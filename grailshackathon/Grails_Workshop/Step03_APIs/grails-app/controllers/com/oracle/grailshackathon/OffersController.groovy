package com.oracle.grailshackathon

import grails.converters.JSON

class OffersController {

	def offerService

	def getOffers(def id){
		render offerService.findOffersForItem(id) as JSON
	}
	
	def updateOffers(def id){
		render offerService.update(id) as JSON
	}
	
	def newOffer(def id){
		def jsonObject = request.JSON
		render offerService.create(jsonObject) as JSON
	}
}
