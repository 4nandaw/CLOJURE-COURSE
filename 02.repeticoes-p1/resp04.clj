(defn conta []
  (loop [n 0]
    (println n)
    (recur (+ 1N n))))

(println (conta))
