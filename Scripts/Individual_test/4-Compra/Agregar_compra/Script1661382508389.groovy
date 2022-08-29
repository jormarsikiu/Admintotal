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
String openBrowser = CustomKeywords.'navegador.validateNavegador.browser'()

'Variable para cerrar o mantener abierto el navegador'
String closeBrowser = ''

'Variable para guardar el producto'

String descripcionproduct = ''

'Variable para guardar el proveedor'
String proveedor = ''

'Variable para guardar el proveedor'
String validarproveedor = ''

String id_folio = ''

'Mantener abierto el navegador/ Abrir el navegador'
if (openBrowser == '1')
	{
		'Flujo Completo'
		WebUI.navigateToUrl(GlobalVariable.Web +'/admin/inventario/entradas/compras/')
		
		proveedor = GlobalVariable.nombreProveedor
		
		id_folio = GlobalVariable.idfolio
		
		'Insertar descripcion en el filtro'
		WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_buscar_texto'), descripcionproduct)
		
		
		'Indicador para no cerrar el navegador y continuar el flujo'
		closeBrowser = '0'
		
		String id_tipoproducto = GlobalVariable.tipoproducto
		
		if (id_tipoproducto == '2' || id_tipoproducto == '8')
			{
				WebUI.comment('El producto creado es un Ensamble o Emsamble Dinamico y no se procesa compra')
				
			    'Cerrar navegador'
			    WebUI.closeBrowser()
				
				'Espera de 5 segundos'
				WebUI.delay(5)
				
			} 
		
	}

else {
		
		'Flujo Individual'
		
		proveedor = GlobalVariable.Proveedor
		
		id_folio = GlobalVariable.Folio
		
		'Indicador para cerrar el navegador'
		closeBrowser = '1'
}

'Click en boton > Menu-Inventario'
WebUI.click(CustomKeywords.'menu.xpath_dynamic.object'('boton_inventario'))

'Click en boton > Menu - Entradas Almacen'
WebUI.click(CustomKeywords.'menu.xpath_dynamic.object'('boton_entradas_almacen'))

'Click en boton > Menu-Compras'
WebUI.click(CustomKeywords.'menu.xpath_dynamic.object'('boton_compras'))

'Click en boton > Agregar Compra'
WebUI.click(CustomKeywords.'compra.xpath_dynamic.object'('boton_agregar_compra'))

'Check > Usar fecha de ingreso anterior'
WebUI.click(CustomKeywords.'compra.xpath_dynamic.object'('check_fecha_anterior'))

'Insertar letra para buscar > Proveedor'
WebUI.setText(CustomKeywords.'compra.xpath_dynamic.object'('input_proveedor'), proveedor)

'Seleccionar >  Proveedor'
CustomKeywords.'selects.selectAleatory.aleatoryobject'('opcions_proveedor', '2')
/*
String element = WebUI.getAttribute(CustomKeywords.'compra.xpath_dynamic.object'('modal'), 'style')
println(element)

if (element.contains('block')) {
	
	'Seleccionar > Orden de Compra > Folio'
	CustomKeywords.'selects.table.findtextintable'('table_orden_compra', id_folio)

	'Espera de 5 segundos'
	WebUI.delay(5)

	'Insertar no de factura'
	WebUI.setText(CustomKeywords.'compra.xpath_dynamic.object'('input_no_factura'), CustomKeywords.'compra.data_aleatory.getAleatotyData'(
	        'no_factura'))
	
	'Scroll'
	WebUI.scrollToElement(CustomKeywords.'compra.xpath_dynamic.object'('guardar_form'), 1)

	'Guardar > Liquidar orden de compra'
	WebUI.click(CustomKeywords.'compra.xpath_dynamic.object'('guardar_form'))

	'Espera de 5 segundos'
	WebUI.delay(5)
}

else {
*/	
	descripcionproduct = GlobalVariable.Producto
//}

'Insertar > Entregar a'
WebUI.setText(CustomKeywords.'compra.xpath_dynamic.object'('input_entregar_a'), CustomKeywords.'compra.data_aleatory.getAleatotyData'(
		'comentarios'))


'Seleccionar condicion aleatoria'
CustomKeywords.'selects.selectAleatory.aleatoryobject'('select_condicion', '3')

'Seleccionar moneda aleatoria'
CustomKeywords.'selects.selectAleatory.aleatoryobject'('select_moneda', '3')

'Scroll'
WebUI.scrollToElement(CustomKeywords.'compra.xpath_dynamic.object'('check_incremental_sin_iva'), 1)

'Check > Incremental_sin_iva'
WebUI.click(CustomKeywords.'compra.xpath_dynamic.object'('check_incremental_sin_iva'))

'Insertar no de unidades'
String unidades = WebUI.getAttribute(CustomKeywords.'compra.xpath_dynamic.object'('input_no_unidades'), 'style')
println(unidades)

'Espera de 2 segundos'
WebUI.delay(2)

if (unidades.contains('block')) {

	WebUI.setText(CustomKeywords.'compra.xpath_dynamic.object'('input_no_unidades'), CustomKeywords.'compra.data_aleatory.getAleatotyData'(
			'no_unidades'))	
}

'Insertar no de descuento'
WebUI.setText(CustomKeywords.'compra.xpath_dynamic.object'('input_descuento'), CustomKeywords.'compra.data_aleatory.getAleatotyData'(
		'descuento'))

'Insertar no de flete'
WebUI.setText(CustomKeywords.'compra.xpath_dynamic.object'('input_flete'), CustomKeywords.'compra.data_aleatory.getAleatotyData'(
		'fletes'))

'Insertar comentarios'
WebUI.setText(CustomKeywords.'compra.xpath_dynamic.object'('input_comentarios'), CustomKeywords.'compra.data_aleatory.getAleatotyData'(
		'comentarios'))

'Boton > Guardar'
WebUI.click(CustomKeywords.'compra.xpath_dynamic.object'('button_guardar'))

'Espera de 5 segundos'
WebUI.delay(5)