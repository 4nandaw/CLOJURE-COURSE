(defn quadrados-rec-aux [lista lista-quadrados]
  (let [f (first lista)
        r (rest lista)]
    (if (empty? r)
      (cons (* f f) lista-quadrados)
      (quadrados-rec-aux r (cons (* f f) lista-quadrados)))))

(defn quadrados-rec [lista]
  (if (empty? lista)
    '()
    (reverse (quadrados-rec-aux lista '()))))

(assert (= (quadrados-rec [1 2 3 4]) '(1 4 9 16)))
(assert (= (quadrados-rec []) '()))
(assert (= (quadrados-rec [3]) '(9)))
