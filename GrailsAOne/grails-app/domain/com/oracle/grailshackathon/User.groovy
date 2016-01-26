package com.oracle.grailshackathon

import groovy.transform.ToString;

@ToString(includeNames = true, includeFields = true, excludes = "metaClass,class")
class User {

	static constraints = {
		id bindable: true
		password nullable: true
		gravatar nullable: true
	}

	static mapping = {
		table 'USERS'
		id column: 'USER_ID', generator:'sequence', params:[sequence:'USERS_USER_ID_SEQ']
		username column: 'USER_NAME'
		password column: 'USER_PASSWORD'
		email column: 'USER_EMAIL'
		gravatar column: 'USER_GRAVATAR'
		version false
	}

	String username
	String password
	String email
	String gravatar
}
