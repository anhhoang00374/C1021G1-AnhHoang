$(document).ready(function(){
    $(".delete").click(function(){
        let id = this.id;
        let name = this.value;
        $("#employeeName").text(name);
        $("#employeeId").text(id);
        $("#deleteValue").val(id);

    });
    $("#deleteButton").click(function(){
        $("#formDelete").submit();
    });

})