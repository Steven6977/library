$(document).ready(function() {
    var id = $('#id').val();
    $('#name').addClass("validate[required,maxSize[100]] text-input");
    $('#author').addClass("validate[required,maxSize[100]] text-input");
    $('#publisher').addClass("validate[required,maxSize[100]] text-input");

    $('#editBookForm').validationEngine({
        promptPosition : 'topRight'
    });

    $('#editBook').click(function() {
        $('#editBookForm').attr('action', "bookManagement.action?operation=save&id=" + id);
        $('#editBookForm').submit();
    });
}); 