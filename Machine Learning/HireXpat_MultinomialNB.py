# IMPORT
import pandas as pd
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.model_selection import train_test_split
from sklearn.naive_bayes import MultinomialNB
import pickle
import numpy as np

df = pd.read_csv('buattrain.csv',
                 sep=';',
                 low_memory = False)
#df.sample(100)

# DATA CLEANING
df['description'] = df['description'].map(str) #mapping to str
df['description'] = df['description'].str.lower() #lowering all case
df['description'] = df['description'].str.replace(r'[^\w\s]+', ' ') #remove Punct
df['description'] = df['description'].str.replace(r'_+', ' ') #remove Punct
df['description'] = df['description'].str.replace('\s+', ' ', regex=True) #remove multiple space

#DIVIDING DATA INPUT & OUTPUT
input_column  = 'description'
output_column = 'label'
X = df.loc[:,input_column]
y = df.loc[:,output_column]
print('Data Divided Successfully Into Input & Output')

#BAG OF WORDS MODEL TO CONVERT FEATURES INTO NUMBERS
from sklearn.feature_extraction.text import CountVectorizer
count_vect = CountVectorizer()
X_counts   = count_vect.fit_transform(X).toarray()
print(X_counts.shape)

#TRAIN - TEST DATA SPLIT
from sklearn.model_selection import train_test_split
X_train, X_test, y_train, y_test = train_test_split(X_counts, y, test_size=0.1, random_state=0)
print('Data Divided Into Train & Test')

#CLASSIFICATION USING NAIVE BAYES
import numpy as np
from sklearn.naive_bayes import MultinomialNB
clf = MultinomialNB().fit(X_train, y_train)

predict = clf.predict(X_test)
print('Accuracy of The Model is =====> '+str(round(np.mean(predict == y_test)*100,2))+'%')

import pickle

# Save the trained model
with open('naive_bayes_model.pkl', 'wb') as f:
    pickle.dump(clf, f)

with open('count_vectorizer.pkl', 'wb') as f:
    pickle.dump(count_vect, f)


from google.colab import files
files.download('count_vectorizer.pkl')
files.download('naive_bayes_model.pkl')