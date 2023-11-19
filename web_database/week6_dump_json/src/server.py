from database import connection
from fastapi import FastAPI, Request
import json
from decimal import Decimal
from datetime import date

app = FastAPI()

class CustomJSONEncoder(json.JSONEncoder):
    def default(self, o):
        if isinstance(o, Decimal):
            return float(o)
        elif isinstance(o, date):
            return o.isoformat()
        return super(CustomJSONEncoder, self).default(o)

@app.get("/")
async def hello_world(req: Request):
    return {"msg": "HELLO WORLD FROM ANBISH!"}

@app.get("/congviec")
async def get_congviec(req: Request):
    q = "SELECT * FROM congviec"
    cursor = connection.cursor()
    cursor.execute(q)
    results = cursor.fetchall()
    cursor.close()

    return results


@app.get("/congviec/export")
async def export_congviec(req:Request):
    json_data = await get_congviec(req)
    # print(json_data)

    with open("../json_datas/congviec.json", "w", encoding="utf-8") as json_file:
        json.dump(json_data, json_file, indent=4, ensure_ascii=False)

    return {"msg":f"Exported to {json_file.name}"}


@app.get("/nhanvien")
async def get_nhanvien(req:Request):
    q = "SELECT * FROM nhanvien"
    cursor = connection.cursor()
    cursor.execute(q)
    results = cursor.fetchall()
    cursor.close()

    return results

@app.get("/nhanvien/export")
async def export_nhanvien(req:Request):
    json_data = await get_nhanvien(req)
    
    with open("../json_datas/nhanvien.json", "w", encoding="utf-8") as json_file:
        json.dump(json_data, json_file, indent = 4, ensure_ascii=False, cls=CustomJSONEncoder)
    
    return {"msg" : f"Exported to {json_file.name}"}


@app.get("/dean")
async def get_dean(req:Request):
    q = "SELECT * FROM dean"
    cursor = connection.cursor()
    cursor.execute(q)
    results = cursor.fetchall()
    cursor.close()

    return results

@app.get("/dean/export")
async def export_dean(req:Request):
    json_data = await get_dean(req)
    
    with open("../json_datas/dean.json", "w", encoding="utf-8") as json_file:
        json.dump(json_data, json_file, indent = 4, ensure_ascii=False)
    
    return {"msg" : f"Exported to {json_file.name}"}


@app.get("/phancong")
async def get_phancong(req:Request):
    q = "SELECT * FROM phancong"
    cursor = connection.cursor()
    cursor.execute(q)
    results = cursor.fetchall()
    cursor.close()

    return results

@app.get("/phancong/export")
async def export_phancong(req:Request):
    json_data = await get_phancong(req)
    
    with open("../json_datas/phancong.json", "w", encoding="utf-8") as json_file:
        json.dump(json_data, json_file, indent = 4, ensure_ascii=False, cls=CustomJSONEncoder)
    
    return {"msg" : f"Exported to {json_file.name}"}


@app.get("/diadiem-phong")
async def get_diadiem(req:Request):
    q = "SELECT * FROM diadiem_phg"
    cursor = connection.cursor()
    cursor.execute(q)
    results = cursor.fetchall()
    cursor.close()

    return results

@app.get("/diadiem-phong/export")
async def export_diadiem(req:Request):
    json_data = await get_diadiem(req)
    
    with open("../json_datas/diadiem_phong.json", "w", encoding="utf-8") as json_file:
        json.dump(json_data, json_file, indent = 4, ensure_ascii=False)
    
    return {"msg" : f"Exported to {json_file.name}"}

