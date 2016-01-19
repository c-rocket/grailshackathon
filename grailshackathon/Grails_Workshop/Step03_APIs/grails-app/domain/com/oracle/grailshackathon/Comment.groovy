package com.oracle.grailshackathon

import groovy.transform.ToString;

@ToString(includeNames = true, includeFields = true, excludes = "metaClass,class")
class Comment {

	static constraints = { id bindable: true }

	static mapping = {
		table 'COMMENTS'
		id column: 'COMMENT_ID', generator:'sequence', params:[sequence:'COMMENTS_COMMENT_ID_SEQ']
		itemId column: 'ITEM_ID'
		commentBy column: 'COMMENT_BY'
		createDate column: 'COMMENT_CREATE_DATE'
		text column: 'COMMENT_TEXT'
	}

	Integer itemId
	String text
	Date createDate
	Integer commentBy
}
