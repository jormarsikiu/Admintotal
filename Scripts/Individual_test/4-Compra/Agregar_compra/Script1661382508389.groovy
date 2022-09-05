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

'Variable para cerrar o mantener abierto el navegador'
String closeBrowser = ''

'Variable para guardar el producto'

String descripcionproduct = ''

'Variable para guardar el proveedor'
String proveedor = ''

'Variable para guardar el proveedor'
String validarproveedor = ''

'Variable para guardar el folio'
String id_folio = ''

'Variable para abrir la modal de orden de compra'
String ordenCompra = ''

'Mantener abierto el navegador/ Abrir el navegador'
if (openBrowser == '1')
	{
		'Flujo Completo'
		WebUI.navigateToUrl(GlobalVariable.Web +'/admin/inventario/entradas/compras/')
		
		proveedor = GlobalVariable.nombreProveedor
		
		id_folio = GlobalVariable.idfolio
		
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
			
		ordenCompra = '1'
		
	}

else {
		
		'Flujo Individual'
		
		proveedor = GlobalVariable.Proveedor
		
		id_folio = GlobalVariable.Folio
		
		closeBrowser = '1'
		
		ordenCompra = '0'
}

'Click en boton > Menu-Inventario'
WebUI.click(findTestObject('Object Repository/menu_objects/button_inventario'))
		
'Click en boton > Menu - Entradas Almacen'
WebUI.click(findTestObject('Object Repository/menu_objects/button_entradas_almacen'))
		
'Click en boton > Menu-Compras'
WebUI.click(findTestObject('Object Repository/menu_objects/button_compras'))

'Click en boton > Agregar Compra'
WebUI.click(findTestObject('Object Repository/compra_objects/button_agregar_compra'))

'Check > Usar fecha de ingreso anterior'
WebUI.click(findTestObject('Object Repository/compra_objects/check_fecha_anterior'))

'Insertar letra para buscar > Proveedor'
WebUI.setText(findTestObject('Object Repository/compra_objects/input_proveedor'), proveedor)

'Seleccionar >  Proveedor'
CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'(findTestObject('Object Repository/compra_objects/options_proveedor'))


if (ordenCompra == '1')
{

	String element = WebUI.getAttribute(findTestObject('Object Repository/compra_objects/modal'), 'style')
	println(element)

	if (element.contains('block')) {
	
		'Seleccionar > Orden de Compra > Folio'
		CustomKeywords.'keyword_sharedElements.table.findtextintable'(findTestObject('Object Repository/compra_objects/table_orden_compra'), id_folio)

		'Espera de 2 segundos'
		WebUI.delay(2)

		'Insertar no de factura'
		WebUI.setText(findTestObject('Object Repository/compra_objects/input_no_factura'), CustomKeywords.'keyword_compra.compra_data_aleatory.getAleatotyData'(
	        'no_factura'))
	
		'Scroll'
		WebUI.scrollToElement(findTestObject('Object Repository/compra_objects/guardar_form'), 1)

		'Guardar > Liquidar orden de compra'
		WebUI.click(findTestObject('Object Repository/compra_objects/guardar_form'))

		'Espera de 2 segundos'
		WebUI.delay(2)
		}
}

else if (ordenCompra == '0'){
	
	String element = WebUI.getAttribute(findTestObject('Object Repository/compra_objects/modal'), 'style')
	println(element)

	if (element.contains('block')) {
		
		/*CustomKeywords.'keyword_sharedElements.table.findtextintable'('table_orden_compra', '16')
		
		'Insertar no de factura'
		WebUI.setText(CustomKeywords.'borrar.c_xpath_dynamic.getObject'('input_no_factura'), CustomKeywords.'keyword_compra.compra_data_aleatory.getAleatotyData'(
			'no_factura'))
	
		'Scroll'
		WebUI.scrollToElement(CustomKeywords.'borrar.c_xpath_dynamic.getObject'('guardar_form'), 1)

		'Guardar > Liquidar orden de compra'
		WebUI.click(CustomKeywords.'borrar.c_xpath_dynamic.getObject'('guardar_form'))*/
		
		WebUI.click(findTestObject('Object Repository/compra_objects/cancel_modal'))
		}
	
		'Scroll'
		WebUI.scrollToElement(findTestObject('Object Repository/compra_objects/input_no_factura'), 1)

		'Insertar no de factura'
		WebUI.setText(findTestObject('Object Repository/compra_objects/input_no_factura'), CustomKeywords.'keyword_compra.compra_data_aleatory.getAleatotyData'(
		'no_factura'))
		
		descripcionproduct = GlobalVariable.Producto
		
		'Insertar producto'
		WebUI.setText(findTestObject('Object Repository/compra_objects/input_producto'), descripcionproduct)
		
		'Espera de 3 segundos'
		WebUI.delay(3)
		
		'Buscar elementos en el select'
		String claveprod = WebUI.getAttribute(findTestObject('Object Repository/compra_objects/validate_producto'), 'style')
		println(claveprod)
		
		'Si hay valores seleccionar uno aleatorio'
		if (claveprod.contains('block')) {
		
			String validarclave = CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'(findTestObject('Object Repository/compra_objects/opcion_producto'))
			
		}
		else {
				
			WebUI.setText(findTestObject('Object Repository/compra_objects/input_producto'), '')
				
			WebUI.comment("El select no tiene elementos")
			
		}
	
}

'Insertar > Entregar a'
WebUI.setText(findTestObject('Object Repository/compra_objects/input_entregar_a'), CustomKeywords.'keyword_compra.compra_data_aleatory.getAleatotyData'(
		'comentarios'))

'Scroll'
WebUI.scrollToElement(findTestObject('Object Repository/compra_objects/input_no_factura'), 1)

'Seleccionar condicion aleatoria'
CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'(findTestObject('Object Repository/compra_objects/select_condicion'))

'Seleccionar moneda aleatoria'
CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'(findTestObject('Object Repository/compra_objects/select_moneda'))

'Scroll'
WebUI.scrollToElement(findTestObject('Object Repository/compra_objects/check_incremental_sin_iva'), 1)

'Check > Incremental_sin_iva'
WebUI.click(findTestObject('Object Repository/compra_objects/check_incremental_sin_iva'))

'Espera de 3 segundos'
WebUI.delay(3)

'Scroll'
WebUI.scrollToElement(findTestObject('Object Repository/compra_objects/check_incremental_sin_iva'), 1)

'Insertar unidades de medida'
boolean validar_unidades = CustomKeywords.'keyword_sharedElements.table.findheaderintable'(findTestObject('Object Repository/compra_objects/table_unidades'), 'N° de unidades')

if (validar_unidades == true)
{
	WebUI.setText(findTestObject('Object Repository/compra_objects/input_no_unidades'), CustomKeywords.'keyword_compra.compra_data_aleatory.getAleatotyData'('no_unidades'))
	
	'Espera de 3 segundos'
	WebUI.delay(3)
	
}else {
	println ('El producto no tiene unidades de medida')
	
}

'Insertar no de descuento'
WebUI.setText(findTestObject('Object Repository/compra_objects/input_descuento'), CustomKeywords.'keyword_compra.compra_data_aleatory.getAleatotyData'(
		'descuento'))

'Insertar no de flete'
WebUI.setText(findTestObject('Object Repository/compra_objects/input_flete'), CustomKeywords.'keyword_compra.compra_data_aleatory.getAleatotyData'(
		'fletes'))

'Scroll'
WebUI.scrollToElement(findTestObject('Object Repository/compra_objects/input_descuento'), 1)

'Insertar comentarios'
WebUI.setText(findTestObject('Object Repository/compra_objects/input_comentarios'), CustomKeywords.'keyword_compra.compra_data_aleatory.getAleatotyData'(
		'comentarios'))

'Scroll'
WebUI.scrollToElement(findTestObject('Object Repository/compra_objects/button_guardar'), 1)

'Boton > Guardar'
WebUI.click(findTestObject('Object Repository/compra_objects/button_guardar'))

'Guardar valor del Folio de la compra'
String folio_compra = WebUI.getText(findTestObject('Object Repository/compra_objects/id_folio'))
println(folio_compra)

'Crear el folio como variable global'
CustomKeywords.'keyword_variableGlobal.generateVariable.addGlobalVariable'('idfolioCompra', folio_compra)

println(GlobalVariable.idfolioCompra)

println(closeBrowser)

'Validar para cerrar el navegador'
if (closeBrowser == '1') {
	
	'Cerrar navegador'
	WebUI.closeBrowser()
	
} else if (closeBrowser == '0') {
	
	'Espera de 1 segundos'
	WebUI.delay(1)

	
}