java -Xms1024M -Xmx1024M -javaagent:jrebel.jar -Drebel.remoting_plugin=true -Drebel.remoting_port=4321 -Xdebug -Xrunjdwp:transport=dt_socket,address=25565,server=y,suspend=n -jar craftbukkit.jar
PAUSE