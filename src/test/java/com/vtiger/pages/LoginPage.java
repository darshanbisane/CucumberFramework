package com.vtiger.pages;

import com.vtiger.Utality.UIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends UIActions {
  //  public WebDriver driver; // no need because aleady define in parent file i.e UIActions

    public LoginPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    // page factory approach
    @FindBy(xpath = "//input[@name='user_name']")
    WebElement td_userid;
    @FindBy(name = "user_password")
    WebElement td_password;
    @FindBy(name = "Login")
    WebElement btn_Login;
    @FindBy(xpath = "//*[contains(text(),'You must specify a valid username and password.')]")
    WebElement text_errormsg;

    // @FindBy(name = "user_password1")  // for multiple value
    //  List<WebElement>ids;

    // String uid = "user_name";   // ------------>2nd logic
   // By uid = By.xpath("//@Input[@name='user_name']"); //---->Direct replacing xpath

    public void login(String uid, String pwd) {

        //driver.findElement(By.xpath(Locators.userid)).click(); // 1st logic
        // driver.findElement(By.name(uid)).click();  // 2nd logic
        // driver.findElement(uid).click(); //Direct replacing xpath.

        /*td_userid.clear();
        td_userid.sendKeys(uid);
        td_password.clear();
        td_password.sendKeys(pwd);
        btn_Login.click();*/
        setTd_userid(uid);
        setTd_password(pwd);
        clickLogin();

        //btn_Login.click();
    }

    public void setTd_userid(String uid)

    {
       /* try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(td_userid));
            td_userid.clear();
            td_userid.sendKeys(uid);
        }
        catch (Exception e)
        {
            e.getMessage();
        }*/
        SetInput(td_userid,uid,uid+ "Has been Enter User name fileds");//for Extent report
    }

    public void setTd_password(String pwd)
    {
       /* try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(td_password));
            td_password.clear();
            td_password.sendKeys(pwd);
        }
        catch (Exception e)
        {
            e.getMessage();
        }*/

        //td_password.sendKeys(pwd);
        SetInput(td_password,pwd ,pwd+ "Has been Enter User name fileds"); //for Extent report
    }
    public void  clickLogin()
    {
       // btn_Login.click();
        ClickElement(btn_Login,"Login button click"); // for Extent report
    }
    public  void  verifyLogin()
    {
       // btn_Login.isDisplayed();
        ElementDisp(btn_Login,"Login button exist on login page");//for Extent report
    }
    public  void  text_errormsg()
    {
       // text_errormsg.isDisplayed();
        ElementDisp(text_errormsg,"Error message display sucessfully");//for Extent report

    }

}

