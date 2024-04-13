
import pandas as pd
import numpy as np


class Node:
    def __init__(self, feature=None, value=None, label=None, branches=None):
        self.feature = feature
        self.value = value
        self.label = label
        self.branches = branches


def entropy(data):
    label_freq = data.iloc[:, -1].value_counts(normalize=True)
    print(label_freq)
    entropy = 0
    for p in label_freq:
        entropy += -p * np.log2(p)
    return entropy

data = pd.read_csv("datasets/playing.csv")
print(data['Decision'])
entropy(data)



def information_gain(data, feature):

    total_entropy = entropy(data)
    values, counts = np.unique(data[feature], return_counts=True)
    weighted_entropy = 0
    for i in range(len(values)):
        p = counts[i]/np.sum(counts)
        weighted_entropy += p * entropy(data.where(data[feature] == values[i]).dropna())
    information_gain = total_entropy - weighted_entropy
    return information_gain



data = pd.read_csv("datasets/playing.csv")
features = list(data.columns[1:-1])
for i in features:
    gain = information_gain(data,i)
    print(f"{i}: {gain}")



def id3(data, features, target):
    if len(np.unique(data[target])) <= 1:
        return Node(label=data[target].iloc[0])
    elif len(features) == 0:
        mode_target = data[target].mode()[0]
        return Node(label=mode_target)
    else:
        best_gain = 0
        best_feature = ""
        for i in features:
            if information_gain(data, i) > best_gain:
                best_gain = information_gain(data, i)
                best_feature = i
        tree = Node(feature=best_feature)
        for value in np.unique(data[best_feature]): 
            sub_data = data.where(data[best_feature] == value).dropna()
            print(sub_data)
            sub_tree = id3(sub_data, [x for x in features if x != best_feature], target)
            tree.branches = tree.branches or {}
            tree.branches[value] = sub_tree
        return tree


def print_tree(node, depth=0):
    if node.label is not None:
        print("--"*depth, "Leaf:", node.label)
    else:
        print("--"*depth, node.feature)
        for value, subtree in node.branches.items():
            print("  "*(depth+1), value)
            print_tree(subtree, depth+2)



def predict(tree, new_data):
    try:
        if tree.label is not None:
            return tree.label
        else:
            value = new_data[tree.feature]
            subtree = tree.branches[value]
            return predict(subtree, new_data)
    except:
        print("Dữ liệu sai!")
    



data = pd.read_csv("datasets/playing.csv")
data



target = "Decision"
features = list(data.columns[1:-1])
tree = id3(data, features, target)
new_data = {"outlook": "rainy", "temperature": "hot",
            "humidity": "normal", "windy": "weak"}
prediction = predict(tree, new_data)
print(f"Kết quả dự đoán: {prediction}")



print_tree(tree)

