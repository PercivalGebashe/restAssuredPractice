# RestAssured Practice  

## Overview  
This repository contains API automation test scripts using **RestAssured**, designed to validate and test RESTful web services efficiently. The project follows best practices in API testing, ensuring reliability, maintainability, and integration with CI/CD pipelines.  

## Features  
- Automated API testing using **RestAssured**  
- Test execution managed by **TestNG**  
- Build and dependency management with **Maven**  
- Assertions for response validation and contract testing  
- Integration with **CI/CD pipelines** for continuous testing  

## Prerequisites  
Ensure you have the following installed before running the tests:  
- **Java** (JDK 8 or later)  
- **Maven** (Latest version)  
- **TestNG** (Configured in `pom.xml`)  

## Installation & Setup  
1. Clone the repository:  
   ```sh  
   git clone https://github.com/PercivalGebashe/restAssuredPractice.git  
   cd restAssuredPractice  
   ```  
2. Install dependencies:  
   ```sh  
   mvn clean install  
   ```  

## Running the Tests  
To execute the API test suite, use:  
```sh  
mvn test  
```  
For specific test execution, modify the **TestNG** XML configuration file as needed.  

## Project Structure  
- `src/test/java/` → API test scripts  
- `pom.xml` → Maven dependencies and configurations  

## Contributing  
Feel free to fork the repository and submit pull requests for improvements. Ensure that all changes are properly tested before submitting.  

## License  
This project is open-source under the **MIT License**.  
