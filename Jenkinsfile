pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        sh '''chmod +x ./gradlew
./gradlew assemble'''
      }
    }

    stage('test') {
      steps {
        sh './gradlew test'
      }
    }

  }
}