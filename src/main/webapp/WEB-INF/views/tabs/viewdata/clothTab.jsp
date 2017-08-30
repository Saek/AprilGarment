<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- <div class="loader-overlay">
	<div class="loader-spinner">
	</div>
</div> -->

<div class="page-header">
  <h3>View Data >&nbsp;<small>Clothes</small></h3>
</div>
<div class="panel panel-default">
	<div class="panel-body">
    	<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<label for="usr">Cloth Model:&nbsp;</label>
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
			<div class="col-sm-4">
				<div class="form-group">
					<label for="usr">Cloth Type:&nbsp;</label>
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
			<div class="col-sm-4">
				<div class="form-group">
					<label for="usr">Cloth Group:&nbsp;</label>
					<select class="selectpicker" id="companiesDDL">
						<option value="">Please Select</option>									 	
						<option value="central chidlom">
							Sport
						</option>
						<option value="central chidlom">
							Street
						</option>
						<option value="central chidlom">
							Wedding
						</option>
						<option value="central chidlom">
							Orchestra
						</option>																
					</select>
				</div>
			</div>
		</div> <!-- /.row -->
		
  	</div> <!-- /.panel-body -->
</div> <!-- /.panel -->
<div class="row">
	<div class="col-sm-12">
		<span class="pull-right"> 
  			<button type="button" class="btn btn-primary" id="btnProduce" onclick="showLoader()">
  				<i class="fa fa-search" aria-hidden="true"></i>&nbsp;Search
			</button>
			<div class="clearfix"></div>
		</span>
	</div>
</div>
<hr />
<div class="table-responsive">          
	<table class="table">
  		<thead>
    		<tr>
				<th>#</th>
				<th>Cloth Model</th>
				<th>Cloth Type</th>
				<th>Cloth Group</th>
				<th>Color</th>
				<th>Price</th>
				<th>View</th>
				<th>Edit</th>
				<th>Delete</th>
   			</tr>
  		</thead>
  		<tbody>
  			<c:forEach var="cloth" items="${clothList}" varStatus="status">
  				<tr>
  					<td><c:out value="${status.index + 1}" /></td>
  					<td><c:out value="${cloth.model}" /> </td>
  					<td><c:out value="${cloth.clothType}" /> </td>
  					<td><c:out value="${cloth.clothGroup}" /> </td>
  					<td><c:out value="${cloth.color}" /> </td>
  					<td><c:out value="${cloth.price}" /> </td>
	  				<td>
						<button type="button" class="btn btn-default" id="btnProduce" 
							data-toggle="modal" data-target="#myModal" onclick="openModal(${cloth.clothId})">
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
  			</c:forEach>
  		</tbody>
	</table>
</div> <!-- /.table-responsive -->
<script src="/resources/core/js/pages/clothTab.js"></script>