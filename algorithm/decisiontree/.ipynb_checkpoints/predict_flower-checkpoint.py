import pandas as pd
import numpy as np
from DecisionTreeClassifier import DecisionTreeClassifier
from sklearn.model_selection import train_test_split


def main():
    data = pd.read_csv("datasets/iris.csv")
    X = data.iloc[ : , : -1].values
    Y = data.iloc[ : , -1].values.reshape(-1, 1)
    X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size = 0.3, random_state = 192) #Chia train, test
    
    #Train cay
    tree = DecisionTreeClassifier()
    tree.fit(X_train, Y_train)
    
    #nhap du lieu moi
    sepal_length = float(input("Enter sepal length : "))
    sepal_width = float(input("Enter sepal width : "))
    petal_length = float(input("Enter petal length : "))
    petal_width = float(input("Enter petal width : "))

    x = [[sepal_length, sepal_width, petal_length, petal_width]]
    
    y = tree.predict(x)
    
    print(y)
    input()
	

if (__name__ == "__main__"):
    main()