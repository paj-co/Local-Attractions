INSERT INTO local_attractions.businesses (id, email, name, nip, password, regon) VALUES (1, 'pomiechowek@kajaki.pl', 'ANMAR Kajaki Pomiechówek', '6065022504', '$2a$10$zNIw6uU1jQzjH6KJ9EtZaeqRQldsuh/XzH56Eyzw.d9am7wJpfEfO', '280377064');
INSERT INTO local_attractions.categories (id, description, name) VALUES (1, 'Kajaki rzeczne, jeziorne, morskie', 'Kajaki');
INSERT INTO local_attractions.news_feed (id, active, description, ends, name, starts, service_id) VALUES (1, true, 'Z radością ogłaszamy, iż 1 maja 2019 rozpoczynamy sezon!
Zapraszamy na spływy już od środy!', '2019-05-30 23:59:59.106000', 'Początek sezonu', '2019-05-01 15:21:01.403000', 1);
INSERT INTO local_attractions.news_feed (id, active, description, ends, name, starts, service_id) VALUES (2, true, 'Wszystko wskazuje na to, że lipiec będzie wyjątkowo piękny! Jeśli nie byłeś pewny pogody już się nie zastanawiaj! Chodź na kajak!', '2019-07-31 23:59:59.508000', 'Lato w kajaku!', '2019-07-01 00:00:00.564000', 1);
INSERT INTO local_attractions.news_feed (id, active, description, ends, name, starts, service_id) VALUES (3, true, 'W dniach 19 - 21 lipca zapraszamy na Piknnik Rycerski!
- pokazy walk
- pokaz rzemiosła
- średniowieczne wypieki', '2019-07-21 23:59:59.822000', 'Piknik Rycerski', '2019-07-19 17:00:00.953000', 1);
INSERT INTO local_attractions.news_feed (id, active, description, ends, name, starts, service_id) VALUES (4, true, 'Świętuj znami zakończenie lata!
- zamek dmuchaniec
- malowanie buziek
- gry i zabawy z animatorami', '2019-08-28 23:59:59.816000', 'Zakończenie lata!', '2019-07-26 15:00:00.444000', 1);
INSERT INTO local_attractions.offers (id, active, description, ends, name, starts, service_id) VALUES (1, true, 'Dla grup powyżej 5 osób zniżka 15%!', '2019-07-31 23:59:59.832000', 'Zniżka dla grup powyżej 5 osób!', '2019-07-01 00:00:00.738000', 1);
INSERT INTO local_attractions.offers (id, active, description, ends, name, starts, service_id) VALUES (2, false, 'Od poniedziałku do piątku zniżka 10%
Wpadnij do nas w ciągu tygodnia i ciesz się wspaniałym wypoczynkiem 10% taniej niezależnie od liczby osób!', '2019-08-31 23:59:59.895000', 'Od poniedziałku do piątku zniżka 10%', '2019-08-01 00:00:00.002000', 1);
INSERT INTO local_attractions.services (id, apartmentNumber, closeHourFriday, closeHourMonday, closeHourSaturday, closeHourSunday, closeHourThursday, closeHourTuesday, closeHourWednesday, description, email, houseNumber, informations, mainPicture, name, openHourFriday, openHourMonday, openHourSaturday, openHourSunday, openHourThursday, openHourTuesday, openHourWednesday, phone, street, zipCode, business_id, commune_id, district_id, locality_id, province_id) VALUES (1, null, '20:00:00', '20:00:00', '22:00:00', '22:00:00', '20:00:00', '20:00:00', '20:00:00', 'Organizujemy spływy kajakowe na rzece Wkrze', 'pomiechowek@kajaki.pl', 1, 'Ala ma kota:
- kot ma alę', 0xACED00057372000C6A6176612E696F2E46696C65042DA4450E0DE4FF0300014C0004706174687400124C6A6176612F6C616E672F537472696E673B78707400007702002F78, 'ANMAR Kajaki Pomiechówek', '08:00:00', '08:00:00', '08:00:00', '08:00:00', '08:00:00', '08:00:00', '08:00:00', '789445612', 'Wojska Polskiego', '05-180', 1, null, null, null, null);
INSERT INTO local_attractions.services (id, apartmentNumber, closeHourFriday, closeHourMonday, closeHourSaturday, closeHourSunday, closeHourThursday, closeHourTuesday, closeHourWednesday, description, email, houseNumber, informations, mainPicture, name, openHourFriday, openHourMonday, openHourSaturday, openHourSunday, openHourThursday, openHourTuesday, openHourWednesday, phone, street, zipCode, business_id, commune_id, district_id, locality_id, province_id) VALUES (2, null, '20:00:00', '20:00:00', '20:00:00', '20:00:00', '20:00:00', '20:00:00', '20:00:00', 'Pole namiotowe wraz z możliwością rozpalenia ogniska, łazienkami', 'pomiechowek@kajaki.pl', 1, 'Pole namiotowe wraz z możliwością rozpalenia ogniska.
Oferujemy:
- schludne łazienki / toalety
- dostęp do prądu (własny przedłużacz)', 0xACED00057372000C6A6176612E696F2E46696C65042DA4450E0DE4FF0300014C0004706174687400124C6A6176612F6C616E672F537472696E673B78707400007702002F78, 'Pole namiotowe', '08:00:00', '08:00:00', '08:00:00', '08:00:00', '08:00:00', '08:00:00', '08:00:00', '789445612', 'Wojska Polskiego', '05-180', 1, null, null, null, null);
INSERT INTO local_attractions.services_categories (category_id, service_id) VALUES (1, 1);
INSERT INTO local_attractions.tags (id, name, service_id) VALUES (1, 'kajak', 1);
INSERT INTO local_attractions.tags (id, name, service_id) VALUES (2, 'kajaki', 1);
INSERT INTO local_attractions.tags (id, name, service_id) VALUES (3, 'spływ', 1);
INSERT INTO local_attractions.tags (id, name, service_id) VALUES (4, 'spływy', 1);
INSERT INTO local_attractions.tags (id, name, service_id) VALUES (5, 'rzeka', 1);
INSERT INTO local_attractions.tags (id, name, service_id) VALUES (6, 'aktywny', 1);
INSERT INTO local_attractions.tags (id, name, service_id) VALUES (7, 'wypoczynek', 1);
INSERT INTO local_attractions.tags (id, name, service_id) VALUES (8, 'aktywny wypoczynek', 1);