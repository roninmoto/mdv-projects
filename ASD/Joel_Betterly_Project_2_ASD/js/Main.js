//Joel Betterly
//Project 2
//0412 ASD

// Save form data to Local Storage
//Create function that stores form into Local Storage
//When Submit button is clicked.
$('#submit').on('click', function saveLS(id) {
    //Declare all variables from form and setup unique ID by generating a key.    
    var dt = new Date();
    var key =  (dt.getTime());
    var toa =  $("#toa").val();
    var loi =  $("#loi").val();
    var name = $("#name").val();
    var date = $("#date").val();
    var time = $("#time").val();
    //For the checkbox, we have to create a if/else statement since the value cannot be recorded
    var checkbox;
    if ($('#checkbox-1').is(":checked")){
	checkbox = "Available for Appointment"
	}else{
	checkbox = "Not Available for Appointment"
	}
    var notes = $("#notes").val();
    //Create a variable so we can load the data into Local Storage as a string
    var appt = [toa, loi, name, date, time, checkbox, notes];
    //Adding data to Local Storage giving a key and string
    localStorage.setItem(key, appt);
    //Reload Page so a new form is generated to add more data and give alert that data was added successfully
    location.reload();
    alert("The form has been saved to memory.");
});	

//Turns on/off the form so it can display the data from Local Storage
var toggleCtrl = function(t) {
    
    switch (t) {
    case "on":
        $('#addapptform').css('display', 'none');
        break;
    case "off":
        $('#addapptform').css('display', 'block');
        break;
    default:
        return false;
    }
}

// Pulls data from Local Storage
$('#showData').on('click', function getData() {
	toggleCtrl("on"); //turning off form to display data
    var getData = $('#data')[0];
    
    //Create for loop to pull key and string and break out by making it comment delimited.
    for (var i = 0, j = localStorage.length; i < j; i++) {
        var key = localStorage.key(i);
        var value = localStorage.getItem(key);
        value = value.split(',');
        
        //adding items so list can be built for displaying like DOM
        //You have to add a <div>tag in HTML form with ID of data to import data into like the DOM.
        //Place the tag after your </form>tag but before your </body>
        $('<div>').attr({'class': 'apptDiv'}).appendTo('#data');
        //Have to use concatentation to pull image.  Value 0 is the same as image name as is my appt type (personal business other)
        $('<img>').attr({'src': 'images/' + value[0] + '.png'}).appendTo('.apptDiv');
        //so this would give me the result of <img src="images/Business.png"> in the div tag when it is built
        $('<p>').html('Type of Appointment: ' + value[0]).appendTo('.apptDiv');
        $('<p>').html('Level of Importance: ' + value[1]).appendTo('.apptDiv');
        $('<p>').html('Name of Person: ' + value[2]).appendTo('.apptDiv');
        $('<p>').html('Date of Meeting: ' + value[3]).appendTo('.apptDiv');
        $('<p>').html('Time of Meeting: ' + value[4]).appendTo('.apptDiv');
        $('<p>').html('Appointment Availability: ' + value[5]).appendTo('.apptDiv');        
        $('<p>').html('Notes: ' + value[6]).appendTo('.apptDiv');
        
        //create clickable links so we can edit or delete the data and add BR at bottom for spacing of items(not needed, but looks nice)
        $('<p>').html($('<a>').attr({'href': '#','onclick': 'deleteAppt(' + key + ');'}).html('Delete Appointment')).appendTo('.apptDiv');
        $('<p>').html($('<a>').attr({'href': '#','onclick': 'editAppt(' + key + ');'}).html('Edit Appointment')).appendTo('.apptDiv');
        $('<br>').html('').appendTo('.apptDiv');
    }
});

// Edit data from Local Storage
function editAppt(id) {
    var apptId = id;
	var value = localStorage.getItem(apptId);
	value = value.split(',');
        //Have to turn form on so you can edit the data
	toggleCtrl("off");
    //declare varibales from form    
    var toa = value[0];
    var loi = value[1];
    var name = value[2];
    var date = value[3];
    var time = value[4];
    var checkbox;
    var notes = value[6];

    //turn variables into values
    $('#toa').val(toa);
    $('#loi').val(loi);
    $('#name').val(name);
    $('#date').val(date);
    $('#time').val(time);    
    if ($('#checkbox-1').is(":checked")){
	checkbox = "Available for Appointment"
	}else{
	checkbox = "Not Available for Appointment"
	}
    $('#notes').val(notes);

    // Show the edit button, hide the submit button and the appt list
    var edit = $('#editButton').css('display', 'block');
    var submit = $('#addSubmit').css('display', 'none');
    var apptList = $('#data').css('display', 'none');

    // Changes made to Local Storage when you click the edit button.
    $('#editAppt').on('click', function editAppt() {
        var toa =  $('#toa').val();
        var loi =  $('#loi').val();
        var name = $('#name').val();
        var date = $('#date').val();
        var time = $('#time').val();        
        var checkbox;
        if ($('#checkbox-1').is(":checked")){
		checkbox = "Available for Appointment"
		}else{
		checkbox = "Not Available for Appointment"
		}

        var notes = $('#notes').val();
        var appt = [toa, loi, name, date, time, checkbox, notes];
        //record changes and update Local Storage
        localStorage.setItem(apptId, appt);
        //reload form page for new submission and give alert that update was sucessful.
        location.reload();
        alert("Your Appointment has been changed.");
        
    });
}
// Removes item from Local Storage with confirm.
function deleteAppt(id) {
    //declare variable to find out if you want to delete appt
    var question = confirm("Your appointment will be erased, this cannot be undone.  Are you sure?");
    //if/else statement to remove or cancel
    if (question) {
        localStorage.removeItem(id);
        window.location.reload();
    } else {
        alert("Your appointment was NOT removed.");
    }
}

// Deletes all data from Local Storage
//To use this function you will need to add a function call from your HTML, something like this:
//<li><a href="#" onclick="cls(); location.reload();" id="cls">Clear Local Storage</a></li>
//I placed mine in a footer navigation so that it was always available to the user
function cls() {
    if (localStorage.length === 0) {
        alert("Sorry, no data in memory.");
    } else {
        var question = confirm ("This action cannot be undone, this will erase all of your appointments.");
            if (question){
                localStorage.clear();
                alert("All appointments have been erased from memory.");
                window.location.reload();
                return false;  
            } else {
               alert("The action was canceled. Your appointments are still held in memory."); 
            }
    }
}

//Import JSON data to index.html file using id of "outsideAppt"
//set up function for the button
//this was done exactly as shown in video 5 (ajax-5-jquery) of the Ajax videos.
$("#json").on("click", function(){
    //have to clear data in case user clicks different button
    $('#outsideAppt').empty();
    
    //Add ajax call for json data
    $.ajax({
	url: 'js/data.json',
	type: 'GET',
	dataType: 'json',
	success: function(feedback){
	    //making loop through imported json data. "appointments" is the header of incoming json data file
	    for (var i=0, j=feedback.appointments.length; i<j; i++){
		var jsonData = feedback.appointments[i];
		// create one long concatention for each field that needs to be imported
		$('<div data-role="content">' + '<ul data-role="listview">' + '<li>' +
		  '<img src="images/' + jsonData.toa + '.png" />' +
		  '<p>Type of Appointment: ' + jsonData.toa + '</p>' +
		  '<p>Level of Importance: ' + jsonData.loi + '</p>' +
		  '<p>Name of Person: ' + jsonData.name + '</p>' +
		  '<p>Date of Meeting: ' + jsonData.date + '</p>' +
		  '<p>Time of Meeting: ' + jsonData.time + '</p>' +
		  '<p>Availbility for Meeting: ' + jsonData.checkbox + '</p>' +
		  '<p>Notes: ' + jsonData.notes + '</p>' +
		  '</li>' + '<br>' + '</ul>' + '</div>').appendTo('#outsideAppt');
		console.log(feedback);
	    }
	}
    });
    return false;
    
});

//Adding XML import data using xml button on my index.html, going to be dumped in the <div id="outsideAppt">
//This is the same as video 5(ajax-5-jquery) but you have to declare variables for each field as text.
$('#xml').on("click", function(){
   //clear any data in the tag
   $('#outsideAppt').empty();
    //add ajax just like json data
       $.ajax({
	url: 'js/data.xml',
	type: 'GET',
	dataType: 'xml',
	success: function(fdbk){
	    //create function using find to fetch data from xml file looking for "appts", then using .each to loop through
	    //and using this for each field to find.
	    $(fdbk).find("appt").each(function(){
		//have to declare variables for each field, then insert into the DOM with <li> tags
		var toa = $(this).find('toa').text();
		var loi = $(this).find('loi').text();
		var name = $(this).find('name').text();
		var date = $(this).find('date').text();
		var time = $(this).find('time').text();
		var checkbox = $(this).find('checkbox').text();
		var notes = $(this).find('notes').text();
		//create the DOM insertion just like json data
		$('<div data-role="content">' + '<ul data-role="listview">' + '<li>' +
		  '<img src="images/' + toa + '.png" />' +
		  '<p>Type of Appointment: ' + toa + '</p>' +
		  '<p>Level of Importance: ' + loi + '</p>' +
		  '<p>Name of Person: ' + name + '</p>' +
		  '<p>Date of Meeting: ' + date + '</p>' +
		  '<p>Time of Meeting: ' + time + '</p>' +
		  '<p>Availbility for Meeting: ' + checkbox + '</p>' +
		  '<p>Notes: ' + notes + '</p>' +
		  '</li>' + '<br>' + '</ul>' + '</div>').appendTo('#outsideAppt');
		console.log(fdbk);
	    })
	}
       })   
});

//Adding csv data using csv button from index.html, csv to be dumped in the <div id="outsideAppt">
$('#csv').on("click", function(){
   //clear any data in the tag
   $('#outsideAppt').empty();
   //add ajax call just like json and xml
   $.ajax({
    url: 'js/data.csv',
    type: 'GET',
    dataType: 'text',
    success: function(appt){
	var text = [];
	//using a regex to split the csv data.  Found this expression on a regex site
        var csvData = appt.split(/[\r\n]+/);
	//split the code with my delimiter of '|' choose the pipe to reduce errors in code.
    	var lineOne = csvData[0].split('|');
	
	    //create loop to cycle through csv data
	    //really wanted to use .each but couldn't figure it out and no staff to help me.
	    for (var i=1; i<csvData.length; i++) {
		var data = csvData[i].split('|');
		if (data.length == lineOne.length) {
		    var appointments = []; 
		    for (var j=0; j<lineOne.length; j++) {
		    appointments.push(data[j]); 
		    }
		    text.push(appointments); 
		}
	    }
	    for (var k=0; k<text.length; k++){
		var appts = text[k];
		//using same dom loader as json and xml
		$('<div data-role="content">' + '<ul data-role="listview">' + '<li>' +
		  '<img src="images/' + appts[0] + '.png" />' +
		  '<p>Type of Appointment: ' + appts[0] + '</p>' +
		  '<p>Level of Importance: ' + appts[1] + '</p>' +
		  '<p>Name of Person: ' + appts[2] + '</p>' +
		  '<p>Date of Meeting: ' + appts[3] + '</p>' +
		  '<p>Time of Meeting: ' + appts[4] + '</p>' +
		  '<p>Availbility for Meeting: ' + appts[5] + '</p>' +
		  '<p>Notes: ' + appts[6] + '</p>' +
		  '</li>' + '<br>' + '</ul>' + '</div>').appendTo('#outsideAppt');
	    }
    },
   });
	
});
