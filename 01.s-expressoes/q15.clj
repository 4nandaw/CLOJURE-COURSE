(defn tipo_triangulo [a b c]
  (cond (= a b c) :equilátero
        (or (= a b) (= a c) (= b c)) :isósceles
        (not= a b c) :escaleno
        :else "nil"))

(println (tipo_triangulo (read) (read) (read)))
