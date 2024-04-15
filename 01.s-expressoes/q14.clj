(defn eh_triangulo [a b c]
  (cond (or (>= a (+ b c)) (>= b (+ a c)) (>= c (+ a b))) "Triângulo inválido" 
        :else "Triângulo inválido"))

(println (eh_triangulo (read) (read) (read)))
