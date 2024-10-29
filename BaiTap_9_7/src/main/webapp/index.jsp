<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Form</title>
    <style>
        body {
            background-color: rgba(253, 214, 214, 0.97);
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            
        }

        form {
            background-color: #131313;
            padding: 20px;
            border-radius: 8px;
            width: 400px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            color: #ffffff;
        }

        h2 {
            text-align: center;
            color: #ffffff;
        }

        .inline-fields {
            display: flex;
            justify-content: space-between;
            gap: 10px; /* Adjusts spacing between fields */
        }

        .inline-fields > div:first-child {
            margin-right: 10px; /* Adds space between first and last name fields */
        }

        label {
            display: block;
            margin-top: 10px;
            font-size: 14px;
        }

        input[type="text"],
        input[type="email"],
        input[type="password"],
        textarea {
            width: calc(100% - 10px);
            padding: 8px;
            margin-top: 5px;
            border: none;
            border-radius: 4px;
            font-size: 14px;
        }

        textarea {
            height: 60px;
        }

        input[type="submit"] {
            background-color: #333;
            color: #fff;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-top: 15px;
            width: 100%;
            font-size: 16px;
        }

        input[type="submit"]:hover {
            background-color: #555;
        }

        .required::after {
            content: '*';
            color: red;
        }
    </style>
</head>
<body>
<img src="https://1.bp.blogspot.com/-KiiVgbOcA2s/Xp3JoQri1yI/AAAAAAAAh4s/d1nZKsMBQNUFrw3g7VCC-IqTH65rMn9EQCLcBGAsYHQ/s1600/Hinh-nen-blackpink%2B%252819%2529.jpg" alt="" style="height: 600px">
<form method="post" action="RegistrationForm" name="registrationForm">
    <h2>Register</h2>
    <div class="inline-fields">
        <div>
            <label for="fname" class="required">First Name</label>
            <input type="text" id="fname" name="fname" required>
        </div>
        <div>
            <label for="lname" class="required">Last Name</label>
            <input type="text" id="lname" name="lname" required>
        </div>
    </div>
    <label for="username" class="required">Username</label>
    <input type="text" id="username" name="username" required>
    <label for="email" class="required">E-mail</label>
    <input type="email" id="email" name="email" required>
    <label for="password" class="required">Password</label>
    <input type="password" id="password" name="password" required>
    <label for="facebook">Facebook</label>
    <input type="text" id="facebook" name="facebook" placeholder="Enter your Facebook profile URL.">
    <label for="bio">Short Bio</label>
    <textarea id="bio" name="bio" placeholder="Chia sẽ trải nghiệm của bạn."></textarea>
    <input type="submit" value="Submit">
</form>
</body>
</html>
