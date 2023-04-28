<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Urls</title>

    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Open+Sans"/>


    <style>
        * {
            font-family: arial, serif;
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        .header {
            text-transform: uppercase;
        }

        tr:hover {
            background-color: coral;
        }
    </style>
</head>
<body>
<h1 class="header" style="font-size: 50px">Dear <span style="color: forestgreen">${username}</span>. Weakly Report <span
            style="color: #ff8400;">${report.from} - ${report.to}</span>
</h1>
<h2>Total Weekly Generated URLs Count : ${report.count}</h2>


<#list report.reports as daily_report>

    <hr/>
    <table class="table table-striped">
        <h1>${daily_report.dayName}</h1>
        <tr>
            <td>ID</td>
            <td>Description</td>
            <td>Path</td>
        </tr>
        <tbody>
        <#list daily_report.reports as url_report>
            <tr style="background-color: <#if url_report.expired>lightcoral<#else>greenyellow</#if>">
                <td>${url_report?index + 1}</td>
                <td><a href="${url_report.url}">${url_report.description}</a></td>
                <td><a href="${url_report.url}">${url_report.code}</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
    <h2>Total Daily Generated URLs Count For ${daily_report.dayName} : ${daily_report.count}</h2>
</#list>

</body>
</html>