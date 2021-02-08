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