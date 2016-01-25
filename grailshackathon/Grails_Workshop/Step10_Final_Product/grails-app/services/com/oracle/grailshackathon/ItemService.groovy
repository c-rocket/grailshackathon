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
				ITEM_POSTED_BY:it.postedBy,
				ITEM_BOUGHT_BY:it.boughtBy,
				ITEM_PRICE:it.price,
				ITEM_STATUS:it.status
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
			ITEM_POSTED_BY:item.postedBy,
			ITEM_BOUGHT_BY:item.boughtBy,
			ITEM_PRICE:item.price,
			ITEM_STATUS:item.status
		]
	}
	
	def create(def jsonObject){
		def item = new Item(title:jsonObject.p1,description:jsonObject.p2,postedBy:jsonObject.p3,status:jsonObject.p4,price:jsonObject.p5);
		item.save()
		[
			ITEM_ID:item.id,
			ITEM_TITLE:item.title,
			ITEM_DESC:item.description,
			ITEM_POST_DATE:item.postDate,
			ITEM_POSTED_BY:item.postedBy,
			ITEM_BOUGHT_BY:item.boughtBy,
			ITEM_PRICE:item.price,
			ITEM_STATUS:item.status
		]
	}
	
	def update(def id, def jsonObject){
		def item = Item.findById(id)
		item.title = jsonObject.p1
		item.descrition = jsonObject.p2
		item.status = jsonObject.p5
		item.price = jsonObject.p4
		item.purchasedBy = jsonObject.p3
		item.save()
		[
			ITEM_ID:item.id,
			ITEM_TITLE:item.title,
			ITEM_DESC:item.description,
			ITEM_POST_DATE:item.postDate,
			ITEM_POSTED_BY:item.postedBy,
			ITEM_BOUGHT_BY:item.boughtBy,
			ITEM_PRICE:item.price,
			ITEM_STATUS:item.status
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
