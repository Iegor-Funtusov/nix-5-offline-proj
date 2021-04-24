#!/bin/sh
#Before run, you must set ant environment
#run script apache-ant/setantenv.sh for set ant env
ant build
ant jar
ant run