#!/bin/bash

cd $(dirname $0)

codeBase=$1

usage() {
    echo "$0 front [command]"
    echo "$0 back [command]"

    echo " ==== examples === "
    echo "To run `cd frontvue; gulp run dev`"
    echo "$0 front dev"
    echo "To run `cd backspark; gradlew run`"
    echo "$0 back run"
    exit 1
}

runFront() {
    cd frontvue
    gulp $1 $2 $3 $4 $5
    exit 0
}

runBack() {
    cd backspark
    ./gradlew $1 $2 $3 $4 $5
    exit 0
}

case "$codeBase" in
    front)
     runFront $2 $3 $4 $5 $6
     ;;
    back)
     runBack $2 $3 $4 $5 $6
     ;;
    *)
     usage;
     ;;
esac
