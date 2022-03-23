// $(document).ready(function(){
//     initData();
//
//     $("#addNewCustomer").click(function (event){
//         let form = $("#addNew");
//         let data = form.serializeArray(); //  <-----------
//         console.log( data );
//         let ob ={};
//         let property;
//         for (let i = 0; i < data.length; i++) {
//             if (data[i].name === 'customerType.id'){
//                 property = data[i].name.substr(0, 12);
//             }else {
//                 property = data[i].name;
//             }
//             ob[property] = data[i].value;
//         }
//         console.log(ob)
//         $.ajax({
//             url:"/api/customer/1.0/add-customer",
//             type:"POST",
//             dataType:"JSON",
//             data: JSON.stringify(ob),
//             success:function (data) {
//                 console.log(data);
//                 $("#customer-body").append(data);
//             }
//         })
//     })
//
//
//    function deleteById(inDelete){
//         let id = $(this).attr("value").substr(0,1);
//         let name = $(this).attr("value").substr(1);
//         alert(123+inDelete);
//         console.log(name);
//         $("#name").text(name);
//         console.log($("#name").text());
//         $("#deleteById").val(id);
//         // $.ajax({
//         //     url:"/api/customer/1.0/delete/"+id,
//         //     type:"DELETE",
//         //     success:function(){
//         //         currentButton.parent().parent().remove();
//         //     }
//         // })
//     }
//
//     $("#previous").click(function(){
//         let page = $(this).val();
//         console.log(page);
//         $.ajax({
//             url:"/api/customer/1.0/list",
//             type:"GET",
//             data:{
//                 "page":page
//             },
//             dataType:"html",
//             success:function (data) {
//                 console.log(data);
//                 $("#body").empty();
//                 $("#body").append(data);
//             }
//         });
//     })
//
//     $("#next").click(function(){
//         let page = $(this).val();
//         console.log(page);
//         $.ajax({
//             url:"/api/customer/1.0/list",
//             type:"GET",
//             data:{
//                 "page":page
//             },
//             dataType:"JSON",
//             success:function (data) {
//                 console.log(data);
//                 $("#body").empty();
//                 $("#body").append(addDataBody(data.content));
//             }
//         });
//     })
//
//
//     $("#deleteById").click(function(){
//         let id = $(this).val();
//         let idButton = "#"+"delete"+id;
//         console.log(idButton);
//         alert(123);
//         let deleteButton = $(idButton);
//         $.ajax({
//             url:"/api/customer/1.0/delete/"+id,
//             type:"DELETE",
//             success:function(){
//                 deleteButton.parent().parent().remove();
//                 $("#delete").modal("toggle");
//             }
//         })
//     })
//
//
//     function initData() {
//         $.ajax({
//             url:"/api/customer/1.0/list",
//             type:"GET",
//             dataType:"JSON",
//             success:function (data) {
//                 console.log(data);
//                 //console.log(addDataBody(data));
//                 $("#body").append(addDataBody(data));
//             }
//         });
//     }
//
//     function addDataBody(data) {
//         let content = "";
//         for(let i = 0;i<data.content.length;i++){
//             content += "<tr>"
//             console.log(i);
//             // <td>${data[i].customerType.customerType}</td>
//             content+=
//             `
//              <td>${i}</td>
//              <td>${data.content[i].gender==1?'Man':'Woman'}</td>
//              <td>${data.content[i].code}</td>
//              <td>${data.content[i].name}</td>
//              <td>${data.content[i].birthday}</td>
//              <td>${data.content[i].phone}</td>
//              <td>${data.content[i].idCard}</td>
//              <td>${data.content[i].address}</td>
//              <td>${data.content[i].email}</td>
//                <td></td>
//              <td>
//                     <button type="button" onclick="javascript:deleteById()" th:id="${data.content[i].id}" class="delete  btn btn-primary btn-lg" data-toggle="modal" data-target="#delete" th:value="${data.content[i].id+''+data.content[i].name}" style="background: transparent;border: none;padding:0" >
//                           <i class="material-icons" style="font-size:40px;color:red">delete
//                           </i>
//                     </button>
//              </td>
//              <td>
//                    <button th:value="${data.content[i].id}" style="background: transparent;border: none;padding:0" class="edit">
//                             <i class='far fa-edit' style='font-size:40px;color:green'></i>
//                    </button>
//              </td>
//             `
//             content+="</tr>";
//         };
//         content+= `
//                     <tr>
//                     <td colspan="12">
//                        <button id="previous" th:value="${data.pageable.pageNumber}-1" th:if="${data.pageable.pageNumber>=0}">Previous</button>
//                        <span th:text="${data.pageable.pageNumber}+1"></span>
//                        <span>/</span>
//                        <span th:text="${data.pageable.pageSize}"></span>
//                        <button id="next" th:value="${data.pageable.pageNumber}+1" th:if="${data.pageable.pageNumber<(data.pageable.pageSize-1)}">Next</button>
//                        </td>
//                     </tr>
//                 `
//
//         return content;
//     }
//
// });


$(document).ready(function(){

    $(".delete").click(function(){
        console.log($(this).val());
        let id = $(this).attr("value").substr(0,1);
        $("#deleteValue").val(id);
        let name = $(this).attr("value").substr(1);
        console.log(name);
        $("#customerName").text(name);

        $("#deleteValue").val(id);
    });

    $("#deleteById").click(function(){

    });

    $("#deleteButton").click(function (){
        // $("#deleteValue").val( $("#deleteById").val());
        $("#formDelete").submit();
    });

    $(".edit").click(function (){
        let id = $(this).val();
        console.log(id);
        $.ajax({
            url:"/api/customer/1.0/edit/"+id,
            type:"GET",
            dataType:"JSON",
            success: function (data) {
                $("#updateId").val(id);
                $("#updateCode").val(data.code);
                $("#updateAddress").val(data.address);
                $("#updateEmail").val(data.email);
                $("#updateName").val(data.name);
                $("#updateBirthday").val(data.birthday);
                $("#updateIdCard").val(data.idCard);
                $("#updatePhone").val(data.phone);
                if(data.gender){
                    $("#updateGenderMan").attr("checked",true);
                }else{
                    $("#updateGenderWoman").attr("checked",true );
                };
                $("#updateCustomerType option[value=" + data.customerTypeId + "]").prop("selected",true);

            }
        })
        // let currentForm = $(this).parent().parent();
        // console.log(currentForm.children()[3].search('<td>(.*?)</td>'));
        // //$("#editForm").children[1].val(currentForm.children[1].val());
        // $("#updateCode").val($("#currentCode").val());
        // $("#updateAddress").val($("#currentAddress").val());
        // $("#updateEmail").val($("#currentEmail").val());
        // $("#updateName").val($("#currentName").val());
        // $("#updateBirthday").val($("#currentBirthday").val());
        // $("#updateIdCard").val($("#currentIdCard").val());
        // $("#updatePhone").val($("#currentPhone").val());

    });

});
