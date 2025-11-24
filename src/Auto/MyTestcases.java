package Auto;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestcases extends myData {

	WebDriver driver = new EdgeDriver();

	String myWebSite = "https://automationteststore.com/";

	String SignupPage = "https://automationteststore.com/index.php?rt=account/create";

	@BeforeTest
	public void mySetup() {

		driver.get(myWebSite);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	@Test(priority = 1, enabled = false)
	public void SignupTest() throws InterruptedException {

		driver.navigate().to(SignupPage);

		// WebElements

		WebElement FirstName = driver.findElement(By.id("AccountFrm_firstname"));
		WebElement LastName = driver.findElement(By.id("AccountFrm_lastname"));
		WebElement Email = driver.findElement(By.id("AccountFrm_email"));
		WebElement TelePhone = driver.findElement(By.id("AccountFrm_telephone"));
		WebElement TheFax = driver.findElement(By.id("AccountFrm_fax"));
		WebElement AddressOne = driver.findElement(By.id("AccountFrm_address_1"));

		WebElement Thecountry = driver.findElement(By.id("AccountFrm_country_id"));

		WebElement TheState = driver.findElement(By.id("AccountFrm_zone_id"));

		Select mySelectElementForcountry = new Select(Thecountry);
		Select mySelectElementForTheState = new Select(TheState);

		mySelectElementForcountry.selectByIndex(108);
		Thread.sleep(2000);
		mySelectElementForTheState.selectByIndex(theSelectStateIndex);

		List<WebElement> AllTheStates = TheState.findElements(By.tagName("option"));

		String theCity = AllTheStates.get(theSelectStateIndex).getText();

		WebElement TheCityInput = driver.findElement(By.id("AccountFrm_city"));

		WebElement ThePostelCode = driver.findElement(By.id("AccountFrm_postcode"));

		WebElement loginName = driver.findElement(By.id("AccountFrm_loginname"));

		WebElement ThePassword = driver.findElement(By.id("AccountFrm_password"));
		WebElement TheConfirmPassword = driver.findElement(By.id("AccountFrm_confirm"));
		Thread.sleep(1000);
		WebElement AgreeCheckBox = driver.findElement(By.id("AccountFrm_agree"));

		WebElement ContinueButton = driver.findElement(By.xpath("//button[@title='Continue']"));

		// -- Actions ---
		FirstName.sendKeys(TheFirstName);
		LastName.sendKeys(TheLastName);
		Email.sendKeys(TheEmail);
		TelePhone.sendKeys(TelePhonee);
		TheFax.sendKeys(TheFaxnum);
		AddressOne.sendKeys(TheAdressOne);
		TheCityInput.sendKeys(theCity);
		ThePostelCode.sendKeys(postalCode);

		loginName.sendKeys(LOGINAME);
		ThePassword.sendKeys(Password);
		TheConfirmPassword.sendKeys(Password);
		AgreeCheckBox.click();
		ContinueButton.click();
		Thread.sleep(2000);
		String ActualSignUpMessage = driver.findElement(By.className("maintext")).getText();
		
		// test case (بتقارن القيمة الحقيقة بالمتوقعة وبتشتغل زي ال if )
		
		Assert.assertEquals(ActualSignUpMessage, ExpectedTextForTheSignUp);
	}
	
	@Test (priority = 2 , enabled = false)
	   
	public void LogoutTest() throws InterruptedException  {
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logoff")).click();
		
	}
	
	@Test (priority = 3 , enabled = false)
	   public void Login() throws InterruptedException {
		
		driver.findElement(By.cssSelector("ul[id='customer_menu_top'] li a")).click();
		
		WebElement LoginNameInput = driver.findElement(By.id("loginFrm_loginname"));
		
		WebElement LoginPasswordInput = driver.findElement(By.id("loginFrm_password"));
		
		WebElement LoginButton = driver.findElement(By.cssSelector("button[title='Login']"));
		
		LoginNameInput.sendKeys(LOGINAME);
		
		LoginPasswordInput.sendKeys(Password);
		
		Thread.sleep(3000);
		
		LoginButton.click();
		
		boolean ActualValue= driver.getPageSource().contains(Welcomemessage);
		
		boolean ExpectedValue = true ;
		
		Assert.assertEquals(ActualValue, ExpectedValue);
		
		
	}
	
	@Test (priority = 4)
	 public void AddItemToThecart() {
		
		driver.navigate().to(myWebSite);
		
		List<WebElement> AllItems = driver.findElements(By.className("prdocutname"));
		
		int RandomIndexForTheItem = rand.nextInt(AllItems.size());
		
		AllItems.get(RandomIndexForTheItem).click();
		
	}

	@AfterTest

	public void AftermyTest() {
 
		//
	}

}
