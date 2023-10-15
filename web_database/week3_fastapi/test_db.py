from fastapi.templating import Jinja2Templates
from fastapi import FastAPI
import psycopg2

app = FastAPI()

# Connect to postgresql
db_connect = psycopg2.connect(
    database="CSDL_Hang_Khong",
    user="postgres",
    password="minhandz",
    host="127.0.0.1"
)

cursor_obj = db_connect.cursor()
cursor_obj.execute("SELECT * FROM nhanvien")
result = cursor_obj.fetchall()

for row in result:
    print(row)


templates = Jinja2Templates(directory="templates")


@app.get("/")
def hello_world():
    return {"msg": "HelloWorld"}


@app.get("/db/tables")
def get_tables():
    cursor_obj.execute(
        "SELECT table_name FROM information_schema.tables WHERE table_schema = 'public';")
    res = cursor_obj.fetchall()
    list = []
    for row in res:
        list.append(row[0])
    return list


@app.get("/db/tables/{table_name}")
def get_table(table_name):
    q = f"""
    SELECT * FROM {table_name}
    """
    cursor_obj.execute(q)
    res = cursor_obj.fetchall()
    list = [row for row in res]

    return list


@app.get("/db/tables/{table_name}/fields")
def get_fields(table_name):
    q = f"""
    SELECT column_name 
    FROM information_schema.columns
    WHERE table_name = '{table_name}' 
    ORDER BY ordinal_position;
    """
    cursor_obj.execute(q)
    res = cursor_obj.fetchall()
    list = [row[0] for row in res]

    return list
