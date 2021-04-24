#!/bin/bash

export ANT_HOME=apache-ant-1.9.15/
export PATH=$ANT_HOME/bin/:$PATH

ant clean && ant compile && ant jar && ant run