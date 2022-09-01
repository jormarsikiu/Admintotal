import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.exception.StepFailedException as StepFailedException
import com.kms.katalon.core.testobject.ConditionType as ConditionType

/**
 *Este es un Test Case para la autenticación del login con un usuario y contraseña válido
 *Usa variables Globales de la sección Profiles
 *Es usada en la siguiente ruta:
 *@linkplain https://kaizen.admintotal.com/admin/login
 *@see Usa el Keywords.keyword_login.xpath_dynamic.groovy para obtener los elementos web
 *@author Grupo KAIZEN
 *@since 2022
 */

'Abrir navegador'
WebUI.openBrowser(GlobalVariable.Web)

'Maximizar ventana'
WebUI.maximizeWindow()

'Insertar usuario'
WebUI.setText(CustomKeywords.'keyword_login.xpath_dynamic.getObject'('input_username'), GlobalVariable.Usuario)

'Insertar contraseña'
WebUI.setEncryptedText(CustomKeywords.'keyword_login.xpath_dynamic.getObject'('input_password'), GlobalVariable.Contrasena)

'Click en el boton entrar'
WebUI.click(CustomKeywords.'keyword_login.xpath_dynamic.getObject'('button_entrar'))

'Esperar 2 segundos'
WebUI.delay(2)

'Obtener la URl'
currentUrl = WebUI.getUrl()

'Generar la URl completa'
String Url_new = GlobalVariable.Web + '/admin/index/'

'Validar la URL correcta'
if (currentUrl != Url_new) {
    'Mostrar error si no esta en la URL'
    throw new StepFailedException('Bad URL')
}

'Esperar 2 segundos'
WebUI.delay(2)



