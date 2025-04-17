import pandas as pd

def selectData(students: pd.DataFrame) -> pd.DataFrame:
    filtered_df = students[students['student_id'] == 101]
#Here, the function filters the students DataFrame to select only the rows where the student_id is equal to 101. 
# The filtering is done using the condition students['student_id'] == 101. 
# This returns a new DataFrame, filtered_df, containing only the rows that match the condition.

    result = filtered_df[['name','age']]
#This line selects only the name and age columns from the filtered_df. The double square brackets [['name', 'age']] are used to indicate that we're selecting these two columns.

    return result