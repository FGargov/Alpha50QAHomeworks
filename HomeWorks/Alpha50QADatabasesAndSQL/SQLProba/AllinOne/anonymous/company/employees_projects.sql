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

