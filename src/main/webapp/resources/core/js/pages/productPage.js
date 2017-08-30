console.log("#S prod1111");

$(function () {
    $('#datetimepicker5').datetimepicker({
        defaultDate: "11/1/2013",
        disabledDates: [
            moment("12/25/2013"),
            new Date(2013, 11 - 1, 21),
            "11/22/2013 00:53"
        ]
    });
});

$("#btnProduce").click(function(event) {
	console.log("#S clclcl: ", $("#factoriesDDL").val());
	console.log("#S clothId: ", $("#clothesDDL").val());
	var factoryId = $("#factoriesDDL").val();
	var clothId = $("#clothesDDL").val();
	var productAmount = $("#amount").val();
	console.log("#S factoryId: ", factoryId);
	console.log("#S clothId: ", clothId);
	console.log("#S productAmount: ", productAmount);
	
	if(factoryId != "" && clothId != "" && productAmount > 0) {
		console.log("#S success!!!!");
		var productForm = {};
		productForm.factoryId = factoryId;
		productForm.clothId = clothId;
		productForm.productAmount = productAmount;
		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "/api/addProducts",
			data: JSON.stringify(productForm),
			dataType: 'json',
			timeout: 100000,
			success: function(data) {
				console.log("#S sucess in selectClothMOdel: ", data);	
				resetForm();
				$('.alert.alert-success').show();
				setTimeout(function() {
					$('.alert.alert-success').hide();
				}, 3000);
			}
		});
	}
	else {
		var errorMessage = "";
		if(factoryId == "") {
			errorMessage = "Please select factory name.";
		}
		else if(clothId == "") {
			errorMessage = "Please select cloth model.";
		}
		else if(productAmount < 1) {
			errorMessage = "Amount to produce must greater than zero.";
		}
		showErrorMessage(errorMessage);
	}
		
});
function resetForm() {
	console.log("#S resetForm()");
	$('#factoriesDDL').selectpicker('val', '');
	$('#clothesDDL').selectpicker('val', '');
	$('#price').html(0);
	$('#totalPrice').html(0);
	$("#amount").val(0);
}
function showErrorMessage(message) {
	$("#errorMessage").html(message);
	$(".alert.alert-danger").show();
	setTimeout(function() {
		$(".alert.alert-danger").hide();
	}, 3000);
}
function selectClothModel() {
	
	console.log("#S selectClothModel");
	var id = $("#clothesDDL").val();
	console.log("#S id: ", id);

	if(id == "") {
		$("#price").text(0);
	}
	else {
		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "/api/getClothPrice",
//			data: JSON.stringify({ id: id }),
			data: id,
			dataType: 'json',
			timeout: 100000,
			success: function(data) {
				console.log("#S sucess in selectClothMOdel: ", data);
//				$("#clothPrice").val(data);
				
				$("#price").text(data);
				var price = data;
				var amount = $("#amount").val();
				var total = amount * price;
				$("#totalPrice").text(total);
				
			}
		});
	} 
	
}

function getTotalPrice() {
	console.log("#S getTotalPrice()");
	var amount = $("#amount").val();
	var price = $("#price").text();
	var total = amount * price;
	console.log("#S total: ", total);
	$("#totalPrice").text(total);
}