import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable

'Keyword para abrir el navegador'
String openBrowser = CustomKeywords.'navegador.validateNavegador.browser'()

'Variable para cerrar o mantener abierto el navegador'
String closeBrowser = ''

'Variable para guardar el producto'
String descripcionproduct = ''

'Si el navegador esta abierto usar el producto creado, sino usar un producto ingresado manualmente en Variables Locales'
if (openBrowser == '1')
	{
		descripcionproduct = GlobalVariable.descripcionproducto
		
		'Insertar descripcion en el filtro'
		WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_buscar_texto'), descripcionproduct)
		
		'Indicador para no cerrar el navegador y continuar el flujo'
		closeBrowser = '0'
		
	}

else {
		
		'Agregar un producto que ya exista'
		descripcionproduct = GlobalVariable.Producto
		
		'Indicador para cerrar el navegador'
		closeBrowser = '1'
}

'Click en boton > Menu-Inventario'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('boton_inventario'))

'Click en boton > Menu - Entradas Almacen'
WebUI.click(CustomKeywords.'ordenCompra.xpath_dynamic.object'('boton_entradas_almacen'))

'Click en boton > Menu-Orden Compra'
WebUI.click(CustomKeywords.'ordenCompra.xpath_dynamic.object'('boton_orden_compra'))

'Click en boton > Agregar Orden Compra'
WebUI.click(CustomKeywords.'ordenCompra.xpath_dynamic.object'('boton_agregar_orden_compra'))

'Insertar letra para buscar > Proveedor'
WebUI.setText(CustomKeywords.'ordenCompra.xpath_dynamic.object'('input_proveedor'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
        'letra'))

'Seleccionar >  Proveedor'
CustomKeywords.'selects.selectAleatory.aleatoryobject'('opcions_proveedor', '2')

'Insertar letra para buscar > Entregar a'
WebUI.setText(CustomKeywords.'ordenCompra.xpath_dynamic.object'('input_entregar_a'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
        'letra'))

'Seleccionar >  Entregar a'
CustomKeywords.'selects.selectAleatory.aleatoryobject'('opcions_entregar_a', '2')

'Check > Recoger a Domicilio'
WebUI.click(CustomKeywords.'ordenCompra.xpath_dynamic.object'('check_recoger_a_dormicilio'))

'Insertar en input > Fecha Entrega'
WebUI.setText(CustomKeywords.'ordenCompra.xpath_dynamic.object'('input_fecha_entrega'), CustomKeywords.'ordenCompra.data_aleatory.getAleatotyData'(
		'fecha_entrega'))

'Abrir select > Hora de'
WebUI.click(CustomKeywords.'ordenCompra.xpath_dynamic.object'('select_hora_de'))

'Select opcion > Hora de'
CustomKeywords.'selects.selectAleatory.aleatoryobject'('opcions_hora_de', '2')

'Abrir select > Hora hasta'
WebUI.click(CustomKeywords.'ordenCompra.xpath_dynamic.object'('select_hora_hasta'))

'Select opcion > Hora hasta'
CustomKeywords.'selects.selectAleatory.aleatoryobject'('opcions_hora_hasta', '2')

'Aceptar modal'
WebUI.click(CustomKeywords.'ordenCompra.xpath_dynamic.object'('button_aceptar_modal'))

'Abrir select > Moneda'
WebUI.click(CustomKeywords.'ordenCompra.xpath_dynamic.object'('select_moneda'))

'Select opcion > Moneda'
CustomKeywords.'selects.selectAleatory.aleatoryobject'('options_moneda', '2')

'Insertar un T.C'
WebUI.setText(CustomKeywords.'ordenCompra.xpath_dynamic.object'('input_T_C'), CustomKeywords.'ordenCompra.data_aleatory.getAleatotyData'(
        'T.C'))

'Abrir select > Condicion'
WebUI.click(CustomKeywords.'ordenCompra.xpath_dynamic.object'('select_condicion'))
	
'Seleccionar opcion > Condicion'
CustomKeywords.'selects.selectAleatory.aleatoryobject'('options_condicion', '2')

'Abrir select > Uso CFDI'
WebUI.click(CustomKeywords.'ordenCompra.xpath_dynamic.object'('select_cfdi'))
	
'Seleccionar opcion > Uso CFDI'
CustomKeywords.'selects.selectAleatory.aleatoryobject'('options_cfdi', '2')

'Scroll hacia el producto'
WebUI.scrollToElement(CustomKeywords.'ordenCompra.xpath_dynamic.object'('input_producto'), 1)

'Insertar producto'
WebUI.setText(CustomKeywords.'ordenCompra.xpath_dynamic.object'('input_producto'), descripcionproduct)

'Select opcion > producto'
CustomKeywords.'selects.selectAleatory.aleatoryobject'('options_producto', '2')

'Insertar cantidad'
WebUI.setText(CustomKeywords.'ordenCompra.xpath_dynamic.object'('input_cantidad'), CustomKeywords.'ordenCompra.data_aleatory.getAleatotyData'(
		'cantidad'))

'Crear tipo de dato fecha'
Date todaysDate = new Date()

'Insertar en input > Fecha Entrega'
WebUI.setText(CustomKeywords.'ordenCompra.xpath_dynamic.object'('input_fecha'), CustomKeywords.'ordenCompra.data_aleatory.getAleatotyData'(
        'fecha_entrega'))

'Insertar en input > Comentario'
WebUI.setText(CustomKeywords.'ordenCompra.xpath_dynamic.object'('textarea_comentario'), CustomKeywords.'ordenCompra.data_aleatory.getAleatotyData'(
        'comentario'))

'Guardar formulario'
WebUI.click(CustomKeywords.'ordenCompra.xpath_dynamic.object'('guardar_form'))

'Espera de 5 segundos'
WebUI.delay(5)

println(closeBrowser)

'Validar para cerrar el navegador'
if (closeBrowser == '1') {
	
	'Cerrar navegador'
	WebUI.closeBrowser()
	
} else if (closeBrowser == '0') {
	
	'Espera de 1 segundos'
	WebUI.delay(1)

	
}