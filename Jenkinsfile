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
                stage('Thread 1') {
                	steps {
                    	    echo 'Thread 1'
                	    sh 'pip list'
                        }
                }
                stage('Thread 2') {
                	steps {
                    	    sh 'pwd'
                            sh 'ls -lah'
                	}
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
