$(function(){
	
	//event handling on Add Booking for SM button
	$("#smAddPNRButton").click(function()
	{
		//construct url for SM Active page
		
		var pnrValue = $("#pnrValue").val();
		var flightValue = $("#flightValue").val(); 
		var mockEnabled =  $("#mockEnabled").val(); 
		 
		var userLastName = "shop";

		if(mockEnabled=='on')
		{
		 	window.location.href = 'sm_active_page.html?pnrValue='+pnrValue+'&flightValue='+flightValue+'&mockEnabled='+mockEnabled;
		}
		else
		{
		 	window.location.href = 'sm_active_page.html?pnrValue='+pnrValue+'&flightValue='+flightValue+'&mockEnabled='+mockEnabled;

			//do add booking and load on BOOKINGS page
			
/*			$.ajax
			({
			    
				type: 'POST',
		 	    
				url = "/smartmoves/smartmoves/users/1/bookings",
				
				url : offerLink,
				
			    crossDomain: true,

			    data:'{"bookingCode": "'+pnrValue+'","lastName" : "'+userLastName+'"}',
			    
			    dataType: 'json',
			     
			    contentType: 'application/json',
			    
			    success: function(responseData, textStatus, jqXHR) 
			    {
			    	console.log('addBookings responseData='+responseData);
	
				 	window.location.href = 'sm_bookings_page.html';
					
			    },
			    error: function (responseData, textStatus, errorThrown) 
			    {
			        alert('$.ajax POST failed.');
				}
			    
			});
*/
			
		}	
	});
	
	
});