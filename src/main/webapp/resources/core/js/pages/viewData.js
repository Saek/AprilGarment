console.log("#S viewData.js");
initPage();


function initPage() {
	var loadurl = "/viewClothTab";
    var targ = "#clothTab";
	showLoader();
	$.get(loadurl, function(data) {
    	console.log("#S loadurl: ", loadurl);
    	console.log("#S data: ", data);
    	$(targ).html(data);
//    	$("#companiesDDL").show();
    	$(".selectpicker").selectpicker({
    	    "title": "Select Options"        
    	}).selectpicker("render");
    	hideLoader();
    });
}

$('[data-toggle="tabajax"]').click(function(e) {
    console.log("#S tabajax has been22 clicked!");
	var $this = $(this),
        loadurl = $this.attr('href'),
        targ = $this.attr('data-target');
	console.log("#S this: ", $this);
	console.log("#S targ: ", targ);
    
	showLoader();
	$.get(loadurl, function(data) {
    	$(targ).html(data);    	
		$(".selectpicker").selectpicker({
    	    "title": "Select Options"        
    	}).selectpicker("render");   
		hideLoader();
    });

    $this.tab('show');
    return false;
});