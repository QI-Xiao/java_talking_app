FROM tomcat:9.0.76-jre17
MAINTAINER Xiao
ARG PROFILE=dev
ENV PROFILE ${PROFILE}
EXPOSE 8080

RUN rm -rf /usr/local/tomcat/webapps/ROOT
COPY ./*.war /usr/local/tomcat/webapps/ROOT.war
COPY ./setenv.sh  /usr/local/tomcat/bin/setenv.sh