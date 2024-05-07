package org.etiya;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;




    public class TestsMethodWithJunit {

        private WebDriver driver;

        @Before
        public void setUp() {
            driver = new ChromeDriver();
            driver.navigate().to("https://www.saucedemo.com/v1/");
        }

        @After
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }

        @Test
        public void testLoginPageTitle() {
            String expectedTitle = "Swag Labs";
            String actualTitle = driver.getTitle();
            assertEquals(expectedTitle, actualTitle);
        }

        @Test
        public void testLogin() {
            WebElement usernameInput = driver.findElement(By.id("user-name"));
            usernameInput.sendKeys("esatyener");

            WebElement passwordInput = driver.findElement(By.id("password"));
            passwordInput.sendKeys("esat@YENER");

            WebElement loginBtn = driver.findElement(By.id("login-button"));
            loginBtn.click();

            WebElement errorText = driver.findElement(By.tagName("h3"));
            String expectedError = "Epic sadface: Username and password do not match any user in this service";
            String actualError = errorText.getText();
            assertEquals(expectedError, actualError);
        }
        @Test
        public void testUsernameInputValue() {
            WebElement usernameInput = driver.findElement(By.id("user-name"));
            usernameInput.sendKeys("esatyener");
            assertEquals("esatyener", usernameInput.getAttribute("value"));
        }

        @Test
        public void testTotalInputCount() {
            List<WebElement> inputs = driver.findElements(By.cssSelector("input"));
            int expectedCount = 2; // Kullanıcı adı ve şifre inputları
            assertEquals(expectedCount, inputs.size());
        }

        @Test
        public void testPasswordInputEnabled() {
            WebElement passwordInput = driver.findElement(By.id("password"));
            assertTrue(passwordInput.isEnabled());
        }

        @Test
        public void testLogoDisplayed() {
            WebElement logo = driver.findElement(By.className("login_logo"));
            assertTrue(logo.isDisplayed());
        }
    }


