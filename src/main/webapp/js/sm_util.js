$(document).ready(function() 
{

//utility to get PARAMS from url
	
	$.urlParam = function(name){
	    var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
	    if (results==null){
	       return null;
	    }
	    else{
	       return results[1] || 0;
	    }
	};
 
window.pnrValue =  $.urlParam('pnrValue');
window.flightValue = $.urlParam('flightValue');

console.log('user entered PNR='+pnrValue + " flight="+flightValue);

});
