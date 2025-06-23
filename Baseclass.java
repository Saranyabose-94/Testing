package com.base;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public abstract class Baseclass {
	public static WebDriver driver;
	
	public static ExtentReports extentReports;
	public static File file;
	public static JavascriptExecutor javaScriptExecutor;
	
	
	//BROWSER LAUNCH
	protected static WebDriver browserLaunch(String browserName)
	{
		try {
			if(browserName.equalsIgnoreCase("chrome")) {
				driver= new ChromeDriver();
			}
			else if(browserName.equalsIgnoreCase("firefox")) {
				driver= new FirefoxDriver();
			}
			else if(browserName.equalsIgnoreCase("edge")) {
				driver= new EdgeDriver();
			}
		} catch (Exception e) {
			
			Assert.fail("ERROR: OCCUR DURING BROWSER lAUNCH");
		}
		
		driver.manage().window().maximize();
		return driver;
	}

	
	  //GET URL
    protected static void getUrl(String url)
    {
    	try {
			driver.get(url);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING BROWSER GETTING URL");
		}
    }
    
    
//BROWSER CLOSE
    protected static void browserClose()
    {
    	try {
			driver.close();
		} catch (Exception e) {
			
			Assert.fail("ERROR: OCCUR DURING BROWSER CLOSE");
		}
    }
    
    
    //BROWSER QUIT
    protected static void browserQuit()
    {
    	try {
			driver.quit();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING BROWSER QUIT");
		}  
    
    }
    
    
  
    
    //NAVIGATE METHODS
    protected static void navigateMethods(String type)
    
    {
    	try {
    		if(type.equalsIgnoreCase("back")) {
			driver.navigate().back();
    		} else if(type.equalsIgnoreCase("forward")) {
    			driver.navigate().forward();
    		} else if(type.equalsIgnoreCase("refresh")) {
    			driver.navigate().refresh();
    		}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING NAVIGATE FUNCTION");
		}
    }
    
    
    //FRAME
    protected static void switchToFrame(WebElement element,String type,String value)
    {
    	try {
			if(type.equalsIgnoreCase("index")) {
				driver.switchTo().frame(Integer.parseInt(value));
			}else if(type.equalsIgnoreCase("name")) {
				driver.switchTo().frame(element);
			}else if(type.equalsIgnoreCase("WebElement")) {
				driver.switchTo().frame(element);
			}
		} catch (NumberFormatException e) {
			Assert.fail("ERROR: OCCUR DURING SWITICHING TO FRAME");
		}
    }
    
    
    //NAVIGATE TO
    protected static void navigateToUrl(String navigateUrl)
    {
    	try {
			driver.navigate().to(navigateUrl);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING NAVIGATING TO URL ");
		}
    }
    
    
    //GET TITLE
    protected static void getTitle()
    {
    	try {
			String title=driver.getTitle();
			System.out.println("Title of the page: "+title);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING GETTING TITLE OF THE PAGE ");
		}
    	
    	
    }
    
    
    //GET TEXT
    protected static void getText(WebElement element)
    {
    	try {
			String text=element.getText();
			System.out.println(text);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING GETTING TITLE OF THE PAGE ");
		}
    	
    	
    }
    
    
    //GET CURRENT URL
    protected static void getCurrentUrl()
    {
    	try {
			driver.getCurrentUrl();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING GETTTING CURRENT URL OF THE PAGE ");
		}
    	
    }
    
    
    
    //GET ATTRIBUTE
    protected static void getAttribute(WebElement element,String value)
    {
    	try {
			element.getAttribute(value);
			
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING GET ATTRIBUTE  ");
		}
    	
    }
    
    
    //SIMPLE ALERT
    protected static void simpleAlert(String type)
    {
    	try {
			Alert alert=driver.switchTo().alert();
			if(type.equalsIgnoreCase("accept")) {
				alert.accept();
			}else if(type.equalsIgnoreCase("dismiss")) {
				alert.dismiss();
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING SIMPLE ALERT  ");
		}
    	
    }
    
    
    //CONFIRM ALERT
    
    protected static void confirmAlert(String type)
    {
    	try {
			Alert alert=driver.switchTo().alert();
			if(type.equalsIgnoreCase("accept")) {
				alert.accept();
			}else if(type.equalsIgnoreCase("dismiss")) {
				alert.dismiss();
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING CONFIRM ALERT  ");
		}
    	
    }
    
    
    //PROMT ALERT 
    protected static void promtAlert(String type)
    {
    	try {
			Alert alert=driver.switchTo().alert();
			if(type.equalsIgnoreCase("accept")) {
				alert.accept();
			}else if(type.equalsIgnoreCase("dismiss")) {
				alert.dismiss();
			} else if(type.equalsIgnoreCase("gettext")) {
				
				String text=alert.getText();
				System.out.println(text);
			}
			
			
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING PROMT ALERT  ");
		}}
    	
    	protected static void promtAlertInput(String type,String input) {
    		try {
				Alert alert=driver.switchTo().alert();
				{
					if(type.equalsIgnoreCase("sendkey")) {
						alert.sendKeys(input);
					}
				}
			} catch (Exception e) {
				Assert.fail("ERROR: OCCUR DURING PROMT ALERT INPUT  ");
			}
    	}
    	
    
    protected static void inputValues(WebElement element, String values) {
    	try {
			element.sendKeys(values);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING SENDKEY PASSING THE INPUT VALUE  ");
		}
    }
    protected static void elementClick(WebElement element) {
    	try {
			element.click();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING CLICKING THE ELEMENT  ");
		}
    }
    
    protected static void elementClear(WebElement element) {
    	try {
			element.clear();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING CLICKING THE ELEMENT  ");
		}
    }
    
    protected static void actionsOnElement(WebElement element, String type) {
    	try {
    		Actions build=new Actions(driver);
    		if(type.equalsIgnoreCase("contextClick")) {
			build.contextClick(element).build().perform();
    		} else if(type.equalsIgnoreCase("moveToelement")) {
    			build.moveToElement(element).build().perform();
    		} else if(type.equalsIgnoreCase("doubleclick")) {
    			build.doubleClick(element).build().perform();
    		}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING ACTIONS ON THE ELEMENT  ");
		}
    }
    
    protected static void robotClass(String type) {
    	try {
			Robot robo=new Robot();
			if(type.equalsIgnoreCase("up")) {
				robo.keyPress(KeyEvent.VK_UP);
				robo.keyRelease(KeyEvent.VK_UP);
			}else if(type.equalsIgnoreCase("down")) {
				 robo.keyPress(KeyEvent.VK_DOWN); 
				 robo.keyRelease(KeyEvent.VK_DOWN);
			}else if(type.equalsIgnoreCase("enter"))
			{
				robo.keyPress(KeyEvent.VK_ENTER); 
				robo.keyRelease(KeyEvent.VK_ENTER);
			}else if(type.equalsIgnoreCase("Tab"))
			{
				robo.keyPress(KeyEvent.VK_TAB); 
				robo.keyRelease(KeyEvent.VK_TAB);
			}
		} catch (AWTException e) {
			Assert.fail("ERROR: OCCUR DURING ROBOT ACTIONS(KEYBOARD ACTIONS) ");
		}
    }
    
    protected static void isoption(WebElement element,String type) {
    	if(type.equalsIgnoreCase("isSelected")) {
    		boolean selected= element.isSelected();
    		System.out.println("Is WebElement selected? :"+selected);
    	}else if(type.equalsIgnoreCase("isEnabled")) {
    		boolean enable= element.isEnabled();
    		System.out.println("Is WebElement Enabled? :"+enable);
    	}else if(type.equalsIgnoreCase("isEnabled")) {
    		boolean display= element.isDisplayed();
    		System.out.println("Is WebElement Displayed? :"+display);
    	}
    }
    
    protected static void elementSubmit(WebElement element) {
    	try {
			element.submit();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING SUBMITTING THE ELEMENT  ");
		}
    }
    
    
    protected static void selectDropDown(WebElement element,String type,String value) {
    	try {
			Select select =new Select(element);
			
			if(type.equalsIgnoreCase("visibleText")) {
				select.selectByVisibleText(value);	
			}else if(type.equalsIgnoreCase("value")) {
				select.selectByValue(value);
			} else if(type.equalsIgnoreCase("Index")) {
				select.selectByIndex(Integer.parseInt(value));
			}
		} catch (NumberFormatException e) {
			Assert.fail("ERROR: OCCUR DURING DROPDOWN ");
		}
    }
    
    
    protected static void deSelectDropDown(WebElement element,String type,String value) {
    	try {
			Select select =new Select(element);
			
			if(type.equalsIgnoreCase("visibleText")) {
				select.deselectByVisibleText(value);	
			}else if(type.equalsIgnoreCase("value")) {
				select.deselectByValue(value);
			} else if(type.equalsIgnoreCase("Index")) {
				select.deselectByIndex(Integer.parseInt(value));
			} else if(type.equalsIgnoreCase("all")) {
				select.deselectAll();
			}
		} catch (NumberFormatException e) {
			Assert.fail("ERROR: OCCUR DURING DROPDOWN ");
		}
    }
    
    protected static void implicitWait(String type,int duration) {
    	try {
			if(type.equalsIgnoreCase("seconds")) {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
			}else if(type.equalsIgnoreCase("minutes")) {
				driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(duration));
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING IMPLICIT WAIT ");
		}
    }
    
    protected static void localWait(int millisec) {
    try {
		Thread.sleep(millisec);
	} catch (InterruptedException e) {
		Assert.fail("ERROR: OCCUR DURING STATIC WAIT ");
	}
    }
    
    protected static void explicitWait(int duration,String condition,WebElement element) {
    	try {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(duration));
			if(condition.equalsIgnoreCase("elementToBeClickable")) {
				wait.until(ExpectedConditions.elementToBeClickable(element));
			}else if(condition.equalsIgnoreCase("selected")) {
				wait.until(ExpectedConditions.elementToBeSelected(element));
			}else if(condition.equalsIgnoreCase("visibility")) {
				wait.until(ExpectedConditions.visibilityOf(element));
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING EXPLICIT WAIT ");
		}
    
}   
    
    
    protected static void javaScriptExecutor(WebElement element) {
    	try {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();",element);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING JAVA SCRIPT EXECUTOR ");
		}
    }
    
    protected static void getWindowHandle() {
    	String parent=driver.getWindowHandle();
        
        Set<String> windowhandling=driver.getWindowHandles(); 
    	for(String window : windowhandling)
        {
        	if(!parent.equals(window))
        	{
        		driver.switchTo().window(window);
        	}
        	
        }
    }
    
    
    
    protected static void windowsHandles(int num) {
    	try {
			List<String> allWindow = new ArrayList(driver.getWindowHandles());
			driver.switchTo().window(allWindow.get(num));
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING WINDOW HANDLES");
		}
    }
    
    
    protected static void validation(String actual,String expected) {
    	try {
    		Assert.assertEquals(actual,expected);
    	}
    	catch(Exception e)
    	{
    		Assert.fail("ERROR: OCCUR DURING VALIDATION");
    	}
    }
    	
   	
    	public static void extentReportStart(String location) {
    		try
    		{
    			extentReports = new ExtentReports();
    			file = new File(location);
    			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
    			extentReports.attachReporter(sparkReporter);
    			extentReports.setSystemInfo("OS", System.getProperty("os.name"));
    			extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
    		}
    		catch(Exception e)
        	{
        		Assert.fail("ERROR: OCCUR DURING EXTENTREPORTSTART");
        	}
    		
    	}

    	public static void extentReportTearDown(String location) {
    		try
    		{
    			extentReports.flush();
    			file = new File(location);
    			Desktop.getDesktop().browse((file).toURI());
    		}catch(Exception e)
    	    {
    			Assert.fail("ERROR: OCCUR DURING EXTENTREPORTTEARDOWN");
    	    }
    	}

    	public String takeScreenshot() 
    	{
    			TakesScreenshot screenshot = (TakesScreenshot) driver;
    			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    			File scrfile = screenshot.getScreenshotAs(OutputType.FILE);
    			File destfile = new File("E:\\JAVA\\TestNG_Project\\Screenshort\\.png" + "_" + timeStamp + ".png");
				try {
					FileUtils.copyFile(scrfile, destfile);
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				return destfile.getAbsolutePath();
    			
  
    	
    	}
    
    
    
}