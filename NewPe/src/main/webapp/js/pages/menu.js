$(document).ready(function() {
	$('.ui.menu .ui.dropdown').dropdown({
        on: 'hover'
    });
	$('.ui.menu a.item')
    	.on('click', function() {
    		$(this)
            .addClass('active')
            .siblings()
            .removeClass('active');
        });
	
	$('#homeSair').click(function() {
		$("#spanMensagemPergunta").html("Deseja sair do sistema?");
		$('#modalPergunta')
			.modal({
				blurring  : true,
				closable  : false,
				onDeny    : function(){
					return true;
				},
				onApprove : function() {
//					$("#formPesquisa").attr("action", "InicioAlteracao");
//					$("#formPesquisa").submit();
					return true;
				}
			})
			.modal('show');	
	});
});