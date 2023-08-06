-- 1. Write a SQL query to find the average salary of employees who have been hired before year 2000 incl. Round it down to the nearest integer.
SELECT FLOOR(AVG(salary)) AS average_salary
FROM employees
WHERE YEAR(hire_date) <= 2000;

-- 2. Write a SQL query to find all town names that end with a vowel (a,o,u,e,i).
-- Hint: MySQL right() function
SELECT name FROM towns
WHERE RIGHT(name, 1) IN ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

-- 3. Write a SQL query to find all town names that start with a vowel (a,o,u,e,i).
SELECT name FROM towns
WHERE LEFT(name, 1) IN ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

-- 4. Write a SQL query that outputs the name and the length of the town with the longest name.
SELECT name, CHAR_LENGTH(name) AS length
FROM towns
ORDER BY length DESC;


-- 5. Write a SQL query that outputs the name and the length of the town with the shortest name.


-- 6. Write a SQL query to find all employees with even IDs.


-- 7. Write a SQL query to find the names and salaries of the employees that take the minimal salary in the company.


-- 8. Write a SQL query to find the names and salaries of the employees that have a salary that is up to 10% higher than the minimal salary for the company.


-- 9. Write a SQL query to find the full name, salary and department of the employees that take the minimal salary in their department.


-- 10. Write a SQL query to find the average salary in department #1.


-- 11. Write a SQL query to find the average salary in the "Sales" department.


-- 12. Write a SQL query that outputs the number of employees in the "Sales" department.


-- 13. Write a SQL query that outputs the number of employees that have manager.


-- 14. Write a SQL query that outputs the number of employees that don't have manager.


-- 15. Write a SQL query to find all departments, along with the average salary for each of them.


-- 16. Write a SQL query to find all projects that took less than 1 year (365 days) to complete.
-- Hint: Datediff


-- 17. Write a SQL query that outputs the number for employees from each town, grouped by department. For example how many people from Bellevue work in Sales. How many people from Calgary work in Marketing, and so on...


-- 18. Write a SQL query that outputs the first and last name of all managers that have exactly 5 employees.


-- 19. Write a SQL query to find all employees along with their managers. For employees that do not have manager display the value "(no manager)".


-- 20. Write a SQL query that outputs the names of all employees whose last name is exactly 5 characters long.
-- Hint: MySQL length


-- 21. Write a SQL query that outputs the current date and time in the following format "`day.month.year hour:minutes:seconds:milliseconds`".
SELECT DATE_FORMAT(NOW(),'%d.%m.%Y %H:%i:%s:%f') AS current_datetime;

SELECT DATE_FORMAT(NOW(),'%d.%m.%Y %H:%i:%s') AS current_datetime,
       FLOOR((MICROSECOND(NOW())/1000)) AS milliseconds;

-- 22. Write a SQL query to display the average employee salary by department and job title. For example, the average salary in Engineering for Design Engineer is 32,700.
-- Hint: MySQL date functions


-- 23. Write a SQL query that outputs the town with most employees.


-- 24. Write a SQL query that outputs the number of managers from each town.


-- 25. Write a SQL query to find the manager who is in charge of the most employees and his average salary.


-- 26. Write a SQL query that outputs the names of the employees who have worked on the most projects.
