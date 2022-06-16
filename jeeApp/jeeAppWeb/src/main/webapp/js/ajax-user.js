
window.onload = function(){

    let eltBtnAjax = document.getElementById("btnUserViaAjax");
    eltBtnAjax.addEventListener("click",function (evt){
	    let inputUserId = document.getElementById("userId");
	    let userId = inputUserId.value;
        let url = "api-user/user/"+userId;
        makeAjaxGetRequest(url,callbackDeviseSucces,callbackError);
    });

}

function callbackDeviseSucces(responseData){
    console.log("Succes:"+responseData + " " + typeof responseData);
    let objUser = JSON.parse(responseData);
    let spanUsername = document.getElementById("username");
    spanUsername.innerHTML="<b>"+objUser.username+"</b>";
    let spanEmail = document.getElementById("email");
    spanEmail.innerHTML="<b>"+objUser.email+"</b>";
}

function callbackError(responseData){
    console.log("ERROR:"+responseData);
}