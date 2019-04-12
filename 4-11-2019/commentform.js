$('#submit').click(function(){
    const name = $('#name');
    const email = $('#email');
    const phone = $('#phone');
    var required = [name, email, phone];

    for (var i = 0; i < required.length; i++){
        if (required[i].val() === ''){
            $('p#message').html("Please Fill Out Required Fields").addClass('warning');
            required[i].prev().addClass('warning');
        }
        if (required[i].val() !==''){
            required[i].prev().removeClass('warning');
        }
    }

    if (!$("#form").hasClass('warning')){
        $('.form-container').remove();
        $('h2').html('Thanks for your feedback');
    }

})