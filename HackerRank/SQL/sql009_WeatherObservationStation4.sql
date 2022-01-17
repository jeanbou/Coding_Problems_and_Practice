-- HINT : https://stackoverflow.com/questions/21701094/calculate-the-difference-between-results-of-two-count-queries-based-on-2-tabl
SELECT (COUNT(CITY)-COUNT(DISTINCT CITY)) FROM STATION
