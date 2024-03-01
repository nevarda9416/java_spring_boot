/*********************************************************************************************************/
/**
 * Readmore plugin for CKEditor 4.x (Author: daotientu)
 * version:	1.0
 * Released: On 2021-07-19
 */
/*********************************************************************************************************/

CKEDITOR.plugins.add('readmore',
  {
    icons: 'readmore',
    init: function( editor ) {
		editor.addCommand( 'readmore', new CKEDITOR.dialogCommand( 'readmoreDialog' ) );
        editor.ui.addButton( 'readmore', {
            label: 'Văn bản đọc thêm',
            command: 'readmore',
            toolbar: 'insert',
            icon : this.path + 'readmore.png'
        });
        CKEDITOR.dialog.add( 'readmoreDialog', this.path + 'dialogs/readmore.js' );
    }
});
