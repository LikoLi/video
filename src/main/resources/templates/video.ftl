<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Video</title>
    <link href="https://vjs.zencdn.net/7.5.4/video-js.css" rel="stylesheet">
    <link href="/video.css" rel="stylesheet">
    <!-- If you'd like to support IE8 (for Video.js versions prior to v7) -->
    <script src="https://vjs.zencdn.net/ie8/1.1.2/videojs-ie8.min.js"></script>
</head>
<body>
    <h2>Video</h2>
        <div class="video">
            <div class="v_left">
                <#list filePathSet as file>
                    <a class="v_path" path="${file}">${file?substring(file?last_index_of("/") + 1)}</a>
                </#list>
            </div>
            <div class="v_right">
                <video id='my-video' class='video-js' controls preload='auto' width='800px' height='540px'
                       poster='MY_VIDEO_POSTER.jpg' data-setup='{}'>
                    <source src='/api/v1/video/showVideo?fileName=${filePathSet[0]}' type='video/ogg'>
                    <p class='vjs-no-js'>
                        To view this video please enable JavaScript, and consider upgrading to a web browser that
                        <a href='https://videojs.com/html5-video-support/' target='_blank'>supports HTML5 video</a>
                    </p>
                </video>
            </div>
        </div>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script src='https://vjs.zencdn.net/7.5.4/video.js'></script>
    <script src="/myvideo.js"></script>
</body>
</html>