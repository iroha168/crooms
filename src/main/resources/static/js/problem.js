$(function(){
	$(".cb").on("change", function(){
		var name = $(this).attr("name").split(",");
		ckClick(name[0], name[1]);
	});
});

function ckClick(name, title){
	var content = [name+ ": "+ title];
	   var obj = new Object();
	   obj.name = [name];
	   obj.title  = [title];
	   var jsonString= JSON.stringify(obj);	
	   writeSelections(jsonString);
}

function writeSelections(selections){
	var data = JSON.parse(selections);
	len = data.name.length;
	for(var i = 0; i < len; i++){
		$(".selected ul").append("<li>"+data.name[i]+": "+ data.title[i]+"</li>");
	}
}

