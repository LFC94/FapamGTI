function somarvalorcd(campo) {
    var quant = document.getElementById("txtQuant").value;

    document.getElementById("txtValor").value = Number(document.getElementById("txtQuant").value) * 1.5

}

function validasenha() {

    if (document.getElementById("txtSenha").value == document.getElementById("txtConfirmaSenha").value) {
        return true;
    } else {
        return false;
    }

}

function validacampovazio() {

    if (this.value) {
        return true;
    } else {
        return false;
    }

}