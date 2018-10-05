#! /usr/bin/bash

killall chromedriver
killall geckodriver
mvn clean 
mvn test -pl gui-tests -Dbrowser=chrome -Dthread.count=5
cd gui-tests/target
allure serve