(defn soma-quadrados-de-pares [sq]
 (reduce +
    (map (fn [x] (* x x))
        (filter even? sq))))


(assert (= (soma-quadrados-de-pares []) 0))
(assert (= (soma-quadrados-de-pares [1 2 3 4]) 20))
(assert (= (soma-quadrados-de-pares [4]) 16))
