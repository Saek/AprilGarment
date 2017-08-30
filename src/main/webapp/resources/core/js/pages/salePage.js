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

function test() {
	console.log("#S test()");
	var newitemnum = 3;
    var newitemdesc = "Relish";
    $("#clothesDDL").append('<option value="'+newitemnum+'" selected="">'+newitemdesc+'</option>');
    $("#clothesDDL").selectpicker("refresh");
}

$(document).on('change', '.selectpicker', function () {
    $('.selectpicker').selectpicker('refresh');
});

function selectStore() {
	console.log("#S selectStore()");
	
	var storeId = $("#storesDDL").val();
	if(storeId != "") {
		$.ajax({
			type: "GET",
			contentType: "application/json",
			url: "/api/getClothModelByStoreId?storeId=" + storeId,
//			data: JSON.stringify(productForm),
			dataType: 'json',
			timeout: 100000,
			success: function(data) {
				console.log("#S sucess in sellProduct: ", data);	
				bindClothDDL(data);
			}
		});
	}
}

function bindClothDDL(clothList) {
	console.log("#S bindClothDDL clothList: ", clothList);
	console.log("#S bindClothDDL clothList.length: ", clothList.length);
//	$('#clothesDDL').selectpicker();
	var message = "No Cloth In Store!";
	if(clothList.length > 0) {
		message = "Please Select";
	}
	var pleaseSelectOption = '<option value="">' + message + '</option>';
	$('#clothesDDL').empty();
	$('#clothesDDL').append(pleaseSelectOption);
	$.each(clothList, function(index, cloth) {
		console.log("#S cloth ==> ", cloth);
		var option = '<option value="' + cloth.clothId + '">' + cloth.model + '</option>';
		console.log("#S option: ", option);
		$('#clothesDDL').append(option);
	});
	console.log("#S inside dropdownlist cloth: " , $('#clothDDL'));
	$('#clothesDDL').selectpicker('refresh');
	console.log("#S finish bindClothDDL");
}

//private int storeId;
//@JsonView(Views.Public.class)
//private int clothId;
//@JsonView(Views.Public.class)
//private int saleAmount;
//@JsonView(Views.Public.class)
//private BigDecimal pricePerOne;
//@JsonView(Views.Public.class)
//private BigDecimal totalSale;

function sellProduct() {
	console.log("#S sellProduct");
	var storeId = $('#storesDDL').val();
	var clothId = $('#clothesDDL').val();
	var saleAmount = $('#amount').val();
	var pricePerOne = $('#price').text().trim();
	var totalSale = $('#totalPrice').text().trim();
	
	var saleForm = {
			storeId: parseInt(storeId),
			clothId: parseInt(clothId),
			saleAmount: parseInt(saleAmount),
			pricePerOne: parseFloat(pricePerOne),
			totalSale: parseFloat(totalSale)
	};
	console.log("#S saleForm: ", saleForm);
	$.ajax({
		type: "POST",
		contentType: "application/json",
//		url: "/api/sellProducts?test=testSellProduct",
		url: "/api/sellProducts",
		data: JSON.stringify(saleForm),
		dataType: 'json',
		timeout: 100000,
		success: function(data) {
			console.log("#S sucess in sellProduct: ", data.message);	
			resetForm();
			$('.alert.alert-success').show();
			setTimeout(function() {
				$('.alert.alert-success').hide();
			}, 3000);
		}
	});
}

function resetForm() {
	console.log("#S resetForm()");
	
	$('#storesDDL').selectpicker('val', '');
	$('#clothesDDL').empty();
	$('#clothesDDL').selectpicker('refresh');
	
	$("#amount").val(0);
	$('#available').html(0);
	$('#price').html(0);	
	$('#totalPrice').html(0);
}

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
			url: "/api/getClothInSalePage",
			data: id,
			dataType: 'json',
			timeout: 100000,
			success: function(data) {
				console.log("#S sucess in selectClothMOdel: ", data);
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

function getTotalPrice() {
	console.log("#S getTotalPrice()");
	var amount = $("#amount").val();
	var price = $("#price").text();
	var total = amount * price;
	console.log("#S total: ", total);
	$("#totalPrice").text(total);
}