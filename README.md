# sssh
simple springboot app with a terribly written alphabet cipher

build: 
`docker build -t sssh .`

run:
`docker run -p 8080:8080 sssh:latest`

"encrypt":
`localhost:8080/encrypt?message=yourmessage&secret=yoursecret`

"decrypt":
`http://localhost:8080/decrypt?message=wcoieiujezc&secret=yoursecret`
