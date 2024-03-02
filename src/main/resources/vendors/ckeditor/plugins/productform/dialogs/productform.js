/*********************************************************************************************************/
/**
 * Product form plugin for CKEditor 4.x (Author: daotientu)
 * version:    1.0
 * Released: On 2021-07-29
 */
/*********************************************************************************************************/

CKEDITOR.dialog.add('productformDialog', function (editor) {
    return {
        title: 'Form sản phẩm trong bài viết',
        minWidth: 980,
        minHeight: 365,
        contents: [
            {
                id: 'text',
                label: 'HTML',
                elements: [
                    {
                        type: 'html',
                        html: '<div id="list_product_forms"></div>'
                    }
                ]
            }
        ],
        onShow: function () {
            $.ajax({
                type: 'GET',
                url: '/form/product/list/content',
                success: function (result, status, xhr) {
                    $('#list_product_forms').html(result);
                },
                error: function (xhr, status, error) {
                    console.log(error);
                }
            });
        },
        onOk: function () {
            var rFile = $('#list_product_forms').find('input[name="path_to_file"]:checked').val(), device_name = $('#list_product_forms').find('input[name="path_to_file"]:checked').attr('device-name').trim();
            if (rFile.length > 0)
                editor.insertHtml('<div><div class="include_form_order_content" data-file="' + rFile + '"><b><i><u>Đây là nơi hiển thị form sản phẩm ' + (device_name !== '' ? device_name + ' ' : '') + 'trong bài viết</u></i></b></div></div>');
        }
    };
});
