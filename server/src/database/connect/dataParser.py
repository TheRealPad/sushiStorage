from data.sushi import Sushi

class DataParserInterface:
    def connection(self):
        pass

    def close(self):
        pass

    def get_all_sushi(self) -> [Sushi]:
        pass

    def get_one_sushi(self, uuid: str):
        pass

    def remove_sushi(self):
        pass

    def update_sushi(self):
        pass

    def create_sushi(self, sushi: Sushi):
        pass
