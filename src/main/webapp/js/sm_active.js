
$(document).ready(function() 
{

window.mockEnabled =  $.urlParam('mockEnabled');

console.log("Is mockEnabled="+mockEnabled);

var randomLocationLat, randomLocationLong = '';

var destinationLat = '52.3081';
var destinationLong = '4.7642';

var map, GeoMarker;

var numberOfSecondsToRefreshMap = 90; //no of seconds to refresh the map
 
var mockPathCoordinates = 0;

var geocoder;

  var destinationA = new google.maps.LatLng(52.3081, 4.7642); //schiphol aiport    
  
  function initialize() {
	  
	var mapOptions = {
      zoom: 5,
      center: new google.maps.LatLng(52.3081, 4.7642), //schiphol aiport
      mapTypeId: google.maps.MapTypeId.ROADMAP,
      disableDefaultUI: true
    }; 
    
    map = new google.maps.Map(document.getElementById('map_canvas'),mapOptions);

    geocoder = new google.maps.Geocoder();
    
    GeoMarker = new GeolocationMarker();
    GeoMarker.setCircleOptions({fillColor: '#808080'});


//      google.maps.event.addListenerOnce(GeoMarker, 'position_changed', function() {
//CALLED WHENVER USER POSITION IS CHANGED

//      	//alert("pos="+this.getPosition());
 
//        	calculateDistances(this.getPosition());
 	
//        map.setCenter(this.getPosition());
//        map.fitBounds(this.getBounds());
//      }); 

	
 mockRefreshMap();//CALLED AT A REGULAR INTERVAL USER POSITION IS CHANGED
	
 google.maps.event.addListener(GeoMarker, 'geolocation_error', function(e) {
   alert('There was an error obtaining your position. Message: ' + e.message);
     });
		
     GeoMarker.setMap(map);
   }
 
//default style is yellow
var stylesYellow = [
              {
                stylers: [
                  { hue: "#FFFFCC" },
              { saturation: -20 }
            ]
          }
        ];

//green zone
var stylesGreen = [
              {
                stylers: [
                  { hue: "#66FF99" },
              { saturation: -20 }
            ]
          }
        ];

//red zone
var stylesRed= [
              {
                stylers: [
                  { hue: "#FF6666" },
                  { saturation: -20 }
                ]
              }
            ];

var stylesArray = [stylesGreen, stylesYellow, stylesRed];
	
var stylesList = {GREEN : stylesGreen, yellow: stylesYellow, RED : stylesRed}

// random styles for mock testing
function randomStyler()
{
	var zoneStyle = Math.floor((Math.random() * 3) );
	console.log('randomZone='+ zoneStyle);
	return 	 stylesArray[zoneStyle];
}

//random ETA for mock testing
function getMockETA()
{
	var pathToSchipholFromCentral = [ 
	                       		{
 			                       		lati:	"52.377934",
			                       		longi: "4.900920"
	                       		},
//	                       		{
//										lati:	"52.385173",
//			                       		longi: "4.844574"
//	                       		},								
	                       		{
			                       		lati:	"52.341855",
			                       		longi:  "4.837959"
								},
								{
			                       		lati: "52.330645",
			                       		longi: "4.791594"
								}
					  ];


mockLocation = pathToSchipholFromCentral[mockPathCoordinates];
	
if(mockPathCoordinates == (pathToSchipholFromCentral.length-1))
	{
		mockPathCoordinates = 0;
	} 
else
	{
		mockPathCoordinates += 1; 
	}
 
console.log('randomLocation mockPathCoordinates2='+mockPathCoordinates+' lati='+ pathToSchipholFromCentral[mockPathCoordinates].lati + " longi="+pathToSchipholFromCentral[mockPathCoordinates].longi);
 
return 	mockLocation;
	
}

var bounds = new google.maps.LatLngBounds();
var markersArray = [];

var destinationIcon = 'images/schiphol_icon_2_1.png';
var originIcon = 'images/user_on_move_icon_2_1.png';
   
var distanceMatrixCounter = 0;

function calculateDistances(origin) {
  var service = new google.maps.DistanceMatrixService();
 
  distanceMatrixCounter++;
  console.log("distanceMatrixCounter="+distanceMatrixCounter);
  
  var origin1 =  new google.maps.LatLng(origin.coords.latitude,origin.coords.longitude,true); //for users' CURRENT LOCATION
    
  //AJAY FIXED ORIGINS FOR MOCK 
  if(mockEnabled!= undefined && mockEnabled == 'on')
	{
	  	randomLocation = getMockETA() ;  
	  	randomLocationLat = randomLocation.lati;
	  	randomLocationLong = randomLocation.longi;
	  	
	  	origin1 =  new google.maps.LatLng(randomLocation.lati, randomLocation.longi );
	}

  service.getDistanceMatrix(
    {
     
      origins: [origin1],
      destinations: [destinationA],
      travelMode: google.maps.TravelMode.WALKING, //AJAY CHANGED FROM DRIVING TO WALKING 
      unitSystem: google.maps.UnitSystem.METRIC,
      avoidHighways: false,
      avoidTolls: false
    }, callback);
}

function callback(response, status) {
  if (status != google.maps.DistanceMatrixStatus.OK) {
    alert('Error was: ' + status);
  } else {
    var origins = response.originAddresses;
    var destinations = response.destinationAddresses;
    var outputDiv = document.getElementById('outputDiv');
//    outputDiv.innerHTML = '';
deleteOverlays();

for (var i = 0; i < origins.length; i++) {
  var results = response.rows[i].elements;
  addMarker(origins[i], false); //chaning to TRUE from FALSE show origin marker
  for (var j = 0; j < results.length; j++) {
    addMarker(destinations[j], true);

 var distanceKMString = results[j].distance.text;
 var originPostitionString = origins[i]; 
 var destinationPositionString = destinations[j];
 var etaHoursString = results[j].duration.text ;
 
 //PASS ETA and other details to OFFER ENGINE and get LIST OF OFFERS
	    
 var distanceMtrs = results[j].distance.value/1000; //VALUE DEVIDED BY 1K FOR kilometers
 var etaMinutes = results[j].duration.value/60; //ETA value divided 60 for MINUTES 
 var colorZone;  
 
 console.log("distanceMtrs="+ distanceMtrs + " etaMinutes = "+etaMinutes);
  
	$.ajax({
	    
		type: 'POST',
	     
	    url: '/smartmoves/users/548482096390c2cd08ef4e8b/offers',
	     
	    crossDomain: true, 

	    data:'{"userGPSLocationLat": "'+randomLocationLat+'","userGPSLocationLong" : "'+randomLocationLong+'", "airportGPSLocationLat": "'+destinationLat+'",  "airportGPSLocationLong": "'+destinationLong+'", "distance":'+distanceMtrs+',"mode": "Car","pnr": "'+pnrValue+'","flightNumber": "'+flightValue+'", "eta": '+etaMinutes+'}',
	    
	    dataType: 'json',
	    
	    contentType: 'application/json', 
	    
	    success: function(responseData, textStatus, jqXHR) 
	    	{
	        
	    	$('#smoveOfferList').remove('');
	    	
	    	$("#smove-offer-container").html('<div id="smoveOfferList" class="smove-offerlist owl-carousel"> </div>');
	    	
	    	console.log('$.ajax success responseData='+responseData + " responseData.zone="+responseData.zone);
 
	    	colorZone = responseData.zone;
	    	
	    	$("#sm_arrival_notification").removeClass('sm-RED-zone');
	    	$("#sm_arrival_notification").removeClass('sm-YELLOW-zone');
	    	$("#sm_arrival_notification").removeClass('sm-GREEN-zone');
	    	
	    	$("#sm_arrival_notification").addClass('sm-'+colorZone+'-zone');
	    	
	    	if(colorZone=='RED')
	    	{
	    		$("#sm_ETA_prefix").html('Oops, you are running too late. ETA is ');
	    	}
	    	else if(colorZone=='YELLOW')
	    	{
	    		$("#sm_ETA_prefix").html('You may want to rush! ETA is ');
	    	}
	    	else if(colorZone=='GREEN')
	    	{
	    		$("#sm_ETA_prefix").html('Keep the speed, you are arriving on time. ETA is ');
	    	}
	    	
	    	
	    	var offerCount = 0;
	    	var responseDataOffers = responseData.offers;
	    	
	    	if(responseDataOffers!=null && responseDataOffers!= undefined)
	    	{
	    		
		    	for(offerCount;offerCount<responseDataOffers.length;offerCount++)
		    	{
		    		var offerImage = responseDataOffers[offerCount].links[0].imageUrl;
		    		
		    		var offerTitle = responseDataOffers[offerCount].offerTitle;
		    		
		    		var offerDesc = responseDataOffers[offerCount].offerDesc;
		    		
		    		var offerPage = responseDataOffers[offerCount].links[0].rel;
	 	    		
		    		var offerLink = responseDataOffers[offerCount].links[0].resourceHref ;
		    		
		    		$('#smoveOfferList').append('<div href="sm_'+offerPage+'_page.html?pnrValue='+pnrValue+'&flightValue='+flightValue+'&offerLink='+offerLink+'" class="sm-page-content"><div class="smove-offer-type-icon"><img src="'+offerImage+'"></div><div class="sm-page-conent-label-major">'+offerTitle+'</div><div class="smove-offer-text">'+offerDesc+'</div></div>');
	
		    	} 
	    	
		        map.setOptions({styles: stylesList[ responseData.zone ]}); //set the style based on ZONE
		       		         
		        //set carousel
		         $("#smoveOfferList").owlCarousel({
			  
			    	      navigation : false, // Show next and prev buttons
			    	     // slideSpeed : 300,
			    	     // paginationSpeed : 400,
			    	      items : 3, //10 items above 1000px browser width
					      itemsDesktop : [1000,3], //5 items between 1000px and 901px
					      itemsDesktopSmall : [900,2], // betweem 900px and 601px
					      itemsTablet: [600,1], //2 items between 600 and 0
					      itemsMobile : false // itemsMobile disabled - inherit from itemsTablet option
					      
			    	 
			    	      // "singleItem:true" is a shortcut for:
			    	      // items : 1, 
			    	      // itemsDesktop : false,
			    	      // itemsDesktopSmall : false,
			    	      // itemsTablet: false,
			    	      // itemsMobile : false
			    	 
			    	  }); 
	 
		         $("#sm_ETA_time").html(etaHoursString); 
		         
			     outputDiv.innerHTML += "FROM: "+originPostitionString + '<BR/> TO: ' + destinationPositionString
			     + '<BR/> DISTANCE: ' + distanceKMString + ' <BR/> ETA: '
			     + etaHoursString + '<br> Printed on:' + new Date() +'<br> Zone: '+colorZone+'<br>---------------- <br>';
	
			   //event handling on various offer links
			 	$(".sm-page-content").click(function()
			 	{
			 		//construct url for respective offer page
			 				 			 		
			 	 	window.location.href = $(this).attr('href'); 
			  		
			 	});
		 	

		 		if(FB!=null && FB!=undefined)
		 		{
		 			
				 	//send FB FACEBOOK message when user has started from HOME
				 	if(colorZone == 'RED')
					{
		
				 		FB.ui({
				 			  method: 'feed',
				 			  link: 'https://www.facebook.com/schiphol', 
				 			  caption: 'Starting from Home towards Schipol for my flight No: '+flightValue,
				 			}, function(response){});
					}
		
				 	//send FB FACEBOOK message when user has reached airport
				 	if(colorZone == 'GREEN')
					{
				 		FB.ui({
				 			  method: 'feed',
				 			  link: 'https://www.facebook.com/schiphol', 
				 			  caption: 'Arriving at Schipol for my flight No: '+flightValue,
				 			}, function(response){});
					}
		 		}	
	    	}


	    },
	    error: function (responseData, textStatus, errorThrown) {
	        alert('$.ajax POST failed.');
		    } 
		});
		
 
      } 
    } 
  }
}

$("#showLogsBtn").click(function (){
	
	//hide this button and show logs
	$(this).hide();
	
	$("#outputDiv").show();
	
});

function addMarker(location, isDestination) {
  var icon;
  if (isDestination) {
    icon = destinationIcon;
   } 
 	else 
  {
    icon = originIcon; //ICON FOR ORIGIN
  }
   
  geocoder.geocode({'address': location}, function(results, status) {
  
if (status == google.maps.GeocoderStatus.OK) {

bounds.extend(results[0].geometry.location);
  map.fitBounds(bounds);
  
  var marker = new google.maps.Marker({
    map: map,
    position: results[0].geometry.location,
    icon: icon
  });
  markersArray.push(marker);
} else {
  alert('Geocode was not successful for the following reason: '
        + status);
    }
  });
}

function deleteOverlays() {
  for (var i = 0; i < markersArray.length; i++) {
    markersArray[i].setMap(null);
  }
  markersArray = [];
}

//

 //load the map
  google.maps.event.addDomListener(window, 'load', initialize);
  
  if(!navigator.geolocation) {
    alert('Your browser does not support geolocation');
  }
  
  
  function mockRefreshMap()
  {
 	//get user's current location
 	
 	console.log("mockRefreshMap()");
     
 	if (navigator.geolocation) {
         navigator.geolocation.getCurrentPosition(calculateDistances, function(error) {
        	 console.log("time out error in mockRefreshMap()" + error.code);          
         },{enableHighAccuracy:true,  timeout:numberOfSecondsToRefreshMap*1000, maximumAge:numberOfSecondsToRefreshMap*1000 });
     } 
     else  
     {
    	 console.log("error in mockRefreshMap()");
     }
  	
//      	     map.setCenter(this.getPosition());
//      	     map.fitBounds(this.getBounds());
      }
 
      //set refresh interval to reload user's position
     setInterval(mockRefreshMap,numberOfSecondsToRefreshMap*1000);	  
});