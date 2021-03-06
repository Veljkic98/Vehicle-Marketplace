insert into authority (name) values ('ROLE_ADMIN');
insert into authority (name) values ('ROLE_USER');

insert into authenticated_user (id, first_name, last_name, email, password, company_name, phone_number) values 
    (nextval('person_seq'), 'Dragan', 'Grsic', 'auth@gmail.com', '$2a$10$smy7Eo0CdCrhcjYe8lAOMeMoxqeGTHGilpNcOiAAMUQR0F.5EVmHG', 'Fast cars', '+385 69 558 321');
insert into user_authority (user_id, authority_id) values (1, 2);

insert into authenticated_user (id, first_name, last_name, email, password, company_name, phone_number) values 
    (nextval('person_seq'), 'Dejan', 'Spasojevic', 'auth2@gmail.com', '$2a$10$smy7Eo0CdCrhcjYe8lAOMeMoxqeGTHGilpNcOiAAMUQR0F.5EVmHG', 'Aldo', '+385 67 918 333');
insert into user_authority (user_id, authority_id) values (2, 2);

insert into admin (id, first_name, last_name, email, password) values 
    (nextval('person_seq'), 'John', 'Smith', 'admin@gmail.com', '$2a$10$smy7Eo0CdCrhcjYe8lAOMeMoxqeGTHGilpNcOiAAMUQR0F.5EVmHG');
insert into user_authority (user_id, authority_id) values (3, 1);

insert into admin (id, first_name, last_name, email, password) values 
    (nextval('person_seq'), 'Simons', 'Balboa', 'admin2@gmail.com', '$2a$10$smy7Eo0CdCrhcjYe8lAOMeMoxqeGTHGilpNcOiAAMUQR0F.5EVmHG');
insert into user_authority (user_id, authority_id) values (4, 1);

insert into vehicle_type (name) values ('Cabriolet / Roadster / Convertible');
insert into vehicle_type (name) values ('Estate Car');
insert into vehicle_type (name) values ('Saloon');
insert into vehicle_type (name) values ('Small Car');
insert into vehicle_type (name) values ('Sports Car / Coupe');
insert into vehicle_type (name) values ('SUV / Off-road');
insert into vehicle_type (name) values ('Van / Minibus');
insert into vehicle_type (name) values ('Other');

insert into fuel_type (name) values ('Petrol');
insert into fuel_type (name) values ('Diesel');
insert into fuel_type (name) values ('Ethanol');
insert into fuel_type (name) values ('Hybrid - Petrol');
insert into fuel_type (name) values ('Hybrid - Diesel');
insert into fuel_type (name) values ('Electric');
insert into fuel_type (name) values ('Other');

insert into make (name) values ('BMW');
insert into make (name) values ('Audi');

insert into model (name, make_id) values ('320', 1);
insert into model (name, make_id) values ('520', 1);
insert into model (name, make_id) values ('330', 1);
insert into model (name, make_id) values ('750Li', 1);
insert into model (name, make_id) values ('A8', 2);
insert into model (name, make_id) values ('A7', 2);

insert into files (data, name, type) values (lo_import('/Users/images/320.jpg'), '320.jpg', 'image/jpeg');
insert into files (data, name, type) values (lo_import('/Users/images/520.jpg'), '520.jpg', 'image/jpeg');
insert into files (data, name, type) values (lo_import('/Users/images/330.jpg'), '330.jpg', 'image/jpeg');
insert into files (data, name, type) values (lo_import('/Users/images/750Li.jpg'), '750Li.jpg', 'image/jpeg');
insert into files (data, name, type) values (lo_import('/Users/images/A7.jpg'), 'A7.jpg', 'image/jpeg');
insert into files (data, name, type) values (lo_import('/Users/images/A8.jpg'), 'A8.jpg', 'image/jpeg');
-- insert into files (data, name, type) values (lo_import('/Users/images/330.jpg'), '330.jpg', 'image/jpeg');
-- insert into files (data, name, type) values (lo_import('/Users/images/750Li.jpg'), '750Li.jpg', 'image/jpeg');
-- insert into files (data, name, type) values (lo_import('/Users/images/A8.jpg'), 'A8.jpg', 'image/jpeg');
-- insert into files (data, name, type) values (lo_import('/Users/images/A7.jpg'), 'A7.jpg', 'image/jpeg');



insert into vehicle (cubic_capacity, first_registration, kilometer, number_of_doors, power, model_id, fuel_type_id, vehicle_type_id) values (2000, '12-12-2017', 50000, 5, 145, 1, 1, 3);
insert into vehicle (cubic_capacity, first_registration, kilometer, number_of_doors, power, model_id, fuel_type_id, vehicle_type_id) values (2000, '12-12-2016', 45000, 5, 145, 2, 1, 5);
insert into vehicle (cubic_capacity, first_registration, kilometer, number_of_doors, power, model_id, fuel_type_id, vehicle_type_id) values (3000, '12-12-2005', 185000, 5, 286, 3, 2, 1);
insert into vehicle (cubic_capacity, first_registration, kilometer, number_of_doors, power, model_id, fuel_type_id, vehicle_type_id) values (4000, '12-12-2020', 2000, 5, 585, 4, 2, 3);
insert into vehicle (cubic_capacity, first_registration, kilometer, number_of_doors, power, model_id, fuel_type_id, vehicle_type_id) values (3000, '12-12-2018', 120000, 5, 286, 5, 3, 6);
insert into vehicle (cubic_capacity, first_registration, kilometer, number_of_doors, power, model_id, fuel_type_id, vehicle_type_id) values (3000, '12-12-2017', 185000, 5, 256, 6, 3, 7);

insert into location (country, city) values ('Serbia', 'Novi Sad');
insert into location (country, city) values ('Serbia', 'Belgrade');

insert into offer (date, description, authenticated_user_id, location_id, vehicle_id, price, images_id) values ('15-03-2021' ,'This offer is so god, dont miss the offer.', 1, 1, 1, 15000, 1);
insert into offer (date, description, authenticated_user_id, location_id, vehicle_id, price, images_id) values ('12-03-2021' ,'ofer com 2.', 2, 2, 2, 19000, 2);
insert into offer (date, description, authenticated_user_id, location_id, vehicle_id, price, images_id) values ('15-02-2021' ,'ofer com 3.', 2, 1, 3, 5000, 3);
insert into offer (date, description, authenticated_user_id, location_id, vehicle_id, price, images_id) values ('15-01-2021' ,'ofer com 4.', 1, 2, 4, 95000, 4);
insert into offer (date, description, authenticated_user_id, location_id, vehicle_id, price, images_id) values ('18-01-2021' ,'Auto je kao NOV! Vredi pogledati. Ovo je oglas broj 6...', 1, 2, 6, 38000, 5);
insert into offer (date, description, authenticated_user_id, location_id, vehicle_id, price, images_id) values ('15-01-2021' ,'Redovno odrzavan u ovlastenom servisu. Za svaku preporuku.', 1, 1, 5, 35000, 6);
