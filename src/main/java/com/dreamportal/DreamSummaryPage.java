package com.dreamportal;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import java.util.List;

public class DreamSummaryPage {
    WebDriver driver;
    static Logger logger = Logger.getLogger(DreamSummaryPage.class);
    By rows = By.cssSelector("table tbody tr");

    public DreamSummaryPage(WebDriver driver) {
        this.driver = driver;
        logger.info("DreamSummaryPage initialized.");
    }

    public int getStat(String id) {
        logger.info("Fetching stat for: " + id);
        List<WebElement> rowElements = driver.findElements(rows);
        for (WebElement row : rowElements) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.size() == 2 && cells.get(0).getText().equalsIgnoreCase(id)) {
                int statValue = Integer.parseInt(cells.get(1).getText());
                logger.info("Stat found for " + id + ": " + statValue);
                return statValue;
            }
        }

        logger.warn("Stat not found for " + id + ", returning 0.");
        return 0;
    }

    public boolean verifyStat(String id, int expected) {
        int value = this.getStat(id);
        boolean result = value == expected;
        logger.info("Verifying stat for '" + id + "'. Expected: " + expected + ", Found: " + value + " → " + (result ? "PASS" : "FAIL"));
        return result;
    }
}
