package com.dreamportal;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;



    public class HomePage {
        WebDriver driver;

        By loader = By.id("loadingAnimation");
        By main = By.id("mainContent");
        By myDreams = By.id("dreamButton");

        public HomePage(WebDriver driver) {
            this.driver = driver;
        }

        public boolean waitForLoaderToDisappear() {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                return wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
            } catch (Exception e) {
                return false;
            }
        }

        public boolean isMainVisible() {
            return driver.findElement(main).isDisplayed();
        }

        public void clickMyDreams() {
            driver.findElement(myDreams).click();
        }
    }
