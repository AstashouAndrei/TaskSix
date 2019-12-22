<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Airline</title>
    <style type="text/css">
        body {
            background: url("resources/img/airline.jpg");
            background-size: 100%;
        }
    </style>
</head>

<body>
<h1> Airline Crew Staff</h1>
<form>
    <input type="text" name="staffID" id="staffID" placeholder="Please, enter staff ID">
    <input type="button" name="submit" id="submit" onclick="getStaff()" value="Get staff by ID">
    <input type="reset" value="Cancel">
</form>

<br>

<div id="loading"></div>

<table id="staff" width="25%" cellspacing="0" cellpadding="4" border="1">
    <tr>
        <th align="left" width="15%">Staff ID</th>
        <th align="center">First name</th>
        <th align="center">Last name</th>
        <th align="center">Profession</th>
    </tr>
</table>

<script type="text/javascript">

    function isInt(value) {
        return !isNaN(value) &&
            parseInt(Number(value)) == value &&
            !isNaN(parseInt(value, 10));
    }

    function getStaff() {
        var id = document.getElementById('staffID').value;
        if (isInt(id) && id > 0) {
            document.getElementById('loading').innerHTML = "Loading, please wait...";
            request = new XMLHttpRequest();
            if (!request) {
                console.log('Unable to create XMLHTTP instance');
                return false;
            }
            request.open("GET", 'StaffController?id=' + id, true);
            request.responseType = 'json';
            request.send();
            request.onreadystatechange = function () {
                if (request.readyState == XMLHttpRequest.DONE) {
                    document.getElementById('loading').innerHTML = "";
                    if (request.status == 200) {
                        var table = document.getElementById('staff');
                        for (var i = 1; i < table.rows.length;) {
                            table.deleteRow(i);
                        }
                        var staff = request.response;
                        var row = table.insertRow(table.rows.length);
                        row.style.textAlign ="center";
                        var cell = row.insertCell(0);
                        var cell1 = row.insertCell(1);
                        var cell2 = row.insertCell(2);
                        var cell3 = row.insertCell(3);
                        var id = document.createTextNode(staff.id);
                        var firstName = document.createTextNode(staff.firstName);
                        var lastName = document.createTextNode(staff.lastName);
                        var profession = document.createTextNode(staff.profession);
                        cell.appendChild(id);
                        cell1.appendChild(firstName);
                        cell2.appendChild(lastName);
                        cell3.appendChild(profession);
                    } else {
                        console.log('Something went wrong..!!');
                    }
                }
            }
        } else {
            alert("ID should be positive integer");
        }
    }
</script>

</body>
</html>