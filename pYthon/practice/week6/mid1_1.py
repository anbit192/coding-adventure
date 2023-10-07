import math


def getTopWord(filename, n):
    '''
    Hàm trả lại danh sách (list) n từ có số lần nhiều nhất trong file văn bản filename.
    Trong file văn bản filename, mỗi từ phân cách nhau bởi dấu cách
    Danh sách kết quả được sắp xếp giảm dần theo thứ tự từ điển của các từ.
    Nếu 2 từ có tần số xuất hiện bằng nhau thì ưu tiên từ có thứ tự từ điển lớn hơn 
    (ví dụ 'd' > 'c' vì vậy nếu 'd' và 'c' có cùng số lần xuất hiện thì lấy 'd')
    Ví dụ, file văn bản có nội dung như sau: 
    "
    a b c a a a b c d f d a d a f g s g h f s s a
    a g h b c e f g m n j s a r t y y u v z x k l a   
    "
    
    danh sách các từ cùng số lần xuất hiện sắp xếp theo số lần xuất hiện giảm dần, từ giảm dần theo thứ tự từ điển như sau:
    
    [('a', 10), ('s', 4), ('g', 4), ('f', 4), ('d', 3), ('c', 3), ('b', 3), ('y', 2)
    , ('h', 2), ('z', 1), ('x', 1), ('v', 1), ('u', 1), ('t', 1), ('r', 1), ('n', 1)
    , ('m', 1), ('l', 1), ('k', 1), ('j', 1), ('e', 1)]
    
    Như vậy với n = 6, kết quả là
    
    ['s', 'g', 'f', 'd', 'c', 'a']
    
    
    Chú ý, file văn bản có nhiều dòng và không có ký tự unicode
    Nếu n > số từ thì kết quả là toàn bộ danh sách các từ.
    '''

    file = open(filename, "r")
    list = []
    for line in file:
        items = line.split()
        for i in items:
            list.append(i)
    dict = {}
    for i in list:
        dict[i] = dict.get(i, 0) + 1

    sorted_dict = sorted(dict.items(), key=lambda x: (x[1], x[0]), reverse=True)
    if (n >= len(sorted_dict)):
        n = len(sorted_dict)
    list_keys = [sorted_dict[i][0] for i in range(n)]

    return sorted(list_keys, key=lambda x: x, reverse=True)


def getVector(filename, topword):
    '''
        Hàm này trả lại danh sách (list) số nguyên tương ứng với vector biểu diễn văn bản trong file filename.
        phần tử thứ i trong danh sách là số lần từ topword[i] xuất hiện trong văn bản.
        
        ví dụ văn bản là 
        "
        a b c a a a b c d f d a d a f g s g h f s s a
        a g h b c e f g m n j s a r t y y u v z x k l a   
        "        
        
        
        topword = ['s', 'g', 'f', 'd', 'a']
        
        kết quả là: [4, 4, 4, 3, 10]
        
    '''
    file = open(filename, "r")
    list = []
    for line in file:
        items = line.split()
        for i in items:
            list.append(i)

    dict = {}
    for i in list:
        dict[i] = dict.get(i, 0) + 1

    count_chars = [dict[item] for item in topword]

    return count_chars


def getCosineSim(u, v):
    '''
        Phương thức tính cosine góc tạo bởi hai vector u, v
        
        cosine(u,v) = (u.v)/(||u||x||v||)
        
        ví dụ với u = [1,2,3,4], v = [1,2,1,1], kết quả làm tròn đến 5 chữ số là: 0.82808
    '''
    cosine = dot_product(u, v) / (magnitude(u) * magnitude(v))

    return round(cosine, 5)


def dot_product(u, v):
    sum = 0
    for i in range(len(u)):
        sum += (u[i] * v[i])

    return sum


def magnitude(u):
    sum = 0
    for i in range(len(u)):
        sum += (u[i] ** 2)

    return math.sqrt(sum)


def sinhTaylor(x, e):
    '''
     Viết chương trình tính sinh(x) theo khai triển Taylor,
     trong đó e là sai số để xác định  thời điểm dừng thuật toán,
     Thuật toán dừng lại tại số hạng Pi nếu |Pi - Pi-1| <= e 
     
     ví dụ x = 5.5, e = 0.00001 kết quả làm tròn đến 5 chữ số là: 122.34392
          nhưng với e = 0.5     kết quả làm tròn đến 5 chữ số là: 122.34289
     
    '''
    sum = 0
    i = 1
    temp = 1
    temp2 = 0
    while (True):
        temp *= x / i
        if (i % 2 != 0):
            sum += temp
            if (abs(temp2 - temp) <= e):
                break
        temp2 = temp
        i += 1

    return sum


'''
    Chú ý, các phương thức sẽ được gọi đến để chấm điểm, 
    do vậy bài nộp của sinh viên cần phải bỏ hết (hoặc comment #) các lệnh in ra màn hình
     
'''


def testDemo():
    print(getTopWord('text.txt', 5))
    print(getVector('text.txt', getTopWord('text.txt', 5)))

    print(round(getCosineSim([1, 2, 3, 4], [1, 2, 1, 1]), 5))

    print(round(sinhTaylor(5.5, 0.5), 5))


'''
Bỏ comment lệnh testDemo() dưới đây để test chương trình, và comment lại lệnh đó khi nộp bài
'''
# testDemo()
