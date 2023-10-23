from db import *
from pydantic import BaseModel

class NhanVien(BaseModel):
    ma_nv: int
    ten: str
    luong: int

    # def __init__(self, ma_nv, ten, luong):
    #     self.ma_nv = ma_nv
    #     self.ten = ten
    #     self.luong = luong


    def get_data(id):

        try: 
            if (id == "*"):
                q = "SELECT * FROM nhanvien"
                cursor_obj.execute(q)
            else:
                q = """
                    SELECT * FROM nhanvien
                    WHERE manv = (%s)
                """
                cursor_obj.execute(q, id)
            result = cursor_obj.fetchall()

            return result
        except:
            print(f"{id} not exist")
    

    def create_data(item: "NhanVien"):
        q = """
            INSERT INTO nhanvien VALUES (%s, %s, %s);
        """
        values = (item.ma_nv, item.ten, item.luong)
        cursor_obj.execute(q, values)
        db_connect.commit()

        return {"MESSAGE" : "CREATED!"}
    

    def put_data(id, item: "NhanVien"):
        try:
            q = """
                UPDATE nhanvien
                SET (ten, luong) = (%s, %s)
                WHERE manv = (%s)
            """
            values = (item.ten, item.luong, id)
            cursor_obj.execute(q, values)
            db_connect.commit()

            return {"MESSAGE" : "UPDATED!"}
        except:
            print(f"{id} not exist")

    
    def del_data(id):
        try:
            q = f"""
                DELETE FROM nhanvien
                WHERE manv = {id}
            """
            cursor_obj.execute(q)
            db_connect.commit()

            return {"MESSAGE" : "DELETED!"}
        except:
            print(f"{id} not exist")

    