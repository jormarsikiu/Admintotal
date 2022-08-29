package ordenCompra

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject

import internal.GlobalVariable

public class xpath_dynamic {

	@Keyword
	def object(String elemento) {

		String xpath = ''

		if (elemento == 'boton_agregar_orden_compra')
			xpath = "//a[contains(@href, '/admin/inventario/agregar_orden_compra/')]"

		else if (elemento == 'input_fecha_entrega')
			xpath = "//input[@id='id_fecha_entrega']"

		else if (elemento == 'input_proveedor')
			xpath = "//input[@id='id_proveedor']"

		else if (elemento == 'opcions_proveedor')
			xpath = "(//li[@class='ui-menu-item'])[1]/a"

		else if (elemento == 'input_entregar_a')
			xpath = "//input[@id='id_direccion_entrega']"

		else if (elemento == 'opcions_entregar_a')
			xpath = "(//li[@class='ui-menu-item'])[2]/a"

		else if (elemento == 'input_fecha_entrega')
			xpath = "//input[@id='id_fecha_entrega']"

		else if (elemento == 'select_hora_de')
			xpath = "//select[@id='id_hora_entrega_a']"

		else if (elemento == 'opcions_hora_de')
			xpath = "//select[@id='id_hora_entrega_a']/option"

		else if (elemento == 'select_hora_hasta')
			xpath = "//select[@id='id_hora_entrega_b']"

		else if (elemento == 'opcions_hora_hasta')
			xpath = "//select[@id='id_hora_entrega_b']/option"

		else if (elemento == 'button_aceptar_modal')
			xpath = "(//div[@class='ui-dialog-buttonset'])/button[1]"

		else if (elemento == 'check_recoger_a_dormicilio')
			xpath = "//input[@id='id_entregar_domicilio']/following-sibling::*[1]"

		else if (elemento == 'select_moneda')
			xpath = "//select[@id='id_moneda']"

		else if (elemento == 'options_moneda')
			xpath = "//select[@id='id_moneda']/option"

		else if (elemento == 'input_T_C')
			xpath = "//input[@id='id_cambio']"

		else if (elemento == 'select_condicion')
			xpath = "//select[@id='id_condicion']"

		else if (elemento == 'options_condicion')
			xpath = "//select[@id='id_condicion']/option"

		else if (elemento == 'select_cfdi')
			xpath = "//select[@id='id_uso_cfdi']"

		else if (elemento == 'options_cfdi')
			xpath = "//select[@id='id_uso_cfdi']/option"

		else if (elemento == 'input_producto')
			xpath = "//input[@id='id_form-0-producto']"

		else if (elemento == 'options_producto')
			xpath = "(//li[@class='ui-menu-item'])[3]/a"

		else if (elemento == 'input_cantidad')
			xpath = "//input[@id='id_form-0-cantidad']"

		else if (elemento == 'input_fecha')
			xpath = "//input[@id='id_form-0-fecha_entrega']"

		else if (elemento == 'textarea_comentario')
			xpath = "//textarea[@id='id_comentarios']"

		else if (elemento == 'guardar_form')
			xpath = "(//input[@value='Guardar'])[2]"

		else if (elemento == 'id_folio')
			xpath = "(//div[@class='col-md-12'])[2]/table/tbody/tr/td"

		else if (elemento == 'fecha_desde')
			xpath = "//input[@id='id_desde']"

		else if (elemento == 'fecha_hasta')
			xpath = "//input[@id='id_hasta']"

		else if (elemento == 'button_buscar')
			xpath = "(//button[@class='btn btn-primary'])[1]"

		else if (elemento == 'first_oc_table')
			xpath = "(//a[contains(@href, 'admin/ver_orden_compra')])[1]"

		else if (elemento == 'edit_oc')
			xpath = "//a[contains(@href, '/admin/inventario/editar_orden_compra/')]"

		else if (elemento == 'guardar_editar')
			xpath = "(//input[@value='Guardar'])"

		else if (elemento == 'eliminar_ocr')
			xpath = "(//a[contains(@onclick, '/admin/delete/movimiento/orden_compra/')])[1]"

		else if (elemento == 'input_motivo_eliminar')
			xpath = "//input[@id='id_cancelacion-motivo_cancelacion']"

		else if (elemento == 'button_aceptar')
			xpath = "//button[contains(@onclick, 'enviarCancelacion')]"


		TestObject to = new TestObject().addProperty('xpath', ConditionType.EQUALS, xpath)
		return to
	}
}
