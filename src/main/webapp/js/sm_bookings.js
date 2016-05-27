$(function(){
	
	//event handling on Add Booking for SM button
	$(".sm-user-bookings").click(function()
	{
		//construct url for SM Active page
		
		var pnrValue = $(this).find(".pnrValue").html();
		var flightValue =  $(this).find(".flightValue").html(); 
		var mockEnabled =   'on' ;
		
	 	window.location.href = 'sm_active_page.html?pnrValue='+pnrValue+'&flightValue='+flightValue+'&mockEnabled='+mockEnabled;
 		
	});
	
	//event handling on SET REMINDERS
	$(".sm-set-reminders").click(function()
	{
		//construct url for SM INactive page
		 
		var pnrValue = $(this).find(".pnrValue").html();
		var flightValue =  $(this).find(".flightValue").html(); 
		var mockEnabled =   'on' ;
		 
	 	window.location.href = 'sm_inactive_page.html?pnrValue='+pnrValue+'&flightValue='+flightValue+'&mockEnabled='+mockEnabled;
 		
	});
	
});