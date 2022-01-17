-- This is a not exact SQL request, but just what I stored after
SELECT roller_ID, name FROM students WHERE
roller_ID IN (SELECT roller_ID from ROLLER_STUDENTS_MARK WHERE ( subject_one+subject_two+subject_three< 100))
