$(document).ready(function() {
	
	$('.menu .item').tab();
	
	$('.ui.radio.checkbox').checkbox();
	
	$("#pesNome").focus();
	
	$('select.dropdown').dropdown();
	
	$('#btnIncluirContato').click(function() {
		$("#conDescricao").val("");
		$("#conResponsavel").val("");
		$("#pesNome").val("0");
		$('#modalContato')
			.modal({
				closable  : false,
				onDeny    : function(){
					window.alert('Não');
					return true;
				},
				onApprove : function() {
					salvarContato();
					return true;
				}
			})
			.modal('show');	
	});

//	$('#formContato').form({
//		fields: {
//    	usuLogin: {
//          identifier  : 'conDescricao',
//          rules: [
//            {
//              type   : 'empty',
//              prompt : 'O login deve ser preenchido.'
//            }
//          ]
//        }
//      }
//    });
});

function salvarContato() {
    $.ajax({
		url: 'NewPe/Paciente/IncluiContato',
		data: $('#formContato').serialize(),
		type: 'POST',
		cache: false,
		dataType: "json",
		beforeSend: function(){
//			$("#loading").css("display", "block");
//			$("#divMensagemErro").css("display", "none");
		},
		success: function(data, status, request){
//			$("#loading").css("display", "none");
			if (status == "success" && data.mensagemUsuario == null) {
				atualizarTabelaContato(data.listaContatoVO);
//				$("#tabelaValores").addRowData(0, {
//					vvpDataCadastro : data.valoresProdutoVO.vvpDataCadastro,
//					vrpImpostoICMS  : data.valoresProdutoVO.vrpImpostoICMS,
//					vrpImpostoIPI   : data.valoresProdutoVO.vrpImpostoIPI,
//					vrpImpostoISS   : data.valoresProdutoVO.vrpImpostoISS,
//					vvpValorProduto : data.valoresProdutoVO.vvpValorProduto
//				});
//				$("#modalValoresProduto").modal('hide'); 
			} else {
//				$("#divMensagemErro").css("display", "block");
//				$("#spanMsgError").show().html(data.mensagemUsuario);						
			}
		},
		error: function (request, error) {
//			$("#loading").css("display", "none");
//			$("#divMensagemErro").css("display", "block");
//			$("#spanMsgError").show().html("Sistema indisponível no momento.");
		}        
	}); 
}

function atualizarTabelaContato(listaContatoVO) {
	$("#spanTotalContatos").html("0");
	if (listaContatoVO != undefined && listaContatoVO.length > 0) {
		$("#spanTotalContatos").html(listaContatoVO.length);
		$("#tableListaContatos tbody").html("");
		var html = "";
		for (var i = 0; listaContatoVO.length > i; i++) {
			var contatoVO = listaContatoVO[i];
			html = "";
			html = "<tr>";
			html = html+ "<td><i onclick='javascript:excluir("+contatoVO.conCodigo+");' style='cursor: pointer' class='remove icon'></i></td>";
			html = html+ "<td><i onclick='javascript:alterar("+contatoVO.conCodigo+");' style='cursor: pointer' class='edit icon'></i></td>";
			html = html+ "<td>"+contatoVO.conDescricao+"</td>";
			html = html+ "<td>"+contatoVO.conResponsavel+"</td>";
			html = html+ "<td>"+contatoVO.tcoDescricao+"</td>";
			html = html+ "</tr>";
			$("#tableListaContatos tbody").append(html);
		}
	}
}

function excluir(conCodigo) {
	
}

function alterar(conCodigo) {
	
}