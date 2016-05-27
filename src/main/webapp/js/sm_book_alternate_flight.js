$(function()
{
	var alternateFlightValue = $.urlParam(alternateFlightValue);
	
	console.log('alternateFlightValue='+alternateFlightValue);
	
	$("#originalFlight").html('Your original flight was '+flightValue);
	
	$("#alternateFlight").html('You selected alternate flight as '+alternateFlightValue);
	
	//show user selected alternate flight

});