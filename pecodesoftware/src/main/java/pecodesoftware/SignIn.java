package pecodesoftware;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignIn {

    @Test
    public void signin(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.pecodesoftware.com/qa-portal/registerlogin/registerlogin.php");

        driver.findElement(By.xpath("/html/body/div/div/form/div[1]/input")).sendKeys("user");        ;
        driver.findElement(By.xpath("/html/body/div/div/form/div[2]/input")).sendKeys("pass");
        driver.findElement(By.xpath("/html/body/div/div/form/div[3]/input")).click();

        WebElement username = driver.findElement(By.xpath("/html/body/div/div/form/div[1]"));
        WebElement usernameParent = username.findElement(By.xpath(".."));

        String usernameError = usernameParent.findElement(By.xpath("/html/body/div/div/form/div[1]/span")).getText();
        Assert.assertEquals(usernameError, "No account found with that username.");

        driver.quit();
    }
}
