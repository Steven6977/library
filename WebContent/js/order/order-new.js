$(document).ready(function() {

    var oTable = $('#example').dataTable({
        "sPaginationType" : "full_numbers",
        "bProcessing" : true,
        "sAjaxSource" : "querydata?type=ava_book",
        "sPagination" : true,
        aoColumns : [{
            "sDefaultContent" : "",
            "bUseRendered" : false,
            "fnRender" : function(o, v) {// o, v contains the object and value for the column
                return '<input type="checkbox" id="' + o.aData.id + '" name="someCheckbox" value = "' + o.aData.name + '"/>';
            }
        }, {
            "mData" : "name"
        }, {
            "mData" : "author"
        }, {
            "mData" : "publisher"
        }, ]

    });

    $('#useraccount').addClass("validate[required,maxSize[20],ajax[ajaxOrderUserAccountCall]] text-input");
 //   $('#bookname').addClass("validate[required,maxSize[20],ajax[ajaxOrderBookNameCall]] text-input");

    $('#saveOrderForm').validationEngine({
        promptPosition : 'topRight'
    });

    $('#saveOrder').click(function() {
        var c = $('input:checked', oTable.fnGetNodes());
        var url = "orderManagement.action?operation=new";
        if(c.length == 0){
            alert("请选择要借的书籍");
            return ;
        }
        for(var i = 0; i < c.length; i++){
            url += "&bookIds=" + c[i].id;
        }
        
        $('#saveOrderForm').attr('action', url);
        $('#saveOrderForm').submit();
    });
});
