package step02_db_and_api

import grails.converters.JSON

class ItemsController {
	def items(){
		render Item.findAll().collect{
			[
				id:it.id,
				postedBy:it.postedBy,
				title:it.title,
				postDate:it.postDate,
				price:it.price,
				boughtBy:it.boughtBy,
				status:it.status,
				description:it.description,
			]
		} as JSON
	}
}
