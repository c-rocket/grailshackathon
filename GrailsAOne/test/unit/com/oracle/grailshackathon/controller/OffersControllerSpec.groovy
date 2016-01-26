package com.oracle.grailshackathon.controller

import com.oracle.grailshackathon.Item;
import com.oracle.grailshackathon.ItemsController;
import com.oracle.grailshackathon.OfferService;
import com.oracle.grailshackathon.OffersController;

import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(OffersController)
@Mock(OfferService)
class OffersControllerSpec extends Specification {

	def setup() {
	}

	def cleanup() {
	}

	void "test find offers for item"() {
		when:
		def offers = [["hi":"bye"]]
		def mock = [findOffersForItem: {itemId-> return offers }] as OfferService
		controller.offerService = mock
		controller.params.id = 5
		controller.getOffers()

		then:
		response.text == '[{"hi":"bye"}]'
	}

	void "test update offer"() {
		when:
		def offer = ["hi":"bye"]
		def mock = [update: {id,obj-> return offer}] as OfferService
		controller.offerService = mock
		controller.params.id = 5
		controller.updateOffer()

		then:
		response.text == '{"hi":"bye"}'
	}

	void "test create offers"() {
		when:
		def offer = ["hi":"bye"]
		def mock = [create: {id-> return offer}] as OfferService
		controller.offerService = mock
		controller.newOffer()

		then:
		response.text == '{"hi":"bye"}'
	}
}
