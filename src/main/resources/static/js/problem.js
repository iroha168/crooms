$(function(){
	writeSelections();
	$(".cb").on("change", function(){
		var name = $(this).attr("name").split(",");
		ckClick(name[0], name[1], $(this).prop("checked"));
	});
	$(".delete_all").on("click", function(){
		deleteClick();
	});
});

function deleteClick(){
	empty();
}

function ckClick(name, title,checked){
	if(checked){
		check(name, title);
	}else{
		unchecked(name, title);		
	}
}

function unchecked(name, title){
	$(".selected ul ."+name).remove();
}

function check(name, title){
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
	empty();
	for(var i = 0; i < len; i++){
		$(".selected ul").append("<li class="+data.name[i]+">"+data.name[i]+": "+ data.title[i]+"</li>");
	}
}

function empty(){
	document.cookie = "problems=; max-age=0";
	$(".selected ul").empty();
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
    cookieValue = cookieValue == "" ? getEmptyJsonObject() : JSON.parse(cookieValue);
    return cookieValue;
}

function getEmptyJsonObject(name, title){
	var obj = new Object();
	obj.name = [];
	obj.title  = [];		
	return obj;
}

function getJsonObject(name, title){
	var obj = new Object();
	obj.name = [name];
	obj.title  = [title];
	return obj;
}