pipeline {
  agent any
  environment {
    CODING_MAVEN_REPO_ID="${CCI_CURRENT_TEAM}-${PROJECT_NAME}-${MAVEN_REPO_NAME}"
    CODING_MAVEN_REPO_URL="${CCI_CURRENT_WEB_PROTOCOL}://${CCI_CURRENT_TEAM}-maven.pkg.${CCI_CURRENT_DOMAIN}/repository/${PROJECT_NAME}/${MAVEN_REPO_NAME}/"
  }
  stages {
    stage('检出代码') {
      steps {
        checkout([$class: 'GitSCM',
        branches: [[name: GIT_BUILD_REF]],
        userRemoteConfigs: [[
          url: GIT_REPO_URL,
          credentialsId: CREDENTIALS_ID
        ]]])
      }
    }
    stage('编译构建') {
      steps {
        sh 'mvn clean package'
      }
    }
    stage('单元测试') {
      steps {
        sh 'mvn test'
      }
      post {
        always {
          // 收集测试报告
          junit 'target/surefire-reports/*.xml'
        }
      }
    }
    // 如果不需要通过命令的方式指定版本号，这一步可以省略
    stage('修改版本号') {
      steps {
        sh "mvn versions:set -DnewVersion=${CODING_MAVEN_VERSION}"
      }
    }
    stage('发布到 maven 制品库') {
      steps {
        echo '发布中...'
        withCredentials([
            usernamePassword(
              credentialsId: "${CODING_ARTIFACTS_CREDENTIALS_ID}",
              usernameVariable: 'CODING_MAVEN_REG_USERNAME',
              passwordVariable: 'CODING_MAVEN_REG_PASSWORD'
            )
          ]) {
            sh 'mvn deploy -s ./settings.xml -DskipTests'
        }
        echo '发布完成.'
      }
    }
  }
}