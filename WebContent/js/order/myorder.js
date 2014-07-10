$(document).ready(function() {
	var oTable = $('#example').dataTable({
		"sPaginationType" : "full_numbers",
		"bProcessing" : true,
		"sAjaxSource" : "querydata?type=myorder",
		"sPagination" : true,
		aoColumns : [{
			"mData" : "name"
		}, {
			"mData" : "author"
		}, {
			"mData" : "publisher"
		},{
			"mData" : "borrowdate"
		}, {
			"mData" : "returndate"
		}],
		"oLanguage" : {
			"sZeroRecords" : "对不起,没有相关记录可以显示"
		}
	});
});
