package com.oracle.grailshackathon

import grails.test.spock.IntegrationSpec
import grails.transaction.Rollback
import spock.lang.IgnoreRest

@Rollback
class CommentServiceIntegrationSpec extends IntegrationSpec {

	def commentService
	def userService
	def itemService

	def setup() {
		
	}

	def cleanup() {
	}

	void "Test Find Comments for Item"() {
		when:
		def userJson = [
			username:"test user",
			email:"test@user.com",
			pw:"12345"
		]
		def savedUser = userService.create(userJson)
		def userId = savedUser.USER_ID

		def itemJson = [
			p1:"Test Item",
			p2:"test@user.com",
			p3:userId,
			p4:"OPEN",
			p5:15
		]
		def savedItem = itemService.create(itemJson)
		def itemId = savedItem.ITEM_ID
		def json = [
			p1:itemId,
			p2:userId,
			p3:"Comment Text"
		]
		commentService.create(json)
		def comments = commentService.findCommentsForItem(itemId)

		then:
		comments.size() == 1
		def comment = comments.getAt(0)
		comment.ITEM_ID  == itemId 
		comment.COMMENT_BY  == userId 
		comment.COMMENT_CREATE_DATE != null
		comment.COMMENT_TEXT == "Comment Text"
		comment.USER_NAME == "test user"
		comment.USER_GRAVATAR != null
	}
}
