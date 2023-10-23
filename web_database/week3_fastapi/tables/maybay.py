from db import *
from pydantic import BaseModel

class MayBay(BaseModel):

    ma_mb: int
    loai: str
    tam_bay: int

    # def __init__(self, ma_mb, loai, tam_bay):
    #     self.ma_mb = ma_mb
    #     self.loai = loai
    #     self.tam_bay = tam_bay


    
    def get_data(id):

        try: 
            if (id == "*"):
                q = "SELECT * FROM maybay"
                cursor_obj.execute(q)

            else:
                q = """
                    SELECT * FROM maybay
                    WHERE mamb = (%s)
                """
            cursor_obj.execute(q, id)
            result = cursor_obj.fetchall()

            return result
        except:
            print(f"{id} not exist")
            return "ERROR"
    

    def create_data(item: "MayBay"):
        q = """
            INSERT INTO maybay 
            VALUES (%s, %s, %s);
        """

        values = (item.ma_mb, item.loai, item.tam_bay)

        cursor_obj.execute(q, values)
        db_connect.commit()

        return {"MESSAGE" : "CREATED!"}
    

    def put_data(id, item: "MayBay"):
        try:
            q = """
                UPDATE maybay
                SET (loai, tambay) = (%s, %s)
                WHERE mamb = (%s)
            """
            values = (item.loai, item.tam_bay, id)
            cursor_obj.execute(q, values)
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
            return "ERROR"