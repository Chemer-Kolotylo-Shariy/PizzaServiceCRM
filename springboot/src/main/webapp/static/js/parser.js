// jQuery(document).ready(function(){
//     function doAjaxPost() {
//         // get the form values
//         var contextPath ='http://localhost:8888/products';
//
//         $.ajax({
//             type: "GET",
//             url: contextPath+"/all",
//             dataType: "JSON",
//             contentType: "application/json; charset=UTF-8",
//             success: function(data){
//                 alert(data);
//                 // we have the response
//
//                 messageInbox(obj);
//             },
//             error: function(e){
//                 alert('Error: ' + e);
//             }
//         });
//     }
//     //setInterval(doAjaxPost,10*1000);
//
//
//     function messageInbox(obj) {
//         var list = '<div>';
//         $(obj.producrs).each(function (i, item) {
//             list = list +'<tr>'
//                 + '<td>item.name</td>'
//                 + '<td>item.specification</td>'
//                 + '<td>item.photo</td>'
//                 + '<td>item.priceWithPersent</td>'
//                 + '<td>item.persent</td>'
//                 + '<td>item.size.size</td>'
//                 +'<tr>'
//
//         });
//         list = list + '</div>';
//         alert(list);               //here I get only <div></div>
//         $("#inboxDiv").html(list);
//         alert("messageInbox end");
//         }
// });


// (function($) {
//     var url = 'http://localhost:8888/products/all';
//     var productPars = [];
//     $.ajax({
//         type: 'GET',
//         url: url,
//         async: false,
//         jsonpCallback: 'callback',
//         contentType: "application/json",
//         dataType: 'jsonp',
//         success: function(json) {
//             productPars = JSON.parse(json);
//             console.log(JSON.stringify(json.products));
//             var HTML = '<div>';
//             $.each(productPars, function(idx, product){
//                     HTML = HTML +'<tr>' +
//                         '<td>' + product.name + '</td>' +
//                         '<td>' + product.specification + '</td>' +
//                         '<td>' + product.photo + '</td>' +
//                         '<td>' + product.priceWithPersent + '</td>' +
//                         '<td>' + product.persent + '</td>' +
//                         '<td>' + product.size.size + '</td>' +
//                         '</tr>';
//                 },
//                 HTML = HTML + '</div>',
//                 document.getElementById('products').innerHTML = HTML
//         )},
//         error: function(e) {
//             console.log(e.message);
//         }
//     });
// })(jQuery);


$( document ).ready(function() {

    // GET REQUEST
    // $("#getAllProduct a").click(function(event){
    //     event.preventDefault();
    //     ajaxGet();
    // });
    ajaxGet();
    // DO GET
    function ajaxGet(){
        $.ajax({
            type : "GET",
            url : "http://localhost:8888/products" + "/all",
            contentType: "application/json",
            dataType: 'jsonp',
            success: function(result){
                // if(result.status == "OK"){

                    $.each(result.data, function(i, product){
                        var productRes = '<tr>' +
                            '<td>' + product.name + '</td>' +
                            '<td>' + product.specification + '</td>' +
                            '<td>' + product.photo + '</td>' +
                            '<td>' + product.priceWithPersent + '</td>' +
                            '<td>' + product.persent + '</td>' +
                            '<td>' + product.size.size + '</td>' +
                            '</tr>';
                        $('#productsResult').append(productRes)
                    });
                    console.log("Success: ", result);
                // }else{
                //     $("#productsResult").html("<strong>Error</strong>");
                //     console.log("Fail: ", result);
                // }
            },
            error : function(e) {
                $("#productsResult").html("<strong>Error</strong>");
                console.log("ERROR: ", e);
            }
        });
    }
})
