var cookieData;
$(function(){
	if(cookieData != null){
		writeSelections();
		recheck();
	}
	$(".cb").on("change", function(){
		var name = $(this).attr("name").split(",");
		ckClick(name[0], name[1], $(this).prop("checked"));
	});
	$(".delete_all").on("click", function(){
		deleteClick();
	});
	$(".save").on("click",function(){
		save();
	});
});

function save(){
	document.cookie = "problems="+JSON.stringify(parseCookie()).replace(/[{}\[\]"]/g,"").replace(/[, ]/g,"_")+";path=/";
}

function recheck(){
	for(var i = 0; i < cookieData.name.length; i++){
		$("[name^='"+cookieData.name[i]+"']").prop('checked',true);
	}
}

function deleteClick(){
	expireCookieOfProblem();
	empty();
}

function ckClick(name, title,checked){
	if(checked){
		check(name, title);
	}else{
		unchecked(name, title);		
	}
}

function expireCookieOfProblem(){
	document.cookie = "problems=; max-age=0";
}

function unchecked(name, title){
	for(var i = 0; i < cookieData.name.length; i++){
		if(cookieData.name[i] == name){
			cookieData.name.splice(i,1);
			cookieData.title.splice(i,1);
			break;
		}
	}
	expireCookieOfProblem();
	document.cookie = 'problems='+JSON.stringify(cookieData)+';path=/';
	$(".selected ul ."+name).remove();
}

function check(name, title){
	var data = parseCookie();
	data.name.push(name);
	data.title.push(title);
	document.cookie = 'problems='+JSON.stringify(data)+';path=/';
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