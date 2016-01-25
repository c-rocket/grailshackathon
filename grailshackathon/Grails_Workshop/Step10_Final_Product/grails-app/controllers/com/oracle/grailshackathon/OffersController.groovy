package com.oracle.grailshackathon

import grails.converters.JSON

class OffersController {

	def offerService

	def getOffers(){
		render offerService.findOffersForItem(params.id) as JSON
	}
	
	def updateOffer(){
		def jsonObject = request.JSON
		render offerService.update(params.id,jsonObject) as JSON
	}
	
	def newOffer(){
		def jsonObject = request.JSON
		render offerService.create(jsonObject) as JSON
	}
}
