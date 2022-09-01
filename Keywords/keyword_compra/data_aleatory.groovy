package keyword_compra

import com.kms.katalon.core.annotation.Keyword
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import internal.GlobalVariable

/**
 *Esta clase contiene los datos aleatorios para el formulario para el crud de compra. 
 *El método busca una cadena que es el nombre del elemento,
 *al encontrarlo genera una variable aleatoria,
 *RandomStringUtils es la libreria para datos aleatorios,
 *randomNumeric(2) genera un numero con dos digitos: 52,
 *randomAlphabetic(2) genera una cadena dos caracteres: Ab.
 *Este método es usado en la rutas de formularios siguientes:
 *@linkplain (1) https://kaizen.admintotal.com/admin/inventario/entradas/compras/
 *@linkplain (2) https://kaizen.admintotal.com/admin/inventario/agregar_compra/ 
 *@linkplain (3) https://kaizen.admintotal.com/admin/inventario/editar_compra/
 *@linkplain (4) https://kaizen.admintotal.com/admin/inventario/delete_compra/
 *@author Grupo KAIZEN
 *@since 2022
 */
public class data_aleatory {

	/**
	 *Genera datos aleatorios para incluir en los elementos
	 *@param element es un nombre que se le asigna al elemento para buscarlo
	 *@return aleatoryData es una cadena compuesta por números, letras o alfanumericos
	 */
	@Keyword
	def String getAleatotyData(String element){

		Random random = new Random()

		String aleatoryData = ''

		if  (element == 'no_factura')
			aleatoryData= RandomStringUtils.randomAlphabetic(2) + RandomStringUtils.randomNumeric(5)

		else if (element == 'no_unidades')
			aleatoryData= RandomStringUtils.randomNumeric(2)

		else if (element == 'descuento')
			aleatoryData= RandomStringUtils.randomNumeric(2)

		else if (element == 'fletes')
			aleatoryData= RandomStringUtils.randomNumeric(2)

		else if (element == 'comentarios')
			aleatoryData= 'Automatizacion > Agregar Compra'

		else if (element == 'comentarioEditar')
			aleatoryData= 'Automatizacion > Compra Actualizado'

		return aleatoryData
	}
}
