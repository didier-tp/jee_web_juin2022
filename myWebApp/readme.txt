



http://localhost:8080/myWebApp

===============


CREATE TABLE `User`(
`ID` INTEGER PRIMARY KEY AUTO_INCREMENT,
`username` VARCHAR(64),
`password` VARCHAR(64),
`email` VARCHAR(64)
);

INSERT INTO `User`(`id`,username,password,email) VALUES (1,'titi','pwdtiti', 'titi@icioula.fr');
INSERT INTO `User`(`id`,username,password,email) VALUES (2,'toto','pwdtoto', 'toto@icioula.fr');
INSERT INTO `User`(username,password,email) VALUES ('tata','pwdtata', 'tata@icioula.fr');


select * from `User`;


===============
org.h2.Driver
jdbc:h2:~/test
username="sa"
password=""