package productos

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import internal.GlobalVariable

public class dynamicPath {

	@Keyword
	def object(String elemento) {

		String xpath = ''

		if (elemento == 'boton_inventario')
			xpath = "//a[@class='singleclick link-inventario']"

		else if (elemento == 'boton_catalogo')
			xpath = "//a[@class='singleclick link-catalogos submenu']"

		else if (elemento == 'boton_productos')
			xpath = "//a[@class='singleclick link-productos menu_option']"

		else if (elemento == 'boton_agregar_productos')
			xpath = "//a[contains(@href, '/admin/agregar_producto/')]"

		else if (elemento == 'input_codigo')
			xpath = "//input[@id='id_codigo_sin_marca']"

		else if (elemento == 'input_clave_prod_serv')
			xpath = "//input[@id='id_clave_prod_serv']"

		else if (elemento == 'first_clave_prod_serv')
			xpath = "(//ul[@id='ui-id-8']/li/a)[1]"

		else if (elemento == 'select_tipo')
			xpath = "//select[@id='id_tipo']"

		else if (elemento == 'descripcion')
			xpath = '//input[@id="id_descripcion"]'

		else if (elemento == 'descripcioningles')
			xpath = '//input[@id="id_descripcion_ingles"]'

		else if (elemento == 'descripcionadicional')
			xpath = '//textarea[@id="id_texto_descripcion_adicional"]'

		else if (elemento == 'descripcionecommerce')
			xpath = '//textarea[@id="id_descripcion_ecommerce"]'

		else if (elemento == 'input_linea')
			xpath = '//input[@id="id_linea"]'

		else if (elemento == 'input_sublinea')
			xpath = '//input[@id="id_sublinea"]'

		else if (elemento == 'input_subsublinea')
			xpath = '//input[@id="id_subsublinea"]'

		else if (elemento == 'input_marca')
			xpath = '//input[@id="id_marca"]'

		else if (elemento == 'select_margen_utilidad')
			xpath = '//select[@id="id_vender_menos_margen_utilidad"]'

		else if (elemento == 'select_tasa_IVA')
			xpath = '//select[@id="id_exento_de_impuesto"]'

		else if (elemento == 'select_ieps')
			xpath = '//select[@id="id_porcentaje_ieps"]'

		else if (elemento == 'input_cuota')
			xpath = '//input[@id="id_cuota_ieps"]'

		else if (elemento == 'select_tipo_ieps')
			xpath = '//select[@id="id_tipo_ieps"]'

		else if (elemento == 'select_retencion_iva')
			xpath = '//select[@id="id_retencion_iva"]'

		else if (elemento == 'input_retencion_isr')
			xpath = '//input[@id="id_retencion_isr"]'



		TestObject to = new TestObject().addProperty('xpath', ConditionType.EQUALS, xpath)
		return to
	}
}
