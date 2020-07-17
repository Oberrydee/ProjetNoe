<!DOCTYPE html>
<html lang="fr"> 
<head>
<meta charset="UTF-8">
<title>Galerie</title>
<style>
	
*{box-sizing:border-box}
	
	body{margin:0;padding:.25rem;display:flex;height:100vh;align-items: center}
	
	img{max-width:100%;}
	
	input[type=radio]{position:absolute;left:-9999px}/*on cache tous les input*/
	
.cadre-demo1 label{
	
cursor:pointer/*on pointe tous les labels*/
	
}

.cadre-demo1{

overflow: hidden;
position: relative;
max-width: 600px;
margin: 2rem auto
	
	}


.photos-mini{
	
	
padding-top: 66.67%;


display:flex;

	}

.miniature{

flex: 1;
padding:.25rem;
	
}
	

.fenetre{

object-fit: cover;
position:absolute;
top:0;
transition:all .6s;
left:-100%;
opacity:0}

.fen:checked~ .fenetre{
left:0%;


opacity:1}

figcaption{
text-align:center;
position:absolute;
top:0px;
left:0;
padding:.25rem;
transition:.6s;

opacity:0;
display:flex;
color:white;
background:hsla(0,0%,0%,.8)}

.fen:checked~figcaption{
transition:2s;
opacity:1}
</style>
<body>
<div class=cadre-demo1>
<div class="photos-mini">
<div class=miniature>
<input type="radio" name="demo" checked class="fen" id="lightbox-1" />
<label for="lightbox-1">
<img src="https://www.guyom-design.com/blog/images/1.jpg" alt>
</label>
<img class="fenetre" src="https://www.guyom-design.com/blog/images/1.jpg" alt>
<figcaption>Titre1, description</figcaption>
</div>
<div class=miniature>
<input type="radio" name="demo" class="fen" id="lightbox-2" />
<label for="lightbox-2">
<img src="https://www.guyom-design.com/blog/images/2.jpg" alt>
</label>
<img class="fenetre" src="https://www.guyom-design.com/blog/images/2.jpg" alt>
<figcaption>Titre2, description</figcaption>
</div>
<div class=miniature>
<input type="radio" name="demo" class="fen" id="lightbox-3" />
<label for="lightbox-3">
<img src="https://www.guyom-design.com/blog/images/3.jpg" alt>
</label>
<img class="fenetre" src="https://www.guyom-design.com/blog/images/3.jpg" alt>
<figcaption>Titre3, description</figcaption>
</div>
<div class=miniature>
<input type="radio" name="demo" class="fen" id="lightbox-4" />
<label for="lightbox-4">
<img src="https://www.guyom-design.com/blog/images/4.jpg" alt>
</label>
<img class="fenetre" src="https://www.guyom-design.com/blog/images/4.jpg" alt>
<figcaption>Titre4, description</figcaption>
</div>
<div class=miniature>
<input type="radio" name="demo" class="fen" id="lightbox-5" />
<label for="lightbox-5">
<img src="https://www.guyom-design.com/blog/images/5.jpg" alt>
</label>
<img class="fenetre" src="https://www.guyom-design.com/blog/images/5.jpg" alt>
<figcaption>Titre5, description</figcaption>
</div>
<div class=miniature>
<input type="radio" name="demo" class="fen" id="lightbox-6" />
<label for="lightbox-6">
<img src="https://www.guyom-design.com/blog/images/6.jpg" alt>	
</label>
<img class="fenetre" src="https://www.guyom-design.com/blog/images/6.jpg" alt>
<figcaption>Titre6, description</figcaption>
</div>
</div>
</div>