-- Hint: Only after reading forum, I have found what was wrong in my initial query https://www.hackerrank.com/challenges/earnings-of-employees/forum
SELECT salary * months AS earnings, COUNT(employee_id)
FROM EMPLOYEE
GROUP BY earnings
ORDER BY earnings DESC
LIMIT 1;