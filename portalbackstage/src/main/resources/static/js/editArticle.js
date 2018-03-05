    /**
     * 关闭窗口事件
     */
    window.onunload = function() {
         if (window.opener && !window.opener.closed) {
            window.opener.hideMask();
         }
    };
    /**
     * 关闭窗口，隐藏窗口与打开者的蒙版
     */
    function closeWindow(){
        if (window.opener && !window.opener.closed) {
            window.opener.hideMask();
        }
        window.opener=null;
        window.open('','_self');
        window.close();
    }

    $('#articleForm').submit(function(){
    	$('#mask').show();
        var options = {
             type:'POST',
             dataType:'json',
             success : function(data){
                if(data.statu == 200){
                    closeWindow();
                }else{
                    alert('文章保存失败,' + data.message);
                }
                $('#mask').hide();
             },
             error : function(){
                alert('文章保存失败,请稍后再试');
                $('#mask').hide();
             }
        };
        $('#articleForm').ajaxSubmit(options);
        return false;
    });
