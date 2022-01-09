@REM if 语句执行批处理程序中的条件处理。语法：

@REM IF [NOT] ERRORLEVEL number command
@REM IF [NOT] string1==string2 command
@REM IF [NOT] EXIST filename command


@echo off

set /p "pwd=请输入密码：>"
if "%pwd%"=="123456" echo 密码正确
if not "%pwd%"=="123456" echo 错误的密码: %pwd%
 
set file=D:\tmp.txt
if exist %file% echo %file% 文件存在
if not exist %file% echo %file% 文件不存在
 

copy tmp.txt >nul 2>nul
if errorlevel 1 echo errorlevel=%errorlevel% 拷贝失败
if errorlevel 0 echo errorlevel=%errorlevel% 文件拷贝成功
 
ipconfig > nul
if errorlevel 0 echo errorlevel=%errorlevel% 执行成功