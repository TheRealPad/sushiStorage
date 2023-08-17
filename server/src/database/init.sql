DROP DATABASE IF EXISTS SushiStorage;
CREATE DATABASE SushiStorage;

USE SushiStorage;

CREATE TABLE Sushi (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    imagePath VARCHAR(255) NOT NULL,
    ingredientList VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);