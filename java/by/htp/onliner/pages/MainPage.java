package by.htp.onliner.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage {

	private final Logger logger = LogManager.getRootLogger();
	private static final String BASE_URL = "https://s.onliner.by/profiles";

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}

	@FindBy(xpath = "//ul/li[1]//span[@class='service-form__checkbox-sign ng-binding' and contains(text(),'Минск')]")
	private WebElement regionServicing;

	@FindBy(xpath = "//*[@id='service-list']/div[2]/div/div/div[1]/div[1]/div[2]/div/div[2]/div/div/div[11]")
	private WebElement compAid;

	@FindBy(xpath = "//span[@class='service-form__checkbox-text']//span[contains(text(),'Установка и настройка ПО')]")
	private WebElement settingPO;

	@FindBy(xpath = "//a[@class ='service-response__rating']")
	private List<WebElement> rating;
	
	@FindBy(xpath = "//a[@class ='service-offers__details-item service-offers__details-item_ok ng-binding ng-scope']")
	private List<WebElement> orders;
	
	@FindBy(xpath = "//div[@class='service-offers__unit ng-scope']")
	private List<WebElement> offers;
	
	@FindBy(linkText = "Ритуальные услуги")
	private WebElement ritualServices;
	
	
	public int getListNamesSize() {
		List<WebElement> listNames = driver.findElements(By.xpath("//span[@class='service-offers__name ng-binding']"));

		return listNames.size();
	}

	public int getCountPages() {
		List<WebElement> list = driver
				.findElements(By.xpath("//a[@class='service-pagination__pages-link ng-binding']"));
		return list.size();

	}

	public void selectMinsk() {
		regionServicing.click();
	}

	public void selectSettingPO() {
		Actions actions = new Actions(driver);
		actions.moveToElement(ritualServices).perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		compAid.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		settingPO.click();
	}

	public List<WebElement> getOffers() {
		List<WebElement> listOffers = offers;
		return listOffers;
	}
	
	public List<WebElement> getRating() {
		List<WebElement> listRating = rating;
		return listRating;
	}
	
	public List<WebElement> getOrders() {
		List<WebElement> listOrders = orders;
		return listOrders;
	}

















}
