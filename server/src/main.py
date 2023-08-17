from routes.sushi import SushiRoutes
from middlewares.sushi import SushiMiddleware
from flask import Flask
from flask_http_middleware import MiddlewareManager
import os
from dotenv import load_dotenv


def init_routes(api: Flask):
    sushi_use_cases = SushiRoutes()
    api.add_url_rule("/api/sushi", methods=['GET'], view_func=sushi_use_cases.get_sushis)
    api.add_url_rule("/api/sushi", methods=['POST'], view_func=sushi_use_cases.post_sushis)
    api.add_url_rule("/api/sushi", methods=['PUT'], view_func=sushi_use_cases.put_sushis)
    api.add_url_rule("/api/sushi", methods=['DELETE'], view_func=sushi_use_cases.delete_sushis)


def init_middlewares(api: Flask):
    admin_route = ["/api/sushi"]
    api.wsgi_app = MiddlewareManager(api)
    api.wsgi_app.add_middleware(SushiMiddleware, secured_routers=admin_route)


def init_api(api: Flask):
    init_middlewares(api)
    init_routes(api)


if __name__ == "__main__":
    load_dotenv()
    app: Flask = Flask(__name__)
    init_api(app)
    api_port: str = os.getenv('PORT')
    app.run(host='0.0.0.0', port=api_port if api_port else 8080, debug=True, use_reloader=False)
