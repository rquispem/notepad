CREATE TABLE note (
    id INTEGER NOT NULL IDENTITY,
	title VARCHAR(255) NOT NULL, 
	content VARCHAR(255) NOT NULL, 
	PRIMARY KEY (id)
);

INSERT INTO note (title, content) VALUES ('What is Cassandra?', 'Cassandra is a NoSQL database that belongs to the Column Family NoSQL database category.');
