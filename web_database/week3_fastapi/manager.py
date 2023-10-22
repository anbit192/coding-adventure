from db import *
from tables.chuyenbay import *
from tables.chungnhan import *
from tables.maybay import *
from tables.nhanvien import *

from fastapi import FastAPI


app = FastAPI()

def create_tables():
    create_table_chuyenbay()
    create_table_maybay()
    create_table_nhanvien()
    create_table_chungnhan()
    db_connect.commit()

    

def create_table_chuyenbay():
    q = """
        CREATE TABLE IF NOT EXISTS CHUYENBAY (
            MaCB SERIAL PRIMARY KEY,
            GaDi VARCHAR(255),
            GaDen VARCHAR(255),
            DoDai INT,
            GioDi TIMESTAMP,
            GioDen TIMESTAMP,
            ChiPhi DECIMAL(10, 2)
        );
    """

    cursor_obj.execute(q)


def create_table_maybay():
    q = """
        CREATE TABLE IF NOT EXISTS MAYBAY (
            MaMB SERIAL PRIMARY KEY,
            Loai VARCHAR(255),
            TamBay INT
        );
    """

    cursor_obj.execute(q)


def create_table_nhanvien():
    q = """
        CREATE TABLE IF NOT EXISTS NHANVIEN (
            MaNV SERIAL PRIMARY KEY,
            Ten VARCHAR(255),
            Luong DECIMAL(10, 2)
        );
    """

    cursor_obj.execute(q)


def create_table_chungnhan():
    q = """
        CREATE TABLE IF NOT EXISTS CHUNGNHAN (
            MaNV INT REFERENCES NHANVIEN(MaNV),
            MaMB INT REFERENCES MAYBAY(MaMB),
            PRIMARY KEY (MaNV, MaMB)
        );
    """

    cursor_obj.execute(q)


def main():
    create_tables()

@app.get("/")
def hello_world():
    return "HELLO WORLD"


@app.get("/chuyenbay/{MaCB}")
async def get_chuyenbay(MaCB):
    return ChuyenBay.get_data(MaCB)

@app.post("/chuyenbay/post")
async def create_chuyenbay(item: "ChuyenBay"):
    return ChuyenBay.create_data(item)

@app.put("/chuyenbay/put")
async def update_chuyenbay(id, item: "ChuyenBay"):
    return ChuyenBay.put_data(id, item)

@app.delete("/chuyenbay/delete")
async def del_chuyenbay(id):
    return ChuyenBay.del_data(id)


if __name__ == "__main__":
    import uvicorn
    uvicorn.run(app, host="127.0.0.1", port=8000)
    main()
