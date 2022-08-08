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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils

'Autenticacion del sistema'
WebUI.callTestCase(findTestCase('Individual_Tests/Login_exitoso'), [:], FailureHandling.STOP_ON_FAILURE)

'Click en boton > Menu-Inventario'
WebUI.click(CustomKeywords.'productos.dynamicPath.object'('boton_inventario'))

'Click en boton > Menu - Catalogos'
WebUI.click(CustomKeywords.'productos.dynamicPath.object'('boton_catalogo'))

'Click en boton > Menu-Productos'
WebUI.click(CustomKeywords.'productos.dynamicPath.object'('boton_productos'))

'Xpath para boton de agregar productos'
WebUI.click(CustomKeywords.'productos.dynamicPath.object'('boton_agregar_productos'))

'Insertar en input > Codigo'
WebUI.setText(CustomKeywords.'productos.dynamicPath.object'('input_codigo'), CustomKeywords.'productos.data.getAleatotyData'('codigo'))

'Insertar en input > Clave prod serv'
WebUI.setText(CustomKeywords.'productos.dynamicPath.object'('input_clave_prod_serv'), CustomKeywords.'productos.data.getAleatotyData'('codigo_busqueda'))

'Seleccionar > Primer Elemento > Clave prod serv'
WebUI.click(CustomKeywords.'productos.dynamicPath.object'('first_clave_prod_serv'))

'Abrir select > Tipo'
WebUI.click(CustomKeywords.'productos.dynamicPath.object'('select_tipo'))

'Selecionar > Primer elemento > Tipo'
WebUI.selectOptionByValue(CustomKeywords.'productos.dynamicPath.object'('select_tipo'), CustomKeywords.'productos.data.getAleatotyData'('tipo'), true)

'Espera de 2 segundos'
WebUI.delay(2)

'Insertar en input > Descripcion Espanol'
WebUI.setText(CustomKeywords.'productos.dynamicPath.object'('descripcion'), CustomKeywords.'productos.data.getAleatotyData'('textogenerico'))

'Insertar en input > Descripcion Ingles'
WebUI.setText(CustomKeywords.'productos.dynamicPath.object'('descripcioningles'), CustomKeywords.'productos.data.getAleatotyData'('textogenerico'))

'Insertar en input > Descripcion Adicional'
WebUI.setText(CustomKeywords.'productos.dynamicPath.object'('descripcionadicional'), CustomKeywords.'productos.data.getAleatotyData'('textogenerico'))

'Insertar en input > Descripcion ecommerce'
WebUI.setText(CustomKeywords.'productos.dynamicPath.object'('descripcionecommerce'), CustomKeywords.'productos.data.getAleatotyData'('textogenerico'))

'Insertar en input > Linea'
WebUI.setText(CustomKeywords.'productos.dynamicPath.object'('input_linea'), CustomKeywords.'productos.data.getAleatotyData'('codigo_busqueda'))

'Insertar en input > SubLinea'
WebUI.setText(CustomKeywords.'productos.dynamicPath.object'('input_sublinea'), CustomKeywords.'productos.data.getAleatotyData'('codigo_busqueda'))

'Insertar en input > SubsubLinea'
WebUI.setText(CustomKeywords.'productos.dynamicPath.object'('input_subsublinea'), CustomKeywords.'productos.data.getAleatotyData'('codigo_busqueda'))

'Insertar en input > Marca'
WebUI.setText(CustomKeywords.'productos.dynamicPath.object'('input_marca'), CustomKeywords.'productos.data.getAleatotyData'('codigo_busqueda'))

'Abrir select > Vender_menos_margen_utilidad'
WebUI.click(CustomKeywords.'productos.dynamicPath.object'('select_margen_utilidad'))

'Seleccionar > Primer Elemento > Vender_menos_margen_utilidad'
WebUI.selectOptionByValue(CustomKeywords.'productos.dynamicPath.object'('select_margen_utilidad'), CustomKeywords.'productos.data.getAleatotyData'('margen'), true)

'Abrir select > Tasa IVA'
WebUI.click(CustomKeywords.'productos.dynamicPath.object'('select_tasa_IVA'))

'Seleccionar > Primer Elemento > Tasa IVA'
WebUI.selectOptionByValue(CustomKeywords.'productos.dynamicPath.object'('select_tasa_IVA'), CustomKeywords.'productos.data.getAleatotyData'('iva'), true)

'Abrir select > IEPS'
WebUI.click(CustomKeywords.'productos.dynamicPath.object'('select_ieps'))

'Seleccionar > Primer Elemento > IEPS'
WebUI.selectOptionByValue(CustomKeywords.'productos.dynamicPath.object'('select_ieps'), CustomKeywords.'productos.data.getAleatotyData'('ieps'), true)

'Si se selecciona cuota'
if (CustomKeywords.'productos.data.getAleatotyData'('ieps') == '9999.00') {
	
	'Agregar un valor de cuota aleatoria'
	WebUI.setText(CustomKeywords.'productos.dynamicPath.object'('input_cuota'), CustomKeywords.'productos.data.getAleatotyData'('cuota'))
}

'Abrir select > Tipo IEPS'
WebUI.click(CustomKeywords.'productos.dynamicPath.object'('select_tipo_ieps'))

'Seleccionar > Primer Elemento > Tipo IEPS'
WebUI.selectOptionByValue(CustomKeywords.'productos.dynamicPath.object'('select_tipo_ieps'), CustomKeywords.'productos.data.getAleatotyData'('tipoieps'), true)


'Abrir select > Retencion IVA'
WebUI.click(CustomKeywords.'productos.dynamicPath.object'('select_retencion_iva'))

'Seleccionar > Primer Elemento > Retencion IVA'
WebUI.selectOptionByValue(CustomKeywords.'productos.dynamicPath.object'('select_retencion_iva'), CustomKeywords.'productos.data.getAleatotyData'('retencioniva'), true)

'Insertar en input > Retención ISR'
WebUI.setText(CustomKeywords.'productos.dynamicPath.object'('input_retencion_isr'), CustomKeywords.'productos.data.getAleatotyData'('retencionisr'))

'Espera de 5 segundos'
WebUI.delay(5)

'Cierre del navegador'
WebUI.closeBrowser()
