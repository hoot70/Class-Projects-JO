$('#myButton').click(function(){
    var text = $('#listitem');
    $('ul').append('<li>' + text.val() + '</li>');
    $('#listitem').val('')

    $('li').click(function(){
        $(this).css('text-decoration', 'line-through');
        $(this).delay(1000).hide(1000);
    })

});