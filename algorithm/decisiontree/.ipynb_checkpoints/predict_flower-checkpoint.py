import pandas as pd
import numpy as np
from DecisionTreeClassifier import DecisionTreeClassifier
from sklearn.model_selection import train_test_split


def main():
    data = pd.read_csv("datasets/iris.csv")
    X = data.iloc[ : , : -1].values
    Y = data.iloc[ : , -1].values.reshape(-1, 1)
    X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size = 0.3, random_state = 192)
    
    tree = DecisionTreeClassifier()
    tree.fit(X_train, Y_train)
    tree.print_preorder_tree()
    
    sepal_length = float(input("Nhập sepal length (Độ dài đài hoa): "))
    sepal_width = float(input("Nhập sepal width (Độ rộng đài hoa): "))
    petal_length = float(input("Nhập petal length (Độ dài cánh hoa): "))
    petal_width = float(input("Nhập petal width (Độ rộng cánh hoa): "))

    x = [[sepal_length, sepal_width, petal_length, petal_width]]
    
    y = tree.predict(x)
    
    print(y)
    input()
	

if (__name__ == "__main__"):
    main()