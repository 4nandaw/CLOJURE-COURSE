(require '[clojure.string :as str])

(def vogais #{"a" "e" "i" "o" "u" "A" "E" "I" "O" "U"})

(defn aux-ini-vogais [string]
  (let [ini (first string)]
    (contains? #{"a" "e" "i" "o" "u" "A" "E" "I" "O" "U"} (str ini))))

(defn ini-vogais [sq]
  (map str/lower-case (filter aux-ini-vogais sq)))


(assert (= (ini-vogais ["UFCG" "CC"]) '("ufcg")))
(assert (= (ini-vogais ["Eae" "Iate" "Opera"]) '("eae" "iate" "opera")))
(assert (= (ini-vogais ["Texto" "Teste"]) '()))
(assert (= (ini-vogais []) '()))
