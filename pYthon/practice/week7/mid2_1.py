import math


def getTop2gram(filename, n):
    '''
    Hàm trả lại danh sách (list) n 2-gram  có số lần nhiều nhất trong file văn bản filename.
    Trong file văn bản filename, mỗi từ phân cách nhau bởi dấu cách, một 2-gram là ghép của 2 từ đi liền nhau trong một dòng,
    ví dụ "a b c d" sẽ có các 2 gram là 'a b', 'b c' và 'c d'
    Danh sách kết quả được sắp xếp giảm dần theo thứ tự từ điển của các 2 gram.
    Nếu 2 2-gram có tần số xuất hiện bằng nhau thì ưu tiên 2-gram có thứ tự từ điển lớn hơn
    (ví dụ 'd a' > 'c a' vì vậy nếu 'd a' và 'c a' có cùng số lần xuất hiện thì lấy 'd a')
    Ví dụ, file văn bản có nội dung như sau:
    "
    a b c a a a b c d f d a d a f g s g h f s s a
    a g h b c e f g m n j s a r t y y u v z x k l a
    "

    danh sách các 2-gram cùng số lần xuất hiện sắp xếp theo số lần xuất hiện tăng dần, 2-gram tăng dần theo thứ tự từ điển như sau:

    [('b c', 3), ('s a', 2), ('g h', 2), ('f g', 2), ('d a', 2), ('a b', 2), ('a a', 2), ('z x', 1),
    ('y y', 1), ('y u', 1), ('x k', 1), ('v z', 1), ('u v', 1), ('t y', 1), ('s s', 1), ('s g', 1),
    ('r t', 1), ('n j', 1), ('m n', 1), ('l a', 1), ('k l', 1), ('j s', 1), ('h f', 1), ('h b', 1),
    ('g s', 1), ('g m', 1), ('f s', 1), ('f d', 1), ('e f', 1), ('d f', 1), ('c e', 1), ('c d', 1),
    ('c a', 1), ('a r', 1), ('a g', 1), ('a f', 1), ('a d', 1)]

    Như vậy với n = 5, kết quả là

   ['s a', 'g h', 'f g', 'd a', 'b c']


    Chú ý, file văn bản có nhiều dòng và không có ký tự unicode
    Nếu n > số 2gram thì kết quả là toàn bộ danh sách các 2gram.
    '''

    file = open(filename, "r")
    list = []
    for line in file:
        pairs = get_pair(line)

        for pair in pairs:
            list.append((pair))

    dict = {}

    for item in list:
        dict[item] = dict.get(item, 0) + 1

    sorted_dict = sorted(dict.items(), key=lambda x: (x[1], x[0]), reverse=True)
    # print(sorted_dict)

    result = [sorted_dict[i][0] for i in range(n)]
    # print(result)

    return sorted(result, key=lambda x: x, reverse=True)


def get_pair(s):
    temp = []

    tmp_list = s.split()
    for i in range(len(tmp_list) - 1):
        tmp_str = f"{tmp_list[i]} {tmp_list[i + 1]}"
        temp.append(tmp_str)
    return temp


# getTop2gram("C:\\Users\\Admin\\Desktop\\study\\coding-adventure\\pYthon\\practice\\week7\\pairs.txt", 5)


def getVector(filename, top2gram):
    '''
        Hàm này trả lại danh sách (list) số nguyên tương ứng với vector biểu diễn văn bản trong file filename.
        phần tử thứ i trong danh sách là số lần top2gram[i] xuất hiện trong văn bản.

        ví dụ văn bản là
        "
        a b c a a a b c d f d a d a f g s g h f s s a
        a g h b c e f g m n j s a r t y y u v z x k l a
        "


        top2gram = ['s a', 'g h', 'f g', 'd a', 'b c']

        kết quả là: [2, 2, 2, 2, 3]

    '''
    file = open(filename, "r")
    list = []
    for line in file:
        pairs = get_pair(line)

        for pair in pairs:
            list.append((pair))

    dict = {}

    for item in list:
        dict[item] = dict.get(item, 0) + 1

    count = [dict[top2gram[i]] for i in range(len(top2gram))]

    return count


# getVector("C:\\Users\\Admin\\Desktop\\study\\coding-adventure\\pYthon\\practice\\week7\\pairs.txt",
#           ['s a', 'g h', 'f g', 'd a', 'b c'])


def getDistance(u, v):
    '''
        Phương thức tính khoảng cách giữa 2 điểm u, v trên không gian vector

        u = (u1, u2,..., un)
        v = (v1, v2,..., vn)


        ví dụ với u = [1,2,3,4], v = [1,2,1,1], kết quả làm tròn đến 5 chữ số là: 3.60555
    '''
    sum = 0
    for i in range(len(u)):
        sum += (u[i] - v[i]) ** 2

    return round(math.sqrt(sum), 5)


# u = [1,2,3,4]
# v = [1,2,1,1]
# res = getDistance(u, v)
# print(round(res, 5))

def coshTaylor(x, e):
    '''
     Viết chương trình tính sinh(x) theo khai triển Taylor,
     trong đó e là sai số để xác định  thời điểm dừng thuật toán,
     Thuật toán dừng lại tại số hạng Pi nếu |Pi - Pi-1| <= e

     ví dụ x = 5.5, e = 0.00001 kết quả làm tròn đến 5 chữ số là: 122.34801
          nhưng với e = 0.5     kết quả làm tròn đến 5 chữ số là: 92.69794

    '''
    cosh = 1
    temp = 1
    temp2 = 0
    i = 1

    while (True):
        temp *= (x / i)
        if (i % 2 == 0):
            cosh += temp

            if (abs(temp2 - temp) <= e):
                break
            temp2 = temp
        i += 1

    return round(cosh, 5)


# r = coshTaylor(6, 0.5)
# print(r)


'''
    Chú ý, các phương thức sẽ được gọi đến để chấm điểm, 
    do vậy bài nộp của sinh viên cần phải bỏ hết (hoặc comment #) các lệnh in ra màn hình

'''


def testDemo():
    print(getTop2gram('text.txt', 5))
    print(getVector('text.txt', getTop2gram('text.txt', 5)))
    print(round(getDistance([1, 2, 3, 4], [1, 2, 1, 1]), 5))
    print(round(coshTaylor(5.5, 0.5), 5))


'''
Bỏ comment lệnh testDemo() dưới đây để chạy chương trình, và comment lại lệnh đó khi nộp bài
'''
# testDemo()
