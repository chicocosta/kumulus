FROM tomcat:9.0.88-jre8
RUN rm -fr /usr/local/tomcat/webapps/crud-pessoa-0.0.1-SNAPSHOT
COPY ./crud-pessoa-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]


