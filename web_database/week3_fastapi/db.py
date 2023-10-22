
import psycopg2

# Connect to postgresql
db_connect = psycopg2.connect(
    database="CSDL_Hang_Khong",
    user="postgres",
    password="minhandz",
    host="127.0.0.1"
)

cursor_obj = db_connect.cursor()
# cursor_obj.execute("SELECT * FROM nhanvien")
# result = cursor_obj.fetchall()

# for row in result:
#     print(row)


# templates = Jinja2Templates(directory="templates")
