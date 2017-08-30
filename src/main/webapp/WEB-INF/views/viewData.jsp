<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url value="/resources/core/css/pages/view-data.css" var="viewDataCss" />
<link href="${viewDataCss}" rel="stylesheet" />

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
      
   		<div class="container">
			<div class="panel with-nav-tabs panel-primary">
		        <div class="panel-heading">
		            <ul class="nav nav-tabs">
		                <li class="active">
		                	<a href="/viewClothTab" data-toggle="tabajax" data-target="#clothTab">
		                		Clothes
		                	</a>
		                </li>
		                <li>
		                	<a href="/viewFactoryTab" data-toggle="tabajax" data-target="#factoryTab">
		                		Factories
		                	</a>
		                </li>
		                <li>
		                	<a href="/viewStoreTab" data-toggle="tabajax" data-target="#storeTab">
		                		Stores
		                	</a>
		                </li>
		                <li>
		                	<a href="/viewSaleTab" data-toggle="tabajax" data-target="#saleTab">
		                		Sales
		                	</a>
		                </li>
		            </ul>
		        </div>
	            <div class="panel-body">
	                <div class="tab-content">
	                    <div class="tab-pane fade in active" id="clothTab">
						</div>
	                    <div class="tab-pane fade" id="factoryTab">
						</div>
	                    <div class="tab-pane fade" id="storeTab">
						</div>
	                    <div class="tab-pane fade" id="saleTab">
						</div>
	                </div>
	            </div>
			</div>
			<div style="height:100%">
			</div>
		</div> <!-- /.container -->
		
		<script src="/resources/core/js/pages/viewData.js"></script>
    </tiles:putAttribute>
</tiles:insertDefinition>