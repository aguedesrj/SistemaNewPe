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
		$('.ui.modal')
			.modal({
				blurring  : true,
				closable  : false,
				onDeny    : function(){
					window.alert('Wait not yet!');
					return true;
				},
				onApprove : function() {
					return true;
				}
			})
			.modal('show');	
	});
});