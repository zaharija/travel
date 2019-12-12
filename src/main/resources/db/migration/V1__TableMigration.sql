CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    phone_number VARCHAR(50),
    token VARCHAR(10)
);
CREATE TABLE places (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    county VARCHAR(50) NOT NULL
);
CREATE TABLE owners (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    phone_number VARCHAR(50)
);
CREATE TABLE apartments (
    id SERIAL PRIMARY KEY,
    price VARCHAR(50) NOT NULL,
    beds VARCHAR(50) NOT NULL,
    stars VARCHAR(50) NOT NULL,
    place_id INTEGER REFERENCES places(id),
    owner_id INTEGER REFERENCES owners(id)
);
CREATE TABLE bookings (
    id SERIAL PRIMARY KEY,
    bookingStart DATE NOT NULL,
    bookingEnd DATE NOT NULL,
    apartment_id INTEGER REFERENCES apartments(id)
);
CREATE TABLE admins (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    token VARCHAR(10)
);