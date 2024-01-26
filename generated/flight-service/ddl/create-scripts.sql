create table flight
(
    price               float(53) not null,
    departure_date_time timestamp(6),
    return_date_time    timestamp(6),
    id                  uuid      not null,
    arrival_airport     varchar(255),
    departure_airport   varchar(255),
    primary key (id)
);

