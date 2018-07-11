<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>${lover.yourName}❤${lover.taName}</title>
    <link rel="icon" href="/ico/waiting.ico" type="image/x-icon" />
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <style type="text/css">
        @font-face {
            font-family: digit;
            src: url("/digital-7_mono.ttf" /*tpa=./digital-7_mono.ttf*/) format("truetype");
        }
        #feedAv{ margin-top: -250px!important;transform: scale(0);}
        #powerby_sohu a{font-size:0!important;line-height:0!important}
        #changyan_floatbar_wrapper{display:none!important}
    </style>
    <link href="/css/default.css" tppabs="./css/default.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="/js/jquery.js" tppabs="./js/jquery.js"></script>
    <script type="text/javascript" src="/js/garden.js" tppabs="./js/garden.js"></script>
    <script type="text/javascript" src="/js/functions.js" tppabs="./js/functions.js"></script>
<body>
<div id="mainDiv">
    <div id="content">
        <div id="code">
            <span class="comments">${lover.taName}</span><br/>
            <span class="space"><span class="comments">${lover.loveWords1}</span></span><br/>
            <span class="space"/><span class="comments">${lover.loveWords2}</span><br/>
            <span class="space"/><span class="comments">${lover.loveWords3}</span><br/>
            <span class="space"/><span class="comments">${lover.loveWords4}</span><br/>
            <br/>
            <br/>
            <span class="space"/><span class="comments">来</span>
            <br/>
            <span class="space"/><span class="comments">自</span>
            <br/>
            <span class="space"/><span class="comments">${lover.yourName}</span>
        </div>
        <div id="loveHeart">
            <canvas id="garden"></canvas>
            <div id="words">
                <div id="messages">
                ${lover.taName}, 这是我们认识的第
                    <div id="elapseClock"></div>
                </div>
                <div id="loveu">
                    永远爱你，一辈子，不分离！<br/>
                    <div class="signature">- ${lover.yourName}</div>
                </div>
            </div>
        </div>
        <div id="SOHUCS" sid=""></div>
        <script type="text/javascript">
            $("#SOHUCS").attr("sid", window.location.href);
            window.changyan = undefined;
            window.cyan = undefined;
            $.getScript("https://changyan.sohu.com/upload/changyan.js", function () {
                window.changyan.api.config({appid: "cysY47RCD", conf: "prod_0c1fd0a4edbb782bf78a2e967106b6c4"});
            })
            $.ajaxSetup({cache: true});
        </script>
    </div>

    <script type="text/javascript">

        var offsetX = $("#loveHeart").width() / 2;
        var offsetY = $("#loveHeart").height() / 2 - 55;
        var together = new Date();
        together.setFullYear(${lover.year}, ${lover.month} , ${lover.day});
        together.setHours(20);
        together.setMinutes(0);
        together.setSeconds(0);
        together.setMilliseconds(0);

        if (!document.createElement('canvas').getContext) {
            var msg = document.createElement("div");
            msg.id = "errorMsg";
            msg.innerHTML = "提醒您：您的浏览器版本过旧^_^<br/>" +
                    "推荐使用 <a href='http://dlsw.br.baidu.com/ditui/zujian/bdBrowserSetup-5956-ftn_1000061134.exe' target='_blank'>百度浏览器<br/>请先升级您的浏览器，效果很炫哦~~";
            document.body.appendChild(msg);
            $("#code").css("display", "none")
            $("#copyright").css("position", "absolute");
            $("#copyright").css("bottom", "10px");
            document.execCommand("stop");
        } else {
            setTimeout(function () {
                adjustWordsPosition();
                startHeartAnimation();
            }, 5000);

            timeElapse(together);
            setInterval(function () {
                timeElapse(together);
            }, 500);

            adjustCodePosition();
            $("#code").typewriter();
        }
    </script>
    <audio id="bgmMusic" src="/mp3/bg.mp3" preload="auto" type="audio/mp3" autoplay loop></audio>


</body>
</html>
