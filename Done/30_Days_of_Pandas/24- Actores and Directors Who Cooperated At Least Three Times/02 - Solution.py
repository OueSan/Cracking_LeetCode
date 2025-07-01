import pandas as pd

def actors_and_directors(actor_director: pd.DataFrame) -> pd.DataFrame:
        pair_count = actor_director.groupby(['actor_id', 'director_id'], as_index=False).count()
        return pair_count.loc[pair_count['timestamp'] >= 3, ['actor_id', 'director_id']]