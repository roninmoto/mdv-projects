function (doc){
	if (doc._id.substr(0,4) === "appt") {
		emit(doc._id,{
			"name": doc.name,
			"toa": doc.toa,
			"loi": doc.loi,
			"notes": doc.notes
		});
	}
};