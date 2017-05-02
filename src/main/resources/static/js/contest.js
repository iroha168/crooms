$(function(){
	writeSelections();
}

function writeSelections(){
	cookieData = parseCookie();
	empty();
	for(var i = 0; i < cookieData.name.length; i++){
		$(".selected ul").append("<li class="+cookieData.name[i]+">"+cookieData.name[i]+": "+ cookieData.title[i]+"</li>");
	}
}

function empty(){
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
