(defn conta
  ([] (println (conta 0)))
  ([n] (println n)
   (println (conta (+ 1N n)))))

(conta (read))
(println (conta))
