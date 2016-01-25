package com.oracle.grailshackathon

import grails.test.spock.IntegrationSpec
import grails.transaction.Rollback
import spock.lang.IgnoreRest

@Rollback
class CommentServiceIntegrationSpec extends IntegrationSpec {

	def commentService
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

	void "Test Find Comments for Item"() {
		when:
		def json = [
			p1:itemId,
			p2:userId,
			p3:"Comment Text"
		]
		commentService.create(json)
		def comments = commentService.findCommentsForItem(itemId)

		then:
		comments.size() == 1
		comments.ITEM_ID == itemId
		comments.COMMENT_BY == userId
		comments.COMMENT_CREATE_DATE != null
		comments.COMMENT_TEXT == "Comment Text"
		comments.USER_NAME == "test user"
		comments.GRAVATAR != null
	}
}
