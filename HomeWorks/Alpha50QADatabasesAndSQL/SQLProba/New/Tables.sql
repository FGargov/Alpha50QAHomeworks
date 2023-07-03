create table departments
(
    department_id int auto_increment
        primary key,
    name          varchar(50) not null,
    manager_id    int         not null
)
    charset = utf8mb4;

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

create table towns
(
    town_id int auto_increment
        primary key,
    name    varchar(50) not null
)
    charset = utf8mb4;

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

create table employees
(
    employee_id   int auto_increment
        primary key,
    first_name    varchar(50)    not null,
    last_name     varchar(50)    not null,
    middle_name   varchar(50)    null,
    job_title     varchar(50)    not null,
    department_id int            not null,
    manager_id    int            null,
    hire_date     datetime       not null,
    salary        decimal(19, 4) not null,
    address_id    int            null,
    constraint FK_employees_addresses
        foreign key (address_id) references addresses (address_id),
    constraint FK_employees_departments
        foreign key (department_id) references departments (department_id),
    constraint FK_employees_employees
        foreign key (manager_id) references employees (employee_id)
)
    charset = utf8mb4;

alter table departments
    add constraint FK_departments_employees
        foreign key (manager_id) references employees (employee_id);

create table employees_projects
(
    employee_id int not null,
    project_id  int not null,
    primary key (employee_id, project_id),
    constraint FK_employees_projects_employees
        foreign key (employee_id) references employees (employee_id),
    constraint FK_employees_projects_projects
        foreign key (project_id) references projects (project_id)
)
    charset = utf8mb4;


