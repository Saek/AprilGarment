<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
 
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        
        <div class="container" style="min-height: 500px">

			<div class="starter-template">
				<h1>Login Form</h1>
				<br>
		
				<p><font color="red">${errorMessage}</font></p>
				<form class="form-horizontal" id="login-form" action="/login" method="POST">
					<div class="form-group form-group-lg">
						<label class="col-sm-2 control-label">Name: </label>
						<div class="col-sm-10">
							<input name="name" type=text class="form-control" id="username" />
						</div>
					</div>
					<div class="form-group form-group-lg">
						<label class="col-sm-2 control-label">Password: </label>
						<div class="col-sm-10">
							<input name="password" type="password" class="form-control" id="email" />
						</div>
					</div>
		
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" id="bth-login" class="btn btn-primary btn-lg">Login</button>
						</div>
					</div>
				</form>
			</div> <!-- /.starter-template -->
			
		</div> <!-- /.container -->
 		
 		<script>
 			$("#bth-login").click(function(event) {
 				console.log("#S login is clicked!");
 				$("#login-form").submit();
 			}) ;
 		</script>
    </tiles:putAttribute>
</tiles:insertDefinition>