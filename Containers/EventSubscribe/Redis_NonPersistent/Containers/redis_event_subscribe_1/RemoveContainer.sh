clear

. Container.properties
. ContainerInfo.info

if [ "$(docker ps -aq -f status=running -f name=$containerName)" ]; then
      docker stop $containerName
      docker rm $containerName
else
      docker rm $containerName
fi
