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

(defn soma-quadrados [lista]
  (if (empty? lista)
    0
    (apply + (quadrados-rec lista))))

(assert (= (soma-quadrados [1 2 3]) 14))
(assert (= (soma-quadrados []) 0))
