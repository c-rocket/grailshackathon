package com.oracle.grailshackathon

import grails.transaction.Transactional

@Transactional
class OfferService {

	def findOffersForItem(def itemId) {
		def item = Item.findById(itemId)
		Offer.findAllByItem(item).collect{
			[
				OFFER_ID:it.id,
				ITEM_ID:it.item?.id,
				OFFER_BY:it.offerBy?.id,
				OFFER_AMOUNT:it.amount,
				OFFER_CREATE_DATE:it.createDate,
				OFFER_STATUS:it.status
			]
		}
	}
	
	def update(def id, def jsonObject){
		def offer = Offer.findById(id)
		offer.status = jsonObject.p1
		offer.save(flush: true,failOnError: true)
		[
			OFFER_ID:it.id,
			ITEM_ID:it.item?.id,
			OFFER_BY:it.offerBy?.id,
			OFFER_AMOUNT:it.amount,
			OFFER_CREATE_DATE:it.createDate,
			OFFER_STATUS:it.status
		]
	}

	def create(def jsonObject){
		def item = Item.findById(jsonObject.p1)
		def offerBy = User.findById(jsonObject.p2)
		def offer = new Offer(item:item,offerBy:offerBy,amount:jsonObject.p3);
		offer.save(flush: true,failOnError: true)
		[
			OFFER_ID:offer.id,
			ITEM_ID:offer.item?.id,
			OFFER_BY:offer.offerBy?.id,
			OFFER_AMOUNT:offer.amount,
			OFFER_CREATE_DATE:offer.createDate,
			OFFER_STATUS:offer.status
		]
	}
}
