<?PHP 
include('../php/ConexionBD.php');
date_default_timezone_set('Europe/Madrid');

@ $nombre =  $_POST['nombre'];  				//pide el servidor al cliente el nombre 
@ $apellidos =  $_POST['apellidos'];			//pide el servidor al cliente los apellidos
@ $direccion =  $_POST['direccion'];			//pide el servidor al cliente la direccion
@ $poblacion =  $_POST['poblacion'];			//pide el servidor al cliente la poblacion
@ $codigo_postal =  $_POST['codigo_postal'];	//pide el servidor al cliente el codigo postal
@ $correo =  $_POST['correo'];					//pide el servidor al cliente el correo electronico
@ $telefono =  $_POST['telefono'];				//pide el servidor al cliente el telefono
@ $dni =  $_POST['dni'];						//pide el servidor al cliente el dni
@ $password = $_POST['password'];



$nombre =  trim($nombre);					//eliminamos los posibles espacios en blanco tanto delanteros como traseros que pueda haber almacenados en la variable
$apellidos =  trim($apellidos);				//eliminamos los posibles espacios en blanco tanto delanteros como traseros que pueda haber almacenados en la variable
$direccion =  trim($direccion);				//eliminamos los posibles espacios en blanco tanto delanteros como traseros que pueda haber almacenados en la variable
$poblacion =  trim($poblacion);				//eliminamos los posibles espacios en blanco tanto delanteros como traseros que pueda haber almacenados en la variable
$codigo_postal =  trim($codigo_postal);		//eliminamos los posibles espacios en blanco tanto delanteros como traseros que pueda haber almacenados en la variable
$correo =  trim($correo);						//eliminamos los posibles espacios en blanco tanto delanteros como traseros que pueda haber almacenados en la variable
$telefono =  trim($telefono);				//eliminamos los posibles espacios en blanco tanto delanteros como traseros que pueda haber almacenados en la variable


if(strlen($codigo_postal) != 5){   			//comprobamos que tras eliminar los espacios, el codigo postal siga siendo de tamaño 5 y por tanto valido
?>
	<SCRIPT type="text/javascript">
		window.alert("El codigo postal introducido es erroneo"); 
		window.location.href = 'contacta.php';
	</SCRIPT>
<?PHP 
	exit;
}


if(strlen($telefono) != 9){					//comprobamos que tras eliminar los espacios, el telefono siga siendo de tamaño 9 y por tanto valido
?>
	<SCRIPT type="text/javascript">
		window.alert("Telefono incorrecto"); 
		window.location.href = 'contacta.php';
	</SCRIPT>
<?PHP 
	exit;
}

$patron='.+@.+\..+';
if (!eregi($patron, $correo))
	{
?>
	<SCRIPT type="text/javascript">
		window.alert("El correo introducido es erroneo"); 
		window.location.href = 'contacta.php';
	</SCRIPT>
<?PHP 
		exit;
	}
//comprobar que el email contiene todos los datos que debe contener un email, en apuntes viene como hacer.

$busqueda='SELECT dni FROM clientes WHERE dni= "'.$dni.'"';
$resultado=mysql_query($busqueda);
	if ($resultado != 0)
	{	
	?>
	<SCRIPT type="text/javascript">
		window.alert("Ya existe una persona registrada con su DNI"); 
		window.location.href = 'contacta.php';
	</SCRIPT>
<?PHP 
		exit;
	}
//comprobar que no existe otro usuario en la base de datos con el mismo DNI, si existe advertir que ya existe.

$insertar='INSERT INTO clientes VALUES("'.$dni.'", "'.$nombre.'", "'.$apellidos.'", "'.$direccion.'", "'.$poblacion.'", "'.$codigo_postal.'", "'.$correo.'", "'.$telefono.'", "'.$password.'");';
$resultado=mysql_query($insertar);
?>
	<SCRIPT type="text/javascript">
		window.alert("El registro en el servidor se ha completado"); 
		window.location.href = 'Principal.php';
	</SCRIPT>
<?PHP 

//almacenar usuario en la base de datos e indicar que ya es un usuario registrado que inicie sesión.

?>