import pandas as pd


def selectFirstRows(employees: pd.DataFrame) -> pd.DataFrame:
    # Return the first 3 rows of the DataFrame
    return employees.head(3)



This function, selectFirstRows, takes a DataFrame named employees as input and returns the first three rows using the head() method with an argument of 3.