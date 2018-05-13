<html><br>
<head><br>
    <title>Welcome!</title><br>
</head>
<body>
<hr>
<#if list.ret >
    <#list list.data as l>
    <h1>Welcome ${l.name} !</h1>
    <p>${l.id}</p>
    <p>${l.domain}</p>
    </#list>
</#if>
</body>
</html>