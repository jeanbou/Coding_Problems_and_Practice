-- This is a not exact SQL request, but just what I stored after
SELECT employee_ID, name FROM EMPLOYEES
WHERE description LIKE '%HR%' AND employee_ID IN (SELECT employee_ID FROM last_year_bonus WHERE bonus >= 5000)
