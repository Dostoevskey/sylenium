taskkill /f /im chromedriver.exe
taskkill /f /im geckodriver.exe
cd..
call mvn clean test -pl gui-tests -Dbrowser=firefox -Dthread.count=5
cd gui-tests/target
call allure serve