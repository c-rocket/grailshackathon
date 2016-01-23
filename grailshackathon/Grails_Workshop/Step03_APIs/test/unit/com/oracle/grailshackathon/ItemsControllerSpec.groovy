package com.oracle.grailshackathon

import com.oracle.grailshackathon.Item;
import com.oracle.grailshackathon.ItemsController;

import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(ItemsController)
@Mock(ItemService)
class ItemsControllerSpec extends Specification {

	def setup() {
	}

	def cleanup() {
	}

	void "test get items"() {
		when: 
		def items = [["hi":"bye"]]
		def mock = [findAll: {-> return items }] as ItemService
		controller.itemService = mock
		controller.getItems()

		then:
		response.text == '[{"hi":"bye"}]'
	}
}
