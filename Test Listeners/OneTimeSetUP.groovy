import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.logging.Logger

import org.openqa.selenium.TakesScreenshot

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable
import net.bytebuddy.agent.builder.AgentBuilder.Default.ExecutingTransformer

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.annotation.TearDown
import com.kms.katalon.core.annotation.SetUp

class OneTimeSetUP {
	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */
	
		//Open Browser and Pass the required Url
	@BeforeTestCase
	def sampleBeforeTestCase(TestCaseContext testCaseContext)
	 {
		
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl(GlobalVariable.Url)
	 }
	
	 //Checks status of test case & takes Screenshot for failed Step and Closes Browser
	@AfterTestCase
	def sampleAfterTestCase(TestCaseContext testCaseContext)
	{
		String excutionSource = RunConfiguration.getExecutionSource()
		String logFolderPath = RunConfiguration.getLogFolderPath()
		String userDir = System.getProperty("user.dir")+"\\ReportsTest Cases\\ScreenShoots"
		String status = testCaseContext.getTestCaseStatus()
		String name = testCaseContext.testCaseId
		if(status=="FAILED")
		{
		Date today = new Date()
		String todaysDate = today.format('dd_MM_yy');
		String nowTime = today.format('hh_mm_ss');
		WebUI.takeScreenshot(userDir +'\\'+ name +'_'+ nowTime +'_'+ todaysDate +".PNG");
		}
		
		WebUI.closeBrowser()
	}
	
		
}