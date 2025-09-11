package com.vtiger.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class login3
{
    public WebDriver driver;
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://localhost:100");

    }
    @When("user enters a valid username and valid password")
    public void user_enters_a_valid_username_and_valid_password()
    {
        driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");

    }
    @When("clicks on the login button")
    public void clicks_on_the_login_button()
    {
        driver.findElement(By.xpath("//input[@name='Login']")).click();
    }
    @Then("user should be navigated to the home page")
    public void user_should_be_navigated_to_the_home_page()
    {
        driver.findElement(By.linkText("Home")).isDisplayed();
    }
    @Then("user should see the logout link")
    public void user_should_see_the_logout_link()
    {
        driver.findElement(By.xpath("//*[Contains(text(),You must specify a valid username and password.")).isDisplayed();
        driver.quit();
    }

    @When("user enters a valid username and invalid password")
    public void user_enters_a_valid_username_and_invalid_password()
    {
        driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin1");
        driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin2");
    }
    @Then("user should see an error message {string}")
    public void user_should_see_an_error_message(String string) {
        driver.findElement(By.xpath("//*[contains(text(),You must specify a valid username and password.)")).isDisplayed();
    }

}
