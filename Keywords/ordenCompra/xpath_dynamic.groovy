package ordenCompra

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject

import internal.GlobalVariable

public class xpath_dynamic {

	@Keyword
	def object(String elemento) {

		String xpath = ''

		if (elemento == 'boton_entradas_almacen')
			xpath = "//a[@class='singleclick link-entradas submenu']"

		else if (elemento == 'boton_orden_compra')
			xpath = "//a[@class='singleclick link-ordenes_compra menu_option']"

		else if (elemento == 'boton_agregar_orden_compra')
			xpath = "//a[contains(@href, '/admin/inventario/agregar_orden_compra/')]"

		else if (elemento == 'input_proveedor')
			xpath = "//input[@id='id_proveedor']"

		else if (elemento == 'input_first_proveedor')
			xpath = "(//li[@class='ui-menu-item'])[1]/a"

		else if (elemento == 'input_entregar_a')
			xpath = "//input[@id='id_direccion_entrega']"

		else if (elemento == 'input_first_entregar_a')
			xpath = "(//li[@class='ui-menu-item'])[2]/a"

		else if (elemento == 'check_recoger_a_dormicilio')
			xpath = "//input[@id='id_entregar_domicilio']/following-sibling::*[1]"

		else if (elemento == 'input_fecha_entrega')
			xpath = "//input[@id='id_fecha_entrega']"

		else if (elemento == 'button_aceptar_modal')
			xpath = "(//div[@class='ui-dialog-buttonset'])/button[1]"

		else if (elemento == 'input_producto')
			xpath = "//input[@id='id_form-0-producto']"

		else if (elemento == 'input_first_producto')
			xpath = "(//li[@class='ui-menu-item'])[3]/a"
			
		else if (elemento == 'input_cantidad')
			xpath = "id_form-0-cantidad"
			


		TestObject to = new TestObject().addProperty('xpath', ConditionType.EQUALS, xpath)
		return to
	}
}
