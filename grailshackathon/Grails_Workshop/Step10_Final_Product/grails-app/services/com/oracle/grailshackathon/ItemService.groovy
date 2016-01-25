package com.oracle.grailshackathon

import grails.transaction.Transactional

@Transactional
class ItemService {

	def findAll() {
		Item.findAll().collect{
			[
				ITEM_ID:it.id,
				ITEM_TITLE:it.title,
				ITEM_DESC:it.description,
				ITEM_POST_DATE:it.postDate,
				ITEM_POSTED_BY:it.postedBy?.id,
				ITEM_BOUGHT_BY:it.boughtBy?.id,
				ITEM_PRICE:it.price,
				ITEM_STATUS:it.status,
				USER_GRAVATAR:it.postedBy?.gravatar
			]
		}
	}

	def findById(def id){
		def item =  Item.findById(id)
		[
			ITEM_ID:item.id,
			ITEM_TITLE:item.title,
			ITEM_DESC:item.description,
			ITEM_POST_DATE:item.postDate,
			ITEM_POSTED_BY:item.postedBy?.id,
			ITEM_BOUGHT_BY:item.boughtBy?.id,
			ITEM_PRICE:item.price,
			ITEM_STATUS:item.status,
			USER_GRAVATAR:it.postedBy?.gravatar
		]
	}

	def create(def jsonObject){
		def postedBy = User.findById(jsonObject.p3)
		def item = new Item(title:jsonObject.p1,description:jsonObject.p2,postedBy:postedBy,status:jsonObject.p4,price:jsonObject.p5);
		item.save(flush: true)
		[
			ITEM_ID:item.id,
			ITEM_TITLE:item.title,
			ITEM_DESC:item.description,
			ITEM_POST_DATE:item.postDate,
			ITEM_POSTED_BY:item.postedBy?.id,
			ITEM_BOUGHT_BY:item.boughtBy?.id,
			ITEM_PRICE:item.price,
			ITEM_STATUS:item.status,
			USER_GRAVATAR:item.postedBy?.gravatar
		]
	}

	def update(def id, def jsonObject){
		def purchasedBy = User.findById(jsonObject.p3)
		def item = Item.findById(id)
		item.title = jsonObject.p1
		item.descrition = jsonObject.p2
		item.status = jsonObject.p5
		item.price = jsonObject.p4
		item.boughtBy = purchasedBy
		item.save(flush: true)
		[
			ITEM_ID:item.id,
			ITEM_TITLE:item.title,
			ITEM_DESC:item.description,
			ITEM_POST_DATE:item.postDate,
			ITEM_POSTED_BY:item.postedBy?.id,
			ITEM_BOUGHT_BY:item.boughtBy?.id,
			ITEM_PRICE:item.price,
			ITEM_STATUS:item.status,
			USER_GRAVATAR:item.postedBy?.gravatar
		]
	}

	def delete(def id){
		def item = Item.findById(id)
		if(item){
			item.delete
			return true
		}else{
			return false
		}
	}
}
