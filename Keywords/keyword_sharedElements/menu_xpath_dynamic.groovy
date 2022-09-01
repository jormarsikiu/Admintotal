package keyword_sharedElements

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import internal.GlobalVariable
/**
 *Esta clase contiene los elementos dinámicos web (xpath) del formulario del menu lateral.
 *@author Grupo KAIZEN
 *@since 2022
 */
public class menu_xpath_dynamic {

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

		if (element == 'boton_inventario')
			xpath = "//a[@class='singleclick link-inventario']"

		else if (element == 'boton_catalogo')
			xpath = "//a[@class='singleclick link-catalogos submenu']"

		else if (element == 'boton_productos')
			xpath = "//a[@class='singleclick link-productos menu_option']"

		if (element == 'boton_entradas_almacen')
			xpath = "//a[@class='singleclick link-entradas submenu']"

		else if (element == 'boton_orden_compra')
			xpath = "//a[@class='singleclick link-ordenes_compra menu_option']"

		else if (element == 'boton_compras')
			xpath = "//a[@class='singleclick link-compras menu_option']"

		else if (element == 'condicion')
			xpath = "//select[@id='id_condicion']"


		TestObject newElement = new TestObject().addProperty('xpath', ConditionType.EQUALS, xpath)
		return newElement
	}
}
