$(document).ready(function() {
	
	$('.menu .item').tab();
	
	$('.ui.radio.checkbox').checkbox();
	
	$("#pesNome").focus();
	
	$('select.dropdown').dropdown();
	
	$('#btnIncluirContato').click(function() {
		$("#conDescricao").val("");
		$("#conResponsavel").val("");
		$("#conCodigo").val("");
		$('#tcoCodigo').val('-1').change();
		$("#tcoDescricao").val("");
		
		$('#modalContato')
			.modal({
				closable  : false,
				onDeny    : function(){
					return true;
				},
				onApprove : function() {
					if (isFormContatoValidado()) {
						salvarContato();
						return true;
					} else {
						return false;
					}
				}
			})
			.modal('show');	
	});
	
	$('#btnSalvar').click(function() {
		
		exibirModalMensagem("Erro...");
	});
});

function isFormContatoValidado() {
	if ($("#tcoDescricao").val() == "conDescricao") {
//		exibirModalMensagem("O campo contato deve ser preenchido");
		alert("O campo contato deve ser preenchido");
		$("#tcoDescricao").focus();
		return false;
	}
	
	if ($("#tcoCodigo").val() == "-1") {
//		exibirModalMensagem("O campo tipo de contato deve ser preenchido");
		alert("O campo tipo de contato deve ser preenchido");
		$("#tcoCodigo").focus();
		return false;
	}
	return true;
}

/**
 * 
 */
function salvarContato() {	
	$("#tcoDescricao").val(document.getElementById('tcoCodigo').options[document.getElementById('tcoCodigo').selectedIndex].innerText);
	$.ajax({
		url: 'NewPe/Paciente/IncluiContato',
		data: $('#formContato').serialize(),
		type: 'POST',
		cache: false,
		dataType: "json",
		beforeSend: function(){
			//
		},
		success: function(data, status, request){
			if (status == "success" && data.mensagemUsuario == null) {
				atualizarTabelaContato(data.listaContatoVO);
			} else {
				exibirModalMensagem(data.mensagemUsuario);
			}
		},
		error: function (request, error) {
			exibirModalMensagem("Sistema indisponível no momento.");
		}        
	}); 
}

/**
 * 
 * @param listaContatoVO
 */
function atualizarTabelaContato(listaContatoVO) {
	$("#spanTotalContatos").html("0");
	$("#tableListaContatos tbody").html("");
	if (listaContatoVO != undefined && listaContatoVO.length > 0) {
		$("#spanTotalContatos").html(listaContatoVO.length);
		var html = "";
		for (var i = 0; listaContatoVO.length > i; i++) {
			var contatoVO = listaContatoVO[i];
			html = "";
			html = "<tr>";
			html = html+ "<td><i onclick='javascript:excluir("+contatoVO.conCodigo+");' style='cursor: pointer' class='remove icon'></i></td>";
			html = html+ "<td><i onclick='javascript:alterar("+contatoVO.conCodigo+");' style='cursor: pointer' class='edit icon'></i></td>";
			html = html+ "<td>"+contatoVO.conDescricao+"</td>";
			html = html+ "<td>"+contatoVO.conResponsavel+"</td>";
			html = html+ "<td>"+contatoVO.tipoContatoVO.tcoDescricao+"</td>";
			html = html+ "</tr>";
			$("#tableListaContatos tbody").append(html);
		}
	}
}

/**
 * 
 * @param conCodigo
 */
function excluir(conCodigo) {
	$("#spanMensagemPergunta").html("Deseja remover o contato?");
	$('#modalPergunta')
		.modal({
			blurring  : true,
			closable  : false,
			onDeny    : function(){
				return true;
			},
			onApprove : function() {
			    $.ajax({
					url: 'NewPe/Paciente/ExcluiContato?contatoVO.conCodigo='+conCodigo,
					type: 'GET',
					cache: false,
					dataType: "json",
					beforeSend: function(){
						//
					},
					success: function(data, status, request) {
						if (status == "success" && data.mensagemUsuario == null) {
							atualizarTabelaContato(data.listaContatoVO);
						} else {
							exibirModalMensagem(data.mensagemUsuario);
						}
					},
					error: function (request, error) {
						exibirModalMensagem("Sistema indisponível no momento.");
					}        
				});
				return true;
			}
		})
		.modal('show');	
}

/**
 * 
 * @param conCodigo
 */
function alterar(conCodigo) {
    $.ajax({
		url: 'NewPe/Paciente/AlteraContato?contatoVO.conCodigo='+conCodigo,
		type: 'GET',
		cache: false,
		dataType: "json",
		beforeSend: function(){
			//
		},
		success: function(data, status, request) {
			if (status == "success" && data.mensagemUsuario == null) {
				$("#conDescricao").val(data.contatoVO.conDescricao);
				$("#conResponsavel").val(data.contatoVO.conResponsavel);
				$("#conCodigo").val(data.contatoVO.conCodigo);
				$('#tcoCodigo').val(data.contatoVO.tipoContatoVO.tcoCodigo).change();
				// abrir modal...
				$('#modalContato')
					.modal({
						closable  : false,
						onDeny    : function(){
							return true;
						},
						onApprove : function() {
							salvarContato();
							return true;
						}
					})
					.modal('show');
			} else {
				exibirModalMensagem(data.mensagemUsuario);
			}
		},
		error: function (request, error) {
			exibirModalMensagem("Sistema indisponível no momento.");
		}        
	});	
}