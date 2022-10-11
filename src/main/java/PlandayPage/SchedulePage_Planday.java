package PlandayPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SchedulePage_Planday extends BaseClass_Planday{

public SchedulePage_Planday(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
public int size;

@FindBy(xpath = "//iframe[@title='Page content']")
private WebElement iFrame;

@FindBy(name="shiftStartEnd_start")
private WebElement fromSchedule ;

@FindBy(name="shiftStartEnd_end")
private WebElement toSchedule ;

@FindBy(xpath="//button[text()='Create']")
private WebElement create;

//Methods

public void switcToIframe() {

driver.switchTo().frame(iFrame);	
}

public void verifyEmployeeCount() {
List<WebElement> empList = driver.findElements(By.xpath("//*[@class='virtualized-board__row']//following::*[@class='row-header3__text__title' and contains(text(),'Employee')]"));
size= empList.size();
System.out.println("the count of employees is :"+ size);	
}

public void createShiftAndVerify(String fromTime, String toTime) throws InterruptedException {
Thread.sleep(5000);
String dateSet = returnCurrentDate();
WebElement gridCellToday = driver.findElement(By.xpath("//*[@class='board-slot board-slot--clickable' and @aria-label='"+dateSet+" Employee One']"));
gridCellToday.click();
System.out.println("Todays' date is :"+ dateSet);
Thread.sleep(1000);
Assert.assertTrue(fromSchedule.isDisplayed(), "FAIL: the From field is visible");
fromSchedule.sendKeys(fromTime);
toSchedule.sendKeys(toTime);
create.click();
System.out.println("the content of cell after selection is : "+gridCellToday.getText());
}
}
