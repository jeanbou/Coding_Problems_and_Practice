-- Note: the difficulties werer when you tried to unite all and previously sorted 1 select was squizzed that's why order by at the end
((SELECT CONCAT(NAME,'(',SUBSTRING(Occupation, 1, 1),')') AS COMPLICATEDNAME FROM OCCUPATIONS)
UNION ALL
(SELECT CONCAT('There are a total of ',COUNT(Occupation),' ',LOWER(Occupation),'s.') FROM OCCUPATIONS
GROUP BY Occupation)
)
ORDER BY COMPLICATEDNAME