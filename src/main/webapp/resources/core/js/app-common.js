console.log("#S app-common init");

function showLoader() {
	var loader = '<div class="loader-overlay">' +
					'<div class="loader-spinner">'+
					'</div>'+
				 '</div>';
	$('body').prepend(loader);
	
//	setTimeout(hideLoader, 1000);
}

function hideLoader() {
	console.log("#S hideLoader()");
	var loader = $('.loader-overlay');
	loader.detach();
}