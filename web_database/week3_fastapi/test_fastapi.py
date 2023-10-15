from fastapi import FastAPI

app = FastAPI()

@app.get("/items/{item_id}")
async def read_item(item_id, required: str, default: int = 0, limit: (int | None) = None):

    return {"item_id" : item_id, "required_param" : required, "default_param" : default, "limit" : limit}

@app.get("/")
async def hello_world():
    return {"message" : "Hello World"}



