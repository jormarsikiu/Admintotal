package productos

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils

import internal.GlobalVariable

public class data_aleatory {

	@Keyword
	def String getAleatotyData(String elemento){

		Random random = new Random()

		String aleatoryData = ''

		if (elemento == 'codigo_busqueda')
			aleatoryData = RandomStringUtils.randomAlphabetic(1)

		else if (elemento == 'clave_prod_serv')
			aleatoryData= RandomStringUtils.randomNumeric(1)

		else if (elemento == 'codigo')
			aleatoryData= RandomStringUtils.randomAlphabetic(4)

		else if (elemento == 'textogenerico')
			aleatoryData= "Automatizacion "+ RandomStringUtils.randomNumeric(4)

		else if (elemento == 'letra') {
			List randomObjects = Arrays.asList('a', 'e', 'i', 'o', 'u')
			String randomPath = randomObjects.get(new Random().nextInt(randomObjects.size()))
			aleatoryData = randomPath
		}

		else if (elemento == 'imagenURL')
			aleatoryData= "https://kaizen.admintotal.com/site_media_b/img/logo_azul_blanco.png"

		else if (elemento == 'cuota')
			aleatoryData= RandomStringUtils.randomNumeric(4)

		else if (elemento == 'retencionisr') {
			List randomObjects = Arrays.asList('0.1', '0.2', '0.3', '0.4', '0.5')
			String randomPath = randomObjects.get(new Random().nextInt(randomObjects.size()))
			aleatoryData = randomPath
		}

		else if (elemento == 'factor_conversion') {
			List randomObjects = Arrays.asList('0.1', '0.2', '0.3', '0.4', '0.5')
			String randomPath = randomObjects.get(new Random().nextInt(randomObjects.size()))
			aleatoryData = randomPath
		}

		else if (elemento == 'codigo_origen')
			aleatoryData= RandomStringUtils.randomNumeric(4)

		else if (elemento == 'costo_reposicion')
			aleatoryData= RandomStringUtils.randomNumeric(4)

		else if (elemento == 'margen_utilidad_porciento')
			aleatoryData= RandomStringUtils.randomNumeric(5)

		else if (elemento == 'precio')
			aleatoryData= RandomStringUtils.randomNumeric(5)

		else if (elemento == 'factor'){
			List randomObjects = Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9')
			String randomPath = randomObjects.get(new Random().nextInt(randomObjects.size()))
			aleatoryData = randomPath
		}

		else if (elemento == 'codigo_barra')
			aleatoryData= RandomStringUtils.randomNumeric(13)

		else if (elemento == 'medidas')
			aleatoryData= RandomStringUtils.randomNumeric(2)

		else if (elemento == 'relacionados')
			aleatoryData= 'Relacionados' + RandomStringUtils.randomNumeric(5)

		return aleatoryData
	}
}
