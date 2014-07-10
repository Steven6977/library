$(document).ready(function() {

    $('#name').addClass("validate[required,maxSize[50]] text-input");
    $('#useraccount').addClass("validate[required,minSize[5],maxSize[20],ajax[ajaxUserAccountCall]] text-input");
    $('#password').addClass("validate[required,minSize[5],maxSize[20]] text-input");
    $('#email').addClass("validate[required,custom[email]] text-input");

    $('#saveUserForm').validationEngine({
        promptPosition : 'topRight'
    });

    $('#saveUser').click(function() {
        $('#saveUserForm').attr('action', "userManagement.action?operation=new");
        $('#saveUserForm').submit();
    });
}); 