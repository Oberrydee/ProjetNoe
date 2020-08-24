<html lang="fr">
<head>
	<meta charset="utf-8">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author"      content="Sergey Pozhilov (GetTemplate.com)">
	
	<title>Connexion</title>

	<link rel="shortcut icon" href="assets/images/gt_favicon.png">
	
	<link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
	<link rel="stylesheet" href="assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/css/font-awesome.min.css">

	<!-- Custom styles for our template -->
	<link rel="stylesheet" href="assets/css/bootstrap-theme.css" media="screen" >
	<link rel="stylesheet" href="assets/css/main.css">

	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<script src="assets/js/html5shiv.js"></script>
	<script src="assets/js/respond.min.js"></script>
	<![endif]-->
</head>


<body class="home">
    <!-- Fixed navbar -->
	<div class="navbar navbar-inverse navbar-fixed-top headroom" >
		<div class="container">
			<div class="navbar-header">
				<!-- Button for smallest screens -->
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
				<a class="navbar-brand" href="/association-arche/home"><img src="assets/images/Logo.png" alt="Arche de Noe"></a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav pull-right">
					<li class="active"><a href="/association-arche/home">Accueil</a></li>
					
					<li><a href="/association-arche/contact">Contact</a></li>
					<li><a class="btn" href="/association-arche/signin">Connexion</a></li>
				</ul>
			</div><!--/.nav-collapse -->
		</div>
	</div> 

	<header id="head" class="secondary"></header>

	<!-- container -->
	<div class="container">

		<ol class="breadcrumb">
			<li><a href="/association-arche/home">Accueil</a></li>
			<li class="active">Accès utilisateur</li>
		</ol>

		<div class="row">
			
			<!-- Article main content -->
			<article class="col-xs-12 maincontent">
				<header class="page-header">
					<h1 class="page-title">Connexion</h1>
				</header>
				
				<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
					<div class="panel panel-default">
						<div class="panel-body">
							<h3 class="thin text-center">Se connecter à votre compte utilisateur</h3>
							<hr>
							
							<form action="/association-arche/home-a" method="post">
								<div class="top-margin">
									<label>Email <span class="text-danger">*</span></label>
									<input type="text" name="session_email" class="form-control" value="${session_email}">
								</div>
								<div class="top-margin">
									<label>Mot de passe <span class="text-danger">*</span></label>
									<input type="password" name="session_mdp" class="form-control" value="${session_mdp}">
								</div>

								<hr>

								<div class="row">
									<div class="col-lg-8">
										<b><a href="/association-arche/request-new-password">Mot de passe oublié?</a></b>
                                                                        <div>
                                                                            <p style="color: red">${textError}</p>
                                                                        </div>
									</div>
                                                                    
                                                            
									<div class="col-lg-4 text-right">
										<button class="btn btn-action" type="submit">Connexion</button>
									</div>
								</div>
							</form>
						</div>
					</div>

				</div>
				
			</article>
			<!-- /Article -->

		</div>
	</div>	<!-- /container -->
</body>
<footer id="footer" class="top-space">

		<div class="footer1">
			<div class="container">
				<div class="row">
					
					<div class="col-md-3 widget">
						<h3 class="widget-title">Contact</h3>
						<div class="widget-body">
								<a href="mailto:#">association.arche.msia19@gmail.com</a><br>
								<br>
								
							</p>	
						</div>
					</div>

					<div class="col-md-3 widget">
						<h3 class="widget-title">Follow me</h3>
						<div class="widget-body">
							<p class="follow-me-icons">
								<a href=""><i class="fa fa-twitter fa-2"></i></a>
								<a href=""><i class="fa fa-dribbble fa-2"></i></a>
								<a href=""><i class="fa fa-github fa-2"></i></a>
								<a href=""><i class="fa fa-facebook fa-2"></i></a>
							</p>	
						</div>
					</div>

					<div class="col-md-6 widget">
						<h3 class="widget-title">Nos sites</h3>
						<div class="widget-body">
						<iframe src="https://www.google.com/maps/d/embed?mid=1dBuRyVNZPx4ZpUPjnZ-xxZ7JL3N3d02a&hl=fr" width="640" height="480"></iframe>
						
						</div>
					</div>

				</div> <!-- /row of widgets -->
			</div>
		</div>

		<div class="footer2">
			<div class="container">
				<div class="row">
					
					<div class="col-md-6 widget">
						<div class="widget-body">
							<p class="simplenav">
								<a href="/association-arche/home">Accueil</a> | 
								<a href="/association-arche/contact">Contact</a> |
								<b><a href="/association-arche/signin">Connexion</a></b>
							</p>
						</div>
					</div>

					<div class="col-md-6 widget">
						<div class="widget-body">
							<p class="text-right">
								Copyright &copy; 2020, Association Arche. Designed by <a href="http://gettemplate.com/" rel="designer">MSIA 19| Groupe B</a> 
							</p>
						</div>
					</div>

				</div> <!-- /row of widgets -->
			</div>
		</div>

	</footer>
</html>