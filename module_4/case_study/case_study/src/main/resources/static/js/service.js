$(document).ready(function(){
    $(".view").click(function(){
        let id = $(this).val();
        console.log(id);

    })

    $(".cancelBtn").click(function(){
        $('#addNew').modal('toggle');
    })
})