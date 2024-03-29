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
        <li><a href="tips.html">Tips</a></li>
        <li><a href="food.html">Food</a></li>
		<li><a href="product.html">Product</a></li>
		<li class="active"><a href="Admin">Admin</a></li>
        </ul>

    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<div class="container">
  <h1>Admin Login</h1>

<form style="width:300px" action="AdminAuthenticator" method="post">
  <div class="form-group">
    <label for="name1">Name</label>
    <input type="text" name="name" class="form-control" id="name1" placeholder="Name"/>
  </div>
  <div class="form-group">
    <label for="password1">Password</label>
    <input type="password" name="password" class="form-control" id="password1" placeholder="Password"/>
  </div>
  
  <button type="submit" class="btn btn-primary">Login</button>
</form>
</div>

  <script src="resources/jquery.min.js"></script>
  <script src="resources/bootstrap.min.js"></script>
  </body>
</html>