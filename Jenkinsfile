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
      parallel {
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

        stage('sonar') {
          steps {
            sh '''./gradlew sonarqube \\
  -Dsonar.projectKey=testpage \\
  -Dsonar.host.url=http://153.127.20.106:4902 \\
  -Dsonar.login=8e949d8c952f2a43763e9355a194a5ecf53082ed'''
          }
        }

      }
    }

    stage('error') {
      steps {
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