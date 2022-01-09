@REM if-else 语句，该语句用来处理 “如果条件为真，执行语句1；否则，执行语句2”。伪语句：

@REM if 条件 == true
@REM     语句1
@REM else
@REM     语句2

@REM ELSE 命令必须与 IF 命令的尾端在同一行上

@echo off
IF EXIST filename. (
    del filename.
) ELSE (
    echo filename. missing.
)

IF EXIST filename. (del filename.) ELSE echo filename. missing


set /p pwd=请输入密码：
if "%pwd%"=="123456" (
    echo 密码正确
) else (
    echo 错误的密码: %pwd%
)