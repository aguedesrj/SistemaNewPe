$(document).ready(function() {	
	
});

function exibirModalMensagem(mensagem) {
	$("#spanMensagemErro").html(mensagem);
	$('#modalMensagemErro')
		.modal({
			blurring  : true,
			closable  : true
		})
		.modal('show');	
}