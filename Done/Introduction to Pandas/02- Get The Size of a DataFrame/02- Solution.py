from typing import List
import pandas as pd

def getDataframeSize(players: pd.DataFrame) -> List[int]:
    # Obtendo o número de linhas e colunas
    return list(players.shape)
