<!DOCTYPE html>

<%@page import="entities.Projet"%>
<%@page import="entities.Salarié"%>
<%@page import="entities.Etat"%>
<%@page import="entities.Espece"%>
<%@page import="entities.Alerte"%>
<%@page import="model.AccessBD"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="fr">
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="assets\css\app.css">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author"      content="Ibtissame FRIKS">
	
	<title>Alertes</title>

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
				<a class="navbar-brand" href="/association-arche/home"><img src="assets/images/logo.png" alt="Arche de Noe"></a>
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
						</td>
						<!-- <td> -->
							<!-- Ibtissame FRIKS -->
						<!-- </td> -->
					</tr>
				</table>
			</div>

			<br>

			<div id="menuapp">
				<table class="table_menuapp">
					
					<ul class="nav flex-column">
						<li class="nav-item">
							<a class="nav-link active" href="/association-arche/get-comptes">Comptes</a>
						</li>						
						<li class="nav-item">
							<a class="nav-link active" href="/association-arche/get-alerts">Alertes</a>
						</li>						
						<li class="nav-item">
                                                    <a class="nav-link active" href="/association-arche/get-projects">Projets</a>
						</li>						
						<li class="nav-item">
							<a class="nav-link active" href="/association-arche/get-projects-to-start">Candidatures de projets de sauvetage</a>
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

		<div id="blockright">>
			<!-- </table> -->
        <%
            List<Alerte> listeAlertes = (List<Alerte>)AccessBD.selectAllALerts();
            if(listeAlertes != null && !listeAlertes.isEmpty() ){
                
                %>
			<table class="tableau_demande" colspan=7 class="colspan">
				</br>
				</br>
				<tr>
                                    <td>N° Alerte</td><td>Espèce</td><td>Urgence</td><td>Sentinelle</td><td>Actions</td>
				</tr>
                <%
                
                for(Alerte alerte : listeAlertes){
                %>

                    <tr>
                            <td> <%=alerte.getIdalerte()%></td>
                            <td> <%=alerte.getEspeceIdespece().getNom()%></td>
                            <td> <%=alerte.getUrgence()%></td>
                            <td> <%=alerte.getSentinelleIdsentinelle().getSalariéidSalarié().getNom()%> <%=alerte.getSentinelleIdsentinelle().getSalariéidSalarié().getPrénom()%></td>
                          <td> 
                                <a style= "red" href = /association-arche/delete-alerte?id=<%=alerte.getIdalerte()%>
                                   Supprimer
                                </a>
                            </td>
                    </tr>	
            <%
                }
            }%>

<div display="inline-block" align="center">
    
    <form action="/association-arche/create-alert">
			<button class="btn btn-success " type="submit" style="color:white;">Nouvelle alerte
                        </button>
                            <br>
    </form>
		</div>
                        </br>
</div>

