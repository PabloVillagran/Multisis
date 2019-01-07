var xOffset = -250;

(function($) {//src = https://stackoverflow.com/questions/3837037/div-with-scrollbar-inside-div-with-positionfixed 
  $.fn.innerstaticHeight = function() {
        var heightOfOuterfixed = $('.content').height(),
        offset = $('.content>div').offset(),
        topOfInnerDiv = offset.top,
        potentialHeight = (topOfInnerDiv + heightOfOuterfixed );

        $('.content>div').css('height',potentialHeight);
  }
})(jQuery);


(function($) {
	$.fn.innerstaticWidth = function(dif){
		var widthOfOuterfixed = $('.content').width(),
		offset = $('.content>div').offset(),
		leftOfInnerDiv = offset.left,
		potentialWidth = widthOfOuterfixed + dif;
		
		$('.content>div').css('width', potentialWidth);
	}
})(jQuery);


$(document).ready(function(){
	
	var descripcion = $('#desc').text();
	
	$('.ui-menuitem-link').each(function(){
		if($(this).text().indexOf(descripcion) != -1) {
			$(this).addClass('active');
			return false;
		}
	});

	$('.content>div').innerstaticHeight();
	$('.content>div').innerstaticWidth(-250);

});


//src = https://codepen.io/jasonhowmans/pen/dykhL
(function() {
	var $body = document.body
	, $menu_trigger = $body.getElementsByClassName('menu-toggler')[0];

	if ( typeof $menu_trigger !== 'undefined' ) {
		$menu_trigger.addEventListener('click', function() {
			if($body.className == 'menu-active'){
				$body.className = '';
				xOffset = -20;
			}
			else{
				$body.className = 'menu-active';
				xOffset = -250;
			}
			$('.content>div').innerstaticWidth(xOffset);
//			$body.className = ( $body.className == 'menu-active' )? '' : 'menu-active';
		});
	}

}).call(this);
//end src = https://codepen.io/jasonhowmans/pen/dykhL


//resize code! src=https://stackoverflow.com/questions/5489946/jquery-how-to-wait-for-the-end-of-resize-event-and-only-then-perform-an-ac
var rtime;
var timeout = false;
var delta = 200;
$(window).resize(function() {
    rtime = new Date();
    if (timeout === false) {
        timeout = true;
        setTimeout(resizeend, delta);
    }
});

function resizeend() {
    if (new Date() - rtime < delta) {
        setTimeout(resizeend, delta);
    } else {
        timeout = false;
        $('.content>div').innerstaticWidth(xOffset);
    }
}
//endresize

function goHome(){
	$('#homeHeader-homeLink').trigger('click');
}