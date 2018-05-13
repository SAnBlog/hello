  <!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="content-type" content="散,散的个人博客,个人博客散,散-个人博客,好看的个人博客">
<link rel="SHORTCUT ICON" href="/img/cat.ico"/>
<title>${user.name}</title>
<link href="/css/bootstrap.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="/css/style.css" id="style_target">
<script src="/css/jquery-2.1.0.min.js"></script>
<script src="/css/bootstrap.min.js"></script>
<script src="/css/newjs.js"></script>
<style type="text/css">

	.addbold{
		font-style: bold;
		align:center;
	}
 
  table {
  border-collapse: collapse;
}
td {
  width: 30px;
  line-height: 17px;
  text-align: center;
  border: 1px solid #ccc;
}
.pastdate {
  background-color: #F2F2F2;
}
.curdate {
  font-weight: bold;
  background-color: #93FBF9;
}
#ad{
	position:absolute;
	left:0;
	top:700px;
	width:13%;
}
</style>
</head>

<script>

function startTime()
{
var today=new Date();
var h=today.getHours();
var m=today.getMinutes();
var s=today.getSeconds();
m=checkTime(m);
s=checkTime(s);
document.getElementById('txt').innerHTML=h+":"+m+":"+s;
t=setTimeout(function(){startTime()},500);
}

function checkTime(i)
{
if (i<10)
  {
  i="0" + i;
  }
return i;
}

function style1(){
    var style1f = document.getElementById("style_target");
	style1f.setAttribute("href","/css/style2.css");
}

function style2(){
    var style1c = document.getElementById("style_target");
	style1c.setAttribute("href","/css/style.css");
}


					var ad = document.getElementById("ad");

						$(window).scroll(function(){
							var top = $(document).scrollTop() + 700;
							$("#ad").css("top",top);
						})

			
</script>
																
<body onload="startTime()" data-spy="scroll" data-target="#myScrollspy" oncontextmenu=self.event.returnValue=false >
			<audio autoplay="autopaly" loop="true">
					<source src="/mp3/bgm.mp3" type="audio/mp3" />
			</audio> 
			<a href="#"><img src="/img/ad.jpg"  id="ad"></a>
<div class="container">
  <div class="row"> 

    
    <div class="col-md-2 col-xs-2" id="myScrollspy" >
    <div data-spy="affix" >  
      <div class="bccolor">
        <h4 id="hello" class="addbold"></h4>
        <button id="timeS" class="btn-xs btn btn-warning" type="button" title="提示"  
      data-container="body" data-toggle="popover" data-placement="right" 
      data-content="合理安排，注意休息"></button>
   
        <script>
        $(function () 
      { $("[data-toggle='popover']").popover();
      });
var times="";
var hellos="";
var day=new Date();
var hours=day.getHours();
if((hours>=0)&&(hours<=5)){
   hellos="深夜了，注意身体哦";
   times="晚上好";
}
if ((hours>=6)&&(hours<=10)) {
hellos="清晨好，起得真早啊";
   times="早上好";
}
if ((hours>=11)&&(hours<=12)) {
hellos="中午好，午饭时间喔";
   times="中午好";
}
if ((hours>=13)&&(hours<=17)) {
    hellos="外面的太阳猛烈吗";
   times="下午好"; 
}
if ((hours>=18)&&(hours<=23)) {
     hellos="到了晚饭时间咯";
      times="晚上好"; 
}


document.getElementById("timeS").innerHTML=times;
document.getElementById("hello").innerHTML=hellos;
   </script> 
        
        <ul class="nav nav-pills nav-stacked addbold">
          
          <li><a href="#">首页</a></li>
          <li><a href="#section-2">足迹</a></li>
          <li><a href="#section-3">目标</a></li>
          <li><a href="#section-4">爱好</a></li>
          <li><a href="#section-5">播客</a></li>
          <li><a href="#section-6">留言</a></li>
          
        </ul>
        <p style="color: #3BC2C8" class="addbold">时间</p>
        <p id="txt"></p>
		
        <p>©2016 Designed 
			<br>
		 <p style="color: #F0AD4E">SAn</p>
			<!--
			<br><a href="chat/chat.html" style="color:#EBA50E;" target="_blank">聊天室</a>
			<br><a href="http://blog.csdn.net/qq_34789775/article/details/71302309" style="color:#EBA50E;" target="_blank">技术博客</a>
			-->
		</p>
 
        </div>
      </div>
     </div> 
  
    <div class="col-md-10 col-xs-10" style="text-align: center;">
      <div class="row"> 
        
     
        <div id="home" class="hrR"> <img src="/img/xingye.jpg" alt="头像" class="img-circle">
          <h2 class="addbold">${user.name}</h2>
            <h2 class="addbold">${user.domain}</h2>
          <br>
        
          <h4>过去虽然不能改变，未来可以。</h4>
        
			
			<button type="button" class="btn btn-warning btn-xs" onClick="style2()">默认</button>
			 <button type="button" class="btn btn-info btn-xs" onClick="style1()">新款</button>
          <br>
        </div>
        <div class="road">
          <h2 style="text-align: center;" class="addbold titlecolor margintb"  id="section-2">足迹</h2>
          <br>
          <div class="headerwidth">
          <p class="phr">--------------------------------------------------------------------------------------------------</p>
          <p>人生如梦，转瞬苍颜雪鬓，不管顺风顺水，坦途荣耀，不管逆风逆水，沉浮坎坷</p>
		 <p class="phr">--------------------------------------------------------------------------------------------------</p>
          </div>

          <div class="row">
			<div class="toproad"> 
             
              <div class="col-md-3">
                <div class="toptime addbold">
                  <p>4.13</p>
                </div>
              </div>
          
              <div class="col-md-1"> <img src="/img/red.png" class="img-circle"> </div>
              
              <div class="col-md-8">
                <div class="panel panel-info">
                  <div class="panel-heading addbold"> 蓝桥杯省赛三等奖 </div>
                </div>
               
              </div>
            </div>
           <div class="toproad"> 
             
              <div class="col-md-3">
                <div class="toptime"> 4月-11 </div>
              </div>
          
              <div class="col-md-1"> <img src="/img/green.png" class="img-circle"> </div>
           
              <div class="col-md-8">
                <div class="panel panel-danger">
                  <div class="panel-heading"> </div>
                  <div class="panel-body"> SSH框架学完，写项目</div>
                </div>
                
              </div>
            </div>
            <br/><br/><br/>
			<div class="toproad"> 
          
              <div class="col-md-3">
                <div class="toptime addbold">
                  <p>4.8-4.10</p>
                </div>
              </div>
         
              <div class="col-md-1"> <img src="/img/red.png" class="img-circle"> </div>
       
              <div class="col-md-8">
                <div class="panel panel-info">
                  <div class="panel-heading addbold"> 参见蓝桥杯与华中区程序设计网络赛 </div>
                </div>
              
              </div>
            </div>
				<br/><br/><br/>
            <div class="toproad"> 
             
              <div class="col-md-3">
                <div class="toptime">
                  <p>3月 - 4月</p>
                </div>
              </div>
            
              <div class="col-md-1"> <img src="/img/blue.png" class="img-circle"> </div>
           
              <div class="col-md-8">
                <div class="panel panel-warning">
                  <div class="panel-heading"> </div>
                  <div class="panel-body"> 校内老师加强培训强度，冲刺蓝桥杯 </div>
                </div>
              
              </div>
            </div>
			<br/><br/><br/>
            <div class="toproad"> 
            
              <div class="col-md-3">
                <div class="toptime"> 2月 - 3月 </div>
              </div>
             
              <div class="col-md-1"> <img src="/img/green.png" class="img-circle"> </div>
            
              <div class="col-md-8">
                <div class="panel panel-danger">
                  <div class="panel-heading"> </div>
                  <div class="panel-body"> 学习Struts2、Hibernate、Sping等框架，边学习算法</div>
                </div>
              
              </div>
            </div>
			
			<br/><br/><br/>
            <div class="toproad"> 
            
              <div class="col-md-3">
                <div class="toptime addbold"> 2017年 </div>
              </div>
           
               <div class="col-md-1"> <img src="/img/blue.png" class="img-circle"> </div>
            
              <div class="col-md-8">
                <div class="panel panel-success">
                  <div class="panel-heading"> </div>
                  <div class="panel-body addbold"> 进入大二下半年 </div>
                </div>
            
              </div>
            </div>
			<br/><br/><br/>
			 <div class="toproad"> 
          
              <div class="col-md-3">
                <div class="toptime addbold">
                  <p>1月-2月</p>
                </div>
              </div>
         
              <div class="col-md-1"> <img src="/img/red.png" class="img-circle"> </div>
       
              <div class="col-md-8">
                <div class="panel panel-info">
                  <div class="panel-heading addbold"> 蓝桥杯校内赛16名 Javaweb学完并掌握</div>
                </div>
           
              </div>
            </div>
			
			<br/><br/><br/>
            <div class="toproad"> 
         
              <div class="col-md-3">
                <div class="toptime">
                  <p>11月 - 12月</p>
                </div>
              </div>
           
              <div class="col-md-1"> <img src="/img/blue.png" class="img-circle"> </div>
         
              <div class="col-md-8">
                <div class="panel panel-warning">
                  <div class="panel-heading"> </div>
                  <div class="panel-body"> 开始算法的学习 冲刺蓝桥杯校内赛  </div>
                </div>
              
              </div>
            </div>
			
			<br/><br/><br/>
            <div class="toproad"> 
            
              <div class="col-md-3">
                <div class="toptime addbold"> 10月 - 11月 </div>
              </div>
            
              <div class="col-md-1"> <img src="/img/green.png" class="img-circle"> </div>
          
              <div class="col-md-8">
                <div class="panel panel-danger">
                  <div class="panel-heading"> </div>
                  <div class="panel-body addbold">泡图书馆学完剩下的JavaSE30%内容、开始自学传智播客Javaweb</div>
                </div>
         
              </div>
            </div>
			<br/><br/><br/>
            <div class="toproad"> 
            
              <div class="col-md-3">
                <div class="toptime">
                  <p>7月-9月</p>
                </div>
              </div>
         
              <div class="col-md-1"> <img src="/img/red.png" class="img-circle"> </div>
          
              <div class="col-md-8">
                <div class="panel panel-info">
                  <div class="panel-heading"> 暑假学习传智播客JavaSE 掌握SE70%知识点</div>
                </div>
            
              </div>
            </div>
            <br/><br/><br/>
            <div class="toproad"> 
            
              <div class="col-md-3">
                <div class="toptime addbold"> 9月 </div>
              </div>
          
               <div class="col-md-1"> <img src="/img/blue.png" class="img-circle"> </div>
           
              <div class="col-md-8">
                <div class="panel panel-success">
                  <div class="panel-heading"> </div>
                  <div class="panel-body addbold"> 进入大二上半年 </div>
                </div>
              
              </div>
            </div>
            <div class="toproad"> 
           
              <div class="col-md-3">
                <div class="toptime">
                  <p>4月 - 6月</p>
                </div>
              </div>
          
              <div class="col-md-1"> <img src="/img/red.png" class="img-circle"> </div>
         
              <div class="col-md-8">
                <div class="panel panel-warning">
                  <div class="panel-heading"> </div>
                  <div class="panel-body"> 菜鸟教程自学Boostrap与Jquery（三遍） </div>
                </div>
              
              </div>
            </div>
			
			<br/><br/><br/>
            <div class="toproad"> 
      
              <div class="col-md-3">
                <div class="toptime"> 2月 - 4月 </div>
              </div>
         
              <div class="col-md-1"> <img src="/img/green.png" class="img-circle"> </div>
           
              <div class="col-md-8">
                <div class="panel panel-danger">
                  <div class="panel-heading"> </div>
                  <div class="panel-body">奔波各大慕课平台自学javase与javascript  </div>
                </div>
         
              </div>
            </div>
			<br/><br/>
			<br/><br/><br/>
			<br/><br/><br/>
            <div class="toproad"> 
          
              <div class="col-md-3">
                <div class="toptime addbold"> 2016年 </div>
              </div>
            
              <div class="col-md-1"> <img src="/img/blue.png" class="img-circle"> </div>
           
              <div class="col-md-8">
                <div class="panel panel-success">
                  <div class="panel-heading"> </div>
                  <div class="panel-body addbold"> 进入大一下半年 </div>
                </div>
           
              </div>
            </div>
			<br/><br/><br/>
            <div class="toproad"> 
           
              <div class="col-md-3">
                <div class="toptime"> 11月 - 2月 </div>
              </div>
          
			  <div class="col-md-1"> <img src="/img/red.png" class="img-circle"> </div>
          
              <div class="col-md-8">
                <div class="panel panel-info">
                  <div class="panel-heading"> </div>
                  <div class="panel-body"> 慕课网自学HTML5与CSS、PS  </div>
                </div>
           
              </div>
            </div>
			<br/><br/><br/>
            <div class="toproad"> 
            
              <div class="col-md-3">
                <div class="toptime"> 9月 - 11月 </div>
              </div>
           
              <div class="col-md-1"> <img src="/img/green.png" class="img-circle"> </div>
          
              <div class="col-md-8">
                <div class="panel panel-warning">
                  <div class="panel-heading"> </div>
                  <div class="panel-body"> 开始学习PS、HTTML、office基础 </div>
                </div>
            
              </div>
            </div>
			<br/><br/><br/>
            <div class="toproad"> 
            
              <div class="col-md-3">
                <div class="toptime addbold"> 2015年 </div>
              </div>
             
			    <div class="col-md-1"> <img src="/img/blue.png" class="img-circle"> </div>
             
              <div class="col-md-8">
                <div class="panel panel-default">
                  <div class="panel-heading addbold"> 踏入软件专业 </div>
                </div>
             
              </div>
            </div>
          </div>
        </div>

        <div class="target textc">
          <div class="row"> 
     
            <div>
              <h2 class="addbold  margintb titlecolor margintb"  id="section-3">目标</h2>
              <br>
              <div class="headerwidth">
              <p>------------------------------------------------------------------------------------------------------------------------</p>
              <p>从内而外，勇气充斥着我的灵魂，让我不断的战斗。我可以听见自己的心跳，充满力量，活着真好</p>
              <p>------------------------------------------------------------------------------------------------------------------------</p>
            </div>
        </div>
            <br>
            <br>
          
            <div class="row">
              <div class="col-md-4"> <img src="/img/hack.png" alt="黑客" class="img-circle imgs">
                <h3>算法</h3>
                <p class="plr">算法是程序的灵魂。</p>
              </div>
              <div class="col-md-4"> <img src="/img/java.png" alt="java" class="img-circle imgs">
                <h3>JAVA</h3>
                <p class="plr">允许程序员以优雅的思维方式进行复杂的编程。</p>
              </div>
              <div class="col-md-4"> <img src="/img/web.png" alt="前端" class="img-circle imgs" >
                <h3>前端</h3>
                <p class="plr">HTML5、CSS3、javascript等技术，bootstrap、Jquery框架。</p>
              </div>
            </div>
         
            <div class="progress1">
              <h4 class="addbold  margintb">PROGRESS</h4>
              <h5>前端</h5>
              <div class="progress progressb">
                <div class="progress-bar progress-bar-success" role="progressbar" 
      aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" 	
      style="width: 80%;"> <span>"80%"</span> </div>
              </div>
              <h5>算法</h5>
              <div class="progress progressb">
                <div class="progress-bar progress-bar-info" role="progressbar" 
      aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" 	
      style="width: 40%;"> <span>"40%"</span> </div>
              </div>
              <h5 class="">javaSE</h5>
              <div class="progress progressb">
                <div class="progress-bar progress-bar-warning" role="progressbar" 
      aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" 
      style="width: 100%;"> <span>"100%"</span> </div>
              </div>
              <h5>javaEE</h5>
              <div class="progress">
                <div class="progress-bar progress-bar-danger" role="progressbar" 
      aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" 	
      style="width: 70%;" > <span>"70%"</span> </div>
              </div>
            </div>
          </div>
        </div>
        <div class="target yellowtext">
          <div class="row">
            <div>
              <h2 class="addbold  margintb titlecolor" id="section-4">爱好</h2>
              
              <div class="headerwidth">
              	
              
              <p>---------------------------------------------------------------------------------------------------------------------------</p>
              <p style="color:#7C94E6;">每个人都有属于自己的兴趣爱好，而这些兴趣爱好往往会使我们把烦恼。不高兴的事忘到九霄云外去</p>
              <p>---------------------------------------------------------------------------------------------------------------------------</p>
            </div>
            </div>
      
            <div class="row toproad">
   <div class="col-sm-6 col-md-4">
      <div class="thumbnail">
         <img src="/img/2(1).jpg"
         alt="originality">
         <div class="caption">
            <h5>originality</h5>
            <p>一点点 - 创意设计</p>
            <p>
               
            </p>
         </div>
      </div>
   </div>
   <div class="col-sm-6 col-md-4">
      <div class="thumbnail">
         <img src="/img/2(2).jpg"
         alt="originality">
         <div class="caption">
            <h5>originality</h5>
            <p>一点点 - 创意设计</p>
            <p>
               
            </p>
         </div>
      </div>
   </div>
   <div class="col-sm-6 col-md-4">
      <div class="thumbnail">
         <img src="/img/2(3).jpg"
         alt="originality">
         <div class="caption">
            <h5>originality</h5>
            <p>一点点 - 创意设计</p>
            <p>
              
            </p>
         </div>
      </div>
   </div>
        </div>
        
         <div class="row">
   <div class="col-sm-6 col-md-4">
      <div class="thumbnail">
         <img src="/img/1(1).jpg"
         alt="originality">
         <div class="caption">
            <h5>originality</h5>
            <p>一点点 - 创意设计</p>
            <p>
               
            </p>
         </div>
      </div>
   </div>
   <div class="col-sm-6 col-md-4">
      <div class="thumbnail">
         <img src="/img/1(2).jpg"
         alt="originality">
         <div class="caption">
            <h5>originality</h5>
            <p>一点点 - 创意设计</p>
            <p>
               
            </p>
         </div>
      </div>
   </div>
   <div class="col-sm-6 col-md-4">
      <div class="thumbnail">
         <img src="/img/1(3).jpg"
         alt="originality">
         <div class="caption">
            <h5>originality</h5>
            <p>一点点 - 创意设计</p>
            <p>
              
            </p>
         </div>
      </div>
   </div>
        </div>
       
         <div class="row">
   <div class="col-sm-6 col-md-4">
      <div class="thumbnail">
         <img src="/img/3(1).jpg"
         alt="originality">
         <div class="caption">
            <h5>originality</h5>
            <p>一点点 - 创意设计</p>
            <p>
               
            </p>
         </div>
      </div>
   </div>
   <div class="col-sm-6 col-md-4">
      <div class="thumbnail">
         <img src="/img/3(2).jpg"
         alt="originality">
         <div class="caption">
            <h5>originality</h5>
            <p>一点点 - 创意设计</p>
            <p>
               
            </p>
         </div>
      </div>
   </div>
   <div class="col-sm-6 col-md-4">
      <div class="thumbnail">
         <img src="/img/3(3).jpg"
         alt="originality">
         <div class="caption">
            <h5>originality</h5>
            <p>一点点 - 创意设计</p>
            <p>
              
            </p>
         </div>
      </div>
   </div>
        </div>
    
         <div class="row">
   <div class="col-sm-6 col-md-4">
      <div class="thumbnail">
         <img src="/img/1(4).jpg"
         alt="originality">
         <div class="caption">
            <h5>originality</h5>
            <p>一点点 - 创意设计</p>
            <p>
               
            </p>
         </div>
      </div>
   </div>
   <div class="col-sm-6 col-md-4">
      <div class="thumbnail">
         <img src="/img/2(4).jpg"
         alt="originality">
         <div class="caption">
            <h5>originality</h5>
            <p>一点点 - 创意设计</p>
            <p>
               
            </p>
         </div>
      </div>
   </div>
   <div class="col-sm-6 col-md-4">
      <div class="thumbnail">
         <img src="/img/3(4).jpg"
         alt="originality">
         <div class="caption">
           <h5>originality</h5>
            <p>一点点 - 创意设计</p>
            <p>
              
            </p>
         </div>
      </div>
   </div>
     </div>
	</div>
     
      </div>
     
            <div class="row">
           
        <div class="target">
			<h2 class="addbold  margintb titlecolor margintb" id="section-5">播客</h2>
			<div class="headerwidth">
             	   
             <p>------------------------------------------------------------------------------------------------</p>
              <p>即便付出与得到不成正比，但至少不会留下遗憾，至少没有拥有不是因为错失</p>
              <p>------------------------------------------------------------------------------------------------</p>
            </div>
            <div class="view">
                    <div class="view1">
                    <div class="view2">
                    	     
            	<img src="/img/post1.jpg" class="contact4">
                 <h4 class="pull-left"><a href="#">心灵鸡汤</a></h4>
                 <hr>
                 <p>身在让人迷茫的大学，告诉自己：像个人一样活着吧，正经地学点东西吧，要慎重的做出选择呀，保持清醒的头脑吧。你的行为并不是只牵动着你一个人，即使年轻，也一定要勇敢的承担起责任</p>
                 </div>
                 <hr>
                 <div class="datecolor">
                 	<p class="pull-left"><span class="glyphicon glyphicon-cloud"></span>Date:<span class="pc">18 June</span></p> <p class="pull-right">Comments:<span class="pc">19</span></p>
                 </div>
                 
                 <br>
   			</div>  
   			
   			<div class="view1">
                    <div class="view2">
                    	     
            	<div class="view3">
            		<h4>不要整天患得患失，想那些有的没的，让自己忙起来，忙是治疗一切神经病的良药</h4>
            	</div>
                 <h4 class="pull-left"><a href="#">经典语录</a></h4>
                 </div>
                 <hr>
                 <div class="datecolor">
                 	<p class="pull-left"><span class="glyphicon glyphicon-cloud"></span>Date:<span class="pc">18 June</span></p> <p class="pull-right"> <span class="glyphicon glyphicon-fire"></span>Comments:<span class="pc">06</span></p>
                 </div>
                 
                 <br>
   			</div> 
   			<div class="view1">
                    <div class="view2">
                    	     
            	<img src="/img/11.jpg" class="contact4">
                 <h4 class="pull-left"><a href="#">Smile</a></h4>
                 <hr>
                 </div>
                 <div class="datecolor">
                 	<p class="pull-left"><span class="glyphicon glyphicon-cloud"></span>Date:<span class="pc">18 June</span></p> <p class="pull-right">Comments:<span class="pc">23</span></p>
                 </div>
                 
                 <br>
   			</div> 
   			<div class="view1">
                    <div class="view2">
                    	     
            	<img src="/img/post2.jpg" class="contact4">
                 <h4 class="pull-left"><a href="#">心灵鸡汤</a></h4>
                 <hr>
                 <p>保持善良，做到真诚，宽容待别人，严以律自己，其他一切随意就好！ 真正的朋友不一定常见面，但一定在你需要的时候出现在你面前，不一定常联系..但一定把你放在心中最温暖的一角。人，各有各的位置，各有各的价值，各有各的理念，各有各的世界观，各有各的人生观，各有各的价值观。把该做的事做好，把该走的路走好</p>
                 </div>
                 <hr>
                 <div class="datecolor">
                 	<p class="pull-left"><span class="glyphicon glyphicon-cloud"></span>Date:<span class="pc">18 June</span></p> <p class="pull-right">Comments:<span class="pc">19</span></p>
                 </div>
                 
                 <br>
   			</div> 
            </div>

  	</div>

  </div>

  <div class="row">
		<div class="target">
	   		<h2 class="addbold  margintb titlecolor margintb" id="section-6">留言</h2>
	   		
	   		<div class="headerwidth">
              <p>-----------------------------------------------------------------------------</p>
              <p class="pc">如果你对此站点内容有想法或者建议欢迎留言，同请教与交流。</p>
              <p>-----------------------------------------------------------------------------</p>
            </div>

            <div id="myCarousel" class="carousel slide">

   <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
   </ol>   

   <div class="carousel-inner margintb heigthcontact">
      <div class="item active">
         <img class="img-rounded" src="/img/street2.jpg" alt="First slide">
      </div>
      <div class="item">
         <img class="img-rounded" src="/img/street.jpg" alt="Second slide">
      </div>
      <div class="item">
         <img class="img-rounded" src="/img/street3.jpg" alt="Third slide">
      </div>
   </div>

   <a class="carousel-control left" href="#myCarousel " 
      data-slide="prev">&lsaquo;</a>
   <a class="carousel-control right" href="#myCarousel" 
      data-slide="next">&rsaquo;</a>
</div> 

	   		<div class="row">
		<h3>LET'S GET IN TOUCH</h3>
	   		<div class="col-md-6 col-xs-6">	   			
	   			<ul class="contact2">

	   				<li><img src="/img/contact(1).png">1300100082<span class="label label-info">QQ</span></li>
	   				<li><img src="/img/contact(2).png">1300100082@qq.com<span class="label label-success">Email</span></li>

	   			</ul>
	   		</div>
	   		<div class="col-md-6 col-xs-6">
	   		<ul class="contact2">

	   				<li><img src="/img/contact(3).png">湖北武汉<span class="label label-warning">Address</span></li>
	   				<li><img src="/img/contact(4).png">萌新求支持<span class="label label-danger">Support</span></li>
	   			</ul>
	
   </div>
	   		</div>
			
		<div id="SOHUCS" sid="SAn"></div>
		<script charset="utf-8" type="text/javascript" src="https://changyan.sohu.com/upload/changyan.js" ></script>
		<script type="text/javascript">
		window.changyan.api.config({
		appid: 'cysY47RCD',
		conf: 'prod_0c1fd0a4edbb782bf78a2e967106b6c4'
		});
		</script>

	   		</div>
		</div>

  </div>


  </div>
</div>

</body>
</html>
