ALTER table employee_tbl
ADD COLUMN mg_id VARCHAR(25);

update employee_tbl
set mg_id = '443679012'
where emp_id = '311549902' OR emp_id = '442346889';