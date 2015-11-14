<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
	<link rel="shortcut icon" href="../img/logo.png" type="image/png" />
	
	<meta charset="utf-8" />
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  
	<title>::: New Pé :::</title>
	
 	<script src="../js/jquery/jquery-2.1.4.min.js"></script>
	<script src="../js/semantic-ui/semantic.min.js"></script>
	
	<link rel="stylesheet" type="text/css" href="../js/semantic-ui/semantic.min.css">
	
  <style type="text/css">
    body {
      background-color: #DADADA;
    }
  </style>	
	
</head>
<body>
	<script src="../js/pages/login.js"></script>
 	<div class="main ui container" style="width: 400px; margin-top: 80px;">
		<s:if test="hasActionErrors()">
			<div class="ui negative message" style="height: 80px;">
				<i class="close icon"></i>
			  	<div class="header">
			    	Ocorreu o seguinte erro:
			  	</div>
			  	<s:actionerror/>
			</div>		
		</s:if>	
		<div class="ui raised segment">
			<h2 class="ui dividing header">Efetuar login</h2>
	  		<div class="column" style="margin-top: 20px;">
	  			<s:form class="ui large form" namespace="Usuario" id="formLogin" name="formLogin" theme="simple">
		  			<div class="ui form" style="width:300px;">
		      			<div class="field">
		        			<div class="ui corner left icon labeled input">
		        				<s:textfield name="usuario.usuLogin" id="usuLogin" size="20" maxlength="15" theme="simple" required="true" placeholder="Login"/>
		        				<i class="user icon"></i>
		        				<div class="ui corner label">
    								<i class="asterisk icon"></i>
  								</div>
		        			</div>
		      			</div>
		      			<div class="field">
		        			<div class="ui corner left icon labeled input">
		        				<s:password name="usuario.usuSenha" id="usuSenha" size="15" maxlength="10" theme="simple" required="true" placeholder="Senha"/>
		          				<i class="lock icon"></i>
		        				<div class="ui corner label">
    								<i class="asterisk icon"></i>
  								</div>		          				
		        			</div>
		      			</div>
		      			<button id="btnEntrar" type="button" class="ui blue submit button">Entrar</button>
		    		</div>
		    		<div class="ui error message"></div>
	  			</s:form>
			</div>
		</div>
	</div>
</body>
</html>
