// var xmlHttp = null;//声明XMLHttpRequest
//
// // 创建XMLHttpRequest对象
// function createXMLHttpRequest() {
//     // 已创建XMLHttpRequest对象，直接返回
//     if (xmlHttp != null)
//         return;
//     // 检测浏览器针对(FireFox、Chrome、Safari、Opera与IE7+)是否支持直接创建XMLHttpRequest
//     if (window.XMLHttpRequest) {
//         xmlHttp = new XMLHttpRequest();
//         // 检测否是IE浏览器
//     } else if (window.ActiveXObject) {
//         try {
//             // IE6
//             xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
//         } catch (e) {
//             // IE5
//             xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
//         }
//     }
// }
//
//
// //发送请求
// function sendRequest(){
//     // 创建异步发送请求对象
//     createXMLHttpRequest();
//     //非0、非null、true表示真
//     if (!xmlHttp){
//         alert("XMLHttpRequest对象创建失败!!");
//         return;
//     }
//     var str = document.getElementById("txtMessage").value;
//
//
//     //Post方式发送请求
//     xmlHttp.open("POST","AjaxMessageServlet",true);
//     xmlHttp.onreadystatechange=showMessage;
//     xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");//设置编码方式
//     xmlHttp.send("message="+str);
// }
//
//
// //回调函数
// function showMessage(){
//     //判断就绪状态和响应状态码是否符合要求
//     if(xmlHttp.readyState==4&&xmlHttp.status==200) {
//         var result = xmlHttp.responseText;//接收服务器响应的文本
//
//         document.getElementById("myspan").innerHTL = result;
//     }
// }

