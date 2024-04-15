; Exemplo 01
;
; O código abaixo demonstra como escrever uma função
; com múltiplas aridades. Neste caso, temos duas: i) 
; com um único parâmetro (apenas `[a]`); e ii) com dois
; parâmetros (sendo `[a b]`. Observe que cada aridade,
; incluindo um vetor com os parâmetros e o corpo da função,
; é colocada em uma s-expressão própria. Você pode ter
; quantas aridades desejar seguindo o mesmo modelo. 

(defn soma-ou-dobra 
  ([a] (* 2 a))
  ([a b] (+ a b)))
  
(println (soma-ou-dobra 14))
(println (soma-ou-dobra 14 0))
