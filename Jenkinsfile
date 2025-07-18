pipeline {
    agent any

    tools {
        jdk 'jdk17'
        gradle 'gradle-8'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/lukaszgolojuch/trainingSauceDemo'
            }
        }

        stage('Install Browsers') {
            steps {
                sh './gradlew playwrightInstall'
            }
        }

        stage('Run Tests') {
            steps {
                sh './gradlew test'
            }
        }

        stage('Publish JUnit Results') {
            steps {
                junit '**/build/test-results/test/*.xml'
            }
        }
    }
}