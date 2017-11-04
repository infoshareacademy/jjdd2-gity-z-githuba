FROM jboss/wildfly:latest
CMD ["ls -ll"]

ADD config /opt/jboss/wildfly/config/

COPY target/EMailApp.war /opt/jboss/wildfly/config/

CMD ["/opt/jboss/wildfly/config/execute.sh"]

