pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
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
                steps {
                    echo 'Thread 1'
                }
                steps {
                    echo 'Thread 2'
                }
            }
        }
        stage('Continue serial tasks') {
            steps {
            	echo 'Continue with serial task'
            }
        }
    }
}
