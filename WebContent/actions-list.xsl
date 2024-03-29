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
				<!-- Navbar part -->
				<nav class="navbar navbar-expand-lg navbar-light bg-light">
					<a class="navbar-brand" href="/Currency-client/price-action">
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
								<a class="nav-link" href="/Currency-client/price-action">
									<i class="fas fa-home"></i>
									Acceuil
									<span class="sr-only">(current)</span>
								</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="/Currency-client/bourses">
									<i class="fas fa-money-bill-alt"></i>
									Bourses
								</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="/Currency-client/actions">
									<i class="fas fa-exchange-alt"></i>
									Actions
								</a>
							</li>

							<xsl:if test="not(//connected-user/@email)">
								<li class="nav-item">
									<a class="nav-link" href="/Currency-client/login">
										<i class="fas fa-sign-in-alt"></i>
										Se connecter
									</a>
								</li>
							</xsl:if>

							<xsl:if test="//connected-user/@email">
								<li class="nav-item dropdown">
									<a class="nav-link dropdown-toggle" href="#"
										id="navbarDropdown" role="button" data-toggle="dropdown"
										aria-haspopup="true" aria-expanded="false">
										<i class="fas fa-tachometer-alt"></i>
										Dashboard
									</a>
									<div class="dropdown-menu" aria-labelledby="navbarDropdown">
										<a class="dropdown-item"
											href="/Currency-client/dashboard?boursePage">
											<i class="fas fa-building"></i>
											Administration des bourses
										</a>
										<div class="dropdown-divider"></div>
										<a class="dropdown-item"
											href="/Currency-client/dashboard?actionPage">
											<i class="fab fa-artstation"></i>
											Administration des actions
										</a>
									</div>
								</li>
								<li class="nav-item">
									<form method="POST" style="margin: 0; padding: 0;"
										action="/Currency-client/login" id="disconnect">
										<input type="hidden" name="logout" />
										<a class="nav-link" style="cursor: pointer;"
											onclick="document.getElementById('disconnect').submit();">
											<i class="fas fa-sign-out-alt"></i>
											Se deconnecter
										</a>
									</form>
								</li>
							</xsl:if>

						</ul>
						<form method="GET" action="/Currency-client/actions"
							class="form-inline my-2 my-lg-0">
							<input class="form-control mr-sm-2" type="search"
								name="name" placeholder="Recherche d'une action..."
								aria-label="Search" />
							<button class="btn btn-outline-success my-2 my-sm-0"
								type="submit"><i class="fas fa-search"></i> Chercher</button>
						</form>
					</div>
				</nav>

				<!-- Container -->
				<div class="container">
					<h1 class="display-4 text-center">
						<i class="far fa-list-alt"></i>
						Liste des actions disponibles
					</h1>
					<table class="table table-striped table-hover table-bordered">
						<thead class="thead-light">
							<tr class="text-center">
								<th scope="col">#</th>
								<th scope="col">
									<i class="fas fa-signature"></i>
									Nom
								</th>
								<th scope="col">
									<i class="fas fa-table"></i>
									Date
								</th>
								<th scope="col">
									<i class="fas fa-cash-register"></i>
									Variation
								</th>
								<th scope="col">
									<i class="fas fa-rss"></i>
									Ouberture
								</th>
								<th scope="col">
									<i class="fas fa-rss-square"></i>
									Clôture
								</th>
								<th scope="col" colspan="2">
									<i class="fab fa-artstation"></i>
									Actions
								</th>
							</tr>
							<xsl:for-each
								select="/ns2:actions/listeActions/actions">
								<tr class="text-center">
									<td scope="row">
										<xsl:value-of select="@ns2:id" />
									</td>
									<td>
										<xsl:value-of select="ns2:name" />
									</td>
									<td>
										<xsl:value-of select="ns2:date" />
									</td>

									<xsl:choose>
										<xsl:when test="ns1:variation > 0">
											<td class="text-success">
												<i class="fas fa-angle-double-up mr-1"></i>
												<xsl:value-of select="ns1:variation" />
												%
											</td>
										</xsl:when>
										<xsl:otherwise>
											<td class="text-danger">
												<i class="fas fa-angle-double-down mr-1"></i>
												<xsl:value-of select="ns1:variation" />
												%
											</td>
										</xsl:otherwise>
									</xsl:choose>
									<td>
										<xsl:value-of select="ns2:openingAmount" />
									</td>
									<td>
										<xsl:value-of select="ns2:closingAmount" />
									</td>
									<td>
										<a href="/Currency-client/actions?bourse={ns2:bourse}">
											<button class="btn btn-primary btn-sm">
												<i class="fas fa-list"></i>
												Liste des actions de cette bourse
											</button>
										</a>
									</td>
									<td>
										<a href="/Currency-client/actions?name={ns2:name}">
											<button class="btn btn-info btn-sm">
												<i class="fas fa-window-restore"></i>
												Historique de l'action
											</button>
										</a>
									</td>
								</tr>
							</xsl:for-each>
							<xsl:if
								test="count(/ns2:actions/listeActions/actions) = 0">
								<tr class="alert alert-warning text-center">
									<td colspan="7">
										<i class="fas fa-exclamation"></i>
										Aucune action n'a été trouvée!
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