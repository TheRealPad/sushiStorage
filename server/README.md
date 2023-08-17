# SushiStorage API

## Techno

- [Docker](https://www.docker.com/)
- [Python 3](https://www.python.org/)
- [Flask](https://flask.palletsprojects.com/en/2.3.x/) (you can go to [requirements.txt](requirements.txt) to have more details about the dependencies)

## Use the api

### manually
```bash
pip install -r requirements.txt # install dependencies
python src/main.py # launch server
```

### Docker
```bash
make
# or
docker-compose -f ./config/docker-compose.yml up --build -d
```

by default the API port is [8080](http://127.0.0.1:8080/api/sushi), you can change it in your .env (see [.env.config](.env.config))

## init the database

```bash
mysql -u $USER_NAME -p < src/database/init.sql
```