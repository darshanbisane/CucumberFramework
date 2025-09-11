package com.vtiger.stepdefinition;

import com.vtiger.pages.HomePage;
import com.vtiger.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class leadsteps extends basesteps
{

    @When("user click on new lead.")
    public void User_click_on_new_lead()
    {
        hp.clickNewLead();
    }
    @Then("fill all mandatory fields and click on save.")
    public void all_mandatoty_fields()
    {
        ldp.create_with_mandatory_filed(dt.get(TcName).get("Firstname"), dt.get(TcName).get("Lastname"),dt.get(TcName).get("Company"));
    }

    @Then("lead should be created successfully.")
    public void lead_creation()
    {

        ldp.verifyleadstep(dt.get(TcName).get("FirstName"),dt.get(TcName).get("Lastname"),dt.get(TcName).get("Company"));
    }

}
