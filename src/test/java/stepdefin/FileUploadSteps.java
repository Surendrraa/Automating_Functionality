package stepdefin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;




import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadSteps {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.dealsdray.com/");
    }

    @Test
    public void fileUploadTest() throws InterruptedException {
        driver.findElement(By.name("username")).sendKeys("prexo.mis@dealsdray.com");
        driver.findElement(By.name("password")).sendKeys("prexo.mis@dealsdray.com");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//span[text()='Order']")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//span[text()='Orders']")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//button[text()='Add Bulk Orders']")).click();
        Thread.sleep(4000);

        String filePath = System.getProperty("user.dir");
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(filePath + "\\Files\\demo-data.xlsx");
        driver.findElement(By.xpath("//button[text()='Import']")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//button[text()='Validate Data']")).click();
        Thread.sleep(8000);

      
            Alert alert = driver.switchTo().alert();
            alert.accept(); // Click on OK if it's a JavaScript alert
            Thread.sleep(4000);
       
      
        // Capture the full page screenshot using Shutterbug
        Shutterbug.shootPage(driver, Capture.FULL_SCROLL, true)
                  .withName("Screenshot.png")
                  .save("/AUTOMATION_FUNCTIONALITY_TEST/Screenshots/FileUpload");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    }

