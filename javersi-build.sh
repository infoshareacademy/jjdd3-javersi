mvn clean package && sudo docker-compose up -d --build && echo ">>Javersi Charging Point App was build.<<\nMain port: 4120.\nWildfly management port: 4141.\n MySQL port: 4122."
sudo docker exec -it jjdd3javersi_javersi_db_1 bash
mysql javersi_data -ujaversi -pjaversi123
ALTER SCHEMA `javersi_data`  DEFAULT CHARACTER SET utf8  DEFAULT COLLATE utf8_bin ;