import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

/**Este archivo permite crear y actualizar la documentación de los archivos Keywords
 * Ejecuta el siguiente comando en la consola:
 * gradle groovydoc -x compileGroovy 
 * */

	Process process = Runtime.getRuntime().exec("cmd /c gradlew groovydoc -x compileGroovy");

	StringBuilder output = new StringBuilder();

	BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

	String line;

	while ((line = reader.readLine()) != null) {

		output.append(line + "\n");
	}

	int exitVal = process.waitFor();

	if (exitVal == 0) {

		System.out.println(output);
		
		WebUI.comment("Buscar el archivo en C://Proyecto QA Admintotal/build/docs/groovydoc/index.html");

	} else {

		WebUI.comment("No se puedo crear el archivo!. Instalar Gradle");
	}