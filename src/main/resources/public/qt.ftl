<#ftl encoding="utf-8">
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <style media="screen">
        html, body {
            height: 100%;
        }

        p {
            text-align: center;
            font-size: 280%;
            word-break: break-all;
        }

        span {
            font-family: "Arial Unicode MS";
        }


    </style>
</head>
<body marginheight="300">


<p align="center" style="font-size:280%">扫描到以下内容:</p>
<div align="center">
    <table border="1" align="center" width="100%">
        <tr>
            <td>
                <p>委托项目类型：${content.projectType}</p>
                <p>防伪号：<span>${content.checkNumber}</span></p>
                <p>事务所名称：安徽天桓会计师事务所（普通合伙)</p>
                <p>鉴证对象名称：${content.name}</p>
                <p>报告文号：皖天桓${content.character}审字(<span>${content.year}<span>)第<span>${content.number}</span>号</p>
                <p>以上内容仅供参考,以http://cmis.aicpa.org.cn:9000/ahicpa/common/comtent.do?method=search查询结果为准。</p>
            </td>
        </tr>
    </table>
</div>

<br/>
<br/>
<br/>
</body>
</html>