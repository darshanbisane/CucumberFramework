package com.vtiger.pages;
import com.vtiger.Utality.UIActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends UIActions
{

  //  public WebDriver driver;  // no need because aleady define in parent file i.e UIActions
    public HomePage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(linkText = "Home")
    WebElement lnk_Home;
    @FindBy(linkText = "Logout")
    WebElement lnk_Logout;
    @FindBy(linkText = "New Lead")
    WebElement lnk_NewLead;

    public void verifyHome()
    {
       // lnk_Home.isDisplayed();
        ElementDisp(lnk_Home , "Home tab is display on Homepage"); //for Extent report
    }
    public void verifyLogout()
    {
        //lnk_Logout.isDisplayed();
        ElementDisp(lnk_Logout,"Logout link exit on homepage");//for Extent report
    }
    public void clickLogout()
    {
      //  lnk_Logout.click();
        ClickElement(lnk_Logout,"Logout link clicked");//for Extent report
    }
    public void clickNewLead()
    {
        //  lnk_Logout.click();
        ClickElement(lnk_NewLead,"New Lead link clicked"); //for Extent report
    }
}
