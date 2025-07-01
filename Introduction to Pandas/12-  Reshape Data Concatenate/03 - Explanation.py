Explanation:
pd.concat([df1, df2], ignore_index=True) combines df1 and df2 vertically.
The ignore_index=True argument ensures that the resulting DataFrame has a new, continuous index.


Example:

# Input DataFrames
df1 = pd.DataFrame({
    'student_id': [1, 2, 3, 4],
    'name': ['Mason', 'Ava', 'Taylor', 'Georgia'],
    'age': [8, 6, 15, 17]
})

df2 = pd.DataFrame({
    'student_id': [5, 6],
    'name': ['Leo', 'Alex'],
    'age': [7, 7]
})

# Concatenating the DataFrames
result = concatenateTables(df1, df2)

print(result)


Output:
   student_id     name  age
0           1    Mason    8
1           2      Ava    6
2           3   Taylor   15
3           4  Georgia   17
4           5      Leo    7
5           6     Alex    7
