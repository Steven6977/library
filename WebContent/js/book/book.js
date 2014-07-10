function del(id) {
    var r = confirm("确认删除?");
    if (r == true) {
        $.post("validate?operation=checkDeleteBook", {
            id : id
        }, function(flag) {
            if (flag == "false") {
                $('#delBookForm').attr('action', "bookManagement.action?operation=delete&id=" + id);
                $('#delBookForm').submit();
            } else {
                alert("此书有借阅记录,无法删除");
            }
        });
    }
}


$(document).ready(function() {


    var oTable = $('#example').dataTable({
        "sPaginationType" : "full_numbers",
        "bProcessing" : true,
        "sAjaxSource" : "querydata?type=book",
        "sPagination" : true,
        aoColumns : [{
            "mData" : "name"
        }, {
            "mData" : "author"
        }, {
            "mData" : "publisher"
        }, {
            "mData" : "stateCN"
        }, {
            "bSearchable" : false,
            "bSortable" : false,
            "sDefaultContent" : "",
            "fnRender" : function(oObj) {
                return "<a href='bookManagement.action?operation=edit&id=" + oObj.aData.id + "'>修改</a>  <a href='javascript:;' onclick='del(" + oObj.aData.id + ")'>删除</a>";
            },
            "bUseRendered" : false
        }]

    });
});
