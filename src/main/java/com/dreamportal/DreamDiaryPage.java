package com.dreamportal;

import org.openqa.selenium.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DreamDiaryPage {

    WebDriver driver;

    By rows = By.cssSelector("table tbody tr");

    public DreamDiaryPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean validateRowCount() {
        List<WebElement> rowElements = driver.findElements(rows);
        return rowElements.size() == 10;
    }

    public boolean validateDreamTypes() {
        List<WebElement> rowElements = driver.findElements(rows);
        for (WebElement row : rowElements) {
            String type = row.findElements(By.tagName("td")).get(2).getText();
            if (!(type.equals("Good") || type.equals("Bad"))) return false;
        }
        return true;
    }

    public boolean validateAllColumnsFilled() {
        List<WebElement> rowElements = driver.findElements(rows);
        for (WebElement row : rowElements) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            if (cols.size() != 3) return false;
            for (WebElement col : cols) {
                if (col.getText().trim().isEmpty()) return false;
            }
        }
        return true;
    }
    public boolean verifyRecurringDreams(String... expectedDreams) {
        List<WebElement> rowElements = driver.findElements(rows);
        Map<String, Long> dreamCounts = rowElements.stream()
                .map(row -> row.findElements(By.tagName("td")).get(0).getText())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<String> recurringDreams = dreamCounts.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return Arrays.asList(expectedDreams).containsAll(recurringDreams) && recurringDreams.containsAll(Arrays.asList(expectedDreams));


    }
}
