@echo off

@REM 局部变量和全局变量

@REM 默认情况下，变量对于整个命令提示符会话都是全局的。
@REM 调用 SETLOCAL 命令以使变量在脚本范围内成为本地变量。
@REM 调用 SETLOCAL 后,任何变量赋值都会在调用 ENDLOCAL、调用 EXIT 或执行到达脚本中的文件结尾 (EOF) 时恢复

set /A globalvar = 5

SETLOCAL
set /A var = 13145
set /A var = %var% + 5
echo %var%
echo %globalvar%
ENDLOCAL