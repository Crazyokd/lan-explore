@REM SHIFT [/n]
 
@REM 如果命令扩展被启用，SHIFT 命令支持/n 命令行开关；该命令行开关告诉
@REM 命令从第 n 个参数开始移位；n 介于零和八之间。例如:
 
@REM     SHIFT /2
 
@REM 会将 %3 移位到 %2，将 %4 移位到 %3，等等；并且不影响 %0 和 %1。

@echo off
:round
if "%1"=="" goto cmd1
echo 参数：%1
shift
goto round

:cmd1
echo 没有获取到参数，结束脚本
goto end
:end