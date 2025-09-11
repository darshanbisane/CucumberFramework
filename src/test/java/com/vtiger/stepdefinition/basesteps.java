package com.vtiger.stepdefinition;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.vtiger.pages.HomePage;
import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class basesteps
{
    public static Properties pr;
    public static WebDriver driver;
    public static LoginPage lp;
    public static HomePage hp;
    public static LeadPage ldp;

    public static Map<String,Map<String,String>> dt;
    public static String TcName;
    public static  ExtentHtmlReporter htmlReporter ;
    public static  ExtentReports extent;  //for Extent report
    public static ExtentTest report;  //for Extent report


    public void Initiation()
    {
        readFile();
       // System.exit(0);
       // if(pr == null)
        readProperties();
      //  if(driver == null)
        launchApp();
    }
    //using Config.properties file
    public void launchApp()
    {
        if(pr.getProperty("browser").equalsIgnoreCase("edge"))
        {
            driver = new EdgeDriver();
        }
        else if (pr.getProperty("browser").equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
        }
        else if (pr.getProperty("browser").equalsIgnoreCase("headless"))
        {
            ChromeOptions options = new ChromeOptions(); //This code Copied from chat gpt
            options.addArguments("--headless");   // Run in headless mode
            options.addArguments("--disable-gpu"); // (Recommended for Windows)
            options.addArguments("--window-size=1920,1080"); // optional, set resolution
            driver= new ChromeDriver(options);
        }
        else
        {
            driver = new ChromeDriver();
        }
        driver.get(pr.getProperty("Appurl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(pr.getProperty("globalwait"))));

    }
// Function for read Properties file
    public void readProperties()
    {
        try {
            pr = new Properties();
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Config.properties");
            pr.load(file);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    // Function for read Excel file
    public void readFile() {
        try {
            Fillo fillo = new Fillo();   // This code copied from fillo
            Connection connection = fillo.getConnection(System.getProperty("user.dir")+"/src/test/resources/TestData/data.xlsx");
            String strQuery = "Select * from Sheet1";
            Recordset recordset = connection.executeQuery(strQuery);
            int rows= recordset.getCount(); // -->Count of row
            List<String> ls= recordset.getFieldNames(); //Becz direct colume count () not available so we are using getFieldNames
            int colms =ls.size();   //---->Count of Columes
            dt = new HashMap<>();  //globally defined
            while(recordset.next())

            //for(int i=1;i<=rows-1;i++)  //-->For rows
            {
                Map<String,String> rowsdata = new LinkedHashMap<>();
                for(int j=1;j<colms;j++)  //-->For colums
                {
                    //String Colmname=ls.get(j);
                    //String Colmval =recordset.getField(ls.get(j));
                    rowsdata.put(ls.get(j),recordset.getField(ls.get(j))); // For kay and value
                }
                dt.put(recordset.getField("TcName"),rowsdata) ;
            }
            System.out.println(dt);

            recordset.close();
            connection.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    //Function for create Extent report
  public void createExtendreport()
  {
      Date d = new Date();
      DateFormat ft = new SimpleDateFormat("ddmmyyyyhhmmss");
      String filename = ft.format(d);
     htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/src/test/java/com/vtiger/reports/"+"extentreport_"+filename+".html"); // This is comparable only with- extentreports (version 4.0.6)
      extent = new ExtentReports();  //Create an object
      extent.attachReporter(htmlReporter);
      extent.setSystemInfo("Tester", "Darshan");
      extent.setSystemInfo("Environment", "QA");
      htmlReporter.config().setTheme(Theme.DARK);
      htmlReporter.config().setDocumentTitle("Automation Report");
      htmlReporter.config().setReportName("Cucumber Test Results");
  }

}
