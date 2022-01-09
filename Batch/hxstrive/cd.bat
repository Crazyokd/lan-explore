@echo off
set basePath=%cd%
echo %basePath%

@REM %~dp0 可以用来获取批处理文件的实际路径，与当前 DOS 环境所在的目录没有关系。其中：

@REM %~dp0 的 “d” 为 Drive 的缩写，即为驱动器，磁盘；

@REM %~dp0 的 “p” 为 Path 缩写，即为路径，目录；

@REM 我们可以使用 cd 命令转到 %~dp0 返回的目录，不过推荐使用 cd /d %~dp0。
@REM 因为可以避免盘符问题

set basePath=%~dp0
echo %basePath%

@REM 更多选项语法：

@REM ~0   删除任何引号(")，扩充 %0

@REM %~d0   仅将 %0 扩充到一个驱动器号

@REM %~f0   将 %0 扩充到一个完全合格的路径名（“f” 是 file，即文件）

@REM %~p0   仅将 %0 扩充到一个路径

@REM %~n0   仅将 %0 扩充到一个文件名（“n” 是 name 文件名）

@REM %~x0   仅将 %0 扩充到一个文件扩展名

@REM %~s0   扩充的路径只含有短名（“s” 为 Short，短的）

@REM %~a0   将 %0 扩充到文件的文件属性（“a” 为 attribute，即属性）

@REM %~t0   将 %0 扩充到文件的日期/时间（“t” time）

@REM %~z0   将 %0 扩充到文件的大小（Size 大小）

@REM %~$PATH:0   查找列在路径环境变量的目录，并将 %0 扩充到找到的第一个完全合格的名称。
@REM 如果环境变量名未被定义，或者没有找到文件，此组合键会扩充到空字符串
REM C:
echo %~d0
 
REM C:\Users\Administrator\Desktop\test.bat
echo %~f0
 
REM \Users\Administrator\Desktop\
echo %~p0
 
REM test
echo %~n0
 
REM .bat
echo %~x0
 
REM C:\Users\ADMINI~1\Desktop\test.bat
echo %~s0
 
REM --a------
echo %~a0
 
REM 2020/06/10 13:27
echo %~t0
 
REM 141
echo %~z0


@REM 可以组合修饰符来得到多重结果：

@REM %~dp0    仅将 %0 扩充到一个驱动器号和路径

@REM %~nx0    仅将 %0 扩充到一个文件名和扩展名

@REM %~fs0    仅将 %0 扩充到一个带有短名的完整路径名

@REM %~dp$PATH:0    查找列在路径环境变量的目录，并将 %I 扩充到找到的第一个驱动器号和路径。

@REM %~ftza0     将 %0 扩充到类似输出线路的 DIR

@REM %0 为当前批处理文件。如果0换成1为第一个文件，2为第2个


@REM %cd% 和 %~dp0 两者均可以获取到当前路径，
@REM 而 %~dp0 获取的是批处理文件所在目录的路径，%cd% 获取的是当前 DOS 环境的路径。
@REM 如果批处理文件和执行批处理文件不再同一目录，则 %cd% 返回的路径并不是批处理文件所在目录的路径，而是执行环境当前的路径。

@REM %cd% 和 %~dp0 区别：

@REM 1）使用范围上的不同

@REM %cd% 可以在批处理脚本（bat脚本）、命令行窗口中使用

@REM %~dp0 只能在批处理脚本（bat脚本） 中使用

@REM 2）bat 脚本执行时，两者代表的值是否会变化

@REM %cd% 会，因为代表的是当前目录

@REM %~dp0 不会，因为代表的是脚本文件在磁盘的位置