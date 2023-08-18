import os

from flask import request

from database.connect.dataParser import DataParserInterface
from data.sushi import Sushi


class SushiRoutes:
    db: DataParserInterface

    def __init__(self, db: DataParserInterface):
        self.db = db

    def get_sushis(self):
        data = self.db.get_all_sushi()
        for sushi in data:
            if os.path.isfile("./assets/" + sushi.image_path):
                import base64
                with open("./assets/" + sushi.image_path, "rb") as img_file:
                    my_string = base64.b64encode(img_file.read()).decode("utf-8")
                    sushi.image_path = my_string
        return data, 200

    def post_sushis(self):
        data = self.db.get_all_sushi()
        file = request.files['image']
        if file.filename != '':
            file.save('./assets/' + file.filename)
        sushi = Sushi("", request.form["name"], request.form["description"], file.filename, request.form["ingredientList"])
        for elem in data:
            if elem.name == sushi.name:
                return {'create': 'fail - duplicate'}, 400
        self.db.create_sushi(sushi)
        return {'create': 'good'}, 200

    def put_sushis(self):
        file = request.files['image']
        sushi = Sushi(request.form["id"], request.form["name"], request.form["description"], file.filename, request.form["ingredientList"])
        self.db.update_sushi(sushi)
        return {'update': 'good'}, 200

    def delete_sushis(self):
        self.db.remove_sushi(request.form["id"])
        return {'delete': 'good'}, 200
