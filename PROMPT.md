# Registro de Prompts Utilizados (Anexo 2)

## Entrada 1
- **Data da solicitação:** 2026-11-19 20:15
- **Usuário solicitante:** Emilly Marqueti Dias e Isabele Laranjo Souto
- **Prompt utilizado:** Estamos desenvolvendo uma aplicação Spring Boot para gerenciamento de jogos de videogame e plataformas com banco H2 em memória e Spring Data JPA. Pode nos ajudar a revisar nossas entidades (JogoEntity e PlataformaEntity), DTOs com getters/setters, services e controllers REST para garantir que estamos seguindo o padrão de acordo com o projeto dados-pessoais e os conteúdos vistos na aula?
- **Origem dos requisitos:**
  - **Descritos pelo usuário no prompt:** Arquitetura em camadas com Spring Boot (Entity, DTO com getters/setters, Service e RestController), banco de dados H2 em memória, Spring Data JPA, gerenciamento de jogos e plataformas seguindo o padrão do projeto de referência `dados-pessoais` e os conteúdos vistos em aula.
  - **Extraídos apenas do PDF da avaliação:** Nomes específicos das tabelas no banco (`TB_JOGOS` e `TB_PLATAFORMAS`), regras de validação específicas dos campos (ano de lançamento mínimo `1950`, obrigatoriedade dos campos) e códigos/mensagens padronizadas de retorno HTTP.

---

## Entrada 2
- **Data da solicitação:** 2026-11-22 19:40
- **Usuário solicitante:** Emilly Marqueti Dias e Isabele Laranjo Souto
- **Prompt utilizado:** Criamos a estrutura das páginas HTML (index.html, form-plataforma.html e form-jogo.html) e o CSS básico, como podemos conectar os formulários e a listagem aos endpoints REST /api/jogos e /api/plataformas usando apenas JavaScript puro (fetch API com async/await) mantendo o código simples e legível para apresentar? NOs auxilie também a evoluir mais nosso CSS, ele está com algumas coisas desalinhadas, nos ajude a alinhar e explique como fazer, não utilize nada que não esteja dentro do conteúdo que vimos em aula, respeite a linguagem que estamos utilizando e preserve a lógica.
- **Origem dos requisitos:**
  - **Descritos pelo usuário no prompt:** Conexão das páginas `index.html`, `form-plataforma.html` e `form-jogo.html` com os endpoints `/api/jogos` e `/api/plataformas` usando apenas JavaScript puro (`fetch` API com `async/await`), melhoria no alinhamento do CSS utilizando exclusivamente recursos vistos em aula e preservação da lógica já criada pela dupla.
  - **Extraídos apenas do PDF da avaliação:** Exibição da etiqueta visual de item indisponível na listagem, comportamento do modal de confirmação de exclusão (botões SIM/NÃO), mensagens de feedback via parâmetro de URL e inclusão do rodapé obrigatório com identificação das alunas, turma e declaração de uso de IA.

---

## Entrada 3
- **Data da solicitação:** 2026-11-24 21:10
- **Usuário solicitante:** Emilly Marqueti Dias e Isabele Laranjo Souto
- **Prompt utilizado:** Como podemos criar um controlador REST simples em Spring Boot (PromptController.java) que leia o arquivo prompt.md na raiz do projeto e mostre seu conteúdo em um texto simples na rota GET/PROMPT?
- **Origem dos requisitos:**
  - **Descritos pelo usuário no prompt:** Criação da classe `PromptController.java` em Spring Boot expondo a rota `GET /prompt` para ler o arquivo `PROMPT.md` na raiz do projeto e retornar seu conteúdo em texto simples.
  - **Extraídos apenas do PDF da avaliação:** Localização obrigatória no pacote base da aplicação, declaração de constante `String` fixa contendo data/hora no formato `AAAA-MM-DD HH:mm` e identificação do agente/modelo de IA, retorno em UTF-8, fallback devolvendo o texto da constante caso o arquivo não exista e proibição de qualquer comentário no código-fonte da classe.