@echo off
setlocal
set /p input=请输入字母A或B：
if "%input%"=="A" goto A
if "%input%"=="B" goto B
echo 您没有输入字母
goto end
REM 定义了一个标签
 
:A
echo 您输入的字母是A
goto end
REM 定义了一个标签
 
:B
echo 您输入的字母是B
goto end
:end