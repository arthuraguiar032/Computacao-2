# TuiterLite2
Projeto de clone do Twitter para fins acadêmicos, onde simulo apenas algumas funcionalidades da rede social. Nesse projeto foi implementado algumas melhorias em relação ao [TuiterLite](https://github.com/arthuraguiar032/Computacao-2/tree/master/TuiterLite).

### Funcionalidades implementadas nesse projeto ###
1. Modifique o if inicial do método tuitarAlgo()
  para que uma checked exception específica seja lançada para cada
  uma daquelas situações inesperadas. A única exceção seria se o
  usuário ou o texto fossem nulos, situação essa em que deveremos lançar
  uma IllegalArgumentException (que estende RuntimeException).
  
2. Crie unit tests para verificar que cada uma das checked exceptions acima
  serão corretamente lançadas quando a situação que eles precisam reportar
  acontecer.
  
3. Modifique as classes TuiterLite e Tuite de forma que, ao instanciar um TuiterLite,
  você possa especificar qual o tipo de anexo que será suportado, via tipo genérico,
  fazendo o teste que está quebrando a compilação passar direitinho.
