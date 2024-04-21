/*insert into users*/
INSERT INTO `dining_reviews_db`.`users` (`USERNAME`, `NAME`, `PASSWORD`, `PHONE_NUMBER`, `CITY`) VALUES ('petar123', 'Petar Dimitrov', '123456', '0887624531', 'Sofia');
INSERT INTO `dining_reviews_db`.`users` (`USERNAME`, `NAME`, `PASSWORD`, `PHONE_NUMBER`, `CITY`) VALUES ('jivko456', 'Jivko Ivanov', '654321', '089642268', 'Plovdiv');
INSERT INTO `dining_reviews_db`.`users` (`USERNAME`, `NAME`, `PASSWORD`, `PHONE_NUMBER`, `CITY`) VALUES ('svetla324', 'Svetla Yordanova', '456987', '0886457811', 'Lom');
INSERT INTO `dining_reviews_db`.`users` (`USERNAME`, `NAME`, `PASSWORD`, `PHONE_NUMBER`, `CITY`) VALUES ('yordan789', 'Yordan Todorov', '789654', '0896312747', 'Sofia');
INSERT INTO `dining_reviews_db`.`users` (`USERNAME`, `NAME`, `PASSWORD`, `PHONE_NUMBER`, `CITY`) VALUES ('evelina746', 'Evelina Bogdanova', '965412', '0896352249', 'Plovdiv');
INSERT INTO `dining_reviews_db`.`users` (`USERNAME`, `NAME`, `PASSWORD`, `PHONE_NUMBER`, `CITY`) VALUES ('teodor906', 'Teodor Filipov', '654123', '0896400257', 'Sofia');
INSERT INTO `dining_reviews_db`.`users` (`USERNAME`, `NAME`, `PASSWORD`, `PHONE_NUMBER`, `CITY`) VALUES ('veselina098', 'Veselina Stoyanova', '654123', '0896322257', 'Lom');
INSERT INTO `dining_reviews_db`.`users` (`USERNAME`, `NAME`, `PASSWORD`, `PHONE_NUMBER`, `CITY`) VALUES ('desislava456', 'Desislava Stamenova', '456987', '0887543001', 'Plovdiv');
INSERT INTO `dining_reviews_db`.`users` (`USERNAME`, `NAME`, `PASSWORD`, `PHONE_NUMBER`, `CITY`) VALUES ('martin654', 'Martin Veselinov', '123045', '0885420014', 'Sofia');
INSERT INTO `dining_reviews_db`.`users` (`USERNAME`, `NAME`, `PASSWORD`, `PHONE_NUMBER`, `CITY`) VALUES ('ralica123', 'Ralica Evgenieva', '456321', '0884560123', 'Plovdiv');

/*insert into cuisine*/
INSERT INTO `dining_reviews_db`.`cuisine` (`TYPE`) VALUES ('Bulgarian');
INSERT INTO `dining_reviews_db`.`cuisine` (`TYPE`) VALUES ('Italian');
INSERT INTO `dining_reviews_db`.`cuisine` (`TYPE`) VALUES ('Greek');
INSERT INTO `dining_reviews_db`.`cuisine` (`TYPE`) VALUES ('Mexican');
INSERT INTO `dining_reviews_db`.`cuisine` (`TYPE`) VALUES ('Japanese');
INSERT INTO `dining_reviews_db`.`cuisine` (`TYPE`) VALUES ('Korean');
INSERT INTO `dining_reviews_db`.`cuisine` (`TYPE`) VALUES ('Indian');
INSERT INTO `dining_reviews_db`.`cuisine` (`TYPE`) VALUES ('Mediterranean');
INSERT INTO `dining_reviews_db`.`cuisine` (`TYPE`) VALUES ('Chinese');

/*insert into restaurants*/
INSERT INTO `dining_reviews_db`.`restaurants` (`NAME`, `ADDRESS`, `PHONE_NUMBER`, `CUISINE_TYPE`, `price_range`, `FOOD_SCORE`, `SERVICE_SCORE`, `ATMOSPHERE_SCORE`, `OVERALL_SCORE`) VALUES ('Olive Tree', 'Sofia', '0887543200', '3', '$$', '0.0', '0.0', '0.0', '0.0');
INSERT INTO `dining_reviews_db`.`restaurants` (`NAME`, `ADDRESS`, `PHONE_NUMBER`, `CUISINE_TYPE`, `price_range`, `FOOD_SCORE`, `SERVICE_SCORE`, `ATMOSPHERE_SCORE`, `OVERALL_SCORE`) VALUES ('Bella Italiana', 'Plovdiv', '0897542703', '2', '$$', '0.0', '0.0', '0.0', '0.0');
INSERT INTO `dining_reviews_db`.`restaurants` (`NAME`, `ADDRESS`, `PHONE_NUMBER`, `CUISINE_TYPE`, `price_range`, `FOOD_SCORE`, `SERVICE_SCORE`, `ATMOSPHERE_SCORE`, `OVERALL_SCORE`) VALUES ('Sakura Sushi', 'Sofia', '0875221495', '5', '$$$$', '0.0', '0.0', '0.0', '0.0');
INSERT INTO `dining_reviews_db`.`restaurants` (`NAME`, `ADDRESS`, `PHONE_NUMBER`, `CUISINE_TYPE`, `price_range`, `FOOD_SCORE`, `SERVICE_SCORE`, `ATMOSPHERE_SCORE`, `OVERALL_SCORE`) VALUES ('Noodle World', 'Plovdiv', '0896425788', '9', '$', '0.0', '0.0', '0.0', '0.0');
INSERT INTO `dining_reviews_db`.`restaurants` (`NAME`, `ADDRESS`, `PHONE_NUMBER`, `CUISINE_TYPE`, `price_range`, `FOOD_SCORE`, `SERVICE_SCORE`, `ATMOSPHERE_SCORE`, `OVERALL_SCORE`) VALUES ('La Pizzeria Italiana', 'Lom', '0896320479', '2', '$$', '0.0', '0.0', '0.0', '0.0');
INSERT INTO `dining_reviews_db`.`restaurants` (`NAME`, `ADDRESS`, `PHONE_NUMBER`, `CUISINE_TYPE`, `price_range`, `FOOD_SCORE`, `SERVICE_SCORE`, `ATMOSPHERE_SCORE`, `OVERALL_SCORE`) VALUES ('Mama Mia''s Trattoria', 'Sofia', '0887563204', '2', '$$$', '0.0', '0.0', '0.0', '0.0');
INSERT INTO `dining_reviews_db`.`restaurants` (`NAME`, `ADDRESS`, `PHONE_NUMBER`, `CUISINE_TYPE`, `price_range`, `FOOD_SCORE`, `SERVICE_SCORE`, `ATMOSPHERE_SCORE`, `OVERALL_SCORE`) VALUES ('Tandoori Delight', 'Sofia', '0887300126', '7', '$$', '0.0', '0.0', '0.0', '0.0');
INSERT INTO `dining_reviews_db`.`restaurants` (`NAME`, `ADDRESS`, `PHONE_NUMBER`, `CUISINE_TYPE`, `price_range`, `FOOD_SCORE`, `SERVICE_SCORE`, `ATMOSPHERE_SCORE`, `OVERALL_SCORE`) VALUES ('Sabor Latino', 'Sofia', '0875014431', '4', '$', '0.0', '0.0', '0.0', '0.0');
INSERT INTO `dining_reviews_db`.`restaurants` (`NAME`, `ADDRESS`, `PHONE_NUMBER`, `CUISINE_TYPE`, `price_range`, `FOOD_SCORE`, `SERVICE_SCORE`, `ATMOSPHERE_SCORE`, `OVERALL_SCORE`) VALUES ('Dragon Wok', 'Lom', '0892001457', '9', '$', '0.0', '0.0', '0.0', '0.0');
INSERT INTO `dining_reviews_db`.`restaurants` (`NAME`, `ADDRESS`, `PHONE_NUMBER`, `CUISINE_TYPE`, `price_range`, `FOOD_SCORE`, `SERVICE_SCORE`, `ATMOSPHERE_SCORE`, `OVERALL_SCORE`) VALUES ('La Dolce Vita', 'Plovdiv', '0896104463', '2', '$$$$', '0.0', '0.0', '0.0', '0.0');

/*insert into administrators*/
INSERT INTO `dining_reviews_db`.`administrators` (`U_ID`) VALUES ('2');
INSERT INTO `dining_reviews_db`.`administrators` (`U_ID`) VALUES ('4');
INSERT INTO `dining_reviews_db`.`administrators` (`U_ID`) VALUES ('7');

/*insert into reviews*/
INSERT INTO `dining_reviews_db`.`reviews` (`RESTAURANT_ID`, `AUTHOR`, `PUBLISHED_ON`, `status`, `COMMENTARY`, `FOOD_SCORE`, `SERVICE_SCORE`, `ATMOSPHERE_SCORE`) VALUES ('2', '10', '2024-01-10 15:30:00', 'ACCEPTED', 'Delicious food and excellent service!', '5.0', '5.0', '4.0');
INSERT INTO `dining_reviews_db`.`reviews` (`RESTAURANT_ID`, `AUTHOR`, `PUBLISHED_ON`, `status`, `COMMENTARY`, `FOOD_SCORE`, `SERVICE_SCORE`, `ATMOSPHERE_SCORE`) VALUES ('4', '5', '2024-02-05 08:45:00', 'ACCEPTED', 'The food was average, but the service was fantastic.', '3.0', '5.0', '3.0');
INSERT INTO `dining_reviews_db`.`reviews` (`RESTAURANT_ID`, `AUTHOR`, `PUBLISHED_ON`, `status`, `COMMENTARY`, `FOOD_SCORE`, `SERVICE_SCORE`, `ATMOSPHERE_SCORE`) VALUES ('1', '9', '2024-02-20 18:20:00', 'REJECTED', 'Terrible experience, the food was cold and tasted awful. Service was slow and the staff was rude. I expect a refund.', '1.0', '1.0', '2.0');
INSERT INTO `dining_reviews_db`.`reviews` (`RESTAURANT_ID`, `AUTHOR`, `PUBLISHED_ON`, `status`, `COMMENTARY`, `FOOD_SCORE`, `SERVICE_SCORE`, `ATMOSPHERE_SCORE`) VALUES ('6', '6', '2024-03-03 12:00:00', 'ACCEPTED', 'Amazing ambiance and friendly staff.', '4.0', '4.0', '5.0');
INSERT INTO `dining_reviews_db`.`reviews` (`RESTAURANT_ID`, `AUTHOR`, `PUBLISHED_ON`, `status`, `COMMENTARY`, `FOOD_SCORE`, `SERVICE_SCORE`, `ATMOSPHERE_SCORE`) VALUES ('9', '3', '2024-03-15 20:10:00', 'ACCEPTED', 'Disappointing experience, slow service.', '2.0', '2.0', '3.0');
INSERT INTO `dining_reviews_db`.`reviews` (`RESTAURANT_ID`, `AUTHOR`, `PUBLISHED_ON`, `status`, `COMMENTARY`, `FOOD_SCORE`, `SERVICE_SCORE`, `ATMOSPHERE_SCORE`) VALUES ('6', '1', '2024-03-28 09:55:00', 'ACCEPTED', 'Incredible food, but the atmosphere was lacking.', '5.0', '4.0', '3.0');
INSERT INTO `dining_reviews_db`.`reviews` (`RESTAURANT_ID`, `AUTHOR`, `PUBLISHED_ON`, `status`, `COMMENTARY`, `FOOD_SCORE`, `SERVICE_SCORE`, `ATMOSPHERE_SCORE`) VALUES ('2', '5', '2024-04-10 16:40:00', 'PENDING', 'Great food, attentive staff.', '4.0', '5.0', '4.0');
INSERT INTO `dining_reviews_db`.`reviews` (`RESTAURANT_ID`, `AUTHOR`, `PUBLISHED_ON`, `status`, `COMMENTARY`, `FOOD_SCORE`, `SERVICE_SCORE`, `ATMOSPHERE_SCORE`) VALUES ('2', '8', '2024-04-02 11:40:00', 'ACCEPTED', 'Exceptional food quality and friendly service!', '5.0', '5.0', '4.0');
INSERT INTO `dining_reviews_db`.`reviews` (`RESTAURANT_ID`, `AUTHOR`, `PUBLISHED_ON`, `status`, `COMMENTARY`, `FOOD_SCORE`, `SERVICE_SCORE`, `ATMOSPHERE_SCORE`) VALUES ('3', '1', '2024-02-25 19:15:00', 'ACCEPTED', 'Mediocre food, but the service made up for it.', '3.0', '4.0', '4.0');
INSERT INTO `dining_reviews_db`.`reviews` (`RESTAURANT_ID`, `AUTHOR`, `PUBLISHED_ON`, `status`, `COMMENTARY`, `FOOD_SCORE`, `SERVICE_SCORE`, `ATMOSPHERE_SCORE`) VALUES ('10', '5', '2024-04-12 17:20:00', 'PENDING', 'Cozy ambiance, but the food lacked flavor.', '2.0', '3.0', '4.0');
INSERT INTO `dining_reviews_db`.`reviews` (`RESTAURANT_ID`, `AUTHOR`, `PUBLISHED_ON`, `status`, `COMMENTARY`, `FOOD_SCORE`, `SERVICE_SCORE`, `ATMOSPHERE_SCORE`) VALUES ('2', '8', '2024-03-05 08:30:00', 'ACCEPTED', 'Fantastic experience overall! Delicious food and attentive service.', '5.0', '5.0', '5.0');
