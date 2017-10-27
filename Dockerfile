FROM jboss/wildfly:latest

MAINTAINER "InfoShare Academy"

ADD target/EMailApp.war /opt/jboss/wildfly/standalone/deployments/

RUN wildfly/bin/add-user.sh admin admin --silent

EXPOSE 8801
EXPOSE 9900

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
