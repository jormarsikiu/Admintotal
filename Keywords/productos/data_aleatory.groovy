package productos

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
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

		else if (elemento == 'tipo') {
			List randomObjects = Arrays.asList('0', '1', '2', '3', '4', '5', '7', '8', '9', '10')
			String randomPath = randomObjects.get(new Random().nextInt(randomObjects.size()))
			aleatoryData = randomPath
		}

		else if (elemento == 'tipoventa') {
			List randomObjects = Arrays.asList('1', '2', '3')
			String randomPath = randomObjects.get(new Random().nextInt(randomObjects.size()))
			aleatoryData = randomPath
		}

		else if (elemento == 'textogenerico')
			aleatoryData= "Automatizacion "+ RandomStringUtils.randomNumeric(4)

		else if (elemento == 'letra') {
			List randomObjects = Arrays.asList('a', 'e', 'i', 'o', 'u')
			String randomPath = randomObjects.get(new Random().nextInt(randomObjects.size()))
			aleatoryData = randomPath
		}

		else if (elemento == 'imagenURL')
			aleatoryData= "https://kaizen.admintotal.com/site_media_b/img/logo_azul_blanco.png"

		else if (elemento == 'margen')
			aleatoryData= String.valueOf(new Random().nextInt(2 - 0))

		else if (elemento == 'iva')
			aleatoryData= String.valueOf(new Random().nextInt(2 - 0))

		else if (elemento == 'ieps') {
			List randomObjects = Arrays.asList('3.00', '6.00', '7.00', '8.00', '9.00', '25.00', '26.50', '30.00', '30.40', '50.00', '53.00', '160.00', '9999.00')
			String randomPath = randomObjects.get(new Random().nextInt(randomObjects.size()))
			aleatoryData = randomPath
		}

		else if (elemento == 'cuota')
			aleatoryData= RandomStringUtils.randomNumeric(4)

		else if (elemento == 'tipoieps') {
			List randomObjects = Arrays.asList('1', '2')
			String randomPath = randomObjects.get(new Random().nextInt(randomObjects.size()))
			aleatoryData = randomPath
		}

		else if (elemento == 'retencioniva') {
			List randomObjects = Arrays.asList('0.000000', '18.750000', '25.000000', '37.500000', '50.000000', '66.666670', '100.000000')
			String randomPath = randomObjects.get(new Random().nextInt(randomObjects.size()))
			aleatoryData = randomPath
		}

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

		else if (elemento == 'tipo_servicio') {
			List randomObjects = Arrays.asList('3', '4', '5', '6', '7','8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '99')
			String randomPath = randomObjects.get(new Random().nextInt(randomObjects.size()))
			aleatoryData = randomPath
		}

		else if (elemento == 'grupo_activo') {
			List randomObjects = Arrays.asList('1', '2', '3')
			String randomPath = randomObjects.get(new Random().nextInt(randomObjects.size()))
			aleatoryData = randomPath
		}

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
