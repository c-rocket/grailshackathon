package com.oracle.grailshackathon

import grails.converters.JSON

class OffersController {

	def offerService

	def getOffers(def id){
		render offerService.findOffersForItem(id) as JSON
	}
	
	def updateOffer(def id){
		def jsonObject = request.JSON
		render offerService.update(id,jsonObject) as JSON
	}
	
	def newOffer(def id){
		def jsonObject = request.JSON
		render offerService.create(jsonObject) as JSON
	}
}
