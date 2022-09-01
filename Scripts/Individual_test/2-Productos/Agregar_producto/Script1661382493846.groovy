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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.exception.StepFailedException as StepFailedException
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils

String openBrowser = CustomKeywords.'keyword_navegador.validateNavegador.browser'()

String closeBrowser = ''

'Si el navegador esta abierto'
if (openBrowser == '1') {
    'Que el navegador no se cierre para que continue el flujo'
    closeBrowser = '0'
} else {
    'Si el navegador no esta abierto, se abrio para prueba individual y se cerrara al final del test'
    closeBrowser = '1'
}

println(closeBrowser)

'Click en boton > Menu-Inventario'
WebUI.click(CustomKeywords.'keyword_sharedElements.menu_xpath_dynamic.getObject'('boton_inventario'))

'Click en boton > Menu - Catalogos'
WebUI.click(CustomKeywords.'keyword_sharedElements.menu_xpath_dynamic.getObject'('boton_catalogo'))

'Click en boton > Menu-Productos'
WebUI.click(CustomKeywords.'keyword_sharedElements.menu_xpath_dynamic.getObject'('boton_productos'))

'Click en boton -> Agregar Productos'
WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('boton_agregar_productos'))

'Tipo de venta aleatorio > Tienda, Web, Ambos'
List randomObjects = Arrays.asList('1', '2', '3')
String randomPath = randomObjects.get(new Random().nextInt(randomObjects.size()))

'Tienda'
if (randomPath == '1') {
    WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('radio_tienda'))
}

'Web'
if (randomPath == '2') {
    WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('radio_web'))
}

'Ambos'
if (randomPath == '3') {
    WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('radio_ambos'))
}

'Insertar en input > Imagen URL'
WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_imagenURL'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
        'imagenURL'))

'Ruta del archivo'
def fileDir = RunConfiguration.getProjectDir() + '/Data Files/logo_azul_blanco.png'

'Sustituir barras dependiendo del navegador'
fileDir = fileDir.replace('/', '\\')

'Insertar en input > Imagen URL'
WebUI.uploadFile(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_imagenUpload'), fileDir)

'Scroll'
WebUI.scrollToElement(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('check_restringir_descuento'), 1)

'Check laterales - check_restringir_descuento'
WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('check_restringir_descuento'))

'Check laterales - quitar check_restringir_decimales'
WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('check_restringir_decimales'))

'Check laterales - check_restringir_decimales'
WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('check_restringir_decimales'))

'Check laterales - check_habilitar_webhook'
WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('check_habilitar_webhook'))

'Check laterales - check_integracion_rappi'
WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('check_integracion_rappi'))

'Check laterales - check_pedidos_especiales'
WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('check_pedidos_especiales'))

'Check laterales - check_venta_cd_cod_barras'
WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('check_venta_cd_cod_barras'))

'Check laterales - check_habilitar_bascula'
WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('check_habilitar_bascula'))

'Check laterales - check_congelar_precios_venta'
WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('check_congelar_precios_venta'))

'Check laterales - check_no_generar_comision'
WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('check_no_generar_comision'))

'Check laterales - check_usa_doble_unidad'
WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('check_usa_doble_unidad'))

'Scroll Cabecera'
WebUI.scrollToElement(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('guardar_form'), 1)

'Insertar en input > Codigo'
WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_codigo'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
        'codigo'))

'Insertar en input > Clave prod serv'
WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_clave_prod_serv'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
        'clave_prod_serv'))

'Espera de 2 segundos'
WebUI.delay(2)
	
'Buscar elementos en el select'
String claveprod = WebUI.getAttribute(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('validar_clave_prod_serv'), 'style')
println(claveprod)

'Si hay valores seleccionar uno aleatorio'
if (claveprod.contains('block')) {

	String validarclave = CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('opcion_clave_prod_serv', '1')
	
}
else {
		
	WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_clave_prod_serv'), '')
		
	WebUI.comment("El select no tiene elementos")
	
}


'Abrir select > Tipo'
WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('select_tipo'))

'Selecionar opcion > Tipo'
//CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('options_tipo', '1')

WebUI.selectOptionByValue(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('select_tipo'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
        'tipo_producto'), false)

'Guardar valor del Tipo producto'
String tipo_producto = WebUI.getAttribute(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('select_tipo'), 'value')
println(tipo_producto)

'Crear el tipo de producto como variable global'
CustomKeywords.'keyword_variableGlobal.generateVariable.addGlobalVariable'('tipoproducto', tipo_producto)

println(GlobalVariable.tipoproducto)

'Espera de 2 segundos'
WebUI.delay(2)

'Guardar valor del Texto Generico'
String Texto_generico = CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'('textogenerico')

'Insertar en input > Descripcion Espanol'
WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('descripcion'), Texto_generico)

'Insertar en input > Descripcion Ingles'
WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('descripcioningles'), Texto_generico)

'Insertar en input > Descripcion Adicional'
WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('descripcionadicional'), Texto_generico)

'Scroll'
WebUI.scrollToElement(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('descripcionadicional'), 1)

'Insertar en input > Descripcion ecommerce'
WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('descripcionecommerce'), Texto_generico)

'Scroll'
WebUI.scrollToElement(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('descripcionecommerce'), 1)

'Buscar en linea'
WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_linea'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
        'letra'))

'Espera de 2 segundos'
WebUI.delay(2)

'Validar si existen valores en > Linea'
String textl = WebUI.getText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('validate_linea'))

print(textl)

'Sino hay valores dejar vacio y de lo contrario hay valores darle click al primero'
if (textl == 'No search results.') {
    'No hay valores dejar vacio'
    WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_linea'), '')

    WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_sublinea'), '')

    WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_subsublinea'), '')
} else {
    'Si hay valores darle click al primero'
    WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_firstlinea'))

    WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_sublinea'))

    WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_lastsublinea'))

    WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_subsublinea'))

    WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_firstsubsublinea'))
}

'Scroll'
WebUI.scrollToElement(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_marca'), 1)

'Buscar en input > Marca'
WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_marca'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
        'letra'))

'Espera de 2 segundos'
WebUI.delay(2)

'Validar si existen valores en > Marca'
String textmarca = WebUI.getText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('validate_marca'))

print(textmarca)

'Sino hay valores dejar vacio y de lo contrario hay valores darle click al primero'
if (textmarca == 'No search results.') {
    'Si no hay valores escribir uno'
    WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_marca'), '')
} else {
    'Si hay valores darle click al primero'
    WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_firstmarca'))
}

'Esperar 1 segundos'
WebUI.delay(1)

'Abrir select > Vender_menos_margen_utilidad'
WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('select_margen_utilidad'))

'Seleccionar opcion > Vender_menos_margen_utilidad'
CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('options_margen_utilidad', '1')

'Scroll'
WebUI.scrollToElement(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_marca'), 1)

'Abrir select > Tasa IVA'
WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('select_tasa_IVA'))

'Seleccionar opcion > Tasa IVA'
CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('options_tasa_IVA', '1')

'Abrir select > IEPS'
WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('select_ieps'))

'Seleccionar opcion> IEPS'
CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('options_ieps', '1')

'Valor del IEPS'
String ieps = WebUI.getAttribute(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('select_ieps'), 'value')
println(ieps)

'Si selecciona un IEPS diferente a vacio'
if ((ieps != '9999.00')) {
	'Abrir select > Tipo IEPS'
	WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('select_tipo_ieps'))
	
	'Seleccionar > Tipo IEPS'
	CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('options_tipo_ieps', '1')

} else if  (ieps == '9999.00') {
    'Agregar un valor de cuota aleatoria'
    WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_cuota'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
            'cuota'))
	
	'Abrir select > Tipo IEPS'
	WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('select_tipo_ieps'))
	
	'Seleccionar > Tipo IEPS'
	CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('options_tipo_ieps', '1')
	
} else if (ieps == '') {}

'Seleccionar Check > No generar IEPS en la venta de este producto'
WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('check_no_generar_ieps'))

'Abrir select > Retencion IVA'
WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('select_retencion_iva'))

'Seleccionar opcion > Retencion IVA'
CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('options_retencion_iva', '1')

'Insertar en input > Retención ISR'
WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_retencion_isr'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
        'retencionisr'))

print(tipo_producto)

'Opciones de Articulo, Materia Prima, Embalaje y Embalaje Dinamico'
if (((((tipo_producto == '0') || (tipo_producto == '1')) || (tipo_producto == '2')) || (tipo_producto == '7')) || (tipo_producto == 
'8')) {
    'Insertar en input > Factor_conversion'
    WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_factor_conversion'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
            'factor_conversion'))
}

'Opciones de servicios'
if (tipo_producto == '3') {
    'Click al tipo de servicio'
    WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_tipo_servicio'))

    'Select el tipo de servicio'
	CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('option_tipo_servicio', '1')
	
	'Valor del tipo de servicio'
	String tiposervicio = WebUI.getAttribute(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_tipo_servicio'), 'value')

    if (tiposervicio == '99') {
        'Insertar en input > Cuenta servicio personalizado'
        WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_cuenta_servicio_personalizado'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
                'clave_prod_serv'))

        'Valida si existen valores en el select'
        if (WebUI.verifyElementPresent(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('first_cuenta_servicio_personalizado'), 
            1)) {
            'Si hay valores darle click al primero'
            WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('first_cuenta_servicio_personalizado'))
        }
    }
}

'Opciones Servicios subcontratados'
if (tipo_producto == '5') {
    
	'Click al tipo de servicio'
    WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_tipo_servicio'))

    'Select el tipo de servicio'
	CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('option_tipo_servicio', '1')
	
	'Valor del tipo de servicio'
	String tiposervicio = WebUI.getAttribute(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_tipo_servicio'), 'value')

    if (tiposervicio == '99') {
        'Insertar en input > Cuenta servicio personalizado'
        WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_cuenta_servicio_personalizado'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
                'clave_prod_serv'))

        'Valida si existen valores en el select'
        if (WebUI.verifyElementPresent(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('first_cuenta_servicio_personalizado'), 
            1)) {
            'Si hay valores darle click al primero'
            WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('first_cuenta_servicio_personalizado'))
        }
    }
    
    'Insertar en input > Factor de conversión'
    WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_factor_conversion'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
            'factor_conversion'))
}

'Opciones Activo Fijo'
if (tipo_producto == '4') {
    'Click en Grupo activo'
    WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_grupo_activo'))
	
    'Insertar en input > Grupo activo'
	CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('options_grupo_activo', '1')
}

'Opciones Mano de obra'
if (tipo_producto == '9') {
    'Insertar en input > Cuenta contable'
    WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_cuenta_servicio_personalizado'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
            'clave_prod_serv'))

    'Valida si existen valores en el select'
    if (WebUI.verifyElementPresent(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('first_cuenta_servicio_personalizado'), 
        1)) {
        'Si hay valores darle click al primero'
        WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('first_cuenta_servicio_personalizado'))
    }
}

'Insertar en input > Número de predial'
WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_codigo_origen'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
        'codigo_origen'))

'Insertar en input > Costo de Reposicion'
WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_costo_reposicion'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
        'costo_reposicion'))

'Seleccionar > Nivel comisión'
WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('select_nivel_comision'))

'Seleccionar opcion > Nivel comisión'
CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('opcion_nivel_comision', '1')

'Scroll'
WebUI.scrollToElement(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_costo_reposicion'), 1)

'Insertar en input > Cuenta para consumo interno'
WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_consumo_interno'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
        'clave_prod_serv'))

'Espera de 2 segundos'
WebUI.delay(2)

'Buscar elementos en el select'
String claveconsumo = WebUI.getAttribute(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('validar_consumo'), 'style')
println(claveprod)

'Si hay valores seleccionar uno aleatorio'
if (claveconsumo.contains('block')) {

	CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('options_consumo_interno', '1')
}
else {
		
	WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_consumo_interno'), '')
		
	WebUI.comment("El select no tiene elementos")
	
}

'Scroll'
WebUI.scrollToElement(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_costo_reposicion'), 1)

'Insertar en input > Clave material peligroso'
WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_clave_material_peligroso'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
        'clave_prod_serv'))

'Espera de 2 segundos'
WebUI.delay(2)

'Buscar elementos en el select'
String clavepeligroso = WebUI.getAttribute(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('validar_peligroso'), 'style')
println(clavepeligroso)

'Si hay valores seleccionar uno aleatorio'
if (clavepeligroso.contains('block')) {

	CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('options_clave_material_peligroso', '1')
}
else {
		
	WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_clave_material_peligroso'), '')
		
	WebUI.comment("El select no tiene elementos")
	
}

'Esperar 2 segundos'
WebUI.delay(2)

'Seleccionar > Clave material peligroso'
WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('select_clave_embalaje_material_peligroso'))

'Esperar 2 segundos'
WebUI.delay(2)

'Seleccionar opcion > Clave material peligroso'
CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('options_clave_embalaje_material_peligroso', '1')

'Esperar 2 segundos'
WebUI.delay(2)

'Insertar en input > Comentarios'
WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_comentarios'), Texto_generico)

'Scroll'
WebUI.scrollToElement(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_comentarios'), 1)

'Insertar en input > M.U.'
WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_MU'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
        'margen_utilidad_porciento'))

'Insertar en input > Precio'
WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_precio'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
        'precio'))

'Abrir select > Moneda'
WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('select_moneda'))

'Select opcion > Moneda'
CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('options_moneda', '1')

'Scroll'
WebUI.scrollToElement(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_unidad_medida'), 1)

'Insertar en input > Unidad de medida'
WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_unidad_medida'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
        'letra'))

WebUI.delay(2)

'Valida si existen valores en el select'
String textm = WebUI.getText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('validate_unidad_medida'))

print(textm)

if (textm == 'No search results.') {
    'Si no hay valores escribir uno'
    WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_unidad_medida'), 'Pieza' + CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
            'clave_prod_serv'))
} else {
    'Si hay valores darle click al primero'
	CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('opcion_unidad_medida', '1')
   
}

'Insertar en input > Factor'
WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_factor'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
        'factor'))

'Insertar en input > Codigo barra'
WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_codigo_barra'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
        'codigo_barra'))

'Insertar en input > Base'
WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_base'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
        'medidas'))

'Insertar en input > Altura'
WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_altura'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
        'medidas'))

'Insertar en input > Profundidad'
WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_profundidad'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
        'medidas'))

'Insertar en input > Peso'
WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_peso'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
        'medidas'))

WebUI.delay(2)

'Seleccionar Check > Selec. compra'
WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('check_selec_compra'))

'Seleccionar Check > Selec. venta'
WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('check_selec_venta'))

'Seleccionar Check > Kardex'
WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('check_kardex'))

'Opciones de Articulo, Materia Prima, Activo Fijo, Servicios subcontratados, Mano de obra, Artículo para arrendamiento'
if ((((((tipo_producto == '0') || (tipo_producto == '1')) || (tipo_producto == '4')) || (tipo_producto == '5')) || (tipo_producto == 
'9')) || (tipo_producto == '10')) {
    'Click en boton > Lista precios proveedores'
    WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('boton_lista_precios_proveedores'))

    'Insertar en input > Lista_precios > Cod_proveedor'
    WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_lista_precios_cod_proveedor'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
            'codigo'))

    'Insertar en input > Lista_precios > Proveedor'
    WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_lista_precios_proveedor'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
            'letra'))

    'Valida si existen valores en el select'
    String textp = WebUI.getText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('validate_proveedor'))

    WebUI.delay(2)

    if (textp == 'No search results.') {
        'Si no hay valores escribir uno'
        WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_lista_precios_proveedor'), 'Proveedor' + CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
                'clave_prod_serv'))
    } else {
		'Si hay valores darle a una opcion'
		CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('opcion_lista_precios_proveedor', '1')
		
    }
    
    'Esperar 2 segundos'
    WebUI.delay(2)

    'Crear tipo de dato fecha'
    Date todaysDate = new Date()

    'Insertar en input > Lista_precios > Fecha'
    WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_lista_precios_fecha'), todaysDate.format('dd/MM/yy'))

    'Insertar en input > Lista_precios > Lista_proveedor'
    WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_lista_precios_lista_proveedor'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
            'medidas'))

    'Insertar en input > Lista_precios > INC'
    WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_lista_precios_inc'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
            'medidas'))

    'Insertar en input > Lista_precios > T.Moneda'
    WebUI.selectOptionByIndex(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_lista_precios_moneda'), 1)

    'Insertar en input > Lista_precios > Multiplo_compra'
    WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_lista_precios_multiplo_compra'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
            'medidas'))

    'Seleccionar Check > Lista_precios > Select'
    WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('check_lista_precios_select'))
}

'Opciones de Ensamble, Ensamble dinámico, Producción'
if (((tipo_producto == '2') || (tipo_producto == '8')) || (tipo_producto == '7')) {
    'Seleccionar Tab > Ensamble'
    WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('tab_ensamble'))

    'Insertar en input > Ensamble > Producto'
    WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_ensamble_producto'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
            'letra'))

    'Espera de 2 segundos'
    WebUI.delay(2)

    'Valida si existen valores en el select'
    String texte = WebUI.getText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('validate_ensamble_producto'))

    if (texte == 'No search results.') {
        'Si no hay valores no escribir uno'
        WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_ensamble_producto'), '')
    } else {
		'Si hay valores darle a una opcion'
		CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('option_ensamble_producto', '1')
		
    }
    
    'Insertar en input > Ensamble > Cantidad'
    WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_ensamble_cantidad'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
            'medidas'))

    'Seleccionar Tab > Ensamble > Unidad'
    WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_ensamble_unidad'))

    'Espera de 2 segundos'
    WebUI.delay(2)

    'Valida si existen valores en el select'
    String texteu = WebUI.getText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('validate_ensamble_unidad'))

    if (texteu == 'No search results.') {
        'Si no hay valores escribir uno'
        WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_ensamble_unidad'), 'Caja' + CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
                'codigo'))
    } else {
		'Si hay valores darle a una opcion'
		CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('opcion_ensamble_unidad', '1')
		
    }
}

'Seleccionar Tab > Relacionados'
WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('tab_relacionados'))
/*
'Insertar en input > Relacionados > Conceptos relacionados'
WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_conceptos_relacionados'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
        'relacionados'))
*/

/*
'Insertar en input > Relacionados > Productos complementarios'
WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_productos_complementarios'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
        'letra'))

'Espera de 2 segundos'
WebUI.delay(2)

'Valida si existen valores en el select'
String textpc = WebUI.getText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('validate_productos_complementarios'))

if (textpc == 'No search results.') {
    'Si no hay valores escribir uno'
    WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_productos_complementarios'), '')
} else {
    'Si hay valores darle a una opcion'
	CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('option_productos_complementarios', '1')
}

'Opciones de Articulo, Materia Prima, Embalaje Dinamico, Servicios Subcontratados, Mano de Obra, Activo fijo'
if ((((tipo_producto == '0') || (tipo_producto == '1')) || (tipo_producto == '8')) || (tipo_producto == '5')) {
    'Insertar en input > Relacionados > Alternativos'
    WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_alternativos'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
            'letra'))

    'Espera de 2 segundos'
    WebUI.delay(2)

    'Valida si existen valores en el select'
    String texttag = WebUI.getText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('validate_alternativos'))

    if (texttag == 'No search results.') {
        'Si no hay valores escribir uno'
        WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_alternativos'), '')
    } else {
        'Si hay valores darle a una opcion'
		CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('option_alternativos', '1')
    }
}
*/
'Seleccionar Tab > Tags'
WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('tab_tags'))
/*
'Insertar en input > Tag'
WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_tag'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
        'codigo_busqueda'))

'Espera de 2 segundos'
WebUI.delay(2)

'Valida si existen valores en el select'
String texttag = WebUI.getText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('validate_tag'))

if (texttag == 'No search results.') {
    'Si no hay valores escribir uno'
    WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_tag'), '')
} else {
    'Si hay valores darle a una opcion'
	CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('option_tag', '1')
	
}
*/
'Seleccionar Tab > Consumibles'
WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('tab_consumibles'))
/*
'Insertar en input > Consumibles'
WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_consumibles'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
        'letra'))

'Espera de 2 segundos'
WebUI.delay(2)

'Valida si existen valores en el select'
String textcon = WebUI.getText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('validate_consumibles'))

if (textcon == 'No search results.') {
    'Si no hay valores escribir uno'
    WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_consumibles'), '')
} else {
    'Si hay valores darle a una opcion'
	CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('options_consumibles', '1')
	
}
*/
'Seleccionar Tab > Refacciones'
WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('tab_refacciones'))
/*
'Insertar en input > Refacciones'
WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_refacciones'), CustomKeywords.'keyword_productos.data_aleatory.getAleatotyData'(
        'letra'))

'Espera de 2 segundos'
WebUI.delay(2)

'Valida si existen valores en el select'
String textrefa = WebUI.getText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('validate_input_refacciones'))

if (textrefa == 'No search results.') {
    'Si no hay valores escribir uno'
    WebUI.setText(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('input_refacciones'), '')
} else {
    'Si hay valores darle a una opcion'
	CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('options_input_refacciones', '1')
    
}*/
'Creamos la variable global con el Keyword para buscar el producto'
CustomKeywords.'keyword_variableGlobal.generateVariable.addGlobalVariable'('descripcionproducto', Texto_generico)

'Scroll'
WebUI.scrollToElement(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('guardar_form'), 1)

'Guardar formulario'
WebUI.click(CustomKeywords.'keyword_productos.xpath_dynamic.getObject'('guardar_form'))

'Espera de 5 segundos'
WebUI.delay(5)

'Obtener la URl'
currentUrl = WebUI.getUrl()

'Generar la URl completa'
String Url_new = GlobalVariable.Web + '/admin/inventario/catalogos/productos/'

'Validar la URL correcta'
if (currentUrl != Url_new) {
    'Mostrar error si no esta en la URL'
    throw new StepFailedException('Bad URL')
}

println(closeBrowser)

'Validar para cerrar el navegador'
if (closeBrowser == '1') {
	
    'Cerrar navegador'
    WebUI.closeBrowser()
	
} else if (closeBrowser == '0') {
	
    'Espera de 1 segundos'
    WebUI.delay(1)

    
}

