import pandas as pd
import numpy as np

class Node():
    def __init__(self, feature_index = None, threshold = None, left = None, right = None, information_gain = None, value = None):
        # decision node
        self.feature_index = feature_index
        self.threshold = threshold
        self.left = left
        self.right = right
        self.information_gain = information_gain
        
        #leaf node
        self.value = value     
        
        

class DecisionTreeClassifier():
    def __init__(self, min_sample_splits = 2, max_depth = 2):
        #Khởi tạo root
        self.root = None
        
        #Điều kiện dừng của cây
        self.min_sample_splits = min_sample_splits 
        self.max_depth = max_depth
    
    
    def fit(self, X, Y):
        # train cây
        dataset = np.concatenate((X, Y), axis = 1)
        self.root = self.build_tree(dataset)
        
        
    def calculate_info_gain(self, parent, left_child, right_child, mode = "entropy"):
        
        #Trọng số (weight): mối liên hệ giữa số quan sát của tập con với tập cha
        weight_left = len(left_child) / len(parent)
        weight_right = len(right_child) / len(parent)
        
        if (mode == "gini"):
            gini_index_left = self.gini_index(left_child)
            gini_index_right = self.gini_index(right_child)
            gini_index_parent = self.gini_index(parent)
            
            gain = gini_index_parent - (weight_left * gini_index_left + weight_right * gini_index_right)
        else:
            entropy_parent = self.entropy(parent)
            entropy_left = self.entropy(left_child)
            entropy_right = self.entropy(right_child)
            
            gain = entropy_parent - (weight_left * entropy_left + weight_right * entropy_right)
            
        return gain
    
    
    def entropy(self, y):
        data_labels = np.unique(y) # Lấy ra các giá trị ko trùng lặp của data (1, 1, 1, 0) => (1, 0)
        entropy = 0
        
        for label in data_labels:
            p_label = len(y[y == label]) / len(y) # Xác suất xuất hiện y = label trong tập y (1, 1, 1, 0) => p_1 = 3/4
            entropy += ( - p_label * np.log2(p_label) )
        
        return entropy
    
    def gini_index(self, y): # Tương tự như hàm entropy
        data_labels = np.unique(y)
        gini = 0
        
        for label in data_labels:
            p_label = len(y[y == label]) / len(y)
            gini += p_label**2
        
        return 1 - gini
    
    
    def build_tree(self, dataset, current_depth = 0):
        # Tách biến thuộc tính và mục tiêu làm 2 biến X, Y
        X = dataset[ : , : -1] # Chọn tất cả các hàng và cột trừ cột cuối cùng (Ko có cột type)
        Y = dataset[ : , -1] # Chọn tất cả hàng nhưng chỉ lấy cột cuối cùng (Cột type)
        
        # Lấy ra số lượng quan sát và số biến thuộc tính (Sử dụng np.shape(data))
        num_samples, num_features = np.shape(X) # np.shape(X) trả về số hàng và cột của X 
        
        # Tiếp tục tách cây nếu như thỏa mãn điều kiện dưới
        if (num_samples >= self.min_sample_splits and current_depth <= self.max_depth):
            
            #Tìm ra cách tách tốt nhất
            best_split = self.get_best_split(dataset, num_samples, num_features)
            
            #Kiểm tra xem information gain có lớn hơn 0 hay ko (= 0 thì node đó sẽ chứa cùng 1 kiểu dữ liệu => leaf node)
            if (best_split["information_gain"] > 0):
                
                left_tree = self.build_tree(best_split["dataset_left"], current_depth + 1)
                right_tree = self.build_tree(best_split["dataset_right"], current_depth + 1)
                
                #Trả về decision node
                return Node(best_split["feature_index"], best_split["threshold"], left_tree, right_tree, best_split["information_gain"])
            
        # Gặp điều kiện dừng => Node sẽ trở thành leaf node
        
        ## Tính toán giá trị leaf node
        leaf_value = self.calculate_leaf_value(Y)

        # Trả về leaf node 
        return Node(value = leaf_value)
    
    
    def get_best_split(self, dataset, num_samples, num_features):
        # Tạo ra một dictionary để lưu giá trị
        best_split = {} 
        
        # Khởi tạo max information gain
        max_information_gain = -1 
        
        # Duyệt hết các biến thuộc tính (feature)
        for feature_index in range(num_features):
            feature_values = dataset[ : , feature_index] # Lấy ra tất cả các hàng ở cột thứ feature_index
            # => thu được một mảng các giá trị của biến feature thứ index
            
            #Coi mỗi giá trị của biến feature là một threshold (ngưỡng giá trị) để chia dữ liệu
            unique_thresholds = np.unique(feature_values) # Loại bỏ các giá trị trùng lặp
            
            #Duyệt tất cả các giá trị của feature (thresholds) có trong data
            for threshold in unique_thresholds:
                #Tách dataset thành 2 phần tại giá trị threshold
                dataset_left, dataset_right = self.split(dataset, feature_index, threshold)
                
                #Kiểm tra xem 2 bộ dataset vừa tách ra có null hay không
                if (len(dataset_left) > 0 and len(dataset_right) > 0):
                    
                    # Lấy ra các biến mục tiêu theo 3 bộ data lần lượt
                    y = dataset[ : , -1] #biến mục tiêu gốc
                    left_y = dataset_left[ : , -1] #biến mục tiêu dataset_left
                    right_y = dataset_right[ : , -1] #biến mục tiêu dataset_right
                    
                    #Tính toán information gain
                    current_information_gain = self.calculate_info_gain(y, left_y, right_y, "gini")
                    
                    #update best split nếu thỏa mãn điều kiện dưới
                    if (current_information_gain > max_information_gain):
                        best_split["feature_index"] = feature_index
                        best_split["threshold"] = threshold
                        best_split["dataset_left"] = dataset_left
                        best_split["dataset_right"] = dataset_right
                        best_split["information_gain"] = current_information_gain
                        
                        #update max information gain
                        max_information_gain = current_information_gain
                
        return best_split
    
    
    def split(self, dataset, feature_index, threshold):
        
        rows_left = []
        rows_right = []
        
        # Tách dataset của biến feature thứ index thành 2 phần dựa theo threshold
        for row in dataset:
            if (row[feature_index] <= threshold):
                rows_left.append(row)
            else:
                rows_right.append(row)
        
        #convert từ array sang np.array
        dataset_left = np.array(rows_left)
        dataset_right = np.array(rows_right)
        
        return dataset_left, dataset_right
    
    
    def calculate_leaf_value(self, Y):
        Y = list(Y)
        return max(Y, key = Y.count)
                
    
    def print_preorder_tree(self, tree = None, indent = "   "):
        if (not tree):
            tree = self.root
        
        if (tree.value is not None):
            print(tree.value)
        else:
            print("X_" + str(tree.feature_index), "<=", tree.threshold,"?", tree.information_gain)
            print("%sleft: " %(indent), end = "")
            self.print_preorder_tree(tree.left, indent + indent)
            print("%sright: " %(indent), end = "")
            self.print_preorder_tree(tree.right, indent + indent)
            
    def predict(self, X):
        predictions = [self.make_prediction(x, self.root) for x in X]
        return predictions
    
    
    def make_prediction(self, x, tree):
        
        if (tree.value != None):
            return tree.value
        
        feature_value = x[tree.feature_index]
        if (feature_value <= tree.threshold):
            return self.make_prediction(x, tree.left)
        else:
            return self.make_prediction(x, tree.right)