function checksr() {
    var num1=$("input[name=username]").val();
    var num2=$("input[name=pass]").val();

    if (num1==""||num2==""){
        alert("文本框为空");
        return false;
    }
}