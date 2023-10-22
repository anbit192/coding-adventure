from db import *
from pydantic import BaseModel

class ChungNhan(BaseModel):

    def __init__(self, ma_nv, ma_mb):
        self.ma_nv: str = ma_nv
        self.ma_mb: int = ma_mb


    def get_data(id):

        try: 
            if (id == ""):
                q = "SELECT * FROM chungnhan"
            else:
                q = f"""
                    SELECT * FROM chungnhan
                    WHERE manv = {id}
                """
            cursor_obj.execute(q)
            result = cursor_obj.fetchall()

            return result
        except:
            print(f"{id} not exist")
    

    def create_data(item: "ChungNhan"):
        q = f"""
            INSERT INTO chungnhan VALUES (
                manv = {item.ma_nv},
                mamb = {item.ma_mb},
                
            )
        """

        cursor_obj.execute(q)
        db_connect.commit()

        return {"MESSAGE" : "CREATED!"}
    

    def put_data(id, item: "ChungNhan"):
        try:
            q = f"""
                UPDATE chungnhan
                SET (
                    mamb = {item.ma_mb}
                    
                )
                WHERE manv = {id}
            """
            cursor_obj.execute(q)
            db_connect.commit()

            return {"MESSAGE" : "UPDATED!"}
        except:
            print(f"{id} not exist")

    
    def del_data(id):
        try:
            q = f"""
                DELETE FROM chungnhan
                WHERE manv = {id}
            """
            cursor_obj.execute(q)
            db_connect.commit()

            return {"MESSAGE" : "DELETED!"}
        except:
            print(f"{id} not exist")

    

