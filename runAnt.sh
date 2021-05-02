#!/bin/sh

cd AntProject/ant/ || exit
. ./setantenv.sh

cd ..

ant
ant clean