package com.oracle.grailshackathon

import grails.transaction.Transactional

@Transactional
class OfferService {

	def findOffersForItem(def itemId) {
		Offer.findAllByItemId(itemId).collect{
			[
				OFFER_ID:it.id,
				ITEM_ID:it.itemId,
				OFFER_BY:it.offerBy,
				OFFER_AMOUNT:it.amount,
				OFFER_CREATE_DATE:it.createDate,
				OFFER_STATUS:it.status
			]
		}
	}
	
	def update(def id, def jsonObject){
		def offer = new Offer(itemId:jsonObject.p1,offerBy:jsonObject.p2,amount:jsonObject.p3);
		offer.save()
		[
			OFFER_ID:it.id,
			ITEM_ID:it.itemId,
			OFFER_BY:it.offerBy,
			OFFER_AMOUNT:it.amount,
			OFFER_CREATE_DATE:it.createDate,
			OFFER_STATUS:it.status
		]
	}

	def create(def jsonObject){
		def offer = new Offer(itemId:jsonObject.p1,offerBy:jsonObject.p2,amount:jsonObject.p3);
		offer.save()
		[
			OFFER_ID:it.id,
			ITEM_ID:it.itemId,
			OFFER_BY:it.offerBy,
			OFFER_AMOUNT:it.amount,
			OFFER_CREATE_DATE:it.createDate,
			OFFER_STATUS:it.status
		]
	}
}
