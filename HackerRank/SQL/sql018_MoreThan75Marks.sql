-- HINT: https://stackoverflow.com/questions/34832734/query-to-order-by-the-last-three-characters-of-a-column/39118018
SELECT NAME FROM STUDENTS
WHERE MARKS > 75
ORDER BY RIGHT(NAME, 3), ID ASC
