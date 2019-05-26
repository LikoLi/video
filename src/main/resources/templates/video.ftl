<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Video</title>
</head>
<body>
    <h2>Video</h2>
    <#list filePathSet as file>
        ${file}</br>
        <video src="./showVideo?fileName=${file!}" width="420px" height="380px">
            ERROR
        </video>
    </#list>
</body>
</html>