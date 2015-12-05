<%@ taglib prefix="s"  uri="/struts-tags" %>

<script src="../js/pages/pacienteManutencao.js"></script>

<!-- formulário -->
<s:form class="ui form" namespace="Paciente" id="formPesquisa" name="formPesquisa" theme="simple">
	<s:hidden id="pesCodigo" name="pacienteVO.pessoaVO.pesCodigo"/>
	<s:hidden id="pacCodigo" name="pacienteVO.pacCodigo"/>
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
		<div align="right" style="font-size: 14px; font-style: italic;">
			Total de contatos: <span id="spanTotalContatos" style="font-weight: bold;">0</span>
		</div>
		<table id="tableListaContatos" class="ui striped table" style="margin-top: 5px;">
			<thead>
				<tr>
		    		<th style="width: 20px;"></th>
		    		<th style="width: 20px;"></th>
		      		<th>Contato</th>
		      		<th>Responsável</th>
		      		<th>Tipo de Contato</th>
		    	</tr>
			</thead>
		  	<tbody>
		
			</tbody>
		</table>
		<button id="btnIncluirContato" type="button" class="ui blue submit button" style="margin-top: 10px;">Incluir novo contato</button>
	</div>
	<div class="ui bottom attached tab segment" data-tab="informacoes">
  		Quarto
	</div>
	<button id="btnSalvar" type="button" class="ui blue submit button" style="margin-top: 10px;">Salvar</button>
</s:form>

<!-- Modal Contato -->
<div id="modalContato" class="ui small modal">
	<div class="header">
		::: Sistema New Pé :::
    </div>
	<div class="description">
		<div style="padding-left: 20px; padding-top: 20px; padding-bottom: 20px;">
			<s:form class="ui form" namespace="Contato" id="formContato" name="formContato" theme="simple">
				<s:hidden id="conCodigo" name="contatoVO.conCodigo"/>
				<div class="fields">
					<div class="field">
			        	<label>Contato</label>
			        	<div class="ui corner labeled input">
							<s:textfield name="contatoVO.conDescricao" id="conDescricao" size="40" maxlength="60" theme="simple" required="true" placeholder="Descrição do contato..."/>
							<div class="ui corner label">
	  							<i class="asterisk icon"></i>
							</div>
						</div>
					</div>
					<div class="field">
			        	<label>Responsável</label>
						<s:textfield name="contatoVO.conResponsavel" id="conResponsavel" size="40" maxlength="80" theme="simple" required="true" placeholder="Nome do responsável..."/>
					</div>
				</div>
				<div class="fields">
					<div class="field" style="width: 250px;">
			        	<label>Tipo Contato</label>
			        	<s:select class="ui fluid dropdown" headerKey="-1" 
			        		headerValue="::: Selecione Tipo Contato :::"
							list="listaTipoContato" listKey="tcoCodigo" 
							listValue="tcoDescricao" name="contatoVO.tcoCodigo"/>
					</div>				
				</div>
			</s:form>
		</div>
	</div>
    <div class="actions">
		<div class="ui red cancel inverted button">
        	<i class="remove icon"></i>
        	Cancelar
      	</div>
      	<div class="ui green ok inverted button">
        	<i class="checkmark icon"></i>
        	Confirmar
      	</div>
	</div>
</div>
