function del(id) {
    var r = confirm("确认删除记录?");
    if (r == true) {
        $('#delOrderForm').attr('action', "orderManagement.action?operation=delete&id=" + id);
        $('#delOrderForm').submit();
    }
}

function ret(id) {
    var r = confirm("确认归还?");
    if (r == true) {
        $('#delOrderForm').attr('action', "orderManagement.action?operation=ret&id=" + id);
        $('#delOrderForm').submit();
    }
}


$(document).ready(function() {
    var oTable = $('#example').dataTable({
        "sPaginationType" : "full_numbers",
        "bProcessing" : true,
        "sAjaxSource" : "querydata?type=order",
        "sPagination" : true,
        aoColumns : [{
            "mData" : "username"
        }, {
            "mData" : "bookname"
        }, {
            "mData" : "borrowdate"
        }, {
            "mData" : "returndate"
        }, {
            "bSearchable" : false,
            "bSortable" : false,
            "sDefaultContent" : "",
            "fnRender" : function(oObj) {
                if (oObj.aData.ifreturn == 1) {
                    return "<a href='javascript:;' onclick='del(" + oObj.aData.id + ")'>删除记录</a>";
                } else {
                    return "<a href='javascript:;' onclick='ret(" + oObj.aData.id + ")'>归还</a>";
                }

            },
            "bUseRendered" : false
        }]

    });
});
