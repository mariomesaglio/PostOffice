clear

action=$1
containerName=$2

redisPort=$3

if [ $action = 'CREATE' ]; then

  if [ $redisPort = '']; then
    echo "MUST DEFINE PORT"
    exit
  fi

  mkdir -p ../Containers/
  mkdir -p ../Containers/$containerName

  cp -R ./Template/* ../Containers/$containerName/

  echo 'containerName='$containerName >> ../Containers/$containerName/Container.properties
  echo 'redisPort='$redisPort >> ../Containers/$containerName/Container.properties

  cd ../Containers/$containerName
  ./RunOrStartContainer.sh

else

  if [ $action = 'REMOVE' ]; then

    cd ../Containers/$containerName
    ./RemoveContainer.sh
    cd ..
    rm -R ./$containerName

  else
      echo "INVALID ACTION"
  fi

fi
