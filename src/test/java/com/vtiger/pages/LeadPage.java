package com.vtiger.pages;

import com.vtiger.Utality.UIActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage extends UIActions
{
    public LeadPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='firstname']")
    WebElement td_fname;
    @FindBy(name = "lastname")
    WebElement td_lname;
    @FindBy(name = "company")
    WebElement tb_comp;
    @FindBy(name = "button")
    WebElement btn_save;
    @FindBy(xpath="//td[text()='First Name:']/following::td[1]")
    WebElement txt_fname;

    @FindBy(xpath="//td[text()='Last Name:']/following::td[1]")
    WebElement txt_lname;

    @FindBy(xpath="//td[text()='Company:']/following::td[1]")
    WebElement txt_comp;

    public void create_with_mandatory_filed(String fname, String lname, String comp)   // call in leadsteps
    {
        setTd_fname(fname);
        setTd_lname(lname);
        setText_comp(comp);
        clicksave();

    }

    public void setTd_fname(String fname)

    {
        SetInput(td_fname,fname,fname+" Has been Enter first name fileds");
    }

    public void setTd_lname(String lname)
    {
        //td_password.sendKeys(pwd);
        SetInput(td_lname,lname ,lname+ "Has been Enter last name fileds"); //Extend report
    }
    public void setText_comp(String comp)
    {
        //td_password.sendKeys(pwd);
        SetInput(tb_comp,comp ,comp+ "Has been Enter company fileds"); //Extend report
    }
    public void  clicksave()
    {
        // btn_Login.click();
        ClickElement(btn_save,"save button click"); //Extend report
    }


    public  void  verifyleadstep(String fname , String lname , String comp) //call in leadsteps
    {
        verifyleadcreation(txt_fname,fname,fname+ "expected test match with actual text");
        verifyleadcreation(txt_lname,lname,lname+ "expected test match with actual text");
        verifyleadcreation(txt_comp,comp,comp+ "expected test match with actual text");//Extend report
    }

}
