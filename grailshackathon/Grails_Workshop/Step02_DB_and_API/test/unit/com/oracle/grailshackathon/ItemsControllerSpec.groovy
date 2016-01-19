package com.oracle.grailshackathon

import com.oracle.grailshackathon.Item;
import com.oracle.grailshackathon.ItemsController;

import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(ItemsController)
@Mock(Item)
class ItemsControllerSpec extends Specification {

	def setup() {
	}

	def cleanup() {
	}

	void "test hello"() {
		when:
		def items = [new Item(id:5,title:'test title',boughtBy:1,description:'DESCRIPTION',postedBy:2,price:15,status:'CLOSED')]
		Item.metaClass.static.findAll = { -> items};
		controller.items()

		then:
		response.text == '[{"ITEM_ID":5,"ITEM_TITLE":"test title","ITEM_DESC":"DESCRIPTION","ITEM_POST_DATE":null,"ITEM_POSTED_BY":2,"ITEM_BOUGHT_BY":1,"ITEM_PRICE":15,"ITEM_STATUS":"CLOSED"}]'
	}
}
