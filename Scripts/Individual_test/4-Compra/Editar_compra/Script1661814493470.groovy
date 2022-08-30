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

String openBrowser = CustomKeywords.'navegador.validateNavegador.browser'()
String closeBrowser = ''

println(openBrowser)

'Si el navegador esta abierto'
if (openBrowser == '1')
	{
		'Ir al filtro'
		WebUI.navigateToUrl(GlobalVariable.Web +'/admin/inventario/entradas/compras/')
		
		'Guarda el no. de folio de la compra'
		String id_folio = GlobalVariable.idfolioCompra
		
		'Insertar fecha desde en el filtro'
		WebUI.setText(CustomKeywords.'ordenCompra.xpath_dynamic.object'('fecha_desde'), new Date().format('dd/MM/yy'))
		
		'Insertar fecha hasta en el filtro'
		WebUI.setText(CustomKeywords.'ordenCompra.xpath_dynamic.object'('fecha_hasta'), new Date().format('dd/MM/yy'))
		
		'Insertar folio en el filtro'
		WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_buscar_texto'), id_folio)
		
		'Click en boton > Boton buscar'
		WebUI.click(CustomKeywords.'ordenCompra.xpath_dynamic.object'('button_buscar'))
		
		'Indicador para no cerrar el navegador y continuar el flujo'
		closeBrowser = '0'
		
	}
else {
		
		'Guarda el no. de folio de la orden de compra'
		String id_folio = GlobalVariable.FolioCompra
		
		'Click en boton > Menu-Inventario'
		WebUI.click(CustomKeywords.'menu.xpath_dynamic.object'('boton_inventario'))
		
		'Click en boton > Menu - Entradas Almacen'
		WebUI.click(CustomKeywords.'menu.xpath_dynamic.object'('boton_entradas_almacen'))
		
		'Click en boton > Menu-Compras'
		WebUI.click(CustomKeywords.'menu.xpath_dynamic.object'('boton_compras'))
		
		WebUI.comment('Si se genera un error es porque el no de folio no existe ni las fechas, debe agregarse en variables globales')
		
		'Insertar fecha desde en el filtro'
		WebUI.setText(CustomKeywords.'ordenCompra.xpath_dynamic.object'('fecha_desde'), GlobalVariable.FechaFolioCompra)
		
		'Insertar fecha hasta en el filtro'
		WebUI.setText(CustomKeywords.'ordenCompra.xpath_dynamic.object'('fecha_hasta'), GlobalVariable.FechaFolioCompra)
		
		'Insertar folio en el filtro'
		WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_buscar_texto'), id_folio)
		
		'Click en boton > Boton buscar'
		WebUI.click(CustomKeywords.'ordenCompra.xpath_dynamic.object'('button_buscar'))
		
		'Indicador para cerrar el navegador'
		closeBrowser = '1'
}


'Scroll'
WebUI.scrollToElement(CustomKeywords.'compra.xpath_dynamic.object'('first_c_table'), 1)

'Abrir la primera compra la primera'
WebUI.click(CustomKeywords.'compra.xpath_dynamic.object'('first_c_table'))

'Editar la compra'
WebUI.click(CustomKeywords.'compra.xpath_dynamic.object'('edit_compra'))
WebUI.click(CustomKeywords.'compra.xpath_dynamic.object'('edit_entrada'))

'Scroll al comentario'
WebUI.scrollToElement(CustomKeywords.'compra.xpath_dynamic.object'('input_comentarios'), 1)

'Insertar en input > Comentario'
WebUI.setText(CustomKeywords.'compra.xpath_dynamic.object'('input_comentarios'), CustomKeywords.'compra.data_aleatory.getAleatotyData'(
		'comentarioEditar'))

'Guardar orden de compra'
WebUI.click(CustomKeywords.'compra.xpath_dynamic.object'('guardar_compra'))

'Espera de 5 segundos'
WebUI.delay(5)

'Ir al filtro'
//WebUI.navigateToUrl(GlobalVariable.Web +'/admin/inventario/entradas/compras/')

'Espera de 5 segundos'
WebUI.delay(5)

if (closeBrowser == '1')
{
	'Cerrar navegador'
	WebUI.closeBrowser()
}
else if (closeBrowser == '0'){
	
	'Espera de 1 segundos'
	WebUI.delay(1)
}

