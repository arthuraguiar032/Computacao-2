# Album de Figurinhas

### Funcionalides implementadas nesse projeto ###
1. Fazer todos os unit tests passarem.

2. Criar uma interface `Colecionavel` com os métodos:
      ```java
      Image getImagem()
      int getPosicao()
      ```

3. Criar uma classe `Selo` que possua os métodos públicos:
      ```java
      float getValorNominal()
      String getPais()
      ```
   e que implemente a interface `Colecionavel`.

4. Adapte a classe `Album` para poder colecionar qualquer coisa que seja `Colecionavel`.

5. Adapte novamente a classe `Album` (e outras classes que precisarem acompanhar
   as mudanças), fazendo com que cada instância de `Album`
   possa colecionar, se quisermos, um ÚNICO tipo de objeto colecionável.

6. Adicionar um unit test (um único método) onde você terá duas instâncias de `Album`:
   uma para Selos e outra para Figurinhas, fazendo algum teste muito básico
   com cada instância dessas.
