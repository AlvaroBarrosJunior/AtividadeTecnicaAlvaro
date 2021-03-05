## O Projeto
### Descrição
Trata-se de um progeto de gestão de tarefas, onde o usuário do sistema pode cadastrar tarefas vinculando a um colaborador, podendo também editar, excluir, visualizar. O usuário do sistema tem a opção de cadastrar e excluir colaboradores.

### Funcionalidades
#### Colaborador
a) Cadastrar novo colaborador: inserindo o nome e selecionando o botão cadastrar, os colaboradores seão visualizados em uma tabela está incrementada logo abaixo da opção de cadastro.
b) Excluir colaborador: na tabela está disponível a ação de excluir usuário na coluna de ações, na linha do registro a ser excluído. A exclusão só será possível caso o colaborador não estiver viculado a nenhuma tarefa. Caso contrário uma mensagem de alerta será apresentada.

#### Tarefas
a) Tela inicial do sistema: o sistema inicia abrindo a tela de pesquisa de tarefas (index), onde está apresentada a lista das tarefas já cadastradas, podendo ser filtradas por: Número, Título/Descrição, Responsável e Situação.
b) Cadastrar nova tarefa: para realizar o cadastro o usuário deverá acessar a tela de cadastro através do link "Cadastrar Tarefa" que se encontra no menu presente em todas as telas do sistema. Para isso deverá informar o Título, Descrição, Responsável, Prioridade e Deadline. O valor prioridade é uma lista fechada (enum) e o Responsável deverá ser previamente cadastrado como colaborador, o Deadline deve ser informado com a formatação DD/MM/AAAA.
c) Excluir tarefa: a funcionalidade excluir tarefa se encontra na coluna ações da tabela da tela inicial do sistema, o usuário deverá selecionar a tarefa que deseja excluir.
d) Editar tarefa: a funcionalidade editar tarefa se encontra na coluna ações da tabela da tela inicial do sistema, o usuário deverá selecionar a tarefa que deseja editar, sendo assim redirecionado a uma nova tela para edição, sendo necessário modificar os valores que deseja alterar, selecionando após isto o botão salvar.
e) Concluir tarefa: a funcionalidade concluir tarefa se encontra na coluna ações da tabela da tela inicial do sistema, o usuário deverá selecionar a tarefa que deseja concluir, desta forma a Situação da tarefa será atualizada para Concluída altomaticamente.
f) Visualizar tarefa: a funcionalidade visualizar tarefa se encontra na coluna ações da tabela da tela inicial do sistema, o usuário deverá selecionar a tarefa que deseja visualizar, sendo redirecionado a uma nova tela para visualização de todos os dados da tarefa, após caso queira, pode retornar a tela inicial selecionando o botão voltar.


## Instruções para execução em ambiente local
- Deverá ser realizado o import do projeto para o ambiente local.
- Deverá ser criado um banco de dados com o name = "postgres", user = "usuario" e password = "1234", como descrito no arquivo /src/main/java/META-INF/persistece.xml.
- Rodar o script de criação das tabelas do banco que se encontra no diretório db do projeto /db/ScriptCriacaoDB.

## Telas do sistema
-Tela inicial
![Firefox_Screenshot_2021-03-05T00-38-51 425Z](https://user-images.githubusercontent.com/8556553/110050157-19d29500-7d32-11eb-8c0f-7adb78271ffb.png)
-Tela de cadastro de tarefas
![Firefox_Screenshot_2021-03-05T00-35-34 843Z](https://user-images.githubusercontent.com/8556553/110050392-8f3e6580-7d32-11eb-8a04-52aeba4639b4.png)
-Tela de edição de tarefas
![Firefox_Screenshot_2021-03-05T00-37-30 764Z](https://user-images.githubusercontent.com/8556553/110050216-3a025400-7d32-11eb-8acf-3caf9f766aaf.png)
-Tela de visualização de tarefas
![Firefox_Screenshot_2021-03-05T00-43-29 706Z](https://user-images.githubusercontent.com/8556553/110050476-b5fc9c00-7d32-11eb-9011-7025bc173c38.png)
-Tela de colaboradores
![Firefox_Screenshot_2021-03-05T00-26-27 656Z](https://user-images.githubusercontent.com/8556553/110050553-e47a7700-7d32-11eb-8379-d90af9149fae.png)
