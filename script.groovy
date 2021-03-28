#!/usr/bin/env groovy

package org.kohsuke.github
@Grab(group='org.kohsuke', module='github-api', version='1.75')
import org.kohsuke.github.GitHub

def fetch() {

	println("hello")
	def repos = []
	def org = 'terasology';
	def githubCom = GitHub.connectUsingOAuth('ddae1e41099bb89a636241818107dff969c27695');

	githubCom.getOrganization(org).listRepositories().each {
		repos << it.getName()
	}
	println(repos)
	return repos
}

return this