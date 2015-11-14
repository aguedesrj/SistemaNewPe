$(document).ready(function() {
	$("#usuLogin").focus();
	
	$('.ui.form').form({
		fields: {
    	usuLogin: {
          identifier  : 'usuLogin',
          rules: [
            {
              type   : 'empty',
              prompt : 'O login deve ser preenchido.'
            }
          ]
        },
        usuSenha: {
          identifier  : 'usuSenha',
          rules: [
            {
              type   : 'empty',
              prompt : 'A senha deve ser preenchida.'
            }
          ]
        }
      }
    });
	
	$('#btnEntrar').click(function() {
		$("#formLogin").attr("action", "Entrar");
		$("#formLogin").submit();
	});
});