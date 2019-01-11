var xmlHttp = null;//声明XMLHttpRequest

// 创建XMLHttpRequest对象
function createXMLHttpRequest() {
    // 已创建XMLHttpRequest对象，直接返回
    if (xmlHttp != null)
        return;
    // 检测浏览器针对(FireFox、Chrome、Safari、Opera与IE7+)是否支持直接创建XMLHttpRequest
    if (window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest();
        // 检测否是IE浏览器
    } else if (window.ActiveXObject) {
        try {
            // IE6
            xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            // IE5
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
    }
}


//发送请求
function sendRequest(){
    // 创建异步发送请求对象
    createXMLHttpRequest();
    //非0、非null、true表示真
    if (!xmlHttp){
        alert("XMLHttpRequest对象创建失败!!");
        return;
    }

    //Post方式发送请求
    xmlHttp.open("POST","SearchServiceController",true);
    xmlHttp.onreadystatechange=showProduct;
    xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");//设置编码方式
    xmlHttp.send("message="+str);
}


//回调函数
function showProduct(){
    //判断就绪状态和响应状态码是否符合要求
    if(xmlHttp.readyState==4&&xmlHttp.status==200) {
        var jsonPro = xmlHttp.responseText;//接收服务器响应的文本
        $("#content").html=null;
        for(var i=0;i<jsonPro.length;i++){
            var pro = jsonPro[i];
            var str = '<a href="javascript:;" class="aui-list-item"><div class="aui-right-top"></div><div class="aui-list-head" id="proname">'+pro.productName+'</div><div class="aui-flex"><div class="aui-flex-box"><h4>'+pro.productNum+'</h4></div><div class="aui-text-time"></div><div class="aui-button-get"><button id="apply", onclick="location=\'apply.html\'">申请</button> </div></div><div class="aui-dotted"></div></a>';

        }
        $("#content").append(str);

    }
}


