import pandas as pd

def selectData(students: pd.DataFrame) -> pd.DataFrame:
    filtered_df = students[students['student_id'] == 101]
    result = filtered_df[['name','age']]
    return result