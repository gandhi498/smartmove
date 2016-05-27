$(function(){
	
	
	//call BE for getting list of flights
	$.ajax({
	    
		type: 'POST',
	    
	    url: '/smartmoves/users/548482096390c2cd08ef4e8b/offers/goshow/pnr/'+pnrValue+'/flight/'+flightValue,
	    
	    crossDomain: true,

//	    data:'{"userGPSLocationLat": "100","userGPSLocationLong" : "200", "airportGPSLocationLat": "300",  "airportGPSLocationLong": "400", "distance":'+distanceMtrs+',"mode": "Car","pnr": "'+pnrValue+'","flightNumber": "'+flightValue+'", "eta": '+etaMinutes+'}',
	    
	    dataType: 'json',
	    
	    contentType: 'application/json', 
	    
	    success: function(responseData, textStatus, jqXHR) 
	    	{
	        
	    	console.log('$.ajax success responseData='+responseData + " responseData.bookedFlight="+responseData.bookedFlight.marketingFlightNumber);

	    	var originalFlight = responseData.bookedFlight.marketingFlightNumber;
	    	
	    	$("#originalFlight").html('Following are alternates to your original flight '+originalFlight);
	    	
	    	var alertnateFlights = responseData.alertnateFlights;
	    	
	    	flightCount = 0;
	    	
	    	for(flightCount;flightCount<alertnateFlights.length;flightCount++)
	    	{
	    		var marketingFlightNumber = alertnateFlights[flightCount].marketingFlightNumber;
	    		
	    		var departureDate =  alertnateFlights[flightCount].departureDate;
	    		
	    		$('#alternate_flights_list').append('<a href="sm_book_alternateflight_page.html?pnrValue='+pnrValue+'&flightValue='+flightValue+'&alternateFlightValue='+marketingFlightNumber+'" class="sm-page-content"><div class="sm-page-conent-label-major"> Flight No: '+marketingFlightNumber+' </div><div class="sm-page-conent-label-major"> Date: '+departureDate+' </div> </a>');
				
	    	};
	    	
	    },
	    error: function (responseData, textStatus, errorThrown) {
	        alert('$.ajax POST failed.');
		    }
		});
	
	//create HTML snippet for each flight
	
	
});