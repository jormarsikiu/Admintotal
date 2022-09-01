package keyword_ordenCompra

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject

import internal.GlobalVariable
/**
 *Esta clase contiene los elementos dinámicos web (xpath) del formulario para el crud de Orden de Compra.
 *Es usada para las siguientes rutas de formularios:
 *@linkplain (1) https://kaizen.admintotal.com/admin/inventario/entradas/ordenes_compra/
 *@linkplain (2) https://kaizen.admintotal.com/admin/inventario/agregar_orden_compra/
 *@linkplain (3) https://kaizen.admintotal.com/admin/inventario/entradas/ordenes_compra/
 *@linkplain (4) https://kaizen.admintotal.com/admin/inventario/editar_orden_compra/
 *
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

		if (element == 'boton_agregar_orden_compra')
			xpath = "//a[contains(@href, '/admin/inventario/agregar_orden_compra/')]"

		else if (element == 'input_fecha_entrega')
			xpath = "//input[@id='id_fecha_entrega']"

		else if (element == 'input_proveedor')
			xpath = "//input[@id='id_proveedor']"

		else if (element == 'opcions_proveedor')
			xpath = "(//li[@class='ui-menu-item'])[1]/a"

		else if (element == 'input_entregar_a')
			xpath = "//input[@id='id_direccion_entrega']"

		else if (element == 'opcions_entregar_a')
			xpath = "(//li[@class='ui-menu-item'])[2]/a"

		else if (element == 'input_fecha_entrega')
			xpath = "//input[@id='id_fecha_entrega']"

		else if (element == 'select_hora_de')
			xpath = "//select[@id='id_hora_entrega_a']"

		else if (element == 'opcions_hora_de')
			xpath = "//select[@id='id_hora_entrega_a']/option"

		else if (element == 'select_hora_hasta')
			xpath = "//select[@id='id_hora_entrega_b']"

		else if (element == 'opcions_hora_hasta')
			xpath = "//select[@id='id_hora_entrega_b']/option"

		else if (element == 'button_aceptar_modal')
			xpath = "(//div[@class='ui-dialog-buttonset'])/button[1]"

		else if (element == 'check_recoger_a_dormicilio')
			xpath = "//input[@id='id_entregar_domicilio']/following-sibling::*[1]"

		else if (element == 'select_moneda')
			xpath = "//select[@id='id_moneda']"

		else if (element == 'options_moneda')
			xpath = "//select[@id='id_moneda']/option"

		else if (element == 'input_T_C')
			xpath = "//input[@id='id_cambio']"

		else if (element == 'select_condicion')
			xpath = "//select[@id='id_condicion']"

		else if (element == 'options_condicion')
			xpath = "//select[@id='id_condicion']/option"

		else if (element == 'select_cfdi')
			xpath = "//select[@id='id_uso_cfdi']"

		else if (element == 'options_cfdi')
			xpath = "//select[@id='id_uso_cfdi']/option"

		else if (element == 'input_producto')
			xpath = "//input[@id='id_form-0-producto']"

		else if (element == 'options_producto')
			xpath = "(//li[@class='ui-menu-item'])[3]/a"

		else if (element == 'input_cantidad')
			xpath = "//input[@id='id_form-0-cantidad']"

		else if (element == 'input_fecha')
			xpath = "//input[@id='id_form-0-fecha_entrega']"

		else if (element == 'textarea_comentario')
			xpath = "//textarea[@id='id_comentarios']"

		else if (element == 'guardar_form')
			xpath = "(//input[@value='Guardar'])[2]"

		else if (element == 'id_folio')
			xpath = "(//div[@class='col-md-12'])[2]/table/tbody/tr/td"

		else if (element == 'fecha_desde')
			xpath = "//input[@id='id_desde']"

		else if (element == 'fecha_hasta')
			xpath = "//input[@id='id_hasta']"

		else if (element == 'button_buscar')
			xpath = "(//button[@class='btn btn-primary'])[1]"

		else if (element == 'first_oc_table')
			xpath = "(//a[contains(@href, 'admin/ver_orden_compra')])[1]"

		else if (element == 'edit_oc')
			xpath = "//a[contains(@href, '/admin/inventario/editar_orden_compra/')]"

		else if (element == 'guardar_editar')
			xpath = "(//input[@value='Guardar'])"

		else if (element == 'eliminar_ocr')
			xpath = "(//a[contains(@onclick, '/admin/delete/movimiento/orden_compra/')])[1]"

		else if (element == 'input_motivo_eliminar')
			xpath = "//input[@id='id_cancelacion-motivo_cancelacion']"

		else if (element == 'button_aceptar')
			xpath = "//button[contains(@onclick, 'enviarCancelacion')]"


		TestObject newElement = new TestObject().addProperty('xpath', ConditionType.EQUALS, xpath)
		return newElement
	}
}
