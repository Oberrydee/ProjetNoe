<%@page import="model.AppStrings"%>
<%@page import="entities.Salarié"%>
<!DOCTYPE html>

<%@page import="entities.CompteUtilisateur"%>
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
	
	<title>Comptes</title>

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
            List<Salarié> listeComptes = (List<Salarié>)AccessBD.selectAllSalariés();
            if(listeComptes != null && !listeComptes.isEmpty() ){
                
                %>
			<table class="tableau_demande" colspan=7 class="colspan">
				</br>
				</br>
				<tr>
				<td>ID</td><td>Nom</td><td>Prenom</td><td>Numero</td><td>Date de début</td>
				</tr>                
                <%
                
                for(Salarié sal : listeComptes){
                    if(!sal.getRoleidRole().getNomRole().equals(AppStrings.NOM_ROLE_ABONNE)){
                %>

                    <tr>
                            <td>Employé <%=sal.getIdSalarié()%></td>
                            <td> <%=sal.getNom()%></td>
                            <td> <%=sal.getPrénom()%></td>
                            <td> <%=sal.getEmailPro()%></td>
                            <td>
                                <a href = /association-arche/modify-emp?id=<%=sal.getIdSalarié()%> >
                                   Modifier
                                </a> 
                                </br>
                                <a href = /association-arche/delete-emp?id=<%=sal.getIdSalarié()%> >
                                   Supprimer
                                </a>
                            </td>
                    </tr>	
            <%
                }
                }
            }%>
            
         <div display="inline-block" align="center">
                            <br>
    <form action="/association-arche/create-salarie">
			<button class="btn btn-success " type="submit" style="color:white;">Nouveau compte
                        </button>
                            <br>
    </form>
                        </br>
</div>

