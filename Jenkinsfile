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
  -Dsonar.host.url=http://153.127.20.106:4902 \\'''
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