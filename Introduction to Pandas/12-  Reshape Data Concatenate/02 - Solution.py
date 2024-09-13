import pandas as pd

def concatenateTables(df1: pd.DataFrame, df2: pd.DataFrame) -> pd.DataFrame:
    # Use pd.concat() to concatenate df1 and df2 vertically
    result = pd.concat([df1, df2], ignore_index=True)
    return result