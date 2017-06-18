function myFunction() {
    var answer = document.forms[0];
    var txt = "";
    var i;
    for (i = 0; i < answer.length; i++) {
        if (answer[1].checked) {
            txt = "right";
        } else {
            txt = "wrong. The right answer is " + answer[1].value
        }
    }
    document.getElementById("answer").value = "Your answer is " + txt;
}