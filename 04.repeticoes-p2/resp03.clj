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

(defn quadrados-pares [lista]
  (quadrados-rec (filter even? lista)))


(assert (= (quadrados-pares [1 2 3]) '(4)))
(assert (= (quadrados-pares []) '()))
(assert (= (quadrados-pares [1 3 5]) '()))
