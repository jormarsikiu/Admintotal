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


public class data {

	@Keyword
	def String getAleatotyData(String elemento){

		Random random = new Random()

		String aleatoryData = ''
		
		if (elemento == 'codigo_busqueda')
			aleatoryData = '1'

		//Codigo aleatorio de 7 numeros
		if (elemento == 'codigo')
			aleatoryData= RandomStringUtils.randomNumeric(7)

		//Tipo de Producto del 0 al 10 excluyendo el 6 
		else if (elemento == 'tipo')
		{
			List randomObjects = Arrays.asList('0', '1', '2', '3', '4', '5', '7', '8', '9', '10')
			String randomPath = randomObjects.get(new Random().nextInt(randomObjects.size()))
			aleatoryData = randomPath
		}

		//Texto generico + 4 numeros
		else if (elemento == 'textogenerico')
			aleatoryData= "Producto nuevo "+ random.nextInt(10).toString()

		//Margen del 0 al 2
		else if (elemento == 'margen')
			aleatoryData= String.valueOf(new Random().nextInt(2 - 0))

		//IVA del 0 al 2
		else if (elemento == 'iva')
			aleatoryData= String.valueOf(new Random().nextInt(2 - 0))
			
		//Valores del IEPS 3.00, 6.00...'
		else if (elemento == 'ieps') {
			List randomObjects = Arrays.asList('3.00', '6.00', '7.00', '8.00', '9.00', '25.00', '26.50', '30.00', '30.40', '50.00', '53.00', '160.00', '9999.00')
			String randomPath = randomObjects.get(new Random().nextInt(randomObjects.size()))
			aleatoryData = randomPath
		}
			
		//Cuota IEPS 4 numeros
		else if (elemento == 'cuota')
			aleatoryData= RandomStringUtils.randomNumeric(4)
			
		//Tipo IEPS del 1 al 2	
		else if (elemento == 'tipoieps')
			{
			List randomObjects = Arrays.asList('1', '2')
			String randomPath = randomObjects.get(new Random().nextInt(randomObjects.size()))
			aleatoryData = randomPath
		}

		//Retencion IVA > Valores
		else if (elemento == 'retencioniva')
			{
			List randomObjects = Arrays.asList('0.000000', '18.750000', '25.000000', '37.500000', '50.000000', '66.666670', '100.000000')
			String randomPath = randomObjects.get(new Random().nextInt(randomObjects.size()))
			aleatoryData = randomPath
		}
		
		//Retencion ISR - input > Pueden cambiarse.'
		else if (elemento == 'retencionisr') {
			List randomObjects = Arrays.asList('0.1', '0.2', '0.3', '0.4', '0.5')
			String randomPath = randomObjects.get(new Random().nextInt(randomObjects.size()))
			aleatoryData = randomPath
		}

		return aleatoryData
	}
}
