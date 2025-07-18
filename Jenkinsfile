pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/NAZWA_UZYTKOWNIKA/jenkins-demo.git'
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