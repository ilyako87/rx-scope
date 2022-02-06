FROM tomcat:latest
ADD target/rx-server-*.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]