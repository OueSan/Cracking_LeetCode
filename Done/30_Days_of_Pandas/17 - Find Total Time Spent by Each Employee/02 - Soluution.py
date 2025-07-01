import pandas as pd

def total_time(employees: pd.DataFrame) -> pd.DataFrame:
    employees['time']=(employees['out_time']-employees['in_time']).astype(int)

    tmp=pd.DataFrame(employees.groupby(['emp_id','event_day'],as_index=False)['time'].sum())

    tmp.columns=['emp_id','day','total_time']
    return tmp