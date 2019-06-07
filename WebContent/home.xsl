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

				<!-- Fontawesome CSS -->
				<link rel="stylesheet" href="./static/css/all.min.css" />

				<!-- Chart CSS -->
				<link rel="stylesheet" href="./static/css/Chart.min.css" />

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
					<h4 class="display-4 text-center">
						<i class="fab fa-aws"></i>
						Service Web des bourses
					</h4>
					<hr />


					<div class="row">
						<div
							class="col-12 col-sm-12 col-md-6 col-lg-12 col-xl-6 ml-auto mr-auto text-center">
							<p class="h1">Dernieres Actions</p>
							<canvas id="myChart" width="400" height="400"></canvas>
						</div>
						<div
							class="col-12 col-sm-12 col-md-6 col-lg-12 col-xl-6 ml-auto mr-auto text-center">
							<p class="h1">Actions Évoluées</p>
							<canvas id="myChart1" width="400" height="400"></canvas>
						</div>
					</div>

					<div class="row">
						<div class="col-12 col-sm-12 col-md-12 col-lh-12 col-xl-12">
							<table
								class="table table-striped table-hover table-bordered">
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
					</div>

				</div>

				<!-- Optional JavaScript -->
				<!-- jQuery first, then Popper.js, then Bootstrap JS -->
				<script src="./static/js/jquery.min.js"></script>
				<script src="./static/js/popper.min.js"></script>
				<script src="./static/js/all.min.js"></script>
				<script src="./static/js/Chart.min.js"></script>
				<script src="./static/js/bootstrap.min.js"></script>



				<script>
					var ctx = document.getElementById('myChart');
					var myChart = new Chart(ctx, {
					type: 'bar',
					data: {
					labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
					datasets: [{
					label: '# of Votes',
					data: [12, 19, 3, 5, 2, 3],
					backgroundColor: [
					'rgba(255, 99, 132, 0.2)',
					'rgba(54, 162, 235, 0.2)',
					'rgba(255, 206, 86, 0.2)',
					'rgba(75, 192, 192, 0.2)',
					'rgba(153, 102, 255, 0.2)',
					'rgba(255, 159, 64, 0.2)'
					],
					borderColor: [
					'rgba(255, 99, 132, 1)',
					'rgba(54, 162, 235, 1)',
					'rgba(255, 206, 86, 1)',
					'rgba(75, 192, 192, 1)',
					'rgba(153, 102, 255, 1)',
					'rgba(255, 159, 64, 1)'
					],
					borderWidth: 1
					}]
					},
					options: {
					scales: {
					yAxes: [{
					ticks: {
					beginAtZero: true
					}
					}]
					}
					}
					});

					var ctx1 = document.getElementById('myChart1');
					var myChart = new Chart(ctx1, {
					type: 'bar',
					data: {
					labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
					datasets: [{
					label: '# of Votes',
					data: [12, 19, 3, 5, 2, 3],
					backgroundColor: [
					'rgba(255, 99, 132, 0.2)',
					'rgba(54, 162, 235, 0.2)',
					'rgba(255, 206, 86, 0.2)',
					'rgba(75, 192, 192, 0.2)',
					'rgba(153, 102, 255, 0.2)',
					'rgba(255, 159, 64, 0.2)'
					],
					borderColor: [
					'rgba(255, 99, 132, 1)',
					'rgba(54, 162, 235, 1)',
					'rgba(255, 206, 86, 1)',
					'rgba(75, 192, 192, 1)',
					'rgba(153, 102, 255, 1)',
					'rgba(255, 159, 64, 1)'
					],
					borderWidth: 1
					}]
					},
					options: {
					scales: {
					yAxes: [{
					ticks: {
					beginAtZero: true
					}
					}]
					}
					}
					});
				</script>


			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>