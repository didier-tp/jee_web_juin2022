
window.onload = function(){

    let eltBtnAjax = document.getElementById("btnUserViaAjax");
    eltBtnAjax.addEventListener("click",function (evt){
	    let inputUserId = document.getElementById("userId");
	    let userId = inputUserId.value;
        let url = "api-user/user/"+userId;
        makeAjaxGetRequest(url,callbackDeviseSucces,callbackError);
    });
    
    let eltBtnAddAjax = document.getElementById("btnAddUserViaAjax");
    eltBtnAddAjax.addEventListener("click",function (evt){
	    let newUser = {};
	    newUser.username = document.getElementById("txtUsername").value;
	    newUser.password = document.getElementById("txtPassword").value;
	    newUser.email = document.getElementById("txtEmail").value;
        let url = "api-user/user";
        let userAsJsonString = JSON.stringify(newUser);
        console.log("userAsJsonString="+userAsJsonString);
        makeAjaxPostRequest(url,userAsJsonString,callbackPostSucces,callbackError);
    });

}

function callbackPostSucces(responseData){
    console.log("Succes:"+responseData + " " + typeof responseData);
    document.getElementById("message").innerHTML="<b>"+responseData+"</b>";
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