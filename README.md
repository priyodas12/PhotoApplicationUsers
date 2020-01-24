# PhotoApplicationUsers
Manages Post(Create) service,further implementaion will be going on.


End Point:

http://desktop-ua0ru22:8071/user-ws/users/

Request Body:
{
	"username":"priyodas13",
	"password":"abcgh676jkjf",
	"email":"priyodas1273@gmail.com"
}

Response Body:
{
    "username": "priyodas13",
    "userid": "cd027844-baf4-4f0b-980d-132e00ab7267",
    "email": "priyodas1273@gmail.com"
}

DB Details:

ID  	  EMAIL  	                                 ENCRYPTEDPASSWORD  	                                    USERID                USERNAME  
1	priyodas12@gmail.com	  $2a$10$14n1CrlvEmvRLlEq0cuIDeuIktX0RUwKwRMWH4OREAOuhXOwY0XoS	e21e710f-8947-4cbb-bfaa-1a1439092bdb	priyodas12
4	priyodas1273@gmail.com	$2a$10$6.I6f3z/nTB.CeOHVTLoguxyFSE7tcEHlmurLb.oSyhVoH9XZXhvW	cd027844-baf4-4f0b-980d-132e00ab7267	priyodas13
