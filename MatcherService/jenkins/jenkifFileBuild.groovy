
node('java-11') {
 

		
		
		def artifactory = getArtifactory()
		def currentVersion = getCurrentVersion()
		def newVersion = getNewVersion()
		def pomVersion = getPomVersion()
        stage("Unit tests") {
            try {
                
                String mavenGoals = "clean test"
                artifactory.mvn.run  goals: mavenGoals
            } catch (Exception e) {
                println e.getMessage()
                throw e
            }
        }

        stage("add new version") {
            try {
                              
                String mavenNewVersionGoals = "-B -V -U -e versions:set -DnewVersion=${newVersion} -DoldVersion=${pomVersion} -DgroupId=* -DartifactId=* versions:commit"

                artifactory.mvn.run  goals: mavenNewVersionGoals
            } catch (Exception e) {
                println e.getMessage()
                throw e
            }
        }

        stage("Build a Jar file") {
            try {
                
                String mavenInstallGoals = "install -DskipTests"
                
                arty.mvn.run  goals: mavenInstallGoals
                lifecycleTagger.gitTag("${currentVersion}")
				addTag(
            }
            catch (Exception e) {
                println e.getMessage()
                throw e
            }
        }
}


