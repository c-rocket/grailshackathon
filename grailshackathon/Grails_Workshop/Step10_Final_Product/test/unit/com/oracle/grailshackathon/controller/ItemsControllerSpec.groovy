package com.oracle.grailshackathon.controller

import com.oracle.grailshackathon.Item;
import com.oracle.grailshackathon.ItemService;
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

	void "test get items by id"() {
		when:
		def item = ["hi":"bye"]
		def mock = [findById: {id-> return item}] as ItemService
		controller.itemService = mock
		controller.params.id = 5
		controller.getItem()

		then:
		response.text == '{"hi":"bye"}'
	}
	
	void "test delete item"() {
		when:
		def mock = [delete: {id-> return true}] as ItemService
		controller.itemService = mock
		controller.params.id = 5
		controller.deleteItem()

		then:
		response.text == 'true'
	}
	
	void "test create item"() {
		when:
		def item = ["hi":"bye"]
		def mock = [create: {obj-> return item}] as ItemService
		controller.itemService = mock
		controller.createItem()

		then:
		response.text == '{"hi":"bye"}'
	}
	
	void "test update item"() {
		when:
		def item = ["hi":"bye"]
		def mock = [update: {id,obj-> return item}] as ItemService
		controller.itemService = mock
		controller.params.id = 5
		controller.updateItem()

		then:
		response.text == '{"hi":"bye"}'
	}
}
