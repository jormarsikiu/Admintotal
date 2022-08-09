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

'Valor del Tipo producto'
String tipo_producto = CustomKeywords.'productos.data.getAleatotyData'('tipo')

'Abrir select > Tipo'
WebUI.click(CustomKeywords.'productos.dynamicPath.object'('select_tipo'))

'Selecionar > Primer elemento > Tipo'
WebUI.selectOptionByValue(CustomKeywords.'productos.dynamicPath.object'('select_tipo'), tipo_producto, true)

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

'Valor del IEPS'
String ieps = CustomKeywords.'productos.data.getAleatotyData'('ieps')

'Seleccionar > Primer Elemento > IEPS'
WebUI.selectOptionByValue(CustomKeywords.'productos.dynamicPath.object'('select_ieps'), ieps , true)

'Si se selecciona cuota'
if (ieps == '9999.00') {
	
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

print(tipo_producto)

'Opciones de Articulo, Materia Prima, Embalaje y Embalaje Dinamico'
if (tipo_producto =='0' || tipo_producto =='1' || tipo_producto =='2' || tipo_producto =='7' || tipo_producto =='8')
	{
		'Insertar en input > Factor_conversion'
		WebUI.setText(CustomKeywords.'productos.dynamicPath.object'('input_factor_conversion'), CustomKeywords.'productos.data.getAleatotyData'('factor_conversion'))
	}
'Opciones de servicios'
if (tipo_producto =='3')
	{
		'Click al tipo de servicio'
		WebUI.click(CustomKeywords.'productos.dynamicPath.object'('input_tipo_servicio'))
		
		'Valor del tipo de servicio'
		String tiposervicio = CustomKeywords.'productos.data.getAleatotyData'('tipo_servicio')
		
		'Select el tipo de servicio'
		WebUI.selectOptionByValue(CustomKeywords.'productos.dynamicPath.object'('input_tipo_servicio'), tiposervicio , true)
		
		if (tiposervicio == '99') 
			{
				'Insertar en input > Cuenta servicio personalizado'
				WebUI.setText(CustomKeywords.'productos.dynamicPath.object'('input_cuenta_servicio_personalizado'), CustomKeywords.'productos.data.getAleatotyData'('codigo_busqueda'))
			
				'Seleccionar > Primer Elemento > Cuenta servicio personalizado'
				WebUI.click(CustomKeywords.'productos.dynamicPath.object'('first_cuenta_servicio_personalizado'))
			}
	}
'Opciones Servicios subcontratados'
if (tipo_producto =='5')
	{
		'Click al tipo de servicio'
		WebUI.click(CustomKeywords.'productos.dynamicPath.object'('input_tipo_servicio'))
		
		'Valor del tipo de servicio'
		String tiposervicio = CustomKeywords.'productos.data.getAleatotyData'('tipo_servicio')
		
		'Select el tipo de servicio'
		WebUI.selectOptionByValue(CustomKeywords.'productos.dynamicPath.object'('input_tipo_servicio'), tiposervicio , true)
		
		if (tiposervicio == '99')
			{
				'Insertar en input > Cuenta servicio personalizado'
				WebUI.setText(CustomKeywords.'productos.dynamicPath.object'('input_cuenta_servicio_personalizado'), CustomKeywords.'productos.data.getAleatotyData'('codigo_busqueda'))
			
				'Seleccionar > Primer Elemento > Cuenta servicio personalizado'
				WebUI.click(CustomKeywords.'productos.dynamicPath.object'('first_cuenta_servicio_personalizado'))
			}
		'Insertar en input > Factor de conversión'
		WebUI.setText(CustomKeywords.'productos.dynamicPath.object'('input_factor_conversion'), CustomKeywords.'productos.data.getAleatotyData'('factor_conversion'))
	}
'Opciones Activo Fijo'
if (tipo_producto =='4')
	{
		'Click en Grupo activo'
		WebUI.click(CustomKeywords.'productos.dynamicPath.object'('input_grupo_activo'))
		
		'Insertar en input > Grupo activo'
		WebUI.selectOptionByValue(CustomKeywords.'productos.dynamicPath.object'('input_grupo_activo'), CustomKeywords.'productos.data.getAleatotyData'('grupo_activo'), true)
	}
'Opciones Mano de obra'
if (tipo_producto =='9')
	{		
		'Insertar en input > Cuenta contable'
		WebUI.setText(CustomKeywords.'productos.dynamicPath.object'('input_cuenta_servicio_personalizado'), CustomKeywords.'productos.data.getAleatotyData'('codigo_busqueda'))
			
		'Seleccionar > Primer Elemento > Cuenta contable'
		WebUI.click(CustomKeywords.'productos.dynamicPath.object'('first_cuenta_servicio_personalizado'))
	}
	
'Insertar en input > Número de predial'
WebUI.setText(CustomKeywords.'productos.dynamicPath.object'('input_codigo_origen'), CustomKeywords.'productos.data.getAleatotyData'('codigo_origen'))

'Insertar en input > Costo de Reposicion'
WebUI.setText(CustomKeywords.'productos.dynamicPath.object'('input_costo_reposicion'), CustomKeywords.'productos.data.getAleatotyData'('costo_reposicion'))

'Insertar en input > Cuenta para consumo interno'
WebUI.setText(CustomKeywords.'productos.dynamicPath.object'('input_consumo_interno'), CustomKeywords.'productos.data.getAleatotyData'('codigo_busqueda'))

'Seleccionar > Primer Elemento > Cuenta para consumo interno'
WebUI.click(CustomKeywords.'productos.dynamicPath.object'('first_consumo_interno'))

'Insertar en input > Clave material peligroso'
WebUI.setText(CustomKeywords.'productos.dynamicPath.object'('input_clave_material_peligroso'), CustomKeywords.'productos.data.getAleatotyData'('codigo_busqueda'))

'Seleccionar > Primer Elemento > Clave material peligroso'
WebUI.click(CustomKeywords.'productos.dynamicPath.object'('first_clave_material_peligroso'))

'Seleccionar > Clave material peligroso'
WebUI.click(CustomKeywords.'productos.dynamicPath.object'('select_clave_embalaje_material_peligroso'))

'Seleccionar > Primer Elemento > Clave material peligroso'
WebUI.selectOptionByIndex(CustomKeywords.'productos.dynamicPath.object'('select_clave_embalaje_material_peligroso'), 1)

WebUI.delay(2)

'Insertar en input > Comentarios'
WebUI.setText(CustomKeywords.'productos.dynamicPath.object'('input_comentarios'), CustomKeywords.'productos.data.getAleatotyData'('textogenerico'))

'Insertar en input > M.U.'
WebUI.setText(CustomKeywords.'productos.dynamicPath.object'('input_MU'), CustomKeywords.'productos.data.getAleatotyData'('margen_utilidad_porciento'))

'Insertar en input > Precio'
WebUI.setText(CustomKeywords.'productos.dynamicPath.object'('input_precio'), CustomKeywords.'productos.data.getAleatotyData'('precio'))

'Seleccionar > Primer Elemento > T.Moneda'
WebUI.selectOptionByIndex(CustomKeywords.'productos.dynamicPath.object'('select_moneda'), 1)

'Insertar en input > Unidad de medida'
WebUI.setText(CustomKeywords.'productos.dynamicPath.object'('input_unidad_medida'), 'a')

'Seleccionar > Primer Elemento > Unidad de medida'
WebUI.click(CustomKeywords.'productos.dynamicPath.object'('first_unidad_medida'))

'Insertar en input > Factor'
WebUI.setText(CustomKeywords.'productos.dynamicPath.object'('input_factor'), CustomKeywords.'productos.data.getAleatotyData'('factor'))

'Insertar en input > Codigo barra'
WebUI.setText(CustomKeywords.'productos.dynamicPath.object'('input_codigo_barra'), CustomKeywords.'productos.data.getAleatotyData'('codigo_barra'))

'Insertar en input > Base'
WebUI.setText(CustomKeywords.'productos.dynamicPath.object'('input_base'), CustomKeywords.'productos.data.getAleatotyData'('medidas'))

'Insertar en input > Altura'
WebUI.setText(CustomKeywords.'productos.dynamicPath.object'('input_altura'), CustomKeywords.'productos.data.getAleatotyData'('medidas'))

'Insertar en input > Profundidad'
WebUI.setText(CustomKeywords.'productos.dynamicPath.object'('input_profundidad'), CustomKeywords.'productos.data.getAleatotyData'('medidas'))

'Insertar en input > Peso'
WebUI.setText(CustomKeywords.'productos.dynamicPath.object'('input_peso'), CustomKeywords.'productos.data.getAleatotyData'('medidas'))

'Seleccionar Check > Selec. compra'
WebUI.click(CustomKeywords.'productos.dynamicPath.object'('check_selec_compra'))

'Seleccionar Check > Selec. venta'
WebUI.click(CustomKeywords.'productos.dynamicPath.object'('check_selec_venta'))

'Seleccionar Check > Kardex'
WebUI.click(CustomKeywords.'productos.dynamicPath.object'('check_kardex'))

'Click en boton > Lista precios proveedores'
WebUI.click(CustomKeywords.'productos.dynamicPath.object'('boton_lista_precios_proveedores'))

'Espera de 5 segundos'
WebUI.delay(5)

'Cierre del navegador'
WebUI.closeBrowser()
