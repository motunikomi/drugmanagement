pipeline {
  agent any
  environment {
    resultPath = "build/test-results/**/TEST-*.xml"
    jacocoReportDir = "build/jacoco"
    checkstyleReport = "build/reports/checkstyle/*.xml"
    pmdReport = "build/reports/*.xml"
    spotbugsReport = "build/reports/spotbugs/*.xml"

  }
  stages {
    stage('build') {
      steps {
        sh '''chmod +x ./gradlew
		./gradlew clean assemble'''
      }
    }

    stage('test') {
      steps {
        sh './gradlew test'
      }
      post {
      	success {
          junit resultPath
          jacoco execPattern: "${jacocoReportDir}/*.exec", exclusionPattern: '**/*Test.class'
          recordIssues tool: checkStyle(pattern: checkstyleReport)
          recordIssues tool: pmdParser(pattern: pmdReport)
          recordIssues tool: spotBugs(pattern: spotbugsReport)
      	}
      }
    }
  }
}