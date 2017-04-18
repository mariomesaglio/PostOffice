clear

. Container.properties
. ContainerInfo.info

# Does the container exists?
if [ ! "$(docker ps -q -f id=$containerID)" ]; then

  if [ "$(docker ps -aq -f status=exited -f id=$containerID)" ]; then
      # Removing invalid container.
      docker rm $containerName
  fi
    # Creating the container.
    containerID=$(docker run -d -p $mulePort:8081 --name $containerName -v $PWD/MuleApps:/opt/mule/apps -v $PWD/MuleLogs:/opt/mule/logs -v $PWD/MuleDomains:/opt/mule/domains $containerImage)
    echo 'containerID='$containerID >> ./ContainerInfo.info
    echo 'redisPort='$redisPort >> ./ContainerInfo.info
else
  # Starting the container.
  docker start $containerName
fi
