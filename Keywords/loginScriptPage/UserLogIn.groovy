package loginScriptPage
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.Formatter.DateTime

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.By.ByXPath
import org.openqa.selenium.WebDriver
import org.apache.poi.ss.formula.functions.Today
import org.openqa.selenium.By


import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.TestObjectXpath
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil
import groovy.time.TimeCategory

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


public class UserLogIn {

	//Set Credentials for Login
	@Keyword
	def public static void LogIn() {

		WebUI.waitForElementPresent(findTestObject('Object Repository/UserPage/Input_UserName'), 15)
		WebUI.setText(findTestObject('Object Repository/UserPage/Input_UserName'), GlobalVariable.UserName)
		WebUI.setText(findTestObject('Object Repository/UserPage/Password'), GlobalVariable.Password)
		WebUI.click(findTestObject('Object Repository/UserPage/LogInButton'))

	}



	//Click Settings Button
	@Keyword
	def public static void ClickSettingsButton(String text) {

		WebUI.click(findTestObject('Object Repository/HomePage/SettingsBtn_Click'))
		WebUI.delay(4)
		TestObject Obj = new TestObject("")
		Obj.addProperty("xpath", ConditionType.EQUALS, '//button[text()="' + text + '"]')
		WebUI.click(Obj)
	}
}