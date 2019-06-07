function drawGraph(id, caption, element1, element2, element3, element4,
		element5, element6, val1, val2, val3, val4, val5, val6) {
	var ctx = document.getElementById(id).getContext('2d');
	console.log(ctx);
	console.log(caption);
	console.log(element1)
	var myChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : [ element1, element2, element3, element4, element5,
					element6 ],
			datasets : [ {
				label : '# ' + caption,
				data : [ val1, val2, val3, val4, val5, val6 ],
				backgroundColor : [ '#3e95cd',
						'#8e5ea2', '#3cba9f',
						'#e8c3b9', '#c45850',
						'rgba(255, 159, 64, 0.2)' ],
				borderColor : [ '#3e95cd',
					'#8e5ea2', '#3cba9f',
					'#e8c3b9', '#c45850',
					'rgba(255, 159, 64, 0.2)'],
				borderWidth : 1
			} ]
		},
		options : {
			scales : {
				yAxes : [ {
					ticks : {
						beginAtZero : true
					}
				} ]
			}
		}
	});
}

function drawCharts(id, caption, dates_variations) {
	console.log(id);
	var ctx = document.getElementById('circleChart' + id).getContext('2d');
	var ctx1 = document.getElementById('lineChart' + id).getContext('2d');
	var data = new Array();
	var labels = new Array();
	var newBackgroundColors = new Array();
	var newBorderColors = new Array();
	var backgroundColor = [
		'rgba(255, 99, 132, 1)',
        'rgba(54, 162, 235, 1)',
        'rgba(255, 206, 86, 1)',
        'rgba(75, 192, 192, 1)',
        'rgba(153, 102, 255, 1)',
        'rgba(255, 159, 64, 1)',
        'rgba(255, 99, 150, 0.2)',
        'rgba(255, 90, 132, 0.2)',
        'rgba(255, 90, 188, 0.2)',
        'rgba(255, 90, 20, 0.2)',
        'rgba(255, 100, 62, 0.2)',
        'rgba(255, 80, 132, 0.2)',
        'rgba(255, 40, 132, 0.2)',
        'rgba(255, 80, 32, 0.2)',
        'rgba(255, 90, 200, 0.2)',
        'rgba(255, 70, 200, 0.2)',
        'rgba(255, 150, 132, 0.2)',
        'rgba(255, 250, 132, 0.2)',
        'rgba(255, 92, 132, 0.2)'
	];
	var borderColor = [
		'rgba(255, 99, 132, 1)',
        'rgba(54, 162, 235, 1)',
        'rgba(255, 206, 86, 1)',
        'rgba(75, 192, 192, 1)',
        'rgba(153, 102, 255, 1)',
        'rgba(255, 159, 64, 1)',
        'rgba(255, 99, 150, 0.2)',
        'rgba(255, 90, 132, 0.2)',
        'rgba(255, 90, 188, 0.2)',
        'rgba(255, 90, 20, 0.2)',
        'rgba(255, 100, 62, 0.2)',
        'rgba(255, 80, 132, 0.2)',
        'rgba(255, 40, 132, 0.2)',
        'rgba(255, 80, 32, 0.2)',
        'rgba(255, 90, 200, 0.2)',
        'rgba(255, 70, 200, 0.2)',
        'rgba(255, 150, 132, 0.2)',
        'rgba(255, 250, 132, 0.2)',
        'rgba(255, 92, 132, 0.2)'
	];
	var index = 0;
	dates_variations.forEach((action) => {
		data.push(action.variation);
		labels.push("Date: " + action.date);
		newBackgroundColors.push(backgroundColor[index]);
		newBorderColors.push(backgroundColor[index]);
		index++;
	});
	
	var myPieChart = new Chart(ctx, {
		type : 'pie',
		data: {
		        labels: labels,
		        datasets: [{
		            label: '# Historique de: ' + caption,
		            data: data,
		            backgroundColor: newBackgroundColors,
		            borderColor: newBorderColors,
		            borderWidth: 1
		        }]
		    },
		options : {
			scales : {
				yAxes : [ {
					ticks : {
						beginAtZero : true
					}
				} ]
			}
		}
	});
	
	console.log(data)
	
	var myLineChart = new Chart(ctx1, {
	    type: 'line',
	    data: {
	        labels: labels	,
	        datasets: [{ 
	            data: data,
	            label: caption,
	            borderColor: "#3e95cd",
	            fill: false
	          }
	        ]
	      },
	      options: {
	        title: {
	          display: true,
	          text: 'Historique de l\'action: ' + caption
	        }
	      }
	});
}

function getRandomColor() {
	  var letters = '0123456789ABCDEF';
	  var color = '#';
	  for (var i = 0; i < 6; i++) {
	    color += letters[Math.floor(Math.random() * 16)];
	  }
	  return color;
	}

function drawAllActionsLineCharts(dates_variations) {
	var ctx = document.getElementById('allActionsLineChart').getContext('2d');
	var backgroundColor = [
		'rgba(255, 99, 132, 1)',
        'rgba(54, 162, 235, 1)',
        'rgba(255, 206, 86, 1)',
        'rgba(75, 192, 192, 1)',
        'rgba(153, 102, 255, 1)',
        'rgba(255, 159, 64, 1)',
        'rgba(255, 99, 150, 0.2)',
        'rgba(255, 90, 132, 0.2)',
        'rgba(255, 90, 188, 0.2)',
        'rgba(255, 90, 20, 0.2)',
        'rgba(255, 100, 62, 0.2)',
        'rgba(255, 80, 132, 0.2)',
        'rgba(255, 40, 132, 0.2)',
        'rgba(255, 80, 32, 0.2)',
        'rgba(255, 90, 200, 0.2)',
        'rgba(255, 70, 200, 0.2)',
        'rgba(255, 150, 132, 0.2)',
        'rgba(255, 250, 132, 0.2)',
        'rgba(255, 92, 132, 0.2)'
	];
	var borderColor = [
		'rgba(255, 99, 132, 1)',
        'rgba(54, 162, 235, 1)',
        'rgba(255, 206, 86, 1)',
        'rgba(75, 192, 192, 1)',
        'rgba(153, 102, 255, 1)',
        'rgba(255, 159, 64, 1)',
        'rgba(255, 99, 150, 0.2)',
        'rgba(255, 90, 132, 0.2)',
        'rgba(255, 90, 188, 0.2)',
        'rgba(255, 90, 20, 0.2)',
        'rgba(255, 100, 62, 0.2)',
        'rgba(255, 80, 132, 0.2)',
        'rgba(255, 40, 132, 0.2)',
        'rgba(255, 80, 32, 0.2)',
        'rgba(255, 90, 200, 0.2)',
        'rgba(255, 70, 200, 0.2)',
        'rgba(255, 150, 132, 0.2)',
        'rgba(255, 250, 132, 0.2)',
        'rgba(255, 92, 132, 0.2)'
	];
	
	
	let labels = []
	let data = [];
	let newBackgroundColor = []
	
	dates_variations.forEach((action) => {
		labels.push(action.name);
		console.log(action.variation)
		newBackgroundColor.push(getRandomColor());
		data.push(action.variation);
	});
	
	
	new Chart(ctx, {
		
		type: 'horizontalBar',
	    data: {
	      labels: labels,
	      datasets: [{
	        label: "Historique des actions",
	        backgroundColor: newBackgroundColor,
	        data: data
	      }]
	    },
	    options: {
	      title: {
	        display: true,
	        text: 'Liste des actions'
	      }
	    }
	});
}







