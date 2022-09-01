import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable

/*Para ejecutar este archivo individualmente se debe agregar en 'variables globales' un numero de folio valido de la orden de compra*/

String openBrowser = CustomKeywords.'keyword_navegador.validateNavegador.browser'()
String closeBrowser = ''

println(openBrowser)

'Si el navegador esta abierto'
if (openBrowser == '1')
	{	
		'Ir al filtro'
		WebUI.navigateToUrl(GlobalVariable.Web +'/admin/inventario/entradas/ordenes_compra/')
		
		'Guarda el no. de folio de la orden de compra'
		String id_folio = GlobalVariable.idfolio
		
		'Insertar fecha desde en el filtro'
		WebUI.setText(CustomKeywords.'keyword_ordenCompra.xpath_dynamic.getObject'('fecha_desde'), new Date().format('dd/MM/yy'))
		
		'Insertar fecha hasta en el filtro'
		WebUI.setText(CustomKeywords.'keyword_ordenCompra.xpath_dynamic.getObject'('fecha_hasta'), new Date().format('dd/MM/yy'))
		
		'Insertar folio en el filtro'
		WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.object'('input_buscar_texto'), id_folio)
		
		'Click en boton > Boton buscar'
		WebUI.click(CustomKeywords.'keyword_ordenCompra.xpath_dynamic.getObject'('button_buscar'))
		
		'Indicador para no cerrar el navegador y continuar el flujo'
		closeBrowser = '0'
		
	}
else {
		
		'Guarda el no. de folio de la orden de compra'
		String id_folio = GlobalVariable.Folio
		
		'Click en boton > Menu-Inventario'
		WebUI.click(CustomKeywords.'keyword_sharedElements.menu_xpath_dynamic.getObject'('boton_inventario'))
		
		'Click en boton > Menu - Entradas Almacen'
		WebUI.click(CustomKeywords.'keyword_sharedElements.menu_xpath_dynamic.getObject'('boton_entradas_almacen'))
		
		'Click en boton > Menu-Orden Compra'
		WebUI.click(CustomKeywords.'keyword_sharedElements.menu_xpath_dynamic.getObject'('boton_orden_compra'))
		
		WebUI.comment('Si se genera un error es porque el no de folio no existe ni las fechas, debe agregarse en variables globales')
		
		'Insertar fecha desde en el filtro'
		WebUI.setText(CustomKeywords.'keyword_ordenCompra.xpath_dynamic.getObject'('fecha_desde'), GlobalVariable.FechaFolio)
		
		'Insertar fecha hasta en el filtro'
		WebUI.setText(CustomKeywords.'keyword_ordenCompra.xpath_dynamic.getObject'('fecha_hasta'), GlobalVariable.FechaFolio)
		
		'Insertar folio en el filtro'
		WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.object'('input_buscar_texto'), id_folio)
		
		'Click en boton > Boton buscar'
		WebUI.click(CustomKeywords.'keyword_ordenCompra.xpath_dynamic.getObject'('button_buscar'))
		
		'Indicador para cerrar el navegador'
		closeBrowser = '1'
}

'Scroll'
WebUI.scrollToElement(CustomKeywords.'keyword_ordenCompra.xpath_dynamic.getObject'('first_oc_table'), 1)

'Abrir el orden de compra la primera'
WebUI.click(CustomKeywords.'keyword_ordenCompra.xpath_dynamic.getObject'('first_oc_table'))

'Editar orden de compra'
WebUI.click(CustomKeywords.'keyword_ordenCompra.xpath_dynamic.getObject'('edit_oc'))

'Scroll al comentario'
WebUI.scrollToElement(CustomKeywords.'keyword_ordenCompra.xpath_dynamic.getObject'('textarea_comentario'), 1)

'Insertar en input > Comentario'
WebUI.setText(CustomKeywords.'keyword_ordenCompra.xpath_dynamic.getObject'('textarea_comentario'), CustomKeywords.'keyword_ordenCompra.data_aleatory.getAleatotyData'(
        'comentarioEditar'))

'Guardar orden de compra'
WebUI.click(CustomKeywords.'keyword_ordenCompra.xpath_dynamic.getObject'('guardar_editar'))

'Espera de 5 segundos'
WebUI.delay(5)

//'Ir al filtro'
//WebUI.navigateToUrl(GlobalVariable.Web +'/admin/inventario/entradas/ordenes_compra/')

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

