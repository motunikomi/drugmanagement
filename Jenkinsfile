pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        sh 'chmod +x ./gradlew'
        sh './gradlew clean assemble'
      }
    }

    stage('test') {
      post {
        success {
          junit resultPath
          recordIssues(tool: checkStyle(pattern: checkstyleReport))
          recordIssues(tool: pmdParser(pattern: pmdReport))
          recordIssues(tool: spotBugs(pattern: spotbugsReport))
        }

      }
      steps {
        sh './gradlew build check'
      }
    }

    stage('error') {
      steps {
        withSonarQubeEnv('SonarQube') {
          sh '''./gradlew sonarqube \\
  -Dsonar.projectKey=drugmanagement \\
  -Dsonar.host.url=http://153.127.20.106:4902 \\
  -Dsonar.login=6ed48d56ac6851c52d08728964d74a411e57a323'''
        }

        cleanWs(cleanWhenFailure: true)
      }
    }

  }
  environment {
    resultPath = 'build/test-results/**/TEST-*.xml'
    jacocoReportDir = 'build/jacoco'
    checkstyleReport = 'build/reports/checkstyle/*.xml'
    pmdReport = 'build/reports/pmd/*.xml'
    spotbugsReport = 'build/reports/spotbugs/*.xml'
  }
}