@REM 如果没有名为 ERRORLEVEL 的环境变量，%ERRORLEVEL% 会扩充为 ERROLEVEL 当前数值的字符串表达式；
@REM 否则，您会得到其数值。

@echo off
xcopy tmp.txt D:\tmp\tmp.txt
echo ERRORLEVEL=%ERRORLEVEL%
goto answer%ERRORLEVEL%
 
rem xcopy 默认的 errorlevel 值就有5个，分别表示5种执行状态
rem 0 复制文件成功 
rem 1 未找到复制文件 
rem 2 用户通过CTRL C 终止了xcopy操作 
rem 4 出现了初始化错误  
rem 5 出现了磁盘写入错误
:answer0
echo xcopy 复制文件成功
goto end
 
:answer1
echo xcopy 未找到复制文件
goto end
 
:answer2
echo xcopy 用户通过 CTRL C 终止了xcopy 操作
goto end
 
:answer4
echo xcopy 出现了初始化错误
goto end
 
:answer5
echo xcopy 出现了磁盘写入错误
goto end
 
:end