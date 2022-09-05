package keyword_ordenCompra

import com.kms.katalon.core.annotation.Keyword
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import internal.GlobalVariable
/**
 *Esta clase contiene los datos aleatorios para el formulario para el crud de Orden de Compra.
 *El método busca una cadena que es el nombre del element,
 *al encontrarlo genera una variable aleatoria,
 *RandomStringUtils es la libreria para datos aleatorios,
 *randomNumeric(2) genera un numero con dos digitos: 52,
 *randomAlphabetic(2) genera una cadena dos caracteres: Ab.
 *todaysDate genera una fecha con un dia más al día actual.
 *Este método es usado en la rutas de formularios siguientes:
 *@linkplain (1) https://kaizen.admintotal.com/admin/inventario/entradas/ordenes_compra/
 *@linkplain (2) https://kaizen.admintotal.com/admin/inventario/agregar_orden_compra/
 *@linkplain (3) https://kaizen.admintotal.com/admin/inventario/entradas/ordenes_compra/
 *@linkplain (4) https://kaizen.admintotal.com/admin/inventario/editar_orden_compra/
 *@author Grupo KAIZEN
 *@since 2022
 */
public class ordenCompra_data_aleatory {
	/**
	 *Genera datos aleatorios para incluir en los elements
	 *@param element es un nombre que se le asigna al element para buscarlo
	 *@return aleatoryData es una cadena compuesta por números, letras o alfanumericos
	 */
	@Keyword
	def String getAleatotyData(String element){

		Random random = new Random()

		String aleatoryData = ''

		if  (element == 'T.C')
			aleatoryData= RandomStringUtils.randomNumeric(1)

		else if (element == 'cantidad')
			aleatoryData= RandomStringUtils.randomNumeric(2)

		else if (element == 'fecha_entrega') {
			Date todaysDate = new Date()
			def dayPart = todaysDate[Calendar.DAY_OF_MONTH] + 1;
			aleatoryData= dayPart.toString()
		}

		else if (element == 'comentarioCrear')
			aleatoryData= 'Automatizacion > Comentario de Orden de Compra'

		else if (element == 'comentarioEditar')
			aleatoryData= 'Automatizacion > Orden de Compra Actualizado'

		else if (element == 'comentarioEliminar')
			aleatoryData= 'Prueba Automatizada'

		return aleatoryData
	}
}
