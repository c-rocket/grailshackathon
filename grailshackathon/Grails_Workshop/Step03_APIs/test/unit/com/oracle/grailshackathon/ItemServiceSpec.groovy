package com.oracle.grailshackathon

import com.oracle.grailshackathon.ItemService;

import grails.test.mixin.TestFor
import grails.test.mixin.domain.DomainClassUnitTestMixin;
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(ItemService)
@Mock([Item])
@TestMixin(DomainClassUnitTestMixin)
class ItemServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test formating of item returned for find all"() {
		when:
		def items = [new Item(id:5,title:"test title",boughtBy:1,description:"DESCRIPTION",postedBy:2,price:15,status:"CLOSED")]
		Item.metaClass.'static'.findAll = {->return items}
		def all = service.findAll()
		
		then:
		all == [[
				ITEM_ID:5,
				ITEM_TITLE:"test ttile",
				ITEM_DESC:"DESCRIPTION",
				ITEM_POST_DATE:null,
				ITEM_POSTED_BY:2,
				ITEM_BOUGHT_BY:1,
				ITEM_PRICE:15,
				ITEM_STATUS:"CLOSED"
			]]
    }
}
