insert into authority (name) values ('ROLE_ADMIN');
insert into authority (name) values ('ROLE_USER');

insert into authenticated_user (id, first_name, last_name, email, password, company_name) values 
    (nextval('person_seq'), 'Dragan', 'Grsic', 'auth@gmail.com', '$2a$10$smy7Eo0CdCrhcjYe8lAOMeMoxqeGTHGilpNcOiAAMUQR0F.5EVmHG', 'Fast cars');
insert into user_authority (user_id, authority_id) values (1, 2);

insert into authenticated_user (id, first_name, last_name, email, password, company_name) values 
    (nextval('person_seq'), 'Dejan', 'Spasojevic', 'auth2@gmail.com', '$2a$10$smy7Eo0CdCrhcjYe8lAOMeMoxqeGTHGilpNcOiAAMUQR0F.5EVmHG', 'Aldo');
insert into user_authority (user_id, authority_id) values (2, 2);

insert into admin (id, first_name, last_name, email, password) values 
    (nextval('person_seq'), 'John', 'Smith', 'admin@gmail.com', '$2a$10$smy7Eo0CdCrhcjYe8lAOMeMoxqeGTHGilpNcOiAAMUQR0F.5EVmHG');
insert into user_authority (user_id, authority_id) values (3, 1);

insert into admin (id, first_name, last_name, email, password) values 
    (nextval('person_seq'), 'Simons', 'Balboa', 'admin2@gmail.com', '$2a$10$smy7Eo0CdCrhcjYe8lAOMeMoxqeGTHGilpNcOiAAMUQR0F.5EVmHG');
insert into user_authority (user_id, authority_id) values (4, 1);

insert into files (data, name, type) values (lo_import('/Users/images/title.jpg'), 'title.jpg', 'image/jpeg');

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

insert into model (name, make_id) values ('320', 1);
insert into model (name, make_id) values ('520', 1);
insert into model (name, make_id) values ('330', 1);
insert into model (name, make_id) values ('750Li', 1);

-- insert into make (name, model_id) values ('BMW', 1);
-- insert into make (name, model_id) values ('BMW', 2);
-- insert into make (name, model_id) values ('BMW', 3);
-- insert into make (name, model_id) values ('BMW', 4);

insert into vehicle (cubic_capacity, first_registration, kilometer, number_of_doors, power, model_id, fuel_type_id, vehicle_type_id) values (2000, '12-12-2017', 50000, 5, 145, 1, 1, 3);
insert into vehicle (cubic_capacity, first_registration, kilometer, number_of_doors, power, model_id, fuel_type_id, vehicle_type_id) values (2000, '12-12-2016', 45000, 5, 145, 2, 1, 5);
insert into vehicle (cubic_capacity, first_registration, kilometer, number_of_doors, power, model_id, fuel_type_id, vehicle_type_id) values (3000, '12-12-2005', 185000, 5, 286, 3, 2, 1);
insert into vehicle (cubic_capacity, first_registration, kilometer, number_of_doors, power, model_id, fuel_type_id, vehicle_type_id) values (4000, '12-12-2020', 2000, 5, 585, 4, 2, 3);

insert into location (country, city) values ('Serbia', 'Novi Sad');
insert into location (country, city) values ('Serbia', 'Belgrade');

insert into offer (date, description, authenticated_user_id, location_id, vehicle_id, price, images_id) values ('15-03-2021' ,'This offer is so god, dont miss the offer.', 1, 2, 1, 15000, 1);
insert into offer (date, description, authenticated_user_id, location_id, vehicle_id, price, images_id) values ('12-03-2021' ,'ofer com 2.', 2, 1, 2, 19000, null);
insert into offer (date, description, authenticated_user_id, location_id, vehicle_id, price, images_id) values ('15-02-2021' ,'ofer com 3.', 2, 1, 3, 5000, null);
insert into offer (date, description, authenticated_user_id, location_id, vehicle_id, price, images_id) values ('15-01-2021' ,'ofer com 4.', 1, 2, 4, 95000, null);