<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url value="/resources/core/css/pages/view-cloth-detail-modal.css" var="viewClothDetailModal" />
<link href="${viewClothDetailModal}" rel="stylesheet" />

<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog">
	<div class="modal-dialog modal-md">
    
      <!-- Modal content-->
		<div class="modal-content">
        	<div class="modal-header">
          		<button type="button" class="close" data-dismiss="modal">&times;</button>
          		<h4 class="modal-title">Cloth Detail</h4>
       		</div>
        	<div class="modal-body">
<!--           		<div class="container"> -->
<!--           			<div class="row"> -->
<!--           				<div class="modal-body-content"> -->
<!--           					Cloth Model: <span id="clothModel"></span>  -->
<!--           				</div> -->
<!--           			</div> -->
<!--           		</div> -->
				<table class="table table-striped">
					<tr>
						<td>Model:</td>
						<td id="clothModel"></td>
					</tr>
					<tr>
						<td>Type:</td>
						<td id="clothType"></td>
					</tr>
					<tr>
						<td>Group:</td>
						<td id="clothGroup"></td>
					</tr>
					<tr>
						<td>Brand:</td>
						<td id="clothBrand"></td>
					</tr>
					<tr>
						<td>Price:</td>
						<td id="clothPrice"></td>
					</tr>
					<tr>
						<td>Color:</td>
						<td id="clothColor"></td>
					</tr>
					<tr>
						<td>Size:</td>
						<td id="clothSize"></td>
					</tr>
				</table>
          		
        	</div>
        	<div class="modal-footer">
          		<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        	</div>
      	</div> <!-- /.modal-content -->
	</div> <!-- /.modal-dialog -->
</div>

<script src="/resources/core/js/pages/viewClothDetailModal.js"></script>