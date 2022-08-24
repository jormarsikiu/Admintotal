import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable

/*Para ejecutar este archivo individualmente se debe agregar en 'variables globales' un numero de folio valido de la orden de compra*/

String openBrowser = CustomKeywords.'navegador.validateNavegador.browser'()
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
		String id_folio = GlobalVariable.Folio
		
		'Click en boton > Menu-Inventario'
		WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('boton_inventario'))
		
		'Click en boton > Menu - Entradas Almacen'
		WebUI.click(CustomKeywords.'ordenCompra.xpath_dynamic.object'('boton_entradas_almacen'))
		
		'Click en boton > Menu-Orden Compra'
		WebUI.click(CustomKeywords.'ordenCompra.xpath_dynamic.object'('boton_orden_compra'))
		
		WebUI.comment('Si se genera un error es porque el no de folio no existe ni las fechas, debe agregarse en variables globales')
		
		'Insertar fecha desde en el filtro'
		WebUI.setText(CustomKeywords.'ordenCompra.xpath_dynamic.object'('fecha_desde'), GlobalVariable.FechaFolio)
		
		'Insertar fecha hasta en el filtro'
		WebUI.setText(CustomKeywords.'ordenCompra.xpath_dynamic.object'('fecha_hasta'), GlobalVariable.FechaFolio)
		
		'Insertar folio en el filtro'
		WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_buscar_texto'), id_folio)
		
		'Click en boton > Boton buscar'
		WebUI.click(CustomKeywords.'ordenCompra.xpath_dynamic.object'('button_buscar'))
		
		'Indicador para cerrar el navegador'
		closeBrowser = '1'
}

'Abrir el orden de compra la primera'
WebUI.click(CustomKeywords.'ordenCompra.xpath_dynamic.object'('first_oc_table'))

'Editar orden de compra'
WebUI.click(CustomKeywords.'ordenCompra.xpath_dynamic.object'('edit_oc'))

'Scroll al comentario'
WebUI.scrollToElement(CustomKeywords.'ordenCompra.xpath_dynamic.object'('textarea_comentario'), 1)

'Insertar en input > Comentario'
WebUI.setText(CustomKeywords.'ordenCompra.xpath_dynamic.object'('textarea_comentario'), CustomKeywords.'ordenCompra.data_aleatory.getAleatotyData'(
        'comentarioEditar'))

'Guardar orden de compra'
WebUI.click(CustomKeywords.'ordenCompra.xpath_dynamic.object'('guardar_editar'))

'Espera de 5 segundos'
WebUI.delay(5)

'Ir al filtro'
WebUI.navigateToUrl(GlobalVariable.Web +'/admin/inventario/entradas/ordenes_compra/')

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

