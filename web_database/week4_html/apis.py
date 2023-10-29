from connect import *
from fastapi import FastAPI, Request, Form, HTTPException
from fastapi.responses import *
from fastapi.templating import Jinja2Templates
from typing import Union

app = FastAPI()
templates = Jinja2Templates(directory="templates")

@app.get("/", response_class=HTMLResponse)
def hello_world(request: Request):
    return templates.TemplateResponse("index.html", {"request":request})


# ======================================================== Cong viec ==========================================================
@app.get("/congviec", response_class=HTMLResponse)
def get_congviec(request: Request):
    cursor.execute("SELECT * FROM congviec")
    data = cursor.fetchall()
    return templates.TemplateResponse("congviec/congviec.html", {"request": request, "data":data})

# display add_congviec form
@app.get("/congviec/add", response_class=HTMLResponse)
async def add_congviec_view(request:Request):
    return templates.TemplateResponse("congviec/add_congviec.html", {"request":request})

@app.post("/congviec/add")
async def add_congviec(
    ma_de_an:int = Form(),
    stt:str = Form(),
    ten_cong_viec: str = Form()
):
    try:
        q = """
            INSERT INTO congviec VALUES (%s, %s, %s)
        """
        values = (ma_de_an, stt, ten_cong_viec)

        cursor.execute(q, values)
        connect.commit()

        return "Added!"
    
    except psycopg2.Error as e:
        connect.rollback()
        raise HTTPException(status_code=500, detail=str(e))
    

@app.get("/congviec/update", response_class=HTMLResponse)
async def update_congviec_view(request:Request):
    return templates.TemplateResponse("/congviec/update_congviec.html", {"request":request})

@app.post("/congviec/update")
async def update_congviec(
    ma_de_an:int = Form(),
    stt:str = Form(),
    ten_cong_viec:str = Form()
):
    try:
        q = """
            UPDATE congviec
            SET (stt, ten_cong_viec) = (%s, %s)
            WHERE mada = %s
        """
        values = (stt, ten_cong_viec, ma_de_an)

        cursor.execute(q, values)
        connect.commit()

        return "Updated!"
    
    except psycopg2.Error as e:
        connect.rollback()
        raise HTTPException(status_code=500, detail=str(e))
    
@app.get("/congviec/delete", response_class=HTMLResponse)
async def delete_congviec_view(request:Request):
    return templates.TemplateResponse("congviec/delete_congviec.html", {"request":request})

@app.post("/congviec/delete")
async def delete_congviec(ma_de_an:int = Form()):
    try:
        q = f"""
            DELETE FROM congviec
            WHERE mada = {ma_de_an}
        """

        cursor.execute(q)
        connect.commit()

        return "Deleted!"
    
    except psycopg2.Error as e:
        connect.rollback()
        raise HTTPException(status_code=500, detail=str(e))   
    

# ======================================================== De an ==========================================================



@app.get("/dean", response_class=HTMLResponse)
def get_dean(request: Request):
    cursor.execute("SELECT * FROM dean")
    data = cursor.fetchall()
    dict = {
        "request":request,
        "data":data
    }
    print(data)
    return templates.TemplateResponse("dean/dean.html", dict)

# ======================================================== Nhan vien ==========================================================

@app.get("/nhanvien", response_class=HTMLResponse)
def get_nhanvien(request:Request):

    cursor.execute("SELECT * FROM nhanvien")
    data = cursor.fetchall()

    dict = {
        "request":request,
        "data":data
    }

    return templates.TemplateResponse("nhanvien/nhanvien.html", dict)

# ======================================================== Dia diem phong ==========================================================


@app.get("/diadiemphong", response_class=HTMLResponse)
def get_nhanvien(request:Request):
    cursor.execute("SELECT * FROM diadiem_phg")
    data = cursor.fetchall()

    dict = {
        "request":request,
        "data":data
    }

    return templates.TemplateResponse("diadiem_phong/diadiem_phong.html", dict)

# ======================================================== Phan cong ==========================================================

@app.get("/phancong", response_class=HTMLResponse)
def get_nhanvien(request:Request):
    cursor.execute("SELECT * FROM phancong")
    data = cursor.fetchall()

    dict = {
        "request":request,
        "data":data
    }

    return templates.TemplateResponse("phancong/phancong.html", dict)




