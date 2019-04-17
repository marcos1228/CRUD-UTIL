### CRUD-UTIL
O CRUD foi criado no intuito de pratica a programação orientada a objeto, relacionamento de banco de dados e versionamento de versão utilizando o Git/Hub.
![TelaInicio](https://user-images.githubusercontent.com/48805256/56297862-8543f700-6107-11e9-92d0-8223c65dd7db.PNG)

Imagem inicial do crud

## Tecnologia utilizada:
IDE--> Eclipse versão 2018 02

Windowbuilder SWT --> para a construção das telas 

linguagem de programação --> java 8

Git --> Sistema de versão distribuida 

GitHub--> serviço para hospedagem de projeto

UwAmp--> conjuntos de progromas 

MySQL Worben6.3--> modelagem e ralacionamento de banco de dados

## Função do CRUD:
A finalidade do projeto CRUD é; Criar, Ler, Atualizar, Deletar dados através de uma aplicação no banco de dados.

Create --> Cria um pessoa ou contato na base de dado.

Readme --> Ler um dado no banco de dados.

Update --> Atualiza um dado no banco de dados.

Delete --> Excluir um dado na base de dado.

## Descrição dos botons:

![Boton inserir](https://user-images.githubusercontent.com/48805256/56298646-e9b38600-6108-11e9-8722-389a13c5dd34.PNG) Esse tem a função de cadastra uma nova pessoa

![BotonEditar](https://user-images.githubusercontent.com/48805256/56298903-5fb7ed00-6109-11e9-975e-1b67397b63f6.PNG) Esse editar o cadastro de uma pessoa

![BotonExcluir](https://user-images.githubusercontent.com/48805256/56299016-97269980-6109-11e9-84ab-26e29b880a53.PNG) Esse excluir uma pessoa, basta clica na linha logo em seguida no boton excluir.

![BotonverContatos](https://user-images.githubusercontent.com/48805256/56299145-d7861780-6109-11e9-9735-bd08b70ddc74.PNG) Basta clica na linha para selecionar a pessoa e depois no botonVercontatos para ver todos os contatos cadastrado a essa mesma.

## Tela de Cadastro de Pessoa
![BotonInserirPessoa](https://user-images.githubusercontent.com/48805256/56299686-e91bef00-610a-11e9-84f2-b5b2a67dbb3a.PNG)

## Tela de Editar Cadastro de Pessoa

![TelaEditarPessoa](https://user-images.githubusercontent.com/48805256/56300196-e40b6f80-610b-11e9-94dd-df3257e333a4.PNG)

## Tela ver Contatos

![TelaverContatos](https://user-images.githubusercontent.com/48805256/56300369-3c427180-610c-11e9-978a-403320b9eaae.PNG)

## MONTAGEM DO PROJETO
 O projeto foi montado no *padrão DAO* é um padrão de projeto aonde um objeto;
 
 provê uma interface que abstrai o acesso a dados;
 
 Lê grava a partir da origem de dados(banco de dados, arquivo, memória, etc);
 
 E encapsula o acesso aos dados, de forma que as demais classes não precisam saber disso.
 
 ![ImagemEstruturaProjeto](https://user-images.githubusercontent.com/48805256/56300572-93e0dd00-610c-11e9-828e-a889fa33586c.PNG)
 
 *Imagem do Projeto*
 
 ## BANCO DE DADOS
Banco utilizado foi o MaySQL, criado através do MySQLWorbeanch6.3 
nome do banco de dados é agenda, nele foram craido duas Entidades; pessoa e contato.
Na Entidade pessoa, tem-se os atributos; id, nome, endereco, bairro, cpf e sexo e na Entidade contato tem-se os atributos; id, tipo, registro e pessoaid.
O relacionamento das entidades é de 1:n, onde uma pessoa pode te vários contatos e um contato só pode te uma pessoa.

![RelacionamentoDatabase](https://user-images.githubusercontent.com/48805256/56301017-5a5ca180-610d-11e9-8fa5-f490d812c66d.PNG)
*RelacionamentoDatabase*

# Scripts de criação das Entidades

Scripts create table pessoa:

CREATE TABLE `pessoa` (

  `id` int(11) NOT NULL AUTO_INCREMENT,
  
  `nome` varchar(45) DEFAULT NULL,
  
  `endereco` varchar(45) DEFAULT NULL,
  
  `bairro` varchar(45) DEFAULT NULL,
  
  `cpf` varchar(14) DEFAULT NULL,
  
  `sexo` varchar(10) DEFAULT NULL,
  
  PRIMARY KEY (`id`)
  
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

Scripts create table contato:
CREATE TABLE `contato` (

  `id` int(11) NOT NULL AUTO_INCREMENT,
  
  `tipo` varchar(15) DEFAULT NULL,
  
  `registro` varchar(30) DEFAULT NULL,
  
  `pessoaid` int(11) DEFAULT NULL,
  
  PRIMARY KEY (`id`)
  
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8;


# Conclussão
O projeto CRUD foi surgui da necessidade de  estuda e aprimora o conhecimento em java POO e relacionamento de Banco de dados, como a criação dele pode ver na prática a construção de uma aplicação do zero.




 
 










