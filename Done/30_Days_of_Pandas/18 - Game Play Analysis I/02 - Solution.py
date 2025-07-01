import pandas as pd

def game_analysis(a: pd.DataFrame) -> pd.DataFrame:
    newdf=a.groupby('player_id')['event_date'].min().reset_index()
    newdf.columns=['player_id','first_login']
    return newdf