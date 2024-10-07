import pandas as pd

def count_unique_subjects(df: pd.DataFrame) -> pd.DataFrame:
    return df.groupby('teacher_id')['subject_id'].agg(cnt='nunique').reset_index()

#Memory 70MB
#RunTime 355 ms