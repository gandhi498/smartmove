$(function()
{

	window.pnrValue =  $.urlParam('pnrValue');
	window.flightValue = $.urlParam('flightValue');
	
	var offerLink = $.urlParam('offerLink');
	 
	console.log('offerLink='+offerLink);
	
	var uberEstimates = '';
	

	$.ajax({
	    
		type: 'GET',
 	    
//		url = "/smartmoves/users/548482096390c2cd08ef4e8b/offers/uber/pnr/"+pnrValue+"/flight/"+flightValue+"/fare',
		
		url : offerLink,
		
	    crossDomain: true,

//	    data:'{"userGPSLocationLat": "100","userGPSLocationLong" : "200", "airportGPSLocationLat": "300",  "airportGPSLocationLong": "400", "distance":'+distanceMtrs+',"mode": "Car","pnr": "'+pnrValue+'","flightNumber": "'+flightValue+'", "eta": '+etaMinutes+'}',
	    
	    dataType: 'json',
	     
	    contentType: 'application/json', 
	    
	    success: function(responseData, textStatus, jqXHR) 
	    	{

	    	//sample UBER reply 
//	    	{
//	    	"estimates": 
//	    		[
//	    		{
//	    			"vehicle_view":
//	    			{	
//	    				"display_name":"uberPOP","id":1270,"product_display_type":"uberx"
//	    			},
//	    			"fare_string":"€ 15-20"
//	    		},
//	    		{
//	    			"vehicle_view":
//	    			{
//	    				"display_name":"UberBLACK","id":64,"product_display_type":"black"
//	    			},
//	    			"fare_string":"€ 28-36"
//	    		},
//	    		{
//	    			"vehicle_view":
//	    			{
//	    				"display_name":"UberLUX","id":343,"product_display_type":"lux"
//	    			},
//	    			"fare_string":"€ 35-45"
//	    		}
//	    		]
//	    	};
	    	 
	    	var uberCount = 0;
	    	var ubrEstimates = responseData.estimates;
	    	
	    	for(uberCount;uberCount<ubrEstimates.length;uberCount++)
	    	{
	    		display_name = ubrEstimates[uberCount].vehicle_view.display_name;
	    		productId =  ubrEstimates[uberCount].vehicle_view.id;
	    		fare = ubrEstimates[uberCount].fare_string;
	    		 
	    		$('#uber_qoutes').append('<a href="sm_book_uber_page.html?productId='+productId+'" class="sm-page-content"><div class="sm-page-conent-label-major"> Uber Name : '+display_name+' </div><div class="sm-page-conent-label-major"> Estimated Cost: '+fare+' </div> </a>');
	    		
	    	}
		
	    },
	    error: function (responseData, textStatus, errorThrown) {
	        alert('$.ajax POST failed.');
		    }
		});
	
	//create HTML snippet for each flight
	

});