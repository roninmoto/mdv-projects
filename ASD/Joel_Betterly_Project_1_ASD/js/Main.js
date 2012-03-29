// Save form data to Local Storage

$('#submit').live('click', function saveData(id) {
    var dt = new Date();
    var key = (dt.getTime());
    var toa = $("#toa").val();
    var loi = $("#loi").val();
    var name = $("#name").val();
    var date = $("#date").val();
    var time = $("#time").val();
    var checkbox;
    if ($('#checkbox-1').is(":checked")){
	checkbox = "Available for Appointment"
	}else{
	checkbox = "Not Available for Appointment"
	}
    var notes = $("#notes").val();
    var item = [toa, loi, name, date, time, checkbox, notes];

    localStorage.setItem(key, item);
    location.reload();
    alert("The form has been saved to Local Storage.");
});	

//Turns on/off the form so it can display the data from Local Storage
function toggleControls(n) {
    switch (n) {
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
$('#showData').live('click', function getData() {
	toggleControls("on"); //turning off form to display data
    var getData = $('#data')[0];
    for (var i = 0, j = localStorage.length; i < j; i++) {
        var key = localStorage.key(i);
        var value = localStorage.getItem(key);
        value = value.split(',');
//adding items so list can be built for displaying like DOM
        $('<div>').attr({'class': 'listDiv'}).appendTo('#data');
        $('<img>').attr({'src': 'images/' + value[0] + '.png'}).appendTo('.listDiv');
        $('<p>').html('Type of Appointment: ' + value[0]).appendTo('.listDiv');
        $('<p>').html('Level of Importance: ' + value[1]).appendTo('.listDiv');
        $('<p>').html('Name of Person: ' + value[2]).appendTo('.listDiv');
        $('<p>').html('Date of Meeting: ' + value[3]).appendTo('.listDiv');
        $('<p>').html('Time of Meeting: ' + value[4]).appendTo('.listDiv');
        $('<p>').html('Appointment Availability: ' + value[5]).appendTo('.listDiv');        
        $('<p>').html('Notes: ' + value[6]).appendTo('.listDiv');
        $('<p>').html($('<a>').attr({'href': '#','onclick': 'deleteItem(' + key + ');'}).html('Delete Appointment')).appendTo('.listDiv');
        $('<p>').html($('<a>').attr({'href': '#','onclick': 'editItem(' + key + ');'}).html('Edit Appointment')).appendTo('.listDiv');
        $('<br>').html('').appendTo('.listDiv');
    }
});

// Edit data from Local Storage
function editItem(id) {
    var itemId = id;
	var value = localStorage.getItem(itemId);
	value = value.split(',');
	toggleControls("off"); //Have to turn form on so you can edit the data
    var toa = value[0];
    var loi = value[1];
    var name = value[2];
    var date = value[3];
    var time = value[4];
    var checkbox;
    var notes = value[6];

    $('#toa').val(toa);
    $('#loi').val(loi);
    $('#name').val(name);
    $('#date').val(date);
    $('#time').val(time);    
    if ($('#checkbox-1').is(":checked")){
	checkbox = "Yes"
	}else{
	checkbox = "No"
	}
    $('#notes').val(notes);

    // Show the edit button, hide the submit button and the appt list
    var edit = $('#editButton').css('display', 'block');
    var submit = $('#addSubmit').css('display', 'none');
    var apptList = $('#data').css('display', 'none');

    // Changes made to Local Storage when you click the edit button.
    $('#editAppt').live('click', function clickEdit() {
        var toa = $('#toa').val();
        var loi = $('#loi').val();
        var name = $('#name').val();
        var date = $('#date').val();
        var time = $('#time').val();        
        var checkbox;
        if ($('#checkbox-1').is(":checked")){
		checkbox = "Yes"
		}else{
		checkbox = "No"
		}

        var notes = $('#notes').val();
        var item = [toa, loi, name, date, time, checkbox, notes];
        localStorage.setItem(itemId, item);           
        location.reload();
        alert("Your Appointment has been changed.");
        
    });
}
// Removes item from Local Storage with confirm.
function deleteItem(id) {
    var ask = confirm("Your appointment will be erased, this cannot be undone.  Are you sure?");
    if (ask) {
        localStorage.removeItem(id);
        window.location.reload();
    } else {
        alert("Your appointment was NOT removed.");
    }
}
