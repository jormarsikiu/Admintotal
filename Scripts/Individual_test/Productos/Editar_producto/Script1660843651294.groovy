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

/*Para ejecutar este archivo individualmente se debe agregar en 'variables globales' la descripcion de un producto valido*/

String openBrowser = CustomKeywords.'navegador.validateNavegador.browser'()
String closeBrowser = ''

println(openBrowser)

'Si el navegador esta abierto'
if (openBrowser == '1')
	{
		String descripcionproduct = GlobalVariable.descripcionproducto
		
		'Insertar descripcion en el filtro'
		WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_buscar_texto'), descripcionproduct)
		
		'Indicador para no cerrar el navegador y continuar el flujo'
		closeBrowser = '0'
		
	}
else {
		
		'Agregar el producto a Editar que exista'
		String descripcionproduct = GlobalVariable.Producto
		
		'Click en boton > Menu-Inventario'
		WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('boton_inventario'))
		
		'Click en boton > Menu - Catalogos'
		WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('boton_catalogo'))
		
		'Click en boton > Menu-Productos'
		WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('boton_productos'))
		
		WebUI.comment('Si se genera un error es porque el producto no existe, debe agregarse en variables globales')
		
		'Insertar descripcion en el filtro'
		WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_buscar_texto'), descripcionproduct)
		
		'Indicador para cerrar el navegador'
		closeBrowser = '1'
}


'Click en el boton de buscar'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('button_buscar_texto'))

'Abrir el producto'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('first_prod_table'))

'Editar el producto'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('edit_producto'))

'Validar la URl'
assert WebUI.getUrl().contains('/admin/producto/edit/')

'Insertar en input > Comentarios'
WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_comentarios'), 'Automatizacion > Producto Actualizado')

'Scroll'
WebUI.scrollToElement(CustomKeywords.'productos.xpath_dynamic.object'('input_unidad_medida'), 1)

'Guardar formulario'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('guardar_form'))

'Espera de 8 segundos'
WebUI.delay(8)

'Ir al filtro'
WebUI.navigateToUrl(GlobalVariable.Web +'/admin/inventario/catalogos/productos/')

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
