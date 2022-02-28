CREATE DATABASE somosbooking;
CREATE TABLE article (
    idarticle INT PRIMARY KEY AUTO_INCREMENT,
    namearticle VARCHAR (50) NOT NULL,
    descriptionarticle VARCHAR (500) NOT NULL,
    photoarticle VARCHAR (500) NOT NULL,
    price DOUBLE NOT NULL,
    stock INT NOT NULL,
    size enum('Chica','Mediana','Grande', 'Extra Grande') NULL,
    idColor INT NULL,
    item enum('clothe','music', 'hat') NOT NULL
);
INSERT INTO `somosbooking`.`article` (`NameArticle`, `DescriptionArticle`, `PhotoArticle`, `Price`, `Stock`, `Size`, `IdColor`, `Item`) VALUES ('Hoodie Sage Skylight', 'lorem', 'https://res.cloudinary.com/duymgcfax/image/upload/v1645323135/zh4cahedpx3refi5n0in.png', '99.99', '3', 'Mediana', '2', 'clothe');
INSERT INTO `somosbooking`.`article` (`NameArticle`, `DescriptionArticle`, `PhotoArticle`, `Price`, `Stock`, `Size`, `IdColor`, `Item`) VALUES ('Camisa Sage Skylight', 'lorem', 'https://res.cloudinary.com/duymgcfax/image/upload/v1645323120/rasm1ydy8krndizc682n.png', '59.99', '3', 'Chica', '2', 'clothe');
INSERT INTO `somosbooking`.`article` (`NameArticle`, `DescriptionArticle`, `PhotoArticle`, `Price`, `Stock`, `Size`, `IdColor`, `Item`) VALUES ('CD The Black Hardies', 'lorem', 'https://res.cloudinary.com/duymgcfax/image/upload/v1645323129/jlcdnkjux4kps48hzi0l.png', '99.99', '3', null, null, 'music');
INSERT INTO `somosbooking`.`article` (`NameArticle`, `DescriptionArticle`, `PhotoArticle`, `Price`, `Stock`, `Size`, `IdColor`, `Item`) VALUES ('Bucket Hat The Black Hardies', 'lorem', 'https://res.cloudinary.com/duymgcfax/image/upload/v1645323118/bhwghikxg518bxfeucbw.png', '39.99', '3', null, '2', 'hat');

SELECT * FROM somosbooking.article;