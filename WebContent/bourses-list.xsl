<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:ns1="http://www.prix-action.ma"
	xmlns:ns2="http://www.prix-action.ma">
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
					<a class="navbar-brand" href="/price-action">
						<i class="fab fa-aws"></i>
						Client Prix Action
					</a>
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
								<a class="nav-link" href="/">
									<i class="fas fa-home"></i>
									Acceuil
									<span class="sr-only">(current)</span>
								</a>
							</li>
							<li class="nav-item active">
								<a class="nav-link" href="/Currency-client/bourses">
									<i class="fas fa-money-bill-alt"></i>
									Bourses
									<span class="sr-only">(current)</span>
								</a>
							</li>
							<li class="nav-item active">
								<a class="nav-link" href="/Currency-client/actions">
									<i class="fas fa-exchange-alt"></i>
									Actions
									<span class="sr-only">(current)</span>
								</a>
							</li>
							<li class="nav-item active">
								<a class="nav-link" href="/price-action">
									<i class="fas fa-sign-in-alt"></i>
									Se connecter
									<span class="sr-only">(current)</span>
								</a>
							</li>
						</ul>
						<form method="GET" action="" class="form-inline my-2 my-lg-0">
							<input type="hidden" name="search-type" value="list"/> 
							<input class="form-control mr-sm-2" type="number" name="id"
								placeholder="Recherche par bourse..." aria-label="Search" />
							<button class="btn btn-outline-success my-2 my-sm-0"
								type="submit">Chercher</button>
						</form>
					</div>
				</nav>

				<!-- Container -->
				<div class="container">
					<h1 class="display-4">Liste des bourses disponibles</h1>
					<table class="table table-striped table-hover table-bordered">
						<thead class="thead-light">
							<tr class="text-center">
								<th scope="col">#</th>
								<th scope="col"><i class="fas fa-signature"></i> Nom</th>
								<th scope="col"><i class="fas fa-info-circle"></i> Détails</th>
							</tr>
							<xsl:for-each
								select="/ns2:bourses/listeBourses/bourse">
								<tr class="text-center">
									<td scope="row">
										<xsl:value-of select="@ns1:id" />
									</td>
									<td>
										<xsl:value-of select="ns1:name" />
									</td>
									<td>
										<a href="/Currency-client/bourses?id={@ns1:id}">
											<button class="btn btn-primary">
												<i class="fas fa-list"></i>
												Information de la bourse
											</button>
										</a>
									</td>
								</tr>
							</xsl:for-each>
							<xsl:if test="count(/ns2:bourses/listeBourses/bourse) = 0">
								<tr class="alert alert-warning text-center">
									<td colspan="3">
										<i class="fas fa-exclamation"></i>
										Aucune bourse n'a été trouvée!
									</td>
								</tr>
							</xsl:if>
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