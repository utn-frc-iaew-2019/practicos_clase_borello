# Practico SSL

En vez de utilizar keytool y tomcat, hice un trabajo similar con OpenSSL y NGINX.

+ Cree un certificado y una key firmados por mi y las almacene dentro del directorio openssl (cert.pem y key.pem)

  + PEM Passphrase: agustin

`openssl req -x509 -newkey rsa:4096 -keyout key.pem -out cert.pem -days 365`

+ Cree una configuracion de nginx para que sirva un archivo index.html a traves de https utilizando el certificado que cree previamente.

  + nginx/nginx.conf
  
A partir de esto puedo levantar un servidor NGINX que sirve un archivo estatico (nginx/data/index.html) a traves de https

`nginx -c {direccion dell archivo nginx.conf}`
