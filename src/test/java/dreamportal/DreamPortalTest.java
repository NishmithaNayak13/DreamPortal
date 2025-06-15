package dreamportal;
import com.dreamportal.HomePage;
import com.dreamportal.DreamDiaryPage;
import com.dreamportal.DreamSummaryPage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class DreamPortalTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void testHomePage() {
        driver.get("https://arjitnigam.github.io/myDreams/");
        HomePage home = new HomePage(driver);
        assertTrue(home.waitForLoaderToDisappear());
        assertTrue(home.isMainVisible());
        home.clickMyDreams();
    }

    @Test(priority = 2)
    public void testDreamDiaryPage() {
        switchToTab(1); // switch to second tab (0-indexed)
        DreamDiaryPage diary = new DreamDiaryPage(driver);
        assertTrue(diary.validateRowCount());
        assertTrue(diary.validateDreamTypes());
        assertTrue(diary.validateAllColumnsFilled());
    }

    @Test(priority = 3)
    public void testDreamSummaryPage() {
        switchToTab(2); // switch to third tab
        DreamSummaryPage summary = new DreamSummaryPage(driver);
        assertTrue(summary.verifyStat("Good Dreams", 6));
        assertTrue(summary.verifyStat("Bad Dreams", 4));
        assertTrue(summary.verifyStat("Total Dreams", 10));
        assertTrue(summary.verifyStat("Recurring Dreams", 2));
        switchToTab(1);
        DreamDiaryPage diary = new DreamDiaryPage(driver);
        assertTrue(diary.verifyRecurringDreams("Flying over mountains", "Lost in maze"));
    }

    private void switchToTab(int index) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
