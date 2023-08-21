CREATE SEQUENCE announcement_seq
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE announcement (
  id INTEGER PRIMARY KEY,
  author VARCHAR(255) NOT NULL,
  text VARCHAR(255) NOT NULL,
  votes INTEGER CHECK (votes >= 0),
  email VARCHAR(255) NOT NULL
);

INSERT INTO announcement (id, author, text, votes, email)
VALUES (1, 'Author1', 'Text1', 0, 'author1@example.com');
INSERT INTO announcement (id, author, text, votes, email)
VALUES (2, 'Author2', 'Text2', 0, 'author2@example.com');
