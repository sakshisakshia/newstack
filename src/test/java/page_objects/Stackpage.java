package page_objects;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import constants.Constants;
import step_definitions.Stack_stepdef;
import webdriver_manager.DriverManager;
//import utilities.Loggerload;

public class Stackpage {
private static Stackpage loginPageInstance;
private static final Logger LOGGER = LogManager.getLogger(Stackpage.class);	
	
	//Dummy private constructor prevents the object create
	private Stackpage()
	{
		
		
	}
	
	//this method prevents duplicate object creation, Singleton pattern lazy loading
	public static Stackpage getInstance()
	{
		if(loginPageInstance==null) {
			loginPageInstance = new Stackpage();		
		}
		
		return loginPageInstance;
		
	}
		
	//public WebDriver ldriver;
	//public Stackpage(WebDriver rdriver)
	//{
		//ldriver=rdriver;
		
	//}

	
//homepage
@FindBy(xpath =("//a[@class='nav-link dropdown-toggle']"))WebElement dropdown_datastructures ;
@FindBy(xpath=("//a[@class='dropdown-item' and @href='/stack']"))WebElement dropdown_stack;
@FindBy(xpath=("//a[@href='stack']"))WebElement getstarted_stack;

//stackpage	
@FindBy(xpath=("//a[text()='Operations in Stack']"))WebElement lnkoperations;
@FindBy(xpath=("//a[text()='Implementation']"))WebElement lnkimp;
@FindBy(xpath=("//a[text()='Applications']"))WebElement lnkapp;
@FindBy(xpath=("//a[text()='Practice Questions']"))WebElement lnkpracticeque;
@FindBy(xpath=("//a[@class='btn btn-info']"))WebElement lnktryhere;
@FindBy(xpath=("//button[@type='button']"))WebElement runbtn;
//@FindBy(xpath=("//div[@class='CodeMirror-scroll']"))WebElement inputeditor;
@FindBy(id = "output")WebElement output;
@FindBy(xpath = "//textarea[@tabindex='0']")WebElement inputeditor;

public void navigateToHomePage() throws InterruptedException 
{
	DriverManager.getDriver().get(Constants.HOME_URL);
	Thread.sleep(1000);
	LOGGER.info("User logged in sucessfully");
}

public void clickondatastructuredropdown()
{

	dropdown_datastructures.click();
	LOGGER.info("user clicked on datastructure dropdown button");
}

public void selectstackfromdropdown() throws InterruptedException
{   
	Thread.sleep(1000);
	dropdown_stack.click();

	LOGGER.info("user selects stack from dropdown");
}

public void clickongetstartedunderstack() throws InterruptedException
{	
	Thread.sleep(1000);
	getstarted_stack.click();
	LOGGER.info("user click on the Get Started under stack to open the stack page");
}

public String getstackPageTitle() throws InterruptedException
{
	Thread.sleep(1000);
	String title = DriverManager.getDriver().getTitle();
	return title;
}

public void navigateTostackPage() throws InterruptedException {
	Thread.sleep(2000);
	DriverManager.getDriver().get(Constants. STACKPAGE_URL);
	LOGGER.info("User is in the stack  page");
}

public void clickonoperationsinstack()
{
	lnkoperations.click();
	LOGGER.info("user click on the Operations in Stack link");
}

public void navigatetooperationsinstackPage()
{

	DriverManager.getDriver().get(Constants.OPERATIONSINSTACK_URL);
	LOGGER.info("User is in the operations in stack  page");
}

public void clickontryherelink()
{
	lnktryhere.click();
	LOGGER.info("user click on the Tryhere button");
}

public void navigateTryEditor() throws InterruptedException {
	Thread.sleep(2000);
	DriverManager.getDriver().get(Constants.TRYEDITOR_URL);
	LOGGER.info("User is in the TryEditor page");
}

public void EnterPhytonCode(String validPhytonCode )
{
	
	inputeditor.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
	inputeditor.sendKeys(validPhytonCode);
	//txtCodeArea.sendKeys(strValue);
}
	
public String getActualResult()
{
return output.getText();
}

public void InvalidPhytonCode(String enterinvalidCode ) throws InterruptedException
{
	Thread.sleep(2000);
	inputeditor.sendKeys(enterinvalidCode);
	
}

public String getErrorText() throws InterruptedException {
	Thread.sleep(2000);
	String errorMsg = DriverManager.getDriver().switchTo().alert().getText();
	DriverManager.getDriver().switchTo().alert().accept();
	return errorMsg;
}
public void clickonrun()
{
	runbtn.click();
	LOGGER.info("user click run button");
}

public void clickonimplementation()
{
	lnkimp.click();
	LOGGER.info("user click on the Implementation link");
}
public void navigatetoimplementationinstackPage()
{

	DriverManager.getDriver().get(Constants.IMPLEMENTATION_URL);
	LOGGER.info("User is in the Implication page");
}


public void clickonapplication()
{
	lnkapp.click();
	LOGGER.info("user click on the Applications link");
}
public void navigatetoapplicationsinstackPage()
{

	DriverManager.getDriver().get(Constants.APPLICATIONS_URL);
	LOGGER.info("User is in the Applications page");
}

public void clickonpracticequestions()
{
	lnkpracticeque.click();
	LOGGER.info("user click on the Practice Questions link");
}

}

