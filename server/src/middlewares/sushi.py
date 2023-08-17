from flask import jsonify
from flask_http_middleware import BaseHTTPMiddleware


class SushiMiddleware(BaseHTTPMiddleware):
    def __init__(self, secured_routers=[]):
        super().__init__()
        self.secured_routers = secured_routers

    def dispatch(self, request, call_next):
        if request.path in self.secured_routers:
            print("middleware sushi")
            return call_next(request)
        else:
            return call_next(request)

    def error_handler(self, error):
        return jsonify({"error": str(error)})
