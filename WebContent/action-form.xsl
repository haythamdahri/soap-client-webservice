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
								<a class="nav-link" href="/Currency-client">
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
					<h1 class="display-4 text-center">
						<i class="fas fa-text-height"></i>
						Modification Action
					</h1>

					<div class="card mb-5">
						<div class="card-header">
							<i class="fas fa-edit"></i>
							Modification de l'action N°
							<xsl:value-of select="ns1:action/@ns1:id" />
						</div>
						<div class="card-body">
							<h5 class="card-title">
								<i class="fas fa-italic"></i>
								Saisir les données
							</h5>
							<p class="card-text">

								<xsl:if test="//@error">
									<div class="alert alert-danger" role="alert">
										<i class="fas fa-exclamation-triangle"></i>
										Les données saisies sont invalides!
									</div>
								</xsl:if>

								<!-- Update bourse form -->
								<form method="POST"
									action="/Currency-client/dashboard?updateBourse">

									<div class="form-group">
										<label>
											<i class="fas fa-fingerprint"></i>
											Id
										</label>

										<xsl:if test="ns1:action/@ns1:id">
											<input type="number" value="{ns1:action/@ns1:id}"
												class="form-control" name="id" readonly="true"
												required="true" placeholder="Id bourse" />
											<input type="hidden" name="updateAction" />
										</xsl:if>
										<xsl:if
											test="not(//action) and not(ns1:action/@ns1:id)">
											<input type="text" class="form-control" value="##"
												name="id" readonly="true" required="true"
												placeholder="Id bourse" />
											<input type="hidden" name="addBourse" />
										</xsl:if>

									</div>

									<div class="form-group">
										<label>
											<i class="fas fa-dice-d6"></i>
											Nom
										</label>
										<input type="text" class="form-control" name="name"
											value="{ns1:action/ns1:name}"
											placeholder="Saisir le nom de l'action" maxLength="50"
											minLength="5" required="true" />
									</div>

									<div class="form-group">
										<label>
											<i class="far fa-money-bill-alt"></i>
											Montant d'ouverture
										</label>
										<input type="number" class="form-control"
											name="openingAmount" value="{ns1:action/ns1:openingAmount}"
											placeholder="Saisir le montant d'ouverture"
											maxValue="10000000" minValue="1" required="true" />
									</div>

									<div class="form-group">
										<label>
											<i class="fas fa-money-bill-alt"></i>
											Montant de fermeture
										</label>
										<input type="number" class="form-control"
											name="closingAmount" value="{ns1:action/ns1:closingAmount}"
											placeholder="Saisir le montant de fermeture"
											maxValue="10000000" minValue="1" required="true" />
									</div>

									<div class="form-group">
										<label>
											<i class="fas fa-calendar-week"></i>
											Date
										</label>
										<input type="date" class="form-control"
											name="date" value="{ns1:action/ns1:date}"
											placeholder="JJ/MM/AAAA" pattern="[0-9]{2}/[0-9]{2}/[0-9]{4}"
											required="true" />
									</div>

									<div class="form-group">
										<label for="exampleFormControlSelect1">
											<i class="fas fa-building"></i>
											Bourse <xsl:value-of select="ns1:action/ns1:bourse" />
										</label>
										<select class="form-control" name="bourse">
											<xsl:for-each
												select="//ns2:bourses/listeBourses/bourse">
												<xsl:if test="@ns2:id = /ns1:action/ns1:bourse">
													<option selected="true" value="{@ns2:id}">
														<xsl:value-of select="@ns2:id" />
													</option>
												</xsl:if>
												<xsl:if test="not(@ns2:id = /ns1:action/ns1:bourse)">
													<option value="{@ns2:id}">
														<xsl:value-of select="@ns2:id" />
													</option>
												</xsl:if>
											</xsl:for-each>
										</select>
									</div>

									<button type="submit" class="btn btn-primary btn-sm">
										<i class="fas fa-sd-card"></i>
										Enregistrer
									</button>
								</form>
							</p>
						</div>
					</div>

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