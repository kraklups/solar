<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    	<meta name="viewport" content="width=device-width, initial-scale=1"/>
    	
		<title>Default tiles template</title>
		
		<!-- Bootstrap Core CSS -->
    	<link href="css/bootstrap.min.css" rel="stylesheet">
				
		<!-- Custom CSS -->
		<link href="css/sb-admin.css" rel="stylesheet">
		
    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css">		
		
	</head>
	
	<body>
	
		<div class="page">
			<tiles:insertAttribute name="header" />
			<div class="content">
				<tiles:insertAttribute name="menu" />
				<tiles:insertAttribute name="body" />
			</div>
			<tiles:insertAttribute name="footer" />
		</div>
		
    <!-- jQuery Version 1.11.0 -->
    <script src="js/jquery-1.11.0.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>		

    <!-- Firebug JavaScript -->
    <script src="js/Firebug/firebug.js"></script>		
		
	</body>
	
</html>