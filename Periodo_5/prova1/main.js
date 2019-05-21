$(document).ready(function() {
    $("#txtplaca").inputmask({ mask: 'AAA-9999' });
});

function compra() {
    document.getElementById("dadostroc").classList.value = "row hidden";
    document.getElementById("dadoscompra").classList.value = "row visible";
    document.getElementById("txttipo").value = "compra";
}

function trocar() {
    document.getElementById("dadostroc").classList.value = "row visible";
    document.getElementById("dadoscompra").classList.value = "row hidden";
    document.getElementById("txttipo").value = "troca";
}

function validarCampos() {
    var retorno = true;
    var mensagem = "";
    try {


        if (document.getElementById("txttipo").value == "") {
            mensagem += "Escolha se ira fazer a compra ou a troca<br>";
            retorno = false;
        }

        document.getElementById("txtNome").classList.value = ""
        if (document.getElementById("txtNome").value == "") {
            mensagem += "Informa o nome <br>";
            document.getElementById("txtNome").classList.value = "invalid"
            retorno = false;
        } else {
            if (document.getElementById("txtNome").value.length < 3) {
                mensagem += "O nome deve possuir 3 caracter <br>";
                document.getElementById("txtNome").classList.value = "invalid"
                retorno = false;
            }
        }


        document.getElementById("txtCPF").classList.value = ""
        if (document.getElementById("txtCPF").value == "") {
            mensagem += "Informa o CPF<br>";
            document.getElementById("txtCPF").classList.value = "invalid"
            retorno = false;
        } else {
            if (!TestaCPF(document.getElementById("txtCPF").value)) {
                mensagem += "CPF informado Invalidao<br>";
                document.getElementById("txtCPF").classList.value = "invalid"
                retorno = false;
            }
        }

        if (document.getElementById("txttipo").value == "compra") {
            document.getElementById("txtValor").classList.value = ""
            if (document.getElementById("txtValor").value == "") {
                mensagem += "Informa o Valor da Oferta<br>";
                document.getElementById("txtValor").classList.value = "invalid"
                retorno = false;
            } else {
                if (isNaN(parseFloat(document.getElementById("txtValor").value)) || parseFloat(document.getElementById("txtValor").value) > 47000) {
                    mensagem += "Valor invalido e menor que o do carro <br>";
                    document.getElementById("txtValor").classList.value = "invalid"
                    retorno = false;
                }
            }
        }

        if (document.getElementById("txttipo").value == "troca") {
            document.getElementById("txtAno").classList.value = ""
            if (document.getElementById("txtAno").value == "") {
                mensagem += "Informa o Ano do Veiculo de Troca<br>";
                document.getElementById("txtAno").classList.value = "invalid"
                retorno = false;
            } else {
                if (isNaN(parseInt(document.getElementById("txtAno").value)) || parseInt(document.getElementById("txtValor").value) < 1900 || parseInt(document.getElementById("txtValor").value) > 2017) {
                    mensagem += "Ano invalido e menor que o do carro <br>";
                    document.getElementById("txtAno").classList.value = "invalid"
                    retorno = false;
                }
            }

            document.getElementById("txtplaca").classList.value = ""
            if (document.getElementById("txtplaca").value == "") {
                mensagem += "Informa a PLACA do Veiculo de Troca<br>";
                document.getElementById("txtplaca").classList.value = "invalid"
                retorno = false;
            } else {
                if (!TestaPlaca(document.getElementById("txtplaca").value)) {
                    mensagem += "Placa invalido<br>";
                    document.getElementById("txtplaca").classList.value = "invalid"
                    retorno = false;
                }
            }
        }


        if (!retorno) {
            mostraAlerta(mensagem);
        } else {
            alert("Ok. dados Validados")
        }


    } catch (error) {
        alert(error)
    }
    return retorno;
}

function mostraAlerta(texto) {
    document.getElementById("alert").innerHTML = texto;
    document.getElementById("alert").classList.value = "alert alert-danger";
}

function esconderAlerta(texto) {
    document.getElementById("alert").innerHTML = texto;
    document.getElementById("alert").classList.value = "alert alert-danger hidden";
}

function TestaPlaca(strPlaca) {
    var regexPlate = /^[a-zA-Z]{3}[0-9]{4}$/;
    var regexPlateMerc = /^[a-zA-Z]{3}[0-9]{1}[a-zA-Z]{1}[0-9]{2}$/;
    return regexPlate.test(strPlaca) || regexPlateMerc.test(strPlaca);
}

function TestaCPF(strCPF) {
    var Soma;
    var Resto;
    Soma = 0;
    try {
        if (isNaN(parseFloat(strCPF)) || strCPF.trim().length < 9 || strCPF == "00000000000") return false;

    } catch (error) {
        alert(error);
    }
    for (i = 1; i <= 9; i++) Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (11 - i);
    Resto = (Soma * 10) % 11;

    if ((Resto == 10) || (Resto == 11)) Resto = 0;
    if (Resto != parseInt(strCPF.substring(9, 10))) return false;

    Soma = 0;
    for (i = 1; i <= 10; i++) Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (12 - i);
    Resto = (Soma * 10) % 11;

    if ((Resto == 10) || (Resto == 11)) Resto = 0;
    if (Resto != parseInt(strCPF.substring(10, 11))) return false;
    return true;
}