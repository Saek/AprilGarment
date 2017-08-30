$('#sendProduct').click(function(e) {
	console.log("#S sendProduct click!");
	
	var clothId = $("#clothesDDL").val();
	var storeId = $("#storeDDL").val();
	var sendAmount = $("#amount").val();
	var sendProductForm = {
			clothId: clothId,
			storeId: storeId,
			sendAmount: sendAmount
	}
	console.log("#S sendProductForm: ", sendProductForm);
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/api/sendProduct",
		data: JSON.stringify(sendProductForm),
		dataType: 'json',
		timeout: 100000,
		success: function(data) {
			console.log("#S sucess in sendProduct click!): ", data);
			resetForm();
		}
	});
});

function resetForm() {
	console.log("#S resetForm()");
	$('#storeDDL').selectpicker('val', '');
	$('#clothesDDL').selectpicker('val', '');
	$('#available').html(0);
	$("#amount").val(0);
}

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

function selectClothModel() {
	
	console.log("#S selectClothModel in salePage");
	var id = $("#clothesDDL").val();
	console.log("#S id: ", id);

	if(id == "") {
		$("#price").text(0);
	}
	else {
		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "/api/getClothInSendProductPage",
			data: id,
			dataType: 'json',
			timeout: 100000,
			success: function(data) {
				console.log("#S sucess in selectClothMOdel(getClothInSendProductPage): ", data);
				var cloth = data;
				var price = cloth.price;
				var availableAmount = cloth.availableAmount;
				$("#available").html(availableAmount);
				$("#price").text(price);

				var amount = $("#amount").val();
				var total = amount * price;
				$("#totalPrice").text(total);
				
			}
		});
	} 
	
}