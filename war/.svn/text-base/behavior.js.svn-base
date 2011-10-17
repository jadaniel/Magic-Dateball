jQuery(document).ready(function(){
		
	var textObjects = jQuery(":text");
	var text_field_defaults = new Array();
	
	jQuery.each(textObjects, function (index, ele) {
		text_field_defaults[ele.id] = ele.value;	
	});
	

	jQuery(":text").focusin(function () {
		//focus in handler
		
		if (this.value==text_field_defaults[this.id]) {
			this.value='';
		} 
		
	});
	
	jQuery(":text").focusout(function () {
		if (this.value=='') {
			this.value=text_field_defaults[this.id];
		} 
		
	});
	
});	