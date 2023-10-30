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

@app.get("/dean/add", response_class=HTMLResponse)
async def add_dean_view(request:Request):
    return templates.TemplateResponse("dean/add_dean.html", {"request":request})

@app.post("/dean/add")
async def add_dean(
    ma_de_an:int = Form(),
    ten_de_an:str = Form(),
    dia_diem:str = Form(),
    phong:int = Form()
):
    try:
        q = """
            INSERT INTO dean VALUES (%s, %s, %s, %s)
        """
        values = (ten_de_an, ma_de_an, dia_diem, phong)

        cursor.execute(q, values)
        connect.commit()

        return "Added!"
    
    except psycopg2.Error as e:
        connect.rollback()
        raise HTTPException(status_code=500, detail=str(e))
    

@app.get("/dean/update",response_class=HTMLResponse)
async def update_dean_view(request:Request):
    return templates.TemplateResponse("dean/update_dean.html", {"request":request})

@app.post("/dean/update")
async def update_dean(
    ten_de_an:str = Form(),
    ma_de_an:int = Form(),
    dia_diem:str = Form(),
    phong:str = Form()
):
    try:
        q = """
            UPDATE dean
            SET (tenda, ddiem_da, phong) = (%s, %s, %s)
            WHERE mada = %s
        """
        values = (ten_de_an, dia_diem, phong, ma_de_an)

        cursor.execute(q, values)
        connect.commit()

        return "Updated!"
    
    except psycopg2.Error as e:
        connect.rollback()
        raise HTTPException(status_code=500, detail=str(e))
    
@app.get("/dean/delete", response_class=HTMLResponse)
async def delete_dean_view(request:Request):
    return templates.TemplateResponse("dean/delete_dean.html", {"request":request})

@app.post("/dean/delete")
async def delete_dean(ma_de_an:int = Form()):
    try:
        q = f"""
            DELETE FROM dean
            WHERE mada = {ma_de_an}
        """

        cursor.execute(q)
        connect.commit()

        return "Deleted!"
    
    except psycopg2.Error as e:
        connect.rollback()
        raise HTTPException(status_code=500, detail=str(e))   

    
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


@app.get("/nhanvien/add",response_class=HTMLResponse)
async def add_nhanvien_view(request: Request):
    return templates.TemplateResponse("nhanvien/add_nhanvien.html", {"request":request})

@app.post("/nhanvien/add")
async def add_nhanvien(
    ho: str = Form(),
    lot:str = Form(),
    ten:str = Form(),
    ma_nv:str = Form(),
    ngay_sinh:str = Form(),
    dia_chi:str = Form(),
    gioi_tinh:str = Form(),
    luong:int = Form(),
    ma_nql:int = Form(),
    ma_phong:int = Form()
):
    try:
        q = """
            INSERT INTO nhanvien VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        """
        values = (ho, lot, ten, ma_nv, ngay_sinh, dia_chi, gioi_tinh, luong, ma_nql, ma_phong)

        cursor.execute(q, values)
        connect.commit()

        return "Added!"
    
    except psycopg2.Error as e:
        connect.rollback()
        raise HTTPException(status_code=500, detail=str(e))

@app.get("/nhanvien/update", response_class=HTMLResponse)
async def update_nhanvien_view(request:Request):
    return templates.TemplateResponse("nhanvien/update_nhanvien.html", {"request":request})

@app.post("/nhanvien/update")
async def update_nhanvien(
    ho: str = Form(),
    lot:str = Form(),
    ten:str = Form(),
    ma_nv:str = Form(),
    ngay_sinh:str = Form(),
    dia_chi:str = Form(),
    gioi_tinh:str = Form(),
    luong:int = Form(),
    ma_nql:int = Form(),
    ma_phong:int = Form()
):
    try:
        q = """
            UPDATE nhanvien
            SET (honv, tenlot, tennv, ngsinh, dchi, phai, luong, ma_nql, phg) = (%s, %s, %s, %s, %s, %s, %s, %s, %s)
            WHERE manv = %s
        """
        values = (ho, lot, ten, ngay_sinh, dia_chi, gioi_tinh, luong, ma_nql, ma_phong, ma_nv)

        cursor.execute(q, values)
        connect.commit()

        return "Updated!"
    
    except psycopg2.Error as e:
        connect.rollback()
        raise HTTPException(status_code=500, detail=str(e))
    
@app.get("/nhanvien/delete",response_class=HTMLResponse)
async def delete_nhanvien_view(request: Request):
    return templates.TemplateResponse("nhanvien/delete_nhanvien.html", {"request":request})

@app.post("/nhanvien/delete")
async def delete_nhanvien(ma_nv:str = Form()):
    try:
        q = f"""
            DELETE FROM nhanvien
            WHERE CAST(manv AS int) = CAST({ma_nv} AS int)
        """

        cursor.execute(q)
        connect.commit()

        return "Deleted!"
    
    except psycopg2.Error as e:
        connect.rollback()
        raise HTTPException(status_code=500, detail=str(e))     

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

@app.get("/diadiemphong/add",response_class=HTMLResponse)
async def add_diadiem_phong_view(request:Request):
    return templates.TemplateResponse("diadiem_phong/add_diadiem_phong.html", {"request":request})

@app.post("/diadiemphong/add")
async def add_diadiem_phong(
    ma_phong: int = Form(),
    dia_diem: str = Form()
):
    try:
        q = """
            INSERT INTO diadiem_phg VALUES (%s, %s)
        """
        values = (ma_phong, dia_diem)

        cursor.execute(q, values)
        connect.commit()

        return "Added!"
    
    except psycopg2.Error as e:
        connect.rollback()
        raise HTTPException(status_code=500, detail=str(e))


@app.get("/diadiemphong/update",response_class=HTMLResponse)
async def update_diadiem_phong_view(request:Request):
    return templates.TemplateResponse("diadiem_phong/update_diadiem_phong.html", {"request":request})

@app.post("/diadiemphong/update")
async def update_diadiem_phong(
    ma_phong: int = Form(),
    dia_diem: str = Form()
):
    try:
        q = """
            UPDATE diadiem_phg
            SET diadiem = %s
            WHERE maphg = %s
        """
        values = (dia_diem, ma_phong)

        cursor.execute(q, values)
        connect.commit()

        return "Updated!"
    
    except psycopg2.Error as e:
        connect.rollback()
        raise HTTPException(status_code=500, detail=str(e))

@app.get("/diadiemphong/delete",response_class=HTMLResponse)
async def delete_diadiem_phong_view(request:Request):
    return templates.TemplateResponse("diadiem_phong/delete_diadiem_phong.html", {"request":request})

@app.post("/diadiemphong/delete")
async def delete_diadiem_phong(ma_phong:int = Form()):
    try:
        q = f"""
            DELETE FROM diadiem_phg
            WHERE maphg = {ma_phong}
        """

        cursor.execute(q)
        connect.commit()

        return "Deleted!"
    
    except psycopg2.Error as e:
        connect.rollback()
        raise HTTPException(status_code=500, detail=str(e))   

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

@app.get("/phancong/add", response_class=HTMLResponse)
def add_phancong_view(request:Request):
    return templates.TemplateResponse("phancong/add_phancong.html", {"request":request})

@app.post("/phancong/add")
async def add_phancong(
    ma_nv: str = Form(),
    ma_de_an:int = Form(),
    stt:int = Form(),
    thoi_gian:str = Form()
):
    try:
        q = """
            INSERT INTO phancong VALUES (%s, %s, %s, %s)
        """
        values = (ma_nv, ma_de_an, stt, thoi_gian)

        cursor.execute(q, values)
        connect.commit()

        return "Added!"
    
    except psycopg2.Error as e:
        connect.rollback()
        raise HTTPException(status_code=500, detail=str(e))   




