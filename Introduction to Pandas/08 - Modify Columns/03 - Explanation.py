"""
Explanation:
The modifySalaryColumn function takes a pandas DataFrame as input.
It updates the salary column by multiplying each salary value by 2.
Finally, it returns the modified DataFrame.

Example Usage:
python

data = {'name': ['Jack', 'Piper', 'Mia', 'Ulysses'],
        'salary': [19666, 74754, 62509, 54866]}

employees = pd.DataFrame(data)

modified_employees = modifySalaryColumn(employees)
print(modified_employees)
Output:
markdown

      name   salary
0     Jack    39332
1    Piper   149508
2      Mia   125018
3  Ulysses   109732

"""