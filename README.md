# springboot-k8s-deployment
I have created this prototype project to give some glimps how actually this database deployment can be automated using liquibase.
*- used a single project for infra provisioning showcase
*- infrastructure -kubernetes - used for provisioning
*- provisioning can be done automated using helm charts
*- dockerfile use to create docker image from source
*- java files are to initialize ssl cofigs and start spring boot application
*- changelog xml files are having details what all query needs to be applied through kubernetes container in database


to deploy an app using spring boot
Using ***
spring boot
docker
kubernetes
jenkins
yaml
liquibase
