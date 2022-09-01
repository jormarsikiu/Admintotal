package keyword_login

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
/**
 *Esta clase contiene los elementos dinámicos web (xpath) del formulario para el login.
 *Es usada para las siguientes rutas de formularios:
 *@linkplain https://kaizen.admintotal.com/admin/login
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

		if (element == 'input_username')
			xpath = "//input[@name='username']"

		else if (element == 'input_password')
			xpath = "//input[@name='password']"

		else if (element == 'button_entrar')
			xpath = "//button[@type='submit']"

		else if (element == 'error_msg')
			xpath = "//div[@class='form-message error']"

		TestObject newElement = new TestObject().addProperty('xpath', ConditionType.EQUALS, xpath)
		return newElement
	}
}