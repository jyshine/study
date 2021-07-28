# main.py
from flask import Flask
from flask_cors import CORS
from blueprints.basic_endpoints import blueprint as basic_endpoint
from blueprints.jinja_endpoint import blueprint as jinja_template_blueprint
from blueprints.documented_endpoints import blueprint as documented_endpoints

app = Flask(__name__)
app.config['RESTX_MASK_SWAGGER'] = False

app.register_blueprint(basic_endpoint)
app.register_blueprint(jinja_template_blueprint)
app.register_blueprint(documented_endpoints)
CORS(app)

if __name__ == "__main__":
    app.run()
