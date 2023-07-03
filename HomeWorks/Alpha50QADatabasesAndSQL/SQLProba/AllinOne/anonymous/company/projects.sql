create table projects
(
    project_id  int auto_increment
        primary key,
    name        varchar(50) not null,
    description longtext    null,
    end_date    datetime    null,
    start_date  datetime    not null
)
    charset = utf8mb4;

