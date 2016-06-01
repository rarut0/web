function loadXMLDoc(url) 
				{ 
						var xmlhttp; 
						var txt,x,xx,i; 
						if (window.XMLHttpRequest) 
						{// code for IE7+, Firefox, Chrome, Opera, Safari
						xmlhttp=new XMLHttpRequest(); 
						} 
						else 
						{// code for IE6, IE5 
						xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
						} 
						xmlhttp.onreadystatechange=function() 
						{ if (xmlhttp.readyState==4 && xmlhttp.status==200)
						{ 
						txt="<P>"; 
						x=xmlhttp.responseXML.documentElement.getElementsByTagName("UBICACION");		
						xx=x[0].getElementsByTagName("CIUDAD"); 
						
						
						try
						{ 
						
						txt= txt + "Ciudad:"  + xx[0].firstChild.nodeValue + "<BR>"; 
						
						} 
						catch (er)
						{ 
						txt= "error"; 
						} 
						
						xx=x[0].getElementsByTagName("DIRECCION"); 
						
						try
						{ 
						
						txt= txt + "Dirección:" + xx[0].firstChild.nodeValue + "</P>"; 
						
						} 
						catch (er)
						{ 
						txt= "error"; 
						} 
						
						}
						document.getElementById('DATOS').innerHTML=txt; 
						}
				xmlhttp.open("GET",url,true); 
				xmlhttp.send(); 
				} 