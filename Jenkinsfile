pipeline {
    agent any
    stages {
        stage('Build'){
        steps{
                echo 'Building....'
                sh 'mvn clean package'
                archiveArtifacts artifacts:'**/target/*.jar'
            }
        }
        stage('Test'){
            steps{
                sh 'mvn test -B'
            }

        }
        stage('Deploy'){
            steps{
                withCredentials([[$class          : 'UsernamePasswordMultiBinding',
                                              credentialsId   : 'PCF_LOGIN',
                                              usernameVariable: 'USERNAME',
                                              passwordVariable: 'PASSWORD']]){
                                    sh '/usr/bin/cf login -a https://api.run.pivotal.io -u $USERNAME -p $PASSWORD'
                                    sh '/user/bin/cf target -o uki-engineering -s Academy-S2'
                                    sh '/user/bin/cf push'
                                }
            }

        }
    }


}