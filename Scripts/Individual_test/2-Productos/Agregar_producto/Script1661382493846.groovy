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

String openBrowser = CustomKeywords.'navegador.validateNavegador.browser'()

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
WebUI.click(CustomKeywords.'menu.xpath_dynamic.object'('boton_inventario'))

'Click en boton > Menu - Catalogos'
WebUI.click(CustomKeywords.'menu.xpath_dynamic.object'('boton_catalogo'))

'Click en boton > Menu-Productos'
WebUI.click(CustomKeywords.'menu.xpath_dynamic.object'('boton_productos'))

'Click en boton -> Agregar Productos'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('boton_agregar_productos'))

'Tipo de venta aleatorio > Tienda, Web, Ambos'
List randomObjects = Arrays.asList('1', '2', '3')
String randomPath = randomObjects.get(new Random().nextInt(randomObjects.size()))

'Tienda'
if (randomPath == '1') {
    WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('radio_tienda'))
}

'Web'
if (randomPath == '2') {
    WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('radio_web'))
}

'Ambos'
if (randomPath == '3') {
    WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('radio_ambos'))
}

'Insertar en input > Imagen URL'
WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_imagenURL'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
        'imagenURL'))

'Ruta del archivo'
def fileDir = RunConfiguration.getProjectDir() + '/Data Files/logo_azul_blanco.png'

'Sustituir barras dependiendo del navegador'
fileDir = fileDir.replace('/', '\\')

'Insertar en input > Imagen URL'
WebUI.uploadFile(CustomKeywords.'productos.xpath_dynamic.object'('input_imagenUpload'), fileDir)

'Scroll'
WebUI.scrollToElement(CustomKeywords.'productos.xpath_dynamic.object'('check_restringir_descuento'), 1)

'Check laterales - check_restringir_descuento'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('check_restringir_descuento'))

'Check laterales - quitar check_restringir_decimales'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('check_restringir_decimales'))

'Check laterales - check_restringir_decimales'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('check_restringir_decimales'))

'Check laterales - check_habilitar_webhook'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('check_habilitar_webhook'))

'Check laterales - check_integracion_rappi'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('check_integracion_rappi'))

'Check laterales - check_pedidos_especiales'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('check_pedidos_especiales'))

'Check laterales - check_venta_cd_cod_barras'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('check_venta_cd_cod_barras'))

'Check laterales - check_habilitar_bascula'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('check_habilitar_bascula'))

'Check laterales - check_congelar_precios_venta'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('check_congelar_precios_venta'))

'Check laterales - check_no_generar_comision'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('check_no_generar_comision'))

'Check laterales - check_usa_doble_unidad'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('check_usa_doble_unidad'))

'Scroll Cabecera'
WebUI.scrollToElement(CustomKeywords.'productos.xpath_dynamic.object'('guardar_form'), 1)

'Insertar en input > Codigo'
WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_codigo'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
        'codigo'))

'Insertar en input > Clave prod serv'
WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_clave_prod_serv'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
        'clave_prod_serv'))

'Espera de 2 segundos'
WebUI.delay(2)
	
'Buscar elementos en el select'
String claveprod = WebUI.getAttribute(CustomKeywords.'productos.xpath_dynamic.object'('validar_clave_prod_serv'), 'style')
println(claveprod)

'Si hay valores seleccionar uno aleatorio'
if (claveprod.contains('block')) {

	String validarclave = CustomKeywords.'selects.selectAleatory.aleatoryobject'('opcion_clave_prod_serv', '1')
	
}
else {
		
	WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_clave_prod_serv'), '')
		
	WebUI.comment("El select no tiene elementos")
	
}


'Abrir select > Tipo'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('select_tipo'))

'Selecionar opcion > Tipo'
CustomKeywords.'selects.selectAleatory.aleatoryobject'('options_tipo', '1')

'Guardar valor del Tipo producto'
String tipo_producto = WebUI.getAttribute(CustomKeywords.'productos.xpath_dynamic.object'('select_tipo'), 'value')
println(tipo_producto)

'Crear el tipo de producto como variable global'
CustomKeywords.'variableGlobal.generateVariable.addGlobalVariable'('tipoproducto', tipo_producto)

println(GlobalVariable.tipoproducto)

'Espera de 2 segundos'
WebUI.delay(2)

'Guardar valor del Texto Generico'
String Texto_generico = CustomKeywords.'productos.data_aleatory.getAleatotyData'('textogenerico')

'Insertar en input > Descripcion Espanol'
WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('descripcion'), Texto_generico)

'Insertar en input > Descripcion Ingles'
WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('descripcioningles'), Texto_generico)

'Insertar en input > Descripcion Adicional'
WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('descripcionadicional'), Texto_generico)

'Scroll'
WebUI.scrollToElement(CustomKeywords.'productos.xpath_dynamic.object'('descripcionadicional'), 1)

'Insertar en input > Descripcion ecommerce'
WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('descripcionecommerce'), Texto_generico)

'Scroll'
WebUI.scrollToElement(CustomKeywords.'productos.xpath_dynamic.object'('descripcionecommerce'), 1)

'Buscar en linea'
WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_linea'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
        'letra'))

'Espera de 2 segundos'
WebUI.delay(2)

'Validar si existen valores en > Linea'
String textl = WebUI.getText(CustomKeywords.'productos.xpath_dynamic.object'('validate_linea'))

print(textl)

'Sino hay valores dejar vacio y de lo contrario hay valores darle click al primero'
if (textl == 'No search results.') {
    'No hay valores dejar vacio'
    WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_linea'), '')

    WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_sublinea'), '')

    WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_subsublinea'), '')
} else {
    'Si hay valores darle click al primero'
    WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('input_firstlinea'))

    WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('input_sublinea'))

    WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('input_lastsublinea'))

    WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('input_subsublinea'))

    WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('input_firstsubsublinea'))
}

'Scroll'
WebUI.scrollToElement(CustomKeywords.'productos.xpath_dynamic.object'('input_marca'), 1)

'Buscar en input > Marca'
WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_marca'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
        'letra'))

'Espera de 2 segundos'
WebUI.delay(2)

'Validar si existen valores en > Marca'
String textmarca = WebUI.getText(CustomKeywords.'productos.xpath_dynamic.object'('validate_marca'))

print(textmarca)

'Sino hay valores dejar vacio y de lo contrario hay valores darle click al primero'
if (textmarca == 'No search results.') {
    'Si no hay valores escribir uno'
    WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_marca'), '')
} else {
    'Si hay valores darle click al primero'
    WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('input_firstmarca'))
}

'Esperar 1 segundos'
WebUI.delay(1)

'Abrir select > Vender_menos_margen_utilidad'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('select_margen_utilidad'))

'Seleccionar opcion > Vender_menos_margen_utilidad'
CustomKeywords.'selects.selectAleatory.aleatoryobject'('options_margen_utilidad', '1')

'Scroll'
WebUI.scrollToElement(CustomKeywords.'productos.xpath_dynamic.object'('input_marca'), 1)

'Abrir select > Tasa IVA'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('select_tasa_IVA'))

'Seleccionar opcion > Tasa IVA'
CustomKeywords.'selects.selectAleatory.aleatoryobject'('options_tasa_IVA', '1')

'Abrir select > IEPS'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('select_ieps'))

'Seleccionar opcion> IEPS'
CustomKeywords.'selects.selectAleatory.aleatoryobject'('options_ieps', '1')

'Valor del IEPS'
String ieps = WebUI.getAttribute(CustomKeywords.'productos.xpath_dynamic.object'('select_ieps'), 'value')
println(ieps)

'Si selecciona un IEPS diferente a vacio'
if ((ieps != '9999.00')) {
	'Abrir select > Tipo IEPS'
	WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('select_tipo_ieps'))
	
	'Seleccionar > Tipo IEPS'
	CustomKeywords.'selects.selectAleatory.aleatoryobject'('options_tipo_ieps', '1')

} else if  (ieps == '9999.00') {
    'Agregar un valor de cuota aleatoria'
    WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_cuota'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
            'cuota'))
	
	'Abrir select > Tipo IEPS'
	WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('select_tipo_ieps'))
	
	'Seleccionar > Tipo IEPS'
	CustomKeywords.'selects.selectAleatory.aleatoryobject'('options_tipo_ieps', '1')
	
} else if (ieps == '') {}

'Seleccionar Check > No generar IEPS en la venta de este producto'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('check_no_generar_ieps'))

'Abrir select > Retencion IVA'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('select_retencion_iva'))

'Seleccionar opcion > Retencion IVA'
CustomKeywords.'selects.selectAleatory.aleatoryobject'('options_retencion_iva', '1')

'Insertar en input > Retención ISR'
WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_retencion_isr'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
        'retencionisr'))

print(tipo_producto)

'Opciones de Articulo, Materia Prima, Embalaje y Embalaje Dinamico'
if (((((tipo_producto == '0') || (tipo_producto == '1')) || (tipo_producto == '2')) || (tipo_producto == '7')) || (tipo_producto == 
'8')) {
    'Insertar en input > Factor_conversion'
    WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_factor_conversion'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
            'factor_conversion'))
}

'Opciones de servicios'
if (tipo_producto == '3') {
    'Click al tipo de servicio'
    WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('input_tipo_servicio'))

    'Select el tipo de servicio'
	CustomKeywords.'selects.selectAleatory.aleatoryobject'('option_tipo_servicio', '1')
	
	'Valor del tipo de servicio'
	String tiposervicio = WebUI.getAttribute(CustomKeywords.'productos.xpath_dynamic.object'('input_tipo_servicio'), 'value')

    if (tiposervicio == '99') {
        'Insertar en input > Cuenta servicio personalizado'
        WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_cuenta_servicio_personalizado'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
                'clave_prod_serv'))

        'Valida si existen valores en el select'
        if (WebUI.verifyElementPresent(CustomKeywords.'productos.xpath_dynamic.object'('first_cuenta_servicio_personalizado'), 
            1)) {
            'Si hay valores darle click al primero'
            WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('first_cuenta_servicio_personalizado'))
        }
    }
}

'Opciones Servicios subcontratados'
if (tipo_producto == '5') {
    
	'Click al tipo de servicio'
    WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('input_tipo_servicio'))

    'Select el tipo de servicio'
	CustomKeywords.'selects.selectAleatory.aleatoryobject'('option_tipo_servicio', '1')
	
	'Valor del tipo de servicio'
	String tiposervicio = WebUI.getAttribute(CustomKeywords.'productos.xpath_dynamic.object'('input_tipo_servicio'), 'value')

    if (tiposervicio == '99') {
        'Insertar en input > Cuenta servicio personalizado'
        WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_cuenta_servicio_personalizado'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
                'clave_prod_serv'))

        'Valida si existen valores en el select'
        if (WebUI.verifyElementPresent(CustomKeywords.'productos.xpath_dynamic.object'('first_cuenta_servicio_personalizado'), 
            1)) {
            'Si hay valores darle click al primero'
            WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('first_cuenta_servicio_personalizado'))
        }
    }
    
    'Insertar en input > Factor de conversión'
    WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_factor_conversion'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
            'factor_conversion'))
}

'Opciones Activo Fijo'
if (tipo_producto == '4') {
    'Click en Grupo activo'
    WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('input_grupo_activo'))

    'Insertar en input > Grupo activo'
    CustomKeywords.'selects.selectAleatory.aleatoryobject'('options_grupo_activo', '1')
}

'Opciones Mano de obra'
if (tipo_producto == '9') {
    'Insertar en input > Cuenta contable'
    WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_cuenta_servicio_personalizado'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
            'clave_prod_serv'))

    'Valida si existen valores en el select'
    if (WebUI.verifyElementPresent(CustomKeywords.'productos.xpath_dynamic.object'('first_cuenta_servicio_personalizado'), 
        1)) {
        'Si hay valores darle click al primero'
        WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('first_cuenta_servicio_personalizado'))
    }
}

'Insertar en input > Número de predial'
WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_codigo_origen'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
        'codigo_origen'))

'Insertar en input > Costo de Reposicion'
WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_costo_reposicion'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
        'costo_reposicion'))

'Seleccionar > Nivel comisión'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('select_nivel_comision'))

'Seleccionar opcion > Nivel comisión'
CustomKeywords.'selects.selectAleatory.aleatoryobject'('opcion_nivel_comision', '1')

'Scroll'
WebUI.scrollToElement(CustomKeywords.'productos.xpath_dynamic.object'('input_costo_reposicion'), 1)

'Insertar en input > Cuenta para consumo interno'
WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_consumo_interno'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
        'clave_prod_serv'))

'Espera de 2 segundos'
WebUI.delay(2)

'Buscar elementos en el select'
String claveconsumo = WebUI.getAttribute(CustomKeywords.'productos.xpath_dynamic.object'('validar_consumo'), 'style')
println(claveprod)

'Si hay valores seleccionar uno aleatorio'
if (claveconsumo.contains('block')) {

	CustomKeywords.'selects.selectAleatory.aleatoryobject'('options_consumo_interno', '1')
}
else {
		
	WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_consumo_interno'), '')
		
	WebUI.comment("El select no tiene elementos")
	
}

'Scroll'
WebUI.scrollToElement(CustomKeywords.'productos.xpath_dynamic.object'('input_costo_reposicion'), 1)

'Insertar en input > Clave material peligroso'
WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_clave_material_peligroso'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
        'clave_prod_serv'))

'Espera de 2 segundos'
WebUI.delay(2)

'Buscar elementos en el select'
String clavepeligroso = WebUI.getAttribute(CustomKeywords.'productos.xpath_dynamic.object'('validar_peligroso'), 'style')
println(clavepeligroso)

'Si hay valores seleccionar uno aleatorio'
if (clavepeligroso.contains('block')) {

	CustomKeywords.'selects.selectAleatory.aleatoryobject'('options_clave_material_peligroso', '1')
}
else {
		
	WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_clave_material_peligroso'), '')
		
	WebUI.comment("El select no tiene elementos")
	
}

'Esperar 2 segundos'
WebUI.delay(2)

'Seleccionar > Clave material peligroso'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('select_clave_embalaje_material_peligroso'))

'Esperar 2 segundos'
WebUI.delay(2)

'Seleccionar opcion > Clave material peligroso'
CustomKeywords.'selects.selectAleatory.aleatoryobject'('options_clave_embalaje_material_peligroso', '1')

'Esperar 2 segundos'
WebUI.delay(2)

'Insertar en input > Comentarios'
WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_comentarios'), Texto_generico)

'Insertar en input > M.U.'
WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_MU'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
        'margen_utilidad_porciento'))

'Insertar en input > Precio'
WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_precio'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
        'precio'))

'Abrir select > Moneda'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('select_moneda'))

'Select opcion > Moneda'
CustomKeywords.'selects.selectAleatory.aleatoryobject'('options_moneda', '1')

'Scroll'
WebUI.scrollToElement(CustomKeywords.'productos.xpath_dynamic.object'('input_unidad_medida'), 1)

'Insertar en input > Unidad de medida'
WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_unidad_medida'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
        'letra'))

WebUI.delay(2)

'Valida si existen valores en el select'
String textm = WebUI.getText(CustomKeywords.'productos.xpath_dynamic.object'('validate_unidad_medida'))

print(textm)

if (textm == 'No search results.') {
    'Si no hay valores escribir uno'
    WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_unidad_medida'), 'Pieza' + CustomKeywords.'productos.data_aleatory.getAleatotyData'(
            'clave_prod_serv'))
} else {
    'Si hay valores darle click al primero'
	CustomKeywords.'selects.selectAleatory.aleatoryobject'('opcion_unidad_medida', '1')
   
}

'Insertar en input > Factor'
WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_factor'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
        'factor'))

'Insertar en input > Codigo barra'
WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_codigo_barra'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
        'codigo_barra'))

'Insertar en input > Base'
WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_base'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
        'medidas'))

'Insertar en input > Altura'
WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_altura'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
        'medidas'))

'Insertar en input > Profundidad'
WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_profundidad'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
        'medidas'))

'Insertar en input > Peso'
WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_peso'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
        'medidas'))

WebUI.delay(2)

'Seleccionar Check > Selec. compra'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('check_selec_compra'))

'Seleccionar Check > Selec. venta'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('check_selec_venta'))

'Seleccionar Check > Kardex'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('check_kardex'))

'Opciones de Articulo, Materia Prima, Activo Fijo, Servicios subcontratados, Mano de obra, Artículo para arrendamiento'
if ((((((tipo_producto == '0') || (tipo_producto == '1')) || (tipo_producto == '4')) || (tipo_producto == '5')) || (tipo_producto == 
'9')) || (tipo_producto == '10')) {
    'Click en boton > Lista precios proveedores'
    WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('boton_lista_precios_proveedores'))

    'Insertar en input > Lista_precios > Cod_proveedor'
    WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_lista_precios_cod_proveedor'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
            'codigo'))

    'Insertar en input > Lista_precios > Proveedor'
    WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_lista_precios_proveedor'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
            'letra'))

    'Valida si existen valores en el select'
    String textp = WebUI.getText(CustomKeywords.'productos.xpath_dynamic.object'('validate_proveedor'))

    WebUI.delay(2)

    if (textp == 'No search results.') {
        'Si no hay valores escribir uno'
        WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_lista_precios_proveedor'), 'Proveedor' + CustomKeywords.'productos.data_aleatory.getAleatotyData'(
                'clave_prod_serv'))
    } else {
		'Si hay valores darle a una opcion'
		CustomKeywords.'selects.selectAleatory.aleatoryobject'('opcion_lista_precios_proveedor', '1')
		
    }
    
    'Esperar 2 segundos'
    WebUI.delay(2)

    'Crear tipo de dato fecha'
    Date todaysDate = new Date()

    'Insertar en input > Lista_precios > Fecha'
    WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_lista_precios_fecha'), todaysDate.format('dd/MM/yy'))

    'Insertar en input > Lista_precios > Lista_proveedor'
    WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_lista_precios_lista_proveedor'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
            'medidas'))

    'Insertar en input > Lista_precios > INC'
    WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_lista_precios_inc'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
            'medidas'))

    'Insertar en input > Lista_precios > T.Moneda'
    WebUI.selectOptionByIndex(CustomKeywords.'productos.xpath_dynamic.object'('input_lista_precios_moneda'), 1)

    'Insertar en input > Lista_precios > Multiplo_compra'
    WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_lista_precios_multiplo_compra'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
            'medidas'))

    'Seleccionar Check > Lista_precios > Select'
    WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('check_lista_precios_select'))
}

'Opciones de Ensamble, Ensamble dinámico, Producción'
if (((tipo_producto == '2') || (tipo_producto == '8')) || (tipo_producto == '7')) {
    'Seleccionar Tab > Ensamble'
    WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('tab_ensamble'))

    'Insertar en input > Ensamble > Producto'
    WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_ensamble_producto'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
            'letra'))

    'Espera de 2 segundos'
    WebUI.delay(2)

    'Valida si existen valores en el select'
    String texte = WebUI.getText(CustomKeywords.'productos.xpath_dynamic.object'('validate_ensamble_producto'))

    if (texte == 'No search results.') {
        'Si no hay valores no escribir uno'
        WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_ensamble_producto'), '')
    } else {
		'Si hay valores darle a una opcion'
		CustomKeywords.'selects.selectAleatory.aleatoryobject'('option_ensamble_producto', '1')
		
    }
    
    'Insertar en input > Ensamble > Cantidad'
    WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_ensamble_cantidad'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
            'medidas'))

    'Seleccionar Tab > Ensamble > Unidad'
    WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('input_ensamble_unidad'))

    'Espera de 2 segundos'
    WebUI.delay(2)

    'Valida si existen valores en el select'
    String texteu = WebUI.getText(CustomKeywords.'productos.xpath_dynamic.object'('validate_ensamble_unidad'))

    if (texteu == 'No search results.') {
        'Si no hay valores escribir uno'
        WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_ensamble_unidad'), 'Caja' + CustomKeywords.'productos.data_aleatory.getAleatotyData'(
                'codigo'))
    } else {
		'Si hay valores darle a una opcion'
		CustomKeywords.'selects.selectAleatory.aleatoryobject'('opcion_ensamble_unidad', '1')
		
    }
}

'Seleccionar Tab > Relacionados'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('tab_relacionados'))

'Insertar en input > Relacionados > Conceptos relacionados'
WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_conceptos_relacionados'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
        'relacionados'))
/*
'Insertar en input > Relacionados > Productos complementarios'
WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_productos_complementarios'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
        'letra'))

'Espera de 2 segundos'
WebUI.delay(2)

'Valida si existen valores en el select'
String textpc = WebUI.getText(CustomKeywords.'productos.xpath_dynamic.object'('validate_productos_complementarios'))

if (textpc == 'No search results.') {
    'Si no hay valores escribir uno'
    WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_productos_complementarios'), '')
} else {
    'Si hay valores darle a una opcion'
	CustomKeywords.'selects.selectAleatory.aleatoryobject'('option_productos_complementarios', '1')
}

'Opciones de Articulo, Materia Prima, Embalaje Dinamico, Servicios Subcontratados, Mano de Obra, Activo fijo'
if ((((tipo_producto == '0') || (tipo_producto == '1')) || (tipo_producto == '8')) || (tipo_producto == '5')) {
    'Insertar en input > Relacionados > Alternativos'
    WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_alternativos'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
            'letra'))

    'Espera de 2 segundos'
    WebUI.delay(2)

    'Valida si existen valores en el select'
    String texttag = WebUI.getText(CustomKeywords.'productos.xpath_dynamic.object'('validate_alternativos'))

    if (texttag == 'No search results.') {
        'Si no hay valores escribir uno'
        WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_alternativos'), '')
    } else {
        'Si hay valores darle a una opcion'
		CustomKeywords.'selects.selectAleatory.aleatoryobject'('option_alternativos', '1')
    }
}
*/
'Seleccionar Tab > Tags'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('tab_tags'))

'Insertar en input > Tag'
WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_tag'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
        'codigo_busqueda'))

'Espera de 2 segundos'
WebUI.delay(2)

'Valida si existen valores en el select'
String texttag = WebUI.getText(CustomKeywords.'productos.xpath_dynamic.object'('validate_tag'))

if (texttag == 'No search results.') {
    'Si no hay valores escribir uno'
    WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_tag'), '')
} else {
    'Si hay valores darle a una opcion'
	CustomKeywords.'selects.selectAleatory.aleatoryobject'('option_tag', '1')
	
}

'Seleccionar Tab > Consumibles'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('tab_consumibles'))
/*
'Insertar en input > Consumibles'
WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_consumibles'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
        'letra'))

'Espera de 2 segundos'
WebUI.delay(2)

'Valida si existen valores en el select'
String textcon = WebUI.getText(CustomKeywords.'productos.xpath_dynamic.object'('validate_consumibles'))

if (textcon == 'No search results.') {
    'Si no hay valores escribir uno'
    WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_consumibles'), '')
} else {
    'Si hay valores darle a una opcion'
	CustomKeywords.'selects.selectAleatory.aleatoryobject'('options_consumibles', '1')
	
}
*/
'Seleccionar Tab > Refacciones'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('tab_refacciones'))
/*
'Insertar en input > Refacciones'
WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_refacciones'), CustomKeywords.'productos.data_aleatory.getAleatotyData'(
        'letra'))

'Espera de 2 segundos'
WebUI.delay(2)

'Valida si existen valores en el select'
String textrefa = WebUI.getText(CustomKeywords.'productos.xpath_dynamic.object'('validate_input_refacciones'))

if (textrefa == 'No search results.') {
    'Si no hay valores escribir uno'
    WebUI.setText(CustomKeywords.'productos.xpath_dynamic.object'('input_refacciones'), '')
} else {
    'Si hay valores darle a una opcion'
	CustomKeywords.'selects.selectAleatory.aleatoryobject'('options_input_refacciones', '1')
    
}*/
'Creamos la variable global con el Keyword para buscar el producto'
CustomKeywords.'variableGlobal.generateVariable.addGlobalVariable'('descripcionproducto', Texto_generico)

'Guardar formulario'
WebUI.click(CustomKeywords.'productos.xpath_dynamic.object'('guardar_form'))

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

