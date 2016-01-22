package com.oracle.grailshackathon

import grails.converters.JSON

class UsersController {

	def userService

	def changePassword(){
		def jsonObject = request.JSON
		if(userService.changePassword(jsonObject.email,jsonObject.oldpw,jsonObject.newpw))
			render true as JSON
		else
			response.status = 404;
	}

	def createUser(){
		def jsonObject = request.JSON
		render userService.create(jsonObject) as JSON
	}

	def login(def email, def password){
		render userService.login(email,password) as JSON
	}
}
