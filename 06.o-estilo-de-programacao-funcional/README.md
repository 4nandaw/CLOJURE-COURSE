# O estilo de programação funcional

1. Em Python, escreva um pequeno aplicativo do jogo da velha,
   usando o estilo funcional. Isso significa que:

   1) todo o código de operações que façam entrada e/ou saída
      estão concentradas em um único procedimento (ou função com
      efeito colateral);

   2) todo o código que processa o domínio do problema (o jogo em
      si, as regras, a atualização do estado geral) está
      exclusivamente em funções puras que não alteram dados
      recebidos através dos argumentos; essas funções apenas
      criam novos dados e os retornam; 

   3) o estado é mantido de forma em estruturas de
      dados simples (listas, vetores, mapas) integrados sob uma
      única referência, digamos `estado`; as funções que precisam
      alterar estado, apenas recebem um estado e os eventos e/ou
      dados necessários para a mudança de estado e retornam um
      novo estado;

   Regras do Jogo. O jogo consiste em várias rodadas do jogo da
   velha (da mesma forma que fizemos em sala de aula). A cada
   rodada, o primeiro jogador é alternado e os números de vitórias
   e de empates são atualizados. A qualquer momento, os jogadores
   devem poder concluir o jogo. Ao concluir, o programa deve
   imprimir a contagem geral de vitórias e empates.

   A interface (UI) do programa deve ser o terminal diretamente.
   Observe que a lógica do jogo deve ignorar completamente como a
   UI funciona. A ideia é que a UI possa ser facilmente
   substituída por outra completamente diferente, mas mantendo a
   funcionalidade central do jogo. Pense, por exemplo, que
   podemos querer usar a lógica com uma UI web ou gráfica.
   Perceba que usando a ideia acima de estado, deve ficar fácil
   atualizar a interface de forma completamente separada.

2. Reescreva o programa feito em Python, em Clojure. Observe que
   será quase uma tradução função a função (pelo menos na parte
   referente à lógica central). Escreva a UI da forma que for
   mais fácil para você.
