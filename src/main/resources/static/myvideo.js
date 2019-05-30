window.onload = function() {
    $(".v_path").on("click", function () {
        var path = $(this).attr("path");
        var myPlayer = videojs('my-video');
        var videoUrl = "/api/v1/video/showVideo?fileName=" + path;
        myPlayer.pause();

        videojs("my-video", {}, function() {
            window.myPlayer = this;
            $("source")[0].src = videoUrl;
            // $("#mymoda .video-con #my-video source").attr("src", videoUrl);
            myPlayer.src(videoUrl);
            myPlayer.load(videoUrl);
            myPlayer.play();
        });

    });
};
