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
						<form method="GET" action="/Currency-client/actions"
							class="form-inline my-2 my-lg-0">
							<input class="form-control mr-sm-2" type="search"
								name="name" placeholder="Recherche d'une action..."
								aria-label="Search" />
							<button class="btn btn-outline-success my-2 my-sm-0"
								type="submit">
								<i class="fas fa-search"></i>
								Chercher
							</button>
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


					<div class="row mb-5">
						<div
							class="col-12 col-sm-12 col-md-6 col-lg-12 col-xl-6 ml-auto mr-auto text-center">
							<p class="h1">
								<i class="fas fa-charging-station"></i>
								Actions évoluées
							</p>
							<canvas id="myChart" width="400" height="400"></canvas>
						</div>
						<div
							class="col-12 col-sm-12 col-md-6 col-lg-12 col-xl-6 ml-auto mr-auto text-center">
							<p class="h1">
								<i class="fab fa-yandex-international"></i>
								Bourses Évoluées
							</p>
							<canvas id="myChart1" width="400" height="400"></canvas>
						</div>
					</div>
					
					
					<!-- All actions history -->
					<div class="row mb-5">
						<div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
							<canvas id="allActionsLineChart" width="400" height="400"></canvas>
						</div>
					</div>
					

					<!-- Price action form -->
					<div class="row mb-5 mb-5">
						<div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
							<div class="card">
								<div class="card-header">
									<i class="fab fa-searchengin"></i>
									Prix Action
								</div>
								<div class="card-body">
									<h5 class="card-title">
										<i class="fas fa-mouse-pointer"></i>
										Choisir une action
									</h5>
									<p class="card-text">
										<form method="GET">
											<div class="form-group">
												<label for="exampleFormControlSelect1">
													<i class="fas fa-directions"></i>
													Action
												</label>
												<select class="form-control" name="action">
													<xsl:for-each
														select="/ns2:actions/ns2:actions/listeActions/actions">
														<xsl:param name="bourseId" select="ns2:bourse" />
														<option value="{ns2:name}">
															<xsl:value-of select="ns2:name" />
															| Bourse:
															<xsl:value-of
																select="//ns2:bourses[2]/listeBourses/bourse[@ns2:id=$bourseId]" />
														</option>
													</xsl:for-each>
												</select>
											</div>
											<button type="submit" class="btn btn-primary">
												<i class="fas fa-search-dollar"></i>
												Lancer la recherche
											</button>
										</form>
									</p>
								</div>
							</div>
						</div>
					</div>



					<!-- If user start the search -->
					<xsl:if test="//ns2:actions[2]/listeActions/actions">
						<div class="row mb-5">
							<div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
								<xsl:if
									test="count(//ns2:actions[2]/listeActions/actions) >= 1">
									<h1 class="display-4 text-center">
										<i class="fas fa-search-location"></i>
										Historique de l'action:
										<div class="row">
											<div class="col lead">
												<i class="fas fa-fingerprint"></i>
												:
												<strong>
													<xsl:value-of
														select="//ns2:actions[2]/listeActions/actions[1]/@ns2:id" />
												</strong>
											</div>
											<div class="col lead">
												<i class="fas fa-terminal"></i>
												:
												<strong>
													<xsl:value-of
														select="//ns2:actions[2]/listeActions/actions[1]/ns2:name" />
												</strong>
											</div>
										</div>
									</h1>
								</xsl:if>
								<table
									class="table table-striped table-hover table-bordered mt-4">
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
											<th scope="col">
												<i class="fas fa-building"></i>
												Bourse
											</th>
										</tr>
										<xsl:for-each
											select="//ns2:actions[2]/listeActions/actions">
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
													<xsl:when test="ns2:variation > 0">
														<td class="text-success">
															<i class="fas fa-angle-double-up mr-1"></i>
															<xsl:value-of select="ns1:variation" />
															%
														</td>
													</xsl:when>
													<xsl:otherwise>
														<td class="text-danger">
															<i class="fas fa-angle-double-down mr-1"></i>
															<xsl:value-of select="ns2:variation" />
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
													<xsl:variable name="bourseId"
														select="ns2:bourse" />
													<a href="/Currency-client/bourses?id={$bourseId}">
														<xsl:value-of
															select="//ns2:bourses[2]/listeBourses/bourse[@ns2:id=$bourseId]" />
													</a>
												</td>
											</tr>
										</xsl:for-each>
										<xsl:if
											test="count(//ns2:actions[2]/listeActions/actions) = 0">
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
						</div>
					</xsl:if>

				<!-- If user start the search -->
				<xsl:if test="//ns2:actions[2]/listeActions/actions">
					<div class="row mb-5">
						<div class="col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6 ml-auto mr-auto">
							<canvas
								id="circleChart{//ns2:actions[2]/listeActions/actions[1]/@ns2:id}"
								width="400" height="400"></canvas>
						</div>
						<div class="col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6 ml-auto mr-auto">
							<canvas
								id="lineChart{//ns2:actions[2]/listeActions/actions[1]/@ns2:id}"
								width="400" height="400"></canvas>
						</div>
					</div>
				</xsl:if>

				<div class="row mb-5"></div>

				</div>
				
				
				<footer class="footer mt-auto py-3 mt-5 bg-light">
				  <div class="container">
				    <span class="text-muted"><i class="fab fa-ups"></i> Service web de haute qualité</span>
				  </div>
				</footer>
						


				<!-- Optional JavaScript -->
				<!-- jQuery first, then Popper.js, then Bootstrap JS -->
				<script src="./static/js/jquery.min.js"></script>
				<script src="./static/js/popper.min.js"></script>
				<script src="./static/js/all.min.js"></script>
				<script src="./static/js/Chart.min.js"></script>
				<script src="./static/js/bootstrap.min.js"></script>
				<script src="./static/js/script.js"></script>



				<script type="text/javascript">
					$('document').ready(function(){


					// Draw actions evolution
					drawGraph("myChart",
					"Évolution des actions | Variation",
					`
					<xsl:value-of
						select="/ns2:actions/listeActions/actions[1]/ns2:name" />
					`,
					`
					<xsl:value-of
						select="/ns2:actions/listeActions/actions[2]/ns2:name" />
					`,
					`
					<xsl:value-of
						select="/ns2:actions/listeActions/actions[3]/ns2:name" />
					`,
					`
					<xsl:value-of
						select="/ns2:actions/listeActions/actions[4]/ns2:name" />
					`,
					`
					<xsl:value-of
						select="/ns2:actions/listeActions/actions[5]/ns2:name" />
					`,
					`
					<xsl:value-of
						select="/ns2:actions/listeActions/actions[6]/ns2:name" />
					`,

					`
					<xsl:value-of
						select="/ns2:actions/listeActions/actions[1]/ns2:variation" />
					`,
					`
					<xsl:value-of
						select="/ns2:actions/listeActions/actions[2]/ns2:variation" />
					`,
					`
					<xsl:value-of
						select="/ns2:actions/listeActions/actions[3]/ns2:variation" />
					`,
					`
					<xsl:value-of
						select="/ns2:actions/listeActions/actions[4]/ns2:variation" />
					`,
					`
					<xsl:value-of
						select="/ns2:actions/listeActions/actions[5]/ns2:variation" />
					`,
					`
					<xsl:value-of
						select="/ns2:actions/listeActions/actions[6]/ns2:variation" />
					`);

					drawGraph("myChart1",
					"Évolution des bourses | Nombre des actions",
					`
					<xsl:value-of
						select="//ns2:bourses/listeBourses/bourse[1]/ns2:name" />
					`,
					`
					<xsl:value-of
						select="//ns2:bourses/listeBourses/bourse[2]/ns2:name" />
					`,
					`
					<xsl:value-of
						select="//ns2:bourses/listeBourses/bourse[3]/ns2:name" />
					`,
					`
					<xsl:value-of
						select="//ns2:bourses/listeBourses/bourse[4]/ns2:name" />
					`,
					`
					<xsl:value-of
						select="//ns2:bourses/listeBourses/bourse[5]/ns2:name" />
					`,
					`
					<xsl:value-of
						select="//ns2:bourses/listeBourses/bourse[6]/ns2:name" />
					`,

					`
					<xsl:value-of
						select="//ns2:bourses/listeBourses/bourse[1]/ns2:numberOfActions" />
					`,
					`
					<xsl:value-of
						select="//ns2:bourses/listeBourses/bourse[2]/ns2:numberOfActions" />
					`,
					`
					<xsl:value-of
						select="//ns2:bourses/listeBourses/bourse[3]/ns2:numberOfActions" />
					`,
					`
					<xsl:value-of
						select="//ns2:bourses/listeBourses/bourse[4]/ns2:numberOfActions" />
					`,
					`
					<xsl:value-of
						select="//ns2:bourses/listeBourses/bourse[5]/ns2:numberOfActions" />
					`,
					`
					<xsl:value-of
						select="//ns2:bourses/listeBourses/bourse[6]/ns2:numberOfActions" />
					`
					);

					});
					
					let allActions = [];
					
					<xsl:for-each select="//ns2:actions[1]/listeActions/actions">
						<xsl:variable name="bourseId" select="ns2:bourse" />
						allActions.push({
							date: '<xsl:value-of select="ns2:date" />',
							variation: '<xsl:value-of select="ns2:variation" />',
							name: '<xsl:value-of select="ns2:name" />'
						});
					</xsl:for-each>
					drawAllActionsLineCharts(allActions);
						

					<xsl:if test="//ns2:actions[2]/listeActions/actions">
					
						let actions = [];
						
						<xsl:for-each select="//ns2:actions[2]/listeActions/actions">
							<xsl:variable name="bourseId" select="ns2:bourse" />
							actions.push({
								date: '<xsl:value-of select="ns2:date" />',
								variation: '<xsl:value-of select="ns2:variation" />'
							});
						</xsl:for-each>
					
						drawCharts("<xsl:value-of select="//ns2:actions[2]/listeActions/actions[1]/@ns2:id" />",
						`
						<xsl:value-of
							select="//ns2:actions[2]/listeActions/actions[1]/ns2:name" />
						`,
						actions);
					</xsl:if>
				</script>


			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>