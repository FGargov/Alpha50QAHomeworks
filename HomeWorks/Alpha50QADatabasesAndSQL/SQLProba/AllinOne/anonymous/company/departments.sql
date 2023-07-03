create table departments
(
    department_id int auto_increment
        primary key,
    name          varchar(50) not null,
    manager_id    int         not null,
    constraint FK_departments_employees
        foreign key (manager_id) references employees (employee_id)
)
    charset = utf8mb4;

