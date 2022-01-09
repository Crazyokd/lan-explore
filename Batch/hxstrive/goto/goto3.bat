@echo off
setlocal
set /p input=请输入字符（A或B）：
if "%input%"=="A" goto A
if "%input%"=="B" goto B
echo 您没有输入字母
exit
 
:A
echo 您输入了字符A
exit
 
:B
echo 您输入了字符B
exit