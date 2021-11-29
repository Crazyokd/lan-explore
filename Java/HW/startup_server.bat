@REM 设置Tomcat根目录
set TOMCAT_HOME="D:\ProgramFiles2\Tomcat\apache-tomcat-8.0.50"

call .\deploy.bat
copy config\*.xml "%TOMCAT_HOME%\conf\Catalina\localhost\"

set TOMCAT_HOME_BIN="%TOMCAT_HOME%\bin"

@REM wt -w 0 nt sp -d %cd% cmd /k catalina run --title "console"

@REM Open a new tab with the default profile in the current window
wt -w 0 nt --title console -d %TOMCAT_HOME_BIN% cmd /k catalina run
