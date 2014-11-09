package com.grailsinaction

import grails.rest.RestfulController

class PostRestController extends RestfulController{
	static responseFormats = ["json", "xml"]

	PostRestController() {
		super(Post)
	}
}
