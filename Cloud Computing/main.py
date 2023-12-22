from flask import Flask, request, jsonify, make_response
from flask_cors import CORS
import pickle
import re
import uuid
from datetime import datetime
import pandas as pd

app = Flask(__name__)
CORS(app)

# Load the trained model
with open('naive_bayes_model.pkl', 'rb') as f:
    model = pickle.load(f)

# Load the CountVectorizer
with open('count_vectorizer.pkl', 'rb') as f:
    count_vect = pickle.load(f)

@app.route('/listjob', methods=['GET', 'POST'])
def predict():
        if request.method == 'POST':
         # Request Body
            data = request.json
            text = data['description']
        elif request.method == "GET" :
            text = request.args.get('description')

        try:
            # Preprocess the input text

            text = text.lower()
            text = re.sub(r'[^\w\s]+', ' ', text)
            text = re.sub(r'_+', ' ', text)
            text = re.sub('\s+', ' ', text)

            # Vectorize the input text
            text_vectorized = count_vect.transform([text])

            # Make the prediction
            predicted_probabilities = model.predict_proba(text_vectorized)[0]
            top_class_index = predicted_probabilities.argmax()
            top_class = model.classes_[top_class_index]
            top_probability = predicted_probabilities[top_class_index]

            data_companies = pd.read_csv('data_company.csv', sep=';', low_memory=False)
            df = pd.DataFrame(data_companies)

            # Filter DataFrame and convert to a list of dictionaries
            list_job = df[df['industry'] == top_class].to_dict(orient='records')

            response = {
                'prediction': top_class,
                'list_job': list_job
            }

            return jsonify(response)
        except Exception as error:
            error_message = f"Prediction error: {str(error)}"
            response = make_response(jsonify({'error': error_message}), 500)
            return response

@app.route('/health-check')
def health_check():
    return make_response(jsonify({'result': 'ok'}))

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=80)
