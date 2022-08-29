package menu

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject

import internal.GlobalVariable

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

		if (elemento == 'boton_entradas_almacen')
			xpath = "//a[@class='singleclick link-entradas submenu']"

		else if (elemento == 'boton_orden_compra')
			xpath = "//a[@class='singleclick link-ordenes_compra menu_option']"

		else if (elemento == 'boton_compras')
			xpath = "//a[@class='singleclick link-compras menu_option']"
			
		else if (elemento == 'condicion')
			xpath = "//select[@id='id_condicion']"


		TestObject to = new TestObject().addProperty('xpath', ConditionType.EQUALS, xpath)
		return to
	}
}
