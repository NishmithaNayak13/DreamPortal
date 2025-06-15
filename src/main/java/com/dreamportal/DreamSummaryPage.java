package com.dreamportal;
import org.openqa.selenium.*;

import java.util.List;

public class DreamSummaryPage {
    WebDriver driver;
    By rows = By.cssSelector("table tbody tr");

    public DreamSummaryPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getStat(String id) {
        List<WebElement> rowElements = driver.findElements(rows);
        for (WebElement row : rowElements) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.size() == 2 && cells.get(0).getText().equalsIgnoreCase(id)) {
                return Integer.parseInt(cells.get(1).getText());
            }
        }

        return 0;
    }

    public boolean verifyStat(String id, int expected) {
int value = this.getStat(id);
        return value == expected;
    }



}

