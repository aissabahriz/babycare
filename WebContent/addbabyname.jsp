<!DOCTYPE html>
<html lang="en">
  <head>
     <title>First Bootstrap</title>
     <link rel="stylesheet" href="resources/bootstrap.min.css"/>
  </head>
  <body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="index.html">BabyCare</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="index.html">Home</a></li>
        <li class="active"><a href="ViewBabyName">Baby Names</a></li>
        <li><a href="ViewMoms">Moms</a></li>
        <li><a href="tips.html">Tips</a></li>
        <li><a href="food.html">Food</a></li>
        <li><a href="fashion.html">Fashion</a></li>
		<li><a href="product.html">Product</a></li>
		<li><a href="news.html">News</a></li>
		<li><a href="Admin">Admin</a></li>
        </ul>

    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<div class="container">
  <h1>Add Baby Name</h1>

<form style="width:300px" action="AddBabyName" method="post">
  <div class="form-group">
    <label for="name1">Name:</label>
    <input type="text" name="name" class="form-control" id="name1" placeholder="Name"/>
  </div>
  <div class="form-group">
    <label for="weigth1">Weight:</label>
    <input type="text" name="weigth" class="form-control" id="weigth1" placeholder="Weigth"/>
  </div>
  <div class="form-group">
    <label for="sex1">Sex:</label>
    <input type="radio" name="sex" value="boy" id="sex1"/>Boy
    <input type="radio" name="sex" value="girl" id="sex1"/>Girl
  </div>
  <div class="form-group">
    <label for="age1">Age:</label>
    <select name="age" class="form-control" id="age1">
    <option>1</option>
    <option>2</option>
    <option>3</option>
    <option>4</option>
    <option>5</option>
    <option>6</option>
    <option>7</option>
    </select>
  </div>
  
  <button type="submit" class="btn btn-primary">Add Baby Name</button>
</form>
</div>

  <script src="resources/jquery.min.js"></script>
  <script src="resources/bootstrap.min.js"></script>
  </body>
</html>