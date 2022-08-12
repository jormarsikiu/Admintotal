package login

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject

public class xpath_dynamic {

	@Keyword
	def object(String elemento) {

		String xpath = ''

		if (elemento == 'input_username')
			xpath = "//input[@name='username']"

		else if (elemento == 'input_password')
			xpath = "//input[@name='password']"

		else if (elemento == 'button_entrar')
			xpath = "//button[@type='submit']"

		else if (elemento == 'error_msg')
			xpath = "//div[@class='form-message error']"

		TestObject to = new TestObject().addProperty('xpath', ConditionType.EQUALS, xpath)
		return to
	}
}