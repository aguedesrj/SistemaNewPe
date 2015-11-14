<%@ taglib prefix="s"  uri="/struts-tags" %>

  <!--- Example CSS -->
  <style>
  body {
    padding: 1em;
  }
  .ui.menu {
    margin: 3em 0em;
  }
  .ui.menu:last-child {
    margin-bottom: 110px;
  }
  </style>

  <!--- Example Javascript -->
  <script>
  $(document)
    .ready(function() {
      $('.ui.menu .ui.dropdown').dropdown({
        on: 'hover'
      });
      $('.ui.menu a.item')
        .on('click', function() {
          $(this)
            .addClass('active')
            .siblings()
            .removeClass('active')
          ;
        })
      ;
    })
  ;
  </script>

<div class="ui menu">
	<a class="active item">Principal</a>
  	<div class="ui dropdown item">
    	Paciente
    	<i class="dropdown icon"></i>
    	<div class="menu">
      		<div class="item">
      			<a class="item">Novo</a>
      		Novo</div>
      		<div class="item">Pesquisar</div>
    	</div>
	</div>
	<div class="right menu">
		<a class="item">Sair</a>
	</div>
</div>