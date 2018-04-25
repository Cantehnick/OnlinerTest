package by.htp.onliner.steps;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;





public class TestRegionServicing {

	private Steps steps;
	
	
	@BeforeMethod(description = "Init browser" ,groups = { "suite1" })
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}
	
	@AfterMethod
	public void close() {
		steps.closeDriver();
	}
	
	@Test(groups = { "suite1" })
	public void checkImplementersInMinsk() {
int actual=steps.getSize();
Assert.assertTrue(actual !=0, "Imlementers is ");
	}

@Test(groups = { "suite2" })
public void checkImplementersSettingPO() {
	int actual=steps.checkAvailabilityImplementers();
	Assert.assertTrue(actual !=0, "Imlementers is ");}

@Test(groups = { "suite3" })
public void checkImplementersByCountRaitingAndOrders () {
	int actual = 0;
	if (steps.isCommentsAndOrders(2, 3)) {
		 actual=steps.checkAvailabilityImplementers();
	}
	Assert.assertTrue(actual !=0 ,"Imlementers is ");
}







}
