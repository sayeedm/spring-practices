#!/bin/sh

mvn clean install
mvn -Djava.net.preferIPv4Stack=true spring-boot:run
