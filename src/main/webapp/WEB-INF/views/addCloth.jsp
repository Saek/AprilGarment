<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
 
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
   
        <div class="container">
       		<form data-toggle="validator" role="form"> 
	        	<div class="panel panel-primary header-margin-top">
					<div class="panel-heading">Add Cloth</div>
					<div class="panel-body">
						
						<div class="row">
							<div class="col-sm-3">						
								<div class="form-group has-feedback">
	  								<label for="usr">Cloth Category</label>
	  								<input type="text" placeholder="eg. 240.35 (baht)" class="form-control col-xs-1" id="usr" required>
									<div class="help-block with-errors"></div>
								</div>
							</div>
							<div class="col-sm-3">						
								<div class="form-group">
		  							<label for="pwd">Cloth Model</label>
		  							<input type="text" class="form-control" id="usr" required>
		  							<div class="help-block with-errors"></div>
								</div> 
							</div>
							<div class="col-sm-2">						
								<div class="form-group">
		  							<label for="pwd">Price</label>
		  							<input type="number" class="form-control" id="usr" required>
		  							<div class="help-block with-errors">&nbsp;<i>(number only)</i></div>
								</div> 
							</div>
							<div class="col-sm-2">						
								<div class="form-group">
	  								<label for="usr">Size</label>
	  								<input type="text" class="form-control" id="usr" required>
	  								<div class="help-block with-errors"></div>
								</div>
							</div>
							<div class="col-sm-2">						
								<div class="form-group">
		  							<label for="pwd">Color</label>
		  							<input type="text" class="form-control" id="usr" required>
		  							<div class="help-block with-errors"></div>
								</div> 
							</div>
						</div> <!-- ./row -->
						
						<div class="row">
							<div class="col-sm-3">						
								<div class="form-group">
	  								<label for="usr">Cloth Brand</label>
	  								<input type="number" placeholder="eg. 240.35 (baht)" class="form-control col-xs-1" id="usr" required>
	  								<div class="help-block with-errors">&nbsp;<i>(number only)</i></div>
								</div>
							</div>
							<div class="col-sm-3">						
								<div class="form-group">
		  							<label for="pwd">Cloth Group</label>
		  							<input type="text" placeholder="sport wear" class="form-control" id="usr" required>
		  							<div class="help-block with-errors"></div>
								</div> 
							</div>
							<div class="col-sm-6">						
							</div>
						</div> <!-- ./row -->
							
					</div> <!-- /.form-group -->
				  	<div class="panel-footer clearfix">
				  		<span class="pull-right">
				  			<button type="submit" class="btn btn-primary">
				  				<i class="fa fa-plus" aria-hidden="true"></i>&nbsp;Add
							</button>
				  		</span>
				  	</div>
				</div>
			</form>
			<div style="height:50%">
			</div>
        
        </div> <!-- /.container -->
        <script src="/resources/core/js/pages/addCloth.js"></script>
    </tiles:putAttribute>
</tiles:insertDefinition>