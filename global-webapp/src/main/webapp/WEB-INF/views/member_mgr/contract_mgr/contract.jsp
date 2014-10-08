<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<!-- 引入自定义权限标签 -->
<%@ taglib prefix="glacierui"
	uri="http://com.glacier.permissions.com.cn/tag/easyui"%>

<script type="text/javascript">
	$.util.namespace('glacier.member_mgr.contract_mgr.contract');//自定义命名空间，相当于一个唯一变量(推荐按照webapp目录结构命名可避免重复)

	//定义toolbar的操作，对操作进行控制
	glacier.member_mgr.contract_mgr.contract.param = {
		toolbarId : 'contractDataGrid_toolbar',
		actions : {
             edit:{flag:'edit',controlType:'single'},
             del:{flag:'del',controlType:'multiple'}
          }
     };

	//初始化客服DataGrid
	glacier.member_mgr.contract_mgr.contract.contractDataGrid = $('#contractDataGrid').datagrid({
						fit : true,//控件自动resize占满窗口大小
						iconCls : 'icon-save',//图标样式
						border : false,//是否存在边框
						fitColumns : false,//自动填充行
						nowrap : true,//禁止单元格中的文字自动换行
						autoRowHeight : false,//禁止设置自动行高以适应内容
						striped : true,//true就是把行条纹化。（即奇偶行使用不同背景色）
						singleSelect : true,//限制单选
						checkOnSelect : false,//选择复选框的时候选择该行
						selectOnCheck : false,//选择的时候复选框打勾
						url : ctx + '/do/contract/list.json',
						sortName : 'createTime',//排序字段名称
						sortOrder : 'DESC',//升序还是降序
						remoteSort : true,//开启远程排序，默认为false
						idField : 'contractRecordId',
						columns : [ [ {
							field : 'contractRecordId',
							title : 'ID',
							checkbox : true
						}, {
							field : 'goodsDisplay',
							title : '货物名称',
							width : 120,
							sortable : true
						}, {
							field : 'memberDisplay',
							title : '会员名称(乙方)',
							width : 120,
							sortable : true
						}, {
							field : 'platformDisplay',
							title : '平台名称(甲方)',
							width : 120,
							sortable : true,
						}, {
							field : 'typeDisplay',
							title : '合同类型',
							width : 120,
							sortable : true,
						},  {
							field : 'status',
							title : '状态',
							width : 120,
							sortable : true,
							formatter : function(value, row, index) {//数据格式化
								return renderGridValue(value, fields.status);
							}
						}, {
							field : 'contractContent',
							title : '合同内容',
							width : 120,
							sortable : true,
						}, {
							field : 'operationTime',
							title : '合同生效时间',
							width : 120,
							sortable : true
						}, {
							field : 'closeTime',
							title : '合同失效时间',
							width : 140,
							sortable : true,
						}, {
							field : 'remark',
							title : '备注',
							sortable : true,
							width : 120
						}, {
							field : 'createrDisplay',
							title : '录入人',
							sortable : true,
							width : 120
						}, {
							field : 'createTime',
							title : '录入时间',
							sortable : true,
							width : 200
						}, {
							field : 'updaterDisplay',
							title : '更新人',
							sortable : true,
							width : 120
						}, {
							field : 'updateTime',
							title : '更新时间',
							sortable : true,
							width : 200
						} ] ],
						pagination : true,//True 就会在 datagrid 的底部显示分页栏
						pmemberSize : 10,//注意，pmemberSize必须在pmemberList存在
						pmemberList : [ 2, 10, 50, 100 ],//从session中获取
						rownumbers : true,//True 就会显示行号的列
						toolbar : '#contractDataGrid_toolbar',
						onCheck : function(rowIndex, rowData) {//选择行事件触发
							action_controller(
									glacier.member_mgr.contract_mgr.contract,this).check();
						},
						onCheckAll : function(rows) {//取消勾选行状态触发事件
							action_controller(
									glacier.member_mgr.contract_mgr.contract,this).check();
						},
						onUncheck : function(rowIndex, rowData) {//选择行事件触发
							action_controller(
									glacier.member_mgr.contract_mgr.contract.param,this).unCheck();
						},
						onUncheckAll : function(rows) {//取消勾选行状态触发事件
							action_controller(
									glacier.member_mgr.contract_mgr.contract.param,this).unCheck();
						},
						onSelect : function(rowIndex, rowData) {//选择行事件触发
							action_controller(
									glacier.member_mgr.contract_mgr.contract.param,this).select();
						},
						onUnselectAll : function(rows) {
							action_controller(
									glacier.member_mgr.contract_mgr.contract.param,this).unSelect();
						},
						onLoadSuccess : function(index, record) {//加载数据成功触发事件
							$(this).datagrid('clearSelections');
							$(this).datagrid('clearChecked');
							var rows=$(this).datagrid("getRows");
							if(rows.length==0){   
								var body = $(this).data().datagrid.dc.body2;
								body.find('table tbody').append('<tr><td width="' + body.width() + '" style="height: 25px; text-align: center;color:red">暂时没有记录</td></tr>');
							}
						},
						onDblClickRow : function(rowIndex, rowData){
                        $.easyui.showDialog({
								title : '【' + rowData.memberDisplay + '-'+rowData.platformDisplay+'】合同详细信息',
								href : ctx+ '/do/contract/intoDetail.htm?contractRecordId='+ rowData.contractRecordId,//从controller请求jsp页面进行渲染
								width : 655,
								height : 470,
								resizable : false,
								enableApplyButton : false,
								enableSaveButton : false
							});
						}
					});
</script>

<!-- 所有客服列表面板和表格 -->
<div class="easyui-layout" data-options="fit:true">
	<div id="contractGridPanel" data-options="region:'center',border:true">
		<table id="contractDataGrid">
			<glacierui:toolbar panelEnName="ContractList"
				toolbarId="contractDataGrid_toolbar" menuEnName="member" />
			<!-- 自定义标签：自动根据菜单获取当前用户权限，动态注册方法 -->
		</table>
	</div>
	<div data-options="region:'north',split:true"
		style="height: 40px; padding-left: 10px;">
		<form id="contractSearchForm">
			<table>
				<tr>
					<td>货物名称：</td>
					<td><input name="goodsName" style="width: 80px;"
						class="spinner" /></td>
					<td>会员名称：</td>
					<td><input name="memberName" style="width: 80px;"
						class="spinner" /></td>
					<td>类型：</td>
					<td><input id="contract_type" name="type"
						style="width: 80px;" class="spinner" /></td>
					<td>生效时间：</td>
					<td><input name="contractStartTime" class="easyui-datetimebox"
						style="width: 100px;" /> - <input name="contractEndTime"
						class="easyui-datetimebox" style="width: 100px;" /></td>
					<td>失效时间：</td>
					<td><input name="contractRemoveStartTime" class="easyui-datetimebox"
						style="width: 100px;" /> - <input name="contractRemoveEndTime"
						class="easyui-datetimebox" style="width: 100px;" /></td>
					<td><a href="javascript:void(0);" class="easyui-linkbutton"
						data-options="iconCls:'icon-standard-zoom-in',plain:true"
						onclick="glacier.member_mgr.contract_mgr.contract.contractDataGrid.datagrid('load',glacier.serializeObject($('#contractSearchForm')));">查询</a>
						<a href="javascript:void(0);" class="easyui-linkbutton"
						data-options="iconCls:'icon-standard-zoom-out',plain:true"
						onclick="$('#contractSearchForm input').val('');glacier.member_mgr.contract_mgr.contract.contractDataGrid.datagrid('load',{});">重置条件</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>