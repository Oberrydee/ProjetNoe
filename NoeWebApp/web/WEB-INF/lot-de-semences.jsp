
<%@page import="entities.LotDeSemence"%>
<%@page import="entities.Salle"%>
<%@page import="model.AccessBD"%>
<%@page import="entities.SiteDeStokage"%>
<%@page import="java.util.List"%>
<html lang="fr">
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="assets\css\app.css">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author"      content="Ibtissame FRIKS">
	
	<title>Lots</title>

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
            List<LotDeSemence> listeLotDeSemences  = (List<LotDeSemence>)AccessBD.selectAllLotsDeSemences();
            if(listeLotDeSemences  != null && !listeLotDeSemences .isEmpty() ){
                
                %>
			<table class="tableau_demande" colspan=7 class="colspan">
				</br>
				</br>
				<tr>
				<td>Identifiant</td><td>Site de stockage</td><td>Disponibilit�</td>
                                <td>Dur�e de stockage</td><td>Quantit�(en casiers)</td><td>Conditions de conservation</td>
                                </tr>                
                <%
                
                for (LotDeSemence lot : listeLotDeSemences ){
                %>

                    <tr>
                            <td>Lot <%=lot.getIdLotDeSemence()%></td>
                            <td>Site  <%=lot.getSiteDeStockageSiteDeStockage().getIdSiteDeStokage()%></td>
                            <td> <%=lot.getDisponibiliteEnStock()%></td>
                            <td> <%=lot.getDureeDeStockageEnMois()%></td>
                            <td> <%=lot.getQuantiteEnNbDeCaisses()%></td>
                            <td> <a href="#" ><%=lot.getSalleidSalle().getDescription()%></a></td>
                            <td> 
                                <a style="color:red;" href = /association-arche/delete-lot?id=<%=lot.getIdLotDeSemence()%> >
                                   Supprimer
                                </a>
                                </br>
                                <a href = /association-arche/modify-lot?id=<%=lot.getIdLotDeSemence()%> >
                                   Modifier
                                </a> 
                            </td>
                    </tr>	
            <%
                }
                        }%>

                        <form action="/association-arche/create-lot">
         <div display="inline-block" align="center">
			<button class="btn btn-success " type="submit" style="color:white;">Nouveau Lot
                        </button>
                            <br>
		</div>
                        </br>
                        </form>
</div>

