clear

action=$1
containerName=$2
redisContainerName='redis_'$containerName

mulePort=$3

redisPort=$4

if [ $action = 'CREATE' ]; then

  if [ $mulePort = '']; then
    echo "MUST DEFINE MULE PORT"
    exit
  fi

  if [ $redisPort = '']; then
    echo "MUST DEFINE REDIS PORT"
    exit
  fi

  cd ../Redis_NonPersistent/ContainerManager
  $(./ContainerManager.sh CREATE $redisContainerName $redisPort)
  redisHost=$(docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' $redisContainerName)

  cd ../../ContainerManager
  mkdir -p ../Containers/
  mkdir -p ../Containers/$containerName

  cp -R ./Template/* ../Containers/$containerName/

  echo 'containerName='$containerName >> ../Containers/$containerName/Container.properties
  echo 'mulePort='$mulePort >> ../Containers/$containerName/Container.properties

  echo 'redis.host='$redisHost >> ../Containers/$containerName/MuleApps/event_subscription/mule-app.properties
  echo 'redis.port=6379' >> ../Containers/$containerName/MuleApps/event_subscription/mule-app.properties

  echo 'redis.host='$redisHost >> ../Containers/$containerName/MuleApps/event_subscription/classes/mule-app.properties
  echo 'redis.port=6379' >> ../Containers/$containerName/MuleApps/event_subscription/classes/mule-app.properties

  cd ../Containers/$containerName
  ./RunOrStartContainer.sh

else

  if [ $action = 'REMOVE' ]; then

    cd ../Redis_NonPersistent/ContainerManager
    $(./ContainerManager.sh REMOVE $redisContainerName)

    cd ../../ContainerManager
    cd ../Containers/$containerName
    ./RemoveContainer.sh
    cd ..
    rm -R ./$containerName

  else
      echo "INVALID ACTION"
  fi

fi
