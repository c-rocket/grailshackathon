package com.oracle.grailshackathon

import grails.transaction.Transactional
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Transactional
class UserService {

	static final def KEY = "SuperSecretKey"

	def changePassword(def email, def oldpw, def newpw){
		StandardPasswordEncoder encoder = new StandardPasswordEncoder(KEY)
		String newHash = encoder.encode(newpw)
		def user = User.findByEmail(email)

		try{
			if(encoder.matches(oldpw, user.email)){
				user.email = email
				user.password = newHash
				user.save()
				return true
			}
		}catch (Exception e){
			e.printStackTrace()
		}
		return false
	}

	def login(def email, def password){
		StandardPasswordEncoder encoder = new StandardPasswordEncoder(KEY);
		def user = User.findByEmail(email);
		try {
			if (user && encoder.matches(password, user.password)) {
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace()
		}
		return null;
	}

	def create(def jsonObject){
		StandardPasswordEncoder encoder = new StandardPasswordEncoder(KEY);
		String hash = encoder.encode(jsonObject.password);
		String gravatar = Gravatar.url(jsonObject.email);

		def user = new User(username:jsonObject.username,email:jsonObject.email,password:hash, gravatar: gravatar);
		user.save()
		[
			OFFER_ID:it.id,
			USER_NAME:it.username,
			USER_PASSWORD:it.password,
			USER_EMAIL:it.email,
			USER_GRAVATAR:it.gravatar
		]
	}
}
