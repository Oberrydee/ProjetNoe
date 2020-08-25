<%@page import="model.AccessBD"%>
<!DOCTYPE html>
<html lang="fr">
<head>

	<meta charset="utf-8">
	<link rel="stylesheet" href="assets\css\app.css">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author"      content="Ibtissame FRIKS">
	
	<title>Accueil</title>

	<link rel="shortcut icon" href="assets/images/gt_favicon.png">
	
	<link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
	<link rel="stylesheet" href="assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/css/font-awesome.min.css">

	<!-- Custom styles for our template -->
	<link rel="stylesheet" href="assets/css/bootstrap-theme.css" media="screen" >
		<link rel="stylesheet" href="assets/css/main.css">
<link rel="stylesheet" href="assets/css/app.css">

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
					<li><a class="btn" href="/association-arche/signout">Déconnexion</a></li>
				</ul>
			</div><!--/.nav-collapse -->
		</div>
	</div> 
	<!-- /.navbar -->
	<header id="head" class="secondary"></header>

	
		<div id="blockleft">
			<div id="profil">
				<table class="table_profil">
					<tr>
						<img src="assets\images\smile.png" class="smile_img">
					</tr>
					<tr>
						<td>
							${session_nom} ${session_prenom}
                                                        </br>
                                                        <p style="color:blue">
                                                            ${ambpambp}
                                                        </p>
						</td>
						
					</tr>
				</table>
			</div>

			<br>

			<div id="menuapp">
				<table class="table_menuapp">
					
					<ul class="nav flex-column">
						<ul class="nav flex-column">
						<li class="nav-item">
							<a class="nav-link active" href="/association-arche/get-comptes">Comptes</a>
						</li>	
						<li class="nav-item">
							<a class="nav-link active" href="/association-arche/sites">Sites de stockages</a>
						</li>						
						<li class="nav-item">
							<a class="nav-link active" href="/association-arche/get-lots">Lots de semence</a>
						</li>						
						<li class="nav-item">
							<a class="nav-link active" href="/association-arche/get-tax">Taxinomie</a>
						</li>						
						<li class="nav-item">
							<a class="nav-link active" href="/association-arche/get-emp">Employés</a>
						</li>
					</ul>
							
				</table>
					</div>
		</div>

		<div id="blockright">
			<!-- <table class="deconnexion"> -->
				<!-- <tr> -->
					<!-- <td> -->
						<!-- <button type="text"> -->
							<!-- D&eacute;connexion -->
						<!-- </button> -->
					<!-- </td> -->
				<!-- </tr> -->
			<!-- </table> -->

			<h1>
			  Accueil</h1>
                        </br>
	<div display="inline-block" align="center">	
            <label for="localisation-select">Veuillez choisir une demande :</label>
            </br>
        </div>
            
						<div class="panel-body">  
									<div class="col-lg-4 text-right">            
	<div class="top-margin">	
                <select onchange="window.location=this.options[this.selectedIndex].value" class="form-control">
                        <option value="">-- Choisissez la demande  --</option>
                        <option value="/association-arche/create-salarie">Demande de création de compte</option>
                        <option value="/association-arche/create-project">Demande de création de projet</option>
                        <option value="/association-arche/create-lot">Demande d'ajout de lot de semence</option>
                        <option value="/association-arche/create-site">Demande d'ajout de site de stockage</option>
                </select>
        </div>
                                        </div>
                                        </div>
                        </br>
</div>

