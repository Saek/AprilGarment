<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@page session="false" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>April Garment Application</title>
    
    <!-- CSS -->
<%-- 	<spring:url value="/resources/core/css/jquery-ui.min.css" var="jqueryUiCss" /> --%>
	<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
	<spring:url value="/resources/core/css/bootstrap-datepicker.min.css" var="bootstrapDatePickerCss" />
	<spring:url value="/resources/core/css/font-awesome.min.css" var="fontAwesomeCss" />
	<spring:url value="/resources/core/css/app-style.css" var="appStyleCss" />
	<spring:url value="/resources/core/css/bootstrap-select.min.css" var="bootstrapSelectCss" />
	<spring:url value="/resources/core/css/bootstrap-datetimepicker.min.css" var="bootstrapDateTimePickerCss" />
	
	<!-- JavaScript -->
	<spring:url value="/resources/core/js/jquery.1.10.2.min.js" var="jqueryJs" />
	<spring:url value="/resources/core/js/bootstrap-datepicker.min.js" var="bootstrapDatePickerJs" />
<%-- 	<spring:url value="/resources/core/js/jquery-ui.min.js" var="jqueryUiJs" /> --%>
	<spring:url value="/resources/core/js/moment.min.js" var="momentJs" />
	<spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs" />
	<spring:url value="/resources/core/js/chart.min.js" var="chartJs" />
	<spring:url value="/resources/core/js/bootstrap-select.min.js" var="bootstrapSelectJs" />
	<spring:url value="/resources/core/js/bootstrap-datetimepicker.min.js" var="bootstrapDateTimePickerJs" />
	<spring:url value="/resources/core/js/bootstrapValidator.min.js" var="bootstrapValidationJs" />
	<spring:url value="/resources/core/js/app-common.js" var="appCommonJs" />
	
<%-- 	<link href="${jqueryUiCss}" rel="stylesheet" /> --%>
	<link href="${bootstrapCss}" rel="stylesheet" />
	<link href="${bootstrapDatePickerCss}" rel="stylesheet" />
	<link href="${fontAwesomeCss}" rel="stylesheet" />
	<link href="${bootstrapSelectCss}" rel="stylesheet" />
	<link href="${bootstrapDateTimePickerCss}" rel="stylesheet" />
	<link href="${appStyleCss}" rel="stylesheet" />
	
	
	<script src="${jqueryJs}"></script>
	<script src="${bootstrapDatePickerJs}"></script>
<%-- 	<script src="${jqueryUiJs}"></script> --%>
	<script src="${momentJs}"></script>
	<script src="${bootstrapJs}"></script>
	<script src="${chartJs}"></script>
	<script src="${bootstrapSelectJs}"></script>
	<script src="${bootstrapDateTimePickerJs}"></script>
	<script src="${bootstrapValidationJs}"></script>
	<script src="${appCommonJs}"></script>
</head>
<body>
	<div class="page">
		<tiles:insertAttribute name="header" />
		<div class="content-fluid background-content">
			<tiles:insertAttribute name="body" />
		</div>
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>