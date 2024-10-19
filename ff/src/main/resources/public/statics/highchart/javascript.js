function politicaLgpd() {
	$.ajax({

		url : "/usuario/politicaLgpd/",
		success : function(data) {
			$("#abrePoliticaModalHolder").html(data);
			$('#abrePoliticaModal').modal({
				backdrop : 'static',
				keyboard : false
			});
		}
	});
}

function highChartVaga() {
	$.ajax({

		url : "relatorio",
		success : function(result) {

			var series = [];
			var data = [];

			for (var i = 0; i < result.length; i++) {
				var object = {};

				object.name = result[i].cargo;
				object.y = result[i].quantidade;
				data.push(object);
			}
			var seriesObject = {
				colorByPoint : true,
				data : data
			};
			series.push(seriesObject);
			drawPieChartVaga(series);
		}
	})
}

function highChartCandidatura() {
	$.ajax({

		url : "relatorio",
		success : function(result) {

			var series = [];
			var data = [];

			for (var i = 0; i < result.length; i++) {

				var object = {};

				object.name = result[i].cargo;
				object.y = result[i].candidaturas.length;
				data.push(object);

			}
			var seriesObject = {
				colorByPoint : true,
				data : data
			};
			series.push(seriesObject);
			drawPieChartCandidatura(series);
		}
	})
}

function drawPieChartVaga(series) {
	Highcharts.chart('containerModal', {
		chart : {
			type : 'pie',
			options3d : {
				enabled : true,
				alpha : 45,
				beta : 0
			}
		},
		title : {
			text : 'VAGAS'
		},
		subtitle : {
			text : 'Número de vagas por cargo'
		},
		accessibility : {
			point : {
				valueSuffix : '%'
			}
		},
		tooltip : {
			pointFormat : '<b>{point.percentage:.1f}%</b>'
		},
		plotOptions : {
			pie : {
				allowPointSelect : true,
				cursor : 'pointer',
				depth : 35,
				colors : [ '#ff9327', '#1065a4', '#f6bf85', '#1f74b3',
						'#005594', '#f6be84', '#166baa' ],
				dataLabels : {
					enabled : true,
					format : '<b>{point.name} = {point.y}</b>'
				},
				showInLegend : true
			}
		},
		series : series
	});
}

function drawPieChartCandidatura(series) {
	Highcharts.chart('containerModal', {
		chart : {
			type : 'column',
			options3d : {
				enabled : true,
				alpha : 15,
				beta : 20,
				depth : 50,
				viewDistance : 20
			}
		},
		legend : {
			enabled : false
		},
		title : {
			text : 'CANDIDATURAS'
		},
		subtitle : {
			text : 'Número de candidatos por vaga'
		},
		tooltip : {
			formatter : function() {
				return '<strong>' + this.key + ' </strong>';
			}
		},
		plotOptions : {
			column : {
				allowPointSelect : true,
				cursor : 'pointer',
				colors : [ '#ff9327', '#1065a4', '#f6bf85', '#1f74b3',
						'#005594', '#f6be84', '#166baa' ],
				dataLabels : {
					enabled : true,
					format : '<b>{point.y}</b>',
				},
				showInLegend : true
			}
		},
		xAxis : {
			type : 'category'
		},
		series : series
	});
}