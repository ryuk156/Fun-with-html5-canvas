#!/usr/bin/env groovy


def fetch() {

	def response = sh(script: 'curl https://api.github.com/users/ryuk156/repos')
	println(response[0])
}

return this