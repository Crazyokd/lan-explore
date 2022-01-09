@REM rem xcopy 默认的 errorlevel 值就有5个，分别表示5种执行状态
@REM rem 0 复制文件成功 
@REM rem 1 未找到复制文件 
@REM rem 2 用户通过CTRL C 终止了xcopy操作 
@REM rem 4 出现了初始化错误  
@REM rem 5 出现了磁盘写入错误

@echo off
xcopy tmp.txt D:\tmp\tmp.txt
echo ERRORLEVEL=%ERRORLEVEL%
IF %ERRORLEVEL% EQU 0 goto answer0
IF %ERRORLEVEL% EQU 1 goto answer0
IF %ERRORLEVEL% EQU 2 goto answer2
IF %ERRORLEVEL% EQU 4 goto answer4
IF %ERRORLEVEL% EQU 5 goto answer5

 
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