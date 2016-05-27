$( document ).ready(function()
{

var offerLink =  $.urlParam('offerLink');

console.log('offerLink='+offerLink);

if(!offerLink)
{
	offerLink = "https://www.klm.com/ams/checkin/web/kl/nl/en"; 
}

var icirDeepLinkUlr = offerLink + "/identify?identificationType=PNR&identificationValue="+ pnrValue + "&flightNumber="+ flightValue ;

$("#icirIFrame").attr('src',icirDeepLinkUlr);  


});