@echo off

Dir C:\ > list.txt

@REM 如果将数字 2 附加到重定向过滤器，则它将stderr重定向到文件 list.txt。
Dir C:\ 2> list.txt

DIR C:\ > lists.txt 2>&1

@REM The pseudo file NUL is used to discard any output from a program. 
@REM The following example shows that the output of the command DIR is discarded by sending the output to NUL.
Dir C:\ > NUL

@REM 将键盘的输入重定向到lists.txt
TYPE CON > lists.txt