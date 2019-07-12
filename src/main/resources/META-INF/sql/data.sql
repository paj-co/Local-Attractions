INSERT INTO local_attractions.businesses (id, email, name, nip, password, regon) VALUES (1, 'pomiechowek@kajaki.pl', 'Firma ANMAR', '6065022504', '$2a$10$VX3dgCiOahO/4i/ksgKXAuKu9pQyTYlm6gwSWFURZbF8PheICzST2', '280377064');
INSERT INTO local_attractions.businesses (id, email, name, nip, password, regon) VALUES (2, 'test@test.pl', 'Test', '8896040322', '$2a$10$Zae/XIPbB9Upw3dAaNcEOuBPjapxqlt7WZSVT7kZ1OeByx.Xovjde', '142305471');
INSERT INTO local_attractions.businesses (id, email, name, nip, password, regon) VALUES (12, 'test5@test.org', 'Test 5', '5327205979', '$2a$10$No4F6Uj0V3yg7JEXKkX2C.OK1Uw43rr6lrKQSRZGuWY71TU.2xOPq', '203927062');

INSERT INTO local_attractions.services (id, apartmentNumber, closeHourFriday, closeHourMonday, closeHourSaturday, closeHourSunday, closeHourThursday, closeHourTuesday, closeHourWednesday, description, email, houseNumber, informations, mainImage, name, openHourFriday, openHourMonday, openHourSaturday, openHourSunday, openHourThursday, openHourTuesday, openHourWednesday, phone, street, zipCode, business_id, commune_id, district_id, locality_id, province_id) VALUES (1, null, '20:00:00', '20:00:00', '22:00:00', '22:00:00', '20:00:00', '20:00:00', '20:00:00', 'Organizujemy spływy kajakowe na rzece Wkrze', 'pomiechowek@kajaki.pl', 10, 'Wypożyczalnia kajaków ANMAR', null, 'Spływy kajakowe', '09:00:00', '09:00:00', '09:00:00', '09:00:00', '09:00:00', '09:00:00', '09:00:00', '333-444-555', 'Wojska Polskiego', '05-180', 1, null, null, null, null);
INSERT INTO local_attractions.services (id, apartmentNumber, closeHourFriday, closeHourMonday, closeHourSaturday, closeHourSunday, closeHourThursday, closeHourTuesday, closeHourWednesday, description, email, houseNumber, informations, mainImage, name, openHourFriday, openHourMonday, openHourSaturday, openHourSunday, openHourThursday, openHourTuesday, openHourWednesday, phone, street, zipCode, business_id, commune_id, district_id, locality_id, province_id) VALUES (2, null, '20:00:00', '20:00:00', '22:00:00', '22:00:00', '20:00:00', '20:00:00', '20:00:00', 'Pole namiotowe przy rzece Wkrze', 'pomiechowek@kajaki.pl', 10, 'Pole namiotowe', null, 'Pole namiotowe', '09:00:00', '09:00:00', '09:00:00', '09:00:00', '09:00:00', '09:00:00', '09:00:00', '333-444-555', 'Wojska Polskiego', '05-180', 1, null, null, null, null);

INSERT INTO local_attractions.main_category (id, name) VALUES (1, 'Typ');
INSERT INTO local_attractions.main_category (id, name) VALUES (2, 'Restauracje');
INSERT INTO local_attractions.main_category (id, name) VALUES (3, 'Sportowe');
INSERT INTO local_attractions.main_category (id, name) VALUES (4, 'Nocleg');
INSERT INTO local_attractions.main_category (id, name) VALUES (5, 'Historia');
INSERT INTO local_attractions.main_category (id, name) VALUES (6, 'Moto');

INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (1, 'spływ kajkowy', 'Spływ kajkowy', 3);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (2, 'Noclegi pocąwszy od hotelu do pola namiotowego', 'Pole Namiotowe', 4);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (3, 'aktywnie', 'Aktywny wypoczynek', 1);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (4, 'wszystko co da się robić na świerzym powietrzu', 'Na łonie natury', 1);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (5, 'Offroad, quady, motorówki i inne ...', 'Wypożyczalnia skuterów', 6);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (6, 'wypoczynek nad wodą', 'Woda', 1);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (7, null, 'Ląd', 1);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (8, null, 'Powietrze', 1);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (9, null, 'W mieście', 1);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (10, null, 'Paralotnie', 3);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (11, null, 'Ekstremalne', 1);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (12, null, 'Afgańska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (13, null, 'Afrykańska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (14, null, 'Amerykańska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (15, null, 'Arabska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (16, null, 'Argentyńska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (17, null, 'Armeńska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (18, null, 'Australijska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (19, null, 'Azjatycka', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (20, null, 'Bar', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (21, null, 'Belgijska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (22, null, 'Brazylijska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (23, null, 'Brytyjska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (24, null, 'Chilijska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (25, null, 'Chińska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (26, null, 'Chorwacka', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (27, null, 'Czeska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (28, null, 'Duńska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (29, null, 'Egipska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (30, null, 'Etiopska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (31, null, 'Europejska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (32, null, 'Fast Food', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (33, null, 'Francuska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (34, null, 'Fusion', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (35, null, 'Grecka', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (36, null, 'Grill', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (37, null, 'Gruzińska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (38, null, 'Hawajska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (39, null, 'Hiszpańska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (40, null, 'Indonezyjska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (41, null, 'Indyjska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (42, null, 'Irlandzka', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (43, null, 'Izraelska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (44, null, 'Japońska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (45, null, 'Karaibska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (46, null, 'Kaukaska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (47, null, 'Kawiarnia', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (48, null, 'Kolumbijska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (49, null, 'Koreańska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (50, null, 'Kubańska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (51, null, 'Libańska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (52, null, 'Malezyjska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (53, null, 'Marokańska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (54, null, 'Meksykańska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (55, null, 'Międzynarodowa', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (56, null, 'Neapolitańska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (57, null, 'Nepalska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (58, null, 'Niemiecka', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (59, null, 'Owoce morza', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (60, null, 'Pakistańska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (61, null, 'Perska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (62, null, 'Peruwiańska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (63, null, 'Pizza', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (64, null, 'Polska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (65, null, 'Portugalska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (66, null, 'Street Food', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (67, null, 'Pub', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (68, null, 'Rosyjska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (69, null, 'Rumuńska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (70, null, 'Rzymska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (71, null, 'Singapurska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (72, null, 'Skandynawska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (73, null, 'Śródziemnomorska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (74, null, 'Stek', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (75, null, 'Sushi', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (76, null, 'Szwajcarska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (77, null, 'Szwedzka', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (78, null, 'Tajska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (79, null, 'Tajwańska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (80, null, 'Tania restauracja', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (81, null, 'Tunezyjska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (82, null, 'Turecka', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (83, null, 'Tybetańska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (84, null, 'Ukraińska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (85, null, 'Uzbekistańska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (86, null, 'Węgierska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (87, null, 'Wenezuelska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (88, null, 'Wietnamska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (89, null, 'Winiarnia', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (90, null, 'Włoska', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (91, null, 'Współczesna', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (92, null, 'Zdrowa', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (93, null, 'Zupy', 2);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (94, null, 'Schronisko', 4);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (95, null, 'Pensjonat', 4);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (96, null, 'Hostel', 4);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (97, null, 'Hotelik', 4);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (98, null, 'Hotel', 4);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (99, null, 'Kamping', 4);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (100, null, 'Gospodarstwo Agroturystyczne', 4);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (101, null, 'Muzeum', 5);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (102, null, 'Zabytek', 5);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (103, null, 'Zamek', 5);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (104, null, 'Pałac', 5);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (105, null, 'Skansen', 5);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (106, null, 'Dom', 4);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (107, null, 'Domek letniskowy', 4);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (108, null, 'Wypożyczalnia samochodów', 6);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (109, null, 'Wypożyczalnia sprzętu wodnego', 6);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (110, null, 'Offroad', 6);
INSERT INTO local_attractions.categories (id, description, name, main_category_id) VALUES (111, null, 'Pokój do wynajęcia', 4);

INSERT INTO local_attractions.services_categories (service_id, category_id) VALUES (2, 2);
INSERT INTO local_attractions.services_categories (service_id, category_id) VALUES (1, 36);
INSERT INTO local_attractions.services_categories (service_id, category_id) VALUES (1, 1);
INSERT INTO local_attractions.services_categories (service_id, category_id) VALUES (1, 3);
INSERT INTO local_attractions.services_categories (service_id, category_id) VALUES (1, 6);

INSERT INTO local_attractions.news_feed (id, description, ends, name, starts, service_id) VALUES (5, 'Z radością ogłaszamy, iż 1 maja 2019 rozpoczynamy sezon! Zapraszamy na spływy już od środy!', '2019-05-30', 'Początek sezonu', '2019-05-01', 1);
INSERT INTO local_attractions.news_feed (id, description, ends, name, starts, service_id) VALUES (6, 'Wszystko wskazuje na to, że lipiec będzie wyjątkowo piękny! Jeśli nie byłeś pewny pogody już się nie zastanawiaj! Chodź na kajak!', '2019-07-31', 'Lato w kajaku!', '2019-07-01', 1);
INSERT INTO local_attractions.news_feed (id, description, ends, name, starts, service_id) VALUES (7, 'W dniach 19 - 21 lipca zapraszamy na Piknnik Rycerski! 1. Pokazy walk 2. Pokaz rzemiosła 3. Średniowieczne wypieki', '2019-07-21', 'Piknik Rycerski', '2019-07-19', 1);
INSERT INTO local_attractions.offers (id, description, ends, name, starts, service_id) VALUES (2, 'Dla grup powyżej 5 osób od poniedziałku do piątku zniżka 15%! Warto!', '2019-08-31 00:00:00.000000', 'Promocja poniedziałek - piątek!', '2019-07-01 00:00:00.000000', 1);
INSERT INTO local_attractions.offers (id, description, ends, name, starts, service_id) VALUES (3, 'Przez cały sierpień od poniedziałku do piątku dzieci do lat 10 gratis!!!!', '2019-08-31 00:00:00.000000', 'Rodzinny sierpień!', '2019-08-01 00:00:00.000000', 1);
INSERT INTO local_attractions.offers (id, description, ends, name, starts, service_id) VALUES (4, 'W dniu rozpoczęcia sezonu 50% na wszystko!!!', '2019-05-01 00:00:00.000000', 'Promocja na wszystko dla wszystkich 50%!!!', '2019-05-01 00:00:00.000000', 1);
INSERT INTO local_attractions.offers (id, description, ends, name, starts, service_id) VALUES (5, 'W ostatni weekend sierpnia żegnamy lato! Zniżka 35% na spływ kajakiem, pontonem i kanu!', '2019-08-25 00:00:00.000000', 'Pożegnaie lata', '2019-08-24 00:00:00.000000', 1);