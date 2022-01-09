@echo off
setlocal
set /p input=请输入字符（A或B）：
if "%input%"=="A" goto A
goto end
 
:A
echo (1) 您输入了字符A
 
:A
echo (2) 您输入了字符A
 
:end