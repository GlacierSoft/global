<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<!-- 引入自定义权限标签 -->
<%@ taglib prefix="glacierui"
	uri="http://com.glacier.permissions.com.cn/tag/easyui"%>

<script type="text/javascript">
	$.util.namespace('glacier.carrier_mgr.carrierContract_mgr.carrierContract');//自定义命名空间，相当于一个唯一变量(推荐按照webapp目录结构命名可避免重复)

	//定义toolbar的操作，对操作进行控制
	glacier.carrier_mgr.carrierContract_mgr.carrierContract.param = {
		toolbarId : 'carrierContractDataGrid_toolbar',
		actions : {
             edit:{flag:'edit',controlType:'single'},
             del:{flag:'del',controlType:'multiple'}
          }
     };

	//初始化客服DataGrid
	glacier.carrier_mgr.carrierContract_mgr.carrierContract.carrierContractDataGrid = $('#carrierContractDataGrid').datagrid({
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
 						url : ctx + '/do/carrierContract/list.json',
						sortName : 'createTime',//排序字段名称
						sortOrder : 'DESC',//升序还是降序
						remoteSort : true,//开启远程排序，默认为false
						idField : 'contractRecordId',
						columns : [ [ {
							field : 'contractRecordId',
							title : 'ID',
							checkbox : true
						}, {
							field : 'deliverId',
							title : '配送货物',
							width : 120,
							sortable : true
						}, {
							field : 'carrierDisplay',
							title : '承运商(乙方)',
							width : 120,
							sortable : true
						}, {
							field : 'platformId',
							title : '平台方(甲方)',
							width : 120,
							sortable : true,
						}, {
							field : 'contractTypeDisplay',
							title : '合同类型',
							width : 120,
							sortable : true,
						},  {
							field : 'status',
							title : '合同状态',
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
							field : 'enableTime',
							title : '合同生效时间',
							width : 120,
							sortable : true
						}, {
							field : 'disableTime',
							title : '合同失效时间',
							width : 140,
							sortable : true,
						}, {
							field : 'createrDisplay',
							title : '创建人',
							sortable : true,
							width : 120
						}, {
							field : 'createTime',
							title : '创建时间',
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
						} , {
							field : 'remark',
							title : '备注',
							sortable : true,
							width : 120
						}] ],
						pagination : true,//True 就会在 datagrid 的底部显示分页栏
						pmemberSize : 10,//注意，pmemberSize必须在pmemberList存在
						pmemberList : [ 2, 10, 50, 100 ],//从session中获取
						rownumbers : true,//True 就会显示行号的列
						toolbar : '#carrierContractDataGrid_toolbar',
						onCheck : function(rowIndex, rowData) {//选择行事件触发
							action_controller(
									glacier.carrier_mgr.carrierContract_mgr.carrierContract.param,this).check();
						},
						onCheckAll : function(rows) {//取消勾选行状态触发事件
							action_controller(
									glacier.carrier_mgr.carrierContract_mgr.carrierContract.param,this).check();
						},
						onUncheck : function(rowIndex, rowData) {//选择行事件触发
							action_controller(
									glacier.carrier_mgr.carrierContract_mgr.carrierContract.param,this).unCheck();
						},
						onUncheckAll : function(rows) {//取消勾选行状态触发事件
							action_controller(
									glacier.carrier_mgr.carrierContract_mgr.carrierContract.param,this).unCheck();
						},
						onSelect : function(rowIndex, rowData) {//选择行事件触发
							action_controller(
									glacier.carrier_mgr.carrierContract_mgr.carrierContract.param,this).select();
						},
						onUnselectAll : function(rows) {
							action_controller(
									glacier.carrier_mgr.carrierContract_mgr.carrierContract.param,this).unSelect();
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
								title : '【' + rowData.carrierDisplay + '-'+rowData.platformId+'】合同详细信息',
								href : ctx+ '/do/carrierContract/intoDetail.htm?contractRecordId='+ rowData.contractRecordId,//从controller请求jsp页面进行渲染
								width : 560,
								height : 360,
								resizable : false,
								enableApplyButton : false,
								enableSaveButton : false
							});
						}
					});
	
	  glacier.carrier_mgr.carrierContract_mgr.carrierContract.expContractorManager=function(){
		   location.href=ctx + '/do/carrierContract/exp.json';    
	  };
	
	//状态下拉项
	$('#bankCardSearchForm_status').combobox({
			valueField : 'value',
			//height:18,
			width : 80,
			textField : 'label',
			panelHeight : 'auto',
			editable : false,
			//required:true,
			data : fields.status
		});
	
</script>

<!-- 所有客服列表面板和表格 -->
<div class="easyui-layout" data-options="fit:true">
	<div id="carrierContractGridPanel" data-options="region:'center',border:true">
		<table id="carrierContractDataGrid">
			<glacierui:toolbar panelEnName="CarrierContractList"
				toolbarId="carrierContractDataGrid_toolbar" menuEnName="carrierContract" />
			<!-- 自定义标签：自动根据菜单获取当前用户权限，动态注册方法 -->
		</table>
	</div>
	<div data-options="region:'north',split:true"
		style="height: 40px; padding-left: 10px;">
		<form id="carrierContractSearchForm">
			<table>
				<tr>
					<td>承运商名称：</td>
					<td><input name="carrierDisplay" style="width: 80px;"
						class="spinner" /></td>
					<td>合同状态：</td>
					<td>
					    <input id="bankCardSearchForm_status" name="status" style="width: 80px;" class="spinner"/>
					</td>
					<td>生效时间：</td>
					<td><input name="contractTypeStartTime" class="easyui-datetimebox"
						style="width: 100px;" /> - <input name="contractTypeEndTime"
						class="easyui-datetimebox" style="width: 100px;" /></td>
					<td>失效时间：</td>
					<td><input name="contractRemoveStartTime" class="easyui-datetimebox"
						style="width: 100px;" /> - <input name="contractTypeRemoveEndTime"
						class="easyui-datetimebox" style="width: 100px;" /></td>
					<td><a href="javascript:void(0);" class="easyui-linkbutton"
						data-options="iconCls:'icon-standard-zoom-in',plain:true"
						onclick="glacier.carrier_mgr.carrierContract_mgr.carrierContract.carrierContractDataGrid.datagrid('load',glacier.serializeObject($('#carrierContractSearchForm')));">查询</a>
						<a href="javascript:void(0);" class="easyui-linkbutton"
						data-options="iconCls:'icon-standard-zoom-out',plain:true"
						onclick="$('#carrierContractSearchForm input').val('');glacier.carrier_mgr.carrierContract_mgr.carrierContract.carrierContractDataGrid.datagrid('load',{});">重置条件</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>