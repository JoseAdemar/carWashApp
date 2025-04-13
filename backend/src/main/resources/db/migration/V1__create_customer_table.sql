-- V1__create_customer_table.sql
CREATE TABLE customer (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    cpf VARCHAR(11) NOT NULL UNIQUE,
    phone_number VARCHAR(15),
    zip_code VARCHAR(10),
    city VARCHAR(255) NOT NULL,
    street VARCHAR(255) NOT NULL,
    state VARCHAR(2) NOT NULL
);