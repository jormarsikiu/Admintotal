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

		else if (elemento == 'input_codigo_origen')
			xpath = "//input[@id='id_codigo_origen']"

		else if (elemento == 'input_factor_conversion')
			xpath = "//input[@id='id_factor_conversion']"

		else if (elemento == 'input_tipo_servicio')
			xpath = "//select[@id='id_tipo_servicio']"

		else if (elemento == 'input_cuenta_servicio_personalizado')
			xpath = "//input[@id='id_cuenta_servicio_personalizado']"

		else if (elemento == 'first_cuenta_servicio_personalizado')
			xpath = "(//ul[@id='ui-id-2']/li/a)[1]"

		else if (elemento == 'input_grupo_activo')
			xpath = "//select[@id='id_grupo_activo']"

		else if (elemento == 'input_costo_reposicion')
			xpath = "//input[@id='id_costo']"

		else if (elemento == 'input_consumo_interno')
			xpath = "//input[@id='id_cuenta_consumo_interno']"

		else if (elemento == 'first_consumo_interno')
			xpath = "(//ul[@id='ui-id-9']/li/a)[1]"

		else if (elemento == 'input_clave_material_peligroso')
			xpath = "//input[@id='id_clave_material_peligroso_txt']"

		else if (elemento == 'first_clave_material_peligroso')
			xpath = "(//ul[@id='ui-id-3']/li/a)[1]"
			
		else if (elemento == 'select_clave_embalaje_material_peligroso')
			xpath = "//select[@id='id_clave_embalaje_material_peligroso']"
			
		else if (elemento == 'input_comentarios')
			xpath = "//textarea[@id='id_comentarios']"
			
		else if (elemento == 'input_MU')
			xpath = "//input[@id='id_pls_margen_utilidad_porciento']"
			
		else if (elemento == 'input_precio')
			xpath = "//input[@id='id_pls_precio']"
			
		else if (elemento == 'select_moneda')
			xpath = "//select[@id='id_pls_moneda']"
			
		else if (elemento == 'select_moneda')
			xpath = "//select[@id='id_pls_moneda']"
			
		else if (elemento == 'input_unidad_medida')
			xpath = "//input[@id='id_um-0-um']"
			
		else if (elemento == 'first_unidad_medida')
			xpath = "(//ul[@id='ui-id-12']/li/a)[1]"
			
		else if (elemento == 'input_factor')
			xpath = "//input[@id='id_um-0-factor']"
			
		else if (elemento == 'input_codigo_barra')
			xpath = "//input[@id='id_um-0-codigo_barras']"
			
		else if (elemento == 'input_base')
			xpath = "//input[@id='id_um-0-base']"
				
		else if (elemento == 'input_altura')
			xpath = "//input[@id='id_um-0-altura']"
					
		else if (elemento == 'input_profundidad')
			xpath = "//input[@id='id_um-0-profundidad']"
						
		else if (elemento == 'input_peso')
			xpath = "//input[@id='id_um-0-peso']"
			
		else if (elemento == 'check_selec_compra')
			xpath = "//input[@id='id_um-0-seleccionado_compra']"
				
		else if (elemento == 'check_selec_venta')
			xpath = "//input[@id='id_um-0-seleccionado']"
					
		else if (elemento == 'check_kardex')
			xpath = "//input[@id='id_um-0-um_kardex']"
			
		else if (elemento == 'boton_lista_precios_proveedores')
			xpath = "//a[contains(@href, '#listaPreciosProvTabContent')]"
			
			
			
			
			
			
			
			
			
			
		TestObject to = new TestObject().addProperty('xpath', ConditionType.EQUALS, xpath)
		return to
	}
}
