/*********************************************************************************************************/
/**
 * Product form plugin for CKEditor 4.x (Author: daotientu)
 * version:	1.0
 * Released: On 2021-07-29
 */
/*********************************************************************************************************/

CKEDITOR.plugins.add('productform',
  {
    icons: 'productform',
    init: function( editor ) {
		editor.addCommand( 'productform', new CKEDITOR.dialogCommand( 'productformDialog' ) );
        editor.ui.addButton( 'productform', {
            label: 'Form sản phẩm trong bài viết',
            command: 'productform',
            toolbar: 'insert',
            icon : this.path + 'productform.png'
        });
        CKEDITOR.dialog.add( 'productformDialog', this.path + 'dialogs/productform.js' );
    }
});
