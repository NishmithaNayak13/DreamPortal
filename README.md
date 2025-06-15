# Dream Portal Test Automation

Automated functional UI tests for the Dream Portal website using Selenium WebDriver, TestNG, and Java with the Page Object Model (POM) design pattern.

🌐 Live URL
[Dream Portal Website](https://arjitnigam.github.io/myDreams/)

📌 Technologies Used
- Java
- Selenium WebDriver
- TestNG
- Apache Log4j (for logging)
- Maven

📁 Project Structure
DreamPortalTest/
├── pom.xml
├── logs/
│ └── automation.log ← Log output file
├── src/
│ ├── main/java/com/dreamportal/
│ │ ├── HomePage.java
│ │ ├── DreamDiaryPage.java
│ │ └── DreamSummaryPage.java ← With logging
│ └── test/java/dreamportal/
│ └── DreamPortalTest.java
├── resources/
│ └── log4j.properties ← Log4j config file


✅ Test Scenarios Covered

1. Home Page Validation
- Wait for loading animation to disappear.
- Ensure main content is visible.
- Click on "My Dreams" to open the diary tab.

2. Dream Diary Page
- Validate exactly 10 rows of dreams.
- Ensure dream type is either Good or Bad.
- Check all table cells are filled.
- Verify recurring dreams match expected values.

3. Dream Summary Page
- Validate counts:
  - Good Dreams = 6
  - Bad Dreams = 4
  - Total Dreams = 10
  - Recurring Dreams = 2
  - Log messages track every verification step



🙌 Author
Nishmitha
MCA Graduate | Aspiring QA Engineer



