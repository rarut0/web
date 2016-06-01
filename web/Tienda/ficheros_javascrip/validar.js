function validar(correo,nombre, apellidos, direccion, poblacion, codigo_postal, dni, telefono,password, password_re) { 

var control_fallo = true;
var fallo_nombre = '';
var fallo_apellidos = '';
var fallo_direccion = '';
var fallo_poblacion = '';
var fallo_codigopostal = '';
var fallo_correo = '';
var fallo_correo2 = '';
var fallo_dni = '';
var fallo_telefono = '';
var fallo_password = '';

	


		if (nombre.length <=0) {
			if (control_fallo==true){
				document.formulario.nombre.focus();
			}
			control_fallo = false;
			fallo_nombre = 'nombre,';
		}

		if (apellidos.length <=0) {
			if (control_fallo==true){
				document.formulario.apellidos.focus();
			}
			control_fallo = false;
			fallo_apellidos = 'apellidos,';
		}
		if (direccion.length <=0) {
				if (control_fallo==true){
				document.formulario.direccion.focus();
			}
			control_fallo = false;
			fallo_direccion = 'direccion,';
		}
		if (poblacion.length <=0) {
				if (control_fallo==true){
				document.formulario.poblacion.focus();
			}
			control_fallo = false;
			fallo_poblacion = 'poblacion,';
		}
		if (codigo_postal.length != 5) {
			if (control_fallo==true){
				document.formulario.codigo_postal.focus();
			}
			control_fallo = false;
			var prueba_numero = isNaN(codigo_postal);
			if (prueba_numero){
				fallo_codigopostal = ' codigo postal no es un numero,';
			}
			else{
			fallo_codigopostal = ' codigo postal,';
			}
		}
		if (correo.length <=0) {
			if (control_fallo==true){
				document.formulario.correo.focus();
			}
			control_fallo = false;
			fallo_correo = 'correo electronico,';
		}
		if  (correo.indexOf("@") == -1){
			if (control_fallo==true){
				document.formulario.correo.focus();
			}
			control_fallo = false;
			fallo_correo2 = 'el correo electronico no es valido,';
		}	
		
		if (telefono.length != 9) {
				if (control_fallo==true){
				document.formulario.telefono.focus();
			}
			control_fallo = false;
			var prueba_telef = isNaN(telefono);
			if (prueba_telef){
				fallo_telefono = ' telefono no es un numero,';
			}
			else{
			fallo_telefono = ' telefono,';
			}
		}
		
   var numero = dni.substring(0,dni.length-1);
   var letra_dni = dni.substring(dni.length-1,9);
   numero = numero % 23;
   var letraMin='trwagmyfpdxbnjzsqvhlcket';
   var letraMay='TRWAGMYFPDXBNJZSQVHLCKET';
   letraMin=letraMin.substring(numero,numero+1);
   letraMay=letraMay.substring(numero,numero+1);
   if (letraMin != letra_dni && letraMay != letra_dni){ 
			if (control_fallo==true){
				document.formulario.dni.focus();
			}
    control_fallo = false;
	fallo_dni = ('letra del DNI incorrecta,');
	}
	
		if (password.length <=0) {
			if (control_fallo==true){
				document.formulario.password.focus();
			}
			control_fallo = false;
			fallo_password = 'password vacio,';
		} else if (password != password_re) {
			if (control_fallo==true){
				document.formulario.password.focus();
			}
			control_fallo = false;
			fallo_password = 'los password no coinciden,';
		}
			if (control_fallo){
			return true;
		}
			else{
			 alert ('comprobar los campos: ' + fallo_nombre + ' ' + fallo_apellidos + ' ' + fallo_direccion + ' '  + fallo_poblacion + ' ' + fallo_codigopostal + ' ' + fallo_correo + ' ' + fallo_correo2 + ' ' + fallo_dni + ' ' + fallo_telefono + ' ' + fallo_password);
			 return false;
		}	
return false;
}