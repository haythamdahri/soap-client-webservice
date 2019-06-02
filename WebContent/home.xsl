<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:ns1="http://www.prix-action.ma">
	<xsl:output method="html" encoding="UTF-8" indent="yes" />
	<xsl:template match="/">
		<html lang="en">
			<head>
				<!-- Required meta tags -->
				<meta charset="utf-8" />
				<meta name="viewport"
					content="width=device-width, initial-scale=1, shrink-to-fit=no" />
					
				<link rel="icon" href="./static/images/web-service-img.png" />

				<!-- Bootstrap CSS -->
				<link rel="stylesheet" href="./static/css/bootstrap.min.css" />

				<!-- Bootstrap CSS -->
				<link rel="stylesheet" href="./static/css/all.min.css" />
				
				<title>Client web service : Acceuil</title>
			</head>
			<body>
				<!-- navbar -->
				<nav class="navbar navbar-expand-lg navbar-light bg-light">
					<a class="navbar-brand" href="/price-action"><i class="fab fa-aws"></i> Client Prix Action</a>
					<button class="navbar-toggler" type="button"
						data-toggle="collapse" data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>

					<div class="collapse navbar-collapse"
						id="navbarSupportedContent">
						<ul class="navbar-nav mr-auto">
							<li class="nav-item active">
								<a class="nav-link" href="/price-action">
									<i class="fas fa-home"></i> Acceuil
									<span class="sr-only">(current)</span>
								</a>
							</li>
							<li class="nav-item active">
								<a class="nav-link" href="/price-action">
									<i class="fas fa-sign-in-alt"></i> Se connecter
									<span class="sr-only">(current)</span>
								</a>
							</li>
						</ul>
						<form class="form-inline my-2 my-lg-0">
							<input class="form-control mr-sm-2" type="search"
								placeholder="Recherche..." aria-label="Search" />
								<button class="btn btn-outline-success my-2 my-sm-0"
									type="submit">Chercher</button>
						</form>
					</div>
				</nav>

				<!-- Container -->
				<div class="container">
					<h1 class="display-4">Premiere Bourse du web service</h1>
					<table class="table table-striped table-hover table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Name</th>
							</tr>
							<tr>
								<td>
									<xsl:value-of select="ns1:bourse/@ns1:id" />
								</td>
								<td>
									<xsl:value-of select="ns1:bourse/ns1:name" />
								</td>
							</tr>
						</thead>
					</table>
				</div>

				<!-- Optional JavaScript -->
				<!-- jQuery first, then Popper.js, then Bootstrap JS -->
				<script src="./static/js/jquery.min.js"></script>
				<script src="./static/js/popper.min.js"></script>
				<script src="./static/js/all.min.js"></script>
				<script src="./static/js/bootstrap.min.js"></script>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>