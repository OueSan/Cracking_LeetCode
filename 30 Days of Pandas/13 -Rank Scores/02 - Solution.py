'''
Approach
  1. Use the rank method with method ='dense' to assing ranks to the scores in descending order while handling ties. Add a new colum 'rank' to the scores DataFrame to store the ranks
  2. Sort the DataFrame by score in descending order. This can be achieved using the sort_values method. 
'''

import pandas as pd

def order_scores(scores: pd.DataFrame) -> pd.DataFrame:
    # Use the rank method to assign ranks to the scores in descending order with no gaps
    scores['rank'] = scores['score'].rank(method='dense', ascending=False)

    # Drop id column & Sort the DataFrame by score in descending order
    result_df = scores.drop('id', axis=1).sort_values(by='score', ascending=False)

    return result_df


#Best memory approach Memory: 67.9mb

'''
import pandas as pd

def order_scores(scores: pd.DataFrame) -> pd.DataFrame:
    top_s = sorted(scores.score.values, reverse = True)
    top = []
    top_score = []
    rank = 0
    for i in top_s:
        if i in top_score:
            top.append(rank)
        else:
            rank += 1
            top.append(rank)
            top_score.append(i)
    return pd.DataFrame({"score":top_s, "rank" : top})

'''

#Best RunTime Approach Runtime: 286ms




'''
import pandas as pd

def order_scores(scores: pd.DataFrame) -> pd.DataFrame:
    scores = scores.sort_values(by = 'score', ascending = False)
        scores['rank'] = scores['score'].rank(method = 'dense', ascending = False)
        return scores[['score', 'rank']]
'''