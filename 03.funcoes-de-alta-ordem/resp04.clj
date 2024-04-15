(defn somador [op]
  (fn [sq]
    (loop [sq sq tot 0]
      (if (empty? sq)
        tot
        (recur (rest sq) (+ tot (op (first sq))))))))


(def soma-cubos (somador (fn [x] (* x x x))))

(def soma-pares (somador (fn [x] (if (even? x) x 0))))

(def soma-dobros (somador (fn [x] (* 2 x))))

(def soma-triplos (somador (fn [x] (* 3 x))))

(def soma (somador (fn [x] x)))

(def conta (somador (fn [x] (+ 1))))



(assert (= (soma-cubos [1 2 3 4]) 100))
(assert (= (soma-cubos [2 3 4 5]) 224))

(assert (= (soma-pares [1 2 3 4]) 6))
(assert (= (soma-pares [2 3 4 5]) 6))
(assert (= (soma-pares [1 2 3 4 5 6]) 12))
(assert (= (soma-pares [1 3 5]) 0))

(assert (= (soma-dobros [1 2 3 4]) 20))
(assert (= (soma-dobros [2 3 4 5]) 28))

(assert (= (soma-triplos [1 2 3 4]) 30))
(assert (= (soma-triplos [2 3 4 5]) 42))

(assert (= (soma [2 3 4 5]) 14))
(assert (= (conta [2 3 4 5]) 4))
