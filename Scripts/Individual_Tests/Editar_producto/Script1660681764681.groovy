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
/*
WebUI.callTestCase(findTestCase('Individual_Tests/Login_exitoso'), [:], FailureHandling.STOP_ON_FAILURE)

'Click en boton > Menu-Inventario'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('boton_inventario'))

'Click en boton > Menu - Catalogos'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('boton_catalogo'))

'Click en boton > Menu-Productos'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('boton_productos'))
*/
String descripcionproduct = GlobalVariable.descripcionproducto

String tipoproduct = GlobalVariable.tipoproducto

'Validar la URl del filtro'
String Url_new = GlobalVariable.Web + '/admin/inventario/catalogos/productos/'

'Obtener la URl'
currentUrl = WebUI.getUrl()

'Validar la URL correcta'
if (currentUrl != Url_new) {
    'Mostrar error si no esta en la URL'
    throw new StepFailedException('Bad URL')
}
/*
String tipo = ''

'Insertar tipo de producto en el filtro'
if (tipoproduct == '0')
	 tipo = 'Artículo'
else if (tipoproduct == '1')
	 tipo = 'Materia Prima'
else if (tipoproduct == '2')
	 tipo = 'Ensamble'
else if (tipoproduct == '3')
	 tipo = 'Servicio'
else if (tipoproduct == '4')
	 tipo = 'Activo Fijo'
else if (tipoproduct == '5')
	 tipo = 'Servicios subcontratados'
else if (tipoproduct == '7')
	 tipo = 'Producción'
else if (tipoproduct == '8')
	 tipo = 'Ensamble dinámico'
else if (tipoproduct == '9')
	 tipo = 'Mano de obra'
else if (tipoproduct == '10')
	 tipo = 'Artículo para arrendamiento' 
	 
'Espera de 5 segundos'
WebUI.delay(5)
	 
println tipo
'Insertar el tipo de producto'	
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('input_buscar_tipoproducto'))

WebUI.selectOptionByValue(CustomKeywords.'productos.xpath_dynamic.object'('input_buscar_tipoproducto'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
	'tipoproduct'), true)
*/
'Insertar descripcion en el filtro'
WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_buscar_texto'), descripcionproduct)

'Click en el boton de buscar'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('button_buscar_texto'))

'Abrir el producto'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('first_prod_table'))

'Editar el producto'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('edit_producto'))

'Validar la URl'
assert WebUI.getUrl().contains('/admin/producto/edit/')

'Insertar en input > Comentarios'
WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_comentarios'), 'Producto Actualizado')

'Guardar formulario'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('guardar_form'))

'Espera de 2 segundos'
WebUI.delay(2)

'Ir al filtro'
WebUI.navigateToUrl(GlobalVariable.Web +'/admin/inventario/catalogos/productos/')

'Cerrar navegador'
WebUI.closeBrowser()
