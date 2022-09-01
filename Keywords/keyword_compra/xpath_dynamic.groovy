package keyword_compra

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import internal.GlobalVariable

/**
 *Esta clase contiene los elementos dinámicos web (xpath) del formulario para el crud de compra. 
 *Es usada para las siguientes rutas de formularios:  
 *@linkplain (1) https://kaizen.admintotal.com/admin/inventario/entradas/compras/
 *@linkplain (2) https://kaizen.admintotal.com/admin/inventario/agregar_compra/ 
 *@linkplain (3) https://kaizen.admintotal.com/admin/inventario/editar_compra/
 *@linkplain (4) https://kaizen.admintotal.com/admin/inventario/delete_compra/
 *@author Grupo KAIZEN
 *@since 2022
 */
public class xpath_dynamic {

	/**
	 *<h3>Crea un objeto con una ruta xpath para ejecutar acciones.</h3>
	 *Estas acciones pueden ser: hacer click al objeto o insertar texto en el objeto.
	 *El método busca una cadena que es el nombre de un elemento, 
	 *al encontrarlo lo asocia a un xpath (ruta del elemento web)
	 *y luego lo convierte en objeto de tipo TestObject
	 *@param element es un nombre que se le asigna al elemento para buscarlo
	 *@return newElement es un objeto de tipo TestObject
	 */
	@Keyword
	def getObject(String element) {

		String xpath = ''

		if (element == 'boton_agregar_compra')
			xpath = "//a[contains(@href, '/admin/inventario/agregar_compra/')]"

		else if (element == 'check_fecha_anterior')
			xpath = "//input[@id='id_usar_fecha_anterior']/following-sibling::*[1]"

		else if (element == 'input_proveedor')
			xpath = "//input[@id='id_proveedor']"

		else if (element == 'modal')
			xpath = "//div[@id='ordenes_dialog']"

		else if (element == 'cancel_modal')
			xpath = "//div[@class='ui-dialog-buttonset']/button"

		else if (element == 'input_entregar_a')
			xpath = "//input[@id='id_direccion_entrega_txt']"

		else if (element == 'table_orden_compra')
			xpath = "//div[@id='ordenes_dialog']/table/tbody/tr"

		else if (element == 'table_unidades')
			xpath = "//table[@id='tabla_detalles']/tbody/tr/th"

		else if (element == 'input_no_factura')
			xpath = "//input[@id='id_folio_factura']"

		else if (element == 'input_producto')
			xpath = "//input[@id='id_form-0-producto']"

		else if (element == 'validar_producto')
			xpath = "//input[@id='id_form-0-producto']/following-sibling::*[2]"

		else if (element == 'opcion_producto')
			xpath = "//div[@class='dialog_descripcion_adicional']/following-sibling::*[1]/li/a"

		else if (element == 'guardar_form')
			xpath = "(//input[@value='Guardar'])"

		else if (element == 'select_condicion')
			xpath = "//select[@id='id_condicion']"

		else if (element == 'select_moneda')
			xpath = "//select[@id='id_moneda']"

		else if (element == 'check_incremental_sin_iva')
			xpath = "//input[@id='id_incremental_sin_iva']/following-sibling::*[1]"

		else if (element == 'validate_no_unidades')
			xpath = "//span[@class='doble_unidad']"

		else if (element == 'input_no_unidades')
			xpath = "//input[@id='id_form-0-numero_unidades']"

		else if (element == 'input_descuento')
			xpath = "//input[@id='id_descuento_general']"

		else if (element == 'input_flete')
			xpath = "//input[@id='id_monto_fsa']"

		else if (element == 'input_comentarios')
			xpath = "//textarea[@id='id_comentarios']"

		else if (element == 'button_guardar')
			xpath = "//button[@value='Guardar']"

		else if (element == 'first_c_table')
			xpath = "(//a[contains(@href, 'admin/ver_entrada')])[1]"

		else if (element == 'edit_compra')
			xpath = "(//a[contains(@onclick, 'editarCompra')])[1]"

		else if (element == 'edit_entrada')
			xpath = "//a[contains(@href, '/admin/inventario/editar_compra/')]"

		else if (element == 'guardar_compra')
			xpath = "(//button[contains(@onclick, 'guardarCompra')])"

		else if (element == 'id_folio')
			xpath = "(//div[@class='col-md-12'])[3]/table/tbody/tr/td/b"

		else if (element == 'button_eliminar_compra')
			xpath = "(//a[contains(@onclick, '/admin/delete/movimiento/entrada/')])[1]"

		else if (element == 'input_motivo_eliminar')
			xpath = "//input[@id='id_cancelacion-motivo_cancelacion']"

		else if (element == 'button_aceptar')
			xpath = "//button[contains(@onclick, 'enviarCancelacion')]"

		TestObject newElement = new TestObject().addProperty('xpath', ConditionType.EQUALS, xpath)
		return newElement
	}
}

