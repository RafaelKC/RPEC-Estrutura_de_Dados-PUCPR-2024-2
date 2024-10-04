## Flood Fill

### Codigo em java para preencher pixels da mesma cor com uma cor selecionada!!


### demonstracao:

| ![example](docs/demo1.gif) | ![example](docs/demo2.gif) |
|----------------------------|--------------------|


---

# Decodificador de Código Morse com Árvore Binária

Este projeto em Java decodifica sinais em código Morse utilizando a lógica de navegação em uma árvore binária. Cada símbolo do código Morse é representado por movimentos na árvore: `.` move para a esquerda, e `-` move para a direita.

## Estrutura da Árvore Morse

```text
                                início                                                              
                 E                               T                              
         I               A               N               M              
     S       U       R       W       D       K       G       O      
   H   V   F   *   L       P   J   B   X   C   Y   Z   Q   *   *  
  5 4   3       2               1 6               7       8   9 0
```
(obs: `*` reprenseta um node nulo)

Cada nó na árvore representa uma letra ou número conforme o código Morse, onde:
- `.` (ponto) move para a **esquerda**
- `-` (traço) move para a **direita**

