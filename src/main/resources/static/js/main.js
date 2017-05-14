/**
 * 
 */
$(function() {
    $('#messages li').click(function() {
        $(this).fadeOut();
    });
    setTimeout(function() {
        $('#messages li.info').fadeOut();
    }, 3000);
    $(".dobMask").mask("99/99/9999",{placeholder:"dd/mm/yyyy"});
});