@Library('pipeline-library') _
import java.time.LocalTime
import java.time.LocalDate
import java.time.DayOfWeek

def eu_west_1 = 'https://api.eu-west-1-hf2js.stage.msp.worldpay.io:6443'
def eu_west_2 = 'https://api.eu-west-2-tb1gr.stage.msp.worldpay.io:6443'
def eu_east_1 = 'https://api.us-east-1-aq0mb.stage.msp.worldpay.io/:6443'
def eu_east_2 = 'https://api.us-east-2-m4grn.stage.msp.worldpay.io/:6443'
// for stage(preprod) deployment the versionType should be major,minor or patch(according to the feature)
def versionType ="patch"


pipeline {
    agent {
        kubernetes {
            label 'maven-jdk-11'
            defaultContainer 'maven-jdk-11'
            yaml libraryResource('agents/k8s/maven-jdk-11.yaml')
        }
    }

    environment {
       CURRENT_VERSION = sh (returnStdout: true, script: "git tag --sort version:refname | tail -1").trim()
       APP_NAME = 'apm-paypal'
       // change paypal to actiontopay to deploy the actiontopay in east1 & east2 regions
       DEPLOYMENT_APP_NAME = 'paypal'
       NEXUS_URL = "https://nexus.luigi.worldpay.io"
       //Dev Token
       DEV_NAMESPACE = 'apm-paypal-dev'
       DEV_GKOP_TOKEN_EU_WEST_1 = credentials('maverick-apm-paypal-dev-secret')
       DEV_GKOP_TOKEN_EU_WEST_2 = credentials('Maverick-apm-payapal-dev-secret-eu-west-2')
       DEV_GKOP_TOKEN_EU_EAST_1 = credentials('maverick-apm-actiontopay-dev-secret')
       DEV_GKOP_TOKEN_EU_EAST_2 = credentials('maverick-apm-actiontopay-dev-secret-eu-east-2')

       //Staging Token
       STAGE_NAMESPACE = 'apm-paypal-preprod'
       STAGE_GKOP_TOKEN_EU_WEST_1 = credentials('maverick-apm-paypal-preprod-staging-eu-west-1')
       STAGE_GKOP_TOKEN_EU_WEST_2 = credentials('maverick-apm-paypal-preprod-staging-eu-west-2')
       CHECKMARX_DEV_PROJECT_NAME ='apm-paypal_dev'
       CHECKMARX_PROD_PROJECT_NAME ='apm-paypal_prod'
       CHECKMARX_URL="https://worldpay.checkmarx.net"
       CHECKMARX_HTTP_STATUS= sh(script: "curl -sL -w %{http_code} --output /dev/null ${CHECKMARX_URL}",returnStdout: true)?.trim()

       DEPLOYMENT_POD_CPU_LIMIT='500m'
       DEPLOYMENT_POD_MEMORY_LIMIT='1000Mi'
       APPLICATION_POD_CPU_LIMIT='500m'
       APPLICATION_POD_MEMORY_LIMIT='1000Mi'

       DEPLOYMENT_POD_CPU_REQUESTED='400m'
       DEPLOYMENT_POD_MEMORY_REQUESTED='900Mi'
       APPLICATION_POD_CPU_REQUESTED='400m'
       APPLICATION_POD_MEMORY_REQUESTED='900Mi'

       REPLICAS= "2"
       SPLUNK_INDEX_NPE='gkop-maverick-dev'
       SPLUNK_TOKEN_NPE='REU4MjJFNkUtN0RBQy00QzA5LTg1NDYtNDgzNjUwM0NFRTMx'
       SCALYR_TOKEN_NPE='MHVJYVZ0MTg0R3pYcEJlZm5EV2o5UFdmMURXWVVWVEF1ZEpNWkNRUE9pNUUt'
       SPLUNK_INDEX_PREPROD='gkop-maverick-staging'
       SPLUNK_TOKEN_PREPROD='REU4MjJFNkUtN0RBQy00QzA5LTg1NDYtNDgzNjUwM0NFRTMx'
       SCALYR_TOKEN_PREPROD='MHlyN29FM3g5REd3c3dYczBnMXRQX2xKWjBvNWIvdkcvNVE5c0wwUV92VDgt'



    }


    options {
        buildDiscarder logRotator(artifactDaysToKeepStr: '30', artifactNumToKeepStr: '5', daysToKeepStr: '30', numToKeepStr: '5')
        disableConcurrentBuilds()
        durabilityHint 'PERFORMANCE_OPTIMIZED' //to avoid https://issues.jenkins-ci.org/browse/JENKINS-56945
    }


    stages {
         stage('Determine Project Version') {
                     steps {
                       script{
                          env.VERSION = getUpdatedVersion(versionType,env.CURRENT_VERSION)
                          echo "Project version is ${VERSION}"
                       }
                     }
         }

        stage('APP: Build artifact using Gradle') {
            steps {
                sh """
                    ./gradlew clean build
                    ./gradlew jacocoTestReport
                   """
            }
        }

        stage('Security Gates'){

                 steps {
                     parallel(
                       'Checkmarx Scan': {
                         script{
                               if(env.CHECKMARX_HTTP_STATUS== '200') {
                                  echo "checkmarx Server is up the scan is progressing"
                                   checkmarxRun()
                                    }
                                   else{
                                   echo "CheckMarx Server is Down"
                                    }
                               }
                         },
                       'OWASP Scan': {
                             sh """
                              ./gradlew dependencyCheckAnalyze
                               """
                      },
                      'BlackDuck Scan': {
                            startBlackDuckScan()
                      }

                     )
                 }

                 post {
                     always {
                         dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
                     }

                 }
        }


        stage('APP: Publish Pact report') {
             when {
                    branch 'master'
                   }
             steps {
                    withCredentials([string(credentialsId: 'pact_username', variable: 'PACT_USERNAME'),string(credentialsId: 'pact_password', variable: 'PACT_PASSWORD')])
                                                       {
                    sh """
                       curl -v -XPUT -H "Content-Type: application/json" -u '$PACT_USERNAME':'$PACT_PASSWORD' -d "@paypal-wpg.json"  https://pactbroker-ext.npe.euw1.gw2.worldpay.io/pacts/provider/wpg/consumer/paypal/version/1.0
                       """
                    }
             }
        }


        stage('Dev Deployment') {
              when{
                   allOf{
                      expression{env.BRANCH_NAME != 'master' && VERSION.contains('-SNAPSHOT')}
                   }
              }
              steps {
                    nexusartifactdeployment()
                    gkopdeployment(eu_west_1,eu_west_2,eu_east_1,eu_east_2)

              }
        }


        stage('Integration Testing in Dev') {
              when {
                    allOf{
                          expression{env.BRANCH_NAME != 'master' && VERSION.contains('-SNAPSHOT')}
                         }
              }
              steps {
                    withCredentials([string(credentialsId: 'npe_username', variable: 'NPE_USERNAME'),string(credentialsId: 'npe_password', variable: 'NPE_PASSWORD')])
                    {
                    echo "Run Automation Tests"
                    sleep (500)
                    sh "./gradlew cucumber -Penv=npe -Pusername=${NPE_USERNAME} -Ppassword=${NPE_PASSWORD}"
                    }
              }
              post {
                   failure {
                          echo "Test failed"
                          cucumber buildStatus: 'FAILURE',
                          failedFeaturesNumber: -1,
                          failedScenariosNumber: -1,
                          failedStepsNumber: -1,
                          fileIncludePattern: '**/functional.json',
                          pendingStepsNumber: -1,
                          skippedStepsNumber: -1,
                          sortingMethod: 'ALPHABETICAL',
                          undefinedStepsNumber: -1

                   }
                   success {
                          echo "Test succeeded"
                          cucumber buildStatus: 'SUCCESS',
                          failedFeaturesNumber: 0,
                          failedScenariosNumber: 0,
                          failedStepsNumber: 0,
                          fileIncludePattern: '**/functional.json',
                          pendingStepsNumber: 0,
                          skippedStepsNumber: 0,
                          sortingMethod: 'ALPHABETICAL',
                          undefinedStepsNumber: 0


                   }
              }
        }
        stage('Performance Testing in Dev') {
           when {
             allOf{
               expression{env.BRANCH_NAME != 'master' && VERSION.contains('-SNAPSHOT')}
             }
           }
           steps{
             gatling()
           }
           post {
             always {
               gatlingArchive()
             }
           }
        }



        stage('Stage Deployment') {
              when{
                  allOf{
                      expression{env.BRANCH_NAME == 'master' && !(VERSION.contains('-SNAPSHOT'))}
                  }
              }
              steps {
                   nexusartifactdeployment()
                   gkopBuildAndDeploy(eu_west_1, false, env.STAGE_NAMESPACE, env.STAGE_GKOP_TOKEN_EU_WEST_1)
                   gkopBuildAndDeploy(eu_west_2, false, env.STAGE_NAMESPACE, env.STAGE_GKOP_TOKEN_EU_WEST_2)

              }
              post{
               success {
                 pushreleaseversion()
               }
              }
        }

        stage('Integration Testing in Stage') {
            when {
               allOf{
                  expression{env.BRANCH_NAME == 'master' && !(VERSION.contains('-SNAPSHOT'))}
               }
            }
            steps {
               withCredentials([string(credentialsId: 'preprod_username', variable: 'PREPROD_USERNAME'),string(credentialsId: 'preprod_password', variable: 'PREPROD_PASSWORD')])
               {
               echo "Run Automation Tests"
               sleep (500)
               sh "./gradlew cucumber -Penv=preprod -Pusername=${PREPROD_USERNAME} -Ppassword=${PREPROD_PASSWORD}"
               }
            }
            post {
                   failure {
                          echo "Test failed"
                          cucumber buildStatus: 'FAILURE',
                          failedFeaturesNumber: -1,
                          failedScenariosNumber: -1,
                          failedStepsNumber: -1,
                          fileIncludePattern: '**/functional.json',
                          pendingStepsNumber: -1,
                          skippedStepsNumber: -1,
                          sortingMethod: 'ALPHABETICAL',
                          undefinedStepsNumber: -1

                   }
                   success {
                          echo "Test succeeded"
                          cucumber buildStatus: 'SUCCESS',
                          failedFeaturesNumber: 0,
                          failedScenariosNumber: 0,
                          failedStepsNumber: 0,
                          fileIncludePattern: '**/functional.json',
                          pendingStepsNumber: 0,
                          skippedStepsNumber: 0,
                          sortingMethod: 'ALPHABETICAL',
                          undefinedStepsNumber: 0


                   }
              }
        }
         stage("Generate Build reports"){
            steps{
                  publishHTML (target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: false,
                    keepAll: true,
                    reportDir: "${env.WORKSPACE}/",
                    reportFiles: '/*.pdf',
                    reportName: "Build Report"
                  ])
            }
        }

    }
}

def checkmarxRun() {
      def CHECKMARX_PROJECT_NAME = ""
      if(env.BRANCH_NAME == 'master' && !(VERSION.contains('-SNAPSHOT'))){
            CHECKMARX_PROJECT_NAME = env.CHECKMARX_PROD_PROJECT_NAME
      }
      else{
        CHECKMARX_PROJECT_NAME = env.CHECKMARX_DEV_PROJECT_NAME
      }

    step([$class: 'CxScanBuilder',
           comment: 'Scanned From Jenkins Pipeline',
           credentialsId: 'maverick-checkmarx-id',
           excludeFolders: 'test, target, .mvn, build, apm-paypal-testing, wpg-simulator',
           exclusionsSetting: 'job',
           failBuildOnNewResults: false,
           failBuildOnNewSeverity: 'HIGH',
           fullScanCycle: 10,
           groupId: '365',
           highThreshold: 0,
           lowThreshold: 10,
           mediumThreshold: 5,
           preset: '100000',
           projectName: CHECKMARX_PROJECT_NAME,
           sastEnabled: true,
           serverUrl: 'https://worldpay.checkmarx.net',
           sourceEncoding: '1',
           useOwnServerCredentials: true,
           vulnerabilityThresholdResult: 'FAILURE',
           waitForResultsEnabled: true ,
           generatePdfReport: true,
           filterPattern: '''!**/_cvs/**/*, !**/.svn/**/*,   !**/.hg/**/*,   !**/.git/**/*,  !**/.bzr/**/*, !**/bin/**/*,
                            !**/obj/**/*,  !**/backup/**/*, !**/.idea/**/*, !**/*.DS_Store, !**/*.ipr,     !**/*.iws,
                            !**/*.bak,     !**/*.tmp,       !**/*.aac,      !**/*.aif,      !**/*.iff,     !**/*.m3u, !**/*.mid, !**/*.mp3,
                            !**/*.mpa,     !**/*.ra,        !**/*.wav,      !**/*.wma,      !**/*.3g2,     !**/*.3gp, !**/*.asf, !**/*.asx,
                            !**/*.avi,     !**/*.flv,       !**/*.mov,      !**/*.mp4,      !**/*.mpg,     !**/*.rm,  !**/*.swf, !**/*.vob,
                            !**/*.wmv,     !**/*.bmp,       !**/*.gif,      !**/*.jpg,      !**/*.png,     !**/*.psd, !**/*.tif, !**/*.swf,
                            !**/*.jar,     !**/*.zip,       !**/*.rar,      !**/*.exe,      !**/*.dll,     !**/*.pdb, !**/*.7z,  !**/*.gz,
                            !**/*.tar.gz,  !**/*.tar,       !**/*.gz,       !**/*.ahtm,     !**/*.ahtml,   !**/*.fhtml, !**/*.hdm,
                            !**/*.hdml,    !**/*.hsql,      !**/*.ht,       !**/*.hta,      !**/*.htc,     !**/*.htd, !**/*.war, !**/*.ear,
                            !**/*.htmls,   !**/*.ihtml,     !**/*.mht,      !**/*.mhtm,     !**/*.mhtml,   !**/*.ssi, !**/*.stm, !**/*.html,
                            !**/*.stml,    !**/*.ttml,      !**/*.txn,      !**/*.xhtm,     !**/*.xhtml,   !**/*.class, !**/*.iml, !Checkmarx/Reports/*.*'''

           ])
}

def startBlackDuckScan() {

         def DETECT_SCRIPT_URL = "https://detect.synopsys.com/detect7.sh"
         def BLACKDUCK_URL = "https://fis2.app.blackduck.com"
         def PROJECT_NAME = "APM_PayPal_30000303"
         def SOURCE_DIR = "apm-paypal/build/libs"
         def BD_PROJECT_VERSION = "sandbox"

      if (env.BRANCH_NAME =="master" && !(VERSION.contains('-SNAPSHOT'))) {
        BD_PROJECT_VERSION = VERSION
      }

    withCredentials([string(credentialsId: 'BLACKDUCK_TOKEN', variable: 'BLACKDUCK_TOKEN')]) {

         sh """
                        curl -O ${DETECT_SCRIPT_URL}
                        chmod +x detect7.sh
                        JENKINS_NODE_COOKIE=dontKillMe nohup bash \\
                        ./detect7.sh --blackduck.url=${BLACKDUCK_URL} \\
                                    --blackduck.api.token=${BLACKDUCK_TOKEN} \\
                                    --detect.project.name=${PROJECT_NAME} \\
                                    --detect.project.version.name=${BD_PROJECT_VERSION} \\
                                    --detect.source.path=${SOURCE_DIR} \\
                                    --detect.project.codelocation.unmap=true \\
                                    --detect.timeout=1500 \\
                                    --detect.cleanup=false \\
                                    --detect.risk.report.pdf=true \\
                                    --detect.risk.report.pdf.path=${env.WORKSPACE}/apm-paypal/build/reports/
         """
    }
}

def nexusartifactdeployment() {

        echo "Run gradle deploy"
        withCredentials([usernamePassword(credentialsId: 'nexus-deployer', usernameVariable: 'NEXUS_USER', passwordVariable: 'NEXUS_PASS')]) {
          sh "./gradlew publish --info"
        }
 }

def gkopBuildAndDeploy(def cluster, def dryRun, def NAMESPACE, def GKOP_TOKEN) {
    def ocCmd = "oc"
    sh "${ocCmd} login ${cluster} --token=${GKOP_TOKEN}"

    def branchRef = env.BRANCH_NAME
    if (branchRef ==~ /PR-[0-9]+/) {
        branchRef = (branchRef =~ /PR-/).replaceFirst('pull/') + '/head'
    }

    sh "${ocCmd} project ${NAMESPACE}"
    sh "${ocCmd} process -f ocp/common.yml NMSPACE=${NAMESPACE} IMG_TAG=${VERSION} | ${ocCmd} apply --dry-run=${dryRun}  -n ${NAMESPACE} -f -"
    sh "${ocCmd} process -f ocp/build.yml BRANCH_NAME_HY=${branchRef} IMG_TAG=${VERSION} | ${ocCmd} apply --dry-run=${dryRun}  -n ${NAMESPACE} -f -"

   if (env.BRANCH_NAME == "master") {
        def version = VERSION
        String repo = version.endsWith('-SNAPSHOT') ? 'maven-snapshots' : 'maven-releases'
        String path = "com/worldpay/apm/${env.APP_NAME}/${version}"

        sh "${ocCmd} process -f ocp/deployment.yml NMSPACE=${NAMESPACE} DEPLOYMENT_POD_CPU_LIMIT=${env.DEPLOYMENT_POD_CPU_LIMIT} DEPLOYMENT_POD_MEMORY_LIMIT=${env.DEPLOYMENT_POD_MEMORY_LIMIT} DEPLOYMENT_POD_CPU_REQUESTED=${env.DEPLOYMENT_POD_CPU_REQUESTED} DEPLOYMENT_POD_MEMORY_REQUESTED=${env.DEPLOYMENT_POD_MEMORY_REQUESTED} APPLICATION_POD_CPU_LIMIT=${env.APPLICATION_POD_CPU_LIMIT} APPLICATION_POD_MEMORY_LIMIT=${APPLICATION_POD_MEMORY_LIMIT} APPLICATION_POD_CPU_REQUESTED=${env.APPLICATION_POD_CPU_REQUESTED} APPLICATION_POD_MEMORY_REQUESTED=${env.APPLICATION_POD_MEMORY_REQUESTED} REPLICAS=${env.REPLICAS} IMG_TAG=${VERSION} SPLUNK_INDEX=${env.SPLUNK_INDEX_PREPROD} SPLUNK_TOKEN=${env.SPLUNK_TOKEN_PREPROD} SCALYR_TOKEN=${env.SCALYR_TOKEN_PREPROD} | ${ocCmd} apply  --dry-run=${dryRun} -n ${NAMESPACE} -f -"

        sh "${ocCmd} start-build ${env.APP_NAME} --follow -n ${NAMESPACE} --env=APP_DOWNLOAD_URL=${env.NEXUS_URL}/repository/${repo}/${path}/${env.APP_NAME}-${version}.jar"

        sh "${ocCmd} rollout latest dc/${env.APP_NAME}"
   }

   if (env.BRANCH_NAME != "master") {
           def version= VERSION
           String repo = version.endsWith('-SNAPSHOT') ? 'maven-snapshots' : 'maven-releases'
           String path = "com/worldpay/apm/${env.APP_NAME}/${version}"
           String metadataURL = "${env.NEXUS_URL}/repository/${repo}/${path}/maven-metadata.xml"
           String snapshotVersion = snapshotVersion metadataURL

           sh "${ocCmd} process -f ocp/deployment.yml NMSPACE=${NAMESPACE} DEPLOYMENT_POD_CPU_LIMIT=${env.DEPLOYMENT_POD_CPU_LIMIT} DEPLOYMENT_POD_MEMORY_LIMIT=${env.DEPLOYMENT_POD_MEMORY_LIMIT} DEPLOYMENT_POD_CPU_REQUESTED=${env.DEPLOYMENT_POD_CPU_REQUESTED} DEPLOYMENT_POD_MEMORY_REQUESTED=${env.DEPLOYMENT_POD_MEMORY_REQUESTED} APPLICATION_POD_CPU_LIMIT=${env.APPLICATION_POD_CPU_LIMIT} APPLICATION_POD_MEMORY_LIMIT=${APPLICATION_POD_MEMORY_LIMIT} APPLICATION_POD_CPU_REQUESTED=${env.APPLICATION_POD_CPU_REQUESTED} APPLICATION_POD_MEMORY_REQUESTED=${env.APPLICATION_POD_MEMORY_REQUESTED} REPLICAS=${env.REPLICAS} IMG_TAG=${VERSION} SPLUNK_INDEX=${env.SPLUNK_INDEX_NPE} SPLUNK_TOKEN=${env.SPLUNK_TOKEN_NPE} SCALYR_TOKEN=${env.SCALYR_TOKEN_NPE} | ${ocCmd} apply  --dry-run=${dryRun} -n ${NAMESPACE} -f -"

           sh "${ocCmd} start-build ${env.APP_NAME} --follow -n ${NAMESPACE} --env=APP_DOWNLOAD_URL=${env.NEXUS_URL}/repository/${repo}/${path}/${env.APP_NAME}-${snapshotVersion}.jar"
           sh "${ocCmd} rollout latest dc/${env.APP_NAME}"
      }
}


def getUpdatedVersion(def versionType, def currentVersion){
      def split = currentVersion.split('\\.')
   if(env.BRANCH_NAME == "master" && versionType.length() > 0){
          switch (versionType){
             case "patch":
               split[2]=Integer.valueOf((split[2]))+1
               return (split.join('.')).trim()
             case "minor":
               split[1]=Integer.valueOf((split[1]))+1
               split[2] =0
               return (split.join('.')).trim()
             case "major":
              split[0]=Integer.valueOf((split[0]))+1
              split[1] = 0
              split[2] = 0
              return (split.join('.')).trim()
             default:
               split[2] = Integer.valueOf((split[2]))+1
               return (split.join('.')+"-SNAPSHOT").trim()
           }

   }
   else{
      split[2] = Integer.valueOf((split[2]))+1
      return (split.join('.')+"-SNAPSHOT").trim()
   }
}

def pushreleaseversion(){
    withCredentials([usernamePassword(credentialsId: 'Githubsvc', usernameVariable: 'USER', passwordVariable: 'PASS')]){
             sh """
                   git config --global user.email ecomm-bangalore-A4E-team-mavericks@fisglobal.com
                   git config --global user.name svc-a4e-mavericks
                   git tag -a "${VERSION}" -m  'Released "${VERSION}"'
                   git config --local credential.helper '!f() { echo username=${USER}; echo password=${PASS}; }; f'
                   git push origin ${VERSION}
                """

        }
}
def gatling(){
        try {
           withCredentials([string(credentialsId: 'authtoken', variable: 'TOKEN')]) {

           sh "./gradlew loadTest -Ptoken=${TOKEN}"

           }
        }
        catch (err) {
          echo "Error Occured in performance Testing: ${err}"
          currentBuild.result = 'SUCCESS'
          return

        }

}

def gkopdeployment(def eu_west_1, def eu_west_2, def eu_east_1, def eu_east_2){

     if(env.DEPLOYMENT_APP_NAME == "paypal"){
          gkopBuildAndDeploy(eu_west_1, false, env.DEV_NAMESPACE, env.DEV_GKOP_TOKEN_EU_WEST_1)
          gkopBuildAndDeploy(eu_west_2, false, env.DEV_NAMESPACE, env.DEV_GKOP_TOKEN_EU_WEST_2)
     }
     else{
         gkopBuildAndDeploy(eu_east_1, false, env.DEV_NAMESPACE, env.DEV_GKOP_TOKEN_EU_EAST_1)
         gkopBuildAndDeploy(eu_east_2, false, env.DEV_NAMESPACE, env.DEV_GKOP_TOKEN_EU_EAST_2)
     }
}
