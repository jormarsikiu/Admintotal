package navegador

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.exception.StepFailedException as StepFailedException
import internal.GlobalVariable

public class validateNavegador {

	@Keyword
	def browser() {

		try {
			def x = DriverFactory.getCurrentWindowIndex()
			if ( ( x != null ) && ( x >= 0 ) ) {
				println ( 'El navegador está abierto...' )
				return '1'
			}
		}
		catch(Exception e) {
			println( 'El navegador NO está abierto')
			WebUI.callTestCase(findTestCase('Individual_test/1-Login/Login_exitoso'), [:], FailureHandling.STOP_ON_FAILURE)
			return '0'
		}
	}
}
