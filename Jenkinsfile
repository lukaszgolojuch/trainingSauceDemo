pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/lukaszgolojuch/trainingSauceDemo.git'
            }
        }

        stage('Run Tests') {
            steps {
                sh './gradlew test'
            }
        }

        stage('Publish Results') {
            steps {
                junit '**/build/test-results/test/*.xml'
            }
        }
    }
}