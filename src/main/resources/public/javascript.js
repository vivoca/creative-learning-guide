function myFunction() {
    var answer = document.forms[0];
    var txt = "";
    var i;
    for (i = 0; i < answer.length; i++) {
        if (answer[i].checked && answer[i].value === "gestern") {
            txt = "right";
        }
    }
    if (txt === "") {
        txt = "wrong. The right answer is " + answer[1].value
    }
    document.getElementById("solution").value = "Your answer is " + txt;
}