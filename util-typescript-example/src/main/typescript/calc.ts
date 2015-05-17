/// <reference path="typings/jquery/jquery.d.ts" />
/// <reference path="typings/entities.d.ts" />

$(document).ready(function(){
    $('#calcBtn').click(() => {
        var input = new ExampleApp.Input();
        input.arg1 = $('#arg1').val();
        input.arg2 = $('#arg2').val();
        $.ajax({
            url: '/calc',
            data: input,
            dataType: 'json',
            success: (result: ExampleApp.Result) => {
                $('#add').text(result.add);
                $('#subtract').text(result.subtract);
            },
        });
    });
})




