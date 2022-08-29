package compra

import com.kms.katalon.core.annotation.Keyword
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import internal.GlobalVariable

public class data_aleatory {

	@Keyword
	def String getAleatotyData(String elemento){

		Random random = new Random()

		String aleatoryData = ''

		if  (elemento == 'no_factura')
			aleatoryData= RandomStringUtils.randomAlphabetic(2) + RandomStringUtils.randomNumeric(5)

		else if (elemento == 'no_unidades')
			aleatoryData= RandomStringUtils.randomNumeric(2)

		else if (elemento == 'descuento')
			aleatoryData= RandomStringUtils.randomNumeric(2)

		else if (elemento == 'fletes')
			aleatoryData= RandomStringUtils.randomNumeric(2)

		else if (elemento == 'comentarios')
			aleatoryData= 'Automatizacion > Agregar Compra'

		return aleatoryData
	}
}
