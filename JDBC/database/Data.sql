USE springjdbc;

CREATE TABLE student (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    city VARCHAR(100)
);

INSERT INTO student (id, name, city) VALUES
(1, 'Alice', 'New York'),
(2, 'Bob', 'Los Angeles'),
(3, 'Charlie', 'Chicago'),
(4, 'Diana', 'Houston'),
(5, 'Ethan', 'Phoenix');

