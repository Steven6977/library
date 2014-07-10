$(document).ready(function() {
    $('#oldpassword').addClass("validate[required,minSize[5],maxSize[20],ajax[ajaxPasswordCall]] text-input");
    $('#newpassword').addClass("validate[required,minSize[5],maxSize[20]] text-input");
    $('#repeatpassword').addClass("validate[required,minSize[5],maxSize[20],equals[newpassword]] text-input");
    $('#modifyPasswordForm').validationEngine({
        promptPosition : 'topRight'
    });
    $('#savePassword').click(function() {
        $('#modifyPasswordForm').attr('action', "userManagement.action?operation=password");
        $('#modifyPasswordForm').submit();
    });

});
