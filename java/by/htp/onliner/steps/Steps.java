package by.htp.onliner.steps;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import by.htp.onliner.driver.DriverSingleton;
import by.htp.onliner.pages.MainPage;

public class Steps {

	private WebDriver driver;

	private final Logger logger = LogManager.getRootLogger();

	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}

	public int getSize() {
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		mainPage.selectMinsk();
		logger.info("Actual size" + mainPage.getListNamesSize());
		return mainPage.getListNamesSize();
	}

	public int checkAvailabilityImplementers() {
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		mainPage.selectMinsk();
		mainPage.selectSettingPO();
		logger.info("Actual size" + mainPage.getListNamesSize());
		return mainPage.getListNamesSize();
	}

	public boolean isCommentsAndOrders(int comments, int orders) {
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		mainPage.selectMinsk();
		mainPage.selectSettingPO();
		
		List<WebElement> ratingList = mainPage.getRating();
		List<WebElement> offersList = mainPage.getOffers();
		List<WebElement> ordersList = mainPage.getOrders();
		for (int i = 0; i > offersList.size(); i++) {
			String ratingText = ratingList.get(i).getText();
			String orderText = ordersList.get(i).getText();
			String[] strArrayRaiting = ratingText.split(" ");
			String[] strArrayOrder = orderText.split(" ");

			int countCommments = Integer.valueOf(strArrayRaiting[0]);
			int countOrders = Integer.valueOf(strArrayOrder[1]);

			if (countCommments > comments && countOrders > orders) {
				return true;
			}

		}
		return false;
	}

	

}
