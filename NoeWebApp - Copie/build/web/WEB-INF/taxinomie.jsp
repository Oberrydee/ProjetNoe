
<%@page import="model.AccessBD"%>
<%@page import="entities.Taxinomie"%>
<%@page import="java.util.List"%>
<html lang="fr">
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="assets\css\app.css">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author"      content="Ibtissame FRIKS">
	
	<title>Taxinomie</title>

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
            List<Taxinomie> listeTaxinomies = (List<Taxinomie>)AccessBD.selectAllTaxinomies();
            if(listeTaxinomies != null && !listeTaxinomies. isEmpty() ){
                
                %>
			<table class="tableau_demande" colspan=7 class="colspan">
				</br>
				</br>
				<tr>
				<td>Nom</td><td>Regne</td><td>Classe</td>
                                <td>Espèces</td><td>Embranchement</td><td>ordre</td><td>Genre</td>
                                </tr>                
                <%
                
                for (Taxinomie tax : listeTaxinomies){
                %>

                    <tr>
                            <td> <%=tax.getNom()%></td>
                            <td> <%=tax.getRegneIdregne().getNom()%></td>
                            <td> <%=tax.getClasseIdclasse().getNom()%></td>
                            <td>   <a href="#"> Voir </a></td>
                            <td> <%=tax.getEmbranchementIdembranchement().getNom()%></td>
                            <td> <%=tax.getOrdreIdordre().getNom()%></td>
                            <td> <%=tax.getGenreIdgenre().getNom()%></td>
                            
                            <td> 
                                <a style="color:red;" href = /association-tax/delete-site?id=<%=tax.getIdtaxinomie()%> >
                                   Supprimer
                                </a>
                                </br>
                                <a href = /association-arche/modify-tax?id=<%=tax.getIdtaxinomie()%> >
                                   Modifier
                                </a> 
                            </td>
                    </tr>	
            <%
                }
            }%>

         <div display="inline-block" align="center">
			<button class="btn btn-success " type="submit"><a href="/association-arche/create-site" style="color:white;">Nouvelle taxinomie </a>
                            <br>
		</div>
                        </br>
</div>

