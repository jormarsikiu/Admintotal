import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

String tipoproductt = 'Automatizacion 2741'

//String tipoproductt = GlobalVariable.tipoproducto

'Click en boton > Menu-Inventario'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('boton_inventario'))

'Click en boton > Menu - Entradas Almacen'
WebUI.click(CustomKeywords.'ordenCompra.xpath_dynamic.object'('boton_entradas_almacen'))

'Click en boton > Menu-Orden Compra'
WebUI.click(CustomKeywords.'ordenCompra.xpath_dynamic.object'('boton_orden_compra'))

'Click en boton > Agregar Orden Compra'
WebUI.click(CustomKeywords.'ordenCompra.xpath_dynamic.object'('boton_agregar_orden_compra'))

'Insertar > Proveedor'
WebUI.setText(CustomKeywords.'ordenCompra.xpath_dynamic.object'('input_proveedor'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
        'letra'))

WebUI.click(CustomKeywords.'ordenCompra.xpath_dynamic.object'('input_first_proveedor'))

'Insertar > Entregar a'
WebUI.setText(CustomKeywords.'ordenCompra.xpath_dynamic.object'('input_entregar_a'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
        'letra'))

WebUI.click(CustomKeywords.'ordenCompra.xpath_dynamic.object'('input_first_entregar_a'))

'Check > Recoger a Domicilio'
WebUI.click(CustomKeywords.'ordenCompra.xpath_dynamic.object'('check_recoger_a_dormicilio'))


WebUI.click(CustomKeywords.'ordenCompra.xpath_dynamic.object'('button_aceptar_modal'))

'Insertar el producto'
WebUI.setText(CustomKeywords.'ordenCompra.xpath_dynamic.object'('input_producto'), tipoproductt)

WebUI.click(CustomKeywords.'ordenCompra.xpath_dynamic.object'('input_first_producto'))

