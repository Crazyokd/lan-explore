@REM set 命令用来显示、设置或删除 cmd.exe 环境变量。
@echo off
@REM 如果要显示当前环境变量，键入不带参数的 SET。
set Java_home

@REM 显示以P开头的所有变量
set p

@REM 如果在当前环境中找不到该变量名称，SET 命令将把 ERRORLEVEL设置成 1。如下：
set PATH
echo errorlevel=%errorlevel%
set NOT_HA_HA
echo errorlevel=%errorlevel%


@REM SET 命令不允许变量名含有等号。
set NOT_HA_HA=1
echo %NOT_HA_HA%
@REM 不会有任何输出，并且会删除 PATH 环境变量。
set NOT_HA_HA=
set NOT_HA_HA