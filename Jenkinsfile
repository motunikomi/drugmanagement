pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        sh '''chmod +x ./gradlew
		./gradlew clean assemble'''
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

    stage('') {
      steps {
        cleanWs(cleanWhenFailure: true)
      }
    }

  }
  environment {
    resultPath = 'build/test-results/**/TEST-*.xml'
    jacocoReportDir = 'build/jacoco'
    checkstyleReport = 'build/reports/checkstyle/*.xml'
    pmdReport = 'build/reports/*.xml'
    spotbugsReport = 'build/reports/spotbugs/*.xml'
  }
}