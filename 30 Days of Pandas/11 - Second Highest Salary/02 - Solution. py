import pandas as pd

def second_highest_salary(employee: pd.DataFrame) -> pd.DataFrame:
    employee = employee['salary'].drop_duplicates()
    employee = employee.sort_values(ascending=False)
    if len(employee) < 2:
        return pd.DataFrame({'SecondHighestSalary' : [None]})
    else:
        return pd.DataFrame({'SecondHighestSalary' : [employee.iloc[1]]})