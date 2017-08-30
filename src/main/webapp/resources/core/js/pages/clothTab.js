console.log("#S clothTab.js!!!!!!");

function openModal(id) {
	console.log("#S openModal(): ", id);
	var url = "/viewClothDetail";
	var clothId = id;
	showLoader();
	$.get(url, function(result) {
		$('body').append(result);
		$("#myModal").modal();
		
		$.ajax({
			type: "GET",
			contentType: "application/json",
			dataType: 'json',
			url: "/api/getClothById?clothId="+clothId,
			timeout: 100000,
			success: function(data) {
				console.log("#S sucess in getClothById: ", data);
				populateModal(data);
				hideLoader();
			},
			error: function (xhr, ajaxOptions, thrownError) {
		        console.log("error");
				alert(xhr.status);
		        alert(thrownError);
		        hideLoader();
			}
		});
		
		
		
//		var greeting = {
//				id: 10,
//				message: "hello world"
//		}
//		$.ajax({
//			type: "POST",
//			contentType: "application/json",
//			dataType: 'json',
//			data: JSON.stringify(greeting),
//			url: "/api/letTest",
//			timeout: 100000,
//			success: function(data) {
//				console.log("#S sucess in getClothById: ", data);
//				$("#testId").html(data);
//			},
//			error: function (xhr, ajaxOptions, thrownError) {
//		        console.log("error");
//				alert(xhr.status);
//		        alert(thrownError);
//			},
//			complete: function(data) {
//	            console.log("final data: ", data); 
//	            //A function to be called when the request finishes 
//	            // (after success and error callbacks are executed). 
//	            hideLoader();
//	        }
//		});
		
	});
}

function populateModal(cloth) {
	console.log("#S populateModal: ", cloth);
	var clothId = cloth.clothId;
	var active = cloth.active;
	var clothGroup = cloth.clothGroup;
	var clothType = cloth.clothType;
	var color = cloth.color;
	var madeByYear = cloth.madeByYear;
	var model = cloth.model;
	var price = cloth.price;
	var size = cloth.size;
	var brand = cloth.clothBrand;
	
	$('#testId').html(clothId);
	
	$('#clothModel').html(model);
	$('#clothType').html(clothType);
	$('#clothGroup').html(clothGroup);
	$('#clothBrand').html(brand);
	$('#clothPrice').html(price);
	$('#clothColor').html(color);
	$('#clothSize').html(size);
}

