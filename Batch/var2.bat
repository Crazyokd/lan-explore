@echo off

set /A variable-name=value

@REM variable-name是要设置的变量的名称。

@REM value是需要针对变量设置的值。

@REM /A -如果值本质上需要是数字，则使用此开关。

set message=Hello World 
echo %message%
@REM 要显示变量的值，请注意变量需要用 % 符号括起来。

@REM 使用数值
SET /A a = 5 
SET /A b = 10 
SET /A c = %a% + %b% 
echo %c%
SET /A c = %a% - %b% 
echo %c% 
SET /A c = %b% / %a% 
echo %c% 
SET /A c = %b% * %a% 
echo %c%