-- Create the table in the public schema
CREATE TABLE announcement (
  id INTEGER DEFAULT nextval('announcement_seq') PRIMARY KEY,
  author VARCHAR(255) NOT NULL,
  text VARCHAR(255) NOT NULL,
  votes INTEGER CHECK (votes >= 0),
  email VARCHAR(255) NOT NULL
);
