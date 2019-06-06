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
								<li class="nav-item">
									<a class="nav-link" href="/Currency-client/dashboard">
										<i class="fas fa-tachometer-alt"></i>
										Dashboard
									</a>
								</li>
								<li class="nav-item">
									<form style="margin: 0; padding: 0;" action="/Currency-client/login" id="disconnect">
										<input type="hidden" name="logout" />
										<a class="nav-link" style="cursor: pointer;" onclick="document.getElementById('disconnect').submit();">
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
						<i class="far fa-list-alt"></i>
						Connexion
					</h1>

					<div class="card">
						<div class="card-header">
							<i class="far fa-user-circle"></i> Authentification
						</div>
						<div class="card-body">
							<h5 class="card-title">
								<i class="fas fa-asterisk"></i>
								Saisir vos cordonnées
							</h5>
							<p class="card-text">

								<xsl:if test="//@error">
									<div class="alert alert-danger" role="alert">
										<i class="fas fa-exclamation-triangle"></i> Email ou mot de passe est non valide!
									</div>
								</xsl:if>

								<form method="POST" action="/Currency-client/login">
									<div class="form-group">
										<label>
											<i class="fas fa-envelope-open-text"></i>
											Adresse email
										</label>
										<input type="email" class="form-control" name="email"
											aria-describedby="emailHelp"
											placeholder="Saisir votre adresse email" />
									</div>
									<div class="form-group">
										<label>
											<i class="fas fa-unlock-alt"></i>
											Mot de passe
										</label>
										<input type="password" class="form-control" name="password"
											placeholder="Saisir votre mot de passe" />
									</div>
									<button type="submit" class="btn btn-primary btn-sm">
										<i class="fas fa-sign-in-alt"></i>
										Se connecter
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