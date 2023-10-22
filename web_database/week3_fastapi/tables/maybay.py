from db import *
from pydantic import BaseModel

class MayBay(BaseModel):

    def __init__(self, ma_mb, loai, tam_bay):
        self.ma_mb = ma_mb
        self.loai = loai
        self.tam_bay = tam_bay


    
    def get_data(id):

        try: 
            if (id == ""):
                q = "SELECT * FROM maybay"
            else:
                q = f"""
                    SELECT * FROM maybay
                    WHERE mamb = {id}
                """
            cursor_obj.execute(q)
            result = cursor_obj.fetchall()

            return result
        except:
            print(f"{id} not exist")
    

    def create_data(item: "MayBay"):
        q = f"""
            INSERT INTO maybay VALUES (
                mamb = {item.ma_mb},
                loai = {item.loai},
                tambay = {item.tam_bay}
            )
        """

        cursor_obj.execute(q)
        db_connect.commit()

        return {"MESSAGE" : "CREATED!"}
    

    def put_data(id, item: "MayBay"):
        try:
            q = f"""
                UPDATE maybay
                SET (
                    loai = {item.loai},
                    tambay = {item.tam_bay}
                )
                WHERE mamb = {id}
            """
            cursor_obj.execute(q)
            db_connect.commit()

            return {"MESSAGE" : "UPDATED!"}
        except:
            print(f"{id} not exist")

    
    def del_data(id):
        try:
            q = f"""
                DELETE FROM maybay
                WHERE mamb = {id}
            """
            cursor_obj.execute(q)
            db_connect.commit()

            return {"MESSAGE" : "DELETED!"}
        except:
            print(f"{id} not exist")