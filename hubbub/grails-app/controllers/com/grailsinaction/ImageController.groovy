package com.grailsinaction


class PhotoUploadCommand {
	byte[] photo
	String loginId
}

class ImageController {

   def upload(PhotoUploadCommand puc) {
	   def user = User.findByLoginId(puc.loginId)
	   user.profile.photo = puc.photo
	   redirect controller: "user", action: "profile", id: puc.loginId
   }
   
   def form() {
	   [userList : User.list()]
   }
}
