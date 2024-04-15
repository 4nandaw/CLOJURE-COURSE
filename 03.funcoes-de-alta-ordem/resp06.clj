(defn fahr-celsius [sq]
  (map (fn [n] (format "%.1f" (/ (- n 32) 1.8))) sq))

(assert (= (fahr-celsius [30]) '("-1.1")))
(assert (= (fahr-celsius [86 32]) '("30.0" "0.0")))
(assert (= (fahr-celsius []) '()))
