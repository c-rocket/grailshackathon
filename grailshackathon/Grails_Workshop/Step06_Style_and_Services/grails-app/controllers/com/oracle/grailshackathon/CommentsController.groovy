package com.oracle.grailshackathon

import grails.converters.JSON

class CommentsController {

	def commentService

	def getComments(def itemId){
		render commentService.findCommentsForItem(itemId) as JSON
	}
	
	def newComment(){
		def jsonObject = request.JSON
		render commentService.create(jsonObject) as JSON
	}
}
