//以下代码为AJAX提交搜索请求代码,实际应用中请启用以下代码,并正确填写搜索提交路径和数据获取路径.
//$('#btn').click(function() {
//	$.ajax({
//		cache: true, //保留缓存数据
//		type: "POST", //为post请求
//		url: "url", //提交到指定路径
//		async: true, //true可异步，false不可异步
//		data: $("#serch").val(), //提交数据为input里value
//		async: true, //true可异步，false不可异步
//		error: function(request) { //请求失败之后的操作
//			return;
//			alert("提交失败");
//		},
//		success: function(data) { //请求成功之后的操作
//			$.ajax({
//				cache: true, //保留缓存数据
//				type: "GET", //为get请求
//				url: "url", //数据返回接口路径
//				async: true, //true可异步，false不可异步
//				error: function(request) { //请求失败之后的操作
//					return;
//					alert("请求失败");
//				},
//				success: function(data) { //请求成功之后的操作
//					var x = '';
//					$.each(data, function(index, value) {
//						var trs = "";
//						trs += "<label class='el-checkbox'><img src=" + data[index].head_img + "alt='' /><h4>" + data[index].nickname + "</h4><p>" + data[index].desc + "</p><input name='public' type='checkbox' value='' /></label>";
//						x += trs;
//					});
//					$(".content").html(x);
//				}
//			});
//		}
//	});
//})

//以下代码为本次测试数据的打印,实际应用中请把以下代码全部注释,并启用上面的代码块.
$('#btn').click(function() {
	$.ajax({
		cache: true, //保留缓存数据
		type: "GET", //为get请求
		url: "http://www.17sucai.com/preview/575598/2018-05-09/%E5%85%AC%E4%BC%97%E5%8F%B7/js/shuju.json", //获取数据接口指定路径
		async: true, //true可异步，false不可异步
		error: function(request) { //请求失败之后的操作
			return;
			alert("请求失败");
		},
		success: function(data) { //请求成功之后的操作
			var x = '';
			$.each(data, function(index, value) {
				console.log(data[index].wxid + '' + data[index].nickname + '' + data[index].head_img + '' + data[index].desc);
				var trs = ""; 
				trs += "<label class='el-checkbox'><img src=" + data[index].head_img + "alt='' /><h4>" + data[index].nickname + "</h4><p>" + data[index].desc + "</p><input name='public' type='radio' value='' /></label>";
				x += trs;
			});
			$(".content").html(x);
		}
	});
})

//点击确认,提交所选公众号名称，修改提交地址
$('#btn2').click(function(){
	var radioValue = $("input[type='radio']:checked").parent().find('h4').html();
	console.log(radioValue);
//	$.ajax({
//		cache: true, //保留缓存数据
//		type: "POST", //为post请求
//		url: "url", //提交到指定路径
//		async: true, //true可异步，false不可异步
//		data: radioValue, //提交数据为公众号名字
//		async: true, //true可异步，false不可异步
//		error: function(request) { //请求失败之后的操作
//			return;
//			alert("提交失败");
//		},
//		success: function(data) { //请求成功之后的操作
//			console.log("提交成功");
//		}
//	});
})
