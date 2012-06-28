
	function Load()
	{		
		document.addEventListener("deviceready", onDeviceReady, false);
	}

	function back()
	{
		window.location="revised.html"
	}

	function onDeviceReady()
	{
		 phoneGapReady.innerHTML = ("")
	}
		var x=document.getElementById("gmap");

          function getLocation()
          {
              if (navigator.geolocation)
              {
                  navigator.geolocation.getCurrentPosition(showPosition,showError);
              }
              else{x.innerHTML="Your browser does not support this feature.";}
          }
          
          function showPosition(position)
          {
              lat=position.coords.latitude;
              lon=position.coords.longitude;
              latlon=new google.maps.LatLng(lat, lon)
              mapholder=document.getElementById('mapholder')
              mapholder.style.height='250px';
              mapholder.style.width='100%';
              
              var myOptions={
                  center:latlon,zoom:14,
                  mapTypeId:google.maps.MapTypeId.ROADMAP,
                  mapTypeControl:false,
                  navigationControlOptions:{style:google.maps.NavigationControlStyle.SMALL}
              };
              var map=new google.maps.Map(document.getElementById("mapholder"),myOptions);
              
              // this will give you the little marker on the map indicating your position
              var marker=new google.maps.Marker({position:latlon,map:map,title:"You are here!"});
          }
          
          
          // a function in case there is an error like loading from chrome
          function showError(error)
          {
              switch(error.code) 
              {
                  case error.PERMISSION_DENIED:
                  x.innerHTML="User denied the request for Geolocation."
                  break;
                  case error.POSITION_UNAVAILABLE:
                  x.innerHTML="Location information is unavailable."
                  break;
                  case error.TIMEOUT:
                  x.innerHTML="The request to get user location timed out."
                  break;
                  case error.UNKNOWN_ERROR:
                  x.innerHTML="An unknown error occurred."
                  break;
              }
          }

