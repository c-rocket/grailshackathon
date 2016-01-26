package com.oracle.grailshackathon

import grails.transaction.Transactional

@Transactional
class CommentService {

	def findCommentsForItem(def itemId) {
		def item = Item.findById(itemId)
		Comment.findAllByItem(item).collect{
			[
				COMMENT_ID:it.id,
				ITEM_ID:it.item?.id,
				COMMENT_BY:it.commentBy?.id,
				COMMENT_CREATE_DATE:it.createDate,
				COMMENT_TEXT:it.text,
				USER_NAME:it.commentBy?.username,
				USER_GRAVATAR:it.commentBy?.gravatar
			]
		}
	}

	def create(def jsonObject){
		def commentBy = User.findById(jsonObject.p2)
		def item = Item.findById(jsonObject.p1)
		def comment = new Comment(item:item,commentBy:commentBy,text:jsonObject.p3, createDate:new Date());
		comment.save(flush: true,failOnError: true)
		[
			COMMENT_ID:comment?.id,
			ITEM_ID:comment.item?.id,
			COMMENT_BY:comment.commentBy?.id,
			COMMENT_CREATE_DATE:comment.createDate,
			COMMENT_TEXT:comment.text,
			USER_NAME:comment.commentBy?.username,
			USER_GRAVATAR:comment.commentBy?.gravatar
		]
	}
}
