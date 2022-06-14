cd /d "%~dp0"
git init
git add *
git commit -a -m "version initiale"
git remote add gitHubOriginTpJsf https://didier-tp:password@github.com/didier-tp/m2idef_tpJsf.git
git push -u gitHubOriginTpJsf master
pause

REM open with text editor
REM opne with system editor