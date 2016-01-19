package com.oracle.grailshackathon

import groovy.transform.ToString;

@ToString(includeNames = true, includeFields = true, excludes = "metaClass,class")
class Offer {

	static constraints = { id bindable: true }

	static mapping = {
		table 'OFFERS'
		id column: 'OFFER_ID', generator:'sequence', params:[sequence:'OFFERS_OFFER_ID_SEQ']
		itemId column: 'ITEM_ID'
		offerBy column: 'OFFER_BY'
		amount column: 'OFFER_AMOUNT'
		createDate column: 'OFFER_CREATE_DATE'
		status column: 'OFFER_STATUS'
	}

	Integer itemId
	Integer offerBy
	Integer amount
	String status
	Date createDate
}
