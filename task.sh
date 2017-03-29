#!/bin/bash

cd $(dirname $0)
codeBase=$1

source javaHome.sh

export NVM_DIR="$HOME/.nvm"
[ -s "$NVM_DIR/nvm.sh" ] && \. "$NVM_DIR/nvm.sh"  # This loads nvm

echo "This script requires NVM and jdk8 be installed."
echo "Using nvm: $NVM_DIR"
echo "Using JAVA_HOME: $JAVA_HOME"
nvm install 6 --lts
nvm use 6 --lts

nodeVersion=$(node --version)
echo "node version v6.10 or later needed using $nodeVersion"
npmVersion=$(npm --version)
echo "npm version 0.21.3 or later required using $npmVersion "

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
    pwd
    echo "Running: gulp $1 $2 $3 $4 $5"
    gulp $1 $2 $3 $4 $5
    exit 0
}

runBack() {
    cd backspark
    pwd
    echo "Running: ./gradlew $1 $2 $3 $4 $5"
    ./gradlew $1 $2 $3 $4 $5
    exit 0
}

dieNotZero() {
    if [ "$1" -eq "0" ]; then
        return
    fi

    echo "Existing to do error"
    exit 1;
}

startDev() {
    thisPid=$$

    cd devproxy;
    node dev.js &
    proxyPid=$!
    result=$?
    dieNotZero $?

    cd ../frontvue
    node build/dev-server.js &
    frontPid=$!
    dieNotZero $?

    cd ../backspark
    ./gradlew run &
    backPid=$!
    dieNotZero $?
    cd ..

    sleep 5

    echo "backPid $backPid"
    echo "frontPid $frontPid"
    echo "proxyPid $proxyPid"

    echo ""
    echo ""
    echo ""
    echo ""
    op="keepgoing"
    while [ "$op" != "quit" ]; do
        echo "Now Serving type 'quit' then ENTER to exit"
        read op
    done

    kill -9 ${proxyPid}
    sleep .5
    kill -9 ${frontPid}
    sleep .5
    kill -9 ${backPid}
    sleep 1
    pkill ${thisPid}
}

runInit() {
    cd frontvue
    npm upgrade
    yarn

    cd ../backspark
    ./gradlew build
}


case "$codeBase" in
    init)
        runInit
        ;;
    front)
        runFront $2 $3 $4 $5 $6
        ;;
    back)
        runBack $2 $3 $4 $5 $6
        ;;
    startdev)
        startDev
        ;;
    *)
        usage;
        ;;
esac
