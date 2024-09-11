Explanation:
The rename() method is used to change the column names. The columns parameter is provided a dictionary where the keys are the old column names, and the values are the new column names.
The DataFrame with the renamed columns is returned.
Example Usage:



# Example DataFrame
data = {
    'id': [1, 2, 3, 4, 5],
    'first': ['Mason', 'Ava', 'Taylor', 'Georgia', 'Thomas'],
    'last': ['King', 'Wright', 'Hall', 'Thompson', 'Moore'],
    'age': [6, 7, 16, 18, 10]
}

students = pd.DataFrame(data)

# Call the function
renamed_students = renameColumns(students)

print(renamed_students)
Output:

   student_id first_name last_name  age_in_years
0           1      Mason      King             6
1           2        Ava    Wright             7
2           3     Taylor      Hall            16
3           4    Georgia  Thompson            18
4           5     Thomas     Moore            10






