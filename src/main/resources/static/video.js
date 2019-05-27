(function() {
    window.onload = function() {
        $(".v_path").on("click", function () {
            var path = $(this).attr("path");
            $("source")[0].src = "/api/v1/video/showVideo?fileName=" + path;
        });
    };
})();