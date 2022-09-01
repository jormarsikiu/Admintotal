package keyword_productos

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils

import internal.GlobalVariable
/**
 *Esta clase contiene los datos aleatorios para el formulario para el crud de productos.
 *El método busca una cadena que es el nombre del element,
 *al encontrarlo genera una variable aleatoria,
 *RandomStringUtils es la libreria para datos aleatorios,
 *randomNumeric(2) genera un numero con dos digitos: 52,
 *randomAlphabetic(2) genera una cadena dos caracteres: Ab.
 *Arrays.asList selecciona solo un valor aleatorio de los incluidos en la lista
 *Este método es usado en la rutas de formularios siguientes:
 *@linkplain (1) https://kaizen.admintotal.com/admin/agregar_producto/
 *@linkplain (2) https://kaizen.admintotal.com/admin/inventario/catalogos/productos/
 *@linkplain (3) https://kaizen.admintotal.com/admin/producto/edit/
 *@linkplain (4) https://kaizen.admintotal.com/admin/delete/producto/
 *@author Grupo KAIZEN
 *@since 2022
 */
public class data_aleatory {
	/**
	 *Genera datos aleatorios para incluir en los elements
	 *@param element es un nombre que se le asigna al element para buscarlo
	 *@return aleatoryData es una cadena compuesta por números, letras o alfanumericos
	 */
	@Keyword
	def String getAleatotyData(String element){

		Random random = new Random()

		String aleatoryData = ''

		/**
		 * El tipo de producto son:
		 * 0- Articulo
		 * 1- Materia Prima
		 * 2- Ensamble
		 * 3- Servicio
		 * 4- Activo Fijo
		 * 5- Servicios Subcontratados
		 * 7- Producción
		 * 8- Ensamble dinamico
		 * 9- Mano de obra
		 * 10- Artículo para arrendamiento
		 */
		if (element == 'tipo_producto') {
			List randomObjects = Arrays.asList('0', '1', '3', '5', '4', '7', '9', '10')
			String randomPath = randomObjects.get(new Random().nextInt(randomObjects.size()))
			aleatoryData = randomPath
		}

		else if (element == 'codigo_busqueda')
			aleatoryData = RandomStringUtils.randomAlphabetic(1)

		else if (element == 'clave_prod_serv')
			aleatoryData= RandomStringUtils.randomNumeric(1)

		else if (element == 'codigo')
			aleatoryData= RandomStringUtils.randomAlphabetic(4)

		else if (element == 'textogenerico')
			aleatoryData= "Automatizacion "+ RandomStringUtils.randomNumeric(4)

		else if (element == 'letra') {
			List randomObjects = Arrays.asList('a', 'e', 'i', 'o', 'u')
			String randomPath = randomObjects.get(new Random().nextInt(randomObjects.size()))
			aleatoryData = randomPath
		}

		else if (element == 'imagenURL')
			aleatoryData= "https://kaizen.admintotal.com/site_media_b/img/logo_azul_blanco.png"

		else if (element == 'cuota')
			aleatoryData= RandomStringUtils.randomNumeric(4)

		else if (element == 'retencionisr') {
			List randomObjects = Arrays.asList('0.1', '0.2', '0.3', '0.4', '0.5')
			String randomPath = randomObjects.get(new Random().nextInt(randomObjects.size()))
			aleatoryData = randomPath
		}

		else if (element == 'factor_conversion') {
			List randomObjects = Arrays.asList('0.1', '0.2', '0.3', '0.4', '0.5')
			String randomPath = randomObjects.get(new Random().nextInt(randomObjects.size()))
			aleatoryData = randomPath
		}

		else if (element == 'codigo_origen')
			aleatoryData= RandomStringUtils.randomNumeric(4)

		else if (element == 'costo_reposicion')
			aleatoryData= RandomStringUtils.randomNumeric(4)

		else if (element == 'margen_utilidad_porciento')
			aleatoryData= RandomStringUtils.randomNumeric(5)

		else if (element == 'precio')
			aleatoryData= RandomStringUtils.randomNumeric(5)

		else if (element == 'factor'){
			List randomObjects = Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9')
			String randomPath = randomObjects.get(new Random().nextInt(randomObjects.size()))
			aleatoryData = randomPath
		}

		else if (element == 'codigo_barra')
			aleatoryData= RandomStringUtils.randomNumeric(13)

		else if (element == 'medidas')
			aleatoryData= RandomStringUtils.randomNumeric(2)

		else if (element == 'relacionados')
			aleatoryData= 'Relacionados' + RandomStringUtils.randomNumeric(5)

		return aleatoryData
	}
}
