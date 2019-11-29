div class="container">
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
    <input type="radio" name="sex" value="boy" id="sex1"/>Male
    <input type="radio" name="sex" value="girl" id="sex1"/>Female
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
