create table flight
(
    price               float(53) not null,
    id                  uuid      not null,
    arrival_airport     varchar(255),
    departure_airport   varchar(255),
    departure_date_time varchar(255),
    return_date_time    varchar(255),
    primary key (id)
);
