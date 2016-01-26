package com.oracle.grailshackathon

import groovy.transform.ToString;

@ToString(includeNames = true, includeFields = true, excludes = "metaClass,class")
class Offer {

	static constraints = {
		id bindable: true
		createDate nullable:true
		status nullable:true
	}

	static belongsTo = [
		item:Item,
		offerBy: User
	]

	static mapping = {
		table 'OFFERS'
		id column: 'OFFER_ID', generator:'sequence', params:[sequence:'OFFERS_OFFER_ID_SEQ']
		item column: 'ITEM_ID'
		offerBy column: 'OFFER_BY'
		amount column: 'OFFER_AMOUNT'
		createDate column: 'OFFER_CREATE_DATE'
		status column: 'OFFER_STATUS'
		version false
	}

	Integer amount
	String status
	Date createDate
}
