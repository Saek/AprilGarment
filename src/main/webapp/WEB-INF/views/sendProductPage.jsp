<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
   
        <div class="container">
        
        	<div class="panel panel-primary header-margin-top">
				<div class="panel-heading">Send Product</div>
				<div class="panel-body">
					
					<div class="row">
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
						<div class="col-sm-6">
							<div class="form-group">
	  							<label for="pwd">Stores:&nbsp;</label>
	  							<select class="selectpicker" id="storeDDL">
									<option value="">Please Select</option>
									<c:forEach var="entry" items="${storesMap}"> 	
										<option value="<c:out value="${entry.key}" />">
											<c:out value="${entry.value}" />
										</option>
									</c:forEach>
								</select>
							</div> 
						</div>
					</div>
					<div class="row">

						<div class="col-sm-2">
							<div class="form-group">
	  							<label for="pwd">Available</label>
<!-- 	  							<input type="number" class="form-control" id="clothPrice"> -->
	  							<div id="available" class="disabled-text">
	  								0
	  							</div>
							</div> 						
						</div>
						<div class="col-sm-2">						
							<div class="form-group">
  								<label for="usr">Amount To Send</label>
  								<input type="number" placeholder="eg. 10 clothes" class="form-control col-xs-1" id="amount" value="0">
							</div>
						</div>
						<div class="col-sm-3">						
							<div class="form-group">
								<label for="pwd">Send Date</label>
				                <div class='input-group date' id='datetimepicker5'>
				                    <input type='text' class="form-control" />
				                    <span class="input-group-addon">
				                        <span class="glyphicon glyphicon-calendar"></span>
				                    </span>
				                </div>
				            </div>
						</div>
						
					</div> <!-- ./row -->
						
				</div> <!-- /.form-group -->
			  	<div class="panel-footer clearfix">
			  		<span class="pull-right">
			  			<button type="button" class="btn btn-primary" id="sendProduct">
			  				<i class="fa fa-paper-plane" aria-hidden="true"></i>&nbsp;Send
						</button>
						<!-- <div class="clearfix"></div> -->
			  		</span>
			  	</div>
			</div>
			
			<div style="height:100%">
			</div>
        
        </div>
        <script src="/resources/core/js/pages/sendProductPage.js"></script>
    </tiles:putAttribute>
</tiles:insertDefinition>