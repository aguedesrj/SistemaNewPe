<%@ taglib prefix="s"  uri="/struts-tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<script src="../js/pages/menu.js"></script>

  <style>
	  body {
	    padding: 1em;
	  }
	  .ui.menu {
	    margin: 3em 0em;
	  }
	  .ui.menu:last-child {
	    margin-bottom: 50px;
	  }
  </style>

<div class="ui menu">
	<a class="active item" href="../Usuario/Home">
		Principal
	</a>
  	<div class="ui dropdown item">
    	Paciente
    	<i class="dropdown icon"></i>
    	<div class="menu">
      		<div class="item">
      			<a href="../Paciente/Manutencao">Novo</a>
      		</div>
      		<div class="item">
      			<a href="../Paciente/Pesquisa">Pesquisar</a>
      		</div>
    	</div>
	</div>
	<div class="right menu">
		<a id="homeSair" class="item">Sair</a>
	</div>
</div>

<!-- Modal Sair -->
<div class="ui small modal">
	<div class="header">
		::: Sistema New Pé :::
    </div>
	<div class="description">
		Deseja sair do sistema?
	</div>
    <div class="actions">
		<div class="ui black deny button">
        	Não
      	</div>
      	<div class="ui positive right labeled icon button">
        	Sim
        	<i class="checkmark icon"></i>
      	</div>
	</div>
</div>