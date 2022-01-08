@ECHO OFF 
:Loop 

IF "%1"=="" GOTO completed 
FOR %%F IN (%1) DO echo %%F 
@REM 对参数进行移位
SHIFT 
GOTO Loop 
:completed