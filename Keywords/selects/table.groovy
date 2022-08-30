package selects

import com.kms.katalon.core.annotation.Keyword
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject

public class table {

	@Keyword
	def findtextintable(String xpath, String ExpectedValue) {

		'Guarda las filas de la tabla - tr'
		List<WebElement> rows_table =  WebUiCommonHelper.findWebElements(new compra.xpath_dynamic().object(xpath), 30)

		'Guarda el tamano de las filas'
		int rows_count = rows_table.size()

		'Loop para recorrer las filas de la tabla'
		Loop:
		for (int row = 0; row < rows_count; row++) {
			'Guarda las columnas de la tabla - td'
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName('td'))

			'Guarda el tamano de las columnas'
			int columns_count = Columns_row.size()

			'Loop para recorrer las columnas '
			for (int column = 0; column < columns_count; column++) {
				'Guarda el texto de cada celda'
				String celltext = Columns_row.get(column).getText()

				'Comprueba de el valor de la celda es el valor esperado'
				if (celltext == ExpectedValue) {
					'Da click en la celda correspondiente'
					Columns_row.get(0).findElement(By.tagName('a')).click()

					'Luego de encontrar el elemento cerrar el Loop'
					break Loop;
				}
			}
		}
	}

	@Keyword
	def findheaderintable(String xpath, String ExpectedValue) {

		'Guarda las filas de la tabla - tr'
		List<WebElement> rows_table =  WebUiCommonHelper.findWebElements(new compra.xpath_dynamic().object(xpath), 30)

		'Guarda el tamano de las filas'
		int rows_count = rows_table.size()

		'Loop para recorrer las filas de la tabla'
		Loop:
		for (int row = 0; row < rows_count; row++) {
			'Guarda las columnas de la tabla - th'
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName('span'))

			'Guarda el tamano de las columnas'
			int columns_count = Columns_row.size()

			'Loop para recorrer las columnas '
			for (int column = 0; column < columns_count; column++) {
				'Guarda el texto de cada celda'
				String celltext = Columns_row.get(column).getText()

				'Comprueba de el valor de la celda es el valor esperado'
				if (celltext == ExpectedValue) {
					'Da click en la celda correspondiente'
					return true;

					'Luego de encontrar el elemento cerrar el Loop'
					break Loop;
				}
				else {
					return false;
				}
			}
		}
	}
}