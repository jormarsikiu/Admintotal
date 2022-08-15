package productos

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject

public class xpath_dynamic {

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

		else if (elemento == 'check_restringir_descuento')
			xpath = "//input[@id='id_restringir_descuento_autorizado']/following-sibling::*[1]"

		else if (elemento == 'check_restringir_decimales')
			xpath = "//input[@id='id_restringir_decimales']/following-sibling::*[1]"

		else if (elemento == 'check_habilitar_webhook')
			xpath = "//input[@id='id_habilitar_webhook']/following-sibling::*[1]"

		else if (elemento == 'check_integracion_rappi')
			xpath = "//input[@id='id_integracion_rappi']/following-sibling::*[1]"

		else if (elemento == 'check_pedidos_especiales')
			xpath = "//input[@id='id_solo_pedido']/following-sibling::*[1]"

		else if (elemento == 'check_venta_cd_cod_barras')
			xpath = "//input[@id='id_venta_cb_cantidad']/following-sibling::*[1]"

		else if (elemento == 'check_habilitar_bascula')
			xpath = "//input[@id='id_habilitar_bascula']/following-sibling::*[1]"

		else if (elemento == 'check_congelar_precios_venta')
			xpath = "//input[@id='id_congelar_precios_venta']/following-sibling::*[1]"

		else if (elemento == 'check_no_generar_comision')
			xpath = "//input[@id='id_no_generar_comision']/following-sibling::*[1]"

		else if (elemento == 'check_usa_doble_unidad')
			xpath = "//input[@id='id_usa_doble_unidad']/following-sibling::*[3]"

		else if (elemento == 'input_codigo')
			xpath = "//input[@id='id_codigo_sin_marca']"

		else if (elemento == 'input_clave_prod_serv')
			xpath = "//input[@id='id_clave_prod_serv']"

		else if (elemento == 'first_clave_prod_serv')
			xpath = "(//li[@class='ui-menu-item'])[1]/a"

		else if (elemento == 'select_tipo')
			xpath = "//select[@id='id_tipo']"

		else if (elemento == 'radio_tienda')
			xpath = "//input[@id='id_medio_distribucion_0']"

		else if (elemento == 'radio_web')
			xpath = "//input[@id='id_medio_distribucion_1']"

		else if (elemento == 'radio_ambos')
			xpath = "//input[@id='id_medio_distribucion_2']"

		else if (elemento == 'descripcion')
			xpath = '//input[@id="id_descripcion"]'

		else if (elemento == 'descripcioningles')
			xpath = '//input[@id="id_descripcion_ingles"]'

		else if (elemento == 'descripcionadicional')
			xpath = '//textarea[@id="id_texto_descripcion_adicional"]'

		else if (elemento == 'descripcionecommerce')
			xpath = '//textarea[@id="id_descripcion_ecommerce"]'

		else if (elemento == 'input_imagenURL')
			xpath = "//input[@id='id_imagen']"

		else if (elemento == 'input_imagenUpload')
			xpath = '//input[@id="id_imagen_adjunta"]'

		else if (elemento == 'input_linea')
			xpath = '//input[@id="id_linea"]'

		else if (elemento == 'validate_linea')
			xpath = "//input[@id='id_linea']//preceding-sibling::span"

		else if (elemento == 'input_firstlinea')
			xpath = "//input[@id='id_linea']/following-sibling::*[2]/li[1]/a"

		else if (elemento == 'input_sublinea')
			xpath = '//input[@id="id_sublinea"]'

		else if (elemento == 'input_lastsublinea')
			xpath = "(//div[@id='lightbox']/following-sibling::*[1])/li[last()]/a"

		else if (elemento == 'input_subsublinea')
			xpath = '//input[@id="id_subsublinea"]'

		else if (elemento == 'input_firstsubsublinea')
			xpath = "//div[@id='lightbox']/following-sibling::*[2]/li[last()]/a"

		else if (elemento == 'input_marca')
			xpath = '//input[@id="id_marca"]'

		else if (elemento == 'validate_marca')
			xpath = "//input[@id='id_marca']//preceding-sibling::span"

		else if (elemento == 'input_firstmarca')
			xpath = "//input[@id='id_marca']/following-sibling::*[2]/li/a"

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

		else if (elemento == 'check_no_generar_ieps')
			xpath = "//input[@id='id_deshabilitar_ieps_ventas']/following-sibling::*[1]"

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

		else if (elemento == 'select_nivel_comision')
			xpath = "//select[@id='id_nivel_comision']"

		else if (elemento == 'input_consumo_interno')
			xpath = "//input[@id='id_cuenta_consumo_interno']"

		else if (elemento == 'first_consumo_interno')
			xpath = "//input[@id='id_cuenta_consumo_interno']/following-sibling::*[3]/li/a"

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

		else if (elemento == 'cerrar_unidad_medida')
			xpath = "//div[@id='UmsTabContent']//a"

		else if (elemento == 'agregar_unidad_medida')
			xpath = "//div[@id='UmsTabContent']//a[@class='add-row btn btn-default btn-sm slim_button']"

		else if (elemento == 'input_unidad_medida')
			xpath = "//input[@id='id_um-0-um']"

		else if (elemento == 'validate_unidad_medida')
			xpath = "//input[@id='id_um-0-um']//preceding-sibling::span"

		else if (elemento == 'first_unidad_medida')
			xpath = "//input[@id='id_um-0-um']/following-sibling::*[1]/li/a"

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

		else if (elemento == 'cerrar_lista_precio')
			xpath = "//div[@id='listaPreciosProvTabContent']//a[@class='delete-row text-danger']"

		else if (elemento == 'agregar_lista_precio')
			xpath = "//div[@id='listaPreciosProvTabContent']//a[@class='add-row btn btn-default btn-sm slim_button']"

		else if (elemento == 'boton_lista_precios_proveedores')
			xpath = "//a[contains(@href, '#listaPreciosProvTabContent')]"

		else if (elemento == 'input_lista_precios_cod_proveedor')
			xpath = "//input[@id='id_monedas-0-codigo']"

		else if (elemento == 'input_lista_precios_proveedor')
			xpath = "//input[@id='id_monedas-0-proveedor']"

		else if (elemento == 'validate_proveedor')
			xpath = "//input[@id='id_monedas-0-proveedor']//preceding-sibling::span"

		else if (elemento == 'input_lista_precios_firstcod_proveedor')
			xpath = "//input[@id='id_monedas-0-proveedor']/following-sibling::*[1]/li/a"

		else if (elemento == 'input_lista_precios_fecha')
			xpath = "//input[@id='id_monedas-0-fecha']"

		else if (elemento == 'input_lista_precios_lista_proveedor')
			xpath = "//input[@id='id_monedas-0-precio_lista']"

		else if (elemento == 'input_lista_precios_inc')
			xpath = "//input[@id='id_monedas-0-flete']"

		else if (elemento == 'input_lista_precios_moneda')
			xpath = "//select[@id='id_monedas-0-moneda']"

		else if (elemento == 'input_lista_precios_multiplo_compra')
			xpath = "//input[@id='id_monedas-0-multiplo_compra']"

		else if (elemento == 'check_lista_precios_select')
			xpath = "//input[@id='id_monedas-0-seleccionado']/following-sibling::*[1]"

		else if (elemento == 'tab_ensamble')
			xpath = "//a[contains(@href, '#prodsEnsambleTabContent')]"

		else if (elemento == 'input_ensamble_producto')
			xpath = "//input[@id='id_ensambles-0-parte']"

		else if (elemento == 'validate_ensamble_producto')
			xpath = "//input[@id='id_ensambles-0-parte']//preceding-sibling::span"

		else if (elemento == 'last_ensamble_producto')
			xpath = "//input[@id='id_ensambles-0-parte']/following-sibling::*[3]/li/a"

		else if (elemento == 'input_ensamble_cantidad')
			xpath = "//input[@id='id_ensambles-0-cantidad']"

		else if (elemento == 'input_ensamble_unidad')
			xpath = "//input[@id='id_ensambles-0-um']"

		else if (elemento == 'validate_ensamble_unidad')
			xpath = "//input[@id='id_ensambles-0-um']//preceding-sibling::span"

		else if (elemento == 'first_ensamble_unidad')
			xpath = "//input[@name='ensambles-0-um']/following-sibling::*[1]/li/a"

		else if (elemento == 'tab_relacionados')
			xpath = "//a[contains(@href, '#relacionadosTabContent')]"

		else if (elemento == 'input_conceptos_relacionados')
			xpath = "//input[@name='conceptos_relacionados']"

		else if (elemento == 'input_productos_complementarios')
			xpath = "//input[@id='id_complementario-0-complemento']"

		else if (elemento == 'validate_productos_complementarios')
			xpath = "//input[@id='id_complementario-0-complemento']//preceding-sibling::span"

		else if (elemento == 'last_productos_complementarios')
			xpath = "//input[@id='id_complementario-0-complemento']/following-sibling::*[1]/li/a"

		else if (elemento == 'input_alternativos')
			xpath = "//input[@id='id_alternativos-0-producto_alt']"

		else if (elemento == 'validate_alternativos')
			xpath = "//input[@id='id_alternativos-0-producto_alt']//preceding-sibling::span"

		else if (elemento == 'last_alternativos')
			xpath = "//input[@id='id_alternativos-0-producto_alt']/following-sibling::*[1]/li/a"

		else if (elemento == 'tab_tags')
			xpath = "//a[contains(@href, '#tagsTabContent')]"

		else if (elemento == 'input_tag')
			xpath = "//input[@id='id_tags-0-tag']"

		else if (elemento == 'validate_tag')
			xpath = "//input[@id='id_tags-0-tag']//preceding-sibling::span"

		else if (elemento == 'last_tag')
			xpath = "//input[@id='id_tags-0-tag']/following-sibling::*[1]/li/a"

		else if (elemento == 'tab_consumibles')
			xpath = "//a[contains(@href, '#consumiblesTabContent')]"

		else if (elemento == 'input_consumibles')
			xpath = "//input[@id='id_consumibles-0-producto_txt']"

		else if (elemento == 'validate_consumibles')
			xpath = "//input[@id='id_consumibles-0-producto_txt']//preceding-sibling::span"

		else if (elemento == 'last_consumibles')
			xpath = "//input[@id='id_consumibles-0-producto_txt']/following-sibling::*[1]/li/a"

		else if (elemento == 'tab_refacciones')
			xpath = "//a[contains(@href, '#refaccionesTabContent')]"

		else if (elemento == 'input_refacciones')
			xpath = "//input[@id='id_refacciones-0-producto_txt']"

		else if (elemento == 'validate_input_refacciones')
			xpath = "//input[@id='id_refacciones-0-producto_txt']//preceding-sibling::span"

		else if (elemento == 'last_input_refacciones')
			xpath = "//input[@id='id_refacciones-0-producto_txt']/following-sibling::*[1]/li/a"

		else if (elemento == 'guardar_form')
			xpath = "(//button[@id='guardar'])[2]"

		else if (elemento == 'input_buscar_texto')
			xpath = "//input[@id='id_q']"

		else if (elemento == 'button_buscar_texto')
			xpath = "//button[@value='Buscar']"

		else if (elemento == 'first_prod_table')
			xpath = "(//a[contains(@href, '/admin/inventario/ver_producto')])[1]"




		TestObject to = new TestObject().addProperty('xpath', ConditionType.EQUALS, xpath)
		return to
	}
}
