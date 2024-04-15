(defn conta-rec [n]
  (println n)
  (println (conta-rec (+ 1N n))))

(defn conta []
  (println (conta-rec 0)))

(println (conta))
