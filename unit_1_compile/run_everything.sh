echo
echo "------- CONSOLE RUN -------"
echo
cd console
. console_run.sh
echo
echo "------- ANT RUN -------"
echo
cd ../ant
. ant_run.sh
echo
echo "------- MAVEN RUN -------"
echo
cd ../maven/app
. maven_run.sh
echo