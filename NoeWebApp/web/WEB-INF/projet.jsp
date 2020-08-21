<!DOCTYPE html>

<%@page import="entities.Projet"%>
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
	
	<title>Projet Fil Rouge</title>

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
					<li><a class="btn" href="signin.html">Déconnexion</a></li>
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
							Nom prénom
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
							<a class="nav-link active" href="interface.html">Comptes</a>
						</li>
						
						<li class="nav-item">
							<a class="nav-link active" href="interfaceAlertes.html">Altertes</a>
						</li>
						
						<li class="nav-item">
							<a class="nav-link active" href="interfaceProjet.html">Projets</a>
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
			  Projets de sauvetage
			</h1>
        <%
            List<Projet> listeProjets = (List<Projet>)AccessBD.selectAllProjets();
            if(listeProjets != null && !listeProjets.isEmpty() ){
                
                %>
			<table class="tableau_demande" colspan=7 class="colspan">
				</br>
				</br>
				<tr>
				<td>ID</td><td>Espèce</td><td>Demandeur</td><td>Alerte associée</td><td>Narrateur</td><td>Statut</td><td>Date de début</td>
				</tr>                
                <%
                
                for(Projet projet:listeProjets){
                %>

                    <tr>
                            <td>Projet <%=projet.getIdprojet()%></td>
                            <td> <%=projet.getAlerteIdalerte().getEspeceIdespece().getIdespece()%></td>
                            <td> <%=projet.getDemandeurIdsalarie().getNom()%></td>
                            <td> <%=projet.getAlerteIdalerte().getIdalerte()%></td>
                            <td> <%=projet.getNarrateurIdsalarie().getNom()%></td>
                            <td> <%=projet.getEtatIdetat().getDescription()%></td>
                            <td> <%=(projet.getDateDebut())==null? " " : projet.getDateDebut().toString()%></td>
                            <td> 
                                <a href = /association-arche/cancel-project?id=<%=projet.getIdprojet()%> >
                                   Annuler
                                </a>
                                </br>
                                <a href = /association-arche/modify-project?id=<%=projet.getIdprojet()%> >
                                   Modifier
                                </a> 
                                </br>
                                <a href = /association-arche/delete-project?id=<%=projet.getIdprojet()%> >
                                   Supprimer
                                </a>
                            </td>
                    </tr>	
            <%
                }
            }
else {
                %>
         <div display="inline-block" align="center">
             <br>
                <p>Rien à afficher</p>	
         </div>
                <%
                    }
%>

			<br>
         <div display="inline-block" align="center">
			<button class="btn btn-success " type="submit"><a href="/association-arche/create-project" style="color:black;">Nouvelle demande</a>
                            <br>
		</div>
                        </br></br>
</div>

