gradle clean build shadowJar
sudo docker build -t word-count .
sudo docker run -i -t --network host word-count
