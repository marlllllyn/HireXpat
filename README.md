# 🤝🌏HireXpat🌏🤝
###  **Bridging careers globally – connecting talent with opportunities, one border at a time!**
Many foreigners, commonly referred to as expatriates or expats, express a strong interest in working in Indonesia. However, these individuals often encounter limitations stemming from finding job opportunities, and additional information like changes in immigration policies, work permit requirements, and other legal considerations. 

This app links global jobs invites foreign talent to Indonesia. Exclusively international, it streamlines overseas job searches and provides visa insights. Empowering career leaps, it aligns with our MD, CC, and ML path, connecting talent globally inspired by real-world problems.

![Design and Development](https://github.com/marlllllyn/HireXpat/blob/main/HIREXPAT.jpg)

# Background 👔📣
● Increasing Global Workforce Mobility

More people worldwide seek job opportunities abroad or aspire to develop careers in Indonesia, emphasizing the growing trend of international workforce movement.

● Challenges Faced by Expatriates

Expatriates encounter difficulties such as unfamiliar job markets, language barriers, and adjusting to local customs, which hinder both personal and professional growth

● Lack of Platforms Providing Expatriates Information

Insufficient availability of comprehensive platforms offering necessary details such as job opportunities, immigration policies, work permits, and other essential information for expatriates.

● Proposed Innovative Solution

Introducing HireXpat, an innovative mobile application aimed at addressing the challenges faced by expatriates by leveraging AI technology to enhance job search efficiency and provide tailored support.

● Empowerment and Support for Expatriates

A dedicated effort to empower and support expatriates in their international careers, providing invaluable assistance, guidance, and resources to help them navigate challenges and make informed decisions.

# Data 🗂
The data used to train and test the model consist of three datasets, which are **data_company.csv**, **users (1).csv**, and **buattrain.csv**. The data_company.csv data includes eight different attributes: ID_company, name, email, country, provinces, industry, position_available, and description. The users (1).csv data includes two different attributes: description and label. The buattrain.csv data includes two different attributes: description and label. The users (1).csv data and buattrain.csv has the same attributes but with different contents. Spesifically, the buattrain.csv data was used to train and test the model to make sure that the user's description align with the company's label. The data was splitted into training and testing sets following 90:10 ratio.

# The model used for this application 📲
The model architecture consists of a Bag of Words representation using CountVectorizer and a Multinomial Naive Bayes classifier. The dataset used to train the model was divided into input (Description) and output (Label). The data is preprocessed by converting to lowercase, removing punctuation, and applying bag-of-words encoding. After all of the training and testing process of the model was done, the accuracy of the model is evaluated using the test set, and it achieved an accuracy of 91.67%.


# Implementation and Reasoning  💻
This application used a model for text classification with Naive Bayes using Scikit-Learn and developing an API using Flask for making predictions based on the trained model. The reasoning behind the implementation is to classify users job interests into relevant job field.



# Team Members 🫂
👉 (ML) M232BSX0969  – Amanda Gozali 

  👩‍💼[LinkedIn](https://www.linkedin.com/in/amandagozali/)

👉 (ML)  M232BSX1921 – Angela Iskandar 

  👩‍💼[LinkedIn](www.linkedin.com/in/angela-iskandar-)

👉 (ML)  M232BSX0247 – Marlyn Ha 

  👩‍💼[LinkedIn](https://www.linkedin.com/in/marlyn-ha/)


👉 (CC)  C009BSY4317 – Muhamad Ramdani  

  👨🏾‍💼[LinkedIn](https://www.linkedin.com/in/mramdanii)

👉 (CC)  C009BSY3634 – Rafly Akval Caesar Fadillah 

  👨🏾‍💼[LinkedIn](https://www.linkedin.com/in/rafly-akval/)
  
👉 (MD) A120BSY2311 – Muhamad Fajar Nasrulloh 

  👨🏾‍💼[LinkedIn](https://www.linkedin.com/in/fajarnasrullah)


# Our Paths and Documentation 📂
Here is the list of our paths and its relevant documentation link:
## ⚙️ Machine Learning 
[Machine Learning Documentation](https://github.com/marlllllyn/HireXpat/tree/62101fa313bc40c07e6516b998c0152978da48f2/Machine%20Learning)
## 📱 Mobile Development 
[Mobile Development Documentation](https://github.com/marlllllyn/HireXpat/tree/62101fa313bc40c07e6516b998c0152978da48f2/Mobile%20Development)
## 🔗 Cloud Computing 
[Cloud Computing Documentation](https://github.com/marlllllyn/HireXpat/tree/62101fa313bc40c07e6516b998c0152978da48f2/Cloud%20Computing)






