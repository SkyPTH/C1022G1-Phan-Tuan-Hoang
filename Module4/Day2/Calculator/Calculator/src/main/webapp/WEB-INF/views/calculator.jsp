<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<form method="get" action="/calculator">
    <div class="mb3">
    <label for="firstNum">Fist number</label>
    <input type="number" name="firstNum"  id="firstNum">
    </div>
    <div class="mb3">
    <label for="secondNum">Second number</label>
    <input type="number" name="secondNum"  id="secondNum">
    </div>
    <br>
    <div class="mb3">
    <input type="submit" name="operand" value="Addition(+)">
    <input type="submit" name="operand" value="Subtraction(-)">
    <input type="submit" name="operand" value="Multiplication(*)">
    <input type="submit" name="operand" value="Division(/)">
    </div>
</form>

<h3>${result}</h3>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>