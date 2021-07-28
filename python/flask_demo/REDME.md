<h2>개발환경 셋팅</h2>
<pre><code>
mkdir flask_demo

cd flask_demo

python3 -m venv venv

. venv/bin/activate

deactivate

pip install Flask
pip install -r requirements.txt


export FLASK_APP=main.py
export FLASK_ENV=development
flask run
</code></pre>


- Blueprints 사용
- Jinja Templates 사용
- RESTx 사용


http://localhost:5000/documented_api/doc

