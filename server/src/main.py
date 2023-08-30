import os
from flask import Flask
from flask_http_middleware import MiddlewareManager
from dotenv import load_dotenv
from database.connect.mysql import MySqlParser
from database.connect.dataParser import DataParserInterface

from routes.sushi import SushiRoutes
from middlewares.sushi import SushiMiddleware


def init_routes(api: Flask, db: DataParserInterface):
    sushi_use_cases = SushiRoutes(db)
    api.add_url_rule("/api/sushi", methods=['GET'], view_func=sushi_use_cases.get_sushis)
    api.add_url_rule("/api/sushi", methods=['POST'], view_func=sushi_use_cases.post_sushis)
    api.add_url_rule("/api/sushi", methods=['PUT'], view_func=sushi_use_cases.put_sushis)
    api.add_url_rule("/api/sushi", methods=['DELETE'], view_func=sushi_use_cases.delete_sushis)


def init_middlewares(api: Flask):
    admin_route = ["/api/sushi"]
    api.wsgi_app = MiddlewareManager(api)
    api.wsgi_app.add_middleware(SushiMiddleware, secured_routers=admin_route)


def init_api(api: Flask, db: DataParserInterface):
    init_middlewares(api)
    init_routes(api, db)


if __name__ == "__main__":
    load_dotenv()
    database = MySqlParser(
        user=str(os.environ.get('DATABASE_USER')),
        password=str(os.environ.get('DATABASE_PASSWORD')),
        host=str(os.environ.get('DATABASE_URL')),
        database=str(os.environ.get('DATABASE_NAME')),
        port=str(os.environ.get('DATABASE_PORT'))
    )
    print(database.get_all_sushi())
    app: Flask = Flask(__name__)
    init_api(app, database)
    app.run(debug=True, host="0.0.0.0", port=int(os.environ.get("PORT", 8080)))
