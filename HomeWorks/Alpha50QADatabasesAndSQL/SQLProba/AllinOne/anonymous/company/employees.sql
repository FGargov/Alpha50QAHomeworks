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

