create table addresses
(
    address_id int auto_increment
        primary key,
    text       varchar(100) not null,
    town_id    int          null,
    constraint FK_addresses_towns
        foreign key (town_id) references towns (town_id)
)
    charset = utf8mb4;

