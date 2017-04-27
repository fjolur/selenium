package bdd.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class EntrepreneurSteps {
    protected WebDriver driver;
    private By fieldFioLocator = By.xpath(".//*[@id='fio']");
    private By fieldCityLocator = By.xpath(".//*[@id='city']");
    private By fieldNumberLocator = By.xpath(".//*[@id='tel']");
    private By fieldEmailLocator = By.xpath(".//*[@id='mail']");
    private By fieldPassLocator = By.xpath(".//*[@id='pass']");
    private By fieldCheckboxLocator = By.xpath(".//*[@id='entrepreneur-register-form']/div[1]/div/div[2]/form/div[5]/div[3]/div/label");

    @Given("^I am on new project registration page \"([^\"]*)\"$")
    public void setup(String url) {
//        System.setProperty("webdriver.gecko.driver", "C:\\KIT\\AboutTheCodeAutomationE2E\\e2e_automation\\src\\test\\resources\\geckodriver\\geckodriver.exe")
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kateryna.makarenko\\IdeaProjects\\selenium\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    public void fillData(By locator, String fillData){
        WebElement searchElement = driver.findElement(locator);
        searchElement.clear();
        searchElement.sendKeys(fillData);
        Assert.assertEquals(searchElement.getAttribute("value"), fillData);
    }

    @When("^I fill my First Name \"([^\"]*)\" and Last Name \"([^\"]*)\" into Full Name field$")
    public void iFillMyFirstNameAndLastNameIntoFullNameField(String firstName, String lastName) throws Throwable {
        String fullName = firstName + " " + lastName;
        fillData(fieldFioLocator, firstName + " " + lastName);
        Assert.assertEquals(driver.findElement(fieldFioLocator).getAttribute("value"), fullName);
    }

    @And("^I fill my City \"([^\"]*)\" into City field$")
    public void IfillmyCityintoCityfield(String city) throws Throwable {
        fillData(fieldCityLocator, city);
    }

    @And("^I fill my phone number \"([^\"]*)\" into Phone field$")
    public void iFillMyPhoneNumberIntoPhoneField(String number) throws Throwable {
        fillData(fieldNumberLocator, number);
    }

    @And("^I fill my email address \"([^\"]*)\" into Email field$")
    public void iFillMyEmailAddressIntoEmailField(String email) throws Throwable {
        fillData(fieldEmailLocator, email);
    }

    @And("^I fill my desired password \"([^\"]*)\" into Password field$")
    public void iFillMyDesiredPasswordIntoPasswordField(String pass) throws Throwable {
        fillData(fieldPassLocator, pass);
    }

    @And("^I set checkbox to show my password$")
    public void iSetCheckboxToShowMyPassword() throws Throwable {
        WebElement checkboxE = driver.findElement(fieldCheckboxLocator);
        Boolean  checkbox = driver.findElement(fieldCheckboxLocator).isSelected();
        checkboxE.clear();
 //       Assert.assertEquals(checkboxE.isSelected(), checkbox);
    }
}