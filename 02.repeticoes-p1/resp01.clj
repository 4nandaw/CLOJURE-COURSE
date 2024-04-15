(defn msg-rec [s]
  (println s)
  (msg-rec s))

(msg-rec (read))
