/**
 * Created by Mary on 22.09.2015.
 */
function deleteOrder(id){
    console.log(id);
    $.ajax({
        type: "POST",
        url: contextPath + "/deleteOrder.action",
        data: JSON.stringify(id),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (){
            $("#"+id).hide();
        },
        async:false
    });
}