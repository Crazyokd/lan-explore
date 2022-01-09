@echo off
set sum=0
rem 调用子程序
call :sub sum 1 2 3 4
echo sum=%sum%
pause
rem 定义一个子程序
:sub
set /a %1=%1+%2
shift /2
if not "%2"=="" goto sub
goto :eof