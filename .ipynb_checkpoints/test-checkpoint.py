from matplotlib import pyplot as plt
from sklearn import datasets,tree
from sklearn.tree import DecisionTreeClassifier, DecisionTreeRegressor
import numpy as np

iris = datasets.load_iris()
x = iris.data
y = iris.target

clf_tree = DecisionTreeRegressor()
model = clf_tree.fit(x, y)

fig = plt.figure(figsize=(25,20))


_ = tree.plot_tree(clf_tree, feature_names=iris.feature_names, class_names=iris.target_names, filled=True)
fig.savefig("decistion_tree2.png")