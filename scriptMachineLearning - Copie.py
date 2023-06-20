import sys
import requests
import json
import logging
from transformers import pipeline
logging.captureWarnings(True)

#function to get information from api
def get_all_DB(url):
    payload = {}
    headers = {}
    response = requests.request("GET", url, headers=headers, data=payload)
    dataGet = response.json()
    return (dataGet)
    

#analyse de sentiment avec modèle 
def sentiment_analysis(list_feedbacks):
  sentiment_pipeline = pipeline("sentiment-analysis")
  for feedback in list_feedbacks:
    if feedback['sentiment']!="POSITIVE" and feedback['sentiment']!="NEGATIVE":
      feedback['sentiment']=sentiment_pipeline(feedback['commentaire'])[0]['label']
  return list_feedbacks

###"API fOR Update Database"
def updata_DB(payload,url):
    headers = {
    'Content-Type': 'application/json'
    }
    response = requests.request("PUT", url, headers=headers, data=payload)
    

def update_sentiment(list_feedbacks_sentiment):
    for sentiment in list_feedbacks_sentiment:
        url = "http://localhost:8089/TunisieCamp/Feedback/update-Feedback/{}".format(sentiment['id'])
        payload = json.dumps(sentiment)
        updata_DB(payload,url)

#######################################################Part 2 Most frequent word
def update_tags_forum(list_Feedbacks_in_Forums):
  for forum in list_Feedbacks_in_Forums:
    list_feedbacks_by_forum=""
    for f in forum['feedbacks']:
      if f['sentiment']!="NEGATIVE":
          list_feedbacks_by_forum+=" "+(f['commentaire'])
      
    #function to split text into word
    print(list_feedbacks_by_forum)
    tokens = word_tokenize(list_feedbacks_by_forum)
    tokens = [w for w in tokens if w not in stop_words and w.isalpha() ]
    print(tokens)
    vocabulary = set(tokens)
    # print(len(vocabulary))
    frequency_dist = nltk.FreqDist(tokens)
    tags=sorted(frequency_dist,key=frequency_dist.__getitem__, reverse=True)[0:5]
    forum['tags']=str(tags)
    print(forum['id'])
    print(tags)
    url_forum_update  = "http://localhost:8089/TunisieCamp/forum/update-forum/{}".format(forum['id'])
    payload = json.dumps(forum)
    print("payload",forum)
    print(type(forum))
    updata_DB(payload,url_forum_update)
  return (list_Feedbacks_in_Forums)
    
import nltk
nltk.download('punkt')
nltk.download('stopwords')
from nltk.tokenize import word_tokenize
from nltk.corpus import stopwords
stop_words = set(stopwords.words())
####exec
##########Feedback
url_feedback = "http://localhost:8089/TunisieCamp/Feedback/retrieve-all-feedbacks"
list_feedbacks=get_all_DB(url_feedback)
list_feedbacks_sentiment=sentiment_analysis(list_feedbacks)
update_sentiment(list_feedbacks_sentiment)
print(list_feedbacks_sentiment)
##########Forum
url_forum_get = "http://localhost:8089/TunisieCamp/forum/retrieve-all-forums"
list_Feedbacks_in_Forums=get_all_DB(url_forum_get)
list_Feedbacks_in_Forums=update_tags_forum(list_Feedbacks_in_Forums)
print(list_Feedbacks_in_Forums)
