from database.connect.dataParser import DataParserInterface
from data.sushi import Sushi


class SushiRoutes:
    db: DataParserInterface

    def __init__(self, db: DataParserInterface):
        self.db = db

    def get_sushis(self):
        data = self.db.get_all_sushi()
        print(data)
        return data, 200

    def post_sushis(self):
        return {'token': 'good'}, 200

    def put_sushis(self):
        return {'token': 'good'}, 200

    def delete_sushis(self):
        return {'token': 'good'}, 200
