Website Job App Test Automation Project
This is a software test automation for the application form, created via the Lever company.

Prerequisites
chromedriver.exe
Make sure 'chromedriver.exe' version:128, compatible with your Chrome browser.
You can find your current Chrome version under Settings > About Chrome
Update the path to 'chromedriver.exe' in the value parameter of the property with the key 'webdriver.chrome.driver' located in 'src/test/java/BaseTest.java'

Test Classes
'EndToEndTest.java'

This scenario tests:
1. Visit website and verify the homepage loads.
2. Select “Company” > “Careers” in the navigation bar and ensure the page and sections load.
3. Filter by location and department, check job list presence.
4. Verify job listings have Position, Department, and Location fields containing selected items. 
5. Click “View Role” and confirm redirection.

Built With
Programming Languages: Java
Environment: JDK 17.0.10
Maven 2.22.0
Log4j 1.2.17
JUnit 5.10.1
Selenium 4.24.0
