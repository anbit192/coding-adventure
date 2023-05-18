import pandas as pd
import numpy as np
from DecisionTreeClassifier import DecisionTreeClassifier
from sklearn.model_selection import train_test_split

def main():
    data = pd.read_csv("datasets/airfoil_self_noise.csv")
    X = data.iloc[ : , : -1].values
    Y = data.iloc[ : , -1].values.reshape(-1, 1)
    X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size = 0.3, random_state = 192)
    
    tree = DecisionTreeClassifier(min_sample_splits = 5, max_depth = 10)
    tree.fit(X_train, Y_train)
    tree.print_preorder_tree()
    
    x1 = float(input("Enter x1: "))
    x2 = float(input("Enter x2: "))
    x3 = float(input("Enter x3: "))
    x4 = float(input("Enter x4: "))
    x5 = float(input("Enter x5: "))
    
    x = [[x1, x2, x3, x4, x5]]
    y = tree.predict(x)
    
    print(y)
    
    input()
    
    
if __name__ == "__main__":
    main()