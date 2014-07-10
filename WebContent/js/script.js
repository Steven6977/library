$(document).ready(function() {
	
	// Center the module.
	$(window).resize(function() {
		$('.centerModule').each(function() {
			var w = $(window).width() - $(this).width();
			var h = $(window).height() - $(this).height();
			$(this).css({
				position: 'absolute',
				left: w / 2,
				top: Math.max(h / 2, 130)
			});
		});
	});
	
	$(window).trigger('resize');
	
	// Handle button submit and clear
	$('.formButton').click(function() {
		var id = $(this).attr('id').replace('tsb_', '');
		var form = $(this).parents('form').eq(0);
		$('#' + id, form).trigger('click');
	});
	
	
	$('.content table tr').each(function(idx) {
		if (idx % 2 == 0) {
			$(this).addClass('even');
		}
		$('td:last, th:last', $(this)).css({
			borderRight: 'none'
		});
	}).hover(
		function() {
			if ($(this).find('td').length > 0) {
				$(this).addClass('hover');
			}
		},
		function() {
			$(this).removeClass('hover');
		}
	);
	
	$('div.moduleHeader').each(function() {
		var indicator = $(this).find('.indicator');
		if (indicator.length > 0) {
			$(this).css({
				cursor: 'pointer'
			});
			
			$(this).click(function() {
				var ind = $(this).find('.indicator');
				var p = $(this).parent();
				if (ind.hasClass('indicatorOff')) {
					$('.content, .moduleLeft, .moduleRight, .moduleBottom', p).addClass('hide');
					ind.removeClass('indicatorOff');
				} else {	
					$('.content, .moduleLeft, .moduleRight, .moduleBottom', p).removeClass('hide');
					ind.addClass('indicatorOff');
				}
			});
		}
	});
	/* used for static html , drop it
	$('div.moduleHeader a').click(function(e) {
		e.preventDefault();
		e.stopImmediatePropagation();
		e.stopPropagation();
		var url = $(this).attr('href');
		window.location.href = url;
	});
	*/
	$('.deleteButton').click(function() {
		var background = $('.modal');
		if (background.length <= 0) {
			background = $('<div class="modal hide"></div>');
			$('body').append(background);
		}
		if ($('#closeConfirm').length <= 0) {
			var html = $('<div id="closeConfirm" class="module centerModule popup hide"><div class="moduleHeader"><div class="bkl"></div><div class="bkr"></div><h2>Delete User Case</h2></div><div class="moduleLeft"></div><div class="moduleRight"></div><div class="moduleBottom"></div><div class="content"><div class="row">Are you sure you want to delete User Case "[UserCaseID]"?</div><div class="bottomBar"><div class="buttonBarInside"><a href="javascript:;" id="deleteBtn" class="button"><span><span>Delete</span></span></a><a href="javascript:;" id="cancelBtn" class="button"><span><span>Cancel</span></span></a></div></div></div>');
			$('body').append(html);
			
			html.find('.bottomBar a').click(function() {
				// TODO: Delete or cancel
				unloadModal();
			});
		}
		
		var wp = $(this).parents('.module').eq(0);
		var header = wp.find('div.moduleHeader h2').text().replace(' List', '');
		
		var confirmPop = $('#closeConfirm');
		confirmPop.find('div.moduleHeader h2').text('Delete ' + header);
		var uid = $(this).parent().parent().find('td').eq(0).text();
		confirmPop.find('.content .row').text('Are you sure you want to delete ' + header + ' "' + uid + '"?');
		
		loadModal('closeConfirm');
	});
	
	$('.enableBtn, .disableBtn').click(function() {
		if ($(this).hasClass('on')) {
			return;
		}
		
		var p = $(this).parent();
		$('.on', p).removeClass('on');
		$(this).addClass('on');
	});
	
	$('input[name="hasStage"]:radio').change(function() {
		var value = $(this).val();
		var prRow = $(this).parents('.content').eq(0).find('.prRow');
		prRow.find('.subrow').hide();
		prRow.find('.' + value).show();
	});
	$('input[name="hasStage"]:checked').trigger('change');
});



function loadModal(id) {
	var background = $('.modal');
	background.removeClass('hide');
	$('#' + id).removeClass('hide');
	
	$(window).trigger('resize');
}

function unloadModal() {
	$('.modal').addClass('hide');
	$('.popup').addClass('hide');
}