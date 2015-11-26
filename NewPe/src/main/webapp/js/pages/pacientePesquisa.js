$(document).ready(function() {
	$("#pesNome").focus();
	
	$("#pesNome").autocomplete({
		source: function( request, response ) {
			$.ajax({
				url: "http://localhost:8080/NewPe/Paciente/EfetuaPesquisa",
				data: $('#formPesquisa').serialize(),
				type: 'POST',
				cache: false,
				dataType: "json",
				beforeSend: function() {
            	  
				},
				success: function(data, status, request){ 
					if (status == "success" && data.mensagemUsuario == null) {
						//
						atualizarTabela(data.listaPacientes);
					} else {
						//  					
					}
				},
				error: function (request, error) {
//					alert("Teste...");
//					$("#loading").css("display", "none");
//					$("#divMensagemErro").css("display", "block");
//					$("#spanMsgError").show().html("Sistema indisponível no momento.");  
				}
	        });
	      },
	      minLength: 3
	    });
});

function atualizarTabela(listaPacientes) {
	if (listaPacientes != undefined && listaPacientes.length > 0) {
		$("#tableListaPacientes tbody").html("");
		var html = "";
		for (var i = 0; listaPacientes.length > i; i++) {
			var pessoa = listaPacientes[i];
			html = "";
			html = "<tr>";
			html = html+ "<td><i onclick='javascript:alterar("+pessoa.pesCodigo+");' style='cursor: pointer' class='edit icon'></i></td>";
			html = html+ "<td>"+pessoa.pesNome+"</td></tr>";
			$("#tableListaPacientes tbody").append(html);
		}
	}
}

function alterar(pesCodigo) {
	$("#pesCodigo").val(pesCodigo);
	$("#formPesquisa").attr("action", "InicioAlteracao");
	$("#formPesquisa").submit();	
}
