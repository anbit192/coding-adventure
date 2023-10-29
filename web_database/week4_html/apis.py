from connect import *
from fastapi import FastAPI, Request
from fastapi.responses import *
from fastapi.templating import Jinja2Templates

app = FastAPI()
templates = Jinja2Templates(directory="templates")

@app.get("/", response_class=HTMLResponse)
def hello_world(request: Request):
    return templates.TemplateResponse("index.html", {"request":request})

@app.get("/congviec", response_class=HTMLResponse)
def get_congviec(request: Request):
    cursor.execute("SELECT * FROM congviec")
    data = cursor.fetchall()
    return templates.TemplateResponse("congviec.html", {"request": request, "data":data})
