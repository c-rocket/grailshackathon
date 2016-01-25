package com.oracle.grailshackathon

import grails.converters.JSON

class ItemsController {

	def itemService

	def getItems(){
		render itemService.findAll() as JSON
	}
	
	def getItem(def id){
		render itemService.findById(id) as JSON
	}

	def deleteItem(def id){
		render itemService.delete(id)
	}

	def createItem(){
		def jsonObject = request.JSON
		render itemService.create(jsonObject) as JSON
	}
	
	def updateItem(def id){
		def jsonObject = request.JSON
		render itemService.update(id,jsonObject) as JSON
	}
}
