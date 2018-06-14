<%-- 
    Document   : index
    Created on : 19-feb-2013, 9:25:56
    Author     : Walter
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TITULO PAGINA</title>
    </head>
    
    <body>
        
<?php
Echo ‘HOLA PHP’';
?>

 <h1>HOLA MUNDO</h1>
        <input type="text" id="xx" /> 
<button type="button" onClick="tel()">envia</button>

<script>
function tel() {
var num=document.getElementById('xx');
alert(num.value);
</script>
       
    </body>
</html>
