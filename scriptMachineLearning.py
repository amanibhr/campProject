import sys
import requests
import json
import logging
from transformers import pipeline
logging.captureWarnings(True)
url = "http://localhost:8089/TunisieCamp/Feedback/retrieve-all-feedbacks"
#function to get information from api
def get_all_feedback(url):
    payload = {}
    headers = {}
    response = requests.request("GET", url, headers=headers, data=payload)
    dataGet = response.json()
    return (dataGet)
    
list_feedbacks=get_all_feedback(url)
#analyse de sentiment avec modèle 
def sentiment_analysis(list_feedbacks):
  print (type(list_feedbacks))
  sentiment_pipeline = pipeline("sentiment-analysis")
  for feedback in list_feedbacks:
    print(sentiment_pipeline(feedback['commentaire']))
    feedback['sentiment']=sentiment_pipeline(feedback['commentaire'])[0]['label']
    print(feedback['commentaire'])
  return list_feedbacks

list_feedbacks_sentiment=sentiment_analysis(list_feedbacks)
print(list_feedbacks_sentiment)
###"API fOR Update Database"

def updata_DB(payload,url):
    headers = {
    'Content-Type': 'application/json'
    }

    response = requests.request("PUT", url, headers=headers, data=payload)
for sentiment in list_feedbacks_sentiment:
  # print(sentiment['id'])
  url = "http://localhost:8089/TunisieCamp/Feedback/update-Feedback/{}".format(sentiment['id'])
  payload = json.dumps(sentiment)
  updata_DB(payload,url)
