
DROP TABLE IF EXISTS customer;
create table customer (
	id SERIAL PRIMARY KEY,
	first_name TEXT,
	last_name TEXT,
	email TEXT,
	company TEXT,
	status TEXT
);

INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Siobhan','Brazier','sbrazier0@cisco.com','Tagpad','ACTIVE');
INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Heinrick','Genese','hgenese1@ovh.net','Podcat','INACTIVE');
INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Brodie','Stancer','bstancer2@businessinsider.com','Tazz','ACTIVE');
INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Temple','Kleinfeld','tkleinfeld3@over-blog.com','Reallinks','ACTIVE');
INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('June','Downey','jdowney4@smugmug.com','Wordware','INACTIVE');
INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Seamus','Chevin','schevin5@usda.gov','Dynabox','INACTIVE');
INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Dani','Godmer','dgodmer6@about.me','Jaxspan','ACTIVE');
INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Rafi','Sivyer','rsivyer7@cbsnews.com','Gevee','INACTIVE');
INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Dunstan','Powner','dpowner8@ucoz.com','Devbug','INACTIVE');
INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Annissa','Ricioppo','aricioppo9@stumbleupon.com','Tekfly','ACTIVE');
INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Corliss','Sitlinton','csitlintona@seesaa.net','Gabcube','ACTIVE');
INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Hephzibah','Inman','hinmanb@ca.gov','Lajo','ACTIVE');
INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Elspeth','Valentino','evalentinoc@odnoklassniki.ru','Jayo','INACTIVE');
INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Klarrisa','Bizzey','kbizzeyd@ezinearticles.com','Realbuzz','ACTIVE');
INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Lorrayne','Mitford','lmitforde@usa.gov','Twitterbridge','ACTIVE');
INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Ferdinand','Matuska','fmatuskaf@hexun.com','Linkbridge','ACTIVE');
INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Natalya','Wressell','nwressellg@over-blog.com','Tagchat','INACTIVE');
INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Madelene','Goldie','mgoldieh@furl.net','Skinder','INACTIVE');
INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Art','Stepney','astepneyi@arstechnica.com','Linkbuzz','INACTIVE');
INSERT INTO customer(first_name,last_name,email,company,status) VALUES ('Erma','Goodsal','egoodsalj@macromedia.com','Feednation','INACTIVE');

select * from  customer;

