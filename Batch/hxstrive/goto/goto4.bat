@REM 标签名只可以使用常量，而不能使用变量。

@echo off
setlocal
REM 使用变量存放标签名
set labelA=:A
set labelB=:B
set /p input=请输入字符（A或B）：
if "%input%"=="A" goto A
if "%input%"=="B" goto B
echo 您没有输入字母
goto end
 
REM 使用变量定义标签名
%labelA%
echo 您输入了字符A
goto end
 
REM 使用变量定义标签名
%labelB%
echo 您输入了字符B
goto end
 
:end