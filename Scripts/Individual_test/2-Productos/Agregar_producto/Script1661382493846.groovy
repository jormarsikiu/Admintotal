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
WebUI.click(findTestObject('Object Repository/menu_objects/button_inventario'))

'Click en boton > Menu - Catalogos'
WebUI.click(findTestObject('Object Repository/menu_objects/button_catalogo'))

'Click en boton > Menu-Productos'
WebUI.click(findTestObject('Object Repository/menu_objects/button_productos'))

'Click en boton -> Agregar Productos'
WebUI.click(findTestObject('Object Repository/productos_objects/buttons/button_agregar_productos'))

'Tipo de venta aleatorio > Tienda, Web, Ambos'
List randomObjects = Arrays.asList('1', '2', '3')
String randomPath = randomObjects.get(new Random().nextInt(randomObjects.size()))

'Tienda'
if (randomPath == '1') {
    WebUI.click(findTestObject('Object Repository/productos_objects/checks/check_radio_tienda'))
}

'Web'
if (randomPath == '2') {
    WebUI.click(findTestObject('Object Repository/productos_objects/checks/check_radio_web'))
}

'Ambos'
if (randomPath == '3') {
    WebUI.click(findTestObject('Object Repository/productos_objects/checks/check_radio_ambos'))
}

'Insertar en input > Imagen URL'
WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_imagenURL'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
        'imagenURL'))

'Ruta del archivo'
def fileDir = RunConfiguration.getProjectDir() + '/Data Files/logo_azul_blanco.png'

'Sustituir barras dependiendo del navegador'
fileDir = fileDir.replace('/', '\\')

'Insertar en input > Imagen URL'
WebUI.uploadFile(findTestObject('Object Repository/productos_objects/inputs/input_imagenUpload'), fileDir)

'Scroll'
WebUI.scrollToElement(findTestObject('Object Repository/productos_objects/checks/check_restringir_descuento'), 1)

'Check laterales - check_restringir_descuento'
WebUI.click(findTestObject('Object Repository/productos_objects/checks/check_restringir_descuento'))

'Check laterales - quitar check_restringir_decimales'
WebUI.click(findTestObject('Object Repository/productos_objects/checks/check_restringir_decimales'))

'Check laterales - check_restringir_decimales'
WebUI.click(findTestObject('Object Repository/productos_objects/checks/check_restringir_decimales'))

'Check laterales - check_habilitar_webhook'
WebUI.click(findTestObject('Object Repository/productos_objects/checks/check_habilitar_webhook'))

'Check laterales - check_integracion_rappi'
WebUI.click(findTestObject('Object Repository/productos_objects/checks/check_integracion_rappi'))

'Check laterales - check_pedidos_especiales'
WebUI.click(findTestObject('Object Repository/productos_objects/checks/check_pedidos_especiales'))

'Check laterales - check_venta_cd_cod_barras'
WebUI.click(findTestObject('Object Repository/productos_objects/checks/check_venta_cd_cod_barras'))

'Check laterales - check_habilitar_bascula'
WebUI.click(findTestObject('Object Repository/productos_objects/checks/check_habilitar_bascula'))

'Check laterales - check_congelar_precios_venta'
WebUI.click(findTestObject('Object Repository/productos_objects/checks/check_congelar_precios_venta'))

'Check laterales - check_no_generar_comision'
WebUI.click(findTestObject('Object Repository/productos_objects/checks/check_no_generar_comision'))

'Check laterales - check_usa_doble_unidad'
WebUI.click(findTestObject('Object Repository/productos_objects/checks/check_usa_doble_unidad'))

'Scroll Cabecera'
WebUI.scrollToElement(findTestObject('Object Repository/productos_objects/buttons/button_guardar_form'), 1)

'Insertar en input > Codigo'
WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_codigo'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
        'codigo'))

'Insertar en input > Clave prod serv'
WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_clave_prod_serv'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
        'clave_prod_serv'))

'Espera de 2 segundos'
WebUI.delay(2)
	
'Buscar elementos en el select'
String claveprod = WebUI.getAttribute(findTestObject('Object Repository/productos_objects/validate/validate_clave_prod_serv'), 'style')
println(claveprod)

'Si hay valores seleccionar uno aleatorio'
if (claveprod.contains('block')) {

	TestObject opcion_clave = findTestObject('Object Repository/productos_objects/selects/opcion_clave_prod_serv')
	
	String validarclave = CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'(opcion_clave)
	
}
else {
		
	WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_clave_prod_serv'), '')
		
	WebUI.comment("El select no tiene elementos")
	
}

'Abrir select > Tipo'
WebUI.click(findTestObject('Object Repository/productos_objects/selects/select_tipo'))

'Selecionar opcion > Tipo'
//CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('options_tipo', '1')

WebUI.selectOptionByValue(findTestObject('Object Repository/productos_objects/selects/select_tipo'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
        'tipo_producto'), false)

'Guardar valor del Tipo producto'
String tipo_producto = WebUI.getAttribute(findTestObject('Object Repository/productos_objects/selects/select_tipo'), 'value')
println(tipo_producto)

'Crear el tipo de producto como variable global'
CustomKeywords.'keyword_variableGlobal.generateVariable.addGlobalVariable'('tipoproducto', tipo_producto)

println(GlobalVariable.tipoproducto)

'Espera de 2 segundos'
WebUI.delay(2)

'Guardar valor del Texto Generico'
String Texto_generico = CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'('textogenerico')

'Insertar en input > Descripcion Espanol'
WebUI.setText(findTestObject('Object Repository/productos_objects/textareas/descripcion'), Texto_generico)

'Insertar en input > Descripcion Ingles'
WebUI.setText(findTestObject('Object Repository/productos_objects/textareas/descripcioningles'), Texto_generico)

'Insertar en input > Descripcion Adicional'
WebUI.setText(findTestObject('Object Repository/productos_objects/textareas/descripcionadicional'), Texto_generico)

'Scroll'
WebUI.scrollToElement(findTestObject('Object Repository/productos_objects/textareas/descripcionadicional'), 1)

'Insertar en input > Descripcion ecommerce'
WebUI.setText(findTestObject('Object Repository/productos_objects/textareas/descripcionecommerce'), Texto_generico)

'Scroll'
WebUI.scrollToElement(findTestObject('Object Repository/productos_objects/textareas/descripcionecommerce'), 1)

'Buscar en linea'
WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_linea'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
        'letra'))

'Espera de 2 segundos'
WebUI.delay(2)

'Validar si existen valores en > Linea'
String textl = WebUI.getText(findTestObject('Object Repository/productos_objects/validate/validate_linea'))

print(textl)

'Sino hay valores dejar vacio y de lo contrario hay valores darle click al primero'
if (textl == 'No search results.') {
    'No hay valores dejar vacio'
    WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_linea'), '')

    WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_sublinea'), '')

    WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_subsublinea'), '')
} else {
    'Si hay valores darle click al primero'
    WebUI.click(findTestObject('Object Repository/productos_objects/inputs/input_firstlinea'))

    WebUI.click(findTestObject('Object Repository/productos_objects/inputs/input_sublinea'))

    WebUI.click(findTestObject('Object Repository/productos_objects/inputs/input_lastsublinea'))

    WebUI.click(findTestObject('Object Repository/productos_objects/inputs/input_subsublinea'))

    WebUI.click(findTestObject('Object Repository/productos_objects/inputs/input_firstsubsublinea'))
}

'Scroll'
WebUI.scrollToElement(findTestObject('Object Repository/productos_objects/inputs/input_marca'), 1)

'Buscar en input > Marca'
WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_marca'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
        'letra'))

'Espera de 2 segundos'
WebUI.delay(2)

'Validar si existen valores en > Marca'
String textmarca = WebUI.getText(findTestObject('Object Repository/productos_objects/validate/validate_marca'))

print(textmarca)

'Sino hay valores dejar vacio y de lo contrario hay valores darle click al primero'
if (textmarca == 'No search results.') {
    'Si no hay valores escribir uno'
    WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_marca'), '')
} else {
    'Si hay valores darle click al primero'
    WebUI.click(findTestObject('Object Repository/productos_objects/inputs/input_firstmarca'))
}

'Esperar 1 segundos'
WebUI.delay(1)

'Abrir select > Vender_menos_margen_utilidad'
WebUI.click(findTestObject('Object Repository/productos_objects/selects/select_margen_utilidad'))

'Seleccionar opcion > Vender_menos_margen_utilidad'

CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'(findTestObject('Object Repository/productos_objects/selects/options_margen_utilidad'))

'Scroll'
WebUI.scrollToElement(findTestObject('Object Repository/productos_objects/inputs/input_marca'), 1)

'Abrir select > Tasa IVA'
WebUI.click(findTestObject('Object Repository/productos_objects/selects/select_tasa_IVA'))

'Seleccionar opcion > Tasa IVA'
CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'(findTestObject('Object Repository/productos_objects/selects/options_tasa_IVA'))

'Abrir select > IEPS'
WebUI.click(findTestObject('Object Repository/productos_objects/selects/select_ieps'))

'Seleccionar opcion> IEPS'
CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'(findTestObject('Object Repository/productos_objects/selects/options_ieps'))

'Valor del IEPS'
String ieps = WebUI.getAttribute(findTestObject('Object Repository/productos_objects/selects/select_ieps'), 'value')
println(ieps)

'Si selecciona un IEPS diferente a vacio'
if ((ieps != '9999.00')) {
	'Abrir select > Tipo IEPS'
	WebUI.click(findTestObject('Object Repository/productos_objects/selects/select_tipo_ieps'))
	
	'Seleccionar > Tipo IEPS'
	CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'(findTestObject('Object Repository/productos_objects/selects/options_tipo_ieps'))

} else if  (ieps == '9999.00') {
    'Agregar un valor de cuota aleatoria'
    WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_cuota'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
            'cuota'))
	
	'Abrir select > Tipo IEPS'
	WebUI.click(findTestObject('Object Repository/productos_objects/selects/select_tipo_ieps'))
	
	'Seleccionar > Tipo IEPS'
	CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'(findTestObject('Object Repository/productos_objects/selects/options_tipo_ieps'))
	
} else if (ieps == '') {}

'Seleccionar Check > No generar IEPS en la venta de este producto'
WebUI.click(findTestObject('Object Repository/productos_objects/checks/check_no_generar_ieps'))

'Abrir select > Retencion IVA'
WebUI.click(findTestObject('Object Repository/productos_objects/selects/select_retencion_iva'))

'Seleccionar opcion > Retencion IVA'
CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'(findTestObject('Object Repository/productos_objects/selects/options_retencion_iva'))

'Insertar en input > Retención ISR'
WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_retencion_isr'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
        'retencionisr'))

print(tipo_producto)

'Opciones de Articulo, Materia Prima, Embalaje y Embalaje Dinamico'
if (((((tipo_producto == '0') || (tipo_producto == '1')) || (tipo_producto == '2')) || (tipo_producto == '7')) || (tipo_producto == 
'8')) {
    'Insertar en input > Factor_conversion'
    WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_factor_conversion'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
            'factor_conversion'))
}

'Opciones de servicios'
if (tipo_producto == '3') {
    'Click al tipo de servicio'
    WebUI.click(findTestObject('Object Repository/productos_objects/selects/select_tipo_servicio'))

    'Select el tipo de servicio'
	CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'(findTestObject('Object Repository/productos_objects/selects/option_tipo_servicio'))
	
	'Valor del tipo de servicio'
	String tiposervicio = WebUI.getAttribute(findTestObject('Object Repository/productos_objects/selects/select_tipo_servicio'), 'value')

    if (tiposervicio == '99') {
        'Insertar en input > Cuenta servicio personalizado'
        WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_cuenta_servicio_personalizado'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
                'clave_prod_serv'))

        'Valida si existen valores en el select'
        if (WebUI.verifyElementPresent(findTestObject('Object Repository/productos_objects/inputs/first_cuenta_servicio_personalizado'), 
            1)) {
            'Si hay valores darle click al primero'
            WebUI.click(findTestObject('Object Repository/productos_objects/inputs/first_cuenta_servicio_personalizado'))
        }
    }
}

'Opciones Servicios subcontratados'
if (tipo_producto == '5') {
    
	'Click al tipo de servicio'
    WebUI.click(findTestObject('Object Repository/productos_objects/selects/select_tipo_servicio'))

    'Select el tipo de servicio'
	CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'(findTestObject('Object Repository/productos_objects/selects/option_tipo_servicio'))
	
	'Valor del tipo de servicio'
	String tiposervicio = WebUI.getAttribute(findTestObject('Object Repository/productos_objects/selects/select_tipo_servicio'), 'value')

    if (tiposervicio == '99') {
        'Insertar en input > Cuenta servicio personalizado'
        WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_cuenta_servicio_personalizado'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
                'clave_prod_serv'))

        'Valida si existen valores en el select'
        if (WebUI.verifyElementPresent(findTestObject('Object Repository/productos_objects/inputs/first_cuenta_servicio_personalizado'), 
            1)) {
            'Si hay valores darle click al primero'
            WebUI.click(findTestObject('Object Repository/productos_objects/inputs/first_cuenta_servicio_personalizado'))
        }
    }
    
    'Insertar en input > Factor de conversión'
    WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_factor_conversion'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
            'factor_conversion'))
}

'Opciones Activo Fijo'
if (tipo_producto == '4') {
    'Click en Grupo activo'
    WebUI.click(findTestObject('Object Repository/productos_objects/selects/select_grupo_activo'))
	
    'Insertar en input > Grupo activo'
	CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'(findTestObject('Object Repository/productos_objects/selects/options_grupo_activo'))
}

'Opciones Mano de obra'
if (tipo_producto == '9') {
    'Insertar en input > Cuenta contable'
    WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_cuenta_servicio_personalizado'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
            'clave_prod_serv'))

    'Valida si existen valores en el select'
    if (WebUI.verifyElementPresent(findTestObject('Object Repository/productos_objects/inputs/first_cuenta_servicio_personalizado'), 
        1)) {
        'Si hay valores darle click al primero'
        WebUI.click(findTestObject('Object Repository/productos_objects/inputs/first_cuenta_servicio_personalizado'))
    }
}

'Insertar en input > Número de predial'
WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_codigo_origen'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
        'codigo_origen'))

'Insertar en input > Costo de Reposicion'
WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_costo_reposicion'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
        'costo_reposicion'))

'Seleccionar > Nivel comisión'
WebUI.click(findTestObject('Object Repository/productos_objects/selects/select_nivel_comision'))

'Seleccionar opcion > Nivel comisión'
CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'(findTestObject('Object Repository/productos_objects/selects/opcion_nivel_comision'))

'Scroll'
WebUI.scrollToElement(findTestObject('Object Repository/productos_objects/inputs/input_costo_reposicion'), 1)

'Insertar en input > Cuenta para consumo interno'
WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_consumo_interno'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
        'clave_prod_serv'))

'Espera de 2 segundos'
WebUI.delay(2)

'Buscar elementos en el select'
String claveconsumo = WebUI.getAttribute(findTestObject('Object Repository/productos_objects/validate/validate_consumo'), 'style')
println(claveprod)

'Si hay valores seleccionar uno aleatorio'
if (claveconsumo.contains('block')) {

	CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'(findTestObject('Object Repository/productos_objects/selects/options_consumo_interno'))
}
else {
		
	WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_consumo_interno'), '')
		
	WebUI.comment("El select no tiene elementos")
	
}

'Scroll'
WebUI.scrollToElement(findTestObject('Object Repository/productos_objects/inputs/input_costo_reposicion'), 1)

'Insertar en input > Clave material peligroso'
WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_clave_material_peligroso'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
        'clave_prod_serv'))

'Espera de 2 segundos'
WebUI.delay(2)

'Buscar elementos en el select'
String clavepeligroso = WebUI.getAttribute(findTestObject('Object Repository/productos_objects/validate/validate_peligroso'), 'style')
println(clavepeligroso)

'Si hay valores seleccionar uno aleatorio'
if (clavepeligroso.contains('block')) {

	CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'(findTestObject('Object Repository/productos_objects/selects/options_clave_material_peligroso'))
}
else {
		
	WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_clave_material_peligroso'), '')
		
	WebUI.comment("El select no tiene elementos")
	
}

'Esperar 2 segundos'
WebUI.delay(2)

'Seleccionar > Clave material peligroso'
WebUI.click(findTestObject('Object Repository/productos_objects/selects/select_clave_embalaje_material_peligroso'))

'Esperar 2 segundos'
WebUI.delay(2)

'Seleccionar opcion > Clave material peligroso'
CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'(findTestObject('Object Repository/productos_objects/selects/options_clave_embalaje_material_peligroso'))

'Esperar 2 segundos'
WebUI.delay(2)

'Insertar en input > Comentarios'
WebUI.setText(findTestObject('Object Repository/productos_objects/textareas/comentarios'), Texto_generico)

'Scroll'
WebUI.scrollToElement(findTestObject('Object Repository/productos_objects/textareas/comentarios'), 1)

'Insertar en input > M.U.'
WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_MU'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
        'margen_utilidad_porciento'))

'Insertar en input > Precio'
WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_precio'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
        'precio'))

'Abrir select > Moneda'
WebUI.click(findTestObject('Object Repository/productos_objects/selects/select_moneda'))

'Select opcion > Moneda'
CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'(findTestObject('Object Repository/productos_objects/selects/options_moneda'))

'Scroll'
WebUI.scrollToElement(findTestObject('Object Repository/productos_objects/inputs/input_unidad_medida'), 1)

'Insertar en input > Unidad de medida'
WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_unidad_medida'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
        'letra'))

WebUI.delay(2)

'Valida si existen valores en el select'
String textm = WebUI.getText(findTestObject('Object Repository/productos_objects/validate/validate_unidad_medida'))

print(textm)

if (textm == 'No search results.') {
    'Si no hay valores escribir uno'
    WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_unidad_medida'), 'Pieza' + CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
            'clave_prod_serv'))
} else {
    'Si hay valores darle click al primero'
	CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'(findTestObject('Object Repository/productos_objects/selects/opcion_unidad_medida'))
   
}

'Insertar en input > Factor'
WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_factor'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
        'factor'))

'Insertar en input > Codigo barra'
WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_codigo_barra'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
        'codigo_barra'))

'Insertar en input > Base'
WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_base'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
        'medidas'))

'Insertar en input > Altura'
WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_altura'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
        'medidas'))

'Insertar en input > Profundidad'
WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_profundidad'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
        'medidas'))

'Insertar en input > Peso'
WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_peso'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
        'medidas'))

WebUI.delay(2)

'Seleccionar Check > Selec. compra'
WebUI.click(findTestObject('Object Repository/productos_objects/checks/check_selec_compra'))

'Seleccionar Check > Selec. venta'
WebUI.click(findTestObject('Object Repository/productos_objects/checks/check_selec_venta'))

'Seleccionar Check > Kardex'
WebUI.click(findTestObject('Object Repository/productos_objects/checks/check_kardex'))

'Opciones de Articulo, Materia Prima, Activo Fijo, Servicios subcontratados, Mano de obra, Artículo para arrendamiento'
if ((((((tipo_producto == '0') || (tipo_producto == '1')) || (tipo_producto == '4')) || (tipo_producto == '5')) || (tipo_producto == 
'9')) || (tipo_producto == '10')) {
    'Click en boton > Lista precios proveedores'
    WebUI.click(findTestObject('Object Repository/productos_objects/tabs/tab_lista_precios_proveedores'))

    'Insertar en input > Lista_precios > Cod_proveedor'
    WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_lista_precios_cod_proveedor'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
            'codigo'))

    'Insertar en input > Lista_precios > Proveedor'
    WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_lista_precios_proveedor'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
            'letra'))

    'Valida si existen valores en el select'
    String textp = WebUI.getText(findTestObject('Object Repository/productos_objects/validate/validate_proveedor'))

    WebUI.delay(2)

    if (textp == 'No search results.') {
        'Si no hay valores escribir uno'
        WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_lista_precios_proveedor'), 'Proveedor' + CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
                'clave_prod_serv'))
    } else {
		'Si hay valores darle a una opcion'
		CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'(findTestObject('Object Repository/productos_objects/selects/opcion_lista_precios_proveedor'))
		
    }
    
    'Esperar 2 segundos'
    WebUI.delay(2)

    'Crear tipo de dato fecha'
    Date todaysDate = new Date()

    'Insertar en input > Lista_precios > Fecha'
    WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_lista_precios_fecha'), todaysDate.format('dd/MM/yy'))

    'Insertar en input > Lista_precios > Lista_proveedor'
    WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_lista_precios_lista_proveedor'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
            'medidas'))

    'Insertar en input > Lista_precios > INC'
    WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_lista_precios_inc'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
            'medidas'))

    'Insertar en input > Lista_precios > T.Moneda'
    WebUI.selectOptionByIndex(findTestObject('Object Repository/productos_objects/inputs/input_lista_precios_moneda'), 1)

    'Insertar en input > Lista_precios > Multiplo_compra'
    WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_lista_precios_multiplo_compra'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
            'medidas'))

    'Seleccionar Check > Lista_precios > Select'
    WebUI.click(findTestObject('Object Repository/productos_objects/checks/check_lista_precios_select'))
}

'Opciones de Ensamble, Ensamble dinámico, Producción'
if (((tipo_producto == '2') || (tipo_producto == '8')) || (tipo_producto == '7')) {
    'Seleccionar Tab > Ensamble'
    WebUI.click(findTestObject('Object Repository/productos_objects/tabs/tab_ensamble'))

    'Insertar en input > Ensamble > Producto'
    WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_ensamble_producto'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
            'letra'))

    'Espera de 2 segundos'
    WebUI.delay(2)

    'Valida si existen valores en el select'
    String texte = WebUI.getText(findTestObject('Object Repository/productos_objects/validate/validate_ensamble_producto'))

    if (texte == 'No search results.') {
        'Si no hay valores no escribir uno'
        WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_ensamble_producto'), '')
    } else {
		'Si hay valores darle a una opcion'
		CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'(findTestObject('Object Repository/productos_objects/selects/option_ensamble_producto'))
		
    }
    
    'Insertar en input > Ensamble > Cantidad'
    WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_ensamble_cantidad'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
            'medidas'))

    'Seleccionar Tab > Ensamble > Unidad'
    WebUI.click(findTestObject('Object Repository/productos_objects/inputs/input_ensamble_unidad'))

    'Espera de 2 segundos'
    WebUI.delay(2)

    'Valida si existen valores en el select'
    String texteu = WebUI.getText(findTestObject('Object Repository/productos_objects/validate/validate_ensamble_unidad'))

    if (texteu == 'No search results.') {
        'Si no hay valores escribir uno'
        WebUI.setText(findTestObject('Object Repository/productos_objects/inputs/input_ensamble_unidad'), 'Caja' + CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
                'codigo'))
    } else {
		'Si hay valores darle a una opcion'
		CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'(findTestObject('Object Repository/productos_objects/selects/opcion_ensamble_unidad'))
		
    }
}

'Seleccionar Tab > Relacionados'
WebUI.click(findTestObject('Object Repository/productos_objects/tabs/tab_relacionados'))
/*
'Insertar en input > Relacionados > Conceptos relacionados'
WebUI.setText(CustomKeywords.'borrar.productos_xpath_dynamic.getObject'('input_conceptos_relacionados'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
        'relacionados'))
*/

/*
'Insertar en input > Relacionados > Productos complementarios'
WebUI.setText(CustomKeywords.'borrar.productos_xpath_dynamic.getObject'('input_productos_complementarios'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
        'letra'))

'Espera de 2 segundos'
WebUI.delay(2)

'Valida si existen valores en el select'
String textpc = WebUI.getText(CustomKeywords.'borrar.productos_xpath_dynamic.getObject'('validate_productos_complementarios'))

if (textpc == 'No search results.') {
    'Si no hay valores escribir uno'
    WebUI.setText(CustomKeywords.'borrar.productos_xpath_dynamic.getObject'('input_productos_complementarios'), '')
} else {
    'Si hay valores darle a una opcion'
	CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('option_productos_complementarios', '1')
}

'Opciones de Articulo, Materia Prima, Embalaje Dinamico, Servicios Subcontratados, Mano de Obra, Activo fijo'
if ((((tipo_producto == '0') || (tipo_producto == '1')) || (tipo_producto == '8')) || (tipo_producto == '5')) {
    'Insertar en input > Relacionados > Alternativos'
    WebUI.setText(CustomKeywords.'borrar.productos_xpath_dynamic.getObject'('input_alternativos'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
            'letra'))

    'Espera de 2 segundos'
    WebUI.delay(2)

    'Valida si existen valores en el select'
    String texttag = WebUI.getText(CustomKeywords.'borrar.productos_xpath_dynamic.getObject'('validate_alternativos'))

    if (texttag == 'No search results.') {
        'Si no hay valores escribir uno'
        WebUI.setText(CustomKeywords.'borrar.productos_xpath_dynamic.getObject'('input_alternativos'), '')
    } else {
        'Si hay valores darle a una opcion'
		CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('option_alternativos', '1')
    }
}
*/


'Seleccionar Tab > Tags'
WebUI.click(findTestObject('Object Repository/productos_objects/tabs/tab_tags'))
/*
'Insertar en input > Tag'
WebUI.setText(CustomKeywords.'borrar.productos_xpath_dynamic.getObject'('input_tag'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
        'codigo_busqueda'))

'Espera de 2 segundos'
WebUI.delay(2)

'Valida si existen valores en el select'
String texttag = WebUI.getText(CustomKeywords.'borrar.productos_xpath_dynamic.getObject'('validate_tag'))

if (texttag == 'No search results.') {
    'Si no hay valores escribir uno'
    WebUI.setText(CustomKeywords.'borrar.productos_xpath_dynamic.getObject'('input_tag'), '')
} else {
    'Si hay valores darle a una opcion'
	CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('option_tag', '1')
	
}
*/
'Seleccionar Tab > Consumibles'
WebUI.click(findTestObject('Object Repository/productos_objects/tabs/tab_consumibles'))
/*
'Insertar en input > Consumibles'
WebUI.setText(CustomKeywords.'borrar.productos_xpath_dynamic.getObject'('input_consumibles'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
        'letra'))

'Espera de 2 segundos'
WebUI.delay(2)

'Valida si existen valores en el select'
String textcon = WebUI.getText(CustomKeywords.'borrar.productos_xpath_dynamic.getObject'('validate_consumibles'))

if (textcon == 'No search results.') {
    'Si no hay valores escribir uno'
    WebUI.setText(CustomKeywords.'borrar.productos_xpath_dynamic.getObject'('input_consumibles'), '')
} else {
    'Si hay valores darle a una opcion'
	CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('options_consumibles', '1')
	
}
*/
'Seleccionar Tab > Refacciones'
WebUI.click(findTestObject('Object Repository/productos_objects/tabs/tab_refacciones'))
/*
'Insertar en input > Refacciones'
WebUI.setText(CustomKeywords.'borrar.productos_xpath_dynamic.getObject'('input_refacciones'), CustomKeywords.'keyword_productos.products_data_aleatory.getAleatotyData'(
        'letra'))

'Espera de 2 segundos'
WebUI.delay(2)

'Valida si existen valores en el select'
String textrefa = WebUI.getText(CustomKeywords.'borrar.productos_xpath_dynamic.getObject'('validate_input_refacciones'))

if (textrefa == 'No search results.') {
    'Si no hay valores escribir uno'
    WebUI.setText(CustomKeywords.'borrar.productos_xpath_dynamic.getObject'('input_refacciones'), '')
} else {
    'Si hay valores darle a una opcion'
	CustomKeywords.'keyword_sharedElements.selectOptionAleatory.aleatoryobject'('options_input_refacciones', '1')
    
}*/
'Creamos la variable global con el Keyword para buscar el producto'
CustomKeywords.'keyword_variableGlobal.generateVariable.addGlobalVariable'('descripcionproducto', Texto_generico)

'Scroll'
WebUI.scrollToElement(findTestObject('Object Repository/productos_objects/buttons/button_guardar_form'), 1)

'Guardar formulario'
WebUI.click(findTestObject('Object Repository/productos_objects/buttons/button_guardar_form'))

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
    //WebUI.closeBrowser()
	
} else if (closeBrowser == '0') {
	
    'Espera de 1 segundos'
    WebUI.delay(1)

    
}

