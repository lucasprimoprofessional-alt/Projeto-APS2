# Pizzaria com Abstract Factory

Projeto em Java (Maven) que simula pedidos em duas pizzarias de estilos diferentes, **Nova York** e **Chicago**. Cada pizzaria usa os próprios ingredientes regionais, e o código garante que os ingredientes de uma região nunca se misturem com os da outra.

O projeto aplica o padrão de projeto **Abstract Factory**, combinado com o **Factory Method**.

---

## Sumário

1. [Explicação básica](#explicação-básica)
2. [Por que escolhemos este projeto](#por-que-escolhemos-este-projeto)
3. [Por que o Abstract Factory é o mais adequado](#por-que-o-abstract-factory-é-o-mais-adequado)
4. [Estrutura do projeto](#estrutura-do-projeto)
5. [Papéis do padrão no código](#papéis-do-padrão-no-código)
6. [Como executar](#como-executar)
7. [Em que outros projetos o padrão poderia ser usado](#em-que-outros-projetos-o-padrão-poderia-ser-usado)

---

## Explicação básica

O fluxo de um pedido funciona assim:

1. O cliente pede uma pizza a uma loja (`LojaDePizza`), informando o sabor.
2. A loja decide qual sabor criar (`criarPizza`). Esta é a parte do **Factory Method**.
3. A pizza recebe a **fábrica de ingredientes** da região da loja.
4. Ao ser preparada, a pizza pede à fábrica a massa, o molho, o queijo e o ingrediente do sabor (calabresa ou frango). Esta é a parte do **Abstract Factory**.
5. A loja assa, fatia e embala a pizza.

Cada região tem uma fábrica própria:

| Ingrediente | Nova York | Chicago |
|---|---|---|
| Massa | Massa fina | Massa grossa |
| Molho | Marinara | Tomate ameixa |
| Queijo | Reggiano | Mussarela |
| Calabresa | Fatiada | Defumada |
| Frango | Desfiado | Em cubos |

Sabores disponíveis: Nova York vende queijo, calabresa e frango. Chicago vende apenas calabresa e frango.

---

## Por que escolhemos este projeto

Escolhemos este projeto porque ele tem tudo a ver com o conteúdo da semana passada, o **Factory Method**. A base do código já era um Factory Method: as lojas (`LojaDePizzaNovaYork` e `LojaDePizzaChicago`) decidem qual `Pizza` instanciar no método `criarPizza()`.

Isso nos permitiu fazer uma evolução natural do que já estudamos:

- **Semana passada (Factory Method):** uma subclasse decide **qual objeto** criar.
- **Esta semana (Abstract Factory):** uma fábrica cria **uma família inteira de objetos relacionados** (massa, molho, queijo e cobertura) que combinam entre si.

Assim, os dois padrões aparecem juntos no mesmo código e dá para ver claramente a diferença e a relação entre eles.

---

## Por que o Abstract Factory é o mais adequado

O problema do projeto é este: cada pizza precisa de **vários ingredientes**, e esses ingredientes **dependem da região**. Não faz sentido uma pizza de Chicago com massa fina e queijo reggiano de Nova York. O Abstract Factory resolve exatamente isso:

- **Garante consistência:** cada fábrica entrega uma família completa de ingredientes da mesma região, sem misturas.
- **Isola as classes concretas:** as pizzas não conhecem `MassaFina`, `QueijoMussarela` etc. Elas só conhecem as interfaces (`Massa`, `Molho`, `Queijo`...) e a `FabricaDeIngredientes`.
- **Facilita a expansão:** para abrir uma loja em outra região (por exemplo, São Paulo), basta criar uma nova fábrica concreta e uma nova loja. Nenhuma pizza precisa ser alterada.
- **Evita condicionais espalhadas:** sem o padrão, cada sabor teria `if (regiao == ...)` para escolher os ingredientes. Com ele, a escolha acontece em um único lugar, na fábrica.
- **Combina com o Factory Method:** a loja continua escolhendo o sabor, e a fábrica escolhe os ingredientes. Cada padrão cuida de uma responsabilidade.

Um ponto a considerar: adicionar um **novo tipo** de ingrediente (por exemplo, `Borda`) exige alterar a interface da fábrica e todas as fábricas concretas. Esse é o custo conhecido do padrão, que compensa quando o que mais muda é a quantidade de famílias (regiões), como é o caso aqui.

---

## Estrutura do projeto

```
src/main/java/org/example/
├── Main.java
├── LojaDePizza.java              (Factory Method: criador abstrato)
├── Pizza.java                    (cliente abstrato)
├── Lojas/
│   ├── LojaDePizzaNovaYork.java
│   └── LojaDePizzaChicago.java
├── Sabores/
│   ├── PizzaDeQueijo.java
│   ├── PizzaDeCalabresa.java
│   └── PizzaDeFrango.java
├── Fabricas/
│   ├── FabricaDeIngredientes.java        (Abstract Factory)
│   ├── FabricaIngredientesNovaYork.java
│   └── FabricaIngredientesChicago.java
└── Ingredientes/
    ├── Massa, Molho, Queijo, Calabresa, Frango   (interfaces)
    ├── MassaFina, MassaGrossa
    ├── MolhoMarinara, MolhoDeTomateAmeixa
    ├── QueijoReggiano, QueijoMussarela
    ├── CalabresaFatiada, CalabresaDefumada
    └── FrangoDesfiado, FrangoEmCubos
```

---

## Papéis do padrão no código

| Papel no padrão | Classe(s) |
|---|---|
| Abstract Factory | `FabricaDeIngredientes` |
| Concrete Factory | `FabricaIngredientesNovaYork`, `FabricaIngredientesChicago` |
| Abstract Product | `Massa`, `Molho`, `Queijo`, `Calabresa`, `Frango` |
| Concrete Product | `MassaFina`, `MolhoMarinara`, `QueijoReggiano`, `CalabresaFatiada`... |
| Client | `Pizza` e os sabores (`PizzaDeQueijo`, `PizzaDeCalabresa`, `PizzaDeFrango`) |
| Factory Method (criador) | `LojaDePizza` e as lojas de cada região |

A regra principal do padrão é respeitada: os sabores usam apenas a fábrica abstrata e os produtos abstratos, sem nunca instanciar uma classe concreta de ingrediente.

---

## Como executar

Requisitos: **JDK 25** (conforme o `pom.xml`) e **Maven**.

```bash
mvn compile
mvn exec:java -Dexec.mainClass="org.example.Main"
```

Se preferir, execute a classe `Main` diretamente pela IDE (IntelliJ, Eclipse etc.).

Exemplo do que o programa mostra:

```
=== LOJA DE NOVA YORK ===
Preparando Pizza de Queijo
Massa: Massa Fina
Molho: Molho Marinara
Queijo: Queijo Reggiano
Assando Pizza de Queijo
...
```

---

## Em que outros projetos o padrão poderia ser usado

O Abstract Factory serve sempre que o sistema precisa criar **famílias de objetos que devem ser usados juntos**, e a família pode variar conforme algum contexto:

- **Interface gráfica multiplataforma:** uma fábrica para Windows, outra para macOS e outra para Linux, cada uma criando botão, janela e menu no estilo do sistema.
- **Temas de aplicativo:** tema claro e tema escuro, cada um criando cores, ícones e fontes combinando entre si.
- **Acesso a banco de dados:** uma fábrica para MySQL e outra para PostgreSQL, criando conexão, comando e leitor de resultados compatíveis entre si.
- **Jogos:** um cenário medieval e um futurista, cada um criando personagens, armas e inimigos do mesmo estilo.
- **Lojas e pagamentos internacionais:** uma fábrica por país, criando imposto, frete e meio de pagamento conforme as regras locais.
- **Montadora de veículos:** uma fábrica por modelo ou linha, criando motor, painel e rodas compatíveis.
- **Geração de documentos:** uma fábrica para PDF e outra para HTML, criando cabeçalho, tabela e rodapé no mesmo formato.

---

## Diagramas

Os diagramas de classes do projeto estão nos arquivos:

- `diagrama_1_factory_method_v2` (lojas, pizzas e sabores)
- `diagrama_2_abstract_factory_v2` (fábricas e ingredientes)

---

## Referência

Padrão descrito em *Head First Design Patterns* (Freeman e Robson), cujo exemplo da pizzaria serviu de base para este projeto.
