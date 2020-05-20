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
              sh './gradlew -Dsonar.host.url=http：//153.127.20.106：4902 sonarqube'
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