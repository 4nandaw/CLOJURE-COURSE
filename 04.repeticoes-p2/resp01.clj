(defn quadrados [lista] 
  (map (fn [n] (* n n)) lista))

(assert (= (quadrados [1 2 3 4]) '(1 4 9 16)))
(assert (= (quadrados []) '()))
(assert (= (quadrados [2]) '(4)))
