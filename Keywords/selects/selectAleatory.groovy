package selects

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement
import internal.GlobalVariable

public class selectAleatory {


	@Keyword
	def aleatoryobject(String elemento, String num) {

		List<WebElement> elements

		if (num == '1') {
			elements = WebUiCommonHelper.findWebElements(new productos.xpath_dynamic().object(elemento), 30)
		}

		else if (num == '2') {
			elements = WebUiCommonHelper.findWebElements(new ordenCompra.xpath_dynamic().object(elemento), 30)
		}

		else if (num == '3') {
			elements = WebUiCommonHelper.findWebElements(new compra.xpath_dynamic().object(elemento), 30)
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

