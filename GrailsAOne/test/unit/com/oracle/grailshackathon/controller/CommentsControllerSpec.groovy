package com.oracle.grailshackathon.controller

import com.oracle.grailshackathon.CommentService;
import com.oracle.grailshackathon.CommentsController;
import com.oracle.grailshackathon.Item;
import com.oracle.grailshackathon.ItemsController;

import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(CommentsController)
@Mock(CommentService)
class CommentsControllerSpec extends Specification {

	def setup() {
	}

	def cleanup() {
	}

	void "test find comments for item"() {
		when:
		def comments = [["hi":"bye"]]
		def mock = [findCommentsForItem: {itemId-> return comments }] as CommentService
		controller.commentService = mock
		controller.params.itemId = 5
		controller.getComments()

		then:
		response.text == '[{"hi":"bye"}]'
	}

	void "test create comment"() {
		when:
		def comment = ["hi":"bye"]
		def mock = [create: {obj-> return comment}] as CommentService
		controller.commentService = mock
		controller.newComment()

		then:
		response.text == '{"hi":"bye"}'
	}
}
