<%@page import="entities.Projet"%>
<%@page import="entities.Etat"%>
<%@page import="entities.Espece"%>
<%@page import="entities.Alerte"%>
<%@page import="model.AppStrings"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="utf-8">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author"      content="Sergey Pozhilov (GetTemplate.com)">
	
	<title>Creation Projet</title>

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
				<a class="navbar-brand" href="index.html"><img src="assets/images/logo.png" alt="Arche de Noe"></a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav pull-right">
					<li class="active"><a href="index.html">Accueil</a></li>
					<li><a href="contact.html">Contact</a></li>
					<li><a class="btn" href="signin.html">Deconnexion</a></li>
				</ul>
			</div><!--/.nav-collapse -->
		</div>
	</div> 
	<!-- /.navbar -->



	<header id="head" class="secondary"></header>

	<!-- container -->
	<div class="container">

		<ol class="breadcrumb">
			<li><a href="index.html">Page d'accueil</a></li>
			<li class="active">Création de projet</li>
		</ol>

		<div class="row">
			
			<!-- Article main content -->
			<article class="col-xs-12 maincontent">
				<header class="page-header">
					<h1 class="page-title"></h1>
				</header>
				
				<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
					<div class="panel panel-default">
						<div class="panel-body">
							<h3 class="thin text-center">Nouveau Salarié</h3>	<hr>

                                                        <form action = "/association-arche/create-salarie" method="post">
                                                            
                                                                <div class="top-margin">
                                                                            <p style="color: red">${textError}</p>
                                                                        </div>
                                                                <div class="top-margin">
									<label>Nom </label>
									<input type="text" name="nom" class="form-control">
                                                                </div>
                                                            
                                                                <div class="top-margin">
									<label>Prenom </label>
									<input type="text" name="prenom" class="form-control">
								</div>
                                                            
                                                                <div class="top-margin">
									<label>Numero de téléphone</label>
									<input type="text" name="numero_de_telephone" class="form-control">
								</div>
                                                            
                                                                <div class="top-margin">
									<label>Email</label>
									<input type="email" name="email" class="form-control">
								</div>
                                                            
                                                                <div class="top-margin">
                                                                        <label>Site : </label>
                                                                <select name="site" id="natureDemande-select">  
                                                                    <option value="DAX">DAX</option>
                                                                    <option value="LILLE">LILLE</option>
                                                                    <option value="ANNECY">ANNECY</option>
                                                                    
                                                                </select>
                                                                </div></br>
                                                            <div>
									<label>Numero de batiment</label>
									<input type="int" name="numero_de_batiment" class="form-control">
								</div>
                                                                <div class="top-margin">
									<label>Rue </label>
									<input type="text" name="rue" class="form-control">
								</div>
                                                                <div class="top-margin">
									<label>Ville </label>
									<input type="text" name="ville" class="form-control">
								</div>
                                                                <div class="top-margin">
									<label>Code Postal </label>
									<input type="text" name="code_postal" class="form-control">
								</div>
                                                                <div class="top-margin">
									<label>Role </label>
                                                                        <select name="role" id="natureDemande-select">  
                                                                            <option value="<%=AppStrings.NOM_ROLE_EMPLOYE%>">Aucun</option>
                                                                            <option value="<%=AppStrings.NOM_ROLE_RH%>">Ressources Humaines</option>
                                                                            <option value="<%=AppStrings.NOM_ROLE_RECHERCHE_ET_DEVELOPPEMENT%>">Recherche et Développement</option>
                                                                            <option value="<%=AppStrings.NOM_ROLE_PERSONNEL_SITE_DE_STOCKAGE%>">Personnel de site de stockage</option>
                                                                            <option value="<%=AppStrings.NOM_ROLE_SENTINELLE%>">Sentinelle</option>
                                                                            <option value="<%=AppStrings.NOM_ROLE_dIRECTEUR_DE_PRODUCTION%>">Directeur de Producation</option>
                                                                            <option value="<%=AppStrings.NOM_ROLE_ITSM%>">ITSM</option>
                                                                            <option value="<%=AppStrings.NOM_ROLE_NARRATEUR%>">Narrateur</option>
                                                                            <option value="<%=AppStrings.NOM_ROLE_CHEF_DE_PROJET%>">Chef de projet</option>
                                                                                                                
                                                                        </select>
								</div>
                                                                        

                                                                </br></br>
								</div>
                                                                <div class="top-margin">
                                                                    
										<button class="btn btn-success btn-space" type="submit" style="color:white;">
                                                                                    Envoyer la demande</button>
									
									</div>
								<hr>

								</div>
							</form>
						</div>
					</div>

				</div>
				
			</article>
			<!-- /Article -->

		</div>
	</div>	<!-- /container -->
	

<footer id="footer" class="top-space">

		<div class="footer1">
			<div class="container">
				<div class="row">
					
					<div class="col-md-3 widget">
						<h3 class="widget-title">Contact</h3>
						<div class="widget-body">
								<a href="mailto:#">association@arche.com</a><br>
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
								<a href="#">Accueil</a> | 
								<a href="about.html">A propos de nous</a> |
								<a href="contact.html">Contact</a> |
								<b><a href="signup.html">Connexion</a></b>
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