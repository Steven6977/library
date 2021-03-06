$(document).ready(function() {

    $('#name').addClass("validate[required,maxSize[100]] text-input");
    $('#author').addClass("validate[required,maxSize[100]] text-input");
    $('#publisher').addClass("validate[required,maxSize[100]] text-input");

    $('#saveBookForm').validationEngine({
        promptPosition : 'topRight'
    });

    $('#saveBook').click(function() {
        $('#saveBookForm').attr('action', "bookManagement.action?operation=new");
        $('#saveBookForm').submit();
    });
});