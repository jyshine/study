// JavaScript Document

// top 버튼
function moveTop() {
	$(window).scroll(function () {
		if ($(this).scrollTop() > 50) {
			$('#back-to-top').fadeIn();
		} else {
			$('#back-to-top').fadeOut();
		}
	});
	$('#back-to-top').click(function () {
		$('#back-to-top').tooltip('hide');
		$('body,html').animate({
			scrollTop: 0
		}, 800);
		return false;
	});
	$('#back-to-top').tooltip('show');
}

//Date picker
function dataPicker() {
	$('.btDtpicker').datepicker({
		changeMonth: true,
		changeYear: true,
		autoclose: true,
		format: "yyyy-mm-dd",
		language: 'kr'

	});
}

function selectboxChange() {
	$("#getCode").each(function(){
		var str = "";
		$(this).children( "option:selected" ).each(function() {
			str += $( this ).text() + " ";
		});
		$(this).siblings('span').children('strong').text( str );
	});
}

function popupModal() {
	/*var url = $(this).attr('data-url');*/
	$('.btn_modal').on('click', function(e){
		$('.modal').modal({
			remote : url
		});	
	});
}

$(document).ready(function () {
	moveTop();
	dataPicker();
})

$(window).on('load', function () {
	
	// 모바일 기기 접속 여부 체크 후 PC일때만 스크롤 mCustomScrollbar 실행
	var filter = "win16|win32|win64|mac|macintel";
	if (navigator.platform) {
		if (filter.indexOf(navigator.platform.toLowerCase()) < 0) {
			//alert('모바일');
			//테이블 스크롤  커스터마이징 해제
			$(".tbl_scroll, .tbl_scroll_sm, .tbl_scroll_md, .tbl_scroll_lg").off(mCustomScrollbar);
		} else {
			//alert('PC');
			//테이블 스크롤  커스터마이징
			$(".tbl_scroll_lg").mCustomScrollbar({
				axis: "x",
				theme: "dark-thin",
				advanced: {
					autoExpandHorizontalScroll: true
				}
			});
			$(".tbl_scroll, .tbl_scroll_sm, .tbl_scroll_md").mCustomScrollbar({
				axis: "x",
				theme: "dark-thin",
				advanced: {
					autoExpandHorizontalScroll: false
				}
			});
		}
	}
	
})