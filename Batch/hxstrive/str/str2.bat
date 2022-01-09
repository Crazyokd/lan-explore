@REM 替换字符串，即将某一字符串中的特定字符或字符串替换为给定的字符串。语法如下：

@REM %variable:str1=str2%

@REM 参数说明：

@REM variable：变量命令，存放字符串。

@REM str1：被替换的字符串

@REM str2：替换字符串，将使用该字符串去替换字符串中所有的 str1 字符串。

@echo off
set aa=伟大的中国！我为你自豪！
echo 替换前：%aa%
echo 替换后：%aa:中国=中华人民共和国%
 
echo aa = %aa%
set "aa=%aa:中国=中华人民共和国%"
echo aa = %aa%
 
pause



set str=Hello, welcome to the article.
echo 原文：%str%
 
rem 判断 str 变量中是否存在 the 字符串
set "tmpStr=%str:the=%"
if "%str%"=="%tmpStr%" (
    echo 很抱歉！没有找到
) else (
    echo 存在字符串 “the”
)
 
pause