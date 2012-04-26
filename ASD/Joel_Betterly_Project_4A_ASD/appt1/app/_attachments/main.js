$(document).ready(function(){

	var $database = $.couch.db('appt1');
	
	$('#submit').on('click', function(x){
		x.preventDefault();
		var savecdb = {};
		savecdb._id = "appt:"+ $('#name').val();
		savecdb.name = $('#name').val();
		savecdb.toa = $('#toa').val();
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
					var name = appt.value.name;
					var toa = appt.value.toa;
					var loi = appt.value.loi;
					var notes = appt.value.notes;
					$(
						'<div class="Appointments">' +	
							'<ul data-role="listview">' +
							    '<li>Name of Appointment: '+ name +'</li>' +
								'<li>Type of Appointment: '+ toa +'</li>' +
								'<li>Level of Importantance: '+ loi +'</li>' +
								'<li>Notes: '+ notes +'</li>' +
								'<a href="#" id ="'+ id +'" >Edit Appointment</a>' +
								'<br />' +
								'<a href="#" id ="'+ id +'"> Delete Appointment</a>' +
							'</ul>' +
						'</div>' 
					)
					.appendTo('div#DOMin');
				});
			}
		});
	});	

	$('div#DOMin').click(function(event){
		var id = "appt:" + appt.value.name;
	$database.openDoc(id, {
		
		success: function(doc){
			var name = doc.name;
			var toa = doc.toa;
			var loi = doc.loi;
			var notes = doc.notes;
			$database.removeDoc(doc);
			$.mobile.changePage('#addItemsForm');
			$('#name').val(name);
			$('#toa').val(toa);
			$('#loi').val(loi);
			$('#notes').val(notes);

		}
	})	
	});

	
	
}); //Closing bracket for document ready