<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url value="/resources/core/css/pages/compare-page.css" var="comparePageCss" />

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
	    <link href="${comparePageCss}" rel="stylesheet" />
	    <div class="container-fluid">
		    <div class="alert alert-warning" style="display:none;">
				<strong>Warning!</strong>&nbsp;&nbsp;<span id="successMessage">Amount to produce must greater than zero</span> 
			</div>
			<div class="alert alert-danger" style="display:none;">
				<strong>Warning!</strong>&nbsp;&nbsp;<span id="errorMessage">Please Specify The Years</span> 
			</div>
<!-- 			<form data-toggle="validator" role="form" id="graphForm"> -->
			    <div class="panel panel-default">
					<div class="panel-body">
					    <div class="row">
							<div class="col-sm-8">
								<div class="form-group pull-left margin-left-15px">
									<label for="usr">Title Category:&nbsp;</label> 
							        <select id="titleDDL" onchange="selectTitle()" class="selectpicker" required>
							            <option value="">Please Select</option>
							            <option value="Cloth Model">Cloth Model</option>
							            <option value="Sales">Sales</option>
							        </select>
							        <div class="help-block with-errors"></div>
							    </div>
							    <div class="form-group pull-left margin-left-20px">
									<div id="clothModelForm" style="display:none;">
										<label for="usr">Cloth Models:&nbsp;</label> 
								        <select id="clothModelsDDL" onchange="selectClothModel()" class="selectpicker" required>
								            <option value="">Please Select</option>
								            <c:forEach var="entry" items="${clothesMap}"> 	
												<option value="<c:out value="${entry.key}" />">
													<c:out value="${entry.value}" />
												</option>
											</c:forEach>
								        </select>
								        
								        <div class="help-block with-errors"></div>
									</div>							        
							    </div>
							</div>
							<div class="col-sm-4">
							    <div class="form-group pull-right margin-left-15px">
									<label for="usr">Graph Category:&nbsp;</label> 
							        <select id="chartCategory" onchange="selectChartCategory();" class="selectpicker" required>
							            <option value="">Please Select</option>
							            <option value="bar">bar</option>
							            <option value="line">line</option>
							        </select>
							        <div class="help-block with-errors"></div>
								</div>
							</div>        
				    	</div> <!-- /.row -->
				    	<div class="row">
				    		<div class="col-sm-6">
				    			<div class="form-group pull-left margin-left-15px">
									<label for="usr">Year:&nbsp;</label> 
							        <select id="yearDDL" class="selectpicker" onchange="selectYear()">
							        </select>
							        <div class="help-block with-errors"></div>
								</div>
								<button type="button" class="btn btn-primary margin-left-15px" id="btnAddDate" onclick="addYear()">
	  								<i class="fa fa-plus" aria-hidden="true"></i>
								</button>
								<button type="button" class="btn btn-baby-blue" id="btnAddDate" onclick="resetYearsDDL()">
	  								<i class="fa fa-repeat" aria-hidden="true"></i>
								</button>
				    		</div>
				    		<div class="col-sm-6">
				    			
				    		</div>
				    	</div> <!-- /.row -->
				    	<div class="row">
				    		<div class="col-sm-6">
				    			<div class="margin-left-15px">
					    			<h4 id="selectedYearList">
						    			<!-- <span class="label label-default">2017<i class="fa fa-times small-cross" aria-hidden="true"></i></span> -->
						    			<!-- <span class="label label-default"><i class="fa fa-times" aria-hidden="true"></i></span> -->
										<!-- <span class="label label-primary">2016</span>
										<span class="label label-success">2015</span>
										<span class="label label-info">2014</span> -->
									</h4>
								</div>
				    		</div>
				    		<div class="col-sm-6">
				    			<button type="submit" class="btn btn-primary margin-left-15px pull-right" id="btnDrawGraph" disabled>
	  								<i class="fa fa-bar-chart " aria-hidden="true"></i>&nbsp;Show Graph
								</button>
				    		</div>
				    	</div>
				    </div> <!-- /.panel-body -->
				</div> <!-- /.panel panel-default -->
<!-- 			</form> -->
			<div class="first-chart-wrapper" id="displayFirstChartArea">
		        <h1 id="chartTitle" style="display:none;">Cloth Model:<span id="modelName"></span></h1>
		        <canvas id="myChart"></canvas>
		    </div>
		    <div style="width: 500px; height: 500px; margin: auto; margin-top: -200px; display:none;">
		        <canvas id="mySecondChart" width:"150" height: "150"></canvas>
			</div>
		</div> <!-- /.container -->
        <script src="/resources/core/js/pages/comparePage.js"></script>
    </tiles:putAttribute>
</tiles:insertDefinition>