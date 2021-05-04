
import Base.Base.BaseUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.Messages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class MyStepdefs extends BaseUtil {
    private BaseUtil baseUtil;

    public MyStepdefs (BaseUtil util) {
        this.baseUtil = util;
    }

    private WebDriver driver;
    @Given("I am in the login page")
    public void iAmInTheLoginPageOfTheParaBankApp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\toqa\\Desktop\\cirts\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://parabank.parasoft.com/parabank/index.htm");

    }



    @Given("I am in the login page of the Para Bank Application")
    public void iAmInTheLoginPageOfTheParaBankApplication() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\toqa\\Desktop\\cirts\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://parabank.parasoft.com/parabank/index.htm");

    }

    @When("I enter valid {string} and {string} with {string}")
    public void i_enter_valid_credentials(String username, String password, String userFullName) {
        baseUtil.userFullName = userFullName;
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("username")).submit();

    }



    @Then("I should be taken to the Overview page")
    public void iShouldBeTakenToTheOverviewPage() {
        String actualuserFullName = driver.findElement(By.className("smallText")).getText();
        assertTrue(actualuserFullName, actualuserFullName.contains(baseUtil.userFullName));
        driver.findElement(By.linkText("Log Out")).click();


    }
    @After()
    public void tear(){
        driver.quit();
    }
}

