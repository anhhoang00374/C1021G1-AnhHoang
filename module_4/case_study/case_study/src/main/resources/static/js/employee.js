$(document).ready(function(){
    $(".delete").click(function(){
        let id = this.id;
        let name = this.value;
        $("#employeeName").text(name);
        $("#employeeId").text(id);
        console.log($("#employeeName").text(name));
        $("#deleteValue").val(id);

    });
    $("#deleteButton").click(function(){
        $("#formDelete").submit();
    });

    $(".edit").click(function () {
        let id = $(this).val();
        // console.log(id);
        $.ajax({
            url: "/api/employee/1.0/edit/" + id,
            type: "GET",
            dataType: "JSON",
            success: function (data) {
                console.log(data);
                $("#updateId").val(data.id);
                $("#updateSalary").val(data.salary);
                $("#updateCode").val(data.code);
                $("#updateName").val(data.name);
                $("#updateBirthday").val(data.birthday);
                $("#updatePhone").val(data.phone);
                $("#updateIdCard").val(data.idCard);
                $("#updateAddress").val((data.address));
                $("#updateEmail").val(data.email);
                 $("#updateDivision option[value=" + data.division.id + "]").prop("selected", true);
                $("#updateEducation option[value=" + data.education.id + "]").prop("selected", true);
                $("#updatePosition option[value=" + data.position.id + "]").prop("selected", true);
                $("#updateUserName").val(data.user.userName);

            }
        })
    })

})