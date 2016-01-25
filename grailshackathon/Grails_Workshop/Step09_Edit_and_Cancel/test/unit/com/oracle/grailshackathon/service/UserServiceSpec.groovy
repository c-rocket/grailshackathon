package com.oracle.grailshackathon.service

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.domain.DomainClassUnitTestMixin

import org.springframework.security.crypto.password.StandardPasswordEncoder

import spock.lang.Specification

import com.oracle.grailshackathon.User
import com.oracle.grailshackathon.UserService

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(UserService)
@Mock([User])
@TestMixin(DomainClassUnitTestMixin)
class UserServiceSpec extends Specification {

	def setup() {
	}

	def cleanup() {
	}

	void "test change password - valid"() {
		when:
		StandardPasswordEncoder encoder = new StandardPasswordEncoder(UserService.KEY)
		String email = "Test.user@oracle.com"
		String oldpw = "hi"
		String newpw = "bye"

		String oldHash = encoder.encode(oldpw)

		def user = new User(password:oldHash,email:email)
		User.metaClass.'static'.findByEmail = {em->return user}

		// execute
		def changed = service.changePassword(email, oldpw, newpw)

		then:
		changed == true
	}

	void "test change password - invalid"() {
		when:
		StandardPasswordEncoder encoder = new StandardPasswordEncoder(UserService.KEY)
		String email = "Test.user@oracle.com"
		String oldpw = "hi"
		String newpw = "bye"

		String oldHash = encoder.encode("some weird hash")

		def user = new User(password:oldHash,email:email)
		User.metaClass.'static'.findByEmail = {em->return user}

		// execute
		def changed = service.changePassword(email, oldpw, newpw)

		then:
		changed == false
	}

	void "test login - valid"() {
		when:
		StandardPasswordEncoder encoder = new StandardPasswordEncoder(UserService.KEY)
		String email = "Test.user@oracle.com"
		String password = "hi"

		String passwordHash = encoder.encode(password)

		def user = new User(password:passwordHash,email:email)
		User.metaClass.'static'.findByEmail = {em->return user}

		// execute
		def validUser = service.login(email, password)

		then:
		validUser == [USER_ID:null, USER_NAME:null, USER_PASSWORD:passwordHash, USER_EMAIL:email, USER_GRAVATAR:null]
	}

	void "test login - invalid"() {
		when:
		StandardPasswordEncoder encoder = new StandardPasswordEncoder(UserService.KEY)
		String email = "Test.user@oracle.com"
		String password = "hi"

		String passwordHash = encoder.encode("some weird hash")

		def user = new User(password:passwordHash,email:email)
		User.metaClass.'static'.findByEmail = {em->return user}

		// execute
		def validUser = service.login(email, password)

		then:
		validUser == null
	}
}
