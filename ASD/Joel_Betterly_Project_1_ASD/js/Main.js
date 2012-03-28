$(document).ready(function() {

// Save form data to local storage

$('#submit').live('click', function saveData(id) {
    var d = new Date();
    var key = (d.getTime());
    var toa = $("#toa").val();
    var loi = $("#loi").val();
    var name = $("#name").val();
    var date = $("#date").val();
    var time = $("#time").val();
    var checkbox;
    if ($('#checkbox-1').is(":checked")){
	checkbox = "Available for Appt"
	}else{
	checkbox = "Not Available for Appt"
	}
    var notes = $("#notes").val();
    var item = [
    toa, loi, name, date, time, checkbox, notes];

    localStorage.setItem(key, item);
  //  location.reload();
    alert("Form Saved!");
});	


//function toggleControls(n) {
//    switch (n) {
//    case "on":
//        $('#addapptform').css('display', 'none');
//        $('#clearLink').css('display', 'inline');
//        break;
//    case "off":
//        $('#addapptform').css('display', 'block');
//        $('#clearLink').css('display', 'inline');
//        $('#list').css('display', 'none');
//        break;
//    default:
//        return false;
//    }
//}

});