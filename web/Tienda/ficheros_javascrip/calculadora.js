	var cadena = "";
 
		function calcular(){		
 
			var entrada = document.getElementById("txt_entrada");			
			var cad = (cadena === "") ?  entrada.value : "(" + cadena  + ")" + entrada.value;							
 
			try{
 
				var resultado = eval(cad);					
				document.getElementById("p_resultado").innerHTML = resultado;
				entrada.value = "";
				cadena = cad;
				document.getElementById("p_cadena").innerHTML = cadena;
 
			}catch(err){					
				alert("Expresión mal forma...");				
			}
 
		}		
 
		function borrar(){
			var entrada = document.getElementById("txt_entrada");			
			entrada.value = "";		
			cadena = "";			
			document.getElementById("p_resultado").innerHTML = "0";
			document.getElementById("p_cadena").innerHTML = cadena;
		}	
 
		function identificar_tecla(evento){
 
			// Verificar si se presiona la tecla "Enter"
			if(evento.keyCode==13){
				calcular();		
 
			// Verificar si se presiona la tecla "Esc"				
			}else if(evento.keyCode==27){
				borrar();
			}
		}