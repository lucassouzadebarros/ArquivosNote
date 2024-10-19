$(document).ready(function() {


    $('#abrirModalEscolaridade').click(function(e) {

        $.ajax({
            type: "GET",
            url: "/relatorio/buscarTodasEscolaridades",
            async: false,
            success: function(response) {
                //$('.progress').fadeOut();
                //$("#container").fadeIn();
                popularComboEscolaridade(response);
                $("#con-close-modal-escolaridade").modal();

            },
            error: function(response) {

            },
            complete: function() {

            }
        });


    });

    $('#abrirModalRegiao').click(function(e) {

        $.ajax({
            type: "GET",
            url: "/relatorio/buscarTodosEstados",
            success: function(response) {
                $("#con-close-modal-regiao").modal();
                popularCombos('estado', response);
            }
        });


    });

    $('#select-estado').change(function(e) {

        $.ajax({
            type: "GET",
            url: "/relatorio/buscarCidadesPorEstado?estado=" + e.target.value,
            success: function(response) {
                popularCombos('cidade', response);
            }
        });

    });

    $('#select-cidade').change(function(e) {
        console.log("chegouu");
        $.ajax({
            type: "GET",
            url: "/relatorio/buscarBairrosPorCidade?cidade=" + e.target.value,
            success: function(response) {
                popularCombos('bairro', response);
            }
        });

    });


    $('#buscar-escolaridade').click(function(e) {

        //$("#container").fadeOut();
        //$('.progress').fadeIn();

        console.log($(this).closest(".row").find("#escolaridade > div > select").val())

        $.ajax({
            type: "GET",
            url: "/relatorio/formacao",
            async: false,
            success: function(response) {
                //$('.progress').fadeOut();
                //$("#container").fadeIn();
                montarGrafico(response, "Relatório de Escolaridade", "container-relatorio-escolaridade");

            },
            error: function(response) {

            },
            complete: function() {

            }
        });

    });

    $('#buscar-deficiencia').click(function(e) {

        //$("#container").fadeOut();
        //$('.progress').fadeIn();


        $.ajax({
            type: "GET",
            url: "/relatorio/deficiencia",
            async: false,
            success: function(response) {
                //$('.progress').fadeOut();
                //$("#container").fadeIn();
                montarGraficoDeficiencia(response, "Relatório de Deficiência", "container-relatorio-deficiencia");

            },
            error: function(response) {

            },

            complete: function() {

            }
        });


    });

    $('#buscar-idade').click(function(e) {

        montarGraficoIdade("response", "Relatório de Idade", "container-relatorio-idade");
    });

    $('#buscar-regiao').click(function(e) {

        montarGraficoRegiao("response", "Relatório de Regiao", "container-relatorio-regiao");
    });
});

function montarGrafico(informacoesGrafico, nomeGrafico, seletor) {

    let legenda = [];
    let numeros = [];

    $.each(informacoesGrafico, function(indexInArray, valueOfElement) {
        legenda.push(valueOfElement.NIVEL);
        numeros.push(valueOfElement.QUANTIDADE);

        renderizarGraficoPie(legenda, numeros, nomeGrafico, seletor);
    });


}


function montarGraficoDeficiencia(informacoesGrafico, nomeGrafico, seletor) {

    let legenda = [];
    let numeros = [];

    $.each(informacoesGrafico, function(indexInArray, valueOfElement) {
        console.log(valueOfElement.DEFICIENCIA == 0)
        legenda.push(valueOfElement.DEFICIENCIA == 0 ? "Auditiva" : "Múltipla");
        numeros.push(valueOfElement.QUANTIDADE);

        renderizarGraficoPie(legenda, numeros, nomeGrafico, seletor);
    });


}

function montarGraficoIdade(informacoesGrafico, nomeGrafico, seletor) {

    let legenda = [];
    let numeros = [];

    legenda = ["14 anos à 24 anos", "36 anos à 50 anos", "51 ++"];
    numeros = [20, 30, 10];

    renderizarGraficoPie(legenda, numeros, nomeGrafico, seletor);
}

function montarGraficoRegiao(informacoesGrafico, nomeGrafico, seletor) {

    let legenda = [];
    let numeros = [];

    legenda = ["Botafogo", "Bangu", "Centro", "Flamengo", "Glória", "Lapa"];
    numeros = [20, 30, 10, 10, 10, 20];

    renderizarGraficoPie(legenda, numeros, nomeGrafico, seletor);

    /*
    $.each(informacoesGrafico, function(indexInArray, valueOfElement) {
        console.log(valueOfElement.DEFICIENCIA == 0)
        legenda.push(valueOfElement.DEFICIENCIA == 0 ? "Auditiva" : "Múltipla");
        numeros.push(valueOfElement.QUANTIDADE);

    });*/


}

function popularComboEscolaridade(dados) {

    $.each(dados, function(indexInArray, valueOfElement) {
        $("#escolaridade > div > select").append("<option value=" + valueOfElement.id + ">" + valueOfElement.descricao + "</option>");
    });

}

function popularCombos(seletor, dados) {
    $('#select-' + seletor + ' > option').remove();

    $.each(dados, function(indexInArray, valueOfElement) {
        $("#select-" + seletor).append("<option value=" + valueOfElement.id + ">" + valueOfElement.nome + "</option>");

    });
    $("#select-" + seletor).selectpicker('refresh');
    $('#select-' + seletor + ' ').trigger('change');
}