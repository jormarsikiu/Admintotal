package keyword_navegador

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase


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

/**
 *Esta clase valida si el navegador esta abierto o cerrado.
 *@author Grupo KAIZEN
 *@since 2022
 */
public class validateNavegador {

	/**
	 *<h3>Este método valida si la ventana del navegador esta abierta o cerrada.</h3>
	 *Si esta abierto solo retornará el valor de 1.
	 *Si esta cerrado abrirá el test case de Login_exitoso.
	 *@return 1 si el navegador esta abierto
	 *@return 0 si el navegador esta cerrado
	 */
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
