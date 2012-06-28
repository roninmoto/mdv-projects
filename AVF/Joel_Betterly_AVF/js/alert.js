function onBodyLoad()
	{		
		document.addEventListener("deviceready", onDeviceReady, false);
	}

	function onDeviceReady()
	{
		//phoneGapReady.innerHTML = ("")

	}
	
		function back()
	{
		window.location="revised.html"
	}
	

    function alertDismissed() {

    }
    
    function showAlert() {
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
    
    function showConfirm() {
        navigator.notification.confirm(
                                       'You are Confirmed!',
                                       onConfirm, 
                                       'Confirm',
                                       'Restart, Exit' 
                                       );
    }