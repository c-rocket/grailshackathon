package com.oracle.grailshackathon

import grails.converters.JSON

class CommentsController {

	def commentService

	def getComments(){
		render commentService.findCommentsForItem(params.itemId) as JSON
	}
	
	def newComment(){
		def jsonObject = request.JSON
		render commentService.create(jsonObject) as JSON
	}
}
