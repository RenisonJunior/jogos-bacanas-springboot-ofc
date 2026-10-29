JOGOS BACANAS - PROJETO SPRING BOOT

TECNOLOGIAS
- Java 17 ou superior
- Spring Boot
- Spring Web
- Thymeleaf
- Spring Data JPA
- H2 Database
- Bean Validation
- Maven

COMO ABRIR
1. Extraia o arquivo ZIP.
2. Abra a pasta jogos-bacanas no IntelliJ IDEA, Eclipse ou outra IDE com suporte a Maven.
3. Aguarde a IDE importar as dependências do arquivo pom.xml.
4. Execute a classe JogosBacanasApplication.java.
5. Acesse http://localhost:8080 no navegador.

PÁGINAS
- Início: http://localhost:8080/
- Jogos: http://localhost:8080/jogos
- Sobre: http://localhost:8080/sobre
- Gêneros: http://localhost:8080/generos
- Sugestões: http://localhost:8080/sugestoes

BANCO DE DADOS
O banco H2 cria e mantém o arquivo jogosbacanas-db na pasta em que a aplicação é executada. As seis tabelas são:
1. usuarios
2. generos
3. desenvolvedoras
4. plataformas
5. jogos
6. sugestoes

Para abrir o console H2, acesse http://localhost:8080/h2-console e use:
JDBC URL: jdbc:h2:file:./jogosbacanas-db
User Name: sa
Password: deixe em branco

RECURSOS DE SUGESTÕES
- Inserir uma sugestão.
- Ver os detalhes de uma sugestão cadastrada.
- Editar os dados e o status da análise.
- Excluir uma sugestão.
- Validar os campos obrigatórios e o formato do e-mail.

Os jogos iniciais e seus dados são adicionados automaticamente na primeira execução. As imagens permanecem apontando para os endereços web presentes no HTML enviado.
