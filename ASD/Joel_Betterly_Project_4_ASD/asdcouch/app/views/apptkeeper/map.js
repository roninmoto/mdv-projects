function (doc){
	if (doc._id.substr(0,4) === "appt") {
		emit(doc._id,{
			"toa": doc.toa,
			"loi": doc.loi,
			"name": doc.name,
			"date": doc.date,
			"time": doc.time,
			"checkbox": doc.checkbox,
			"notes": doc.notes
		});
	}
};