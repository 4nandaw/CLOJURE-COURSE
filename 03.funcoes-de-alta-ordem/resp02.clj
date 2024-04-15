; a)
(defn length [sq]
  (if (empty? sq)
    0
    (+ 1 (length (rest sq)))))

(assert (= (length [1 2 3 4 5 6]) 6))
(assert (= (length [])0))
(assert (= (length ["teste"]) 1))


;b)
(defn value_at [i sq]
  (cond
    (empty? sq) nil
    (= i 1) (first sq)
    :else (value_at (- i 1) (rest sq))))

(assert (= (value_at 2 [1 2 3 4]) 2))
(assert (= (value_at 6 [1 2 3 4 5 6 7]) 6))
(assert (= (value_at 3 ["teste1" "teste2" "teste3"]) "teste3"))
(assert (= (value_at 2 []) nil))
(assert (= (value_at 4 [1 2 3]) nil))

;c)
(defn index 
  ([v sq i]
   (if (not (empty? sq))
     (if (= v (first sq))
       i
       (index v (rest sq) (inc i)))
     -1))
  ([v sq] (index v sq 0)))

(assert (= (index 5 [1 8 3]) -1))
(assert (= (index 2 [1 3 2]) 2))
(assert (= (index 1 []) -1))
(assert (= (index 10 [10 1 10]) 0))
(assert (= (index 4 [1 2 3 4]) 3))
