package compra

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject

import internal.GlobalVariable

public class xpath_dynamic {

	@Keyword
	def object(String elemento) {

		String xpath = ''

		if (elemento == 'boton_agregar_compra')
			xpath = "//a[contains(@href, '/admin/inventario/agregar_compra/')]"

		else if (elemento == 'check_fecha_anterior')
			xpath = "//input[@id='id_usar_fecha_anterior']/following-sibling::*[1]"

		else if (elemento == 'input_proveedor')
			xpath = "//input[@id='id_proveedor']"

		else if (elemento == 'modal')
			xpath = "//div[@aria-describedby='ordenes_dialog']"

		else if (elemento == 'input_entregar_a')
			xpath = "//input[@id='id_direccion_entrega_txt']"

		else if (elemento == 'table_orden_compra')
			xpath = "//div[@id='ordenes_dialog']/table/tbody/tr"

		else if (elemento == 'input_no_factura')
			xpath = "//input[@id='id_folio_factura']"

		else if (elemento == 'guardar_form')
			xpath = "(//input[@value='Guardar'])"

		else if (elemento == 'select_condicion')
			xpath = "//select[@id='id_condicion']"

		else if (elemento == 'select_moneda')
			xpath = "//select[@id='id_moneda']"

		else if (elemento == 'check_incremental_sin_iva')
			xpath = "//input[@id='id_incremental_sin_iva']/following-sibling::*[1]"

		else if (elemento == 'input_no_unidades')
			xpath = "//input[@id='id_form-0-numero_unidades']"

		else if (elemento == 'input_descuento')
			xpath = "//input[@id='id_descuento_general']"

		else if (elemento == 'input_flete')
			xpath = "//input[@id='id_monto_fsa']"

		else if (elemento == 'input_comentarios')
			xpath = "//textarea[@id='id_comentarios']"

		else if (elemento == 'button_guardar')
			xpath = "//button[@value='Guardar']"


		TestObject to = new TestObject().addProperty('xpath', ConditionType.EQUALS, xpath)
		return to
	}
}

