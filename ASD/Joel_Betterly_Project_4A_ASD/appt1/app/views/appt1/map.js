function (doc){
	if (doc._id.substr(0,4) === "appt") {
		emit(doc._id,{
			"toa": doc.toa,
			"loi": doc.loi,
			"notes": doc.notes
		});
	}
};