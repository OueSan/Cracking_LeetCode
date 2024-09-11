Explanation:
The function changeDatatype takes a pandas DataFrame students as input.
The .astype(int) method converts the grade column from floats to integers.
The DataFrame is returned with the updated data type for the grade column.
You can use this function with the provided example like this:

python

# Example DataFrame
data = {'student_id': [1, 2],
        'name': ['Ava', 'Kate'],
        'age': [6, 15],
        'grade': [73.0, 87.0]}

students = pd.DataFrame(data)

# Call the function
updated_students = changeDatatype(students)

# Print the result
print(updated_students)
This will output:


   student_id  name  age  grade
0           1   Ava    6     73
1           2  Kate   15     87






