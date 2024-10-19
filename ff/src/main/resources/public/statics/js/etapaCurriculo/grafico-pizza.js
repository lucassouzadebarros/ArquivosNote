function renderizarGraficoPie(legenda, numeros, nomeGrafico, seletor) {

    let data = [];

    for (let i = 0; i < legenda.length; i++) {

        let montagem = [];

        montagem.push(legenda[i]);
        montagem.push(numeros[i]);

        data.push(montagem);
        montagem = [];
    }


    Highcharts.chart(seletor, {
        chart: {
            type: 'pie',
            options3d: {
                enabled: true,
                alpha: 45,
                beta: 0
            }
        },
        title: {
            text: nomeGrafico
        },
        accessibility: {
            point: {
                valueSuffix: '%'
            }
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                depth: 35,
                dataLabels: {
                    enabled: true,
                    format: '{point.name}'
                }
            }
        },
        series: [{
            type: 'pie',
            name: 'Porcentagem',
            data: data
        }]

    });
}