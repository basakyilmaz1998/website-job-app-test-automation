Jobs.lever.co Test Automation Project
This is a software test automation for the application form, created via the Lever company.
The page will remain open until August 15, 2024.

Prerequisites
chromedriver.exe
Make sure 'chromedriver.exe' version:128, compatible with your Chrome browser.
You can find your current Chrome version under Settings > About Chrome
Update the path to 'chromedriver.exe' in the value parameter of the property with the key 'webdriver.chrome.driver' located in 'src/test/java/BaseTest.java'

Test Classes
'EndToEndTest.java'

This scenario tests:
1. Visit https://useinsider.com/ and verify the homepage loads.
2. Select “Company” > “Careers” in the navigation bar and ensure the Career page and its Locations, Teams, Life at Insider sections load.
3. Go to https://useinsider.com/careers/quality-assurance/, click “See all QA jobs”, filter by Location: Istanbul, Turkey and Department: Quality Assurance, and check job list presence.
4. Verify all job listings have Position, Department, and Location fields containing “Quality Assurance” and “Istanbul, Turkey”.
5. Click “View Role” and confirm redirection to the Lever Application form.

Built With
Programming Languages: Java
Environment: JDK 17.0.10
Maven 2.22.0
Log4j 1.2.17
JUnit 5.10.1
Selenium 4.24.0
