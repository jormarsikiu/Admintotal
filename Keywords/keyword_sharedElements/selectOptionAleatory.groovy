package keyword_sharedElements

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement
import internal.GlobalVariable
import com.kms.katalon.core.testobject.TestObject as TestObject
/**
 *Esta clase permite seleccionar valores aleatorios de un select
 *@author Grupo KAIZEN
 *@since 2022
 */
public class selectOptionAleatory {

	/**
	 *Este método busca el select,
	 *al encontrarlos elimina los values que esten vacios,
	 *muestra cuantos elementos tiene el select,
	 *selecciona y presiona un aleatorio de las opciones del select.
	 *Puede ser usado para selects con tamaño limitado y selects con tamaño personalizado.
	 *@param element es el nombre del TestObject
	 */

	@Keyword
	def aleatoryobject(TestObject element) {

		List<WebElement> elements

		elements = WebUiCommonHelper.findWebElements(element, 30)

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

