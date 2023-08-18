from flask import jsonify
from flask_http_middleware import BaseHTTPMiddleware


class SushiMiddleware(BaseHTTPMiddleware):
    def __init__(self, secured_routers=[]):
        super().__init__()
        self.secured_routers = secured_routers

    def dispatch(self, request, call_next):
        if request.method == "GET":
            return call_next(request)
        if request.path in self.secured_routers and request.headers.get("admin") == "admin":
            return call_next(request)
        else:
            error_response = jsonify({"message": "invalid credentials"})
            error_response.status_code = 401
            return error_response
