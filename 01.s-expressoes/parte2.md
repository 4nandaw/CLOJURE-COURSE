# Parte 2

Nos exercícios abaixo, crie as funções pedidas e crie uma função
`main` de apoio que permita testar a função com algum dado lido
da entrada. Mais adiante, forneceremos testes automáticos para
todas estas questões (tanto para as funções principais, como para
as funções `main` de cada questão).


13. Escreva a função `eh_bissexto` que avalia se um ano passado
    como argumento é ou não bissexto. Lembre que um ano é
    bissexto se for divisível por 400 ou se for divisível por 4 e
    não por 100.

(defn eh_bissexto [n]
  (if (or (= (mod n 400) 0) (and (= (mod n 4) 0) (not= (mod n 100) 0)))
    (println "é bissexto")
    (println "não é bissexto")))

(println (eh_bissexto(read)))



14. Escreva a função `eh_triangulo` que, dadas as três medidas dos
    lados de um triângulo, determina se o triângulo é o ou não
    válido (pesquisa a chamada condição de existência do
    triângulo para saber como resolver o problema).

(defn eh_triangulo [a b c]
  (cond (or (>= a (+ b c)) (>= b (+ a c)) (>= c (+ a b))) "Triângulo inválido" 
        :else "Triângulo inválido"))

(println (eh_triangulo (read) (read) (read)))



15. Escreva a função `tipo_triangulo` que, dadas as três medidas
    dos lados de um triângulo, determina o tipo de triângulo e
    deve retornar um _keyword_ indicando o tipo: `:equilátero`,
    `:isósceles` e `:escaleno`. Se as medidas não corresponderem
    a nenhum dos três tipos, deve retornar `nil`.

(defn tipo_triangulo [a b c]
  (cond (= a b c) :equilátero
        (or (= a b) (= a c) (= b c)) :isósceles
        (not= a b c) :escaleno
        :else "nil"))

(println (tipo_triangulo (read) (read) (read)))



16. Escreva a função `fatorial` que, dado um número inteiro
    N retorna o fatorial de N. Lembre que, por definição, o
    fatorial de 0 e 1 é igual a 1 e que o fatorial de qualquer
    outro inteiro K maior que 1 é igual a K multiplicado pelo
    fatorial de K - 1.

    > Observação. Obviamente, esta função requer repetição que é
    > tema que ainda não vimos (será visto nas próximas aulas).
    > Mas nesta implementação, use recursão direta. Isso tornará
    > o código muito simples e lhe dará um gosto da forma geral
    > de repetições em Lisp e Clojure.


(defn fatorial [n]
  (if (or (= n 1) (= n 0))
    1
    (* n (fatorial (- n 1)))))

(println (fatorial (read)))
