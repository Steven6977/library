$(document).ready(function() {
    $('#name').addClass("validate[required,maxSize[50]] text-input");
    $('#email').addClass("validate[required,custom[email]] text-input");
    
    var type = $('#type').val();
    $("#type option").each(function() {
        this.selected = (this.value === type);
    });
    
    $('#editUserForm').validationEngine({
        promptPosition : 'topRight'
    });

    $('#editUser').click(function() {
        $('#editUserForm').attr('action', "userManagement.action?operation=save");
        $('#editUserForm').submit();
    });
});
