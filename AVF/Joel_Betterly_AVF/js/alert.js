function Load()
	{		
		document.addEventListener("deviceready", onDeviceReady, false);
	}

	function onDeviceReady()
	{
		phoneGapReady.innerHTML = ("")

	}
	
		function back()
	{
		window.location="revised.html"
	}
	

    function alertDismissed() {

    }
    
    function alert() {
        navigator.notification.alert(
                                     'You have an Alert!', 
                                     alertDismissed,
                                     'Alert', 
                                     'Okay'
                                     );
    }
    
    function onConfirm(button) {
        alert('You selected button ' + button);
    }
    
    function confirm() {
        navigator.notification.confirm(
                                       'You are Confirmed!',
                                       onConfirm, 
                                       'Confirm',
                                       'Exit' 
                                       );
    }