@REM 达到批处理文件结尾时，对于该批处理文件的每个尚未执行的 setlocal 命令，都会有一个隐含的 endlocal 被执行。

@REM setlocal 批命令现在可以接受可选参数：

@REM enableextensions / disableextensions  启用或禁用命令处理器扩展。
@REM 这些参数比 cmd /e:on 或 /e:off 开关有优先权。

@REM enabledelayedexpansion / disabledelayedexpansion  启用或禁用延缓环境变量扩展。
@REM 这些参数比 cmd /v:on 或 /v:off 开关有优先权。

@ECHO OFF
VERIFY OTHER 2>nul
SETLOCAL ENABLEEXTENSIONS
IF ERRORLEVEL 1 echo Unable to enable extensions


echo before setlocal:
set pathh=administrator
set pathh
pause
 
setlocal
rem reset environment var path
set pathh=E:\tools
echo after setlocal and reset path
set pathh
pause
endlocal
 
echo recovery path by endlocal
set pathh


setlocal enabledelayedexpansion
set LIST=
for %%i in (*) do set LIST=!LIST! %%i
echo %LIST%
endlocal

@REM 如果命令扩展被启用，endlocal 会如下改变：

@REM 如果相应的 setlocal 用新的 enableextensions 或 disableextensions 选项启用或停用了命令扩展；
@REM 那么，在 endlocal 之后，命令扩展的启用/停用状态会还原到执行相应的 setlocal 命令前的状态。