/*********************************************************************************************************/
/**
 * Product image plugin for CKEditor 4.x (Author: daotientu)
 * version:    1.0
 * Released: On 2021-08-30
 */
/*********************************************************************************************************/

CKEDITOR.dialog.add('productimageDialog', function (editor) {
    return {
        title: 'Box (ảnh) sản phẩm trong bài viết',
        minWidth: 980,
        minHeight: 365,
        contents: [
            {
                id: 'text',
                label: 'HTML',
                elements: [
                    {
                        type: 'html',
                        html: '<button onclick="window.open(\'/box/product\', \'_blank\')" style="cursor:pointer;padding:10px;color:#fff;border-radius:3px;border:1px solid #169F85;background:#169F85;margin-right:10px">Thêm mới</button>' +
                            '<button id="getProductImages" style="cursor:pointer;padding:10px;color:#fff;border-radius:3px;border:1px solid #2e6da4;background:#337ab7">Lấy mới danh sách box (ảnh) sản phẩm</button>' +
                            '&nbsp;&nbsp;(Sau khi thêm mới hoặc edit lại box (ảnh) sản phẩm thì click vào nút lấy mới danh sách...)' +
                            '<div id="list_product_images"></div>'
                    }
                ]
            }
        ],
        onShow: function () {
            $('#getProductImages').click(function () {
                $.ajax({
                    type: 'GET',
                    url: '/box/product/list/content',
                    success: function (result, status, xhr) {
                        $('#list_product_images').html(result);
                    },
                    error: function (xhr, status, error) {
                        console.log(error);
                    }
                });
            });
            $.ajax({
                type: 'GET',
                url: '/box/product/list/content',
                success: function (result, status, xhr) {
                    $('#list_product_images').html(result);
                },
                error: function (xhr, status, error) {
                    console.log(error);
                }
            });
        },
        onOk: function () {
            var rFile = $('#list_product_images').find('input[name="thumbnail_url"]:checked').val()
                , product_id = $('#list_product_images').find('input[name="thumbnail_url"]:checked').attr('product-id').trim()
                , class_name = $('#list_product_images').find('input[name="thumbnail_url"]:checked').attr('class-name').trim()
                , device_name = $('#list_product_images').find('input[name="thumbnail_url"]:checked').attr('device-name').trim();
            if (rFile.length > 0)
            {
                var startRange = editor.getSelection(); //Cursor position
                var parent = startRange.getStartElement(); //The parent <p> or <span> of the cursor
                var e1 = CKEDITOR.dom.element.createFromHtml('<div><div class="include_box_product_image" data-productId="' + product_id + '" data-className="' + class_name + '" data-deviceName="' + device_name + '"><img src="' + rFile + '" alt=""/></div></div>');
                parent.insertBeforeMe(e1); //Places new node before the specified node
            }
        }
    };
});
