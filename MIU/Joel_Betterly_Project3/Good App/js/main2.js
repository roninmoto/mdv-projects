var parseApptForm = function(data){
    console.log(data);
};

$(document).ready(function() {
    
    var rbform = $('#addapptform');
        addappterrorslink = $('#addappterrorslink')
    ;    
    
    rbform.validate({
        invalidHandler: function(form, validator){
            addappterrorslink.click();
            for(var key in validator.submitted){
                var label = $('label[for^="'+ key +'"]').not('[generated]');
                label.closest('fieldset').find('ui-controlgroup-label')
            };
            },
//        submitHandler: function(){
//        var data = $(".addapptform").serializeArray();
//        localStorage.setItem("formdata", data);
//        }           
        submitHandler: function(){
            var data = rbform.serializeArray();
            parseApptForm(data);
        }
    });    
});
