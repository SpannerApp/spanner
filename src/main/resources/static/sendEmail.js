function isEmpty(str) {
    return (!str || 0 === str.length);
}

function isEmptyAnyFormElement(email, name, message){
    if(isEmpty(email) || isEmpty(name) || isEmpty(message)){
        return true;
    }
    return false;
}

function sendEmail(){

    var email = document.getElementById("email").value;
    var name = String(document.getElementById("name").value);
    var subject = document.getElementById("subject").value;
    var message = String(document.getElementById("message").value);

     if(!isEmptyAnyFormElement(email, name, message)){
         Email.send("spannerapp@gmail.com",
             "spannerapp@gmail.com",
             subject,
             message + "\n" + "Given employee e-mail: " + email + "\n" + "Given name: " + name,
             "smtp.gmail.com",
             "spannerapp@gmail.com",
             "spanner123");

     }




}

