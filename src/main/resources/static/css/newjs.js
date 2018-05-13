var number;
var time;
window.onload = function(){
  var btn1 = document.getElementsByName("shake").item(0);
  var btn2 = document.getElementsByName("open").item(0);
  btn1.onclick = shakeWindow;
  btn2.onclick = openWindow;
}
window.addEventListener("load",openWindow,0);

function openWindow(){
  var x = screen.availWidth - 300;
  var y = screen.availHeight - 200;
  var style = "width = 300, height = 200, left = " + x + ", top =" + y;
  //window.open("web/info.html","info",style);; 取消弹出页面
  
}
  function calendar(){
  var td = document.getElementsByTagName("td");
  var date = new Date();
  var year = date.getFullYear();
  var month =date.getMonth()+1;
  var curdate = date.getDate();
  var monthlength = new Date(year,month,0).getDate();
  var firstday = new Date(year,month-1,1).getDay();
  var first_td = 8;
  var start = first_td + firstday;
  td.item(0).innerHTML = year + "年" + month + "月";
  for(var i = 1; i<= monthlength; i++){
    td.item(start + i - 1).innerHTML = i;
    if(i == curdate){
      td.item(start + i - 1).className = "curdate";
      }
    if(i < curdate){
      td.item(start + i - 1).className= "pastdate";
    }
  }
  var table = document.getElementById("calendar");
  if(td.item(43).innerHTML == "&nbsp;"){
    table.deleteRow(7);
  }
  if(td.item(36).innerHTML == "&nbsp;"){
    table.deleteRow(6);
  }
}

function showtime(){
  var date = new Date();
  alert(date.toLocaleDateString());
}
  window.addEventListener("load",calendar,0);