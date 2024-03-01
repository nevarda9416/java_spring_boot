/*********************************************************************************************************/
/**
 * Product image plugin for CKEditor 4.x (Author: daotientu)
 * version:	1.0
 * Released: On 2021-08-30
 */
/*********************************************************************************************************/

CKEDITOR.plugins.add('productimage',
  {
    icons: 'productimage',
    init: function( editor ) {
		editor.addCommand( 'productimage', new CKEDITOR.dialogCommand( 'productimageDialog' ) );
        editor.ui.addButton( 'productimage', {
            label: 'Box (ảnh) sản phẩm trong bài viết',
            command: 'productimage',
            toolbar: 'insert',
            icon : this.path + 'productimage.png'
        });
        CKEDITOR.dialog.add( 'productimageDialog', this.path + 'dialogs/productimage.js' );
    }
});
