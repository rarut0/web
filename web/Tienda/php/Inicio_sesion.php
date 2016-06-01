<?PHP 
session_start();

@ $DNI=  $_POST['Login'];			//guardo en una variable el dni

@ $PASSWORD =  $_POST['password'];			//guardo en una variable el password
@ $PASSWORD = addslashes($PASSWORD);

 //			---->Realizo una consulta a la base de datos <----
 include('ConexionBD.php');
 date_default_timezone_set('Europe/Madrid');
		$query = "SELECT * FROM CLIENTES WHERE password='".$PASSWORD."' && dni='".$DNI."'";
		$resultado = mysql_query($query);
		$num_resultados = mysql_num_rows($resultado);
		if($num_resultados == 1)//correcto
		{
			//Iniciar sesion
			
			$_SESSION['DNI'] = $Login;
			header("Location: Principal.php");
		}else{
			session_destroy();
			$fila = mysql_fetch_array($resultado);
@			$usuario = $fila['dni'];
			//error, incorrecto
		}
		

?>