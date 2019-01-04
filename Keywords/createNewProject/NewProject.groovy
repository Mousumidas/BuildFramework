package createNewProject

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.Formatter.DateTime
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIKeywordMain
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import groovy.time.TimeCategory
import internal.GlobalVariable
import java.util.Date
import java.time.LocalDateTime
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.driver.DriverFactory
import org.apache.xpath.operations.Bool
import org.openqa.selenium.By

public class NewProject {

	//Add New Project By clicking Setting Button
	@Keyword
	def public static void AddNewProject(String country) {
		WebUI.delay(5)
		//WebUI.waitForElementVisible(findTestObject('Object Repository/ClickAddButton/ClickPlusIcon'),10)
		WebUI.click(findTestObject('Object Repository/ClickAddButton/ClickPlusIcon'))
		Date today = new Date()
		String Date = today.format("MMddyyyy")
		String Time = today.format("hh:mm:ss")
		String ProjectName = "Astoria'"+ Date +"''"+ Time +"'"
		WebUI.delay(5)
		//String ProjectName =WebUI.getText(findTestObject('Object Repository/CreateProject/ProjectName'))
		WebUI.setText(findTestObject('Object Repository/CreateProject/ProjectName'),ProjectName)
		WebUI.setText(findTestObject('Object Repository/CreateProject/Description'), "Adding Project in '"+country+"'")
		WebUI.click(findTestObject('Object Repository/CreateProject/ClickCountry'))
		WebUI.delay(5)
		TestObject Obj = new TestObject("")
		Obj.addProperty("xpath", ConditionType.EQUALS, '//span[text()="'+country+'"]/parent::mat-option')
		WebUI.scrollToElement(Obj, 5)
		WebUI.click(Obj)
		String TodayDate = today.format("MM/dd/yyyy")
		WebUI.setText(findTestObject('Object Repository/CreateProject/SetStartDate'), TodayDate)
		WebUI.click(findTestObject('Object Repository/CreateProject/EndDateProject'))
		WebUI.setText(findTestObject('Object Repository/CreateProject/EndDateProject'),"05/22/2021")
		WebUI.click(findTestObject('Object Repository/CreateProject/SaveButton'))
		WebUI.delay(5)

		ArrayList count = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/CreateProject/GetProjectCount'), 10)
		int count1 = count.size();
		for(int i=1; i<=count1; i++ )
		{
			TestObject Obj1 = new TestObject("")
			Obj1.addProperty("xpath", ConditionType.EQUALS,"//table//tbody/tr["+ i +"]/td[1]")
			String z = WebUI.getText(Obj1)
			println z

		}



	}
}
