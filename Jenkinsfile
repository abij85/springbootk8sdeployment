pipeline {

    parameters {
        choice(
            name: 'deploy_to_env',
            choices: ['env1', 'env2'],
            description: 'target_env'
        )
    }
    agent {
     label 'labelled agent or any'
    }
    environment {
     //fetch required credentials using credentials from Jenkins secret , if any
    // initialize variables like DOCKER_REGISTRY-PATH etc
    }

    stages {
        stage('init') {
            steps {
                // steps required to initialize pipeline
                // im putting only prototype here
                // INITIALIZE _JAVA_OPTIONS so that liquibase can fetch ssl authntication configuration at application startup
            }
        }

        stage ('Build') {
            mvn clean install
            mkdir container_root_folder_for_docker
            cp -rf target/infraautomation-*.jar container_root_folder_for_docker/infraautomation.jar
        }
        post {
            failure {
                //notify in case build fails
            }
        }

        stage('prepare docker-image'){
            //prototype of steps required
            sh '''
                docker build -t registry_path .
                docker login -u docker_user -p docker_pass
                docker push registry_path
                docker logout
            '''
        }

        stage('kubernetes-login and deploy image') {

         kubectl login --token
         kubectl process -f infrastructure/kubernetes/job.yaml -p // set parameters for yaml
        }
    }
}