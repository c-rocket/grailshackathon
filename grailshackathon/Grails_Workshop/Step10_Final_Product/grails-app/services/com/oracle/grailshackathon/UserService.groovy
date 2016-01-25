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
			if(user && encoder.matches(oldpw, user.password)){
				user.password = newHash
				user.save(flush: true)
				return true
			}
		}catch (Exception e){
			e.printStackTrace()
		}
		return false
	}

	def login(def email, def password){
		StandardPasswordEncoder encoder = new StandardPasswordEncoder(KEY);
		def user = User.findByEmail(email)
		try {
			if (user && encoder.matches(password, user.password)) {
				return [
					USER_ID:user.id,
					USER_NAME:user.username,
					USER_PASSWORD:user.password,
					USER_EMAIL:user.email,
					USER_GRAVATAR:user.gravatar
				]
			}
		} catch (Exception e) {
			e.printStackTrace()
		}
		return null;
	}

	def create(def jsonObject){
		StandardPasswordEncoder encoder = new StandardPasswordEncoder(KEY);
		String hash = encoder.encode(jsonObject.pw);
		String gravatar = Gravatar.url(jsonObject.email);

		def user = new User(username:jsonObject.username,email:jsonObject.email,password:hash, gravatar: gravatar);
		user.save(flush: true)
		[
			USER_ID:user.id,
			USER_NAME:user.username,
			USER_PASSWORD:user.password,
			USER_EMAIL:user.email,
			USER_GRAVATAR:user.gravatar
		]
	}
}
