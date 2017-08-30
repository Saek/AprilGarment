<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url value="/resources/core/css/pages/product-page.css" var="productPageCss" />
<link href="${productPageCss}" rel="stylesheet" />

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <div class="container">
			<div class="panel panel-primary header-margin-top">
				<div class="panel-heading">Add Product</div>
				<div class="panel-body">
					
					<div class="row">
						<div class="col-sm-6">						
							<div class="form-group">
  								<label for="usr">Factory Name:&nbsp;</label>
  								<select class="selectpicker" id="factoriesDDL">
  									<option value="">Please Select</option>
									<c:forEach var="entry" items="${factoriesMap}"> 	
										<option value="<c:out value="${entry.key}"/>">
											<c:out value="${entry.value}" />
										</option>
									</c:forEach>	
							
								</select>
							</div>
						</div>
						<div class="col-sm-6">						
							<div class="form-group">
	  							<label for="pwd">Cloth Model:&nbsp;</label>
	  							<select class="selectpicker" id="clothesDDL" onchange="selectClothModel()">
									<option value="">Please Select</option>
									<c:forEach var="entry" items="${clothesMap}"> 	
										<option value="<c:out value="${entry.key}" />">
											<c:out value="${entry.value}" />
										</option>
									</c:forEach>
								</select>
							</div> 
						</div>
						
					</div> <!-- ./row -->
					<div class="row">
						<div class="col-sm-2">						
							<div class="form-group">
	  							<label for="pwd">Price Per One</label>
<!-- 	  							<input type="number" class="form-control" id="clothPrice"> -->
	  							<div id="price" class="disabled-text">
	  								0
	  							</div>
							</div> 
						</div>
						<div class="col-sm-2">						
							<div class="form-group">
  								<label for="Amount">Amount To Produce</label>
  								<input type="number" class="form-control" id="amount" value="0" onblur="getTotalPrice()">
							</div>
						</div>
						<div class="col-sm-2">						
							<div class="form-group">
	  							<label for="pwd">Total Price</label>
<!-- 	  							<input type="number" class="form-control" id="usr"> -->
								<div id="totalPrice" class="disabled-text">
	  								0
	  							</div>
							</div> 
						</div>
						<div class="col-sm-6">
<!-- 							<div class="form-group"> -->
<!-- 	  							<label for="pwd">Produce Date</label> -->
<!-- 								<input type="text" class="form-control" name="produceDatePicker" id="produceDatePicker"> -->
<!-- 							</div>  -->
							<div class="form-group">
								<label for="pwd">Current Date</label>
				                <div class='input-group date' id='datetimepicker5'>
				                    <input type='text' class="form-control" />
				                    <span class="input-group-addon">
				                        <span class="glyphicon glyphicon-calendar"></span>
				                    </span>
				                </div>
				            </div>
						</div>
					</div>	
				</div> <!-- /.panel-body -->
			  	<div class="panel-footer clearfix">
			  		<div class="alert alert-danger" style="display:none;">
  						<strong>Warning!</strong>&nbsp;&nbsp;<span id="errorMessage">Amount to produce must greater than zero</span> 
					</div>
					<div class="alert alert-success" style="display:none;">
  						<strong>Warning!</strong>&nbsp;&nbsp;<span id="errorMessage">Clothes have been produced successfully!</span> 
					</div>
			  		<span class="pull-right">
			  			<button type="button" class="btn btn-primary" id="btnProduce">
			  				<i class="fa fa-plus" aria-hidden="true"></i>&nbsp;Produce
						</button>
						<!-- <div class="clearfix"></div> -->
			  		</span>
			  	</div>
			</div>
			
			<div style="height:100%">
			</div>
        </div> <!-- /.container -->
        <script src="/resources/core/js/pages/productPage.js"></script>
    </tiles:putAttribute>
</tiles:insertDefinition>