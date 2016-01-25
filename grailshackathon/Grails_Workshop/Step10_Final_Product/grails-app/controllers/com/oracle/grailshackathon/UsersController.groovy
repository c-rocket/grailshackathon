package com.oracle.grailshackathon

import grails.converters.JSON

class UsersController {

	def userService

	def changePassword(){
		def jsonObject = request.JSON
		if(userService.changePassword(jsonObject.email,jsonObject.oldpw,jsonObject.newpw))
			render true
		else
			response.status = 404;
	}

	def createUser(){
		def jsonObject = request.JSON
		render userService.create(jsonObject) as JSON
	}

	def login(){
		render userService.login(params.email,params.password) as JSON
	}
}
