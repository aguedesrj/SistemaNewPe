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
	<script src="../js/pages/util.js"></script>
	
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
	
	<!-- Modal Pergunta -->
	<div id="modalPergunta" class="ui small modal">
		<div class="header">
			<tiles:insertAttribute name="title"/>
	    </div>
		<div class="description">
			<div style="padding-left: 20px; padding-top: 20px; padding-bottom: 20px;">
				<span id="spanMensagemPergunta"></span>
			</div>
		</div>
	    <div class="actions">
			<div class="ui red cancel inverted button">
	        	<i class="remove icon"></i>
	        	Não
	      	</div>
	      	<div class="ui green ok inverted button">
	        	<i class="checkmark icon"></i>
	        	Sim
	      	</div>
		</div>
	</div>
	
	<!-- Modal Mensagem -->
	<div id="modalMensagem" class="ui small modal">
		<div class="header">
			<tiles:insertAttribute name="title"/>
	    </div>
		<div class="description">
			<div style="padding-left: 20px; padding-top: 20px; padding-bottom: 20px;">
				<span id="spanMensagemOk"></span>
			</div>
		</div>
	    <div class="actions">
			<div class="ui green ok inverted button">
	        	<i class="checkmark icon"></i>
	        	OK
	      	</div>
		</div>
	</div>
	
		<!-- Modal Mensagem -->
	<div id="modalMensagemErro" class="ui small modal">
		<div class="header">
			<tiles:insertAttribute name="title"/>
	    </div>
		<div class="description">
			<div style="padding-left: 20px; padding-top: 20px; padding-bottom: 20px;">
				<span id="spanMensagemErro"></span>
			</div>
		</div>
	    <div class="actions">
			<div class="ui red cancel inverted button">
	        	<i class="checkmark icon"></i>
	        	OK
	      	</div>
		</div>
	</div>
</body>
</html>
