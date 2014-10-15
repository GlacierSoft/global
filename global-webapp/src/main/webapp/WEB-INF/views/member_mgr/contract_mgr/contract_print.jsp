<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!-- 引入国际化标签 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%    
String path = request.getContextPath();    
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";    
%>


<script language="javascript" src="<%=basePath %>resources/js/lodop/LodopFuncs.js"></script>
<object  id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0> 
       <embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0></embed>
</object>

<form id="form1">
<table border="1" width="360" height="220" style="border-collapse:collapse;border:solid 1px" bordercolor="#000000">
  <tr>
    <td width="100%" height="240">
      <p align="center"> 
      <font face="隶书" size="5" style="letter-spacing: 10px">${contractData.goodsId}</font>
      <p align="center"><font face="宋体" size="3">科学家</font></p>
      <p align="left"><font face="宋体" size="3">　地址：中国北京社会科学院附近东大街西胡同</font></p>
      <p align="left"><font face="宋体" size="3">　电话：010-88811888</font></p>
      <p><br>      　
      </p>
    </td>
  </tr>
</table>
</form>
<script type="text/javascript">
   
	var LODOP; //声明为全局变量  
   
   $(function(){ 
	   $('#spread_dialog').dialog('close');
	     if('${str}'=="preview_print"){
	    	 CreateOneFormPage();	
	    	 LODOP.PREVIEW(); 
	     }else if('${str}'=="direct_print"){
	    	CreateOneFormPage();
	 		LODOP.PRINT();
	    }else if('${str}'=="design_print"){
	    	CreateTwoFormPage();
			LODOP.PRINT_SETUP();
	    	 
	     }else if('${str}'=="choose_print"){
	    	CreateOneFormPage();
	 		LODOP.PRINTA(); 
	     }
	 } );
   
	 function CreateOneFormPage(){
		LODOP=getLodop();  
		LODOP.PRINT_INIT("打印控件功能演示_Lodop功能_表单一");
		LODOP.SET_PRINT_STYLE("FontSize",18);
		LODOP.SET_PRINT_STYLE("Bold",1);
		LODOP.ADD_PRINT_TEXT(50,231,260,39,"打印页面部分内容");
		LODOP.ADD_PRINT_HTM(88,200,350,600,document.getElementById("form1").innerHTML);
		LODOP.SET_PREVIEW_WINDOW(0,0,0,760,540,"");
	 };	
	 
	 function CreateTwoFormPage(){
			LODOP=getLodop();  
			LODOP.PRINT_INIT("打印控件功能演示_Lodop功能_表单二");
			LODOP.ADD_PRINT_RECT(70,27,634,242,0,1);
			LODOP.ADD_PRINT_TEXT(29,236,279,38,"页面内容改变布局打印");
			LODOP.SET_PRINT_STYLEA(2,"FontSize",18);
			LODOP.SET_PRINT_STYLEA(2,"Bold",1);
			LODOP.ADD_PRINT_HTM(88,40,321,185,document.getElementById("form1").innerHTML);
			LODOP.ADD_PRINT_TEXT(319,58,500,30,"注：其中《表单一》按显示大小，《表单二》在程序控制宽度(285px)内自适应调整");
		};  
   
</script>
	

