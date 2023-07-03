create table categories
(
    category_id   int         not null
        primary key,
    category_name varchar(50) null
);

create table colors
(
    color_id   int         not null
        primary key,
    color_name varchar(20) null
);

create table cars
(
    car_id      int auto_increment
        primary key,
    brand       varchar(50) null,
    model       varchar(50) null,
    year        int         null,
    kilometers  int         null,
    color_id    int         null,
    category_id int         null,
    constraint cars_category_fk
        foreign key (category_id) references categories (category_id),
    constraint cars_colors_fk
        foreign key (color_id) references colors (color_id)
);

create table customer
(
    customer_id int auto_increment
        primary key,
    first_name  varchar(50) null,
    last_name   varchar(50) null
);

create table insurances
(
    insurance_id   int auto_increment
        primary key,
    insurance_type varchar(40)   null,
    cost           decimal(5, 2) null
);

create table locations
(
    location_id int         not null
        primary key,
    city        varchar(50) null
);

create table reservations
(
    reservation_id      int auto_increment
        primary key,
    customer_id         int  null,
    pickup_location_id  int  null,
    dropoff_location_id int  null,
    pickup_date         date null,
    dropoff_date        date null,
    car_id              int  null,
    insurance_id        int  null,
    constraint reservations__pickup_locations_fk
        foreign key (pickup_location_id) references locations (location_id),
    constraint reservations_cars_fk
        foreign key (car_id) references cars (car_id),
    constraint reservations_customer_fk
        foreign key (customer_id) references customer (customer_id),
    constraint reservations_dropoff_locations_fk
        foreign key (dropoff_location_id) references locations (location_id),
    constraint reservations_insurances_fk
        foreign key (insurance_id) references insurances (insurance_id)
);


