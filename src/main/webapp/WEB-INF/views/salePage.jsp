<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
   
        <div class="container">
			<div class="panel panel-primary header-margin-top">
				<div class="panel-heading">
					Sale
				</div>
				<div class="panel-body">
					
					<div class="row">
						<div class="col-sm-6">						
							<div class="form-group">
  								<label for="usr">Stores:&nbsp;</label>
  								<select class="selectpicker" id="storesDDL" onchange="selectStore()">
  									<option value="">Please Select</option>									 	
									<c:forEach var="entry" items="${storesMap}"> 	
									<option value="<c:out value="${entry.key}"/>">
										<c:out value="${entry.value}" />
									</option>
									</c:forEach>															
								</select>
							</div>
						</div>
						<div class="col-sm-6">						
							<div class="form-group">
	  							<button type="button" class="btn btn-primary" id="test" onclick="test()">
					  				<i class="fa fa-usd" aria-hidden="true"></i>&nbsp;Test
								</button>
	  							<label for="pwd">Cloth Model:&nbsp;</label>
	  							<select class="selectpicker" id="clothesDDL" onchange="selectClothModel()">
									<option value="">Please Select Store</option> 	
<%-- 									<c:forEach var="entry" items="${clothesMap}"> 	 --%>
<%-- 										<option value="<c:out value="${entry.key}"/>"> --%>
<%-- 											<c:out value="${entry.value}" /> --%>
<!-- 										</option> -->
<%-- 									</c:forEach> --%>
								</select>
							</div> 
						</div>
						
					</div> <!-- ./row -->
					<div class="row">
						<div class="col-sm-2">						
							<div class="form-group">
  								<label for="Amount">Amount To Sale</label>
  								<input type="number" class="form-control" id="amount" value="0" onblur="getTotalPrice()">
							</div>
						</div>
						<div class="col-sm-2">						
							<div class="form-group">
	  							<label for="pwd">Available</label>
	  							<div id="available" class="disabled-text">
	  								0
	  							</div>
							</div> 
						</div>
						
						<div class="col-sm-2">						
							<div class="form-group">
	  							<label for="pwd">Price Per One</label>
<!-- 	  							<input type="number" class="form-control" id="usr"> -->
								<div id="price" class="disabled-text">
	  								0
	  							</div>
							</div> 
						</div>
						<div class="col-sm-2">						
							<div class="form-group">
	  							<label for="pwd">Total Price (Sale)</label>
<!-- 	  							<input type="number" class="form-control" id="usr"> -->
								<div id="totalPrice" class="disabled-text">
	  								0
	  							</div>
							</div> 
						</div>
						<div class="col-sm-4">

							<div class="form-group">
								<label for="pwd">Sale Date</label>
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
			  			<button type="button" class="btn btn-primary" id="btnSale" onclick="sellProduct();">
			  				<i class="fa fa-usd" aria-hidden="true"></i>&nbsp;Sale
						</button>
						<!-- <div class="clearfix"></div> -->
			  		</span>
			  	</div>
			</div>
			
			<div style="height:100%">
			</div>
        </div> <!-- /.container -->
        <script src="/resources/core/js/pages/salePage.js"></script>
    </tiles:putAttribute>
</tiles:insertDefinition>