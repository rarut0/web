		
		function hora(){
				hoy=new Date();
				var hora = document.getElementById('hora');
				hora.innerHTML = hoy.getHours()+":"+hoy.getMinutes()+":"+hoy.getSeconds();
		}
		function fecha(){
				hoy=new Date();
				var fecha = document.getElementById('fecha');
				fecha.innerHTML = hoy.getDay()+";"+hoy.getMonth()+";"+hoy.getFullYear();
		}
		function quitarFecha(){
				
				var fecha = document.getElementById('fecha');
				fecha.innerHTML = "Ver Fecha";
				
		}
		function quitarHora(){
				
				var hora = document.getElementById('hora');
				hora.innerHTML = "Ver Hora";
				
		}
		