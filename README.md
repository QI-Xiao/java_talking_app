# java_talking_app

## How to use docker to deploy the application

1. Create the war file: mvn clean compile package -DskipTests=true
2. Copy and rename the war file to the target directory: cp ./mvc/target/mvc-1.0-SNAPSHOT.war ./ops/container/ROOT.war
3. Build a docker image: docker build -t talking_app:1 ./ops/container/
4. Run docker with your parameters: docker run --name mvc-api --rm -e PROFILE=dev -e JWT_KEY=### -e DB_URL=### -e DB_PORT=### -e DB_NAME=### -e DB_USERNAME=### -e DB_PW=### -p 80:8080 talking_app:1

Reference:

https://github.com/ali-bouali/spring-boot-websocket-chat-app
