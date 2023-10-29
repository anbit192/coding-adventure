import psycopg2

connect = psycopg2.connect (
    database="quan_ly_de_an",
    user="postgres",
    password="minhandz",
    host="127.0.0.1"
)

cursor = connect.cursor()
cursor.execute("SELECT * FROM congviec")
res = cursor.fetchall()

for row in res:
    print(row)