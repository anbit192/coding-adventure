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



#chuyenbay 
@app.get("/chuyenbay/{MaCB}")
async def get_chuyenbay(MaCB):
    return ChuyenBay.get_data(MaCB)

@app.post("/chuyenbay/post", response_model=ChuyenBay)
async def create_chuyenbay(item: "ChuyenBay"):
    return ChuyenBay.create_data(item)

@app.put("/chuyenbay/put/{id}")
async def update_chuyenbay(id, item: "ChuyenBay"):
    return ChuyenBay.put_data(id, item)

@app.delete("/chuyenbay/delete/{id}")
async def del_chuyenbay(id):
    return ChuyenBay.del_data(id)


#maybay
@app.get("/maybay/{id}")
async def get_maybay(id):
    return MayBay.get_data(id)

@app.post("/maybay/post")
async def create_maybay(item: "MayBay"):
    return MayBay.create_data(item)

@app.put("/maybay/put/{id}")
async def update_maybay(id, item: "MayBay"):
    return MayBay.put_data(id, item)

@app.delete("/maybay/delete/{id}")
async def del_maybay(id):
    return MayBay.del_data(id)

#nhanvien
@app.get("/nhanvien/{id}")
async def get_nhanvien(id):
    return NhanVien.get_data(id)

@app.post("/nhanvien/post")
async def create_nhanvien(item: "NhanVien"):
    return NhanVien.create_data(item)

@app.put("/nhanvien/put/{id}")
async def update_nhanvien(id, item: "NhanVien"):
    return NhanVien.put_data(id, item)

@app.delete("/nhanvien/delete/{id}")
async def del_nhanvien(id):
    return NhanVien.del_data(id)

#chungnhan
@app.get("/chungnhan/{id}")
async def get_chungnhan(id):
    return ChungNhan.get_data(id)

@app.post("/chungnhan/post")
async def create_chungnhan(item: "ChungNhan"):
    return ChungNhan.create_data(item)

@app.put("/chungnhan/put/{id}")
async def update_chungnhan(id, item: "ChungNhan"):
    return ChungNhan.put_data(id, item)

@app.delete("/chungnhan/delete/{id}")
async def del_chungnhan(id):
    return ChungNhan.del_data(id)



if __name__ == "__main__":
    import uvicorn
    uvicorn.run(app, host="127.0.0.1", port=8000)
    main()
