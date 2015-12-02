<%@ taglib prefix="s"  uri="/struts-tags" %>

<script src="../js/pages/pacientePesquisa.js"></script>

<!-- formulário -->
<s:form class="ui form" namespace="Paciente" id="formPesquisa" name="formPesquisa" theme="simple">
	<s:hidden id="pesCodigo" name="pacienteVO.pessoaVO.pesCodigo"></s:hidden>
	<h4 class="ui dividing header">Pesquisa Paciente</h4>
	<div class="field">
		<label>Nome do paciente</label>
        <div class="two fields">
			<div class="field">
            	<s:textfield name="pacienteVO.pessoaVO.pesNome" id="pesNome" size="60" maxlength="55" theme="simple" required="true" placeholder="Digite aqui pelo menos 3 letras do nome do paciente..."/>
          	</div>
		</div>
	</div>
</s:form>
    
<!-- tabela com os resultados. -->
<div align="right" style="font-size: 14px; font-style: italic;">
	Total de pacientes encontrados: <span id="spanTotalPacientes" style="font-weight: bold;">0</span>
</div>
<table id="tableListaPacientes" class="ui striped table" style="margin-top: 5px;">
	<thead>
		<tr>
    		<th style="width: 20px;"></th>
      		<th>Nome</th>
    	</tr>
	</thead>
  	<tbody>

	</tbody>
</table>