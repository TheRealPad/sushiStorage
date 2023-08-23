import mysql.connector
from mysql.connector import errorcode

from database.connect.dataParser import DataParserInterface
from data.sushi import Sushi


class MySqlParser(DataParserInterface):
    user: str
    password: str
    host: str
    database: str
    cnx: any

    def __init__(self, user: str, password: str, host: str, database: str, port: str):
        self.user = user
        self.password = password
        self.database = database
        self.host = host
        self.port = port

    def connection(self):
        try:
            self.cnx = mysql.connector.connect(user=self.user, password=self.password,
                                          host=self.host,
                                          database=self.database, port=self.port)
        except mysql.connector.Error as err:
            self.cnx = False
            if err.errno == errorcode.ER_ACCESS_DENIED_ERROR:
                print("Something is wrong with your user name or password")
            elif err.errno == errorcode.ER_BAD_DB_ERROR:
                print("Database does not exist")
            else:
                print(err)

    def close(self):
        self.cnx.close()

    def get_all_sushi(self) -> [Sushi]:
        self.connection()
        cursor = self.cnx.cursor()
        query = ("SELECT * FROM Sushi")
        cursor.execute(query)
        sushis: [Sushi] = []
        for (id, name, description, image_path, ingredient_list) in cursor:
            sushis = sushis + [Sushi(id, name, description, image_path, ingredient_list)]
        cursor.close()
        self.close()
        return sushis

    def get_one_sushi(self, uuid: str):
        self.connection()
        cursor = self.cnx.cursor()
        query = "SELECT * FROM Sushi WHERE id = %s"
        cursor.execute(query, (uuid,))
        sushis: [Sushi] = []
        for (id, name, description, image_path, ingredient_list) in cursor:
            sushis = sushis + [Sushi(id, name, description, image_path, ingredient_list)]
        cursor.close()
        self.close()
        return sushis

    def remove_sushi(self, uuid: str):
        self.connection()
        cursor = self.cnx.cursor()
        add_employee = ("DELETE FROM Sushi WHERE id = %s")
        data_employee = (uuid,)
        cursor.execute(add_employee, data_employee)
        self.cnx.commit()
        cursor.close()
        self.close()

    def update_sushi(self, sushi: Sushi):
        self.connection()
        cursor = self.cnx.cursor()
        add_employee = ("UPDATE Sushi "
                        "SET name = %s, description = %s, imagePath = %s, ingredientList = %s "
                        "WHERE id = %s")
        data_employee = (sushi.name, sushi.description, sushi.image_path, sushi.ingredient_list, sushi.uuid)
        cursor.execute(add_employee, data_employee)
        self.cnx.commit()
        cursor.close()
        self.close()

    def create_sushi(self, sushi: Sushi):
        self.connection()
        cursor = self.cnx.cursor()
        add_employee = ("INSERT INTO Sushi "
                        "(name, description, imagePath, ingredientList) "
                        "VALUES (%s, %s, %s, %s)")
        data_employee = (sushi.name, sushi.description, sushi.image_path, sushi.ingredient_list)
        cursor.execute(add_employee, data_employee)
        self.cnx.commit()
        cursor.close()
        self.close()
