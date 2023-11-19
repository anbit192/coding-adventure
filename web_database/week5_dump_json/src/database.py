import psycopg2

connection = psycopg2.connect (
    database="quan_ly_de_an",
    user="postgres",
    password="minhandz",
    host="localhost",
)

# cursor = connection.cursor()
# cursor.execute("SELECT * FROM nhanvien")
# print(cursor.fetchall())