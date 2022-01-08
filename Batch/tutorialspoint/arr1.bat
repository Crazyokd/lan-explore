@echo off

@REM 数组的每个元素都需要用 set 命令定义。
@REM 需要“for”循环来遍历数组的值。

set /A a[0] = 1
set /A a[1]=2 
set /A a[2]=3 
echo The first element of the array is %a[0]% 
echo The second element of the array is %a[1]% 
echo The third element of the array is %a[2]%

Rem Adding an element at the end of an array 
Set a[3]=4 
echo The last element of the array is %a[3]%

Rem Setting the new value for the second element of the array 
Set a[1]=5 
echo The new value of the second element of the array is %a[1]%

set list=1 2 3 4 
(for %%a in (%list%) do ( 
   echo %%a 
))


setlocal enabledelayedexpansion 
set topic[0]=comments 
set topic[1]=variables 
set topic[2]=Arrays 
set topic[3]=Decision making 
set topic[4]=Time and date 
set topic[5]=Operators 

@REM 带有 /L 参数的“for”循环用于在范围内移动，用于遍历数组。

@REM start,step,len
for /l %%n in (0,1,5) do ( 
   echo !topic[%%n]! 
)