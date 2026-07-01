package com.vtiger.stepdefinition;

import com.vtiger.pages.HomePage;
import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class login extends basesteps
{
     @Before
    public void getScanerio(Scenario scenario)
    {
        if(htmlReporter== null)
        createExtendreport();      // for Extent report
       TcName = scenario.getName();
       report = extent.createTest(TcName); //for Extent report
        Initiation();  // basestep madhun aala ahe configuration file chi functionality call karnay sathi.
    }
    @After
    public void Quitbro()
    {
        extent.flush(); //for Extent report
        if(driver != null)
        {
            driver.quit();
        }
    }
   /* public  WebDriver driver;
    public  LoginPage lp;
    public  HomePage hp;*/

    @Given("user should be on the login page.")
    public void user_should_be_on_the_login_page() {
        /*driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://localhost:100");*/
        if(driver == null)
            launchApp();
        lp = new LoginPage(driver);   // login page connectivity
        hp = new HomePage(driver);  // home page Connectivity
        ldp = new LeadPage(driver); // lead page Connectivity
    }
    @When("user Enters valid Credential and click on login page.")
    public void user_enters_valid_credential_and_click_on_login_page()
    {
       // lp.login("admin","admin");
        lp.login(dt.get(TcName).get("UserId"), dt.get(TcName).get("Password"));
    }
    @Then("user should be navigate to home page.")
    public void user_should_be_navigate_to_home_page()
    {
        hp.verifyHome();
    }

    @Then("user can see logout link on home page.")
    public void user_can_see_logout_link_on_home_page()
    {

        hp.verifyLogout();
       // driver.quit();

    }
    @When("user Enters Invalid Credential and click on login page.")
    public void user_enters_invalid_credential_and_click_on_login_page()
    {
       // lp.login("admin12","admin12");
        lp.login(dt.get(TcName).get("UserId"),dt.get(TcName).get("Password"));
    }
    @Then("user should be on login page.")
    public void user_should_be_on_login_page()
    {
        lp.verifyLogin();
    }
    @Then("user can see the error message.")
    public void user_can_see_the_error_message()
    {
        lp.text_errormsg();
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       // wait.until(ExpectedConditions.titleContains("You must specify a valid username and password."));
      //  driver.quit();
    }
    @When("user Enters Invalid Credential userid as {string} and password as {string} and click on login page.")
    public void user_enters_invalid_credential_userid_as_and_password_as_and_click_on_login_page(String uid, String pwd)
     {
        lp.login(uid,pwd);
     }
    @Then("user should be navigated to home page.")
    public void user_should_be_navigated_to_home_page()
    {
       hp.verifyHome();
    }
}
