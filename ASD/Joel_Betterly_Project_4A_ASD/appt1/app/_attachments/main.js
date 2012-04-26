$(document).ready(function(){

	var $database = $.couch.db('appt1');
	
	$('#submit').on('click', function(x){
		x.preventDefault();
		var savecdb = {};
		var dt = new Date();
		var key = (dt.getTime());
		savecdb._id = "appt:"+ key + $('#toa').val();
		savecdb.toa = $("#toa").val();
		savecdb.loi = $('#loi').val();
		savecdb.notes = $('#notes').val();
		$database.saveDoc(savecdb, {
			success : function() {
				$.mobile.changePage('#home');
				alert("Appointment is Saved");
			},
		});
	});

	$.ajaxSetup ({
		cache : false
	});	
	//Pulls data from couch using JSON data.	
	$('#viewappt').on('click', function(){
		$('div#DOMin').empty();
		$.ajax({
			url: "_view/appt1",
			dataType: "json",
			beforeSend: function(){
				$.mobile.changePage('#DOMinsert')
			},
			success : function(data){
				$.each(data.rows, function(index, appt){
					var id = "appt:" + appt.value.name;
					var toa = appt.value.toa;
					var loi = appt.value.loi;
					var notes = appt.value.notes;
					$(
						'<div class="Appointments">' +	
							'<ul data-role="listview">' +
								'<li>Type of Appointment: '+ toa +'</li>' +
								'<li>Level of Importantance: '+ loi +'</li>' +
								'<li>Notes: '+ notes +'</li>' +
								'<a href="#" class="edit" id ="'+ id +'" >Edit Appointment</a>' +
								'<br />' +
								'<a href="#" class="delete" id ="'+ id +'"> Delete Appointment</a>' +
							'</ul>' +
						'</div>' 
					)
					.appendTo('div#DOMin');
				});
			}
		});
	});	
	

}); //Closing bracket for document ready