package step_definitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import static org.testng.Assert.assertEquals;
import java.time.Duration;
import java.util.ArrayList;

//import java.util.StackList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import constants.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.HomePage;
import page_objects.SigninPage;
import page_objects.Stackpage;
import utilities.common_utils;
import webdriver_manager.DriverManager;

public class Stack_stepdef 
{
	WebDriver driver = DriverManager.getDriver();
	Stackpage ObjStackPage = Stackpage.getInstance();
	SigninPage SignPage = SigninPage.getInstance();
	HomePage homePage = HomePage.getInstance();
	common_utils objCommounUtils = new common_utils();
	
	private static final Logger LOGGER = LogManager.getLogger(Stack_stepdef.class);	
	
	public Stack_stepdef()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}

	@Given("The user landed on the home page after logged in")
	public void the_user_landed_on_the_home_page_after_logged_in() throws InterruptedException {
		
		driver.get(Constants.SIGNIN_URL);
		driver.manage().window().maximize();
		SignPage.Signin(Constants.USERNAME, Constants.PASSWORD);
		Thread.sleep(2000); 
	    
	}

	@When("The user selects the stack option from the dropdown menu or clicks on Get Started button under Stack")
	public void the_user_selects_the_stack_option_from_the_dropdown_menu_or_clicks_on_get_started_button_under_stack() throws InterruptedException {
	    
		ObjStackPage.clickondatastructuredropdown(); 
		ObjStackPage.selectstackfromdropdown();
		
		//ObjStackPage.clickongetstartedunderstack();

	}

	@Then("The user should be redirected to stack page")
	public void the_user_should_be_redirected_to_stack_page() {
	     
		LOGGER.info("The user is in Stack page");
	}

	@Given("The user is on the stack page")
	public void the_user_is_on_the_stack_page() throws InterruptedException {
		
		String Title = ObjStackPage.getstackPageTitle();
		LOGGER.info("The user is in Stack page");
		LOGGER.info("Title of current page is : " + Title);
		assertEquals(Title, "Stack", "Title not matched"); 
     }

	@When("The user clicks on the operations in the stack link")
	public void the_user_clicks_on_the_operations_in_the_stack_link() {
	    
		ObjStackPage.clickonoperationsinstack();
	}

	@Then("The user should be redirected to operations in stack page")
	public void the_user_should_be_redirected_to_operations_in_stack_page() {
	    
		LOGGER.info("The user should redirected to operations in stack page");   
	}

	@Given("The user is on the operations in stack page")
	public void the_user_is_on_the_operations_in_stack_page() throws InterruptedException {
		
		String Title = ObjStackPage.getstackPageTitle();
		LOGGER.info("Title of current page is : " + Title);
		assertEquals(Title, "Operations in Stack", "Title not matched"); 
   }

	@When("The user clicks on Try here button for operations in stack page")
	public void the_user_clicks_on_try_here_button_for_operations_in_stack_page() {
		
		ObjStackPage.clickontryherelink();
	 }

	@Then("The user should be redirected to page having an tryEditor with a Run button for  operations in stack page")
	public void the_user_should_be_redirected_to_page_having_an_try_editor_with_a_run_button_for_operations_in_stack_page() {
	    
		LOGGER.info("The user is in the tryeditor page");  
	}

	@Then("The user enter the valid python code in tryeditor page and click on Run button")
	public void the_user_enter_the_valid_python_code_in_tryeditor_page_and_click_on_run_button() throws InterruptedException {
	    
		String Title = ObjStackPage.getstackPageTitle();
		LOGGER.info("Title of current page is :" + Title);
		assertEquals(Title, "Assessment", "Title not matched");
		//print("Hello, World!")
		//ObjStackPage.EnterPhytonCode("\print("Hello World")\);
		//ObjStackPage.EnterPhytonCode("print(\"Implementation in Queue\")");
		
		Thread.sleep(3000);
		ArrayList<ArrayList<String>> arrLL = objCommounUtils.readExcelData();
		LOGGER.info("Arraylist count :" + String.valueOf(arrLL.size()));
		ObjStackPage.EnterPhytonCode(arrLL.get(1).get(0));

		ObjStackPage.clickonrun();

	}

	@Then("The user is presented with result for operations in stack")
	public void the_user_is_presented_with_result_for_operations_in_stack() {
	    
		String actualMsg = ObjStackPage.getActualResult();
		LOGGER.info("Actual result  :" + actualMsg);
	    assertEquals(actualMsg, "hello","Result not Matched");   
	 }

	@Given("The user is on the tryEditor page for operations in stack page")
	public void the_user_is_on_the_try_editor_page_for_operations_in_stack_page() throws InterruptedException {
	    
		ObjStackPage.navigateTryEditor();
	}

	@When("The user enter the invalid python code for operations in stack page")
	public void the_user_enter_the_invalid_python_code_for_operations_in_stack_page() throws InterruptedException {
	    
		ArrayList<ArrayList<String>> arrLL = objCommounUtils.readExcelData();
		LOGGER.info("Arraylist count :" + String.valueOf(arrLL.size()));
		ObjStackPage.EnterPhytonCode(arrLL.get(1).get(1));

		//ObjStackPage.InvalidPhytonCode("print\"Implimentation in Stack\")");
	}

	@When("The user click on the run button for operations in stack page")
	public void the_user_click_on_the_run_button_for_operations_in_stack_page() {
	    
		ObjStackPage.clickonrun();
	}

	@Then("The user will get an error message for operations in stack page")
	public void the_user_will_get_an_error_message_for_operations_in_stack_page() throws InterruptedException {
	    
		LOGGER.info("Invalid code when clicked on run button");
		String actualMsg = ObjStackPage.getErrorText();
		LOGGER.info("Error message for invalid python code is" + actualMsg);
		assertEquals(actualMsg,"NameError: name 'hello' is not defined on line 1", "Result not matched");
		
		//SyntaxError: bad input on line 1

	}

	@Given("The user is in editor page and navigates to the stack page for implementation page")
	public void the_user_is_in_editor_page_and_navigates_to_the_stack_page_for_implementation_page() throws InterruptedException {
		ObjStackPage.navigateTostackPage();
	    
	}

	@When("The user clicks on the Implementation link")
	public void the_user_clicks_on_the_implementation_link() {
	    
		ObjStackPage.clickonimplementation();
	}

	@Then("The user should be redirected to Implementation page")
	public void the_user_should_be_redirected_to_implementation_page() {
	    
		LOGGER.info("The user is in the Implementation page");
	}

	@Given("The user is on the Implementation page")
	public void the_user_is_on_the_implementation_page() throws InterruptedException {
		
		String Title = ObjStackPage.getstackPageTitle();
		LOGGER.info("Title of current page is : " + Title);
		assertEquals(Title, "Implementation", "Title not matched");  
    }

	@When("The user clicks on Try here button for Implementation page")
	public void the_user_clicks_on_try_here_button_for_implementation_page() {
	    
		ObjStackPage.clickontryherelink();  
	}

	@Then("The user should be redirected to page having an tryEditor with a Run button and enter valid python code for Implementation page")
	public void the_user_should_be_redirected_to_page_having_an_try_editor_with_a_run_button_and_enter_valid_python_code_for_implementation_page() throws InterruptedException {
	    
		String Title = ObjStackPage.getstackPageTitle();
		LOGGER.info("Title of current page is :" + Title);
		assertEquals(Title, "Assessment", "Title not matched");
		
		//ObjStackPage.EnterPhytonCode("print(\"Implementation in Queue\")");
		ArrayList<ArrayList<String>> arrLL = objCommounUtils.readExcelData();
		LOGGER.info("Arraylist count :" + String.valueOf(arrLL.size()));
		ObjStackPage.EnterPhytonCode(arrLL.get(1).get(0));

	}

	@Then("The user click on the run button for implementation page")
	public void the_user_click_on_the_run_button_for_implementation_page() {
	    
		ObjStackPage.clickonrun();
	}

	@Then("The user is presented with result for implementation page")
	public void the_user_is_presented_with_result_for_implementation_page() {
	    
		String actualMsg = ObjStackPage.getActualResult();
		LOGGER.info("Actual result  :" + actualMsg);
	   // assertEquals(actualMsg, "hello" ); 
	    assertEquals(actualMsg, "hello","Result not Matched");
	}

	@Given("The user is on the tryEditor page for Implementation page")
	public void the_user_is_on_the_try_editor_page_for_implementation_page() throws InterruptedException {
	    
		ObjStackPage.navigateTryEditor();
	}

	@When("The user enter the invalid python code in tryeditor page  and click run button for Implementation page")
	public void the_user_enter_the_invalid_python_code_in_tryeditor_page_and_click_run_button_for_implementation_page() throws InterruptedException {
		
		ArrayList<ArrayList<String>> arrLL = objCommounUtils.readExcelData();
		LOGGER.info("Arraylist count :" + String.valueOf(arrLL.size()));
		ObjStackPage.EnterPhytonCode(arrLL.get(1).get(1));
		//ObjStackPage.InvalidPhytonCode("print\"Implimentation in Stack\")");
		ObjStackPage.clickonrun();

	}

	@Then("The user will get an error message for Implementation page")
	public void the_user_will_get_an_error_message_for_implementation_page() throws InterruptedException {
	    
		LOGGER.info("Invalid code when clicked on run button");
		String actualMsg = ObjStackPage.getErrorText();
		LOGGER.info("Error message for invalid python code is" + actualMsg);
		//assertEquals(actualMsg,"SyntaxError: bad input on line 1", "Result match");
		assertEquals(actualMsg,"NameError: name 'hello' is not defined on line 1", "Result not matched");
	}

	@Given("The user is in tryeditor page and navigates to stack page for application page")
	public void the_user_is_in_tryeditor_page_and_navigates_to_stack_page_for_application_page() throws InterruptedException {
	    
		ObjStackPage.navigateTostackPage();
	}

	@When("The user clicks on the Applications link")
	public void the_user_clicks_on_the_applications_link() {
	    
		ObjStackPage.clickonapplication(); 
	}

	@Then("The user should be redirected to Applications page")
	public void the_user_should_be_redirected_to_applications_page() {
		LOGGER.info("The user is on the applications page"); 
	    
	}

	@Given("The user is on the Applications page")
	public void the_user_is_on_the_applications_page() throws InterruptedException {
		String Title = ObjStackPage.getstackPageTitle();
		LOGGER.info("Title of current page is : " + Title);
		assertEquals(Title, "Applications", "Title not matched");  

	 }

	@When("The user clicks on Try here button for for Applications page")
	public void the_user_clicks_on_try_here_button_for_for_applications_page() {
	    
		ObjStackPage.clickontryherelink();
	}

	@Then("The user should be redirected to page having an tryEditor with a Run button and enter python code for Applications page")
	public void the_user_should_be_redirected_to_page_having_an_try_editor_with_a_run_button_and_enter_python_code_for_applications_page() throws InterruptedException {
	    
		String Title = ObjStackPage.getstackPageTitle();
		LOGGER.info("Title of current page is :" + Title);
		assertEquals(Title, "Assessment", "Title not matched");
		
		ArrayList<ArrayList<String>> arrLL = objCommounUtils.readExcelData();
		LOGGER.info("Arraylist count :" + String.valueOf(arrLL.size()));
		ObjStackPage.EnterPhytonCode(arrLL.get(1).get(0));

		//ObjStackPage.EnterPhytonCode("print(\"Implementation in Stack\")");
	   

	}

	@Then("user click on run button for applications page")
	public void user_click_on_run_button_for_applications_page() {
		ObjStackPage.clickonrun();
	    
	}

	@Then("The user is presented with the result for applications page")
	public void the_user_is_presented_with_the_result_for_applications_page() {
	    
		String actualMsg = ObjStackPage.getActualResult();
		LOGGER.info("Actual result  :" + actualMsg);
	    //assertEquals(actualMsg, "Implimentation in Stack");  
		 assertEquals(actualMsg, "hello","Result not Matched");
	}

	@Given("The user is on the tryEditor page for Applications page")
	public void the_user_is_on_the_try_editor_page_for_applications_page() throws InterruptedException {
		ObjStackPage.navigateTryEditor();
	    
	}

	@When("The user enter the invalid python code in tryeditor and clickon run button for Applications page")
	public void the_user_enter_the_invalid_python_code_in_tryeditor_and_clickon_run_button_for_applications_page() throws InterruptedException {
		
		ArrayList<ArrayList<String>> arrLL = objCommounUtils.readExcelData();
		LOGGER.info("Arraylist count :" + String.valueOf(arrLL.size()));
		ObjStackPage.EnterPhytonCode(arrLL.get(1).get(1));
		//ObjStackPage.InvalidPhytonCode("print\"Implimentation in Stack\")");
		ObjStackPage.clickonrun();
	 }

	@Then("The user will get an error message for Applications page")
	public void the_user_will_get_an_error_message_for_applications_page() throws InterruptedException {
	    
		LOGGER.info("Invalid code when clicked on run button");
		String actualMsg = ObjStackPage.getErrorText();
		LOGGER.info("Error message for invalid python code is" + actualMsg);
		//assertEquals(actualMsg,"SyntaxError: bad input on line 1", "Result do not match");
		//assertEquals(actualMsg,"SyntaxError: bad input on line 1", "Result match");
		assertEquals(actualMsg,"NameError: name 'hello' is not defined on line 1", "Result not matched");
	}

	@Given("The user is in tryeditor page and navigates to applications page")
	public void the_user_is_in_tryeditor_page_and_navigates_to_applications_page() {
	    
		ObjStackPage.navigatetoapplicationsinstackPage();
	}

	@When("The user clicks on the practice Questions button")
	public void the_user_clicks_on_the_practice_questions_button() {
	    
		ObjStackPage.clickonpracticequestions();
	}

	@Then("The user should be directed to practice questions")
	public void the_user_should_be_directed_to_practice_questions() {
	    
		LOGGER.info("The user is in the practice questions page");
	}
}
