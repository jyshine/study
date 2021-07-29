# blueprints/documented_endpoints/__init__.py
from flask import Blueprint
from flask_restx import Api
from blueprints.documented_endpoints.hello_world import namespace as hello_world_ns
from blueprints.documented_endpoints.entities import namespace as entities_ns
from blueprints.documented_endpoints.jinja_template import namespace as jinja_template_ns


blueprint = Blueprint('documented_api', __name__, url_prefix='/documented_api')

authorizations = {
    'ApiKeyAuth': {
        'type': 'apiKey',
        'in': 'header',
        'name': 'Authorization',
        'description': 'Authorization Bearer Access Token'
    },
}
api_extension = Api(
    blueprint,
    authorizations=authorizations,
    title='Flask RESTx Demo',
    version='1.0',
    description='Application tutorial to demonstrate Flask RESTx extension\
        for better project structure and auto generated documentation',
    doc='/doc'
)
api_extension.add_namespace(entities_ns)
api_extension.add_namespace(jinja_template_ns)