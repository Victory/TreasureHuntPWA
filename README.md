# Treasure Hunt PWA
A Treasure Hunt Orogressive Web App (PWA) Built with [Vue](https://vuejs.org/) and [Spark](http://sparkjava.com/)


### Building

There are three main development processes to consider. 
The frontend, the backend and the proxy.

The frontend called frontvuew lives in frontvue directory and is powered by Vue. 
`frontvue` is controlled by Gulp and package management is done via yarn.

The backend lives in backspark and is powered by Javaspark. `backspark` is managed
with gradle.

The proxy lives in `devproxy` and is a simple node/express script to serve both the frontend and
backend during development. 

#### Node
You will need to have NVM installed. You can download and install nvm
 by following the instructions [here](https://github.com/creationix/nvm).

We use gulp and yarn. Gulp raps the yarn/npm tasks.

Run 

    nvm install --lts 6
    nvm use --lts
    npm install --global gulp-cli
    npm install --global yarn

### Java
You will need to have java8 jdk in your JAVA_HOME

Download [jdk8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) then run `export JAVA_HOME="/path/to/jdk8"`

### tasks.sh

There is a tasks.sh file to simplify running the three main dev processes
