(defn quadrados [lista] 
  (map (fn [n] (* n n)) lista))

(defn soma-quadrados [lista]
  (if (empty? lista)
    0
    (apply + (quadrados lista))))

(assert (= (soma-quadrados [1 2 3]) 14))
(assert (= (soma-quadrados []) 0))
