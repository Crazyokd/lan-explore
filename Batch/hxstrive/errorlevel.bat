@echo off
copu a.txt bak/b.txt
echo errorlevel=%errorlevel%

@REM 如果我们使用if errorlevel number command去使用 errorlevel，
@REM 它的含义是：如果返回的错误码值大于或等于值 的时候，将执行cmmand 操作。
if errorlevel 0 echo SUCCESS
pause

@REM 当使用if %errorlevel%==值 cmmand句式时，
@REM 它含义是：如果返回的错误码值等于值的时候，将执行cmmand操作。
echo errorlevel=%errorlevel%
if %errorlevel%==0 (
    echo success
) else (
    echo error
)
pause

rem 小于或等于
if %ERRORLEVEL% LEQ 1 echo SUCCESS

@REM 全部的比较参数如下： 

@REM EQU - 等于，=

@REM NEQ - 不等于，!=

@REM LSS - 小于，<

@REM LEQ - 小于或等于，<=

@REM GTR - 大于，>

@REM GEQ - 大于或等于，>=

