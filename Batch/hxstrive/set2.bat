@echo off
@REM /A 命令行开关指定等号右边的字符串为被评估的数字表达式
set /A val=10+22
echo %val%
 
rem 将 val 环境变量加10，赋值给val2环境变量。其：val2=42
set /A val2=%val%+10
echo %val2%
 
rem 将 16 使用位移操作符，向右移动一位，移动一位等于除以2。其：val3=8
set /A "val3=16>>1"
echo %val3%
 
rem 使用分组符号提升加法的优先级，其：val4=18
set /A val4=(0+1+2+3+4+5+6+7+8+9)/5*2
echo %val4%
 
rem 使用 %% 进行取余运算，其：val5=4
set /A "val5=94%%10"
echo %val5%



@REM 如果指定了一个环境变量名称，但未在当前环境中定义，那么值将被定为零。
@REM 这使您可以使用环境变量值做计算而不用键入那些 % 符号来得到它们的值。

rem 下面在 set 中使用 tmp 参与运算，但是 tmp 并没有定义
rem 默认 tmp 为 0，因此 val=22
set /A val=tmp+22
echo %val%
 
rem 下面在 set 中使用 %tmp2% 获取变量 tmp2 的值，因为没有定义 tmp2 变量，
rem 因此抛出 “运算符不存在。” 错误。其中，val2=0
set /A val2=%tmp2%+22
echo %val2%


rem 十六进制和八进制
set /a 1+1
set /a val=0xA+2
echo %val%
set /a val=04+02
echo %val%