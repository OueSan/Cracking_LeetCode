import pandas as pd

def largest_orders(orders: pd.DataFrame) -> pd.DataFrame:
    # Group by 'customer_number' and count occurrences
    customer_counts = orders.groupby('customer_number').size().reset_index(name='count')
    
    # Sort by count in descending order
    sorted_customers = customer_counts.sort_values(by='count', ascending=False)
    
    # Get the top customer number
    most_frequent_customer = sorted_customers.head(1)[['customer_number']]
    
    return most_frequent_customer