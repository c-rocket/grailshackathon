package com.oracle.grailshackathon

import groovy.transform.ToString;

@ToString(includeNames = true, includeFields = true, excludes = "metaClass,class")
class Comment {

	static constraints = { id bindable: true }

	static belongsTo = [
		item:Item,
		commentBy: User
	]
	
	static mapping = {
		table 'COMMENTS'
		id column: 'COMMENT_ID', generator:'sequence', params:[sequence:'COMMENTS_COMMENT_ID_SEQ']
		item column: 'ITEM_ID'
		commentBy column: 'COMMENT_BY'
		createDate column: 'COMMENT_CREATE_DATE'
		text column: 'COMMENT_TEXT'
		version false
	}
	
	String text
	Date createDate
}
