<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assests/styles/index.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
    <title>Document</title>
</head>
<body>           
    <div class="divider">
    <div class="sidebar">
    <div class="myprofile">
        <img src="assests/images/profile.png" alt="">
    </div>
    <div class="globalchat">
        <button onclick="location.href='global.html';"><img src="assests/images/globalchat.png" alt=""></button>
    </div>
    <div class="groupchat">
        <button><img src="assests/images/group.png" alt=""></button>
    </div>
    <div class="privatechat">
        <button><img src="assests/images/chat.png" alt=""></button>
    </div>
</div>
<div class="messagecontent">
    <div class="scrollablemessagecontent" id="widthassign">
        <div class="emptyspace" id="marker"></div>
        <Script>
        </Script>
    </div>
    <div class="messagesender">
        <input type="text" placeholder="Enter your message" id="sendmessage">
        <button onclick="sendmessage()"><img src="assests/images/send.png" alt=""></button>
    </div>
</div>
</div> 
<script>
var id=0;
setInterval(Readmessage, 1000);
Readmessage()
function Readmessage(){
	$(document).ready(function(){
		console.log("calling");
		$.ajax({
			type:'POST',
			url:'GlobalController',data:{currentId:id},
			success:function(result){
				if(result!=""){
				var parseresult=$.parseJSON(result);
				id=id+parseresult.length;
				parseresult;
				console.log(id);
				console.log(result);
				$.each(parseresult,function(i,value){
					if(value.username=="Amrish"){
						$("#marker").append('<div class="rightmessage"><h3>'+value.username+'</h3><div class="message"><p>'+value.message+'</p></div></div>');
					}else{
						$("#marker").append('<div class="leftmessage"><h3>'+value.username+'</h3><div class="message"><p>'+value.message+'</p></div></div>');
					}
				});
				var elem = document.getElementById('widthassign');
				  elem.scrollTop = elem.scrollHeight;

				}
			}
		});
	})
}
$(document).keyup(function(event) {
    if (event.which === 13) {
    	sendmessage();
    }
});
    function sendmessage(){
        $(document).ready(function(){
        	var inputelement=document.getElementById("sendmessage");
        	var message=inputelement.value;
        	if(message!=''){
        	$.ajax({
        		type:'GET',data:{message:message},
        		url:'GlobalController',
        		success:function(result){
        			console.log("sended "+message);
        			Readmessage();
        		}
        	});
        	inputelement.value='';
        	}
        });
    }
</script>
</body>
</html>