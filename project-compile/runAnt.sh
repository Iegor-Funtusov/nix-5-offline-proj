#!/bin/sh

cd antProject/ant/ || exit
. ./setantenv.sh

cd ..

ant
ant clean