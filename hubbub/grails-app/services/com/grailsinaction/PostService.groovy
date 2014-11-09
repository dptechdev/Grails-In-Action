package com.grailsinaction

import grails.transaction.Transactional

class PostException extends RuntimeException {
	String message
	Post post
}

@Transactional
class PostService {

	Post createPost(String loginId, String content) {
		def user = User.findByLoginId(loginId)
		if (user) {
			def post = new Post(content: content)
			user.addToPosts(post)
			if (post.validate() && user.save()) {
				return post
				println "Post Service - create post - [SUCCESS]"
			} else {
				println "testing error [POSTSERVICE]\n"
			}
		}
	}

	def update() {
		def user = session.user?.attach()
		if (user) {
			user.properties = params
			if (user.save()) {
				flash.message = "Successfully updated user"
			} else {
				flash.message = "Failed to update user"
			}
			[user : user]
		} else {
			response.sendError(404)
		}
	}
}