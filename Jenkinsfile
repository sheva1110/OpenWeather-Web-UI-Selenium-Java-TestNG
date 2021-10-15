pipeline {
    agent { dockerfile true }
    stages {
        stage('Test') {
            steps {
                sh 'Start grid and node'
                cd src/main/resources
                sh start_grid.sh
                sh 'Start run WEB UI automation testing'
                mvn clean -P chrome,qa test
            }
        }
    }
}
