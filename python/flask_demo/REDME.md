<h2>
기본 CRUD 세팅
</h2>
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

http://localhost:5000/basic_api/hello_world


<h2>
Blueprints 사용
</h2>

<h2>
Jinja Templates
</h2>
