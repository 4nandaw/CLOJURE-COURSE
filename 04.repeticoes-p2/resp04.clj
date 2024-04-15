(defn quadrados-pares-rec-aux [lista lista-quadrados]
  (let [f (first lista)
        r (rest lista)]
    (if (empty? r)
      (if (even? f)
        (cons (* f f) lista-quadrados)
        lista-quadrados)
      (if (even? f)
        (quadrados-pares-rec-aux r (cons (* f f) lista-quadrados))
        (quadrados-pares-rec-aux r lista-quadrados)))))


(defn quadrados-pares-rec [lista]
  (if (empty? lista)
    '()
    (reverse (quadrados-pares-rec-aux lista '()))))

(assert (= (quadrados-pares-rec [1 2 3 4]) '(4 16)))
(assert (= (quadrados-pares-rec []) '()))
(assert (= (quadrados-pares-rec [2 3]) '(4)))
(assert (= (quadrados-pares-rec [1 3 5]) '()))
