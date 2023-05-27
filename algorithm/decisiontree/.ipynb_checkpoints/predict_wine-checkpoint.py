import pandas as pd
import numpy as np
from DecisionTreeRegressor import DecisionTreeRegressor
from sklearn.model_selection import train_test_split


def main():
    data = pd.read_csv("datasets/winequality-red.csv")
    X = data.iloc[ : , : -1].values
    Y = data.iloc[ : , -1].values.reshape(-1, 1)
    X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size = 0.3, random_state = 192)
    
    tree = DecisionTreeRegressor(max_depth = 3, min_sample_splits = 10)
    tree.fit(X_train, Y_train)
    tree.print_preorder_tree()
    
    fixed_acid = float(input("Enter fixed acidity: "))
    volatile_acid = float(input("Enter volatile acidity: "))
    citric_acid = float(input("Enter citric acid: "))
    residual_sugar = float(input("Enter residual sugar: "))
    chlorides = float(input("Enter chlorides: "))
    free_sulfur_dioxide = float(input("Enter free sulfur dioxide: "))
    total_sulfur_dioxide = float(input("Enter total sulfur dioxide : "))
    density = float(input("Enter density: "))
    ph = float(input("Enter pH: "))
    sulphates = float(input("Enter sulphates: "))
    alcohol = float(input("Enter alcohol: "))

    x = [[fixed_acid, volatile_acid, citric_acid, residual_sugar, chlorides, free_sulfur_dioxide, total_sulfur_dioxide, density, ph, sulphates, alcohol]]

    y = tree.predict(x)
    
    print(y)
    input()

if (__name__ == "__main__"):
    main()

    
	