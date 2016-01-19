package com.oracle.grailshackathon

import grails.converters.JSON

class ItemsController {
	def items(){
		render Item.findAll().collect{
			[
				ITEM_ID:it.id,
				ITEM_TITLE:it.title,
				ITEM_DESC:it.description,
				ITEM_POST_DATE:it.postDate,
				ITEM_POSTED_BY:it.postedBy,
				ITEM_BOUGHT_BY:it.boughtBy,
				ITEM_PRICE:it.price,
				ITEM_STATUS:it.status
			]
		} as JSON
	}
}
