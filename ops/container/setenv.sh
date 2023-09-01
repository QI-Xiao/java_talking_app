#export JAVA_OPTS="$JAVA_OPTS -Dspring.profiles.active=dev"
#export JAVA_OPTS="$JAVA_OPTS -Djwt.secretKey=dfdsfdsossdf"

#export SPRING_DATASOURCE_URL="jdbc:postgresql://172.17.0.4:5432/talking_db"
#export SPRING_DATASOURCE_DRIVER_CLASS_NAME="org.postgresql.Driver"
#export SPRING_DATASOURCE_USERNAME="admin"
#export SPRING_DATASOURCE_PASSWORD="Training123!"
#export SPRING_JPA_HIBERNATE_DDL_AUTO="none"
#export SPRING_JPA_PROPERTIES_HIBERNATE_DIALECT="org.hibernate.dialect.PostgreSQL9Dialect"
#export SPRING_JPA_SHOW_SQL="true"


export JAVA_OPTS="$JAVA_OPTS -Dspring.profiles.active=${PROFILE}"
export JAVA_OPTS="$JAVA_OPTS -Djwt.secretKey=${JWT_KEY}"

export SPRING_DATASOURCE_URL="jdbc:postgresql://${DB_URL}:${DB_PORT}/${DB_NAME}"
export SPRING_DATASOURCE_DRIVER_CLASS_NAME="org.postgresql.Driver"
export SPRING_DATASOURCE_USERNAME="${DB_USERNAME}"
export SPRING_DATASOURCE_PASSWORD="${DB_PW}"
export SPRING_JPA_HIBERNATE_DDL_AUTO="none"
export SPRING_JPA_PROPERTIES_HIBERNATE_DIALECT="org.hibernate.dialect.PostgreSQL9Dialect"
export SPRING_JPA_SHOW_SQL="true"