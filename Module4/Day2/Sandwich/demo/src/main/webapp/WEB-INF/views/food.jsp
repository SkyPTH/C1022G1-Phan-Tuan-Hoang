<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Food</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<form method="get" action="/food">
    <div class="mb3">
        <label for="lettuce">Lettuce</label>
        <input type="checkbox" name="condiment" value="lettuce" id="lettuce">
    </div>
    <div class="mb3">
        <label for="tomato">Tomato</label>
        <input type="checkbox" name="condiment" value="tomato" id="tomato">
    </div>
    <div class="mb3">
        <label for="mustard">Mustard</label>
        <input type="checkbox" name="condiment" value="mustard" id="mustard">
    </div>
    <div class="mb3">
        <label for="sprouts">Sprouts</label>
        <input type="checkbox" name="condiment" value="sprouts" id="sprouts">
    </div>
    <input type="submit" value="Save">
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>