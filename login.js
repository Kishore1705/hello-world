/*Signin Button*/

$(document).ready(function(){
	$('#loginForm').show();
/*Signin Button Click event*/
	$('#userlogin').on("click",function(){
		var loginDetails=[];
		$('#loginForm input').each(function(){
			if ($(this).val() != "") 
			{
				loginDetails.push($(this).val());
			}	
			else if($(this).val() == "")
			{
				$(this).css({"border":"1px solid red"});
			}					
		});
		//alert(loginDetails.length);
		if(loginDetails.length == 2)
		{
			if(loginDetails[0] == "arpitha@nusecond.com" && loginDetails[1] == "aaa")
			{
				window.location.href="homepage.html";
			}
			else
			{
				$('#error').text('Invalid user name or password');
			}
		}
	});

	/*Form input on focus event*/
	$('#loginForm input').focus(function(){
		$(this).css({"border":""});
	});

	/*Form input on focusout event*/
	$('#loginForm input').blur(function(){
		if($(this).val() != "")
		{
			$(this).css({"border":"1px solid green"});
		}
		else
		{
			$(this).css({"border":"1px solid red"});
		}
	});

	/*Register Button Click event*/
	$('#register').click(function(){
		$('#loginForm').hide();
	});
});
/*Enter key
	var callback = function(e){
    console.log(e.type, e);
    var text = e.type;
    var code = e.which ? e.which : e.keyCode;
    if(13 === code){
        text += ': ENTER';
    } else {
        text += ': keycode '+code;
    }
    alert(text);
	};

	$('#email').keydown(callback);*/