@REM 字符串截取
@REM %variable:~n,m%

@REM 参数说明：

@REM variable：要进行操作的变量名称，该变量中放的是字符串；

@REM n：开始截取字符串的偏移量；如果为正数，则从左边开始；如果没有为负数，则从右边开始

@REM m：要截取字符的个数。如果没有指定个数，则采用默认值，即变量数值的余数
@REM （余数指剩余个数，如：%variable:~-5% 当前偏移量为倒数第6，将剩下的字符全部截取）。
@REM 如果两个数字 (偏移量和长度) 都是负数，使用的数字则是字符串长度加上指定的偏移量或长度

@echo off
set ifo=abcdefghijklmnopqrstuvwxyz0123456789
echo 原字符串：
echo %ifo%
 
rem abcde
echo 截取前5个字符：
echo %ifo:~0,5%
 
rem fghijklmnopqrstuvwxyz0123456789
echo 截取第六个字符直到最后一个字符
echo %ifo:~5%
 
rem 56789
echo 截取最后5个字符：
echo %ifo:~-5%
echo %ifo:~-5,5%
 
rem abcdefghijklmnopqrstuvwxyz01234
echo 截取第一个到倒数第6个字符：
echo %ifo:~0,-5%
 
rem defgh
echo 从第4个字符开始，截取5个字符：
echo %ifo:~3,5%
 
rem wxyz0
echo 从倒数第14个字符开始，截取5个字符：
echo %ifo:~-14,5%
pause



set ifo=a0123456789
echo 原字符串：%ifo%
echo %ifo:~-8%
echo %ifo:~-8,-7%
echo %ifo:~-8,-6%
echo %ifo:~-8,-5%
echo %ifo:~-8,-4%
echo %ifo:~-8,-3%
echo %ifo:~-8,-2%
echo %ifo:~-8,-1%
 
rem error: ECHO 处于关闭状态。
echo %ifo:~-5,-5%
echo %ifo:~-5,-10%
 
pause



FOR /F "tokens=1,2,3,4" %%I IN ('VER') DO (
  set Ver_Temp=%%L
)
echo Windows版本字符串：%Ver_Temp%
 
rem 截取版本
set Ver_Major=%Ver_Temp:~0,2%
set Ver_Minor=%Ver_Temp:~3,1%
set Ver_Build=%Ver_Temp:~-4,3%
 
echo Windows Version:
echo   Major %Ver_Major%
echo   Major %Ver_Minor%
echo   Build %Ver_Build%

pause



echo 当前时间：%time%
echo 当前时间：%time:~0,2%点%time:~3,2%分%time:~6,2%秒%time:~9,2%毫秒
pause