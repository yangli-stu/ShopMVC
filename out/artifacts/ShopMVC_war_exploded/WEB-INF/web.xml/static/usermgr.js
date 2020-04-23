/* 
 * 使用AJAX方式制作表格
 * 1. 把服务器范围的字符串转成JS对象
 * 2. 清空表格
 * 3. 创建表头
 * TODO   4. 使用循环的方式制作表格中的行
 */
 $(document).ready(function(){
	 findAll();
	 
	 /*
	  * 监听删除用户的事件
	  */
	 $(document).on('click','.remove',function () {
	     //自己的代码
		 if(window.confirm("您确定要删除数据吗?"))
			{
			 console.log($(this).attr('id'));
			 var id = $(this).attr('id');
			 deleteGoods(id);
//				$(this).parent().parent().remove();
			}
	 });
	 
	 $(document).on('click','.update',function () {
	     //自己的代码
		 var tds = $(this).parent().siblings("td");
		 console.log(tds);
		 var id = tds[0].innerText;
		 console.log(id);
		 var goodsname = tds[1].innerText;
		 var goodstype = tds[2].innerText;
		 
		 $("#goodsid").val(id);
		 $("#goodsname").val(goodsname);
		 $("#goodstype").val(goodstype);
	 });
	 
	 

 });
 
 
 /*
 * 使用AJAX提交新增用户
 */
 $("#submitBtn").click(function(e){
     //阻止默认行为
     var e = e || window.event;
     e.preventDefault();
     var id =  $("#goodsid").val();
     console.log(id);
//     console.log(id.length);
     if(id>0){
    	 updateGoods();
     }else{
         addGoods();
     }
 })
 

 
function addGoods(){
	 //获取表单数据
     var goodsname = $("#goodsname").val().trim();
     var goodstype = $("#goodstype").val().trim();

     //请求的参数
     var data = {'goodsname':goodsname,'goodstype':goodstype};

     $.ajax({
          //请求地址
         url:'users?flag=add',
         //请求参数
         data:data,
         // 请求方式
         type:'POST',
         //成功回调
         success: function(results){
             console.log(results);
             if(results=='true'){
             alert("添加成功！");
             findAll();
             }else{
            	 alert("添加失败！");
             }
         }
     });	 
 }
function updateGoods(){
	 //获取表单数据
     var goodsname = $("#goodsname").val().trim();
     var goodstype = $("#goodstype").val().trim();
     var goodsid = $("#goodsid").val().trim();

     //请求的参数
     var data = {'goodsname':goodsname,'goodstype':goodstype, 'goodsid': goodsid};

     $.ajax({
          //请求地址
         url:'users?flag=update',
         //请求参数
         data:data,
         // 请求方式
         type:'POST',
         //成功回调
         success: function(results){
             console.log(results);
             if(results=='true'){
             alert("更新成功！");
             findAll();
             }else{
            	 alert("更新失败！");
             }
      
         }
     });	 
 }
 
 
function deleteGoods(id){
	 var data = {'goodsid': id}; 
	$.ajax({
        //请求地址
       url:'users?flag=del',
       //请求参数
       data:data,
       // 请求方式
       type:'GET',
       //成功回调
       success: function(results){
           console.log(results);
           if(results=='true'){
           alert("删除成功！");
           findAll();
           }else{
          	 alert("删除失败！");
           }
    
       }
   });	 

	 
 }

 
function findAll(){
	$.get({
		    url:"users?flag=all", //请求的url地址
		    success:function(results){
		        //请求成功时处理
				
				//看下返回的结果
				console.log(results);
				//把字符串转成对象
		        var data = JSON.parse(results);
				
			    //创建表格
			     $("#table").empty();
			    //创建表头
			    $("#table").append("<tr><td>商品ID</td><td>商品名称</td><td>商品类型</td><td>修改商品</td><td>删除商品</td>");
				//创建表格内容
              for( var i = 0; i < data.length; i++ ) {
                //TODO 动态创建一个tr行标签,并且转换成jQuery对象
                var trTemp = $("<tr></tr>");
                console.log(data[i]);
                //TODO 往行里面追加 td单元格
                trTemp.append("<td>"+ data[i].goodsid +"</td>");
                trTemp.append("<td>"+ data[i].goodsname +"</td>");
                trTemp.append("<td>"+ data[i].goodstype +"</td>");
                trTemp.append("<td><button class='update'> 修改商品 </button></td>");
                trTemp.append("<td><button class='remove' id='" + data[i].goodsid + "'> 删除商品</button></td>");
                //TODO 往表格里面追加行
                $("#table").append(trTemp);
              
            }
			
		    }
		});
}