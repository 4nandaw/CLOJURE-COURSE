(defn eh_bissexto [n]
  (if (or (= (mod n 400) 0) (and (= (mod n 4) 0) (not= (mod n 100) 0)))
    (println "é bissexto")
    (println "não é bissexto")))

(println (eh_bissexto(read)))
