<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>::: New Pé :::</title>
	<script src="../js/jquery/jquery-2.1.4.min.js"></script>
	<script src="../js/semantic-ui/semantic.min.js"></script>
	<link rel="stylesheet" type="text/css" href="../js/semantic-ui/semantic.min.css">
</head>
<body>
	<script src="../js/pages/login.js"></script>	
	<div class="main ui container" style="width: 400px; margin-top: 80px;">
		<div class="ui raised segment">
			<h2 class="ui dividing header">Efetuar login</h2>
	  		<div class="column" style="margin-top: 20px;">
	  			<s:form namespace="Usuario" id="formLogin" name="formLogin" theme="simple">
		  			<div class="ui form" style="width:300px;">
		      			<div class="field">
		        			<div class="ui left icon input">
		        				<s:textfield name="usuario.usuLogin" id="usuLogin" size="20" maxlength="15" theme="simple" required="true" placeholder="Login"/>
		        				<i class="user icon"></i>
		        			</div>
		      			</div>
		      			<div class="field">
		        			<div class="ui left icon input">
		        				<s:password name="usuario.usuSenha" id="usuSenha" size="15" maxlength="10" theme="simple" required="true" placeholder="Senha"/>
		          				<i class="lock icon"></i>
		        			</div>
		      			</div>
		      			<button id="btnEntrar" type="button" class="ui blue submit button">Entrar</button>
		    		</div>
	  			</s:form>
			</div>
		</div>
	</div>
</body>
</html>
