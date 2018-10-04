#! /usr/bin/bash

killall chromedriver
killall geckodriver
mvn clean 
mvn verify -pl gui-tests -Dbrowser=firefox -Dthread.count=5 -Dis.running.on.travis=false
cd gui-tests/target
allure serve