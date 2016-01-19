package step02_db_and_api

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
		response.text == '[{"id":5,"postedBy":2,"title":"test title","postDate":null,"price":15,"boughtBy":1,"status":"CLOSED","description":"DESCRIPTION"}]'
	}
}
