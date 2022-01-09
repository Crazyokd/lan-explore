@REM DOS 终于添加了延迟环境变量扩充的支持。
@REM 该支持默认总是被停用，但也可以通过 CMD.EXE 的 /V 命令行开关启用/停用延迟环境变量。

@REM /V:ON   使用 ! 作为分隔符启用延迟的环境变量扩展。
@REM 例如，/V:ON 会允许 !var! 在执行时扩展变量 var。var 语法会在输入时扩展变量，这与在一个 FOR循环内不同。

@REM /V:OFF  禁用延迟的环境扩展。

@echo off
@REM 使用 ! 符号来输出变量，但是DOS默认是没有启动延迟环境变量，会原样输出变量名，不会解析变量名。
set val=administrator
echo !val!

@REM cmd /v:on
echo !val!