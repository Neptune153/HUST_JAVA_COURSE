@echo off
set JAVA_HOME=%JAVA17_HOME%
set PROJECT_HOME=E:\javaHomework\chapter1
set PATH=%PATH%;%JAVA_HOME%\bin

rem 根据需求选择加载方式：JAR 或 CLASS 目录
set RUN_JAR=false

if "%RUN_JAR%"=="true" (
    set CLASSPATH=%PROJECT_HOME%\jar\run.jar
) else (
    set CLASSPATH=%PROJECT_HOME%\class
)

java -classpath "%CLASSPATH%" homework.ch1.Welcome
pause