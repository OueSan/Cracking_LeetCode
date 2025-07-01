import pandas as pd

def fillMissingValues(products: pd.DataFrame) -> pd.DataFrame:
    # Fill missing values in 'quantity' column with 0
    products['quantity'] = products['quantity'].fillna(0)
    
    # Return the updated DataFrame
    return products
