# Nespresso Test

Repository with the three required tests for Nespresso

### Prerequisites

- Have Java properly installed on your machine
- Have Google Chrome Browser installed
- Some code editor IDE, such as IntelliJ IDE
- Libraries:
  * Selenium Standalone server  from https://www.seleniumhq.org/download/

### Installing

1. Get latest stable version of Chrome Driver from: https://sites.google.com/a/chromium.org/chromedriver/
2. Clone the repository from https://github.com/lucialuzuriaga/nespresso
3. Open the project with IntelliJ
4. Go to File > Project Structure and select Java 1.8 as SDK
5. On Project Structure > Modules select src as folder
5. Project Structure > Libraries and the selenium server standalone downloaded earlier and select Apply and then OK
6. Open src/test/NespressoTest.java and hit alt+Enter on the annotations to add Junit4 to classpath.

## Running the tests

1. Open Chrome Driver and verify that it starts running. You should see something like
```
Starting ChromeDriver 2.35.528157 (4429ca2590d6988c0745c24c8858745aaaec01ef) on port 9515
Only local connections are allowed.
```

2. Right click on src/test/NespressoTest.java and select Run. Chrome browser should open and the three tests will be run. 
