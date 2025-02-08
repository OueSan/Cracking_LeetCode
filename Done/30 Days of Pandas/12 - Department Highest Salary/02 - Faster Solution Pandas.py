import pandas as pd

def department_highest_salary(employee: pd.DataFrame, department: pd.DataFrame) -> pd.DataFrame:
    
    df = employee.merge(department, how='left', 
                        left_on='departmentId', right_on='id')

    grp = df.groupby('name_y')['salary']                    

    return df[df.salary == grp.transform(max)].iloc[:,[5,1,2]
             ].rename(columns = {'name_x': 'Employee',
                                 'salary': 'Salary',
                                 'name_y': 'Department'}) 