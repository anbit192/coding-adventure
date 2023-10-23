from db import *
from pydantic import BaseModel

class ChungNhan(BaseModel):

    ma_nv: int
    ma_mb: int

    # def __init__(self, ma_nv, ma_mb):
    #     self.ma_nv: int = ma_nv
    #     self.ma_mb: int = ma_mb


    def get_data(id):

        try: 
            if (id == "*"):
                q = "SELECT * FROM chungnhan"
                cursor_obj.execute(q)
            else:
                q = """
                    SELECT * FROM chungnhan
                    WHERE manv = %s
                """
                cursor_obj.execute(q, id)
            result = cursor_obj.fetchall()

            return result
        except:
            print(f"{id} not exist")
    

    def create_data(item: "ChungNhan"):
        q = """
            INSERT INTO chungnhan VALUES (%s, %s);
        """
        values = (item.ma_nv, item.ma_mb)
        cursor_obj.execute(q, values)
        db_connect.commit()

        return {"MESSAGE" : "CREATED!"}
    

    def put_data(id, item: "ChungNhan"):
        try:
            q = """
                UPDATE chungnhan
                SET mamb = (%s)
                WHERE manv = (%s);
            """
            values = (item.ma_mb, id)
            cursor_obj.execute(q, values)
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

    

