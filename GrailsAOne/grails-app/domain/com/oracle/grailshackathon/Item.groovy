package com.oracle.grailshackathon

import groovy.transform.ToString;

@ToString(includeNames = true, includeFields = true, excludes = "metaClass,class")
class Item {

	static constraints = {
		id bindable: true
		postedBy nullable: true
		boughtBy nullable: true
		status nullable: true
	}

	static hasMany = [
		offers : Offer,
		comments : Comment
	]

	static belongsTo = [
		postedBy:User
	]

	static mapping = {
		table 'ITEMS'
		id column: 'ITEM_ID', generator:'sequence', params:[sequence:'ITEMS_ITEM_ID_SEQ']
		title column: 'ITEM_TITLE'
		description column: 'ITEM_DESC'
		postDate column: 'ITEM_POST_DATE'
		postedBy column: 'ITEM_POSTED_BY'
		boughtBy column: 'ITEM_BOUGHT_BY'
		price column: 'ITEM_PRICE'
		status column: 'ITEM_STATUS'
		version false
	}

	User boughtBy
	String title
	String description
	Date postDate
	Integer price
	String status
}
