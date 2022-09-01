package keyword_productos

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
/**
 *Esta clase contiene los elementos dinámicos web (xpath) del formulario para el crud de productos.
 *Es usada para las siguientes rutas de formularios:
 *@linkplain (1) https://kaizen.admintotal.com/admin/agregar_producto/
 *@linkplain (2) https://kaizen.admintotal.com/admin/inventario/catalogos/productos/
 *@linkplain (3) https://kaizen.admintotal.com/admin/producto/edit/
 *@linkplain (4) https://kaizen.admintotal.com/admin/delete/producto/
 *@author Grupo KAIZEN
 *@since 2022
 */
public class xpath_dynamic {

	/**
	 *<h3>Crea un objeto con una ruta xpath para ejecutar acciones.</h3>
	 *Estas acciones pueden ser: hacer click al objeto o insertar texto en el objeto.
	 *El método busca una cadena que es el nombre de un elemento,
	 *al encontrarlo lo asocia a un xpath (ruta del elemento web)
	 *y luego lo convierte en objeto de tipo TestObject
	 *@param element es un nombre que se le asigna al elemento para buscarlo
	 *@return newElement es un objeto de tipo TestObject
	 */
	@Keyword
	def getObject(String element) {

		String xpath = ''

		if (element == 'boton_agregar_productos')
			xpath = "//a[contains(@href, '/admin/agregar_producto/')]"

		else if (element == 'check_restringir_descuento')
			xpath = "//input[@id='id_restringir_descuento_autorizado']/following-sibling::*[1]"

		else if (element == 'check_restringir_decimales')
			xpath = "//input[@id='id_restringir_decimales']/following-sibling::*[1]"

		else if (element == 'check_habilitar_webhook')
			xpath = "//input[@id='id_habilitar_webhook']/following-sibling::*[1]"

		else if (element == 'check_integracion_rappi')
			xpath = "//input[@id='id_integracion_rappi']/following-sibling::*[1]"

		else if (element == 'check_pedidos_especiales')
			xpath = "//input[@id='id_solo_pedido']/following-sibling::*[1]"

		else if (element == 'check_venta_cd_cod_barras')
			xpath = "//input[@id='id_venta_cb_cantidad']/following-sibling::*[1]"

		else if (element == 'check_habilitar_bascula')
			xpath = "//input[@id='id_habilitar_bascula']/following-sibling::*[1]"

		else if (element == 'check_congelar_precios_venta')
			xpath = "//input[@id='id_congelar_precios_venta']/following-sibling::*[1]"

		else if (element == 'check_no_generar_comision')
			xpath = "//input[@id='id_no_generar_comision']/following-sibling::*[1]"

		else if (element == 'check_usa_doble_unidad')
			xpath = "//input[@id='id_usa_doble_unidad']/following-sibling::*[3]"

		else if (element == 'input_codigo')
			xpath = "//input[@id='id_codigo_sin_marca']"

		else if (element == 'input_clave_prod_serv')
			xpath = "//input[@id='id_clave_prod_serv']"

		else if (element == 'validar_clave_prod_serv')
			xpath = "//input[@id='id_clave_prod_serv']/following-sibling::*[2]"

		else if (element == 'opcion_clave_prod_serv')
			xpath = "(//li[@class='ui-menu-item'])"

		else if (element == 'select_tipo')
			xpath = "//select[@id='id_tipo']"

		else if (element == 'options_tipo')
			xpath = "//select[@id='id_tipo']/option"

		else if (element == 'radio_tienda')
			xpath = "//input[@id='id_medio_distribucion_0']"

		else if (element == 'radio_web')
			xpath = "//input[@id='id_medio_distribucion_1']"

		else if (element == 'radio_ambos')
			xpath = "//input[@id='id_medio_distribucion_2']"

		else if (element == 'descripcion')
			xpath = '//input[@id="id_descripcion"]'

		else if (element == 'descripcioningles')
			xpath = '//input[@id="id_descripcion_ingles"]'

		else if (element == 'descripcionadicional')
			xpath = '//textarea[@id="id_texto_descripcion_adicional"]'

		else if (element == 'descripcionecommerce')
			xpath = '//textarea[@id="id_descripcion_ecommerce"]'

		else if (element == 'input_imagenURL')
			xpath = "//input[@id='id_imagen']"

		else if (element == 'input_imagenUpload')
			xpath = '//input[@id="id_imagen_adjunta"]'

		else if (element == 'input_linea')
			xpath = '//input[@id="id_linea"]'

		else if (element == 'validate_linea')
			xpath = "//input[@id='id_linea']//preceding-sibling::span"

		else if (element == 'input_firstlinea')
			xpath = "//input[@id='id_linea']/following-sibling::*[2]/li[1]/a"

		else if (element == 'input_sublinea')
			xpath = '//input[@id="id_sublinea"]'

		else if (element == 'input_lastsublinea')
			xpath = "(//div[@id='lightbox']/following-sibling::*[1])/li[last()]/a"

		else if (element == 'input_subsublinea')
			xpath = '//input[@id="id_subsublinea"]'

		else if (element == 'input_firstsubsublinea')
			xpath = "//div[@id='lightbox']/following-sibling::*[2]/li[last()]/a"

		else if (element == 'input_marca')
			xpath = '//input[@id="id_marca"]'

		else if (element == 'validate_marca')
			xpath = "//input[@id='id_marca']//preceding-sibling::span"

		else if (element == 'input_firstmarca')
			xpath = "//input[@id='id_marca']/following-sibling::*[2]/li/a"

		else if (element == 'select_margen_utilidad')
			xpath = '//select[@id="id_vender_menos_margen_utilidad"]'

		else if (element == 'options_margen_utilidad')
			xpath = '//select[@id="id_vender_menos_margen_utilidad"]/option'

		else if (element == 'select_tasa_IVA')
			xpath = '//select[@id="id_exento_de_impuesto"]'

		else if (element == 'options_tasa_IVA')
			xpath = '//select[@id="id_exento_de_impuesto"]/option'

		else if (element == 'select_ieps')
			xpath = '//select[@id="id_porcentaje_ieps"]'

		else if (element == 'options_ieps')
			xpath = '//select[@id="id_porcentaje_ieps"]/option'

		else if (element == 'input_cuota')
			xpath = '//input[@id="id_cuota_ieps"]'

		else if (element == 'select_tipo_ieps')
			xpath = '//select[@id="id_tipo_ieps"]'

		else if (element == 'options_tipo_ieps')
			xpath = '//select[@id="id_tipo_ieps"]/option'

		else if (element == 'check_no_generar_ieps')
			xpath = "//input[@id='id_deshabilitar_ieps_ventas']/following-sibling::*[1]"

		else if (element == 'select_retencion_iva')
			xpath = '//select[@id="id_retencion_iva"]'

		else if (element == 'options_retencion_iva')
			xpath = '//select[@id="id_retencion_iva"]/option'

		else if (element == 'input_retencion_isr')
			xpath = '//input[@id="id_retencion_isr"]'

		else if (element == 'input_codigo_origen')
			xpath = "//input[@id='id_codigo_origen']"

		else if (element == 'input_factor_conversion')
			xpath = "//input[@id='id_factor_conversion']"

		else if (element == 'input_tipo_servicio')
			xpath = "//select[@id='id_tipo_servicio']"

		else if (element == 'option_tipo_servicio')
			xpath = "//select[@id='id_tipo_servicio']/option"

		else if (element == 'input_cuenta_servicio_personalizado')
			xpath = "//input[@id='id_cuenta_servicio_personalizado']"

		else if (element == 'first_cuenta_servicio_personalizado')
			xpath = "(//ul[@id='ui-id-2']/li/a)[1]"

		else if (element == 'input_grupo_activo')
			xpath = "//select[@id='id_grupo_activo']"

		else if (element == 'options_grupo_activo')
			xpath = "//select[@id='id_grupo_activo']/option"

		else if (element == 'input_costo_reposicion')
			xpath = "//input[@id='id_costo']"

		else if (element == 'select_nivel_comision')
			xpath = "//select[@id='id_nivel_comision']"

		else if (element == 'opcion_nivel_comision')
			xpath = "//select[@id='id_nivel_comision']/option"

		else if (element == 'input_consumo_interno')
			xpath = "//input[@id='id_cuenta_consumo_interno']"

		else if (element == 'validar_consumo')
			xpath = "//input[@id='id_cuenta_consumo_interno']/following-sibling::*[3]"

		else if (element == 'options_consumo_interno')
			xpath = "//input[@id='id_cuenta_consumo_interno']/following-sibling::*[3]/li/a"

		else if (element == 'input_clave_material_peligroso')
			xpath = "//input[@id='id_clave_material_peligroso_txt']"

		else if (element == 'validar_peligroso')
			xpath = "//input[@id='id_clave_material_peligroso_txt']/following-sibling::*[4]"

		else if (element == 'options_clave_material_peligroso')
			xpath = "(//ul[@id='ui-id-3']/li/a)"

		else if (element == 'select_clave_embalaje_material_peligroso')
			xpath = "//select[@id='id_clave_embalaje_material_peligroso']"

		else if (element == 'options_clave_embalaje_material_peligroso')
			xpath = "//select[@id='id_clave_embalaje_material_peligroso']/option"

		else if (element == 'input_comentarios')
			xpath = "//textarea[@id='id_comentarios']"

		else if (element == 'input_MU')
			xpath = "//input[@id='id_pls_margen_utilidad_porciento']"

		else if (element == 'input_precio')
			xpath = "//input[@id='id_pls_precio']"

		else if (element == 'select_moneda')
			xpath = "//select[@id='id_pls_moneda']"

		else if (element == 'options_moneda')
			xpath = "//select[@id='id_pls_moneda']/option"

		else if (element == 'cerrar_unidad_medida')
			xpath = "//div[@id='UmsTabContent']//a"

		else if (element == 'agregar_unidad_medida')
			xpath = "//div[@id='UmsTabContent']//a[@class='add-row btn btn-default btn-sm slim_button']"

		else if (element == 'input_unidad_medida')
			xpath = "//input[@id='id_um-0-um']"

		else if (element == 'validate_unidad_medida')
			xpath = "//input[@id='id_um-0-um']//preceding-sibling::span"

		else if (element == 'opcion_unidad_medida')
			xpath = "//input[@id='id_um-0-um']/following-sibling::*[1]/li/a"

		else if (element == 'input_factor')
			xpath = "//input[@id='id_um-0-factor']"

		else if (element == 'input_codigo_barra')
			xpath = "//input[@id='id_um-0-codigo_barras']"

		else if (element == 'input_base')
			xpath = "//input[@id='id_um-0-base']"

		else if (element == 'input_altura')
			xpath = "//input[@id='id_um-0-altura']"

		else if (element == 'input_profundidad')
			xpath = "//input[@id='id_um-0-profundidad']"

		else if (element == 'input_peso')
			xpath = "//input[@id='id_um-0-peso']"

		else if (element == 'check_selec_compra')
			xpath = "//input[@id='id_um-0-seleccionado_compra']"

		else if (element == 'check_selec_venta')
			xpath = "//input[@id='id_um-0-seleccionado']"

		else if (element == 'check_kardex')
			xpath = "//input[@id='id_um-0-um_kardex']"

		else if (element == 'cerrar_lista_precio')
			xpath = "//div[@id='listaPreciosProvTabContent']//a[@class='delete-row text-danger']"

		else if (element == 'agregar_lista_precio')
			xpath = "//div[@id='listaPreciosProvTabContent']//a[@class='add-row btn btn-default btn-sm slim_button']"

		else if (element == 'boton_lista_precios_proveedores')
			xpath = "//a[contains(@href, '#listaPreciosProvTabContent')]"

		else if (element == 'input_lista_precios_cod_proveedor')
			xpath = "//input[@id='id_monedas-0-codigo']"

		else if (element == 'input_lista_precios_proveedor')
			xpath = "//input[@id='id_monedas-0-proveedor']"

		else if (element == 'validate_proveedor')
			xpath = "//input[@id='id_monedas-0-proveedor']//preceding-sibling::span"

		else if (element == 'opcion_lista_precios_proveedor')
			xpath = "//input[@id='id_monedas-0-proveedor']/following-sibling::*[1]/li/a"

		else if (element == 'input_lista_precios_fecha')
			xpath = "//input[@id='id_monedas-0-fecha']"

		else if (element == 'input_lista_precios_lista_proveedor')
			xpath = "//input[@id='id_monedas-0-precio_lista']"

		else if (element == 'input_lista_precios_inc')
			xpath = "//input[@id='id_monedas-0-flete']"

		else if (element == 'input_lista_precios_moneda')
			xpath = "//select[@id='id_monedas-0-moneda']"

		else if (element == 'input_lista_precios_multiplo_compra')
			xpath = "//input[@id='id_monedas-0-multiplo_compra']"

		else if (element == 'check_lista_precios_select')
			xpath = "//input[@id='id_monedas-0-seleccionado']/following-sibling::*[1]"

		else if (element == 'tab_ensamble')
			xpath = "//a[contains(@href, '#prodsEnsambleTabContent')]"

		else if (element == 'input_ensamble_producto')
			xpath = "//input[@id='id_ensambles-0-parte']"

		else if (element == 'validate_ensamble_producto')
			xpath = "//input[@id='id_ensambles-0-parte']//preceding-sibling::span"

		else if (element == 'option_ensamble_producto')
			xpath = "//input[@id='id_ensambles-0-parte']/following-sibling::*[3]/li/a"

		else if (element == 'input_ensamble_cantidad')
			xpath = "//input[@id='id_ensambles-0-cantidad']"

		else if (element == 'input_ensamble_unidad')
			xpath = "//input[@id='id_ensambles-0-um']"

		else if (element == 'validate_ensamble_unidad')
			xpath = "//input[@id='id_ensambles-0-um']//preceding-sibling::span"

		else if (element == 'opcion_ensamble_unidad')
			xpath = "//input[@name='ensambles-0-um']/following-sibling::*[1]/li/a"

		else if (element == 'tab_relacionados')
			xpath = "//a[contains(@href, '#relacionadosTabContent')]"

		else if (element == 'input_conceptos_relacionados')
			xpath = "//input[@name='conceptos_relacionados']"

		else if (element == 'input_productos_complementarios')
			xpath = "//input[@id='id_complementario-0-complemento']"

		else if (element == 'validate_productos_complementarios')
			xpath = "//input[@id='id_complementario-0-complemento']//preceding-sibling::span"

		else if (element == 'option_productos_complementarios')
			xpath = "//input[@id='id_complementario-0-complemento']/following-sibling::*[1]/li/a"

		else if (element == 'input_alternativos')
			xpath = "//input[@id='id_alternativos-0-producto_alt']"

		else if (element == 'validate_alternativos')
			xpath = "//input[@id='id_alternativos-0-producto_alt']//preceding-sibling::span"

		else if (element == 'option_alternativos')
			xpath = "//input[@id='id_alternativos-0-producto_alt']/following-sibling::*[1]/li/a"

		else if (element == 'tab_tags')
			xpath = "//a[contains(@href, '#tagsTabContent')]"

		else if (element == 'input_tag')
			xpath = "//input[@id='id_tags-0-tag']"

		else if (element == 'validate_tag')
			xpath = "//input[@id='id_tags-0-tag']//preceding-sibling::span"

		else if (element == 'option_tag')
			xpath = "//input[@id='id_tags-0-tag']/following-sibling::*[1]/li/a"

		else if (element == 'tab_consumibles')
			xpath = "//a[contains(@href, '#consumiblesTabContent')]"

		else if (element == 'input_consumibles')
			xpath = "//input[@id='id_consumibles-0-producto_txt']"

		else if (element == 'validate_consumibles')
			xpath = "//input[@id='id_consumibles-0-producto_txt']//preceding-sibling::span"

		else if (element == 'options_consumibles')
			xpath = "//input[@id='id_consumibles-0-producto_txt']/following-sibling::*[1]/li/a"

		else if (element == 'tab_refacciones')
			xpath = "//a[contains(@href, '#refaccionesTabContent')]"

		else if (element == 'input_refacciones')
			xpath = "//input[@id='id_refacciones-0-producto_txt']"

		else if (element == 'validate_input_refacciones')
			xpath = "//input[@id='id_refacciones-0-producto_txt']//preceding-sibling::span"

		else if (element == 'options_input_refacciones')
			xpath = "//input[@id='id_refacciones-0-producto_txt']/following-sibling::*[1]/li/a"

		else if (element == 'guardar_form')
			xpath = "(//button[@id='guardar'])[2]"

		else if (element == 'input_buscar_texto')
			xpath = "//input[@id='id_q']"

		else if (element == 'button_buscar_texto')
			xpath = "//button[@value='Buscar']"

		else if (element == 'first_prod_table')
			xpath = "(//a[contains(@href, '/admin/inventario/ver_producto')])[1]"

		else if (element == 'edit_producto')
			xpath = "//a[contains(@href, '/admin/producto/edit/')]"

		else if (element == 'input_buscar_tipoproducto')
			xpath = "//select[@id='id_tipo_producto']"

		else if (element == 'boton_eliminar_prod')
			xpath = "(//a[contains(@onclick, '/admin/delete/producto/')])[1]"

		else if (element == 'input_motivo_eliminar')
			xpath = "//input[@id='id_cancelacion-motivo_cancelacion']"

		else if (element == 'button_aceptar')
			xpath = "//button[contains(@onclick, 'enviarCancelacion')]"

		TestObject newElement = new TestObject().addProperty('xpath', ConditionType.EQUALS, xpath)
		return newElement
	}
}
