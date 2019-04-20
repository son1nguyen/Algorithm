pipeline {
    agent any
    stages {
        stage('Build') {
            step {
                sh 'mvn clean package'
            }
            post {
                success {
                	echo 'Now archiving...'
                    archiveArtifacts artifacts: '**'
                }
            }
        }
        stage('Parallel tasks') {
            parallel {
                step {
                    echo 'Thread 1'
                }
                step {
                    echo 'Thread 2'
                }
            }
        }
        stage('Continue serial tasks') {
            step {
            	echo 'Continue with serial task'
            }
        }
    }
}
