(defn create-board []
  (vec (repeat 3 (vec (repeat 3 " ")))))

(defn get-indexes [move]
  (map #(rem (Integer/parseInt %) 10) move))

(defn in-range? [num start end]
  (<= start num end))

(defn numeric? [move]
  (every? #(Character/isDigit %) move))

(defn get-columns [board]
  (apply map vector board))

(defn get-primary-diagonal [board]
  (for [i (range 3)] (get-in board [i i])))

(defn get-secondary-diagonal [board]
  (for [i (range 3)] (get-in board [i (- 3 (inc i))])))

(defn get-all-victory-possibilities [board]
  (concat board
          (get-columns board)
          [(get-primary-diagonal board) (get-secondary-diagonal board)]))

(defn victory [possibility last-player]
  (every? #(= % last-player) possibility))

(defn is-board-full [board]
  (every? #(not= " " %) (apply concat board)))

(defn get-elem [board indexes]
  (get-in board indexes))

(defn show-board [board]
  (println "   ")
  (doseq [i (range 3)]
    (println (str "   " (clojure.string/join " │ " (nth board i))))
    (if (< i 2)
      (println "  ───┼───┼─── ")))
  (println "   "))

(defn get-input [player]
  (loop []
    (let [move (clojure.string/trim (clojure.string/lower-case (read-line)))]
      (cond
        (= move "q!") (do (println "Exiting the game...") "q!")
        (or (empty? move) (not= 2 (count move))) ""
        :else (str (dec (Integer/parseInt (subs move 0 1))) (dec (Integer/parseInt (subs move 1 2))))))))

(defn valid-move? [board indexes]
  (and (every? #(in-range? % 0 2) indexes)
       (= " " (get-in board indexes))))

(defn validate-input [input]
  (and (not (empty? input)) (= 2 (count input)) (numeric? input)))

(defn make-move [board player move]
  (let [new-board (vec (map vec board))]
    (assoc-in new-board move player)))

(defn winner [board player]
  (some #(victory % player) (get-all-victory-possibilities board)))

(defn choose-next-player [current-player]
  (if (= current-player "X") "O" "X"))

(defn choose-next-board [victory is-draw new-board]
  (if (or victory is-draw) (create-board) new-board))

(defn update-scores [victory is-draw scores player]
  (if victory
    (assoc scores player (inc (get scores player)))
    (if is-draw
      (update scores "Draw" (fnil inc 0))
      scores)))

(defn print-winner [player]
  (println (str "\nPlayer " player " is the winner")))

(defn print-draw []
  (println "\nNo one wins"))

(defn print-invalid [msg]
  (println (str "Invalid " msg "\n")))

(defn print-exit []
  (println "TYPE 'q!' TO QUIT AT ANY TIME\n"))

(defn print-scores [scores]
  (println "--- Scores ---")
  (doseq [[player score] scores]
    (println (str player ": " score)))
  (println "--------------"))

(defn wanna-play [victory is-draw]
  (if (or victory is-draw)
    (loop []
      (let [response (.toLowerCase (read-line))]
        (cond
          (= response "y") true
          (= response "n") false
          :else (do (print-invalid "input. Please enter 'y' to play again or 'n' to quit.") (recur)))))
    true))

(defn main []
  (let [board (create-board)
        scores (atom {"X" 0, "O" 0, "Draw" 0})
        player (atom "X")
        playing (atom true)]
    (print-exit)
    (while @playing
      (show-board board)
      (let [move (get-input @player)]
        (if (validate-input move)
          (let [indexes (get-indexes move)]
            (if (valid-move? board indexes)
              (let [new-board (make-move board @player indexes)
                    victory-status (winner new-board @player)
                    is-draw (and (not victory-status) (is-board-full new-board))
                    next-player (choose-next-player @player)
                    scores-updated (update-scores victory-status is-draw @scores @player)]
                (reset! board (choose-next-board victory-status is-draw new-board))
                (when victory-status (show-board new-board) (print-winner @player))
                (when is-draw (show-board new-board) (print-draw))
                (reset! playing (wanna-play victory-status is-draw))
                (reset! player next-player)
                (reset! scores scores-updated))
              (print-invalid "move. Try again")))
          (when (= move "q!") (reset! playing false)))))
  (print-scores scores)))

(main)