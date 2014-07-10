function del(id) {
    var r = confirm("确认删除?");
    if (r == true) {
        $.post("validate?operation=checkDeleteUser", {
            id : id
        }, function(flag) {
            if (flag == "false") {
                $('#delUserForm').attr('action', "userManagement.action?operation=delete&id=" + id);
                $('#delUserForm').submit();
            } else {
                alert("此账户有借阅记录,无法删除");
            }
        });
    }
}

function active(id) {
    $('#delUserForm').attr('action', "userManagement.action?operation=active&id=" + id);
    $('#delUserForm').submit();
}

function lock(id) {
    $('#delUserForm').attr('action', "userManagement.action?operation=lock&id=" + id);
    $('#delUserForm').submit();
}


$(document).ready(function() {

    var oTable = $('#example').dataTable({
        "sPaginationType" : "full_numbers",
        "bProcessing" : true,
        "sAjaxSource" : "querydata?type=user",
        "sPagination" : true,
        aoColumns : [{
            "mData" : "name"
        }, {
            "mData" : "useraccount"
        }, {
            "mData" : "email"
        }, {
            "mData" : "typeCN"
        }, {
            "mData" : "stateCN"
        }, {
            "bSearchable" : false,
            "bSortable" : false,
            "sDefaultContent" : "",
            "fnRender" : function(oObj) {
            	var str = "";
            	if (oObj.aData.state == '0')
            		str += "<a href='javascript:;' onclick='lock(" + oObj.aData.id + ")'>锁定</a> ";
                else
                	str += "<a href='javascript:;' onclick='active(" + oObj.aData.id + ")'>激活</a> ";
                
            	str += "<a href='userManagement.action?operation=edit&id=" + oObj.aData.id + "'>修改</a>  <a href='javascript:;' onclick='del(" + oObj.aData.id + ")'>删除</a>";
            	return str;
            },
            "bUseRendered" : false
        }]

    });
});
