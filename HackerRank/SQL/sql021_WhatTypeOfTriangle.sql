-- Hint: Better solution https://github.com/BlakeBrown/HackerRank-Solutions/blob/master/SQL/2_Advanced%20Select/01_Type%20of%20Triangle/Type%20of%20Triangle.mysql
SELECT
CASE
    WHEN A = B AND B = C THEN 'Equilateral'
    WHEN ( (A+B)<=C OR (A+C)<=B OR (B+C)<=A ) THEN 'Not A Triangle'
    WHEN (NOT ( (A+B)<=C OR (A+C)<=B OR (B+C)<=A )) AND (A=B OR C=B OR A=C) THEN 'Isosceles'
    ELSE 'Scalene'
    END
END
FROM TRIANGLES