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

'Scroll'
WebUI.scrollToElement(CustomKeywords.'productos.xpath_dynamic.object'('input_unidad_medida'), 1)

'Guardar formulario'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('guardar_form'))

'Ir al filtro'
WebUI.navigateToUrl(GlobalVariable.Web +'/admin/inventario/catalogos/productos/')

'Espera de 5 segundos'
WebUI.delay(5)

'Cerrar navegador'
WebUI.closeBrowser()
