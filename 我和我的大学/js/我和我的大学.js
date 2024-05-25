$(document).ready(function(){//网页加载完毕后执行
	
	$(".div_3_1 li:nth-of-type(1)").mouseover(function(){
		$(".div_3_11").show();
	}).mouseout(function(){
	$(".div_3_11").hide();
	})

	var img=Array("lunbo1.jpg","lunbo2.jpg","lunbo3.jpg");//创建一个数组用来放置图片
	var flag=0;//创建一个变量flag
	$(".arrowRight").click(function(){//通过class=arrowRight找到标签，点击该标签执行该函数
		if(flag==img.length-1){alert("已经是最后一张图片了");}//如果flag==img.length-1，弹出警告框“已经是最后一张图片了”
		else{//否则
			flag++;//flag自增1
			var i=flag+1;//变量i=flag+1
			$(".adver").css("background","url(images/"+img[flag]+")");//通过class=adver找到标签，为其添加样式，通过url添加背景图
			$(".ul_2 li:nth-of-type("+i+")").css("background","orange");//为第i个li标签添加样式，背景颜色为橙色
			$(".ul_2 li:nth-of-type("+i+")").siblings().css("background","#333333");//为第i个li标签的兄弟标签添加样式，背景颜色为黑色
		}
	});
	
	$(".arrowLeft").click(function(){//通过class=arrowLeft找到标签，点击该标签执行该函数
		if(flag==0){alert("这是第一张图片了");}//如果flag==img.length-1，弹出警告框“这是第一张图片了”
		else{//否则
			flag--;//flag自减1
			var i=flag+1;//变量i=flag+1
			$(".adver").css("background","url(images/"+img[flag]+")");//通过class=adver找到标签，为其添加样式，通过url添加背景图
			$(".ul_2 li:nth-of-type("+i+")").css("background","orange");//为第i个li标签添加样式，背景颜色为橙色
			$(".ul_2 li:nth-of-type("+i+")").siblings().css("background","#333333");//为第i个li标签的兄弟标签添加样式，背景颜色为黑色
		}
	});
	
	$(".adver").mousemove(function(){//鼠标移到class=adver标签所在位置时执行
		$(".arrowRight").show();//显示class=arrowRight标签所在的内容
		$(".arrowLeft").show();//显示class=arrowLeft标签所在的内容
	}).mouseout(function(){//鼠标不在class=adver标签所在位置时执行
		$(".arrowRight").hide();////隐藏class=arrowRight标签所在的内容
		$(".arrowLeft").hide();////隐藏class=arrowLeft标签所在的内容
	})
})

