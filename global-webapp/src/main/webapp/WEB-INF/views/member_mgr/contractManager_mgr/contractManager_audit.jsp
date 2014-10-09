<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!-- 引入国际化标签 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div method="post" >
  <form  method="post" style="padding:15px">
    <table class="formtable">
		<tr>
			<td>合同类型：</td>
			<td>
				<input id="withdrawSet_mgr_withdrawSet_form_withdrawSetMinimum" name="contractTypeName"  class="easyui-validatebox spinner" style="width:298px;height: 16px;" required="true" maxlength="50" value="${contractManagerData.contractTypeName}" readonly="readonly"/>
			</td>
		</tr>
		<tr>
			<td>合同状态：</td>
			<td>
   
                   <c:if test="${contractManagerData.status=='enable'}">
                         <input  class="easyui-validatebox spinner" style="width:298px;height: 16px;" required="true" maxlength="50" value="启用" readonly="readonly"/>
                   </c:if>
                   <c:if test="${contractManagerData.status=='disable'}">
                         <input  class="easyui-validatebox spinner" style="width:298px;height: 16px;" required="true" maxlength="50" value="禁用" readonly="readonly"/>
                   </c:if>					
			</td>
		</tr>
		<tr>
			<td>合同有效期限：</td>
			<td>
			  <input id="contractManager_mgr_contractManager_form_timeLimit" name="timeLimit" value="${contractManagerData.timeLimit}"  class="easyui-numberbox spinner"  style="height:18px;width:300px"  readonly="readonly"/>
			</td>
		</tr>
		<tr>
			<td>启用(禁用)设置：</td>
			<td><input type="hidden" id="contractManager_mgr_contractManager_form_contractTypeId" name="contractTypeId" value="${contractManagerData.contractTypeId}" />
			   <input id="contractManager_mgr_contractManager_form_auditState" name="status" type="radio" value="enable" /><span>启用</span>
			   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			   <input id="contractManager_mgr_contractManager_form_auditState" name="status" type="radio" value="disable" /><span>禁用</span></td>
		</tr>
		<tr>
			<td>审核说明：</td>
			<td>
				<textarea name="remark" style="width:298px;" maxlength="255" class="spinner formta">${contractManagerData.remark}</textarea>
			</td>
		</tr>
	</table>
   </form>	
</div>


<script type="text/javascript">
   
    //审核按钮初始化
	if(${contractManagerData.status == 'enable'}){
		document.all("contractManager_mgr_contractManager_form_auditState")[0].checked=true;
	}else{
		document.all("contractManager_mgr_contractManager_form_auditState")[1].checked=true;
	} 
	
 </script>
 


 