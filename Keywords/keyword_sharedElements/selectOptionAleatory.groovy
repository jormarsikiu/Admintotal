package keyword_sharedElements

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement
import internal.GlobalVariable
/**
 *Esta clase permite seleccionar valores aleatorios de un select
 *@author Grupo KAIZEN
 *@since 2022
 */
public class selectOptionAleatory {

	/**
	 *Este método busca los selects en las Keywords xpath,
	 *al encontrarlos elimina del select todos los values que esten vacios,
	 *muestra cuantos elementos tiene el select,
	 *selecciona y presiona un aleatorio de las opciones del select.
	 *Puede ser usado para selects con tamaño limitado y selects con tamaño personalizado.
	 *@param element es el nombre que tiene asignado el xpath en los keyword
	 *@param num es un identificador para determinar en que archivo keyword buscar
	 *@return value es el valor de la variable global
	 */

	@Keyword
	def aleatoryobject(String element, String num) {

		List<WebElement> elements

		if (num == '1') {
			elements = WebUiCommonHelper.findWebElements(new keyword_productos.xpath_dynamic().getObject(element), 30)
		}

		else if (num == '2') {
			elements = WebUiCommonHelper.findWebElements(new keyword_ordenCompra.xpath_dynamic().getObject(element), 30)
		}

		else if (num == '3') {
			elements = WebUiCommonHelper.findWebElements(new keyword_compra.xpath_dynamic().getObject(element), 30)
		}

		//Elimina todos los vacios del select
		for(int i = 0; i<elements.size() ;i++) {
			if (elements.get(i).getAttribute("value") == '')
				elements.remove(i)
			String elementText = elements.get(i).getAttribute("value");
			//System.out.println(elementText);
		}

		WebUI.comment("Select tiene ${elements.size()} elementos!")
		WebElement randomElement = elements.get(new Random().nextInt(elements.size()))
		randomElement.click();
	}
}

