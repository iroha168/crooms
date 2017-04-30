$(function(){
	writeSelections();
	$(".cb").on("change", function(){
		var name = $(this).attr("name").split(",");
		ckClick(name[0], name[1]);
	});
});

function ckClick(name, title){
	var content = [name+ ": "+ title];
	var obj = getJsonObject(name, title);
	var jsonString= JSON.stringify(obj);	
	var cookie = document.cookie;
	var data = parseCookie();
	data.name.push(name);
	data.title.push(title);
	document.cookie = 'problems='+JSON.stringify(data);
	writeSelections();
}

function writeSelections(){
	var data = parseCookie();
	len = data.name.length;
	$(".selected ul").empty();
	for(var i = 0; i < len; i++){
		$(".selected ul").append("<li>"+data.name[i]+": "+ data.title[i]+"</li>");
	}
}

function parseCookie(){
    var cookie = document.cookie;
    var cookieItem = cookie.split(";");
    var cookieValue = "";
    for (i = 0; i < cookieItem.length; i++) {
      var elem = cookieItem[i].split("=");
      if (elem[0].trim() == "problems") {
        cookieValue = unescape(elem[1]);
      } else {
        continue;
      }
    }
    cookieValue = cookieValue == "" ? getJsonObject("","") : JSON.parse(cookieValue);
    return cookieValue;
}

function getJsonObject(name, title){
	var obj = new Object();
	if(name !=""){
		obj.name = [name];
		obj.title  = [title];
	}else{
		obj.name = [];
		obj.title  = [];		
	}
	return obj;
}