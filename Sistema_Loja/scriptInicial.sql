drop database testeJDBC;
create database testeJDBC;
use  testeJDBC;

create table funcionario (
	id_funcionario int primary key auto_increment,
    nome_funcionario varchar (30),
    sobrenome_funcionario varchar (30),
    login_funcionario varchar (30) unique,
    senha_funcionario varchar (30),
    id_tipo_funcionario int,
    foreign key (id_tipo_funcionario) references tipo_funcionario(id)
);

create table tipo_funcionario(
	id_cargo int primary key auto_increment,
    nome_cargo varchar(40)
);

create table produto(
	id_produto int primary key auto_increment,
    nome_produto varchar(30),
    preco_produto double,
    estoque int
);

insert into usuario (nome_funcionario, sobrenome_funcionario, login_funcionario, senha_funcionario) values
("Wesley","Sales","wesleysales12","senha123"),
("Juan","Sales","juansales20","senha123"),
("Henrique","Sales","henriquesales11","senha123"),
("Maria","Carmo","mariadocarmo","senha123"),
("Inara", "Silva","inaraai","senha123");

insert into tipo_usuario ( nome_cargo) values 
("GERENTE"),
("VENDEDOR");

insert into produto (nome_produto, preco_produto,estoque_produto) values 
("PS5 SLIM",5000,60),
("Samsung Galaxy S24 Ultra",6500,100),
("Notebook Dell Inspiron 3000",3199,200),
("Iphone 15 Pro Max",7399,60),
("Notebook Acer Nitro 5",5500,200);


