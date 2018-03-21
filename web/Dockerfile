FROM jboss/wildfly:12.0.0.Final

MAINTAINER "Javersi"

COPY target/javersi-web.war wildfly/standalone/deployments/

RUN echo 'hosts: files mdns4_minimal [NOTFOUND=return] dns mdns4' >> /etc/nsswitch.conf

# Dodanie użytkownika do panelu administracyjnego
RUN wildfly/bin/add-user.sh admin admin --silent

# Dodanie nowej komendy, aby uruchomić panel zarządzania serwerem Wildfly
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
