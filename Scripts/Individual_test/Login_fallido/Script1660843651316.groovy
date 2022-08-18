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

'****PRUEBA 1 > CONTRASEÑA INCORRECTA****'

'Abrir navegador'
WebUI.openBrowser(GlobalVariable.Web)

'Maximizar ventana'
WebUI.maximizeWindow()

'Insertar usuario'
WebUI.setText(CustomKeywords.'login.xpath_dynamic.object'('input_username'), GlobalVariable.Usuario)

'Insertar contraseña incorrecta'
WebUI.setEncryptedText(CustomKeywords.'login.xpath_dynamic.object'('input_password'), GlobalVariable.Contrasena_incorrecta)

'Click en el boton entrar'
WebUI.click(CustomKeywords.'login.xpath_dynamic.object'('button_entrar'))

'Esperar 2 segundos'
WebUI.delay(2)

'Verificar si aparece la etiqueta de error'
WebUI.verifyElementPresent(CustomKeywords.'login.xpath_dynamic.object'('error_msg'), 1)

'Obtener la URl'
currentUrl = WebUI.getUrl()

'Generar la URl completa'
String Url_retorno = GlobalVariable.Web + '/admin/login/?next=/admin/index/'

'Validar la URL correcta'
if (currentUrl != Url_retorno) {
    'Mostrar error si no esta en la URL'
    throw new StepFailedException('Bad URL')
}

'Esperar 2 segundos'
WebUI.delay(2)

'Cerrar navegador'
WebUI.closeBrowser()

'****PRUEBA 2 > USUARIO INCORRECTO****'

'Abrir navegador'
WebUI.openBrowser(GlobalVariable.Web)

'Maximizar ventana'
WebUI.maximizeWindow()

'Insertar usuario incorrecto'
WebUI.setText(CustomKeywords.'login.xpath_dynamic.object'('input_username'), GlobalVariable.Usuario_incorrecto)

'Insertar contraseña'
WebUI.setEncryptedText(CustomKeywords.'login.xpath_dynamic.object'('input_password'), GlobalVariable.Contrasena)

'Click en el boton entrar'
WebUI.click(CustomKeywords.'login.xpath_dynamic.object'('button_entrar'))

'Esperar 2 segundos'
WebUI.delay(2)

'Verificar si aparece la etiqueta de error'
WebUI.verifyElementPresent(CustomKeywords.'login.xpath_dynamic.object'('error_msg'), 1)

'Obtener la URl'
currentUrl = WebUI.getUrl()

'Validar la URL correcta'
if (currentUrl != Url_retorno) {
    'Mostrar error si no esta en la URL'
    throw new StepFailedException('Bad URL')
}

'Esperar 2 segundos'
WebUI.delay(2)

'Cerrar navegador'
WebUI.closeBrowser()

