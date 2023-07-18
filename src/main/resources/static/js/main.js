
(function($) {

	var	$window = $(window),
		$body = $('body');	

	// animacion inicial de la pagina
		$window.on('load', function() {
			window.setTimeout(function() {
				$body.removeClass('is-preload');
			}, 100);
		});
		

})(jQuery);