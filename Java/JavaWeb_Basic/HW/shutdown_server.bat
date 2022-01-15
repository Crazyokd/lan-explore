@REM 设置Tomcat根目录
set TOMCAT_HOME="D:\ProgramFiles2\Tomcat\apache-tomcat-8.0.50"
@REM 保存当前目录
set CURRENT_DIR=%cd%

cd "%TOMCAT_HOME%\bin\"

call .\shutdown.bat

cd %CURRENT_DIR%
TASKKILL /F /IM cmd.exe /T