# Api MicroService de envio de email de conclusao de cadastro de Usuário (Java 🚀 com Spring Boot 🍃, RabbitMQ 🐇 e Postgres 🐘)

**Utilizando CloudAMQP para RabbitMQ**

Este projeto utiliza CloudAMQP para gerenciamento de mensagens com RabbitMQ. 

Este é um projeto Java Spring boot, que consiste em uma API que recebe uma message de outra API via RabbitMq, onde após receber a mensagem no caso o cadastro do usuário é enviado um email para a pessoa dizendo que o cadastro foi concluido.

## Configuração

1. Clone o repositório para sua máquina local:

    ```bash
    git clone https://github.com/Thullyoo/user-microservice
    ```

2. Navegue até o diretório do projeto:

    ```bash
    cd user-microservice
    ```

3. Instale as dependências com o maven

4. Coloque suas variáveis necessárias no application.properties, as seguintes variáveis são necessárias:
   - spring.datasource.username
   - spring.datasource.password
   - spring.rabbitmq.addresses
   - spring.mail.username
   - spring.mail.password
  
5. Inicie a aplicação

A aplicação estará rodando em `http://localhost:8082`.
