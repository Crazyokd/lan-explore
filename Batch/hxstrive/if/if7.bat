@REM 如果没有名为 CMDCMDLINE 的环境变量，%CMDCMDLINE% 将在 CMD.EXE 进行任何处理前扩充为传递给 CMD.EXE 的原始命令行；
@REM 否则，您会得到其数值。
@REM 如果没有名为 CMDEXTVERSION 的环境变量，%CMDEXTVERSION% 会扩充为 CMDEXTVERSION 当前数值的字串符表达式；
@REM 否则，您会得到其数值。

@echo off
echo cmdLine=%CMDCMDLINE%
echo version=%CMDEXTVERSION%