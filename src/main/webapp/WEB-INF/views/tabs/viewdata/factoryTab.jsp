
<div class="page-header">
  <h3>View Data >&nbsp;<small>Factories</small></h3>
</div>
<div class="panel panel-default">
	<div class="panel-body">
    	<div class="row">
			<div class="col-sm-6">
				<div class="form-group">
					<label for="usr">Factory Name:&nbsp;</label>
					<select class="selectpicker" id="companiesDDL">
						<option value="">Please Select</option>									 	
						<option value="central chidlom">
							Central Chidlom
						</option>
						<option value="central chidlom">
							Emquatier
						</option>
						<option value="central chidlom">
							Central Pinklao
						</option>																
					</select>
				</div>
			</div> <!-- /.col-sm-6 -->
			<div class="col-sm-6">
				<div class="form-group pull-right">
					<label for="usr">Employers:&nbsp;</label>
					<select class="selectpicker" id="companiesDDL">
						<option value="">Please Select</option>									 	
						<option value="central chidlom">
							Sweather
						</option>
						<option value="central chidlom">
							Suit
						</option>
						<option value="central chidlom">
							T-Shirt
						</option>																
					</select>
				</div>
			</div> <!-- /.col-sm-6 -->
		</div> <!-- /.row -->
		
  	</div> <!-- /.panel-body -->
</div> <!-- /.panel -->
<div class="row">
	<div class="col-sm-12">
		<span class="pull-right"> 
  			<button type="button" class="btn btn-primary" id="btnProduce">
  				<i class="fa fa-search" aria-hidden="true"></i>&nbsp;Search
			</button>
			<div class="clearfix"></div>
		</span>
	</div>
</div>
<hr />
<div class="table-responsive" id="viewDataTable">          
	<table class="table">
  		<thead>
    		<tr>
				<th>#</th>
				<th>Factory Name</th>
				<th>Sewing</th>
				<th>Producing</th>
				<th>Own Brand</th>
				<th>View</th>
				<th>Edit</th>
				<th>Delete</th>
   			</tr>
  		</thead>
  		<tbody>
			<tr>
				<td>1</td>
				<td>Alaska Factory</td>
				<td>
					<span class="fa fa-check fa-green-font" aria-hidden="true"></span>
				</td>
				<td>
					<span class="fa fa-times fa-red-font" aria-hidden="true"></span>
				</td>
				<td>
					<span class="fa fa-times fa-red-font" aria-hidden="true"></span>
				</td>
				<td>
					<button type="button" class="btn btn-default" id="btnProduce">
  						<i class="fa fa-search-plus" aria-hidden="true"></i>
					</button>					
				</td>
				<td>
					<button type="button" class="btn btn-default" id="btnProduce">
  						<i class="fa fa-pencil" aria-hidden="true"></i>
					</button>
				</td>
				<td>
					<button type="button" class="btn btn-default" id="btnProduce">
  						<i class="fa fa-eraser" aria-hidden="true"></i>
					</button>
				</td>
    		</tr>
    		<tr>
				<td>2</td>
				<td>Yakuza Factory</td>
				<td>
					<span class="fa fa-times fa-red-font" aria-hidden="true"></span>
				</td>
				<td>
					<span class="fa fa-check fa-green-font" aria-hidden="true"></span>
				</td>
				<td>
					<span class="fa fa-times fa-red-font" aria-hidden="true"></span>
				</td>
				<td>
					<button type="button" class="btn btn-default" id="btnProduce">
  						<i class="fa fa-search-plus" aria-hidden="true"></i>
					</button>					
				</td>
				<td>
					<button type="button" class="btn btn-default" id="btnProduce">
  						<i class="fa fa-pencil" aria-hidden="true"></i>
					</button>
				</td>
				<td>
					<button type="button" class="btn btn-default" id="btnProduce">
  						<i class="fa fa-eraser" aria-hidden="true"></i>
					</button>
				</td>
    		</tr>
    		<tr>
				<td>3</td>
				<td>Chocolate Factory</td>
				<td>
					<span class="fa fa-times fa-red-font" aria-hidden="true"></span>
				</td>
				<td>
					<span class="fa fa-check fa-green-font" aria-hidden="true"></span>
				</td>
				<td>
					<span class="fa fa-times fa-red-font" aria-hidden="true"></span>
				</td>
				<td>
					<button type="button" class="btn btn-default" id="btnProduce">
  						<i class="fa fa-search-plus" aria-hidden="true"></i>
					</button>					
				</td>
				<td>
					<button type="button" class="btn btn-default" id="btnProduce">
  						<i class="fa fa-pencil" aria-hidden="true"></i>
					</button>
				</td>
				<td>
					<button type="button" class="btn btn-default" id="btnProduce">
  						<i class="fa fa-eraser" aria-hidden="true"></i>
					</button>
				</td>
    		</tr>
    		<tr>
				<td>4</td>
				<td>Bazuka Factory</td>
				<td>
					<span class="fa fa-check fa-green-font" aria-hidden="true"></span>
				</td>
				<td>
					<span class="fa fa-check fa-green-font" aria-hidden="true"></span>
				</td>
				<td>
					<span class="fa fa-check fa-green-font" aria-hidden="true"></span>
				</td>
				<td>
					<button type="button" class="btn btn-default" id="btnProduce">
  						<i class="fa fa-search-plus" aria-hidden="true"></i>
					</button>					
				</td>
				<td>
					<button type="button" class="btn btn-default" id="btnProduce">
  						<i class="fa fa-pencil" aria-hidden="true"></i>
					</button>
				</td>
				<td>
					<button type="button" class="btn btn-default" id="btnProduce">
  						<i class="fa fa-eraser" aria-hidden="true"></i>
					</button>
				</td>
    		</tr>
  		</tbody>
	</table>
</div> <!-- /.table-responsive -->