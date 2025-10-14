create table categoria
(
    id     bigint auto_increment primary key,
    nome   varchar(80) not null,
    status varchar(10) not null
);

INSERT INTO comex.categoria (id, nome, status) VALUES (1, 'Informática', 'ATIVA');
INSERT INTO comex.categoria (id, nome, status) VALUES (2, 'Móveis', 'ATIVA');
INSERT INTO comex.categoria (id, nome, status) VALUES (3, 'Livros', 'ATIVA');
INSERT INTO comex.categoria (id, nome, status) VALUES (4, 'Celulares', 'ATIVA');
INSERT INTO comex.categoria (id, nome, status) VALUES (5, 'Automotiva', 'ATIVA');


create table produto
(
    id                 bigint auto_increment       primary key,
    nome               varchar(80)                 not null,
    quantidade_estoque bigint         default 0    not null,
    preco              decimal(10, 2) default 0.00 not null,
    categoria_id       bigint                      not null,
    constraint fk_categoria_do_produto
        foreign key (categoria_id) references categoria (id)
);

INSERT INTO comex.produto (id, nome, quantidade_estoque, preco, categoria_id) VALUES (1, 'Notebook Samsung', 20, 3523.00, 1);
INSERT INTO comex.produto (id, nome, quantidade_estoque, preco, categoria_id) VALUES (3, 'Sofá 3 lugares', 5, 2500.00, 2);
INSERT INTO comex.produto (id, nome, quantidade_estoque, preco, categoria_id) VALUES (4, 'Clean Architecture', 239, 102.90, 3);
INSERT INTO comex.produto (id, nome, quantidade_estoque, preco, categoria_id) VALUES (5, 'Mesa de jantar 6 lugares', 3, 3668.00, 2);
INSERT INTO comex.produto (id, nome, quantidade_estoque, preco, categoria_id) VALUES (6, 'iPhone 13 Pro', 12, 9176.00, 4);
INSERT INTO comex.produto (id, nome, quantidade_estoque, preco, categoria_id) VALUES (7, 'Monitor Dell 27', 7, 1889.00, 1);
INSERT INTO comex.produto (id, nome, quantidade_estoque, preco, categoria_id) VALUES (8, 'Implementing Domain-Driven Design', 1, 144.07, 3);
INSERT INTO comex.produto (id, nome, quantidade_estoque, preco, categoria_id) VALUES (9, 'Jogo de pneus', 120, 1276.79, 5);
INSERT INTO comex.produto (id, nome, quantidade_estoque, preco, categoria_id) VALUES (10, 'Clean Code', 17, 95.17, 3);
INSERT INTO comex.produto (id, nome, quantidade_estoque, preco, categoria_id) VALUES (11, 'Galaxy S22 Ultra', 30, 8549.10, 4);
INSERT INTO comex.produto (id, nome, quantidade_estoque, preco, categoria_id) VALUES (12, 'Macbook Pro 16', 2, 31752.00, 1);
INSERT INTO comex.produto (id, nome, quantidade_estoque, preco, categoria_id) VALUES (13, 'Refactoring Improving the Design of Existing Code', 8, 173.90, 3);
INSERT INTO comex.produto (id, nome, quantidade_estoque, preco, categoria_id) VALUES (14, 'Cama queen size', 1, 3100.00, 2);
INSERT INTO comex.produto (id, nome, quantidade_estoque, preco, categoria_id) VALUES (15, 'Central multimidia', 5, 711.18, 5);
INSERT INTO comex.produto (id, nome, quantidade_estoque, preco, categoria_id) VALUES (16, 'Building Microservices', 21, 300.28, 3);
INSERT INTO comex.produto (id, nome, quantidade_estoque, preco, categoria_id) VALUES (17, 'Galaxy Tab S8', 40, 5939.10, 1);



create table cliente
(
    id       bigint auto_increment primary key,
    nome     varchar(150) not null,
    cpf      char(11)     not null,
    telefone varchar(20)  not null,
    endereco varchar(255) null,
    cidade   varchar(100) null,
    estado   char(2)      null
);

INSERT INTO comex.cliente (id, nome, cpf, telefone, endereco, cidade, estado) VALUES (1, 'ANA', '25757504072', '6623622343', 'Rua Almir Fonseca', 'Teresina', 'PI');
INSERT INTO comex.cliente (id, nome, cpf, telefone, endereco, cidade, estado) VALUES (2, 'BIA', '13710112060', '8334968457', 'Quadra CRS 512', 'Brasília', 'DF');
INSERT INTO comex.cliente (id, nome, cpf, telefone, endereco, cidade, estado) VALUES (3, 'CAIO', '19483578019', '6925010140', 'Rua Projetada 561', 'Rio Branco', 'AC');
INSERT INTO comex.cliente (id, nome, cpf, telefone, endereco, cidade, estado) VALUES (4, 'DANI', '02187839060', '6931547688', 'Rua Mário Quintana', 'Porto Velho', 'RO');
INSERT INTO comex.cliente (id, nome, cpf, telefone, endereco, cidade, estado) VALUES (5, 'ELI', '86302490057', '6931547688', 'Travessa E', 'Belém', 'PA');
INSERT INTO comex.cliente (id, nome, cpf, telefone, endereco, cidade, estado) VALUES (6, 'GABI', '11894069005', '6931547688', 'Beco das Antulias', 'Rio de Janeiro', 'RJ');


create table pedido
(
    id            bigint auto_increment                                        primary key,
    data          timestamp                                                    not null,
    desconto      decimal(10, 2)                              default 0.00     not null,
    tipo_desconto enum ('FIDELIDADE', 'QUANTIDADE', 'NENHUM') default 'NENHUM' not null,
    cliente_id    bigint                                                       not null,
    constraint fk_cliente_do_pedido
        foreign key (cliente_id) references cliente (id)
);

INSERT INTO comex.pedido (id, data, desconto, tipo_desconto, cliente_id) VALUES (1, '2022-01-01 00:00:00', 0.00, 'NENHUM', 1);
INSERT INTO comex.pedido (id, data, desconto, tipo_desconto, cliente_id) VALUES (2, '2022-01-05 00:00:00', 0.00, 'NENHUM', 1);
INSERT INTO comex.pedido (id, data, desconto, tipo_desconto, cliente_id) VALUES (3, '2022-01-08 00:00:00', 0.00, 'NENHUM', 1);
INSERT INTO comex.pedido (id, data, desconto, tipo_desconto, cliente_id) VALUES (4, '2022-01-06 00:00:00', 0.00, 'NENHUM', 5);
INSERT INTO comex.pedido (id, data, desconto, tipo_desconto, cliente_id) VALUES (5, '2022-01-13 00:00:00', 0.00, 'NENHUM', 1);
INSERT INTO comex.pedido (id, data, desconto, tipo_desconto, cliente_id) VALUES (6, '2022-01-04 00:00:00', 0.00, 'NENHUM', 4);
INSERT INTO comex.pedido (id, data, desconto, tipo_desconto, cliente_id) VALUES (7, '2022-01-10 00:00:00', 0.00, 'NENHUM', 6);
INSERT INTO comex.pedido (id, data, desconto, tipo_desconto, cliente_id) VALUES (8, '2022-01-15 00:00:00', 0.00, 'NENHUM', 2);
INSERT INTO comex.pedido (id, data, desconto, tipo_desconto, cliente_id) VALUES (9, '2022-01-09 00:00:00', 0.00, 'NENHUM', 2);
INSERT INTO comex.pedido (id, data, desconto, tipo_desconto, cliente_id) VALUES (10, '2022-01-14 00:00:00', 0.00, 'NENHUM', 4);
INSERT INTO comex.pedido (id, data, desconto, tipo_desconto, cliente_id) VALUES (11, '2022-01-03 00:00:00', 0.00, 'NENHUM', 3);
INSERT INTO comex.pedido (id, data, desconto, tipo_desconto, cliente_id) VALUES (12, '2022-01-12 00:00:00', 0.00, 'NENHUM', 4);
INSERT INTO comex.pedido (id, data, desconto, tipo_desconto, cliente_id) VALUES (13, '2022-01-07 00:00:00', 0.00, 'NENHUM', 4);
INSERT INTO comex.pedido (id, data, desconto, tipo_desconto, cliente_id) VALUES (14, '2022-01-16 00:00:00', 0.00, 'NENHUM', 3);
INSERT INTO comex.pedido (id, data, desconto, tipo_desconto, cliente_id) VALUES (15, '2022-01-11 00:00:00', 0.00, 'NENHUM', 3);
INSERT INTO comex.pedido (id, data, desconto, tipo_desconto, cliente_id) VALUES (16, '2022-01-02 00:00:00', 0.00, 'NENHUM', 2);
INSERT INTO comex.pedido (id, data, desconto, tipo_desconto, cliente_id) VALUES (17, '2025-10-09 00:00:00', 0.00, 'NENHUM', 5);


create table item_pedido
(
    id             bigint auto_increment
        primary key,
    preco_unitario decimal(10, 2) not null,
    quantidade     int            not null,
    pedido_id      bigint         not null,
    produto_id     bigint         not null,
    constraint fk_pedido_do_item_pedido
        foreign key (pedido_id) references pedido (id),
    constraint fk_produto_do_item_pedido
        foreign key (produto_id) references produto (id)
);

INSERT INTO comex.item_pedido (id, preco_unitario, quantidade, pedido_id, produto_id) VALUES (98, 3523.00, 1, 1, 1);
INSERT INTO comex.item_pedido (id, preco_unitario, quantidade, pedido_id, produto_id) VALUES (99, 2500.00, 1, 2, 3);
INSERT INTO comex.item_pedido (id, preco_unitario, quantidade, pedido_id, produto_id) VALUES (100, 102.90, 2, 3, 4);
INSERT INTO comex.item_pedido (id, preco_unitario, quantidade, pedido_id, produto_id) VALUES (101, 3678.98, 1, 4, 5);
INSERT INTO comex.item_pedido (id, preco_unitario, quantidade, pedido_id, produto_id) VALUES (102, 9176.00, 6, 5, 6);
INSERT INTO comex.item_pedido (id, preco_unitario, quantidade, pedido_id, produto_id) VALUES (103, 1889.00, 3, 6, 7);
INSERT INTO comex.item_pedido (id, preco_unitario, quantidade, pedido_id, produto_id) VALUES (104, 144.07, 3, 7, 8);
INSERT INTO comex.item_pedido (id, preco_unitario, quantidade, pedido_id, produto_id) VALUES (105, 1276.79, 1, 8, 9);
INSERT INTO comex.item_pedido (id, preco_unitario, quantidade, pedido_id, produto_id) VALUES (106, 95.17, 1, 9, 10);
INSERT INTO comex.item_pedido (id, preco_unitario, quantidade, pedido_id, produto_id) VALUES (107, 8549.10, 5, 10, 11);
INSERT INTO comex.item_pedido (id, preco_unitario, quantidade, pedido_id, produto_id) VALUES (108, 31752.00, 1, 11, 12);
INSERT INTO comex.item_pedido (id, preco_unitario, quantidade, pedido_id, produto_id) VALUES (109, 173.90, 1, 12, 13);
INSERT INTO comex.item_pedido (id, preco_unitario, quantidade, pedido_id, produto_id) VALUES (110, 3100.00, 2, 13, 14);
INSERT INTO comex.item_pedido (id, preco_unitario, quantidade, pedido_id, produto_id) VALUES (111, 711.18, 1, 14, 15);
INSERT INTO comex.item_pedido (id, preco_unitario, quantidade, pedido_id, produto_id) VALUES (112, 300.28, 2, 15, 16);
INSERT INTO comex.item_pedido (id, preco_unitario, quantidade, pedido_id, produto_id) VALUES (113, 5939.10, 4, 16, 17);
INSERT INTO comex.item_pedido (id, preco_unitario, quantidade, pedido_id, produto_id) VALUES (114, 8549.10, 10, 17, 11);

