import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.exception.StepFailedException as StepFailedException
import internal.GlobalVariable as GlobalVariable


'Keyword para abrir el navegador'
String openBrowser = CustomKeywords.'keyword_navegador.validateNavegador.browser'()

'Variable para cerrar o mantener abierto el navegador'
String closeBrowser = ''

'Variable para guardar el producto'
String descripcionproduct = ''

'Si el navegador esta abierto usar el producto creado, sino usar un producto ingresado manualmente en Variables Locales'
if (openBrowser == '1')
	{
		'Producto del flujo anterior'
		descripcionproduct = GlobalVariable.descripcionproducto
		
		'Indicador para no cerrar el navegador y continuar el flujo'
		closeBrowser = '0'
		
	}

else {
		
		'Producto de las variables globales'
		descripcionproduct = GlobalVariable.Producto
		
		'Indicador para cerrar el navegador'
		closeBrowser = '1'
}

'Click en boton > Menu-Inventario'
WebUI.click(CustomKeywords.'keyword_sharedElements.menu_xpath_dynamic.getObject'('boton_inventario'))

'Click en boton > Menu - Entradas Almacen'
WebUI.click(CustomKeywords.'keyword_sharedElements.menu_xpath_dynamic.getObject'('boton_entradas_almacen'))

'Click en boton > Menu-Orden Compra'
WebUI.click(CustomKeywords.'keyword_sharedElements.menu_xpath_dynamic.getObject'('boton_orden_compra'))

'Click en boton > Agregar Orden Compra'
WebUI.click(CustomKeywords.'keyword_ordenCompra.xpath_dynamic.getObject'('boton_agregar_orden_compra'))

'Insertar letra para buscar > Proveedor'
WebUI.setText(CustomKeywords.'keyword_ordenCompra.xpath_dynamic.getObject'('input_proveedor'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
        'letra'))

'Seleccionar >  Proveedor'
CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('opcions_proveedor', '2')

'Guardar valor del Proveedor'
String nombre_proveedor = WebUI.getAttribute(CustomKeywords.'keyword_ordenCompra.xpath_dynamic.getObject'('input_proveedor'), 'value')
println(nombre_proveedor)

'Crear el Proveedor como variable global'
CustomKeywords.'keyword_variableGlobal.generateVariable.addGlobalVariable'('nombreProveedor', nombre_proveedor)

println(GlobalVariable.nombreProveedor)

'Insertar letra para buscar > Entregar a'
WebUI.setText(CustomKeywords.'keyword_ordenCompra.xpath_dynamic.getObject'('input_entregar_a'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
        'letra'))

'Seleccionar >  Entregar a'
CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('opcions_entregar_a', '2')

'Check > Recoger a Domicilio'
WebUI.click(CustomKeywords.'keyword_ordenCompra.xpath_dynamic.getObject'('check_recoger_a_dormicilio'))

'Insertar en input > Fecha Entrega'
WebUI.setText(CustomKeywords.'keyword_ordenCompra.xpath_dynamic.getObject'('input_fecha_entrega'), CustomKeywords.'keyword_ordenCompra.data_aleatory.getAleatotyData'(
		'fecha_entrega'))

'Abrir select > Hora de'
WebUI.click(CustomKeywords.'keyword_ordenCompra.xpath_dynamic.getObject'('select_hora_de'))

'Select opcion > Hora de'
CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('opcions_hora_de', '2')

'Abrir select > Hora hasta'
WebUI.click(CustomKeywords.'keyword_ordenCompra.xpath_dynamic.getObject'('select_hora_hasta'))

'Select opcion > Hora hasta'
CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('opcions_hora_hasta', '2')

'Aceptar modal'
WebUI.click(CustomKeywords.'keyword_ordenCompra.xpath_dynamic.getObject'('button_aceptar_modal'))

'Abrir select > Moneda'
WebUI.click(CustomKeywords.'keyword_ordenCompra.xpath_dynamic.getObject'('select_moneda'))

'Select opcion > Moneda'
CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('options_moneda', '2')

'Insertar un T.C'
WebUI.setText(CustomKeywords.'keyword_ordenCompra.xpath_dynamic.getObject'('input_T_C'), CustomKeywords.'keyword_ordenCompra.data_aleatory.getAleatotyData'(
        'T.C'))

'Abrir select > Condicion'
WebUI.click(CustomKeywords.'keyword_ordenCompra.xpath_dynamic.getObject'('select_condicion'))
	
'Seleccionar opcion > Condicion'
CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('options_condicion', '2')

'Abrir select > Uso CFDI'
WebUI.click(CustomKeywords.'keyword_ordenCompra.xpath_dynamic.getObject'('select_cfdi'))
	
'Seleccionar opcion > Uso CFDI'
CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('options_cfdi', '2')

'Scroll hacia el producto'
WebUI.scrollToElement(CustomKeywords.'keyword_ordenCompra.xpath_dynamic.getObject'('input_producto'), 1)

'Insertar producto'
WebUI.setText(CustomKeywords.'keyword_ordenCompra.xpath_dynamic.getObject'('input_producto'), descripcionproduct)

'Select opcion > producto'
CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('options_producto', '2')

'Insertar cantidad'
WebUI.setText(CustomKeywords.'keyword_ordenCompra.xpath_dynamic.getObject'('input_cantidad'), CustomKeywords.'keyword_ordenCompra.data_aleatory.getAleatotyData'(
		'cantidad'))

'Insertar en input > Fecha Entrega'
WebUI.setText(CustomKeywords.'keyword_ordenCompra.xpath_dynamic.getObject'('input_fecha'), CustomKeywords.'keyword_ordenCompra.data_aleatory.getAleatotyData'(
        'fecha_entrega'))

'Insertar en input > Comentario'
WebUI.setText(CustomKeywords.'keyword_ordenCompra.xpath_dynamic.getObject'('textarea_comentario'), CustomKeywords.'keyword_ordenCompra.data_aleatory.getAleatotyData'(
        'comentarioCrear'))

'Scroll'
WebUI.scrollToElement(CustomKeywords.'keyword_ordenCompra.xpath_dynamic.getObject'('guardar_form'), 1)

'Guardar formulario'
WebUI.click(CustomKeywords.'keyword_ordenCompra.xpath_dynamic.getObject'('guardar_form'))


'Guardar valor del Folio'
String folio = WebUI.getText(CustomKeywords.'keyword_ordenCompra.xpath_dynamic.getObject'('id_folio'))
println(folio)

'Crear el folio como variable global'
CustomKeywords.'keyword_variableGlobal.generateVariable.addGlobalVariable'('idfolio', folio)

println(GlobalVariable.idfolio)

'Espera de 8 segundos'
WebUI.delay(8)

println(closeBrowser)

'Validar para cerrar el navegador'
if (closeBrowser == '1') {
	
	'Cerrar navegador'
	WebUI.closeBrowser()
	
} else if (closeBrowser == '0') {
	
	'Espera de 1 segundos'
	WebUI.delay(1)

	
}