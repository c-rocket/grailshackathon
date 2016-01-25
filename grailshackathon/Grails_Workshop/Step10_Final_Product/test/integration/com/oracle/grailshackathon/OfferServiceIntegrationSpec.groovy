package com.oracle.grailshackathon

import grails.test.spock.IntegrationSpec
import grails.transaction.Rollback
import spock.lang.IgnoreRest

@Rollback
class OfferServiceIntegrationSpec extends IntegrationSpec {

	def offerService
	def userService
	def itemService

	def userId
	def itemId

	def setup() {
		def userJson = [
			username:"test user",
			email:"test@user.com",
			pw:"12345"
		]
		userId = userService.create(userJson).USER_ID

		def itemJson = [
			p1:"Test Item",
			p2:"test@user.com",
			p3:userId,
			p4:"OPEN",
			p5:15
		]
		itemId = itemService.create(itemJson).ITEM_ID
	}

	def cleanup() {
	}

	void "Test Find Offer for Item"() {
		when:
		def json = [
			p1:itemId,
			p2:userId,
			p3:10
		]
		offerService.create(json)
		def offers = offerService.findOffersForItem(itemId)

		then:
		offers.size() == 1
		offers.ITEM_ID == itemId
		offers.OFFER_BY == userId
		offers.OFFER_AMOUNT != null
		offers.OFFER_STATUS == "OPEN"
	}
}
