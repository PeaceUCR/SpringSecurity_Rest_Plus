# SpringSecurity_Rest_Plus
# This is the Plus version of SpringSecurity_Rest

In the Authentication part from request, it's need HTTP Basic authentication

HTTP Basic authentication implementation is the simplest technique for enforcing access controls to web resources because it doesn't require cookies, session identifier and login pages. Rather, HTTP Basic authentication uses static, standard HTTP headers which means that no handshakes have to be done in anticipation.

When the user agent wants to send the server authentication credentials it may use the Authorization header. The Authorization header is constructed as follows:

1) Username and password are combined into a string "username:password"
2) The resulting string is then encoded using Base64 encoding
3) The authorization method and a space i.e. "Basic " is then put before the encoded string.

For example, if the user agent uses 'Aladdin' as the username and 'open sesame' as the password then the header is formed as follows:

Authorization: Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==

# In the ProductService.JAVA

inject the head value of authentication ,and the http header , you can check the cookie from request

then print the authentication info when used in GET method

# How to Use
Eclipse import as maven project, then run maven clean ,maven install,run on server.

Problems may happens
https://stackoverflow.com/questions/6210757/java-lang-classnotfoundexception-org-springframework-web-context-contextloaderl
