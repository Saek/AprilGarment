console.log("#S in comparePage.js");

Chart.defaults.global.defaultFontFamily = 'Georgia';
Chart.defaults.global.defaultFontSize = 25;
Chart.defaults.global.defaultFontColor = '#111'

var isChartEmpty = true;
var clothModelList = [	
	{key: "2017", value: "2017"},
	{key: "2016", value: "2016"},
	{key: "2015", value: "2015"},
	{key: "2014", value: "2014"},
	{key: "2013", value: "2013"}
];	
console.log("#S clothModelList begin");
initClothDDL();

var ctx = $("#myChart");

myChart = new Chart(ctx, {});
console.log("#S myChart is empty22()");

var ctx2 = $("#mySecondChart");
var myPieChart = new Chart(ctx2,{
    type: 'pie',
    data: {
    	labels: ["Red", "Blue", "Yellow", "Green"],
    	datasets: [{
	    	data: [12, 19, 3, 44],
	    	backgroundColor: [
		        'rgba(255, 99, 132, 0.2)',
				'rgba(54, 162, 235, 0.2)',
				'rgba(255, 206, 86, 0.2)',
				'rgba(255,99,132,1)'
			],
        }],
        options: {}
    },        
}); 

function initClothDDL() {
	console.log("#S initClothDDL()");
	var pleaseSelectionOption = '<option value="">Please Select</option>';
	$('#yearDDL').empty();
	$('#yearDDL').append(pleaseSelectionOption);
	$.each(clothModelList, function(index, value) {
		console.log("#S value: ", value);
		var option = value;
		var optionTag = '<option value="' + option.key + '">' + option.value + '</option>';
		$('#yearDDL').append(optionTag);
		
	});
	$('#yearDDL').selectpicker('refresh');
	$('#btnAddDate').prop("disabled", true);
}

function selectTitle() {
	console.log("#S selectTitle()");
	var title = $('#titleDDL').val();
	console.log("#S title: ", title);
	var selectedYearCount = $('#selectedYearList span').size();
	console.log("#S selectedYearCount: ", selectedYearCount);
	var chartCategory = $('#chartCategory').val();
	
	if(title == "Cloth Model") {
		$('#clothModelForm').show();
	}
	else {
		$('#clothModelForm').hide();
	}
	
	if(isBtnGraphEnable()) {
    	$('#btnDrawGraph').prop("disabled", false);
    }
    else {
    	$('#btnDrawGraph').prop("disabled", true);
    }
}

function selectYear() {
	console.log("#S selectYear()");
	var year = $('#yearDDL').val();
	if(year != "") {
		$('#btnAddDate').prop("disabled", false);
	}
	else {
		$('#btnAddDate').prop("disabled", true);
	}
}

function addYear() {
	console.log("#S addYear()");
	var labelClasses = ["label-default", "label-primary", "label-success", "label-info"];	
	var MAX_SIZE = 4;
	var yearsListCount = $('#selectedYearList > span').length;
	var year = $('#yearDDL').val();
	console.log("#S yearsListCount: ", yearsListCount);
	
	if(yearsListCount < MAX_SIZE) {
		var spanTag = '<span class="label ' + labelClasses[yearsListCount] + '">' 
			+ year +
			 '<i class="fa fa-times small-cross" aria-hidden="true" onclick="removeYear($(this).parent())"></i>'+
			 '</span>';
		$('#selectedYearList').append(spanTag);
	}
	else {
		$('.alert.alert-warning').show();
		setTimeout(function() {
			$('.alert.alert-warning').hide();
		}, 5000);
	}
	
	console.log("#S isBtnGraphEnable(): ", isBtnGraphEnable());
	if(isBtnGraphEnable()) {
		$('#clothModelsDDL').prop("required", false);
    	$('#btnDrawGraph').prop("disabled", false);
    }
    else {
    	$('#btnDrawGraph').prop("disabled", true);
    }
	$('#btnAddDate').prop("disabled", true);
	$('#yearDDL').find('[value=' + year + ']').remove();
	$('#yearDDL').selectpicker('refresh');
}

function getGraphInfo() {
	console.log("#S getGraphInfo()");
	showLoader();
	var labels = getLabels();
	var compareDataForm = {
			years: labels
	}
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/api/getGraphInfo",
		data: JSON.stringify(compareDataForm),
		dataType: 'json',
		timeout: 100000,
		success: function(data) {
			console.log("#S get data in getGraphInfos: ", data);
			$('#chartTitle').show();
			var title = $('#titleDDL').val();
			console.log("#S title: ", title);
//			<h1 id="chartTitle" style="">
//				Cloth Model:<span id="modelName">roxie rr12pony</span>
//			</h1>
			if(title == "Sales") {
				$('#chartTitle').html("Sales");
			}
			else {
				var clothModelTitle = "Cloth Model: ";
				var model = $('#clothModelsDDL option:selected').text();
				console.log("#S model: ", model);
				clothModelTitle += model;
				$('#chartTitle').html(clothModelTitle);
			}
			
//			$('#modelName').html(model);
			drawGraph(data);
			hideLoader();
			
//			console.log("#S sucess in sellProduct: ", data.message);	
//			resetForm();
//			$('.alert.alert-success').show();
//			setTimeout(function() {
//				$('.alert.alert-success').hide();
//			}, 3000);
		}
	});
}

function drawGraph(graphInfos) {
	console.log("#S drawGraph!: ", graphInfos);
	isChartEmpty = false;
	var labels = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
	var years = ['2559', '2560'];
	var datasets = [];
	var backgroundColors = ['rgba(255, 99, 132, 0.2)', 'rgba(54, 162, 235, 0.2)'];
	var borderColors = ['rgba(255,99,132,1)', 'rgba(255, 159, 64, 1)'];
	var hoverBackgroundColors = ['rgba(255,99,132,1)', 'rgba(255,99,132,1)']; 
	
	$.each(graphInfos, function(graphInfoIndex, graphInfo) {
		var datas = graphInfo.data;
		var bgColor = [];
		var bColor = [];
		var hBgColor = [];
		$.each(datas, function(dataIndex, data) {
			console.log("#S dataIndex: ", dataIndex);
			console.log("#S data #2222: ", data);
			bgColor.push(backgroundColors[graphInfoIndex]);
			bColor.push(borderColors[graphInfoIndex]);
			hBgColor.push(hoverBackgroundColors[graphInfoIndex]);
		});
		
		console.log("#S graphInfo: ", graphInfo);
		datasets.push({
			label: years[graphInfoIndex],
			data: datas,
			backgroundColor: bgColor,
			borderColor: bColor,
			borderWidth: 1,
			hoverBackgroundColor: hBgColor
		});
	});
	
	console.log("#S finish looop datasets: ", datasets);
	
	var data = {
	    labels: labels,
		datasets: datasets,
		yLabels: ['pizza', 'shark', 'fish', 'crocodiles', 'fff',' snaeeeke'],
		xAxisID: 'hello world'
	};
//	
	myChart = new Chart(ctx, {
	    type: $('#chartCategory').val(),
		data: data,
		options: {
		    scales: {
		        yAxes: [{
		            ticks: {
		                beginAtZero:true
		            }
		        }]
		    },
		    legend: {
		        display: true,
		        labels: {
		            fontColor: 'rgb(255, 99, 132)'
		        }
		    }
		}
	});
}

function removeYear(yearLabel) {
	var yearValue = yearLabel.text();
	yearLabel.remove();
	
	if(isBtnGraphEnable()) {
    	$('#btnDrawGraph').prop("disabled", false);
    }
    else {
    	$('#btnDrawGraph').prop("disabled", true);
    }
}

function selectCategory() {
    console.log("#S selectCategory()");
    var categoriesDDL = $("#categoriesDDL").val();
    $("#chartTitle").text(categoriesDDL);
    console.log("#S select -->> ", categoriesDDL);

    $("#myChart").empty();
    console.log("#S chart title is: ", $("#chartTitle").text());
} 

function selectClothModel() {
	console.log("#S selectClothModel()!");
	if(isBtnGraphEnable()) {
    	$('#btnDrawGraph').prop("disabled", false);
    }
    else {
    	$('#btnDrawGraph').prop("disabled", true);
    }
}

function resetYearsDDL() {
	console.log("#S resetYearsDDL()!");
	$('#yearDDL').empty();
	$('#selectedYearList').empty();
	console.log("#S remove selectedYearList");
//	$('#selectedYearList').html("");
	initClothDDL();
	
	if(isBtnGraphEnable()) {
    	$('#btnDrawGraph').prop("disabled", false);
    }
    else {
    	$('#btnDrawGraph').prop("disabled", true);
    }
}

function getLabels() {
	var labels = [];
	$('#selectedYearList').children('span').each(function(index, entry) {
		console.log("#S entry: ", entry);
		var year = $(entry).text();
		labels.push(year);
		console.log("#S year: ", year);
	});
	return labels;
}

function selectChartCategory() {
    
    var chartCategory = $("#chartCategory").val();
    console.log("#S selectchartCategory --> ", chartCategory);
    var selectedYearCount = $('#selectedYearList span').size();
    
    if(isBtnGraphEnable()) {
    	$('#btnDrawGraph').prop("disabled", false);
    }
    else {
    	$('#btnDrawGraph').prop("disabled", true);
    }
//    var title = $('#titleDDL').val();
//    if(chartCategory != "") {
//		if(selectedYearCount > 0 && chartCategory != "") {
			console.log("#S 1111");
//			$('#clothModelsDDL').prop("required", false);
//			$('#btnDrawGraph').prop("disabled", false);
//			$('#btnDrawGraph').prop("disabled", false);
//		}
//		else {
//			$('#btnDrawGraph').prop("disabled", true);
//			console.log("#S 2222");
//		}
//    }
//    else {
//    	$('#btnDrawGraph').prop("disabled", true);
//    }
    
//    myChart = new Chart(ctx, {
//	    type: chartCategory,
//	    data: data,
//	    options: {
//	        scales: {
//	            yAxes: [{
//	                ticks: {
//	                    beginAtZero:true
//	                }
//	            }]
//	        },
//	        legend: {
//	            display: true,
//	            labels: {
//	                fontColor: 'rgb(255, 99, 132)'
//	            }
//	        }
//	    }
//    });
}   

$('#graphForm').submit(function(event) {
	console.log("#S graphForm is submitted");
	var title = $('#titleDDL').val();
	var clothModel = $('#clothModelsDDL').val();
	var chartCategory = $('#chartCategory').val();
	var selectedYearCount = $('#selectedYearList span').size(); 
	console.log("#S title: ", title);
	console.log("#S clothModel: ", clothModel);
	console.log("#S chartCategory: ", chartCategory);
	console.log("#S selectedYearCount: ", selectedYearCount);
	
	if(selectedYearCount > 0) {
		if(title == "Cloth Model") {
			if(clothModel != "" && chartCategory != "") {
				console.log("#S 111111");
				getGraphInfo();
			}
		}
		else if(title == "Sales") {
			if(chartCategory != "") {
				console.log("#S 222222222");
				getGraphInfo();
			}
		}
	}
	else {
		$('.alert.alert-danger').show();
		setTimeout(function() {
			$('.alert.alert-danger').hide();
		}, 5000);
	}
});

$('#btnDrawGraph').click(function(event) {
	getGraphInfo();
});

function isBtnGraphEnable() {
	console.log("#S isBtnGraphEnable()");
	var title = $('#titleDDL').val();
	var selectedYearCount = $('#selectedYearList span').size();
	var chartCategory = $('#chartCategory').val();
	var clothModel = $('#clothModelsDDL').val();
	if(title != "Cloth Model") {
		console.log("#S title != Cloth Model");
		if(title != "" && chartCategory != "" && selectedYearCount > 0) {
			return true;
		}
		return false;
	}
	else {
		if(title != "" && chartCategory != "" && clothModel != "" && selectedYearCount > 0) {
			return true;
		}
		return false;
	}
}

//$('#graphForm').validator().on('submit', function (e) {
//	if (e.isDefaultPrevented()) {
//    // handle the invalid form...
//		console.log("#S invalid submit");
//	} else {
//    // everything looks good!
//		console.log("#S submit successfully");
//		console.log("#S graphForm is submitted");
//		var labels = getLabels();
//		console.log("#S labels: ", labels);
//		selectedYearList
//		getGraphInfo();
//	}
//});