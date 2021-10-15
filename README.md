## How to use:

- [Installation](#installation)
- [Examples](#examples)
- [Technologies](#technologies)
- [Patterns](#patterns)
- [Dependencies](#dependencies)
- [Reports](#reports)

---

## Installation
```
Install JDK 11.x
Install Maven
---

## Execution:

> Start hub and node of selenium grid

```
	1. Start Grid
	`java -jar selenium-server-standalone-<version>.jar -role hub`

	2. Start Node
	`java -jar selenium-server-standalone-<version>.jar -role node  -hub http://localhost:4444/grid/register`
	```

> Execute the command to run all tests in the project. Default browser is Chrome. Default environment is PRODUCTION.

```
	$ mvn clean test
```
> Execute the command to run only one test class in the project

```
	$ mvn clean test -Dtest=SearchWeatherTest
```

> Execute the command to run on specific browser or environment (ex: run on browser Firefox, environment is QA)

```
	$ mvn clean -P firefox,qa test
```
---

## Technologies:
- Selenium WebDriver
- Java
- Maven

## Patterns
- Fluent Page Object
- PageFactory

---

### Dependencies
* *[selenium](https://www.selenium.dev/)* 
* *[testng](https://testng.org/)* 
* *[extentreports](http://www.extentreports.com/)*
* *[webdrivermanager](https://github.com/bonigarcia/webdrivermanager)* 

---

## Reports
* To view report of test, access the file: */target/report/test_execution.html*

---


//                       _oo0oo_
//                      o8888888o
//                      88" . "88
//                      (| -_- |)
//                      0\  =  /0
//                    ___/`---'\___
//                  .' \\|     |// '.
//                 / \\|||  :  |||// \
//                / _||||| -:- |||||- \
//               |   | \\\  -  /// |   |
//               | \_|  ''\---/''  |_/ |
//               \  .-\__  '-'  ___/-. /
//             ___'. .'  /--.--\  `. .'___
//          ."" '<  `.___\_<|>_/___.' >' "".
//         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//         \  \ `_.   \_ __\ /__ _/   .-` /  /
//     =====`-.____`.___ \_____/___.-`___.-'=====
