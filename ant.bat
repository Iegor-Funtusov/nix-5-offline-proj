@echo off
set ANT_OPTS=-Xmx2G -Dfile.encoding=UTF-8
set ANT_HOME=%~dp0ant\apache-ant-1.10.10
set PATH=%ANT_HOME%\bin;%PATH%
cd unit_1 & cd ant & ant -version & ant clean & ant compile & ant jar & ant run
