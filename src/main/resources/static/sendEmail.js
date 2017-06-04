

function notNullFormElements(email, name, subject, message){
    if(email != null && name != null && subject != null & message != null){
        return true;
    }
    return false;
}

function sendEmail(){

    var email = document.getElementById("email").value;
    var name = document.getElementById("name").value;
    var subject = document.getElementById("subject").value;
    var message = document.getElementById("message").value;

    Email.send("spannerapp@gmail.com",
        "spannerapp@gmail.com",
         subject,
         message + "\n" + "Given employee e-mail: " + email + "\n" + "Given name: " + String(name),
        "smtp.gmail.com",
        "spannerapp@gmail.com",
        "spanner123");
}

