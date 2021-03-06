@echo off

setlocal

set CURRENT_DIR=%~dp0
cd /d %CURRENT_DIR%

rem DEFAULT_WORKSPACEが環境変数に設定されていない場合に設定する
if "%DEFAULT_WORKSPACE%"=="" (
	set DEFAULT_WORKSPACE=%CURRENT_DIR%workspace
)

rem M2_HOMEを上書き
set M2_HOME=%CURRENT_DIR%mvn

rem JAVA_HOME、JRE_HOMEを上書き
set JAVA_HOME=%CURRENT_DIR%java\jdk8
set JRE_HOME=%JAVA_HOME%\bin

rem PATHにmvn/bin java/binを追加
set PATH=%M2_HOME%\bin;%JAVA_HOME%\bin;%PATH%

rem CATALINA_HOMEを上書き
set CATALINA_HOME=%CURRENT_DIR%tomcat
set CATALINA_BASE=%CURRENT_DIR%tomcat
set CATALINA_TMPDIR=%CURRENT_DIR%tomcat\temp
set CATALINA_OPTS=-Xms256m -Xmx512m -XX:PermSize=64m -XX:MaxPermSize=128m

cd %CURRENT_DIR%tomcat\bin
call startup.bat

rem eclipseを起動
cd %CURRENT_DIR%eclipse

if exist ".first" (
	del .first
	set OPT=-clean
) else (
	set OPT=
)

start eclipse.exe %OPT% -vm %JRE_HOME%

cd %CURRENT_DIR%

endlocal
