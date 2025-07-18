pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/lukaszgolojuch/trainingSauceDemo'
            }
        }
        stage('Build') {
            steps {
                echo 'Budowanie projektu...'
            }
        }
        stage('Test') {
            steps {
                echo 'Uruchamianie testów...'
            }
        }
    }
}