<%@page import="model.AppStrings"%>
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
	
	<title>Projets</title>

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
							<a class="nav-link active" href="/association-arche/home-a">Accueil</a>
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
                    if(projet.getEtatIdetat().getDescription().equals(AppStrings.ETAT_A_INITIER)){
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
                                <a style="color:greenyellow;" href = /association-arche/cancel-project?id=<%=projet.getIdprojet()%> >
                                   Valider
                                </a>
                                </br>
                                <a style="color:red;" href = /association-arche/delete-project?id=<%=projet.getIdprojet()%> >
                                   Refuser
                                </a>
                            </td>
                    </tr>	
            <%
                }
                }
            }%>


         <div display="inline-block" align="center">
                            <br>
    <form action="/association-arche/create-project">
			<button class="btn btn-success " type="submit" style="color:white;">Nouveau project
                        </button>
                            <br>
    </form>
		</div>
                        </br>
</div>

