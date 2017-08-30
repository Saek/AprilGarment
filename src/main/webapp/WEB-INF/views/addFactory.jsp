<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/resources/core/css/pages/add-cloth.css" var="addClothCss" />
<link href="${addClothCss}" rel="stylesheet" />

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
   		 
		<div class="container">
			
<!-- 			style="display: none; -->
			<div class="panel panel-baby-blue header-margin-top">
				<div class="panel-heading">Add Factory</div>
				<div class="panel-body">
					<h4>Factory Info</h4>
					<hr/>
					<div class="row">
						<div class="col-sm-4">						
							<div class="form-group">
  								<label for="usr">Factory Name</label>
  								<input type="text" placeholder="eg. 240.35 (baht)" class="form-control" id="usr">
							</div>
						</div>
						<div class="col-sm-4">						
							<div class="form-group">
	  							<label for="pwd">Factory Owner</label>
	  							<input type="text" class="form-control" id="usr">
							</div> 
						</div>
						<div class="col-sm-4">						
							<div class="form-group">
	  							<label for="pwd">Founded Date</label>
	  							<input type="text" class="form-control" id="usr">
							</div> 
						</div>
					</div> <!-- ./row -->
					<h4>Factory Address</h4>
					<hr/>	
					<div class="row">
						<div class="col-sm-6">						
							<div class="form-group">
  								<label for="usr">House No.</label>
  								<input type="number" placeholder="eg. 240.35 (baht)" class="form-control col-xs-1" id="usr">
							</div>
						</div>
						<div class="col-sm-6">						
							<div class="form-group">
	  							<label for="pwd">Village No.</label>
	  							<input type="text" class="form-control" id="usr">
							</div> 
						</div>
					</div> <!-- ./row -->
					<div class="row">
						<div class="col-sm-6">						
							<div class="form-group">
  								<label for="usr">Alley</label>
  								<input type="number" placeholder="eg. 240.35 (baht)" class="form-control col-xs-1" id="usr">
							</div>
						</div>
						<div class="col-sm-6">						
							<div class="form-group">
	  							<label for="pwd">Lane</label>
	  							<input type="text" class="form-control" id="usr">
							</div> 
						</div>
					</div> <!-- ./row -->
					<div class="row">
						<div class="col-sm-6">						
							<div class="form-group">
  								<label for="usr">Lane</label>
  								<input type="number" placeholder="eg. 240.35 (baht)" class="form-control col-xs-1" id="usr">
							</div>
						</div>
						<div class="col-sm-6">						
							<div class="form-group">
	  							<label for="pwd">Road</label>
	  							<input type="text" class="form-control" id="usr">
							</div> 
						</div>
					</div> <!-- ./row -->
					<div class="row">
						<div class="col-sm-6">						
							<div class="form-group">
  								<label for="usr">Sub District</label>
  								<input type="number" placeholder="eg. 240.35 (baht)" class="form-control col-xs-1" id="usr">
							</div>
						</div>
						<div class="col-sm-6">						
							<div class="form-group">
	  							<label for="pwd">District</label>
	  							<input type="text" class="form-control" id="usr">
							</div> 
						</div>
					</div> <!-- ./row -->
					<div class="row">
						<div class="col-sm-6">						
							<div class="form-group">
  								<label for="usr">Province</label>
  								<input type="number" placeholder="eg. 240.35 (baht)" class="form-control col-xs-1" id="usr">
							</div>
						</div>
						<div class="col-sm-6">						
							<div class="form-group">
	  							<label for="pwd">Postal Code</label>
	  							<input type="text" class="form-control" id="usr">
							</div> 
						</div>
					</div> <!-- ./row -->
					<div class="row">
						<div class="col-sm-6">						
							<div class="form-group">
  								<label for="usr">Country</label>
  								<input type="number" placeholder="eg. 240.35 (baht)" class="form-control col-xs-1" id="usr">
							</div>
						</div>
						<div class="col-sm-6">						
							<div class="form-group">
	  							<label for="pwd">Contact</label>
	  							<input type="text" class="form-control" id="usr">
							</div> 
						</div>
					</div> <!-- ./row -->
					<h4>Factory Role</h4>
					<hr/>	
					<div class="row">
						<div class="col-sm-4">						
							<label class="checkbox-inline">
      							<input type="checkbox" value=""><b><i>Checked!</i></b>, If your factory is <b>SEWING</b> cloth
    						</label>
						</div>
						<div class="col-sm-4">						
							<label class="checkbox-inline">
      							<input type="checkbox" value=""><b><i>Checked!</i></b>, If your factory is <b>PRODUCING</b> cloth
    						</label>
						</div>
						<div class="col-sm-4">						
							<label class="checkbox-inline">
      							<input type="checkbox" value=""><b><i>Checked!</i></b>, If your factory has it's <b>OWN BRAND</b>
    						</label>
						</div>
					</div> <!-- ./row -->
					<hr/>
					</br>
					<h4>Employers</h4>
					<hr/>	
					<div class="row">
						<div class="col-sm-8">						
							<div class="form-group">
	  							<label for="pwd">Factory Name</label>
	  							<input type="text" class="form-control" id="usr">
							</div> 
						</div>
						<div class="col-sm-4">						
  							<button type="button" class="btn btn-baby-blue margin-top-24px">
				  				<i class="fa fa-plus" aria-hidden="true"></i>&nbsp;Add
							</button>
						</div>	
					</div> <!-- ./row -->
					<div class="row">
						<div class="col-sm-12">
							<div id="factoriesList">
								<ul class="list-group">
  									<li class="list-group-item item-list-align">
										<span class="clearfix">  											
  											<font class="font-list">Alaska Factory</font>
	  										<button type="button" class="btn btn-danger pull-right ">
								  				<i class="fa fa-times" aria-hidden="true"></i>
											</button>
										</span> 
  									</li>
  									<li class="list-group-item item-list-align">
  										<span class="clearfix">  											
  											<font class="font-list">Bejing Factory</font>
	  										<button type="button" class="btn btn-danger pull-right ">
								  				<i class="fa fa-times" aria-hidden="true"></i>
											</button>
										</span> 
									</li>
  									<li class="list-group-item item-list-align">
  										<span class="clearfix">  											
  											<font class="font-list">Yakuza Factory</font>
	  										<button type="button" class="btn btn-danger pull-right ">
								  				<i class="fa fa-times" aria-hidden="true"></i>
											</button>
										</span> 
									</li>
								</ul>
								
							</div> <!-- /#factoriesList -->
						</div> <!-- /.col-sm-12 -->
					</div> <!-- /.row -->
					<h4>Brands</h4>
					<hr/>	
					<div class="row">
						<div class="col-sm-8">						
							<div class="form-group">
	  							<label for="pwd">Brand Name</label>
	  							<input type="text" class="form-control" id="usr">
							</div> 
						</div>
						<div class="col-sm-4">						
  							<button type="button" class="btn btn-baby-blue margin-top-24px">
				  				<i class="fa fa-plus" aria-hidden="true"></i>&nbsp;Add
							</button>
						</div>	
					</div> <!-- ./row -->
					<div class="row">
						<div class="col-sm-12">
							<div id="factoriesList">
								<ul class="list-group">
  									<li class="list-group-item item-list-align">
										<span class="clearfix">  											
  											<font class="font-list">X Brand</font>
	  										<button type="button" class="btn btn-danger pull-right ">
								  				<i class="fa fa-times" aria-hidden="true"></i>
											</button>
										</span> 
  									</li>
  									<li class="list-group-item item-list-align">
  										<span class="clearfix">  											
  											<font class="font-list">Y Brand</font>
	  										<button type="button" class="btn btn-danger pull-right ">
								  				<i class="fa fa-times" aria-hidden="true"></i>
											</button>
										</span> 
									</li>
  									<li class="list-group-item item-list-align">
  										<span class="clearfix">  											
  											<font class="font-list">Z Brand</font>
	  										<button type="button" class="btn btn-danger pull-right ">
								  				<i class="fa fa-times" aria-hidden="true"></i>
											</button>
										</span> 
									</li>
								</ul>
								
							</div> <!-- /#brandsList -->
						</div> <!-- /.col-sm-12 -->
					</div> <!-- /.row -->
					<h4>Department Stores</h4>
					<hr/>	
					<div class="row">
						<div class="col-sm-8">						
							<div class="form-group">
	  							<label for="pwd">Mall Name</label>
	  							<input type="text" class="form-control" id="usr">
							</div> 
						</div>
						<div class="col-sm-4">						
  							<button type="button" class="btn btn-baby-blue margin-top-24px">
				  				<i class="fa fa-plus" aria-hidden="true"></i>&nbsp;Add
							</button>
						</div>	
					</div> <!-- ./row -->
					<div class="row">
						<div class="col-sm-12">
							<div id="mallsList">
								<ul class="list-group">
  									<li class="list-group-item item-list-align">
										<span class="clearfix">  											
  											<font class="font-list">Central Rama III</font>
	  										<button type="button" class="btn btn-danger pull-right ">
								  				<i class="fa fa-times" aria-hidden="true"></i>
											</button>
										</span> 
  									</li>
  									<li class="list-group-item item-list-align">
  										<span class="clearfix">  											
  											<font class="font-list">Emporium</font>
	  										<button type="button" class="btn btn-danger pull-right ">
								  				<i class="fa fa-times" aria-hidden="true"></i>
											</button>
										</span> 
									</li>
  									<li class="list-group-item item-list-align">
  										<span class="clearfix">  											
  											<font class="font-list">Emquartier</font>
	  										<button type="button" class="btn btn-danger pull-right ">
								  				<i class="fa fa-times" aria-hidden="true"></i>
											</button>
										</span> 
									</li>
									<li class="list-group-item item-list-align">
  										<span class="clearfix">  											
  											<font class="font-list">Central Chidlom</font>
	  										<button type="button" class="btn btn-danger pull-right ">
								  				<i class="fa fa-times" aria-hidden="true"></i>
											</button>
										</span> 
									</li>
								</ul>
								
							</div> <!-- /#mallsList -->
						</div> <!-- /.col-sm-12 -->
					</div> <!-- /.row -->
				</div> <!-- /.panel-body -->
			  	<div class="panel-footer clearfix">
			  		<span class="pull-right">
			  			<button type="button" class="btn btn-baby-blue">
			  				<i class="fa fa-plus" aria-hidden="true"></i>&nbsp;Add
						</button>
						<!-- <div class="clearfix"></div> -->
			  		</span>
			  	</div>
			</div>
		</div> <!-- /.container -->
        
    </tiles:putAttribute>
</tiles:insertDefinition>