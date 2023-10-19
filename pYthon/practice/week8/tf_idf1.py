import math
import os


class Doc:
    '''
    Lớp mô tả một đối tượng văn bản, lớp này có 1 thuộc tính là wordCount kiểu từ điển

    với key là các từ trong văn bản và value là số lần các từ đó xuất hiện trong văn bản

    CHÚ Ý: Để cho đơn giản, mỗi từ trong văn bản được phân cách bởi dấu cách, các từ phân biệt hoa thường...

    Nói chung 2 từ A và B mà A == B nhận giá trị false là khác nhau.
    Ví dụ từ "anh" và "Anh" là khác nhau
          từ "anh." và "anh" là khác nhau

    '''

    def __init__(self, filename):
        self.wordCount = dict()

        self.loadWordCountFromFile(filename)

    def loadWordCountFromFile(self, filename):
        '''
        Hàm thực hiện đọc vào file filename và đếm tần suất xuất hiện các từ rồi đưa vào wordCount

        Hàm này được gọi đến trong hàm dựng, do vậy bắt buộc phải viết đúng hàm này, nếu không các hàm khác sẽ không được
        chấm điểm

        '''

        file = open(filename, "r", encoding="utf-8")
        list_words = []

        for line in file:
            for word in line.strip().split():
                list_words.append(word)

        for item in list_words:
            self.wordCount[item] = self.wordCount.get(item, 0) + 1


class TFIDF:
    '''
        Lớp mô tả việc tính chỉ số TFIDF cho các từ trong văn bản dựa trên kho văn bản
        Lớp này có 2 thuộc tính là corpusPath và data, trong đó:
        - corpusPath là đường dẫn tới thư mục chứa các tệp văn bản
        - data là một từ điển với key là tên các file văn bản, và value là các đối tượng Doc tương ứng
        với key

    '''

    def __init__(self, corpusPath):
        self.corpusPath = corpusPath

        self.data = dict()

        self.loadCorpus(corpusPath)

    def loadCorpus(self, corpusPath):
        '''

        Hàm thực hiện đọc các file văn bản trong thư mục corpusPath, và xây dựng các đối tượng

        Doc tương ứng và đưa vào data

         Hàm nà được gọi đến trong hàm dựng, do vậy bắt buộc phải viết đúng hàm này, nếu không các hàm khác sẽ không được
        chấm điểm

        '''
        file_names = os.listdir(corpusPath)
        for name in file_names:
            # path_name = corpusPath + "/" + name
            path_name = corpusPath + "\\" + name

            doc = Doc(path_name)

            self.data[name] = doc

    def tf(self, w, d: "Doc"):
        '''
        Tính và trả về chỉ số tf của từ w trong Doc d (d là 1 đối tượng Doc)
        Công thức tính tf(w,d) như sau:
        - Gọi tfw là số lần w xuất hiện trong d (ví dụ tfw = 3)
        - Gọi tfm là số lần 1 từ bất kỳ xuất hiện nhiều nhất trong d (ví dụ tfm = 6)
        - khi đó tf(w,d) = tfw/tfm (ví dụ 3/6 = 0.5)

        '''

        sorted_dict = sorted(d.wordCount.items(), key=lambda x: x[1], reverse=True)
        tfw = 0
        if (w in d.wordCount):
            tfw = d.wordCount[w]

        tfm = sorted_dict[0][1]

        return tfw / tfm

    def idf(self, w):
        '''
        Tính và trả chỉ số idf của từ w trong kho văn bản data
        Chỉ số idf của w là idf(w) được tính như sau:
        - Gọi N là số văn bản có trong kho data (ví dụ N = 10)
        - Gọi m là số văn bản trong kho data có chứa từ w (ví dụ m = 3)
        - khi đó: idf(w) = log(N/(1+m)) (ví dụ idf(w) = log(10/(1+3)) = 0.9162907318741551)

        CHÚ Ý DÙNG math.log để tính log
        '''

        N = len(self.data)
        m = 0

        for file_name in self.data.keys():

            doc: "Doc" = self.data[file_name]
            dict = doc.wordCount
            if (w in dict):
                if (dict[w] > 0):
                    m += 1
                    continue

        return math.log(N / (1 + m))

    def tfidf(self, w, d):
        '''
        Hàm tính và trả lại chỉ số tfidf của từ w trong văn bản d (d là một đối tượng Doc) trên kho dữ liệu data
        Chỉ số tfidf(w,d) được tính như sau:
        tfidf(w, d) = tf(w,d) * idf(w)
        '''
        return self.tf(w, d) * self.idf(w)

    def getKTopicWordFromCopus(self, k):
        '''
        Hàm thực hiện tính và trả lại danh sách k từ khác nhau có chỉ số tfidf cao nhất trong kho văn bản data

        Danh sách được sắp xếp tăng dần theo thứ tự từ điển mặc định (không cần sắp xếp theo tiếng Việt)

        CHÚ Ý: 2 từ giống nhau trong 2 văn bản khác nhau có thể cùng có chỉ số tfidf trong top k
        từ có chỉ số tfidf cao nhất, tuy nhiên kết quả chỉ lấy 1 từ
        (có nghĩa là trong danh sách kết quả, k từ đôi một khác nhau)
        '''

        docs = [self.data[key] for key in self.data.keys()]
        word_list = []
        tfidfs = []
        for doc in docs:
            words = doc.wordCount.keys()

            for word in words:
                word_list.append(word)
                tfidfs.append(self.tfidf(word, doc))

        new_dict = {}
        for i in range(len(word_list)):
            new_dict[word_list[i]] = tfidfs[i]

        sorted_tuples = sorted(new_dict.items(), key = lambda x: x[1], reverse=True)
        result = [item[0] for item in sorted_tuples]
        
        
        return result[:k]







def main():
    dir = "C:\\Users\\Admin\\Desktop\\study\\coding-adventure\\pYthon\\practice\\week8\\txt_folder"
    obj = TFIDF(dir)

    test_doc = obj.data["text0.txt"]
    print(obj.tf("an", test_doc))
    print(obj.idf("an"))
    print(obj.tfidf("an", test_doc))


main()
