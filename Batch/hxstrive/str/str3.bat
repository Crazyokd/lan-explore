@echo off
set str1=Hello
set str2=World
 
rem 直接输出合并后的字符串
echo %str1%%str2%
 
rem 将合并后的字符串放入 str 变量中
set str=%str1%%str2%
echo %str%
 
pause


rem 设置变量延迟扩展
if "%OS%"=="Windows_NT" setlocal enabledelayedexpansion
 
rem 将当前目录下面以及子目录下面的目录路径放到 allFile 变量
set "bastPath=%~dp0"
set allFile=
for /r %%i in (*) do (
    set "var=%%i"
    set "allFile=!allFile! !var:%bastPath%=!"
)
echo %allFile%
 
pause