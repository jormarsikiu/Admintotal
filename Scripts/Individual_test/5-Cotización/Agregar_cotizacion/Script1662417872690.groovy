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

'Keyword para abrir el navegador'
String openBrowser = CustomKeywords.'keyword_navegador.validateNavegador.browser'()

if (openBrowser == '1')
	{
		'Flujo Completo'
		WebUI.navigateToUrl(GlobalVariable.Web +'/admin/ventas/cotizaciones/')
		
		//proveedor = GlobalVariable.nombreProveedor
		
		//id_folio = GlobalVariable.idfolio
		
		closeBrowser = '0'
		
		/*String id_tipoproducto = GlobalVariable.tipoproducto
		
		if (id_tipoproducto == '2' || id_tipoproducto == '8')
			{
				WebUI.comment('El producto creado es un Ensamble o Emsamble Dinamico y no se procesa compra')
				
				'Cerrar navegador'
				WebUI.closeBrowser()
				
				'Espera de 5 segundos'
				WebUI.delay(5)
				
			}
			
		ordenCompra = '1'*/
		
	}

else {
		
		'Flujo Individual'
		
		proveedor = GlobalVariable.Proveedor
		
		id_folio = GlobalVariable.Folio
		
		closeBrowser = '1'
		
		ordenCompra = '0'
}

'Click en boton > Menu-Ventas'
WebUI.click(findTestObject('Object Repository/menu_objects/button_ventas'))
		
'Click en boton > Menu - Cotizacion Cliente'
WebUI.click(findTestObject('Object Repository/menu_objects/button_cotizacion_cliente'))
		
'Click en boton > Menu - Cotizacion Cliente'
WebUI.click(findTestObject('Object Repository/cotizacion_cliente/agregar_cotizacion'))