package ordenCompra

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

		if  (elemento == 'T.C')
			aleatoryData= RandomStringUtils.randomNumeric(1)

		else if (elemento == 'cantidad')
			aleatoryData= RandomStringUtils.randomNumeric(2)

		else if (elemento == 'fecha_entrega') {
			Date todaysDate = new Date()
			def dayPart = todaysDate[Calendar.DAY_OF_MONTH] + 1;
			aleatoryData= dayPart.toString()
		}

		else if (elemento == 'comentario')
			aleatoryData= 'Automatizacion > Comentario de Orden de Compra'

		return aleatoryData
	}
}
