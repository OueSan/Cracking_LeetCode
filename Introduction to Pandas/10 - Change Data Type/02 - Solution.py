import pandas as pd

def changeDatatype(students: pd.DataFrame) -> pd.DataFrame:
    # Convert the 'grade' column to integers
    students['grade'] = students['grade'].astype(int)
    return students
