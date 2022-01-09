@echo off
copy a.txt bak/b.txt
if %errorlevel%==0 (
    echo SUCCESS
) else (
    echo ERROR
)

copu a.txt bak/b.txt >nul 2>nul
if %errorlevel%==0 (
    echo SUCCESS
) else (
    echo ERROR
)
pause

@REM >nul 2>nul 就是把命令执行的输出信息和错误信息不输出到屏幕，而是输出到一个根本不存在的设备。
@REM >nul 等效于 1>nul，>nul 前面的 1 表示输出流，2 表示错误流（1可以省略不写）

copu a.txt bak/b.txt >con 2>con
if %errorlevel%==0 (
    echo SUCCESS
) else (
    echo ERROR
)
pause

@REM con 控制台（键盘和显示器）

@REM aux , com1 - com4 所有串口

@REM prn , lpt1 - lpt3 所有并口

@REM nul 空设备

@REM clock$ 电子钟