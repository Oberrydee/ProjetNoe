<!DOCTYPE html>
<html lang="fr">
<head>

	<meta charset="utf-8">
	<link rel="stylesheet" href="assets\css\app.css">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author"      content="Ibtissame FRIKS">
	
	<title>Projet Fil Rouge</title>

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
					<li><a class="btn" href="/association-arche/signout">D�connexion</a></li>
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
							<a class="nav-link active" href="interface.html">Comptes</a>
						</li>
						
						<li class="nav-item">
							<a class="nav-link active" href="interfaceAlertes.html">Altertes</a>
						</li>
						
						<li class="nav-item">
                                                    <a class="nav-link active" href="/association-arche/get-projects">Projets</a>
						</li>
						
						<li class="nav-item">
							<a class="nav-link active" href="interfaceCandidatureProjet.html">Candidatures de projets de sauvetage</a>
						</li>

						<li class="nav-item">
							<a class="nav-link active" href="interfaceSiteStockage.html">Sites de stockages</a>
						</li>
						
						<li class="nav-item">
							<a class="nav-link active" href="interfaceLotSemence.html">Lots de semence</a>
						</li>
						
						<li class="nav-item">
							<a class="nav-link active" href="interfaceTaxinomie.html">Taxinomie</a>
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
			  Page d'accueil</h1>
			

			<table class="tableau_demande">
				<tr>
					<td colspan=4 class="colspan">
						Tableau de demandes
					</td>
				</tr>
				<tr>
  					
 					<td>
 						N� Demande
 					</td>
					<td>
  						Nature de la demande
  					</td>
  					<td>
  						Date de cration 
  					</td>
  					<td>
  						Statut
  					</td>
				</tr>
				<tr>
  					<td>
  						Demande 1
  					</td>
 					<td>
 						
 					</td>
  					<td>
  						
  					</td>
  					<td>
  						
  					</td>
				</tr>
				<tr>
  					<td> 
						Demande 2
  						
  					</td>
 					<td>
 						
 					</td>
  					<td>
  						
  					</td>
  					<td>
  						
  					</td>
				</tr>
				<tr>
  					<td>
  						Demande 3
  					</td>
 					<td>
 						
 					</td>
  					<td>
  						
  					</td>
  					<td>
  						
  					</td>
				</tr>
				<tr>
  					<td>
  						Demande 4
  					</td>
 					<td>
 						
 					</td>
  					<td>
  						
  					</td>
  					<td>
  						
  					</td>
				</tr>
				<tr>
  					<td>
  						Demande 5
  					</td>
 					<td>
 						
 					</td>
  					<td>
  						
  					</td>
  					<td>
  						
  					</td>
				</tr>
				<tr>
  					<td>
  						Demande 6
  					</td>
 					<td>
 						
 					</td>
  					<td>
  						
  					</td>
  					<td>
  						
  					</td>
				</tr>
				<tr>
  					<td>
  						Demande 7
  					</td>
 					<td>
 						
 					</td>
  					<td>
  						
  					</td>
  					<td>
  						
  					</td>
				</tr>
				<tr>
  					<td>
  						Demande 8
  					</td>
 					<td>
 						
 					</td>
  					<td>
  						
  					</td>
  					<td>
  						
  					</td>
				</tr>
				<tr>
  					<td>
  						Demande 9
  					</td>
 					<td>
 						
 					</td>
  					<td>
  						
  					</td>
  					<td>
  						
  					</td>
				</tr>
			</table>

			<br>
         <div display="inline-block" align="center">
			<button class="btn btn-success btn-space" type="submit"><a href="demandeFonctionalit�.html" style="color:black;">Faire la demande</a>
			<button class="btn btn-secondary btn-space" type="submit"><a href="annulerFonctionnalit�.html" style="color:black;">Annuler la demande</a>
			<button class="btn btn-danger btn-space" type="submit"><a href="supprimerFonctionalit�.html" style="color:black;">Supprimer la demande</a>
		

		</div>
</div>
