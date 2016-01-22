package com.oracle.grailshackathon

import grails.transaction.Transactional

@Transactional
class CommentService {

	def findCommentsForItem(def itemId) {
		Comment.findAllByItemId(itemId).collect{
			[
				COMMENT_ID:it.id,
				ITEM_ID:it.itemId,
				COMMENT_BY:it.commentBy,
				COMMENT_CREATE_DATE:it.createDate,
				COMMENT_TEXT:it.text
			]
		}
	}

	def create(def jsonObject){
		def comment = new Comment(itemId:jsonObject.p1,postedBy:jsonObject.p2,text:jsonObject.p3);
		comment.save()
		[
			COMMENT_ID:comment.id,
			ITEM_ID:comment.itemId,
			COMMENT_BY:comment.commentBy,
			COMMENT_CREATE_DATE:comment.createDate,
			COMMENT_TEXT:comment.text
		]
	}
}
