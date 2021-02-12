# Estudo em EJB com Jakarta EE
## API Rest com o servidor WildFly

#### 01 - Do Java EE ao Jakarta EE
- Houve uma transição do **Java EE** para o **Jakarta EE**
- Precisamos de um servidor de aplicação para *deployar* nossa aplicação.
- Com a **API** do **Jakarta EE** temos recursos que facilita o desenvolvimento de aplicações corporativas.
 
#### 02 - Apresentando EJB's e o projeto de agendamento de emails
- Em uma aplicação corporativa, utilizamos diversos recursos de infraestrutura, tais como transação, pool de conexões, filas entre outros.
- Para que o desenvolvedor foque nas regras negociais da aplicação e menos com questões de infraestrutura, criou-se um recurso, que é uma especificação do **Jakarta EE**, chamado **EJB (Enterprise Java Beans)**.
- O **EJB** faz com que haja a inversão de controle, passando a responsabilidade de instanciar objetos e fornecimento de serviços para o servidor de aplicação. Para criar um **EJB** basta anotar uma classe com `@Stateless`

#### 03 - Persistência com JPA
  - Usando o **JPA** com **EJB**, vimos que o servidor de aplicação é responsável por nos fornecer uma instância do **EntityManager**.
  - Temos que informar, para o nosso servidor de aplicação, qual banco de dados iremos acessar e essa configuração é feita em um recurso chamado **DataSource**.
  - Uma vez configurado, podemos fazer as operações com o banco de dados, como *inserts*, *deletes*, entre outros.
  
#### 04 - Fazendo requisições ao nosso EJB com JAX-RS
  - Para fazer requisições para nossa aplicação, utiliza-se o protocolo **HTTP**.
  - Para abstrair a complexidade do protocolo, o **Jakarta EE** nos provê um recurso chamado **JAX-RS**.
  - O **JAX-RS** fornecerá um conjunto de classes, interfaces e anotações.
  - Com pequenas configurações, podemos definir o método da requisição, o tipo de formato que a aplicação irá consumir e/ou produzir, qual status a resposta da requisição irá retornar, entre outras facilidades.
  
#### 05 - Agendamento com TimerService