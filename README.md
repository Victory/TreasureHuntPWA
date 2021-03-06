# Treasure Hunt PWA
A Treasure Hunt Orogressive Web App (PWA) Built with [Vue](https://vuejs.org/) and [Spark](http://sparkjava.com/)

### Building

#### Quick start

 1. install [jdk8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and [nvm](https://github.com/creationix/nvm)
 2. clone this repository
 3. `cp config-paths.sh.dist config-paths.sh`
 4. edit `config-paths.sh` setting path to JAVA_HOME, Mongodb url, etc...
 5. run `chmod +x task.sh`
 6. run `./task.sh upgrade`
 7. assuming everything went ok you can now start the servers with `./task.sh startdev`
 
The server should now be running on http://localhost:8080

#### Structure

There are three main development processes to consider. The frontend, the backend and the proxy.

The frontend called frontvuew lives in frontvue directory and is powered by Vue. 
`frontvue` is controlled by Gulp and package management is done via yarn. During development
the proxy is also run from here.

The backend lives in backspark and is powered by Javaspark. `backspark` is managed
with gradle.

#### Ports and Process
Here are a list of ports and commands to find the PIDS so that if their is 
a lost process it can be `kill`


| codebase  | port |
|-----------|------|
| frontvue  | 8080 |
| backspark | 4567 |


Kill commands

    kill $(ps aux | grep node | grep [d]ev-server.js | awk '{print $2}')
    kill $(ps aux | grep gradle-wrapper.jar | grep [r]un | awk '{print $2}') 

#### Trouble Shooting

Each process can only run once on the same machine as they all bind to an PORT
The Node projects will throw a `ECONNREFUSED` error message
