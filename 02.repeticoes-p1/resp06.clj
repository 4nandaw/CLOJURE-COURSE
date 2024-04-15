(defn conta [i]
  (doseq [n (range i)]
    (println n)))

(conta (read))
