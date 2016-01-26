package com.oracle.grailshackathon

import grails.converters.JSON

class ItemsController {

	def itemService

	def getItems(){
		render itemService.findAll() as JSON
	}
	
	def getItem(){
		render itemService.findById(params.id) as JSON
	}

	def deleteItem(){
		render itemService.delete(params.id)
	}

	def createItem(){
		def jsonObject = request.JSON
		render itemService.create(jsonObject) as JSON
	}
	
	def updateItem(){
		def jsonObject = request.JSON
		render itemService.update(params.id,jsonObject) as JSON
	}
}
