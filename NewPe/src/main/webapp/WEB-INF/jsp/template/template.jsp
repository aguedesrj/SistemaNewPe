<!DOCTYPE html>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
	<link rel="shortcut icon" href="../img/logo.png" type="image/png" />

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"> 
	
	<script src="../js/jquery/jquery.js"></script>
 	<script src="../js/jquery/jquery-ui.js"></script>
	<script src="../js/semantic-ui/semantic.min.js"></script>
	
	<link rel="stylesheet" type="text/css" href="../js/semantic-ui/semantic.min.css">
	
	<title><tiles:insertAttribute name="title"/></title>

</head>
<body>
	<div class="main ui container" style="width: 900px;">
		<div id="tilesMenu"><tiles:insertAttribute name="menu"/></div>
		<div id="tilesMensagem"><tiles:insertAttribute name="mensagem"/></div>
		<div id="tilesConteudo"><tiles:insertAttribute name="conteudo"/></div>	
		<div id="tilesRodape"><tiles:insertAttribute name="rodape"/></div>
	</div>
</body>
</html>
