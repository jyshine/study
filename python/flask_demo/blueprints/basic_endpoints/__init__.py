# blueprints/basic_endpoints/__init__.py
from flask import Blueprint
from flask import request


blueprint = Blueprint('api',__name__, url_prefix='/basic_api')

@blueprint.route('/hello_world')
def hello_world():
    return 'Hello, World!'

@blueprint.route('/entities', methods=['GET','POST'])
def entities():
    if request.method == "GET":
        return{
            'message': 'This endpoint should return a list of entities',
            'method': request.method
        }
    if request.method == "POST":
        return {
            'message': 'This endpoint should create an entity',
            'method': request.method,
		    'body': request.json
        }

@blueprint.route('/entities', methods=['GET','POST'])
def entity(entity_id):
    if request.method == "GET":
        return {
            'id': entity_id,
            'message': 'This endpoint should return the entity {} details'.format(entity_id),
            'method': request.method
        }
    if request.method == "PUT":
        return {
            'id': entity_id,
            'message': 'This endpoint should update the entity {}'.format(entity_id),
            'method': request.method,
		'body': request.json
        }
    if request.method == "DELETE":
        return {
            'id': entity_id,
            'message': 'This endpoint should delete the entity {}'.format(entity_id),
            'method': request.method
        }