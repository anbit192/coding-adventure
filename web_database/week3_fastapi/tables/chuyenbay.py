from db import *
from pydantic import BaseModel


class ChuyenBay(BaseModel):

    ma_cb: str
    ga_di: str
    ga_den: str
    do_dai: int
    gio_di: str
    gio_den: str
    chi_phi: float

    # def __init__(self, ma_cb, ga_di, ga_den, do_dai, gio_di, gio_den, chi_phi):
    #     self.ma_cb = ma_cb
    #     self.ga_di = ga_di
    #     self.ga_den = ga_den
    #     self.do_dai = do_dai
    #     self.gio_di = gio_di
    #     self.gio_den = gio_den
    #     self.chi_phi = chi_phi

    def get_data(flight_id):
        try:
            if (flight_id == ""):
                q = "SELECT * FROM chuyenbay"
            else:
                q = f"""
                    SELECT * FROM chuyenbay
                    WHERE macb = {flight_id}
                """
            cursor_obj.execute(q)
            result = cursor_obj.fetchall()
            return result
        except:
            print(f"{flight_id} not exist")

    def create_data(item: "ChuyenBay"):
        # q = f"""
        #     INSERT INTO chuyenbay VALUES (
        #         {item.ma_cb},
        #         {item.ga_di},
        #         {item.ga_den},
        #         {item.do_dai},
        #         {item.gio_di},
        #         {item.gio_den},
        #         {item.chi_phi}
        #     );
        # """

        q = '''
            INSERT INTO chuyenbay 
            VALUES (%s, %s, %s, %s, %s, %s, %s);
        '''

        values = (item.ma_cb, item.ga_di, item.ga_den, item.do_dai,
                  item.gio_di, item.gio_den, item.chi_phi)

        # cursor_obj.execute(q)
        cursor_obj.execute(q, values)
        db_connect.commit()

        return {"MESSAGE": "CREATED!"}

    def put_data(flight_id, item: "ChuyenBay"):
        try:
            q = f"""
                UPDATE chuyenbay
                SET (
                    gadi = {item.ga_di},
                    gaden = {item.ga_den},
                    dodai = {item.do_dai},
                    giodi = {item.gio_di},
                    gioden = {item.gio_den},
                    chiphi = {item.chi_phi}
                )
                WHERE macb = {flight_id}
            """

            cursor_obj.execute(q)
            db_connect.commit()

            return {"MESSAGE": "UPDATED!"}
        except:
            print(f"{flight_id} not exist")

    def del_data(flight_id):
        try:
            q = f"""
                DELETE FROM chuyenbay
                WHERE macb = {flight_id}
            """

            cursor_obj.execute(q)
            db_connect.commit()

            return {"MESSAGE": "DELETED!"}
        except:
            print(f"{flight_id} not exist")
