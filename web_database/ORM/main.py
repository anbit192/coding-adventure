from fastapi import FastAPI, status, HTTPException
from pydantic import BaseModel
from uuid import uuid4
from database import SessionLocal
from typing import List
import models

app = FastAPI()


class Item(BaseModel):
    id: int | None = uuid4()
    name: str
    description: str
    price: int
    on_offer: bool

    class Config:
        orm_mode = True


db = SessionLocal()


@app.get("/items", response_model=List[Item], status_code=200)
async def fetch_items():
    items = db.query(models.Item).all()
    return items


@app.get("/items/{id}", response_model=Item, status_code=status.HTTP_200_OK)
async def fetch_item_by_id(id: int):
    item = db.query(models.Item).filter(models.Item.id==id).first()
    print(item)

    return item


@app.post("/items", response_model=Item, status_code=status.HTTP_201_CREATED)
async def post_item(item: Item):
    new_item = models.Item(
        name=item.name,
        price=item.price,
        description=item.description,
        on_offer=item.on_offer
    )

    print("check1:", new_item)

    db_item = db.query(models.Item).filter(models.Item.name==new_item.name).first()

    print("check:",db_item)

    if (db_item is not None):
        raise HTTPException(status_code=status.HTTP_400_BAD_REQUEST, detail="Item already exists.")
    db.add(new_item)
    db.commit()

    return new_item


@app.put("/items/{id}", response_model=Item, status_code=status.HTTP_200_OK)
async def update_item(id: int, item: Item):
    item_to_update = db.query(models.Item).filter(models.Item.id == id).first()
    if (item_to_update is None):
        raise HTTPException(status_code=status.HTTP_404_NOT_FOUND, detail=f"Item with ID={id} does not exists.")

    item_to_update.name=item.name
    item_to_update.price=item.price
    item_to_update.description=item.description
    item_to_update.on_offer=item.on_offer
    db.commit()
    return item_to_update





@app.delete("/items/{id}", response_model=Item, status_code=status.HTTP_200_OK)
async def delete_item(id: int):
    item_del = db.query(models.Item).filter(models.Item.id==id).first()
    if (item_del is None):
        raise HTTPException(status_code=status.HTTP_404_NOT_FOUND, detail=f"Item with ID={id} does not exists.")
    db.delete(item_del)
    db.commit()

    return item_del
