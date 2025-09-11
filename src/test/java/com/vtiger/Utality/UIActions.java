package com.vtiger.Utality;
import com.vtiger.stepdefinition.basesteps;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class UIActions
{
    public WebDriver driver;
    public WebDriverWait wait;
    public UIActions(WebDriver driver)
    {
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    // for Input
    public void SetInput(WebElement ele , String value, String msg)
    {
        try
        {
            wait.until(ExpectedConditions.visibilityOf(ele));
            ele.clear();
            ele.sendKeys(value);
            basesteps.report.pass(msg+ getScreenshort());//for Extent report
        }
        catch (Exception e)
        {
            basesteps.report.fail(e.getMessage()+ getScreenshort());//for Extent report
            e.printStackTrace();
        }

    }
   // for click
    public void ClickElement(WebElement ele , String msg)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(ele));
            ele.click();
            basesteps.report.pass(msg+ getScreenshort());//for Extent report
        }
        catch (Exception e)
        {
            basesteps.report.fail(e.getMessage()+ getScreenshort());//for Extent report
            e.printStackTrace();
        }

    }
    // for Display Element (ElementExist text)
    public void ElementDisp(WebElement ele , String msg )
    {
        try
        {
            wait.until(ExpectedConditions.visibilityOf(ele));
            ele.isDisplayed();
            basesteps.report.pass(msg+ getScreenshort()); //for Extent report
        }
        catch (Exception e)
        {
            basesteps.report.fail(e.getMessage()+ getScreenshort()); //for Extent report
            e.printStackTrace();
        }

    }
    public void verifyleadcreation(WebElement elm,String ExpText, String msg)
    {
        try
        {
            wait.until(ExpectedConditions.visibilityOf(elm));
            String actText = elm.getText();
            if (actText.trim().equals(ExpText))
                basesteps.report.pass(msg + getScreenshort());
            else
                basesteps.report.pass(ExpText + " Expected text did not match with actual text" + actText + "   " + getScreenshort());
        }
        catch(Exception e)
            {
                basesteps.report.fail(e.getMessage() + getScreenshort());
                e.printStackTrace();
            }

    }
    //code for capture Screenshort
    public String getScreenshort()  {
        Date dt =new Date();
        DateFormat df= new SimpleDateFormat("DDMMYYY-HHMMSS");
        String filename = df.format(dt); // for unique file name
        String path = System.getProperty("user.dir")+"/src/test/java/com/vtiger/reports/Screenshort/"+filename+".png";
        TakesScreenshot ts = ((TakesScreenshot)driver);  //TakesScreenshot is an interface.And We cannot create an object of interface .so we are cast using 'driver'.*/
        File SrcFile = ts.getScreenshotAs(OutputType.FILE); // We are stored Screenshot in a file
        //move img file to new destination
        File DestFile = new File(path);
        //copy file at destination
        try
        {
            FileUtils.copyFile(SrcFile, DestFile);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        String imagepath = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='"+path+"'><span class='label time-taken grey lighten-1 white-text'>Screenshot</span><a>";
        return imagepath;
    }

}

