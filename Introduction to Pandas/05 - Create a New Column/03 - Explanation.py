# The function createBonusColum takes in a DataFrame employees and return (-> symbol) a column (pd.DataFrame) 
# So you need to name the column like this employees ['bonus'] and give the value to this
#like this    employees['Bonus'] = Employees['Salary'] * 2 (because the problem ask you to double the salary in bonus) 
#and this must return employees (a extra column for this data.Frame) 

Input
employees =
| name    | salary |
| ------- | ------ |
| Piper   | 4548   |
| Grace   | 28150  |
| Georgia | 1103   |
| Willow  | 6593   |
| Finn    | 74576  |
| Thomas  | 24433  |
Output
| name    | salary | bonus  |
| ------- | ------ | ------ |
| Piper   | 4548   | 9096   |
| Grace   | 28150  | 56300  |
| Georgia | 1103   | 2206   |
| Willow  | 6593   | 13186  |
| Finn    | 74576  | 149152 |
| Thomas  | 24433  | 48866  |