$(document).ready(function() {
	// binds form submission and fields to the validation engine
		$('#useraccount').addClass(
				"validate[required,minSize[5],maxSize[20]] text-input");
		$('#password').addClass(
				"validate[required,minSize[5],maxSize[20]] text-input");
		$('#loginForm').validationEngine( {
			promptPosition : 'topRight'
		});
		$('#tsb_submit').click(function() {
			$('#loginForm').attr('action', "login.action");
			$('#loginForm').submit();
		});
	})