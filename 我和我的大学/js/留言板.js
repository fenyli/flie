var tou=new Array("1-1.png","1-5.png","1-6.png","1-4.png");
function postSuccess()
{
	var newLi=document.createElement("li");//创建一个新的li节点元素
	var iNum=Math.floor(Math.random()*4);//随机获取头像
	var touDiv=document.createElement("div");//创建头像所在的div节点
	var touImg=document.createElement("img");//创建头像节点
	touImg.setAttribute("src","images/"+tou[iNum]);//增加头像路径
	touDiv.appendChild(touImg);//将头像放在div节点中
	
	var titleH1=document.createElement("span");//创建标题所在的标签h1
    var titlep=document.createElement("p");
	var title=document.getElementById("title").value;//获取标题
    var content=document.getElementsByTagName("textarea");//获取内容
	titleH1.innerHTML=title;//将标题内容放在h1标签中
	titlep.innerHTML=content;//将留言内容内容放在p标签中

	var newP=document.createElement("p");//创建一个新的p节点元素
	var secName=document.createElement("span");
	var secSelect=document.getElementById("sec").value;//获取版块
	secName.innerHTML="姓名："+secSelect;//将版块内容放到span中
	var myDate=new Date();//创建一个日期对象

	var currentDate=myDate.getFullYear()+"-"+parseInt(myDate.getMonth()+1)+"-"+
	myDate.getDate()+" "+myDate.getHours()+":"+myDate.getMinutes();//获取现在的日期时间，显示示例 如：2022-5-15 21:43
	var timeSpan=document.createElement("span");//创建一个span标签
	timeSpan.innerHTML="发表时间:"+currentDate;//span标签中的值显示为  "发表时间:"+currentDate
	newP.appendChild(secName);//在p节点中插入版块
	newP.appendChild(timeSpan);//在p节点中插入发布时间
	
	newLi.appendChild(touDiv);//插入头像
	newLi.appendChild(titleH1);//插入标题
	newLi.appendChild(newP);//插入版块、时间内容
	var postList=document.getElementById("postList");
	postList.insertBefore(newLi,postList.firstchild);//把当前内容插入到列表最前面
	
	document.getElementById("title").value="";//标题设置为空
	document.getElementById("sec").value="";//标题设置为空
	alert("(*^◎^*)感谢有你！");
}
