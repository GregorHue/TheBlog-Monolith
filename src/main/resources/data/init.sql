INSERT INTO `CATEGORY` (`ID`, `CREATED_AT`, `LAST_UPDATED_AT`, `NAME`) VALUES (1,'2020-02-20T00:00:00',NULL,'All');
INSERT INTO `CATEGORY` (`ID`, `CREATED_AT`, `LAST_UPDATED_AT`, `NAME`) VALUES (2,'2020-02-20T00:00:00',NULL,'Sport');
INSERT INTO `CATEGORY` (`ID`, `CREATED_AT`, `LAST_UPDATED_AT`, `NAME`) VALUES (3,'2020-02-20T00:00:00',NULL,'Holiday');
INSERT INTO `CATEGORY` (`ID`, `CREATED_AT`, `LAST_UPDATED_AT`, `NAME`) VALUES (4,'2020-02-20T00:00:00',NULL,'Fashion');
INSERT INTO `CATEGORY` (`ID`, `CREATED_AT`, `LAST_UPDATED_AT`, `NAME`) VALUES (5,'2020-02-20T00:00:00',NULL,'Hobby');

INSERT INTO `ROLE` (`ID`, `CREATED_AT`, `LAST_UPDATED_AT`, `NAME`) VALUES (1,'2020-02-20T00:00:00',NULL,'ROLE_ADMIN');
INSERT INTO `ROLE` (`ID`, `CREATED_AT`, `LAST_UPDATED_AT`, `NAME`) VALUES (2,'2020-02-20T00:00:00',NULL,'ROLE_USER');

INSERT INTO `USER` (`ID`, `CREATED_AT`, `LAST_UPDATED_AT`, `CITY`, `FIRST_NAME`, `GENDER`, `HOUSE_NUMBER`, `LAST_NAME`, `POSTAL_CODE`, `STREET`, `DELETED_TS`, `EMAIL`, `PASSWORD`, `USERNAME`) VALUES (1,'2020-02-20T00:00:00',NULL,'Kreigerville','Albin','MALE',12,'Smith','CA 53255','Villestreet',null,'smith@example.com','$2a$10$eEI06jrh7DIuzRu9/cItE.JRvpxhbTr4AKA5PiBI5X0h/JQxfZ3wK','user');
INSERT INTO `USER` (`ID`, `CREATED_AT`, `LAST_UPDATED_AT`, `CITY`, `FIRST_NAME`, `GENDER`, `HOUSE_NUMBER`, `LAST_NAME`, `POSTAL_CODE`, `STREET`, `DELETED_TS`, `EMAIL`, `PASSWORD`, `USERNAME`) VALUES (2,'2020-02-20T00:00:00',NULL,'Port Skylafurt','Donald','MALE',43,'Hammes','NY 26566','London Ways',null,'hammes@example.com','$2a$10$NoxbejZGBx60qri8eynPh.evtZqTSggsA5Nuld3Ob3tgpHUcavMJ.','admin');
INSERT INTO `USER` (`ID`, `CREATED_AT`, `LAST_UPDATED_AT`, `CITY`, `FIRST_NAME`, `GENDER`, `HOUSE_NUMBER`, `LAST_NAME`, `POSTAL_CODE`, `STREET`, `DELETED_TS`, `EMAIL`, `PASSWORD`, `USERNAME`) VALUES (3,'2020-02-20T00:00:00',NULL,'Lockmanside','Lacey','FEMALE',212,'Meyer','FL 65466','Ada Ville',null,'meyer@example.com','$2a$10$FQ.eUefDBNOR.UVcyXp6ROVZcFzOofWl26be/mLGhqvSi9hfw5BHu','meyer');
INSERT INTO `USER` (`ID`, `CREATED_AT`, `LAST_UPDATED_AT`, `CITY`, `FIRST_NAME`, `GENDER`, `HOUSE_NUMBER`, `LAST_NAME`, `POSTAL_CODE`, `STREET`, `DELETED_TS`, `EMAIL`, `PASSWORD`, `USERNAME`) VALUES (4,'2020-02-20T00:00:00',NULL,'Emmerichburgh','Antonina','FEMALE',3,'Snyder','TX 48434','Bednar Spurs',null,'snyder@example.com','$2a$10$AAmnmflPFS4yvCv7lTJoIuEDAbFAwkiSCKHcdpa3qZfA.G1OyMYaO','snyder');
INSERT INTO `USER` (`ID`, `CREATED_AT`, `LAST_UPDATED_AT`, `CITY`, `FIRST_NAME`, `GENDER`, `HOUSE_NUMBER`, `LAST_NAME`, `POSTAL_CODE`, `STREET`, `DELETED_TS`, `EMAIL`, `PASSWORD`, `USERNAME`) VALUES (5,'2020-04-25T00:00:00',NULL,'Everett','Iola','FEMALE',367,'Hull','CA 98204','Hollow Road',null,'hull@example.com','$2a$10$TW4BV/HfwqP56veDMrcTE.ZF3dY2Dm00WLG1brJqs1cd0d/vxRlSe','hull');
INSERT INTO `USER` (`ID`, `CREATED_AT`, `LAST_UPDATED_AT`, `CITY`, `FIRST_NAME`, `GENDER`, `HOUSE_NUMBER`, `LAST_NAME`, `POSTAL_CODE`, `STREET`, `DELETED_TS`, `EMAIL`, `PASSWORD`, `USERNAME`) VALUES (6,'2020-04-25T00:00:00',NULL,'Cowan','Robert','MALE',113,'Rogers','NY 31435','Hamilton Road',null,'cowan@example.com','$2a$10$jYOfC/uCwQjv2om7q9cZ1uI1zPNa.xKMWG4sLJ2./AwZnMbjsDI0W','rogers');

INSERT INTO `USER_ROLE` (`USER_ID`, `ROLE_ID`) VALUES (2,1);
INSERT INTO `USER_ROLE` (`USER_ID`, `ROLE_ID`) VALUES (1,2);
INSERT INTO `USER_ROLE` (`USER_ID`, `ROLE_ID`) VALUES (3,2);
INSERT INTO `USER_ROLE` (`USER_ID`, `ROLE_ID`) VALUES (4,2);
INSERT INTO `USER_ROLE` (`USER_ID`, `ROLE_ID`) VALUES (5,2);
INSERT INTO `USER_ROLE` (`USER_ID`, `ROLE_ID`) VALUES (6,2);

INSERT INTO `POST` (`ID`, `CREATED_AT`, `LAST_UPDATED_AT`, `CONTENT`, `LIKES`, `TITLE`, `AUTHOR_ID`, `CATEGORY_ID`) VALUES (1,'2020-02-20T00:07:00','2020-04-16','Donec auctor, risus in fringilla faucibus, dui enim eleifend felis, vitae porta velit risus ultrices ipsum. Mauris molestie tempus tortor nibh, nec pellentesque lorem diam elementum non. Phasellus feugiat, eros quis ornare rutrum, mauris turpis laoreet purus.',2,'Lorem ipsum dolor sit amet',2,5);
INSERT INTO `POST` (`ID`, `CREATED_AT`, `LAST_UPDATED_AT`, `CONTENT`, `LIKES`, `TITLE`, `AUTHOR_ID`, `CATEGORY_ID`) VALUES (2,'2020-02-23T00:08:00',NULL,'In ac neque sapien. Sed auctor dolor ac purus ultricies congue. Proin sollicitudin diam mi, quis placerat turpis condimentum iaculis. Integer pretium vulputate nulla, viverra ultrices nisl sagittis non. Nunc sit amet odio non ipsum.',6,'Sed luctus consectetur',3,2);
INSERT INTO `POST` (`ID`, `CREATED_AT`, `LAST_UPDATED_AT`, `CONTENT`, `LIKES`, `TITLE`, `AUTHOR_ID`, `CATEGORY_ID`) VALUES (3,'2020-02-27T00:09:00',NULL,'Maecenas rhoncus tempor quam euismod auctor. Sed non nibh consectetur, pharetra neque vel, gravida leo. Aliquam erat volutpat. Donec mollis magna libero, a molestie justo varius at. In blandit tristique eleifend. In convallis urna vitae ipsum sodales scelerisque. Phasellus vel.',6,'Phasellus et ultrices turpis',1,3);
INSERT INTO `POST` (`ID`, `CREATED_AT`, `LAST_UPDATED_AT`, `CONTENT`, `LIKES`, `TITLE`, `AUTHOR_ID`, `CATEGORY_ID`) VALUES (4,'2020-02-18T00:10:00',NULL,'Donec viverra leo eu nisl accumsan, non convallis dui congue. Pellentesque cursus libero nec congue volutpat. Vivamus scelerisque ultricies urna, sed vehicula tellus pulvinar a. Sed condimentum lorem et nisl imperdiet placerat. Praesent id pretium massa. Aliquam. ',4,'Aenean sollicitudin quam',4,4);
INSERT INTO `POST` (`ID`, `CREATED_AT`, `LAST_UPDATED_AT`, `CONTENT`, `LIKES`, `TITLE`, `AUTHOR_ID`, `CATEGORY_ID`) VALUES (5,'2020-02-17T00:11:00',NULL,'Integer at velit quis libero pharetra rhoncus. Nullam a convallis enim. Sed a eleifend mauris. Pellentesque quis tempus dui. Nunc quis consectetur dolor. Etiam eget eros ut arcu accumsan gravida ac at.Integer at velit quis libero pharetra rhoncus. Nullam a convallis enim. Sed a eleifend mauris. Pellentesque quis tempus dui. Nunc quis consectetur dolor. Etiam eget eros ut arcu accumsan gravida ac at.',8,'Proin congue felis eget',3,3);
INSERT INTO `POST` (`ID`, `CREATED_AT`, `LAST_UPDATED_AT`, `CONTENT`, `LIKES`, `TITLE`, `AUTHOR_ID`, `CATEGORY_ID`) VALUES (6,'2020-02-28T00:12:00',NULL,'Duis id gravida augue, eget tempor ex. Curabitur iaculis vel urna sit amet dictum. Maecenas id vestibulum ipsum. Quisque auctor ultricies ipsum ullamcorper efficitur. Cras eget cursus nunc. In hac habitasse platea dictumst. ',5,'Curabitur tempus tincidunt dui',2,2);

INSERT INTO `COMMENT` (`ID`, `CREATED_AT`, `LAST_UPDATED_AT`, `CONTENT`, `LIKES`, `AUTHOR_ID`, `POST_ID`) VALUES (1,'2020-02-20 06:00:00',NULL,'Aliquam sed ipsum augue. Donec hendrerit, metus vitae volutpat elementum, odio lacus lobortis lectus, id mollis nisi leo id nisi. Donec pharetra tincidunt vulputate. Vestibulum eget arcu nulla. Proin. ',3,3,2);
INSERT INTO `COMMENT` (`ID`, `CREATED_AT`, `LAST_UPDATED_AT`, `CONTENT`, `LIKES`, `AUTHOR_ID`, `POST_ID`) VALUES (2,'2020-03-03 07:00:00',NULL,'Maecenas porta velit vitae sodales viverra. Cras egestas egestas ipsum, a tincidunt leo vehicula quis. Mauris non urna dui.',8,3,6);
INSERT INTO `COMMENT` (`ID`, `CREATED_AT`, `LAST_UPDATED_AT`, `CONTENT`, `LIKES`, `AUTHOR_ID`, `POST_ID`) VALUES (3,'2020-03-04 08:00:00',NULL,'Nulla commodo tempor leo id convallis. In cursus at leo in tincidunt. Nam vulputate pretium nisl, pretium tincidunt enim porttitor vitae. Sed eget erat et augue viverra. ',5,4,6);
INSERT INTO `COMMENT` (`ID`, `CREATED_AT`, `LAST_UPDATED_AT`, `CONTENT`, `LIKES`, `AUTHOR_ID`, `POST_ID`) VALUES (4,'2020-02-20 09:00:00',NULL,'Curabitur eleifend quam id vulputate facilisis. Etiam consectetur neque faucibus, tristique est imperdiet, convallis sapien. Nulla eu tincidunt ligula. Mauris vel lacus odio. Phasellus in gravida ex. Mauris.',3,4,4);
INSERT INTO `COMMENT` (`ID`, `CREATED_AT`, `LAST_UPDATED_AT`, `CONTENT`, `LIKES`, `AUTHOR_ID`, `POST_ID`) VALUES (5,'2020-02-20 10:00:00',NULL,'Duis tincidunt mi at tortor auctor, quis dignissim arcu viverra. Sed ultricies bibendum sem, sit amet fermentum nulla dapibus et. Donec.',6,4,4);
INSERT INTO `COMMENT` (`ID`, `CREATED_AT`, `LAST_UPDATED_AT`, `CONTENT`, `LIKES`, `AUTHOR_ID`, `POST_ID`) VALUES (6,'2020-02-23 11:00:00',NULL,'Cras ullamcorper sit amet ex in semper. Sed gravida lacus quis nibh volutpat lacinia et vel enim. Aenean a ligula arcu. Lorem ipsum dolor sit.',2,3,2);
INSERT INTO `COMMENT` (`ID`, `CREATED_AT`, `LAST_UPDATED_AT`, `CONTENT`, `LIKES`, `AUTHOR_ID`, `POST_ID`) VALUES (7,'2020-02-20 12:00:00',NULL,'Fusce tortor sapien, convallis sed justo rutrum, tristique maximus diam. In eu nisi rutrum, efficitur tellus ac, suscipit turpis. Etiam dapibus sem nec vehicula lobortis. Sed ultrices.',7,1,1);
INSERT INTO `COMMENT` (`ID`, `CREATED_AT`, `LAST_UPDATED_AT`, `CONTENT`, `LIKES`, `AUTHOR_ID`, `POST_ID`) VALUES (8,'2020-02-20 13:00:00',NULL,'Aliquam efficitur risus id ipsum tincidunt lacinia. In vitae libero sed metus sollicitudin tempus eu eget libero. Sed iaculis tellus sit amet nulla.',4,4,3);
INSERT INTO `COMMENT` (`ID`, `CREATED_AT`, `LAST_UPDATED_AT`, `CONTENT`, `LIKES`, `AUTHOR_ID`, `POST_ID`) VALUES (9,'2020-02-20 14:00:00',NULL,'Fusce enim ipsum, posuere sed enim porttitor, consectetur posuere purus. Donec ut molestie lorem, a lobortis velit. Praesent hendrerit consectetur rhoncus. Curabitur vel condimentum.',1,3,5);
