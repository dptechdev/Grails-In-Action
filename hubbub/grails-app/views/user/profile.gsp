<html>
<body>
	<div class="profilePic">
		<g:if test="${profile.photo}">
			<img
				src="${createLink(controller: 'image', action: 'renderImage', id: profile.user.loginId)}" />
		</g:if>
		<p>
			Profile for <strong>
				${profile.fullName}
			</strong>
		</p>
		<p>
			Bio:
			${profile.bio}
		</p>
	</div>
</body>
</html>