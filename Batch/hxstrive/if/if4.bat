@REM 如果命令扩展被启用，IF 会如下改变：

@REM IF [/I] string1 compare-op string2 command
@REM IF CMDEXTVERSION number command
@REM IF DEFINED variable command

@REM 其中， compare-op 可以是：

@REM EQU - 等于

@REM NEQ - 不等于

@REM LSS - 小于

@REM LEQ - 小于或等于

@REM GTR - 大于

@REM GEQ - 大于或等于


@REM  /I 开关（如果指定）说明要进行的字符串比较不分大小写。/I 开关可以用于 IF 的 string1==string2 的形式上。
@REM  如果 string1 和 string2 都是由数字组成的，字符串会被转换成数字，进行数字比较。
@echo off
if "A" equ "A" echo equ ok
if "A" == "A" echo equ ok
if /I "A" equ "a" echo equ ok
if 100 equ 100 echo equ ok
if 100 == 100 echo equ ok


echo %CMDEXTVERSION%
if CMDEXTVERSION 2 echo 内部版本号为2


set val=10
if DEFINED val echo val=%val%
if NOT DEFINED val echo 没有定义 val 环境变量
 
if DEFINED myPath echo val=%myPath%
if NOT DEFINED myPath echo 没有定义 myPath 环境变量