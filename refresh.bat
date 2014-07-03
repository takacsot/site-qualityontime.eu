git pull origin master

call nanoc compile

call groovy.bat scripts/mediacenter.groovy

call groovy.bat scripts/upload.groovy

echo %DATE%_%TIME% > last_run.txt