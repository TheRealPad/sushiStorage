from dataclasses import dataclass


@dataclass
class Sushi:
    uuid: str
    name: str
    description: str
    image_path: str
    ingredient_list: str

    def __init__(self, uuid: str, name: str, description: str, image_path: str, ingredient_list: str):
        self.uuid = uuid
        self.name = name
        self.description = description
        self.image_path = image_path
        self.ingredient_list = ingredient_list
