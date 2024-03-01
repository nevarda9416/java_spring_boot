/*********************************************************************************************************/
/**
 * Readmore plugin for CKEditor 4.x (Author: daotientu)
 * version:	1.0
 * Released: On 2021-07-19
 */
/*********************************************************************************************************/

CKEDITOR.dialog.add('readmoreDialog',function(editor){
	return{
		title:'Văn bản đọc thêm',
		minWidth:980,
		minHeight:365,
		contents:[
			{	id:'text',
				label:'HTML',
				elements:[
				  { type:'textarea',
				    id:'readmore_area',
					label:'',
					cols:60,
					rows:30
				  }
				]
			}
		],
        onShow: function() {
            CKEDITOR.replace($('textarea.cke_dialog_ui_input_textarea').attr('id'), editor_config_basic);
        },
		onOk: function() {
			//var rInsert=this.getValueOf('text','readmore_area'); // Chế độ text thường
            var rInsert=CKEDITOR.instances[$('textarea.cke_dialog_ui_input_textarea').attr('id')].getData(); // Chế độ rich text
			if ( rInsert.length > 0 )
			editor.insertHtml('<div class="block-readmore"><p class="w-100 text-center click-readmore"><a href="javascript:void(0)" title="Đọc thêm">+ Đọc thêm +</a></p><p class="w-100 text-center d-none click-compact"><a href="javascript:void(0)" title="Rút gọn">- Rút gọn -</a></p><div class="d-none paragraph-readmore">'+rInsert+'</div></div>');
		}
	};
});
