project_name = "jenkins-pipeline-python"
repo =  "git@github.com:jacolmenares/test-jenkins1.git"
repo_name = "repotest"

pipelineJob(project_name) {
	definition {
	   triggers{
		scm('H/3 * * * *')
	   }
	   
	   cpsScm{
		scm {
		    git {
			remote {
			name(repo_name)
			url(repo)
			}
		    }
		    scriptPath("Jenkinsfile")
		}
	   }
   }
}
