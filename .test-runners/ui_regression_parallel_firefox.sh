#! /usr/bin/bash

killall chromedriver
killall geckodriver
cd..
mvn clean test -pl gui-tests -Dbrowser=firefox -Dthread.count=5
cd gui-tests/target
call allure serve