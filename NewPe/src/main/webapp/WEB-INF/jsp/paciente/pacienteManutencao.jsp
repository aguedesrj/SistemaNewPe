<%@ taglib prefix="s"  uri="/struts-tags" %>

<script src="../js/pages/pacienteManutencao.js"></script>

<!-- formulário -->
<s:form class="ui form" namespace="Paciente" id="formPesquisa" name="formPesquisa" theme="simple">
	<h4 class="ui dividing header">Cadastro de Paciente</h4>
	<div class="ui top attached tabular menu">
  		<a class="item active" data-tab="dadosPessoais">Dados pessoais</a>
  		<a class="item" data-tab="endereco">Endereço</a>
  		<a class="item" data-tab="contato">Contato</a>
  		<a class="item" data-tab="informacoes">Informações</a>
	</div>
	<div class="ui bottom attached tab segment active" data-tab="dadosPessoais">
		<div class="field">
        	<label>Nome</label>
        	<div class="fields">
	          	<div class="field">
	          		<div class="ui labeled input">
		            	<s:textfield name="pacienteVO.pessoaVO.pesNome" id="pesNome" size="70" maxlength="80" theme="simple" required="true" placeholder="Nome completo"/>
			        	<div class="ui corner label">
	    					<i class="asterisk icon"></i>
	  					</div>	 
  					</div>         	
	          	</div>
			</div>
		</div>
		<div class="fields">
        	<div class="field">
				<label for="fruit">Sexo:</label>
		    	<div class="field">
		      		<div class="ui radio checkbox">
		        		<input type="radio" name="fruit" checked="" tabindex="0" class="hidden">
		        		<label>Feminino</label>
		      		</div>
		    	</div>
		    	<div class="field">
		      		<div class="ui radio checkbox">
		        		<input type="radio" name="fruit" checked="" tabindex="0" class="hidden">
		        		<label>Masculino</label>
		      		</div>
		    	</div>		    	
        	</div>
        	<div class="field">
          		<label>Data de nascimento</label>
          		<s:textfield name="pacienteVO.pessoaVO.pesDtNascimento" id="pesDtNascimento" size="15" maxlength="10" theme="simple" required="true" placeholder="Nome completo"/>
        	</div>    
        	<div class="field">
          		<label>CPF</label>
          		<s:textfield name="pacienteVO.pessoaVO.pesCpf" id="pesCpf" size="18" maxlength="12" theme="simple" required="true" placeholder="CPF"/>
        	</div>         	    	
		</div>
		<div class="fields">
        	<div class="field">
          		<label>Observação</label>
          		<s:textarea name="pacienteVO.pessoaVO.pesObs" id="pesObs" maxlength="1024" cols="100" rows="3" theme="simple" required="true" placeholder="Observações..."/>
        	</div>         	    	
		</div>		
	</div>
	<div class="ui bottom attached tab segment" data-tab="endereco">
		<div class="fields">
			<div class="field">
	        	<label>Logradouro</label>
				<s:textfield name="pacienteVO.pessoaVO.enderecoVO.endLogadouro" id="endLogadouro" size="60" maxlength="100" theme="simple" required="true" placeholder="Rua, avenida..."/>
			</div>
			<div class="field">
	        	<label>Número</label>
				<s:textfield name="pacienteVO.pessoaVO.enderecoVO.endNumero" id="endNumero" size="12" maxlength="8" theme="simple" required="true" placeholder="Número..."/>
			</div>
			<div class="field">
	        	<label>CEP</label>
				<s:textfield name="pacienteVO.pessoaVO.enderecoVO.endCep" id="endCep" size="15" maxlength="12" theme="simple" required="true" placeholder="CEP..."/>
			</div>
		</div>
		<div class="fields">
			<div class="field">
	        	<label>Bairro</label>
				<s:textfield name="pacienteVO.pessoaVO.enderecoVO.endBairro" id="endBairro" size="50" maxlength="60" theme="simple" required="true" placeholder="Bairro..."/>
			</div>
			<div class="field">
	        	<label>Cidade</label>
				<s:textfield name="pacienteVO.pessoaVO.enderecoVO.endCidade" id="endCidade" size="50" maxlength="60" theme="simple" required="true" placeholder="Cidade..."/>
			</div>
		</div>
		<div class="field" style="width: 300px;">
			<label>Estado</label>
          	<select class="ui fluid dropdown">
          		<option value="">::: Selecione um estado :::</option>
            	<s:iterator value="listaEstado" status="estadoVO">
            		<option value="<s:property value="estSigla" />"><s:property value="estNome"/></option>
            	</s:iterator>
          </select>
        </div>		
	</div>
	<div class="ui bottom attached tab segment" data-tab="contato">
  		Terceiro
	</div>
	<div class="ui bottom attached tab segment" data-tab="informacoes">
  		Quarto
	</div>
	<button id="btnSalvar" type="button" class="ui blue submit button" style="margin-top: 10px;">Salvar</button>
</s:form>

